package com.mmnaseri.utils.tuples.reflection.impl;

import com.mmnaseri.utils.tuples.Tuple;
import com.mmnaseri.utils.tuples.annotations.Metadata;
import com.mmnaseri.utils.tuples.facade.HasFirst;
import com.mmnaseri.utils.tuples.facade.HasSecond;
import com.mmnaseri.utils.tuples.utils.FluentList;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toMap;

/**
 * Utility class for working with proxied objects based on {@link com.mmnaseri.utils.tuples.Tuple}s.
 */
public final class TupleProxyUtils {

  private TupleProxyUtils() {
    throw new IllegalStateException("This type should not be instantiated");
  }

  /** Returns a map of all no-arg method's name to the values returned from the call. */
  public static Map<String, Object> mapOf(Class<?> proxyType, Object proxy) {
    return Arrays.stream(proxyType.getMethods())
        // Filter out all methods defined on the Object class.
        .filter(method -> !method.getDeclaringClass().equals(Object.class))
        // Filter down to non-static, non-void, no-arg methods of the proxy type.
        .filter(
            method ->
                method.getParameterCount() == 0
                    && !void.class.equals(method.getReturnType())
                    && !Modifier.isStatic(method.getModifiers()))
        // Ignore any method that has been annotated with @Metadata.
        .filter(method -> !hasAnnotation(Metadata.class, method))
        // Create a tuple of this method.
        .map(Tuple::of)
        // Extend the tuple by getting the results of the invocation.
        .map(Tuple.extendOne(tuple -> invokeMethod(tuple.first(), proxy)))
        // Map the method to its name.
        .map(tuple -> tuple.first(tuple.first().getName()))
        // Collect the result as a map.
        .collect(toMap(HasFirst::first, HasSecond::second));
  }

  /**
   * Invokes the given method on the provided instance. Any error thrown from this call is wrapped
   * in a {@link RuntimeException}.
   */
  private static Object invokeMethod(Method method, Object instance) {
    try {
      return method.invoke(instance);
    } catch (Exception e) {
      Throwable cause = e instanceof InvocationTargetException ? e.getCause() : e;
      throw new RuntimeException("Could not call method " + method + " on " + instance, cause);
    }
  }

  /** Creates a new instance of the indicated type using the default constructor. */
  public static <E> E instantiate(Class<E> type) {
    try {
      Constructor<E> constructor = type.getDeclaredConstructor();
      constructor.setAccessible(true);
      return constructor.newInstance();
    } catch (Exception e) {
      Throwable cause = e instanceof InvocationTargetException ? e.getCause() : e;
      throw new RuntimeException("Failed to instantiate type " + type, cause);
    }
  }

  /**
   * Determines if the provided element or any of its annotations has been annotated with the
   * indicated annotation.
   */
  public static boolean hasAnnotation(
      Class<? extends Annotation> annotationType, AnnotatedElement element) {
    return getAnnotation(annotationType, element) != null;
  }

  /**
   * If the provided element {@link #hasAnnotation(Class, AnnotatedElement) has been annotated} with
   * the given annotation, returns the annotation definition for that element.
   */
  public static <A extends Annotation> A getAnnotation(
      Class<A> annotationType, AnnotatedElement element) {
    return getAnnotation(annotationType, element, new HashSet<>());
  }

  /**
   * Looks for the provided annotation type on the given element, while maintaining a cache of all
   * elements considered so far, to avoid getting stuck in an infinite loop.
   */
  private static <A extends Annotation> A getAnnotation(
      Class<A> annotationType, AnnotatedElement element, Set<AnnotatedElement> considered) {
    if (considered.contains(element)) {
      return null;
    }
    considered.add(element);
    if (element.isAnnotationPresent(annotationType)) {
      return element.getAnnotation(annotationType);
    }
    FluentList<AnnotatedElement> search =
        FluentList.of(
            Arrays.stream(element.getAnnotations())
                .map(Annotation::annotationType)
                .collect(toList()));
    if (element instanceof Class && !((Class<?>) element).isAnnotation()) {
      if (((Class<?>) element).getSuperclass() != null) {
        search = search.with(((Class<?>) element).getSuperclass());
      }
      if (((Class<?>) element).getInterfaces().length > 0) {
        search = search.with(((Class<?>) element).getInterfaces());
      }
      if (((Class<?>) element).getAnnotatedInterfaces().length > 0) {
        search = search.with(((Class<?>) element).getAnnotatedInterfaces());
      }
    }
    return search.stream()
        .distinct()
        .map(annotation -> getAnnotation(annotationType, annotation, considered))
        .filter(Objects::nonNull)
        .findFirst()
        .orElse(null);
  }
}

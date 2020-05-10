package com.mmnaseri.utils.tuples.reflection.impl;

import com.mmnaseri.utils.tuples.Tuple;
import com.mmnaseri.utils.tuples.annotations.Metadata;
import com.mmnaseri.utils.tuples.facade.HasFirst;
import com.mmnaseri.utils.tuples.facade.HasSecond;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Map;

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
      throw new RuntimeException("Could not call method " + method + " on " + instance, e);
    }
  }

  /**
   * Determines if the provided element or any of its annotations has been annotated with the
   * indicated annotation.
   */
  public static boolean hasAnnotation(
      Class<? extends Annotation> annotationType, AnnotatedElement element) {
    return element.isAnnotationPresent(annotationType)
        || Arrays.stream(element.getDeclaredAnnotations())
            .anyMatch(annotation -> hasAnnotation(annotationType, annotation.annotationType()));
  }

  /**
   * If the provided element {@link #hasAnnotation(Class, AnnotatedElement) has been annotated} with
   * the given annotation, returns the annotation definition for that element.
   */
  public static <A extends Annotation> A getAnnotation(
      Class<A> annotationType, AnnotatedElement element) {
    if (element.isAnnotationPresent(annotationType)) {
      return element.getAnnotation(annotationType);
    }
    return Arrays.stream(element.getAnnotations())
        .map(annotation -> getAnnotation(annotationType, annotation.annotationType()))
        .findFirst()
        .orElse(null);
  }
}

package com.mmnaseri.utils.tuples.reflection.impl;

import com.mmnaseri.utils.tuples.Tuple;
import com.mmnaseri.utils.tuples.annotations.Converted;
import com.mmnaseri.utils.tuples.reflection.MethodInvocation;
import com.mmnaseri.utils.tuples.reflection.TupleInvocationHandler;
import com.mmnaseri.utils.tuples.reflection.type.ElementConverter;
import com.mmnaseri.utils.tuples.reflection.type.ElementConverterRegistry;
import com.mmnaseri.utils.tuples.reflection.type.TypeConverter;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class TupleMethodInvocationHandler implements InvocationHandler {

  private final Class<?> type;
  private final Tuple<?> tuple;
  private final TypeConverter typeConverter;
  private final TupleInvocationHandler handler;

  public TupleMethodInvocationHandler(
      final Class<?> type,
      final Tuple<?> tuple,
      final TypeConverter typeConverter,
      final TupleInvocationHandler handler) {
    this.type = type;
    this.tuple = tuple;
    this.typeConverter = typeConverter;
    this.handler = handler;
  }

  @Override
  public Object invoke(final Object proxy, final Method method, final Object[] args)
      throws Throwable {
    // Create an invocation based on this method call.
    MethodInvocation invocation = new ImmutableMethodInvocation(proxy, args, method, type);
    Object result = handler.handle(tuple, invocation);
    if (result == null) {
      return null;
    }
    if (method.getReturnType().isAssignableFrom(result.getClass())) {
      return result;
    }
    return convertResult(method, result);
  }

  private Object convertResult(final Method method, final Object result) {
    if (TupleProxyUtils.hasAnnotation(Converted.class, method)) {
      return returnStaticallyConvertedObject(method, result);
    }
    if (!typeConverter.supportsConversion(method.getReturnType(), result)) {
      throw new IllegalStateException(
          "Cannot convert " + result + " into the desired type: " + method.getReturnType());
    }
    return typeConverter.convert(method.getReturnType(), result);
  }

  private Object returnStaticallyConvertedObject(final Method method, final Object result) {
    Converted converted = TupleProxyUtils.getAnnotation(Converted.class, method);
    Class<? extends ElementConverter<?>> converterType = converted.value();
    ElementConverter<?> converter = ElementConverterRegistry.defaultRegistry().get(converterType);
    return converter.convert(method.getGenericReturnType(), result);
  }
}

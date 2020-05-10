package com.mmnaseri.utils.tuples.reflection.impl;

import com.mmnaseri.utils.tuples.Tuple;
import com.mmnaseri.utils.tuples.reflection.InvocationElementResolver;
import com.mmnaseri.utils.tuples.reflection.type.TypeConverter;

/**
 * Default implementation of {@link TupleMethodInvocationHandler} which uses {@link
 * DefaultTupleInvocationHandler} to resolve method calls.
 */
public class DefaultTupleMethodInvocationHandler extends TupleMethodInvocationHandler {

  public DefaultTupleMethodInvocationHandler(
      final Class<?> type,
      final Tuple<?> tuple,
      final TypeConverter typeConverter,
      final InvocationElementResolver elementResolver) {
    super(type, tuple, typeConverter, new DefaultTupleInvocationHandler(type, elementResolver));
  }
}

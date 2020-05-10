package com.mmnaseri.utils.tuples.reflection.impl;

import com.mmnaseri.utils.tuples.Tuple;
import com.mmnaseri.utils.tuples.reflection.MethodInvocation;
import com.mmnaseri.utils.tuples.reflection.TupleInvocationHandler;

/** Handler that supports the equality check of two tuple-based proxies. */
public class EqualsTupleInvocationHandler implements TupleInvocationHandler {

  @Override
  public boolean handles(final Tuple<?> tuple, final MethodInvocation invocation) {
    return invocation.method().getName().equals("equals")
        && invocation.method().getParameterCount() == 1
        && invocation.method().getParameterTypes()[0].equals(Object.class);
  }

  @Override
  public Object handle(final Tuple<?> tuple, final MethodInvocation invocation) {
    Object other = invocation.arguments()[0];
    if (!invocation.type().isInstance(other)) {
      return false;
    }
    return TupleProxyUtils.mapOf(invocation.type(), invocation.instance())
        .equals(TupleProxyUtils.mapOf(invocation.type(), other));
  }
}

package com.mmnaseri.utils.tuples.reflection.impl;

import com.mmnaseri.utils.tuples.Tuple;
import com.mmnaseri.utils.tuples.reflection.MethodInvocation;
import com.mmnaseri.utils.tuples.reflection.TupleInvocationHandler;

/**
 * A handler that uses the of the map representation of the proxy as the hash code used for the hash
 * code of the proxied instance.
 */
public class HashCodeTupleInvocationHandler implements TupleInvocationHandler {

  @Override
  public boolean handles(final Tuple<?> tuple, final MethodInvocation invocation) {
    return invocation.method().getName().equals("hashCode")
        && invocation.method().getParameterCount() == 0;
  }

  @Override
  public Object handle(final Tuple<?> tuple, final MethodInvocation invocation) {
    return TupleProxyUtils.mapOf(invocation.type(), invocation.instance()).hashCode();
  }
}

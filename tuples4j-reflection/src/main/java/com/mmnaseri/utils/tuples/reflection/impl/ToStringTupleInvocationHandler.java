package com.mmnaseri.utils.tuples.reflection.impl;

import com.mmnaseri.utils.tuples.Tuple;
import com.mmnaseri.utils.tuples.reflection.MethodInvocation;
import com.mmnaseri.utils.tuples.reflection.TupleInvocationHandler;

import java.util.Map;

import static java.util.stream.Collectors.joining;

/** A handler that generates a string representation of the sorted view of the proxy data. */
public class ToStringTupleInvocationHandler implements TupleInvocationHandler {

  @Override
  public boolean handles(final Tuple<?> tuple, final MethodInvocation invocation) {
    return invocation.method().getName().equals("toString")
        && invocation.method().getParameterCount() == 0;
  }

  @Override
  public Object handle(final Tuple<?> tuple, final MethodInvocation invocation) {
    return "{"
        + TupleProxyUtils.mapOf(invocation.type(), invocation.instance()).entrySet().stream()
            .sorted(Map.Entry.comparingByKey())
            .map(entry -> entry.getKey() + "=" + entry.getValue())
            .collect(joining(", "))
        + "}";
  }
}

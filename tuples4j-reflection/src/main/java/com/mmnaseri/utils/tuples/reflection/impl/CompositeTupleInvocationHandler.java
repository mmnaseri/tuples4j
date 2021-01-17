package com.mmnaseri.utils.tuples.reflection.impl;

import com.mmnaseri.utils.tuples.Tuple;
import com.mmnaseri.utils.tuples.reflection.MethodInvocation;
import com.mmnaseri.utils.tuples.reflection.TupleInvocationHandler;

import java.util.ArrayList;
import java.util.List;

public class CompositeTupleInvocationHandler implements TupleInvocationHandler {

  private final List<TupleInvocationHandler> handlers;

  public CompositeTupleInvocationHandler() {
    handlers = new ArrayList<>();
  }

  protected void add(TupleInvocationHandler handler) {
    handlers.add(handler);
  }

  @Override
  public boolean handles(final Tuple<?> tuple, final MethodInvocation invocation) {
    return handlers.stream().anyMatch(handler -> handler.handles(tuple, invocation));
  }

  @Override
  public Object handle(final Tuple<?> tuple, final MethodInvocation invocation) {
    return handlers.stream()
        .filter(handler -> handler.handles(tuple, invocation))
        .map(handler -> callOrThrow(handler, tuple, invocation))
        .findFirst()
        .orElseThrow(
            () ->
                new IllegalStateException(
                    String.format(
                        "Could not find any suitable handler for invocation %s on tuple %s",
                        invocation, tuple)));
  }

  private static Object callOrThrow(
      TupleInvocationHandler handler, Tuple<?> tuple, MethodInvocation invocation) {
    try {
      return handler.handle(tuple, invocation);
    } catch (Throwable throwable) {
      throw new IllegalStateException(
          String.format(
              "Failed to call handler %s for invocation %s on tuple %s",
              handler, invocation, tuple),
          throwable);
    }
  }
}

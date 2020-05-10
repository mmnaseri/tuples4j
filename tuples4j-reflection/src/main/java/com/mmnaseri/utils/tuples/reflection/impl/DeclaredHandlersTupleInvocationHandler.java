package com.mmnaseri.utils.tuples.reflection.impl;

import com.mmnaseri.utils.tuples.Tuple;
import com.mmnaseri.utils.tuples.annotations.WithHandler;
import com.mmnaseri.utils.tuples.annotations.WithHandlers;
import com.mmnaseri.utils.tuples.reflection.MethodInvocation;
import com.mmnaseri.utils.tuples.reflection.TupleInvocationHandler;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/** A handler that uses the statically provided handlers on the proxy type for value resolution. */
public class DeclaredHandlersTupleInvocationHandler implements TupleInvocationHandler {

  private final List<TupleInvocationHandler> handlers;

  public DeclaredHandlersTupleInvocationHandler(Class<?> proxyType) {
    handlers = new ArrayList<>();
    WithHandlers withHandlers = TupleProxyUtils.getAnnotation(WithHandlers.class, proxyType);
    if (withHandlers != null) {
      Arrays.stream(withHandlers.value())
          .map(WithHandler::value)
          .map(TupleProxyUtils::instantiate)
          .forEach(handlers::add);
    } else {
      WithHandler withHandler = TupleProxyUtils.getAnnotation(WithHandler.class, proxyType);
      if (withHandler != null) {
        handlers.add(TupleProxyUtils.instantiate(withHandler.value()));
      }
    }
  }

  @Override
  public boolean handles(final Tuple<?> tuple, final MethodInvocation invocation) {
    return handlers.stream().anyMatch(handler -> handler.handles(tuple, invocation));
  }

  @Override
  public Object handle(final Tuple<?> tuple, final MethodInvocation invocation) {
    return handlers.stream()
        .filter(handler -> handler.handles(tuple, invocation))
        .map(
            handler -> {
              try {
                return handler.handle(tuple, invocation);
              } catch (Throwable throwable) {
                throw new RuntimeException(
                    String.format(
                        "Failed to call handler %s for invocation %s on tuple %s",
                        handler, invocation, tuple),
                    throwable);
              }
            })
        .findFirst()
        .orElseThrow(
            () ->
                new RuntimeException(
                    String.format(
                        "Could not find any suitable handler for invocation %s on tuple %s",
                        invocation, tuple)));
  }
}

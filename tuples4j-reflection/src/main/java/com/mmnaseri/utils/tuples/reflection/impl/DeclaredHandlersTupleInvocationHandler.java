package com.mmnaseri.utils.tuples.reflection.impl;

import com.mmnaseri.utils.tuples.annotations.WithHandler;
import com.mmnaseri.utils.tuples.annotations.WithHandlers;

import java.util.Arrays;

/** A handler that uses the statically provided handlers on the proxy type for value resolution. */
public class DeclaredHandlersTupleInvocationHandler extends CompositeTupleInvocationHandler {

  public DeclaredHandlersTupleInvocationHandler(Class<?> proxyType) {
    WithHandlers withHandlers = TupleProxyUtils.getAnnotation(WithHandlers.class, proxyType);
    if (withHandlers != null) {
      Arrays.stream(withHandlers.value())
          .map(WithHandler::value)
          .map(TupleProxyUtils::instantiate)
          .forEach(this::add);
    } else {
      WithHandler withHandler = TupleProxyUtils.getAnnotation(WithHandler.class, proxyType);
      if (withHandler != null) {
        this.add(TupleProxyUtils.instantiate(withHandler.value()));
      }
    }
  }
}

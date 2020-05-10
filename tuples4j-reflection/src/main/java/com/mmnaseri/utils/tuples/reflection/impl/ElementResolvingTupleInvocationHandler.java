package com.mmnaseri.utils.tuples.reflection.impl;

import com.mmnaseri.utils.tuples.Tuple;
import com.mmnaseri.utils.tuples.reflection.InvocationElementResolver;
import com.mmnaseri.utils.tuples.reflection.MethodInvocation;
import com.mmnaseri.utils.tuples.reflection.TupleInvocationHandler;

import java.lang.reflect.Method;

/**
 * Invocation handler that uses an instance of {@link InvocationElementResolver} to figure out which
 * element of the tuple should be used as the return value.
 */
public class ElementResolvingTupleInvocationHandler implements TupleInvocationHandler {

  private final InvocationElementResolver elementResolver;

  public ElementResolvingTupleInvocationHandler(final InvocationElementResolver elementResolver) {
    this.elementResolver = elementResolver;
  }

  @Override
  public boolean handles(final Tuple<?> tuple, final MethodInvocation invocation) {
    return true;
  }

  @Override
  public Object handle(final Tuple<?> tuple, final MethodInvocation invocation) {
    int index = elementResolver.resolve(tuple, invocation);
    checkResolvedIndex(invocation.method(), tuple, index);
    return tuple.get(index);
  }

  private void checkResolvedIndex(final Method method, final Tuple<?> tuple, final int index) {
    if (index < 0 || index >= tuple.size()) {
      throw new IllegalStateException(
          "Could not match invocation of "
              + method.getName()
              + " to any elements on tuple "
              + tuple);
    }
  }
}

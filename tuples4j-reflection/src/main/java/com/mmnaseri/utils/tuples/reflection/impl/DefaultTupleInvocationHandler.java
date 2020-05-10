package com.mmnaseri.utils.tuples.reflection.impl;

import com.mmnaseri.utils.tuples.reflection.InvocationElementResolver;

/**
 * Default implementation for {@link com.mmnaseri.utils.tuples.reflection.TupleInvocationHandler}
 * which is composed of (in the following order):
 *
 * <ol>
 *   <li>{@link HashCodeTupleInvocationHandler}
 *   <li>{@link ToStringTupleInvocationHandler}
 *   <li>{@link EqualsTupleInvocationHandler}
 *   <li>{@link InterfaceDefaultMethodTupleInvocationHandler}
 *   <li>{@link ProvidedMethodTupleInvocationHandler}
 *   <li>{@link DeclaredHandlersTupleInvocationHandler}
 *   <li>{@link ElementResolvingTupleInvocationHandler}
 * </ol>
 */
public class DefaultTupleInvocationHandler extends CompositeTupleInvocationHandler {

  public DefaultTupleInvocationHandler(
      final Class<?> type, final InvocationElementResolver elementResolver) {
    add(new HashCodeTupleInvocationHandler());
    add(new ToStringTupleInvocationHandler());
    add(new EqualsTupleInvocationHandler());
    add(new InterfaceDefaultMethodTupleInvocationHandler());
    add(new ProvidedMethodTupleInvocationHandler());
    add(new DeclaredHandlersTupleInvocationHandler(type));
    add(new ElementResolvingTupleInvocationHandler(elementResolver));
  }
}

package com.mmnaseri.utils.tuples.reflection;

import com.mmnaseri.utils.tuples.Tuple;

/**
 * A resolver that is capable of finding element indices based on a method's declaration.
 *
 * @author Milad Naseri (m.m.naseri@gmail.com)
 */
public interface InvocationElementResolver {

  /** Resolves the index of an element from the method for this tuple. */
  int resolve(final Tuple<?> tuple, MethodInvocation invocation);
}

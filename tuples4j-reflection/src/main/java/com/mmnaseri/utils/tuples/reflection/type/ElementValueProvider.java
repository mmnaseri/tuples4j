package com.mmnaseri.utils.tuples.reflection.type;

import com.mmnaseri.utils.tuples.Tuple;
import com.mmnaseri.utils.tuples.reflection.MethodInvocation;

/** Provides the value from a method call on a tuple proxy. */
public interface ElementValueProvider {

  /** Handles the invocation and returns the requisite value (if any). */
  Object handle(Tuple<?> tuple, MethodInvocation invocation) throws Throwable;
}

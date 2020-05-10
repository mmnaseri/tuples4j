package com.mmnaseri.utils.tuples.reflection;

import com.mmnaseri.utils.tuples.Tuple;

/**
 * An invocation handler that can handle select methods on a tuple's proxy instance.
 *
 * @author Milad Naseri (m.m.naseri@gmail.com)
 */
public interface TupleInvocationHandler {

  /** Indicates if this handler handles the provided invocation. */
  boolean handles(Tuple<?> tuple, MethodInvocation invocation);

  /** Handles the invocation and returns the requisite value (if any). */
  Object handle(Tuple<?> tuple, MethodInvocation invocation);
}

package com.mmnaseri.utils.tuples.reflection;

import com.mmnaseri.utils.tuples.Tuple;
import com.mmnaseri.utils.tuples.reflection.type.ElementValueProvider;

/**
 * An invocation handler that can handle select methods on a tuple's proxy instance.
 *
 * @author Milad Naseri (m.m.naseri@gmail.com)
 */
public interface TupleInvocationHandler extends ElementValueProvider {

  /** Indicates if this handler handles the provided invocation. */
  boolean handles(Tuple<?> tuple, MethodInvocation invocation);
}

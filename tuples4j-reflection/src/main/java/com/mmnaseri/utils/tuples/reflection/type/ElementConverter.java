package com.mmnaseri.utils.tuples.reflection.type;

import com.mmnaseri.utils.tuples.Tuple;
import com.mmnaseri.utils.tuples.reflection.MethodInvocation;

/**
 * A converter that can be used to convert values from the element to a desired type. This is used in conjunction with
 */
public interface ElementConverter<E> {

  E convert(Tuple<?> tuple, MethodInvocation invocation);

}

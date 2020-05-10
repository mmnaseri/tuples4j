package com.mmnaseri.utils.tuples.reflection.type;

import java.lang.reflect.Type;

/**
 * A converter that can be used to convert values from the element to a desired type. This is used
 * in conjunction with
 */
public interface ElementConverter<E> {

  /** Converts the type of the given object to the expected type. */
  E convert(Type type, Object value);
}

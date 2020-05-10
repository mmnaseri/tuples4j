package com.mmnaseri.utils.tuples.reflection.type;

import java.lang.reflect.Type;

/**
 * A converter that can convert values from one type to another other.
 *
 * @author Milad Naseri (m.m.naseri@gmail.com)
 */
public interface TypeConverter extends ElementConverter<Object> {

  /** Indicates if this converter supports converting the provided value to the expected type. */
  boolean supportsConversion(Type expectedType, Object value);
}

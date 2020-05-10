package com.mmnaseri.utils.tuples.reflection;

import java.lang.reflect.Type;

/**
 * A converter that can convert values from one type to another other.
 *
 * @author Milad Naseri (m.m.naseri@gmail.com)
 */
public interface TypeConverter {

  /** Indicates if this converter supports converting the provided value to the expected type. */
  boolean supportsConversion(Type expectedType, Object value);

  /** Converts the provided value to the expected type. */
  Object convert(Type expectedType, Object value);
}

package com.mmnaseri.utils.tuples.reflection.type.impl;

import com.mmnaseri.utils.tuples.reflection.type.TypeConverter;

import java.lang.reflect.Type;

/** A converter that converts based on a {@link Class} rather than a generic type. */
public abstract class ClassTypeConverter implements TypeConverter {

  @Override
  public boolean supportsConversion(final Type expectedType, final Object value) {
    return expectedType instanceof Class<?> && supportsConversion((Class<?>) expectedType, value);
  }

  protected abstract boolean supportsConversion(Class<?> expectedType, Object value);

  @Override
  public Object convert(final Type expectedType, final Object value) {
    return convert((Class<?>) expectedType, value);
  }

  protected abstract Object convert(Class<?> expectedType, final Object value);
}

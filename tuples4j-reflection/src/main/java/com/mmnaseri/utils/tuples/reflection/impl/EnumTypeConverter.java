package com.mmnaseri.utils.tuples.reflection.impl;

import java.util.Objects;

/**
 * Converts any number or string value to an enum. This is done by mapping the any object to a
 * string to see if that string's value is supported by the enum. If the input is instead a number
 * the {@link Number#intValue()} is used to get to the index of the enum constant.
 */
public class EnumTypeConverter extends ClassTypeConverter {

  @Override
  protected boolean supportsConversion(final Class<?> expectedType, final Object value) {
    return expectedType.isEnum();
  }

  @Override
  protected Object convert(final Class<?> expectedType, final Object value) {
    if (value instanceof Number) {
      return ((Class<?>) expectedType)
          .asSubclass(Enum.class)
          .getEnumConstants()[((Number) value).intValue()];
    } else {
      return Enum.valueOf(
          ((Class<?>) expectedType).asSubclass(Enum.class), Objects.toString(value));
    }
  }
}

package com.mmnaseri.utils.tuples.reflection.type.impl;

import com.mmnaseri.utils.tuples.reflection.type.TypeConverter;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * A type converter that is composed of other type converters. The first type converter that
 * supports converting a value will be used.
 *
 * @author Milad Naseri (m.m.naseri@gmail.com)
 */
public class CompositeTypeConverter implements TypeConverter {

  private final List<TypeConverter> converters;

  public CompositeTypeConverter() {
    this.converters = new ArrayList<>();
  }

  public void add(TypeConverter converter) {
    converters.add(converter);
  }

  @Override
  public boolean supportsConversion(final Type expectedType, final Object value) {
    return converters.stream()
        .anyMatch(converter -> converter.supportsConversion(expectedType, value));
  }

  @Override
  public Object convert(final Type expectedType, final Object value) {
    TypeConverter typeConverter =
        converters.stream()
            .filter(converter -> converter.supportsConversion(expectedType, value))
            .findFirst()
            .orElseThrow(
                () ->
                    new IllegalStateException(
                        "Could not find a suitable converter for converting "
                            + value
                            + " into an instance of "
                            + expectedType));
    return typeConverter.convert(expectedType, value);
  }
}

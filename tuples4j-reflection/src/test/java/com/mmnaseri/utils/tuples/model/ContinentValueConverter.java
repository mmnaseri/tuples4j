package com.mmnaseri.utils.tuples.model;

import com.mmnaseri.utils.tuples.reflection.type.ElementConverter;

import java.lang.reflect.Type;

public class ContinentValueConverter implements ElementConverter<Continent> {

  @Override
  public Continent convert(final Type type, final Object value) {
    return Continent.valueOf(((String) value).toUpperCase().replace(' ', '_'));
  }
}

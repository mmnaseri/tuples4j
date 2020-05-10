package com.mmnaseri.utils.tuples.reflection.type;

import com.mmnaseri.utils.tuples.reflection.type.impl.DefaultElementConverterRegistry;

/** A registry that can hold instances of a {@link ElementConverter}. */
public interface ElementConverterRegistry {

  ElementConverter<?> get(Class<? extends ElementConverter<?>> type);

  static ElementConverterRegistry defaultRegistry() {
    return DefaultElementConverterRegistry.getInstance();
  }

}

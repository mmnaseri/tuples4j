package com.mmnaseri.utils.tuples.reflection.type;

import com.mmnaseri.utils.tuples.reflection.type.impl.DefaultElementConverterRegistry;

/** A registry that can hold instances of a {@link ElementConverter}. */
public interface ElementConverterRegistry {

  /**
   * Returns an instance of the required converter. If another instance has already been created for
   * this type, then that instance will be reused.
   */
  ElementConverter<?> get(Class<? extends ElementConverter<?>> type);

  /**
   * Returns the default registry instance from {@link
   * DefaultElementConverterRegistry#getInstance()}.
   */
  static ElementConverterRegistry defaultRegistry() {
    return DefaultElementConverterRegistry.getInstance();
  }
}

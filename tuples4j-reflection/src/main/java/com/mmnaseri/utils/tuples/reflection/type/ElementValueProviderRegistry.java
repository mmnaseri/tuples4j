package com.mmnaseri.utils.tuples.reflection.type;

import com.mmnaseri.utils.tuples.reflection.type.impl.DefaultElementValueProviderRegistry;

/** A registry that can hold instances of a {@link ElementValueProvider}. */
public interface ElementValueProviderRegistry {

  /**
   * Returns an instance of the required converter. If another instance has already been created for
   * this type, then that instance will be reused.
   */
  ElementValueProvider get(Class<? extends ElementValueProvider> type);

  /**
   * Returns the default registry instance from {@link
   * DefaultElementValueProviderRegistry#getInstance()}.
   */
  static ElementValueProviderRegistry defaultRegistry() {
    return DefaultElementValueProviderRegistry.getInstance();
  }
}

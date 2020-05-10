package com.mmnaseri.utils.tuples.reflection.type.impl;

import com.mmnaseri.utils.tuples.reflection.impl.TupleProxyUtils;
import com.mmnaseri.utils.tuples.reflection.type.ElementConverter;
import com.mmnaseri.utils.tuples.reflection.type.ElementConverterRegistry;

import java.util.concurrent.ConcurrentHashMap;

/** Default implementation for {@link ElementConverterRegistry}. */
public class DefaultElementConverterRegistry implements ElementConverterRegistry {

  private static volatile DefaultElementConverterRegistry defaultInstance;

  private final ConcurrentHashMap<Class<? extends ElementConverter<?>>, ElementConverter<?>>
      converters;

  private DefaultElementConverterRegistry() {
    if (defaultInstance != null) {
      throw new RuntimeException(
          "Another instance of class already exists. Use getInstance() to get access to that instance.");
    }
    converters = new ConcurrentHashMap<>();
  }

  @Override
  public ElementConverter<?> get(final Class<? extends ElementConverter<?>> type) {
    return converters.computeIfAbsent(type, TupleProxyUtils::instantiate);
  }

  protected DefaultElementConverterRegistry readResolve() {
    return getInstance();
  }

  public static DefaultElementConverterRegistry getInstance() {
    if (defaultInstance == null) {
      synchronized (DefaultElementConverterRegistry.class) {
        if (defaultInstance == null) {
          defaultInstance = new DefaultElementConverterRegistry();
        }
      }
    }
    return defaultInstance;
  }
}

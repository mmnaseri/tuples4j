package com.mmnaseri.utils.tuples.reflection.type.impl;

import com.mmnaseri.utils.tuples.reflection.impl.TupleProxyUtils;
import com.mmnaseri.utils.tuples.reflection.type.ElementConverterRegistry;
import com.mmnaseri.utils.tuples.reflection.type.ElementValueProvider;
import com.mmnaseri.utils.tuples.reflection.type.ElementValueProviderRegistry;

import java.util.concurrent.ConcurrentHashMap;

/** Default implementation for {@link ElementValueProviderRegistry}. */
public class DefaultElementValueProviderRegistry implements ElementValueProviderRegistry {

  private static volatile DefaultElementValueProviderRegistry defaultInstance;

  private final ConcurrentHashMap<Class<? extends ElementValueProvider>, ElementValueProvider>
      providers;

  private DefaultElementValueProviderRegistry() {
    if (defaultInstance != null) {
      throw new RuntimeException(
          "Another instance of class already exists. Use getInstance() to get access to that instance.");
    }
    providers = new ConcurrentHashMap<>();
  }

  @Override
  public ElementValueProvider get(final Class<? extends ElementValueProvider> type) {
    return providers.computeIfAbsent(type, TupleProxyUtils::instantiate);
  }

  public static DefaultElementValueProviderRegistry getInstance() {
    if (defaultInstance == null) {
      synchronized (DefaultElementValueProviderRegistry.class) {
        if (defaultInstance == null) {
          defaultInstance = new DefaultElementValueProviderRegistry();
        }
      }
    }
    return defaultInstance;
  }

  protected DefaultElementValueProviderRegistry readResolve() {
    return getInstance();
  }
}

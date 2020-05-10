package com.mmnaseri.utils.tuples.impl;

import com.mmnaseri.utils.tuples.Reflector;
import com.mmnaseri.utils.tuples.Tuple;
import com.mmnaseri.utils.tuples.reflection.InvocationElementResolver;
import com.mmnaseri.utils.tuples.reflection.impl.DefaultTupleMethodInvocationHandler;
import com.mmnaseri.utils.tuples.reflection.type.TypeConverter;

import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

/** Default implementation for {@link Reflector} which caches instances for each proxy type. */
public class CachingReflector implements Reflector {

  private final Map<Class<?>, Object> proxies;
  private final Tuple<?> tuple;
  private final TypeConverter typeConverter;

  public CachingReflector(final Tuple<?> tuple, final TypeConverter typeConverter) {
    this.tuple = tuple;
    this.typeConverter = typeConverter;
    proxies = new HashMap<>();
  }

  @Override
  public <O> O as(final Class<O> type, final InvocationElementResolver resolver) {
    return type.cast(proxies.computeIfAbsent(type, t -> createProxy(type, resolver)));
  }

  private <O> Object createProxy(final Class<O> type, final InvocationElementResolver resolver) {
    if (!type.isInterface()) {
      throw new IllegalArgumentException("Proxies can only be created using interface types.");
    }
    return Proxy.newProxyInstance(
        Thread.currentThread().getContextClassLoader(),
        new Class[] {type},
        new DefaultTupleMethodInvocationHandler(type, tuple, typeConverter, resolver));
  }
}

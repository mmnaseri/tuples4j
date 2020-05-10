package com.mmnaseri.utils.tuples.impl;

import com.mmnaseri.utils.tuples.ReflectiveTuple;
import com.mmnaseri.utils.tuples.Tuple;
import com.mmnaseri.utils.tuples.reflection.InvocationElementResolver;
import com.mmnaseri.utils.tuples.reflection.type.TypeConverter;

/** Reflective tuple using {@link CachingReflector}. */
public class CachingReflectiveTuple<Z> extends DelegatingTuple<Z> implements ReflectiveTuple<Z> {

  private final CachingReflector reflector;

  public CachingReflectiveTuple(final Tuple<Z> delegate, final TypeConverter typeConverter) {
    super(delegate);
    reflector = new CachingReflector(delegate, typeConverter);
  }

  @Override
  public <O> O as(final Class<O> type, final InvocationElementResolver resolver) {
    return reflector.as(type, resolver);
  }
}

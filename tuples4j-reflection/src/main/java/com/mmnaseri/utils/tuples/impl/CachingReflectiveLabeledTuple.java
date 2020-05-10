package com.mmnaseri.utils.tuples.impl;

import com.mmnaseri.utils.tuples.LabeledTuple;
import com.mmnaseri.utils.tuples.ReflectiveLabeledTuple;
import com.mmnaseri.utils.tuples.reflection.InvocationElementResolver;
import com.mmnaseri.utils.tuples.reflection.type.TypeConverter;

/**
 * Reflective labeled tuple using {@link CachingReflector}.
 */
public class CachingReflectiveLabeledTuple<Z> extends DelegatingLabeledTuple<Z>
    implements ReflectiveLabeledTuple<Z> {

  private final CachingReflector reflector;

  public CachingReflectiveLabeledTuple(
      final LabeledTuple<Z> delegate, final TypeConverter typeConverter) {
    super(delegate);
    reflector = new CachingReflector(delegate, typeConverter);
  }

  @Override
  public <O> O as(final Class<O> type, final InvocationElementResolver resolver) {
    return reflector.as(type, resolver);
  }
}

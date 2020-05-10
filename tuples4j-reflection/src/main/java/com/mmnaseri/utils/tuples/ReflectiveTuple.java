package com.mmnaseri.utils.tuples;

import com.mmnaseri.utils.tuples.impl.CachingReflectiveLabeledTuple;
import com.mmnaseri.utils.tuples.impl.CachingReflectiveTuple;
import com.mmnaseri.utils.tuples.reflection.type.TypeConverter;
import com.mmnaseri.utils.tuples.reflection.type.impl.DefaultTypeConverter;

/**
 * A tuple that can be used to create instances whose methods are bound to this tuple's underlying
 * data.
 *
 * @author Milad Naseri (m.m.naseri@gmail.com)
 */
public interface ReflectiveTuple<Z> extends Tuple<Z>, Reflector {

  /**
   * Returns a reflective version of the provided tuple using {@link DefaultTypeConverter} as the
   * type conversion mediator.
   *
   * @see #of(Tuple, TypeConverter)
   */
  static <Z> ReflectiveTuple<Z> of(Tuple<Z> tuple) {
    return of(tuple, DefaultTypeConverter.getInstance());
  }

  /**
   * Returns a reflective tuple of the provided tuple which caches every proxy instance per type,
   * and uses the provided {@link TypeConverter} for type conversion.
   *
   * @see CachingReflectiveTuple
   */
  static <Z> ReflectiveTuple<Z> of(Tuple<Z> tuple, final TypeConverter typeConverter) {
    return new CachingReflectiveTuple<>(tuple, typeConverter);
  }

  /**
   * Returns a reflective version of the provided labeled tuple by using {@link
   * DefaultTypeConverter} as the type conversion mediator.
   *
   * @see #of(LabeledTuple, TypeConverter)
   */
  static <Z> ReflectiveLabeledTuple<Z> of(LabeledTuple<Z> tuple) {
    return of(tuple, DefaultTypeConverter.getInstance());
  }

  /**
   * Returns a reflective labeled tuple based on the given tuple and uses the provided type
   * conversion to resolve type conversion issues.
   *
   * @see CachingReflectiveLabeledTuple
   */
  static <Z> ReflectiveLabeledTuple<Z> of(
      LabeledTuple<Z> tuple, final TypeConverter typeConverter) {
    return new CachingReflectiveLabeledTuple<>(tuple, typeConverter);
  }
}

package com.mmnaseri.utils.tuples.reflection.impl;

import com.mmnaseri.utils.tuples.utils.FluentMap;

import java.util.Map;
import java.util.function.Function;

/**
 * Converter that can convert object between the boxed and primitive types.
 */
public class PrimitiveTypeConverter extends ClassTypeConverter {

  static final FluentMap<Class<?>, Class<?>> PRIMITIVES =
      FluentMap.<Class<?>, Class<?>>of(int.class, Integer.class)
          .with(float.class, Float.class)
          .with(double.class, Double.class)
          .with(long.class, Long.class)
          .with(short.class, Short.class)
          .with(byte.class, Byte.class)
          .with(char.class, Character.class)
          .with(boolean.class, Boolean.class);

  static final FluentMap<Class<?>, Class<?>> NON_PRIMITIVES = PRIMITIVES.inverseLossy();

  private static final Map<Class<?>, Function<Object, Object>> PRIMITIVES_GETTERS =
      FluentMap.<Class<?>, Function<Object, Object>>of(
              int.class, bound(Number.class, Number::intValue))
          .with(float.class, bound(Number.class, Number::floatValue))
          .with(double.class, bound(Number.class, Number::doubleValue))
          .with(long.class, bound(Number.class, Number::longValue))
          .with(short.class, bound(Number.class, Number::shortValue))
          .with(byte.class, bound(Number.class, Number::byteValue))
          .with(char.class, bound(Character.class, Character::charValue))
          .with(boolean.class, bound(Boolean.class, Boolean::booleanValue));

  @Override
  protected boolean supportsConversion(final Class<?> expectedType, final Object value) {
    return value != null
            && PRIMITIVES.containsKey(value.getClass())
            && PRIMITIVES.get(value.getClass()).equals(expectedType)
        || value != null
            && PRIMITIVES.containsKey(expectedType)
            && PRIMITIVES.get(expectedType).equals(value.getClass());
  }

  @Override
  protected Object convert(final Class<?> expectedType, final Object value) {
    if (expectedType.isPrimitive()) {
      if (!PRIMITIVES.get(expectedType).isInstance(value)) {
        throw new IllegalStateException(
            "Expected " + value + " to be an instance of " + PRIMITIVES.get(expectedType));
      }
      Class<?> primitiveType = NON_PRIMITIVES.get(value.getClass());
      return PRIMITIVES_GETTERS.get(primitiveType).apply(value);
    } else {
      if (!PRIMITIVES.containsValue(expectedType)) {
        throw new IllegalStateException(
            "Cannot convert a primitive value into an instance of " + expectedType);
      }
      return expectedType.cast(value);
    }
  }

  private static <E> Function<Object, Object> bound(Class<E> type, Function<E, Object> function) {
    return o -> function.apply(type.cast(o));
  }
}

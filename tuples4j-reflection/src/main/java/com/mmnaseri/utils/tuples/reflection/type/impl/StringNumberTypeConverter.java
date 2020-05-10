package com.mmnaseri.utils.tuples.reflection.type.impl;

import com.mmnaseri.utils.tuples.utils.FluentMap;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.DoubleAccumulator;
import java.util.concurrent.atomic.DoubleAdder;
import java.util.concurrent.atomic.LongAccumulator;
import java.util.concurrent.atomic.LongAdder;
import java.util.function.BiConsumer;
import java.util.function.Function;

/**
 * Converter that can convert a string representation of any of JDK's standard number types to their
 * corresponding object type.
 */
public class StringNumberTypeConverter extends ClassTypeConverter {

  private static final Map<Class<? extends Number>, Function<String, Number>> READERS =
      FluentMap.<Class<? extends Number>, Function<String, Number>>of(Byte.class, Byte::parseByte)
          .with(Double.class, Double::parseDouble)
          .with(Float.class, Float::parseFloat)
          .with(Integer.class, Integer::parseInt)
          .with(Long.class, Long::parseLong)
          .with(Short.class, Short::parseShort)
          .with(BigDecimal.class, pipe(Double::parseDouble, BigDecimal::new))
          .with(AtomicLong.class, pipe(Long::parseLong, AtomicLong::new))
          .with(AtomicInteger.class, pipe(Integer::parseInt, AtomicInteger::new))
          .with(
              DoubleAccumulator.class,
              string -> new DoubleAccumulator(Double::sum, Double.parseDouble(string)))
          .with(
              DoubleAdder.class,
              string -> accumulate(new DoubleAdder(), Double.parseDouble(string), DoubleAdder::add))
          .with(
              LongAccumulator.class,
              string -> new LongAccumulator(Long::sum, Long.parseLong(string)))
          .with(
              LongAdder.class,
              string -> accumulate(new LongAdder(), Long.parseLong(string), LongAdder::add))
          .with(BigInteger.class, BigInteger::new);

  private Class<?> typeOf(final Class<?> type) {
    return type.isPrimitive() ? PrimitiveTypeConverter.PRIMITIVES.get(type) : type;
  }

  @Override
  protected boolean supportsConversion(final Class<?> expectedType, final Object value) {
    return value instanceof String && READERS.containsKey(typeOf(expectedType));
  }

  @Override
  protected Object convert(final Class<?> expectedType, final Object value) {
    if (expectedType.isPrimitive() && value == null) {
      throw new NullPointerException(
          "Cannot convert null value into an instance of " + expectedType);
    }
    if (value == null) {
      return null;
    }
    return READERS.get(typeOf(expectedType)).apply((String) value);
  }

  private static <E, F> Function<String, F> pipe(Function<String, E> first, Function<E, F> second) {
    return string -> second.apply(first.apply(string));
  }

  private static <E, F> E accumulate(E target, F value, BiConsumer<E, F> consumer) {
    consumer.accept(target, value);
    return target;
  }
}

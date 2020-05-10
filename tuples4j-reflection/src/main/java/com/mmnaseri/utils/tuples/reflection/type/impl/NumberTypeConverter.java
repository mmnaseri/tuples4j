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

/** Converter that can convert all of JDK's standard number types to one-another. */
public class NumberTypeConverter extends ClassTypeConverter {

  private static final Map<Class<? extends Number>, Function<Number, Number>> READERS =
      FluentMap.<Class<? extends Number>, Function<Number, Number>>of(Byte.class, Number::byteValue)
          .with(Double.class, Number::doubleValue)
          .with(Float.class, Number::floatValue)
          .with(Integer.class, Number::intValue)
          .with(Long.class, Number::longValue)
          .with(Short.class, Number::shortValue)
          .with(BigDecimal.class, number -> BigDecimal.valueOf(number.doubleValue()))
          .with(AtomicLong.class, number -> new AtomicLong(number.longValue()))
          .with(AtomicInteger.class, number -> new AtomicInteger(number.intValue()))
          .with(
              DoubleAccumulator.class,
              number -> new DoubleAccumulator(Double::sum, number.doubleValue()))
          .with(
              DoubleAdder.class,
              number -> accumulate(new DoubleAdder(), number.doubleValue(), DoubleAdder::add))
          .with(LongAccumulator.class, number -> new LongAccumulator(Long::sum, number.longValue()))
          .with(
              LongAdder.class,
              number -> accumulate(new LongAdder(), number.longValue(), LongAdder::add))
          .with(BigInteger.class, number -> new BigInteger(String.valueOf(number.intValue())));

  private Class<?> typeOf(final Class<?> type) {
    return type.isPrimitive() ? PrimitiveTypeConverter.PRIMITIVES.get(type) : type;
  }

  @Override
  protected boolean supportsConversion(final Class<?> expectedType, final Object value) {
    return value instanceof Number && READERS.containsKey(typeOf(expectedType));
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
    return READERS.get(typeOf(expectedType)).apply((Number) value);
  }

  private static <E, F> E accumulate(E target, F value, BiConsumer<E, F> consumer) {
    consumer.accept(target, value);
    return target;
  }
}

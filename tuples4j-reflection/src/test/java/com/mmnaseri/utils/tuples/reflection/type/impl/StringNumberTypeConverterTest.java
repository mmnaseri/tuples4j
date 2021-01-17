package com.mmnaseri.utils.tuples.reflection.type.impl;

import com.mmnaseri.utils.tuples.Tuple;
import com.mmnaseri.utils.tuples.utils.FluentMap;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

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

import static com.mmnaseri.utils.tuples.reflection.type.impl.NumberTypeConverterTest.CLASSES_WITHOUT_EQUALITY;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;

public class StringNumberTypeConverterTest {

  private StringNumberTypeConverter converter;

  @BeforeMethod
  public void setUp() {
    converter = new StringNumberTypeConverter();
  }

  @Test(
      expectedExceptions = IllegalArgumentException.class,
      expectedExceptionsMessageRegExp = "Cannot convert null value into an instance of int")
  public void testConvertingNullToPrimitive() {
    converter.convert(int.class, null);
  }

  /**
   * Supplies test data with the signature {@code (String, Class&lt;? extends Number&gt;, Number)},
   * where the first element is the number to be converted, the second element is the output type,
   * and the third element is the expected value.
   */
  @DataProvider
  public Object[][] numberSupplier() {
    Map<Class<? extends Number>, Number> values =
        FluentMap.<Class<? extends Number>, Number>of(Byte.class, (byte) 1)
            .with(Double.class, 1.0D)
            .with(Float.class, 1.0F)
            .with(Integer.class, 1)
            .with(Long.class, 1L)
            .with(Short.class, (short) 1)
            .with(byte.class, (byte) 1)
            .with(double.class, 1.0D)
            .with(float.class, 1.0F)
            .with(int.class, 1)
            .with(long.class, 1L)
            .with(short.class, (short) 1)
            .with(BigDecimal.class, new BigDecimal("1"))
            .with(AtomicLong.class, new AtomicLong(1L))
            .with(AtomicInteger.class, new AtomicInteger(1))
            .with(DoubleAccumulator.class, new DoubleAccumulator(Double::sum, 1D))
            .with(DoubleAdder.class, accumulate(new DoubleAdder(), 1D, DoubleAdder::add))
            .with(LongAccumulator.class, new LongAccumulator(Long::sum, 1L))
            .with(LongAdder.class, accumulate(new LongAdder(), 1L, LongAdder::add))
            .with(BigInteger.class, new BigInteger("1"));
    return values.entrySet().stream()
        .map(entry -> Tuple.of(String.valueOf(entry.getValue()), entry.getKey(), entry.getValue()))
        .map(Tuple::asArray)
        .toArray(Object[][]::new);
  }

  @Test(dataProvider = "numberSupplier")
  public void testConversion(
      String value, Class<? extends Number> expectedType, Number expectedValue) {
    assertThat(converter.supportsConversion(expectedType, value), is(true));
    if (CLASSES_WITHOUT_EQUALITY.contains(expectedType)) {
      assertThat(converter.convert(expectedType, value).toString(), is(expectedValue.toString()));
    } else {
      assertThat(converter.convert(expectedType, value), is(expectedValue));
    }
    if (!expectedType.isPrimitive()) {
      assertThat(converter.convert(expectedType, null), is(nullValue()));
    }
  }

  private static <E, F> E accumulate(E target, F value, BiConsumer<E, F> consumer) {
    consumer.accept(target, value);
    return target;
  }
}

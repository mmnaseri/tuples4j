package com.mmnaseri.utils.tuples.reflection.type.impl;

import com.mmnaseri.utils.tuples.reflection.type.impl.EnumTypeConverter;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class EnumTypeConverterTest {

  private EnumTypeConverter converter;

  @BeforeMethod
  public void setUp() {
    converter = new EnumTypeConverter();
  }

  @Test
  public void testConvertingStringToEnum() {
    assertThat(converter.supportsConversion(Sample.class, "abc"), is(true));
    assertThat(converter.convert(Sample.class, "FIRST"), is(Sample.FIRST));
  }

  @Test
  public void testConvertingNumberToEnum() {
    assertThat(converter.supportsConversion(Sample.class, 1), is(true));
    assertThat(converter.convert(Sample.class, 1), is(Sample.SECOND));
  }

  @Test
  public void testConvertingUnsupported() {

    assertThat(converter.convert(Sample.class, new MyClass("FIRST")), is(Sample.FIRST));
  }

  enum Sample {
    FIRST,
    SECOND
  }

  private static class MyClass {

    private final String value;

    private MyClass(final String value) {
      this.value = value;
    }

    @Override
    public String toString() {
      return value;
    }
  }
}

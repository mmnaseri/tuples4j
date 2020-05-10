package com.mmnaseri.utils.tuples.reflection.impl;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class PrimitiveTypeConverterTest {

  private PrimitiveTypeConverter converter;

  @BeforeMethod
  public void setUp() {
    converter = new PrimitiveTypeConverter();
  }

  @Test
  public void testConvertingInt() {
    assertThat(converter.supportsConversion(int.class, 1), is(true));
    assertThat(converter.convert(Integer.class, 1), is(1));
    assertThat(converter.convert(int.class, 1), is(1));
  }

  @Test
  public void testConvertingFloat() {
    assertThat(converter.supportsConversion(float.class, 1F), is(true));
    assertThat(converter.convert(Float.class, 1F), is(1F));
    assertThat(converter.convert(float.class, 1F), is(1F));
  }

  @Test
  public void testConvertingDouble() {
    assertThat(converter.supportsConversion(double.class, 1D), is(true));
    assertThat(converter.convert(Double.class, 1D), is(1D));
    assertThat(converter.convert(double.class, 1D), is(1D));
  }

  @Test
  public void testConvertingLong() {
    assertThat(converter.supportsConversion(long.class, 1L), is(true));
    assertThat(converter.convert(Long.class, 1L), is(1L));
    assertThat(converter.convert(long.class, 1L), is(1L));
  }

  @Test
  public void testConvertingShort() {
    assertThat(
        converter.supportsConversion(short.class, Integer.valueOf(1).shortValue()), is(true));
    assertThat(
        converter.convert(Short.class, Integer.valueOf(1).shortValue()),
        is(Integer.valueOf(1).shortValue()));
    assertThat(
        converter.convert(short.class, Integer.valueOf(1).shortValue()),
        is(Integer.valueOf(1).shortValue()));
  }

  @Test
  public void testConvertingByte() {
    assertThat(converter.supportsConversion(byte.class, Integer.valueOf(1).byteValue()), is(true));
    assertThat(
        converter.convert(Byte.class, Integer.valueOf(1).byteValue()),
        is(Integer.valueOf(1).byteValue()));
    assertThat(
        converter.convert(byte.class, Integer.valueOf(1).byteValue()),
        is(Integer.valueOf(1).byteValue()));
  }

  @Test
  public void testConvertingCharacter() {
    assertThat(converter.supportsConversion(char.class, (char) 10), is(true));
    assertThat(converter.convert(Character.class, (char) 10), is((char) 10));
    assertThat(converter.convert(char.class, (char) 10), is((char) 10));
  }

  @Test
  public void testConvertingBoolean() {
    assertThat(converter.supportsConversion(boolean.class, true), is(true));
    assertThat(converter.convert(Boolean.class, true), is(true));
    assertThat(converter.convert(boolean.class, true), is(true));
  }

  @Test(
      expectedExceptions = IllegalStateException.class,
      expectedExceptionsMessageRegExp =
          "Expected null to be an instance of class java\\.lang\\.Integer")
  public void testConvertingNullToPrimitive() {
    converter.convert(int.class, null);
  }

  @Test(
      expectedExceptions = IllegalStateException.class,
      expectedExceptionsMessageRegExp =
          "Cannot convert a primitive value into an instance of class java\\.lang\\.String")
  public void testConvertingPrimitiveToUnsupported() {
    converter.convert(String.class, Integer.valueOf(1).shortValue());
  }
}

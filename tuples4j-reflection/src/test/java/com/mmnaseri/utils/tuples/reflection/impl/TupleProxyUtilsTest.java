package com.mmnaseri.utils.tuples.reflection.impl;

import com.mmnaseri.utils.tuples.annotations.Metadata;
import org.testng.annotations.Test;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.testng.Assert.fail;

public class TupleProxyUtilsTest {

  @Test
  public void testInstantiation() throws Exception {
    Constructor<TupleProxyUtils> constructor = TupleProxyUtils.class.getDeclaredConstructor();
    constructor.setAccessible(true);
    try {
      constructor.newInstance();
    } catch (Exception e) {
      assertThat(e, is(instanceOf(InvocationTargetException.class)));
      assertThat(e.getCause(), is(notNullValue()));
      Throwable cause = e.getCause();
      assertThat(cause, is(instanceOf(IllegalStateException.class)));
      assertThat(cause.getMessage(), is("This type should not be instantiated"));
      return;
    }
    fail();
  }

  @Test
  public void testGettingAMapFromValues() {
    MyClass object = new MyClass();
    Map<String, Object> map = TupleProxyUtils.mapOf(TheInterface.class, object);
    assertThat(map, is(notNullValue()));
    assertThat(map.size(), is(2));
    assertThat(map.keySet(), containsInAnyOrder("value", "string"));
    assertThat(map.get("value"), is(123));
    assertThat(map.get("string"), is("xyz"));
  }

  @Test
  public void testDiscoveringAnnotationPresence() throws Exception {
    assertThat(
        TupleProxyUtils.hasAnnotation(Metadata.class, TheInterface.class.getDeclaredMethod("list")),
        is(true));
  }

  @Test
  public void testRetrievingAnnotation() throws Exception {
    SecondAnnotation annotation =
        TupleProxyUtils.getAnnotation(
            SecondAnnotation.class, TheInterface.class.getDeclaredMethod("list"));
    assertThat(annotation, is(notNullValue()));
    assertThat(annotation.value(), is("mno"));
  }

  @Test(expectedExceptions = RuntimeException.class, expectedExceptionsMessageRegExp = "Could not call method.*\\.value\\(\\).*")
  public void testExceptingMethodPreventsMapCreation() {
    TupleProxyUtils.mapOf(ExceptingInterface.class, new ExceptingClass());
  }

  private interface TheSuperInterface {

    Integer value();
  }

  private interface TheInterface extends TheSuperInterface {

    @ThirdAnnotation
    String string();

    @FirstAnnotation
    List<Object> list();

    void doStuff();

    String string2(String param1);
  }

  private interface ExceptingInterface {

    default String value() throws IllegalAccessException {
      throw new IllegalAccessException();
    }
  }

  private static class MyClass implements TheInterface {

    @Override
    public Integer value() {
      return 123;
    }

    @Override
    public String string() {
      return "xyz";
    }

    @Override
    public List<Object> list() {
      return Arrays.asList(1, 2, 3, 4);
    }

    @Override
    public void doStuff() {}

    @Override
    public String string2(final String param1) {
      return "x";
    }

    public String string2() {
      return "";
    }

    public static String string3() {
      return "";
    }
  }

  private static class ExceptingClass implements ExceptingInterface {}

  @SecondAnnotation("mno")
  @Target(ElementType.METHOD)
  @Retention(RetentionPolicy.RUNTIME)
  private @interface FirstAnnotation {}

  @Metadata
  @Target(ElementType.ANNOTATION_TYPE)
  @Retention(RetentionPolicy.RUNTIME)
  private @interface SecondAnnotation {
    String value();
  }

  @FourthAnnotation
  @Target({ElementType.ANNOTATION_TYPE, ElementType.METHOD})
  @Retention(RetentionPolicy.RUNTIME)
  private @interface ThirdAnnotation {}

  @ThirdAnnotation
  @Target(ElementType.ANNOTATION_TYPE)
  @Retention(RetentionPolicy.RUNTIME)
  private @interface FourthAnnotation {}
}

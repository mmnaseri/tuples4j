package com.mmnaseri.utils.tuples.utils;

import org.testng.annotations.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.testng.Assert.fail;

public class TupleUtilsTest {

  @Test
  public void testClassCannotBeInstantiated() {
    try {
      Constructor<TupleUtils> constructor = TupleUtils.class.getDeclaredConstructor();
      constructor.setAccessible(true);
      constructor.newInstance();
    } catch (Exception e) {
      assertThat(e, is(instanceOf(InvocationTargetException.class)));
      Throwable cause = e.getCause();
      assertThat(cause, is(notNullValue()));
      assertThat(cause, is(instanceOf(IllegalStateException.class)));
      assertThat(cause.getMessage(), is("This class should not be instantiated."));
      return;
    }
    fail();
  }
}

package com.mmnaseri.utils.tuples.reflection.impl;

import com.mmnaseri.utils.tuples.Tuple;
import com.mmnaseri.utils.tuples.impl.FourTuple;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class ToStringTupleInvocationHandlerTest {

  private ToStringTupleInvocationHandler handler;

  @BeforeMethod
  public void setUp() {
    handler = new ToStringTupleInvocationHandler();
  }

  @Test
  public void testHandles() throws Exception {
    assertThat(
        handler.handles(
            null,
            new ImmutableMethodInvocation(
                new Object(),
                new Object[0],
                Object.class.getDeclaredMethod("toString"),
                Object.class)),
        is(true));
  }

  @Test
  public void testHandle() {
    FourTuple<Object, Integer, Integer, Integer, Integer> tuple = Tuple.of(1, 2, 3, 4);
    try {
      assertThat(
          handler.handle(
              tuple,
              new ImmutableMethodInvocation(
                  new MyClass(),
                  new Object[0],
                  Object.class.getDeclaredMethod("toString"),
                  TheInterface.class)),
          is("{intValue=123456, strValue=str-value}"));
    } catch (Throwable throwable) {
      throwable.printStackTrace();
    }
  }

  private interface TheInterface {

    String strValue();

    int intValue();
  }

  private static class MyClass implements TheInterface {

    @Override
    public String strValue() {
      return "str-value";
    }

    @Override
    public int intValue() {
      return 123456;
    }
  }
}

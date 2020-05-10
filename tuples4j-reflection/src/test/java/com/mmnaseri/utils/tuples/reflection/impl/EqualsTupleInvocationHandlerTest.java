package com.mmnaseri.utils.tuples.reflection.impl;

import com.mmnaseri.utils.tuples.Tuple;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class EqualsTupleInvocationHandlerTest {

  private EqualsTupleInvocationHandler handler;

  @BeforeMethod
  public void setUp() {
    handler = new EqualsTupleInvocationHandler();
  }

  @Test
  public void testHandles() throws Exception {
    assertThat(
        handler.handles(
            null,
            new ImmutableMethodInvocation(
                new Object(),
                new Object[0],
                Object.class.getDeclaredMethod("equals", Object.class),
                Object.class)),
        is(true));
  }

  @Test
  public void testHandle() {
    MyClass first = new MyClass();
    OtherClass second = new OtherClass();
    try {
      assertThat(
          handler.handle(
              Tuple.of(),
              new ImmutableMethodInvocation(
                  first,
                  new Object[] {second},
                  Object.class.getDeclaredMethod("equals", Object.class),
                  TheInterface.class)),
          is(true));
    } catch (Throwable throwable) {
      throwable.printStackTrace();
    }
  }

  private interface TheInterface {

    String strValue();

    int intValue();
  }

  private interface OtherInterface extends TheInterface {

    boolean booleanValue();
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

  private static class OtherClass implements OtherInterface {

    @Override
    public String strValue() {
      return "str-value";
    }

    @Override
    public int intValue() {
      return 123456;
    }

    @Override
    public boolean booleanValue() {
      return true;
    }
  }
}

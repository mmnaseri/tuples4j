package com.mmnaseri.utils.tuples.reflection.impl;

import com.mmnaseri.utils.tuples.Tuple;
import com.mmnaseri.utils.tuples.reflection.MethodInvocation;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class InterfaceDefaultMethodTupleInvocationHandlerTest {

  private InterfaceDefaultMethodTupleInvocationHandler handler;

  @BeforeMethod
  public void setUp() {
    handler = new InterfaceDefaultMethodTupleInvocationHandler();
  }

  @Test
  public void testHandles() throws Throwable {
    MethodInvocation invocation =
        new ImmutableMethodInvocation(
            new MyClass(),
            new Object[] {"<<<"},
            TheInterface.class.getDeclaredMethod("defaultMethod", String.class),
            TheInterface.class);
    assertThat(handler.handles(Tuple.of(), invocation), is(true));
  }

  @Test
  public void testHandle() throws Throwable {
    MethodInvocation invocation =
        new ImmutableMethodInvocation(
            new MyClass(),
            new Object[] {"<<<"},
            TheInterface.class.getDeclaredMethod("defaultMethod", String.class),
            TheInterface.class);
    assertThat(handler.handle(Tuple.of(), invocation), is("--xyz<<<"));
  }

  private interface TheInterface {

    String value();

    default String defaultMethod(String suffix) {
      return "--" + value() + suffix;
    }
  }

  private static class MyClass implements TheInterface {

    @Override
    public String defaultMethod(String suffix) {
      return "mno" + suffix;
    }

    @Override
    public String value() {
      return "xyz";
    }
  }
}

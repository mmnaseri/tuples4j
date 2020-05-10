package com.mmnaseri.utils.tuples.reflection.impl;

import com.mmnaseri.utils.tuples.Tuple;
import com.mmnaseri.utils.tuples.reflection.MethodInvocation;
import com.mmnaseri.utils.tuples.reflection.TupleInvocationHandler;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CompositeTupleInvocationHandlerTest {

  @Test(
      expectedExceptions = RuntimeException.class,
      expectedExceptionsMessageRegExp = "Could not find any suitable handler .*")
  public void testHandleWithNoSupport() {
    CompositeTupleInvocationHandler handler = new CompositeTupleInvocationHandler();
    handler.handle(null, null);
  }

  @Test(expectedExceptions = RuntimeException.class, expectedExceptionsMessageRegExp = "Failed to call handler .*")
  public void testUsingThrowingHandler() {
    TestCompositeHandler handler = new TestCompositeHandler();
    handler.handle(null, null);
  }

  private static class TestCompositeHandler extends CompositeTupleInvocationHandler {

    public TestCompositeHandler() {
      add(new ThrowingHandler());
    }
  }

  private static class ThrowingHandler implements TupleInvocationHandler {

    @Override
    public boolean handles(final Tuple<?> tuple, final MethodInvocation invocation) {
      return true;
    }

    @Override
    public Object handle(final Tuple<?> tuple, final MethodInvocation invocation) throws Throwable {
      throw new Exception();
    }
  }
}

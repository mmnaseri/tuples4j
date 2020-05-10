package com.mmnaseri.utils.tuples.reflection.impl;

import com.mmnaseri.utils.tuples.Tuple;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class ElementResolvingTupleInvocationHandlerTest {

  private ElementResolvingTupleInvocationHandler handler;

  @BeforeMethod
  public void setUp() {
    handler = new ElementResolvingTupleInvocationHandler(new AnnotationInvocationElementResolver());
  }

  @Test
  public void testHandles() {
    // This handler always handles the methods.
    assertThat(handler.handles(null, null), is(true));
  }

  @Test
  public void testHandleValid() throws Throwable {
    Object value = handler.handle(Tuple.of("value").withLabels("valid"), invocation("valid"));
    assertThat(value, is("value"));
  }

  @Test(expectedExceptions = IllegalStateException.class, expectedExceptionsMessageRegExp = "Could not match invocation of invalid to any elements on tuple .*")
  public void testHandleInvalid() throws Throwable {
    handler.handle(Tuple.of("value").withLabels("valid"), invocation("invalid"));
  }

  private ImmutableMethodInvocation invocation(final String name) throws NoSuchMethodException {
    return new ImmutableMethodInvocation(
        Object.class,
        new Object[0],
        ProxyInterface.class.getDeclaredMethod(name),
        ProxyInterface.class);
  }

  private interface ProxyInterface {

    String valid();

    String invalid();
  }
}

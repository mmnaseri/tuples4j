package com.mmnaseri.utils.tuples.reflection.impl;

import com.mmnaseri.utils.tuples.Tuple;
import com.mmnaseri.utils.tuples.impl.FourTuple;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class HashCodeTupleInvocationHandlerTest {

  private HashCodeTupleInvocationHandler handler;

  @BeforeMethod
  public void setUp() {
    handler = new HashCodeTupleInvocationHandler();
  }

  @Test
  public void testHandles() throws Exception {
    assertThat(
        handler.handles(
            null,
            new ImmutableMethodInvocation(
                new Object(),
                new Object[0],
                Object.class.getDeclaredMethod("hashCode"),
                Object.class)),
        is(true));
  }

  @Test
  public void testHandle() throws Exception {
    FourTuple<Object, Integer, Integer, Integer, Integer> tuple = Tuple.of(1, 2, 3, 4);
    Map<Object, Object> map = new HashMap<>();
    map.put("strValue", "str-value");
    map.put("intValue", 123456);
    assertThat(
        handler.handle(
            tuple,
            new ImmutableMethodInvocation(
                new MyClass(),
                new Object[0],
                Object.class.getDeclaredMethod("hashCode"),
                TheInterface.class)),
        is(map.hashCode()));
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

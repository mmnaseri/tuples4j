package com.mmnaseri.utils.tuples.reflection.impl;

import com.mmnaseri.utils.tuples.Tuple;
import com.mmnaseri.utils.tuples.annotations.Provided;
import com.mmnaseri.utils.tuples.reflection.MethodInvocation;
import com.mmnaseri.utils.tuples.reflection.type.ElementValueProvider;
import com.mmnaseri.utils.tuples.utils.FluentList;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class ProvidedMethodTupleInvocationHandlerTest {

  private ProvidedMethodTupleInvocationHandler handler;

  @BeforeMethod
  public void setUp() {
    handler = new ProvidedMethodTupleInvocationHandler();
  }

  @Test
  public void testHandles() throws Exception {
    assertThat(handler.handles(Tuple.of(), getInvocation()), is(true));
  }

  @Test
  public void testHandle() throws Throwable {
    assertThat(handler.handle(Tuple.of(), getInvocation()), is(Arrays.asList(1, 2, 3, 4, 5, 6)));
  }

  private ImmutableMethodInvocation getInvocation() throws NoSuchMethodException {
    return new ImmutableMethodInvocation(
        new Object(),
        new Object[] {new Integer[] {4, 5, 6}},
        ProxyInterface.class.getDeclaredMethod("valueFromProvider", Integer[].class),
        ProxyInterface.class);
  }

  private interface ProxyInterface {

    @Provided(by = SampleProvider.class)
    List<Integer> valueFromProvider(Integer... others);
  }

  private static class SampleProvider implements ElementValueProvider {

    @Override
    public Object handle(final Tuple<?> tuple, final MethodInvocation invocation) {
      return FluentList.<Object>of(Arrays.asList(1, 2, 3))
          .with((Integer[]) invocation.arguments()[0]);
    }
  }
}

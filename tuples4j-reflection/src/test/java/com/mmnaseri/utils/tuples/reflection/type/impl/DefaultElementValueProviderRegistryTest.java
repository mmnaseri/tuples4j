package com.mmnaseri.utils.tuples.reflection.type.impl;

import com.mmnaseri.utils.tuples.Tuple;
import com.mmnaseri.utils.tuples.reflection.MethodInvocation;
import com.mmnaseri.utils.tuples.reflection.impl.TupleProxyUtils;
import com.mmnaseri.utils.tuples.reflection.type.ElementValueProvider;
import org.testng.annotations.Test;

import static com.mmnaseri.utils.tuples.reflection.type.ElementValueProviderRegistry.defaultRegistry;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.hamcrest.Matchers.sameInstance;
import static org.testng.Assert.fail;

public class DefaultElementValueProviderRegistryTest {

  @Test
  public void testGetInstance() {
    assertThat(defaultRegistry(), is(defaultRegistry()));
    assertThat(defaultRegistry(), is(DefaultElementValueProviderRegistry.getInstance()));
    assertThat(defaultRegistry(), is(notNullValue()));
  }

  @Test
  public void testReflectiveInstantiation() {
    try {
      TupleProxyUtils.instantiate(DefaultElementValueProviderRegistry.class);
    } catch (Exception e) {
      assertThat(e, is(instanceOf(RuntimeException.class)));
      assertThat(e.getCause(), is(notNullValue()));
      assertThat(e.getCause(), is(instanceOf(RuntimeException.class)));
      assertThat(
          e.getCause().getMessage(), containsString("Another instance of class already exists"));
      return;
    }
    fail();
  }

  @Test
  public void testCreatingInstance() {
    assertThat(defaultRegistry().get(MyProvider.class), is(notNullValue()));
  }

  @Test
  public void testFetchingInstance() {
    assertThat(defaultRegistry().get(MyProvider.class), is(notNullValue()));
    assertThat(
        defaultRegistry().get(MyProvider.class),
        is(sameInstance(defaultRegistry().get(MyProvider.class))));
  }

  private static class MyProvider implements ElementValueProvider {

    @Override
    public Object handle(final Tuple<?> tuple, final MethodInvocation invocation) {
      return null;
    }
  }
}

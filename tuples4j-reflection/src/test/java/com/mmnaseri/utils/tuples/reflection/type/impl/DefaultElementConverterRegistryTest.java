package com.mmnaseri.utils.tuples.reflection.type.impl;

import com.mmnaseri.utils.tuples.Tuple;
import com.mmnaseri.utils.tuples.reflection.MethodInvocation;
import com.mmnaseri.utils.tuples.reflection.impl.TupleProxyUtils;
import com.mmnaseri.utils.tuples.reflection.type.ElementConverter;
import org.testng.annotations.Test;

import static com.mmnaseri.utils.tuples.reflection.type.ElementConverterRegistry.defaultRegistry;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.hamcrest.Matchers.sameInstance;
import static org.testng.Assert.fail;

public class DefaultElementConverterRegistryTest {

  @Test
  public void testGetInstance() {
    assertThat(defaultRegistry(), is(defaultRegistry()));
    assertThat(defaultRegistry(), is(DefaultElementConverterRegistry.getInstance()));
    assertThat(defaultRegistry(), is(notNullValue()));
  }

  @Test
  public void testReflectiveInstantiation() {
    try {
      TupleProxyUtils.instantiate(DefaultElementConverterRegistry.class);
    } catch (Exception e) {
      assertThat(e, is(instanceOf(RuntimeException.class)));
      assertThat(e.getCause(), is(notNullValue()));
      assertThat(e.getCause(), is(instanceOf(RuntimeException.class)));
      assertThat(e.getCause().getMessage(), containsString("Another instance of class already exists"));
      return;
    }
    fail();
  }

  @Test
  public void testNewInstanceCreation() {
    ElementConverter<?> converter = defaultRegistry().get(MyConverter.class);
    assertThat(converter, is(notNullValue()));
  }

  @Test
  public void testMultipleRequests() {
    assertThat(
        defaultRegistry().get(MyConverter.class),
        is(sameInstance(defaultRegistry().get(MyConverter.class))));
  }

  private static class MyConverter implements ElementConverter<String> {

    @Override
    public String convert(final Tuple<?> tuple, final MethodInvocation invocation) {
      return null;
    }
  }
}

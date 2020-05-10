package com.mmnaseri.utils.tuples.impl;

import com.mmnaseri.utils.tuples.Tuple;
import com.mmnaseri.utils.tuples.reflection.type.impl.DefaultTypeConverter;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;

public class CachingReflectorTest {

  @Test(expectedExceptions = IllegalArgumentException.class, expectedExceptionsMessageRegExp = "Proxies can only be created using interface types.")
  public void testCreatingProxyUsingNonInterface() {
    CachingReflector reflector = new CachingReflector(Tuple.of(), DefaultTypeConverter.getInstance());
    reflector.as(Object.class);
  }

  @Test
  public void testCreatingProxyForInterface() {
    CachingReflector reflector = new CachingReflector(Tuple.of(), DefaultTypeConverter.getInstance());
    ProxyInterface instance = reflector.as(ProxyInterface.class);
    assertThat(instance, is(notNullValue()));
    assertThat(instance, is(instanceOf(ProxyInterface.class)));
  }
  
  private interface ProxyInterface{}

}
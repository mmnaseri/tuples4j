package com.mmnaseri.utils.tuples.reflection.impl;

import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.hamcrest.Matchers.sameInstance;

public class AnnotationInvocationElementResolverFactoryTest {

  @Test
  public void testCreateNewInstance() {
    AnnotationInvocationElementResolverFactory factory =
        new AnnotationInvocationElementResolverFactory();
    assertThat(factory.create(), is(notNullValue()));
    assertThat(factory.create(), is(instanceOf(AnnotationInvocationElementResolver.class)));
  }

  @Test
  public void testDefaultInstance() {
    assertThat(AnnotationInvocationElementResolverFactory.getInstance(), is(notNullValue()));
    assertThat(
        AnnotationInvocationElementResolverFactory.getInstance(),
        is(sameInstance(AnnotationInvocationElementResolverFactory.getInstance())));
  }
}

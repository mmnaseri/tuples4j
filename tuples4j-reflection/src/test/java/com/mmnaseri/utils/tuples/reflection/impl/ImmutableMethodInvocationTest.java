package com.mmnaseri.utils.tuples.reflection.impl;

import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.arrayContaining;
import static org.hamcrest.Matchers.is;

public class ImmutableMethodInvocationTest {

  @Test
  public void testArgumentsCannotBeModifiedAfterInstantiation() throws Exception {
    Object[] arguments = {1};
    ImmutableMethodInvocation invocation =
        new ImmutableMethodInvocation(
            this,
            arguments,
            getClass().getDeclaredMethod("testArgumentsCannotBeModifiedAfterInstantiation"));

    assertThat(invocation.arguments(), is(arrayContaining(1)));

    arguments[0] = 2;

    assertThat(invocation.arguments(), is(arrayContaining(1)));
  }

  @Test
  public void testArgumentsCannotBeModifiedViaGetter() throws Exception {
    ImmutableMethodInvocation invocation =
        new ImmutableMethodInvocation(
            this,
            new Object[] {1},
            getClass().getDeclaredMethod("testArgumentsCannotBeModifiedViaGetter"));

    Object[] arguments = invocation.arguments();
    assertThat(arguments, is(arrayContaining(1)));

    arguments[0] = 2;

    assertThat(invocation.arguments(), is(arrayContaining(1)));
  }

  @Test
  public void testEquality() throws Exception {
    ImmutableMethodInvocation first =
        new ImmutableMethodInvocation(
            this,
            new Object[] {1},
            getClass().getDeclaredMethod("testArgumentsCannotBeModifiedViaGetter"));
    ImmutableMethodInvocation second =
        new ImmutableMethodInvocation(
            this,
            new Object[] {1},
            getClass().getDeclaredMethod("testArgumentsCannotBeModifiedViaGetter"));

    assertThat(first, is(second));
    assertThat(second, is(first));
  }

  @Test
  public void testHashCode() throws Exception {
    ImmutableMethodInvocation first =
        new ImmutableMethodInvocation(
            this,
            new Object[] {1},
            getClass().getDeclaredMethod("testArgumentsCannotBeModifiedViaGetter"));
    ImmutableMethodInvocation second =
        new ImmutableMethodInvocation(
            this,
            new Object[] {1},
            getClass().getDeclaredMethod("testArgumentsCannotBeModifiedViaGetter"));

    assertThat(first.hashCode(), is(second.hashCode()));
  }
  @Test
  public void testToString() throws Exception {
    ImmutableMethodInvocation first =
        new ImmutableMethodInvocation(
            this,
            new Object[] {1},
            getClass().getDeclaredMethod("testArgumentsCannotBeModifiedViaGetter"));
    ImmutableMethodInvocation second =
        new ImmutableMethodInvocation(
            this,
            new Object[] {1},
            getClass().getDeclaredMethod("testArgumentsCannotBeModifiedViaGetter"));

    assertThat(first.toString(), is(second.toString()));
  }
}

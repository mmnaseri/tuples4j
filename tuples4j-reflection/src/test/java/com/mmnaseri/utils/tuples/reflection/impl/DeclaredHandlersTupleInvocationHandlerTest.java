package com.mmnaseri.utils.tuples.reflection.impl;

import com.mmnaseri.utils.tuples.Tuple;
import com.mmnaseri.utils.tuples.annotations.WithHandler;
import com.mmnaseri.utils.tuples.annotations.WithHandlers;
import com.mmnaseri.utils.tuples.reflection.MethodInvocation;
import com.mmnaseri.utils.tuples.reflection.TupleInvocationHandler;
import org.testng.annotations.Test;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class DeclaredHandlersTupleInvocationHandlerTest {

  @Test
  public void testHandlesForSimpleAnnotation() throws Exception {
    DeclaredHandlersTupleInvocationHandler handler =
        new DeclaredHandlersTupleInvocationHandler(ProxyInterfaceWithSimpleAnnotation.class);
    assertThat(
        handler.handles(Tuple.of(), invocation(ProxyInterfaceWithSimpleAnnotation.class, "getX")),
        is(true));
    assertThat(
        handler.handles(Tuple.of(), invocation(ProxyInterfaceWithSimpleAnnotation.class, "getY")),
        is(false));
  }

  @Test
  public void testHandleForSimpleAnnotation() throws Throwable {
    DeclaredHandlersTupleInvocationHandler handler =
        new DeclaredHandlersTupleInvocationHandler(ProxyInterfaceWithSimpleAnnotation.class);
    assertThat(
        handler.handle(Tuple.of(), invocation(ProxyInterfaceWithSimpleAnnotation.class, "getX")),
        is(10));
  }

  @Test
  public void testHandlesForRepeatedAnnotation() throws Exception {
    DeclaredHandlersTupleInvocationHandler handler =
        new DeclaredHandlersTupleInvocationHandler(ProxyInterfaceWithRepeatedAnnotation.class);
    assertThat(
        handler.handles(Tuple.of(), invocation(ProxyInterfaceWithRepeatedAnnotation.class, "getX")),
        is(true));
    assertThat(
        handler.handles(Tuple.of(), invocation(ProxyInterfaceWithRepeatedAnnotation.class, "getY")),
        is(true));
  }

  @Test
  public void testHandleForRepeatedAnnotation() throws Throwable {
    DeclaredHandlersTupleInvocationHandler handler =
        new DeclaredHandlersTupleInvocationHandler(ProxyInterfaceWithRepeatedAnnotation.class);
    assertThat(
        handler.handle(Tuple.of(), invocation(ProxyInterfaceWithRepeatedAnnotation.class, "getX")),
        is(10));
    assertThat(
        handler.handle(Tuple.of(), invocation(ProxyInterfaceWithRepeatedAnnotation.class, "getY")),
        is("10"));
  }

  @Test
  public void testHandlesForContainerAnnotation() throws Exception {
    DeclaredHandlersTupleInvocationHandler handler =
        new DeclaredHandlersTupleInvocationHandler(ProxyInterfaceWithContainerAnnotation.class);
    assertThat(
        handler.handles(
            Tuple.of(), invocation(ProxyInterfaceWithContainerAnnotation.class, "getX")),
        is(true));
    assertThat(
        handler.handles(
            Tuple.of(), invocation(ProxyInterfaceWithContainerAnnotation.class, "getY")),
        is(false));
  }

  @Test
  public void testHandleForContainerAnnotation() throws Throwable {
    DeclaredHandlersTupleInvocationHandler handler =
        new DeclaredHandlersTupleInvocationHandler(ProxyInterfaceWithContainerAnnotation.class);
    assertThat(
        handler.handle(Tuple.of(), invocation(ProxyInterfaceWithContainerAnnotation.class, "getX")),
        is(10));
  }

  @Test
  public void testHandlesForReferencingAnnotation() throws Exception {
    DeclaredHandlersTupleInvocationHandler handler =
        new DeclaredHandlersTupleInvocationHandler(ProxyInterfaceWithReferencingAnnotation.class);
    assertThat(
        handler.handles(
            Tuple.of(), invocation(ProxyInterfaceWithReferencingAnnotation.class, "getX")),
        is(true));
    assertThat(
        handler.handles(
            Tuple.of(), invocation(ProxyInterfaceWithReferencingAnnotation.class, "getY")),
        is(true));
  }

  @Test
  public void testHandleForReferencingAnnotation() throws Throwable {
    DeclaredHandlersTupleInvocationHandler handler =
        new DeclaredHandlersTupleInvocationHandler(ProxyInterfaceWithReferencingAnnotation.class);
    assertThat(
        handler.handle(
            Tuple.of(), invocation(ProxyInterfaceWithReferencingAnnotation.class, "getX")),
        is(10));
    assertThat(
        handler.handle(
            Tuple.of(), invocation(ProxyInterfaceWithReferencingAnnotation.class, "getY")),
        is("10"));
  }

  @Test
  public void testHandlesForInheritedAnnotation() throws Exception {
    DeclaredHandlersTupleInvocationHandler handler =
        new DeclaredHandlersTupleInvocationHandler(ProxyInterfaceWithInheritedAnnotation.class);
    assertThat(
        handler.handles(
            Tuple.of(), invocation(ProxyInterfaceWithInheritedAnnotation.class, "getX")),
        is(true));
    assertThat(
        handler.handles(
            Tuple.of(), invocation(ProxyInterfaceWithInheritedAnnotation.class, "getY")),
        is(true));
  }

  @Test
  public void testHandleForInheritedAnnotation() throws Throwable {
    DeclaredHandlersTupleInvocationHandler handler =
        new DeclaredHandlersTupleInvocationHandler(ProxyInterfaceWithInheritedAnnotation.class);
    assertThat(
        handler.handle(Tuple.of(), invocation(ProxyInterfaceWithInheritedAnnotation.class, "getX")),
        is(10));
    assertThat(
        handler.handle(Tuple.of(), invocation(ProxyInterfaceWithInheritedAnnotation.class, "getY")),
        is("10"));
  }

  private ImmutableMethodInvocation invocation(final Class<?> proxyType, final String method)
      throws NoSuchMethodException {
    return new ImmutableMethodInvocation(
        Object.class, new Object[] {10}, proxyType.getDeclaredMethod(method, int.class), proxyType);
  }

  @SuppressWarnings("unused")
  @WithHandler(HandlerForX.class)
  private interface ProxyInterfaceWithSimpleAnnotation {

    int getX(int x);

    String getY(int y);
  }

  @SuppressWarnings("unused")
  @WithHandler(HandlerForX.class)
  @WithHandler(HandlerForY.class)
  private interface ProxyInterfaceWithRepeatedAnnotation {

    int getX(int x);

    String getY(int y);
  }

  @WithHandlers({@WithHandler(HandlerForX.class)})
  private interface ProxyInterfaceWithContainerAnnotation {

    int getX(int x);

    String getY(int y);
  }

  @SampleHandled
  private interface ProxyInterfaceWithReferencingAnnotation {

    int getX(int x);

    String getY(int y);
  }

  @SampleHandled
  private interface HandlerDefiningInterface {}

  private interface ProxyInterfaceWithInheritedAnnotation extends HandlerDefiningInterface {
    int getX(int x);

    String getY(int y);
  }

  private static class HandlerForX implements TupleInvocationHandler {

    @Override
    public boolean handles(final Tuple<?> tuple, final MethodInvocation invocation) {
      return invocation.method().getName().endsWith("X") && invocation.arguments().length == 1;
    }

    @Override
    public Object handle(final Tuple<?> tuple, final MethodInvocation invocation) {
      return invocation.arguments()[0];
    }
  }

  private static class HandlerForY implements TupleInvocationHandler {

    @Override
    public boolean handles(final Tuple<?> tuple, final MethodInvocation invocation) {
      return invocation.method().getName().contains("Y") && invocation.arguments().length == 1;
    }

    @Override
    public Object handle(final Tuple<?> tuple, final MethodInvocation invocation) {
      return String.valueOf(invocation.arguments()[0]);
    }
  }

  @WithHandler(HandlerForX.class)
  @WithHandler(HandlerForY.class)
  @Retention(RetentionPolicy.RUNTIME)
  @Target(ElementType.TYPE)
  private @interface SampleHandled {}
}

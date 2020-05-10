package com.mmnaseri.utils.tuples.reflection.impl;

import com.mmnaseri.utils.tuples.Tuple;
import com.mmnaseri.utils.tuples.reflection.MethodInvocation;
import com.mmnaseri.utils.tuples.reflection.TupleInvocationHandler;

import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/** A handler that can call to a default method implemented on an interface. */
public class InterfaceDefaultMethodTupleInvocationHandler implements TupleInvocationHandler {

  @Override
  public boolean handles(final Tuple<?> tuple, final MethodInvocation invocation) {
    return invocation.method().isDefault();
  }

  @Override
  public Object handle(final Tuple<?> tuple, final MethodInvocation invocation) throws Throwable {
    return callDefaultMethod(invocation);
  }

  private Object callDefaultMethod(final MethodInvocation invocation) throws Throwable {
    try {
      return callDefaultMethodWithLookup(defaultLookup(), invocation);
    } catch (IllegalAccessException e) {
      if (e.getMessage().matches(".*no private access for invokespecial.*")) {
        return tryWithAccessibleLookup(invocation);
      }
      throw e;
    }
  }

  private Object tryWithAccessibleLookup(final MethodInvocation invocation) throws Throwable {
    try {
      return callDefaultMethodWithLookup(accessibleLookup(invocation), invocation);
    } catch (Throwable throwable) {
      if (throwable.getClass().getName().equals("java.lang.reflect.InaccessibleObjectException")) {
        return tryWithPrivateLookup(invocation);
      }
      throw throwable;
    }
  }

  private Object tryWithPrivateLookup(final MethodInvocation invocation) throws Throwable {
    return callDefaultMethodWithLookup(privateLookup(invocation), invocation);
  }

  private MethodHandles.Lookup privateLookup(final MethodInvocation invocation)
      throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
    Method privateLookupIn =
        MethodHandles.class.getDeclaredMethod(
            "privateLookupIn", Class.class, MethodHandles.Lookup.class);
    return (MethodHandles.Lookup)
        privateLookupIn.invoke(
            null, invocation.method().getDeclaringClass(), MethodHandles.lookup());
  }

  private Object callDefaultMethodWithLookup(
      MethodHandles.Lookup lookup, MethodInvocation invocation) throws Throwable {
    try {
      return lookup
          .in(invocation.method().getDeclaringClass())
          .unreflectSpecial(invocation.method(), invocation.instance().getClass())
          .bindTo(invocation.instance())
          .invokeWithArguments(invocation.arguments());
    } catch (IllegalAccessException exception) {
      if (exception.getMessage().contains("no private access for invokespecial")) {
        return lookup
            .findSpecial(
                invocation.method().getDeclaringClass(),
                invocation.method().getName(),
                MethodType.methodType(
                    invocation.method().getReturnType(), invocation.method().getParameterTypes()),
                invocation.method().getDeclaringClass())
            .bindTo(invocation.instance())
            .invokeWithArguments(invocation.arguments());
      } else {
        throw exception;
      }
    }
  }

  private static MethodHandles.Lookup defaultLookup() {
    return MethodHandles.lookup();
  }

  private static MethodHandles.Lookup accessibleLookup(MethodInvocation invocation)
      throws NoSuchMethodException, IllegalAccessException, InvocationTargetException,
          InstantiationException {
    Constructor<MethodHandles.Lookup> constructor =
        MethodHandles.Lookup.class.getDeclaredConstructor(Class.class);
    constructor.setAccessible(true);
    return constructor.newInstance(invocation.method().getDeclaringClass());
  }
}

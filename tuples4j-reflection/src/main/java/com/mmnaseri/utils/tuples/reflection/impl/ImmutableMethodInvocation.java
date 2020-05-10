package com.mmnaseri.utils.tuples.reflection.impl;

import com.mmnaseri.utils.tuples.reflection.MethodInvocation;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Objects;

/** The default method invocation instance. */
public class ImmutableMethodInvocation implements MethodInvocation {

  private final Object instance;
  private final Object[] arguments;
  private final Method method;
  private final Class<?> type;

  public ImmutableMethodInvocation(
      final Object instance, final Object[] arguments, final Method method, final Class<?> type) {
    this.instance = instance;
    this.arguments = arguments == null ? new Object[0] : Arrays.copyOf(arguments, arguments.length);
    this.method = method;
    this.type = type;
  }

  @Override
  public Object instance() {
    return instance;
  }

  @Override
  public Object[] arguments() {
    return Arrays.copyOf(arguments, arguments.length);
  }

  @Override
  public Method method() {
    return method;
  }

  @Override
  public Class<?> type() {
    return type;
  }

  @Override
  public String toString() {
    return "ImmutableMethodInvocation{"
        + "instance="
        + instance
        + ", arguments="
        + Arrays.toString(arguments)
        + ", method="
        + method
        + ", type="
        + type
        + '}';
  }

  @Override
  public boolean equals(final Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    final ImmutableMethodInvocation that = (ImmutableMethodInvocation) o;
    return Objects.equals(instance, that.instance)
        && Arrays.equals(arguments, that.arguments)
        && Objects.equals(method, that.method)
        && Objects.equals(type, that.type);
  }

  @Override
  public int hashCode() {
    int result = Objects.hash(instance, method, type);
    result = 31 * result + Arrays.hashCode(arguments);
    return result;
  }
}

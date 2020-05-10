package com.mmnaseri.utils.tuples.reflection;

import java.lang.reflect.Method;

/** Represents a method invocation. */
public interface MethodInvocation {

  /**
   * The instance on which the method is invoked. This is the {@code this} in the context of the
   * call.
   */
  Object instance();

  /** The arguments passed to the method call. */
  Object[] arguments();

  /** The method being invoked. */
  Method method();
}

package com.mmnaseri.utils.tuples.annotations;

import com.mmnaseri.utils.tuples.reflection.TupleInvocationHandler;

import java.lang.annotation.ElementType;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Indicates that the provided method handler should be used in conjunction with the rest of the
 * method handlers when considering methods of the annotated proxy interface.
 */
@Repeatable(WithHandlers.class)
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface WithHandler {

  /** The type of the value handler for this interface. */
  Class<? extends TupleInvocationHandler> value();
}

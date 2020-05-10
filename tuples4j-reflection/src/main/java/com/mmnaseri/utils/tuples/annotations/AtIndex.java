package com.mmnaseri.utils.tuples.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Indicates that the method's value should be retrieved from the element at the given index.
 *
 * @see #value()
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface AtIndex {

  /** The element index to which this method should be bound. */
  int value();
}

package com.mmnaseri.utils.tuples.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Indicates that the annotated method should be mapped to an element with the given label.
 *
 * @see #value()
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface WithLabel {

  /** The label associated with the method. */
  String value();
}

package com.mmnaseri.utils.tuples.annotations;

import com.mmnaseri.utils.tuples.reflection.type.ElementValueProvider;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Indicates that the value of the annotated method should be read from the indicated {@link
 * ElementValueProvider}.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Provided {

  /** The provider to be used for this method. */
  Class<? extends ElementValueProvider> by();
}

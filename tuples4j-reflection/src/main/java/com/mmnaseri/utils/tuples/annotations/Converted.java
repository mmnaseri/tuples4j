package com.mmnaseri.utils.tuples.annotations;

import com.mmnaseri.utils.tuples.reflection.type.ElementConverter;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Used to indicate that a converter should be used to convert the value from the tuple to the
 * return type of the method annotated.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Converted {

  /**
   * The converter that should be used to convert the value read from the tuple to the value
   * returned by the method.
   */
  Class<? extends ElementConverter<?>> value();
}

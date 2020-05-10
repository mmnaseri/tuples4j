package com.mmnaseri.utils.tuples.annotations;

import com.mmnaseri.utils.tuples.reflection.type.ElementConverter;

/**
 * Used to indicate that a converter should be used to convert the value from the tuple to the
 * return type of the method annotated.
 */
public @interface Converted {

  /**
   * The converter that should be used to convert the value read from the tuple to the value
   * returned by the method.
   */
  Class<? extends ElementConverter<?>> value();
}

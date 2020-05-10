package com.mmnaseri.utils.tuples.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Indicates that the provided handlers should be used.
 *
 * @see WithHandler
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface WithHandlers {

  WithHandler[] value();
}

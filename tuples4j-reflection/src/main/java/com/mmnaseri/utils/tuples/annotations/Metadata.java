package com.mmnaseri.utils.tuples.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Annotation indicating that the annotated method or any annotation used that has been in turn
 * annotated with this annotation should not be taken into consideration when processing the proxy
 * instances for equality, hash code generation, or other such operations.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.ANNOTATION_TYPE})
public @interface Metadata {}

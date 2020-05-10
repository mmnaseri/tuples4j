package com.mmnaseri.utils.tuples;

import com.mmnaseri.utils.tuples.reflection.InvocationElementResolver;
import com.mmnaseri.utils.tuples.reflection.InvocationElementResolverFactory;
import com.mmnaseri.utils.tuples.reflection.impl.AnnotationInvocationElementResolverFactory;

/**
 * An entity which is capable of creating tuples that can reflectively create object instances.
 *
 * @author Milad Naseri (m.m.naseri@gmail.com)
 */
public interface Reflector {

  /**
   * Returns an instance of the given type, using the provided method resolver and this tuple's
   * data.
   */
  <O> O as(Class<O> type, InvocationElementResolver resolver);

  /**
   * Returns an instance of the given type with this tuple's data as the backing source, and the
   * {@link AnnotationInvocationElementResolverFactory} factory.
   */
  default <O> O as(Class<O> type) {
    return as(type, AnnotationInvocationElementResolverFactory.getInstance());
  }

  /**
   * Returns an instance of the given type with this tuple's data and an instance of the provided
   * resovler factory for data resolution.
   */
  default <O> O as(Class<O> type, InvocationElementResolverFactory resolverFactory) {
    return as(type, resolverFactory.create());
  }
}

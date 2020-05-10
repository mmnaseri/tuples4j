package com.mmnaseri.utils.tuples.reflection.impl;

import com.mmnaseri.utils.tuples.reflection.InvocationElementResolver;
import com.mmnaseri.utils.tuples.reflection.InvocationElementResolverFactory;

/** Factory that creates instances of {@link AnnotationInvocationElementResolver}. */
public class AnnotationInvocationElementResolverFactory
    implements InvocationElementResolverFactory {

  private static final AnnotationInvocationElementResolverFactory INSTANCE =
      new AnnotationInvocationElementResolverFactory();

  @Override
  public InvocationElementResolver create() {
    return new AnnotationInvocationElementResolver();
  }

  /** Returns the default singleton instance for this factory. */
  public static AnnotationInvocationElementResolverFactory getInstance() {
    return INSTANCE;
  }
}

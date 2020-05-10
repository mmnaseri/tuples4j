package com.mmnaseri.utils.tuples.reflection.impl;

import com.mmnaseri.utils.tuples.Tuple;
import com.mmnaseri.utils.tuples.annotations.Provided;
import com.mmnaseri.utils.tuples.reflection.MethodInvocation;
import com.mmnaseri.utils.tuples.reflection.TupleInvocationHandler;
import com.mmnaseri.utils.tuples.reflection.type.ElementValueProvider;
import com.mmnaseri.utils.tuples.reflection.type.ElementValueProviderRegistry;

/** Handles methods which are annotated with {@link Provided} */
public class ProvidedMethodTupleInvocationHandler implements TupleInvocationHandler {

  @Override
  public boolean handles(final Tuple<?> tuple, final MethodInvocation invocation) {
    return TupleProxyUtils.hasAnnotation(Provided.class, invocation.method());
  }

  @Override
  public Object handle(final Tuple<?> tuple, final MethodInvocation invocation) throws Throwable {
    Provided provided = TupleProxyUtils.getAnnotation(Provided.class, invocation.method());
    Class<? extends ElementValueProvider> providerType = provided.by();
    ElementValueProvider provider =
        ElementValueProviderRegistry.defaultRegistry().get(providerType);
    return provider.handle(tuple, invocation);
  }
}

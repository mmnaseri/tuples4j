package com.mmnaseri.utils.tuples.reflection.impl;

import com.mmnaseri.utils.tuples.LabeledTuple;
import com.mmnaseri.utils.tuples.Tuple;
import com.mmnaseri.utils.tuples.annotations.AtIndex;
import com.mmnaseri.utils.tuples.annotations.WithLabel;
import com.mmnaseri.utils.tuples.reflection.MethodInvocation;
import com.mmnaseri.utils.tuples.reflection.InvocationElementResolver;

/**
 * A method element resolver that uses the annotations found in {@link
 * com.mmnaseri.utils.tuples.annotations} to resolve the element index bound to the provided method.
 */
public class AnnotationInvocationElementResolver implements InvocationElementResolver {

  @Override
  public int resolve(final Tuple<?> tuple, final MethodInvocation invocation) {
    if (invocation.method().isAnnotationPresent(AtIndex.class)) {
      return invocation.method().getAnnotation(AtIndex.class).value();
    }
    if (invocation.method().isAnnotationPresent(WithLabel.class)) {
      if (!(tuple instanceof LabeledTuple<?>)) {
        throw new IllegalStateException(
            "Method "
                + invocation.method().getName()
                + " is annotated with @WithLabel, however, the reference tuple does not have labels.");
      }
      WithLabel withLabel = invocation.method().getAnnotation(WithLabel.class);
      String label = withLabel.value();
      return ((LabeledTuple<?>) tuple).labels().indexOf(label);
    }
    if (tuple instanceof LabeledTuple<?>) {
      return ((LabeledTuple<?>) tuple).labels().indexOf(invocation.method().getName());
    }
    return -1;
  }
}

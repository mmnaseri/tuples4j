package com.mmnaseri.utils.tuples;

import com.mmnaseri.utils.tuples.impl.EmptyTuple;

import java.util.function.Function;

/**
 * Base interface for a tuple that has a size within the range of 1-12.
 *
 * @author Milad Naseri (m.m.naseri@gmail.com)
 */
public interface FixedTuple<Z, T extends FixedTuple<Z, T>> extends Tuple<Z> {

  /** Returns an {@link EmptyTuple}. */
  @Override
  default EmptyTuple<Z> clear() {
    return EmptyTuple.of();
  }

  /**
   * Extends the current tuple by applying the provided function to it and appending the resulting
   * value to the end of this tuple.
   */
  <X extends Z> Tuple<Z> extend(Function<T, X> function);

  /**
   * Returns a new tuple that changes the value of the element at the given index by applying the
   * provided function to the current tuple.
   */
  Tuple<Z> change(int index, Function<T, ? extends Z> function);
}

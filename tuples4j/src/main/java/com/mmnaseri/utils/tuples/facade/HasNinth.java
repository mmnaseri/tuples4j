package com.mmnaseri.utils.tuples.facade;

import com.mmnaseri.utils.tuples.FixedTuple;
import com.mmnaseri.utils.tuples.Tuple;

import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * Defines methods that work with the ninth element of a {@link FixedTuple}.
 *
 * @param <Z> the super-type of the tuple's main data type.
 * @param <A> the type of the object at the ninth position.
 * @param <T> the concrete type of the fixed-size tuple.
 * @author Milad Naseri (m.m.naseri@gmail.com)
 */
public interface HasNinth<Z, A extends Z, T extends HasNinth<Z, A, T>> extends FixedTuple<Z, T> {

  /** Returns the ninth element in the current tuple. */
  @SuppressWarnings("unchecked")
  default A ninth() {
    return (A) get(8);
  }

  /** Sets the ninth element of the tuple to the indicated value. */
  <X extends Z> Tuple<Z> ninth(X value);

  /** Sets the ninth element of the tuple to the supplied value. */
  <X extends Z> Tuple<Z> ninth(Supplier<X> supplier);

  /** Sets the ninth element of the tuple to the value returned from the function. */
  <X extends Z> Tuple<Z> ninth(Function<A, X> function);

  /** Drops the ninth element of the tuple, to return a tuple of one size smaller. */
  Tuple<Z> dropNinth();

  /** Checks to see if the ninth element of this tuple matches the given predicate. */
  default boolean checkNinth(Predicate<A> predicate) {
    return predicate.test(ninth());
  }
}

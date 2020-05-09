package com.mmnaseri.utils.tuples.facade;

import com.mmnaseri.utils.tuples.FixedTuple;
import com.mmnaseri.utils.tuples.Tuple;

import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * Defines methods that work with the third element of a {@link FixedTuple}.
 *
 * @param <Z> the super-type of the tuple's main data type.
 * @param <A> the type of the object at the third position.
 * @param <T> the concrete type of the fixed-size tuple.
 * @author Milad Naseri (m.m.naseri@gmail.com)
 */
public interface HasThird<Z, A extends Z, T extends HasThird<Z, A, T>> extends FixedTuple<Z, T> {

  /** Returns the third element in the current tuple. */
  @SuppressWarnings("unchecked")
  default A third() {
    return (A) get(2);
  }

  /** Sets the third element of the tuple to the indicated value. */
  <X extends Z> Tuple<Z> third(X value);

  /** Sets the third element of the tuple to the supplied value. */
  <X extends Z> Tuple<Z> third(Supplier<X> supplier);

  /** Sets the third element of the tuple to the value returned from the function. */
  <X extends Z> Tuple<Z> third(Function<A, X> function);

  /** Drops the third element of the tuple, to return a tuple of one size smaller. */
  Tuple<Z> dropThird();

  /** Checks to see if the third element of this tuple matches the given predicate. */
  default boolean checkThird(Predicate<A> predicate) {
    return predicate.test(third());
  }
}

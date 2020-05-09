package com.mmnaseri.utils.tuples.facade;

import com.mmnaseri.utils.tuples.FixedTuple;
import com.mmnaseri.utils.tuples.Tuple;

import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * Defines methods that work with the fourth element of a {@link FixedTuple}.
 *
 * @param <Z> the super-type of the tuple's main data type.
 * @param <A> the type of the object at the fourth position.
 * @param <T> the concrete type of the fixed-size tuple.
 * @author Milad Naseri (m.m.naseri@gmail.com)
 */
public interface HasFourth<Z, A extends Z, T extends HasFourth<Z, A, T>> extends FixedTuple<Z, T> {

  /** Returns the fourth element in the current tuple. */
  @SuppressWarnings("unchecked")
  default A fourth() {
    return (A) get(3);
  }

  /** Sets the fourth element of the tuple to the indicated value. */
  <X extends Z> Tuple<Z> fourth(X value);

  /** Sets the fourth element of the tuple to the supplied value. */
  <X extends Z> Tuple<Z> fourth(Supplier<X> supplier);

  /** Sets the fourth element of the tuple to the value returned from the function. */
  <X extends Z> Tuple<Z> fourth(Function<A, X> function);

  /** Drops the fourth element of the tuple, to return a tuple of one size smaller. */
  Tuple<Z> dropFourth();

  /** Checks to see if the fourth element of this tuple matches the given predicate. */
  default boolean checkFourth(Predicate<A> predicate) {
    return predicate.test(fourth());
  }
}

package com.mmnaseri.utils.tuples.facade;

import com.mmnaseri.utils.tuples.FixedTuple;
import com.mmnaseri.utils.tuples.Tuple;

import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * Defines methods that work with the eleventh element of a {@link FixedTuple}.
 *
 * @param <Z> the super-type of the tuple's main data type.
 * @param <A> the type of the object at the eleventh position.
 * @param <T> the concrete type of the fixed-size tuple.
 * @author Milad Naseri (m.m.naseri@gmail.com)
 */
public interface HasEleventh<Z, A extends Z, T extends HasEleventh<Z, A, T>>
    extends FixedTuple<Z, T> {

  /** Returns the eleventh element in the current tuple. */
  @SuppressWarnings("unchecked")
  default A eleventh() {
    return (A) get(10);
  }

  /** Sets the eleventh element of the tuple to the indicated value. */
  <X extends Z> Tuple<Z> eleventh(X value);

  /** Sets the eleventh element of the tuple to the supplied value. */
  <X extends Z> Tuple<Z> eleventh(Supplier<X> supplier);

  /** Sets the eleventh element of the tuple to the value returned from the function. */
  <X extends Z> Tuple<Z> eleventh(Function<A, X> function);

  /** Drops the eleventh element of the tuple, to return a tuple of one size smaller. */
  Tuple<Z> dropEleventh();

  /** Checks to see if the eleventh element of this tuple matches the given predicate. */
  default boolean checkEleventh(Predicate<A> predicate) {
    return predicate.test(eleventh());
  }
}

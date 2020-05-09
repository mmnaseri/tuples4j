package com.mmnaseri.utils.tuples.facade;

import com.mmnaseri.utils.tuples.FixedTuple;
import com.mmnaseri.utils.tuples.Tuple;

import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * Defines methods that work with the eighth element of a {@link FixedTuple}.
 *
 * @param <Z> the super-type of the tuple's main data type.
 * @param <A> the type of the object at the eighth position.
 * @param <T> the concrete type of the fixed-size tuple.
 * @author Milad Naseri (m.m.naseri@gmail.com)
 */
public interface HasEighth<Z, A extends Z, T extends HasEighth<Z, A, T>> extends FixedTuple<Z, T> {

  /** Returns the eighth element in the current tuple. */
  @SuppressWarnings("unchecked")
  default A eighth() {
    return (A) get(7);
  }

  /** Sets the eighth element of the tuple to the indicated value. */
  <X extends Z> Tuple<Z> eighth(X value);

  /** Sets the eighth element of the tuple to the supplied value. */
  <X extends Z> Tuple<Z> eighth(Supplier<X> supplier);

  /** Sets the eighth element of the tuple to the value returned from the function. */
  <X extends Z> Tuple<Z> eighth(Function<A, X> function);

  /** Drops the eighth element of the tuple, to return a tuple of one size smaller. */
  Tuple<Z> dropEighth();

  /** Checks to see if the eighth element of this tuple matches the given predicate. */
  default boolean checkEighth(Predicate<A> predicate) {
    return predicate.test(eighth());
  }
}

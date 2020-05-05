package com.mmnaseri.utils.tuples.facade;

import com.mmnaseri.utils.tuples.FixedTuple;
import com.mmnaseri.utils.tuples.Tuple;

import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * Defines methods that work with the first element of a {@link FixedTuple}.
 *
 * @param <Z> the super-type of the tuple's main data type.
 * @param <A> the type of the object at the first position.
 * @param <T> the concrete type of the fixed-size tuple.
 * @author Milad Naseri (m.m.naseri@gmail.com)
 */
public interface HasFirst<Z, A extends Z, T extends HasFirst<Z, A, T>>
        extends
        FixedTuple<Z, T> {

    /**
     * Returns the first element in the current tuple.
     */
    @SuppressWarnings("unchecked")
    default A first() {
        return (A) get(0);
    }

    /**
     * Sets the first element of the tuple to the indicated value.
     */
    <X extends Z> Tuple<Z> first(X value);

    /**
     * Sets the first element of the tuple to the supplied value.
     */
    <X extends Z> Tuple<Z> first(Supplier<X> supplier);

    /**
     * Sets the first element of the tuple to the value returned from the function.
     */
    <X extends Z> Tuple<Z> first(Function<A, X> function);

    /**
     * Drops the first element of the tuple, to return a tuple of one size smaller.
     */
    Tuple<Z> dropFirst();

    /**
     * Checks to see if the first element of this tuple matches the given predicate.
     */
    default boolean checkFirst(Predicate<A> predicate) {
        return predicate.test(first());
    }

}


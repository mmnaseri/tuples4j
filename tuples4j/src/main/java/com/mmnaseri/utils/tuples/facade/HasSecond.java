package com.mmnaseri.utils.tuples.facade;

import com.mmnaseri.utils.tuples.FixedTuple;
import com.mmnaseri.utils.tuples.Tuple;

import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * Defines methods that work with the second element of a {@link FixedTuple}.
 *
 * @param <Z> the super-type of the tuple's main data type.
 * @param <A> the type of the object at the second position.
 * @param <T> the concrete type of the fixed-size tuple.
 * @author Milad Naseri (m.m.naseri@gmail.com)
 */
public interface HasSecond<Z, A extends Z, T extends HasSecond<Z, A, T>>
        extends
        FixedTuple<Z, T> {

    /**
     * Returns the second element in the current tuple.
     */
    @SuppressWarnings("unchecked")
    default A second() {
        return (A) get(1);
    }

    /**
     * Sets the second element of the tuple to the indicated value.
     */
    <X extends Z> Tuple<Z> second(X value);

    /**
     * Sets the second element of the tuple to the supplied value.
     */
    <X extends Z> Tuple<Z> second(Supplier<X> supplier);

    /**
     * Sets the second element of the tuple to the value returned from the function.
     */
    <X extends Z> Tuple<Z> second(Function<A, X> function);

    /**
     * Drops the second element of the tuple, to return a tuple of one size smaller.
     */
    Tuple<Z> dropSecond();

    /**
     * Checks to see if the second element of this tuple matches the given predicate.
     */
    default boolean checkSecond(Predicate<A> predicate) {
        return predicate.test(second());
    }

}


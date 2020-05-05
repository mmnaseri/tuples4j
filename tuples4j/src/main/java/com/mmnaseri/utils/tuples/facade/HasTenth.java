package com.mmnaseri.utils.tuples.facade;

import com.mmnaseri.utils.tuples.FixedTuple;
import com.mmnaseri.utils.tuples.Tuple;

import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * Defines methods that work with the tenth element of a {@link FixedTuple}.
 *
 * @param <Z> the super-type of the tuple's main data type.
 * @param <A> the type of the object at the tenth position.
 * @param <T> the concrete type of the fixed-size tuple.
 * @author Milad Naseri (m.m.naseri@gmail.com)
 */
public interface HasTenth<Z, A extends Z, T extends HasTenth<Z, A, T>>
        extends
        FixedTuple<Z, T> {

    /**
     * Returns the tenth element in the current tuple.
     */
    @SuppressWarnings("unchecked")
    default A tenth() {
        return (A) get(9);
    }

    /**
     * Sets the tenth element of the tuple to the indicated value.
     */
    <X extends Z> Tuple<Z> tenth(X value);

    /**
     * Sets the tenth element of the tuple to the supplied value.
     */
    <X extends Z> Tuple<Z> tenth(Supplier<X> supplier);

    /**
     * Sets the tenth element of the tuple to the value returned from the function.
     */
    <X extends Z> Tuple<Z> tenth(Function<A, X> function);

    /**
     * Drops the tenth element of the tuple, to return a tuple of one size smaller.
     */
    Tuple<Z> dropTenth();

    /**
     * Checks to see if the tenth element of this tuple matches the given predicate.
     */
    default boolean checkTenth(Predicate<A> predicate) {
        return predicate.test(tenth());
    }

}


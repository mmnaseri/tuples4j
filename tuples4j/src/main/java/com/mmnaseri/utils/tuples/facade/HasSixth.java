package com.mmnaseri.utils.tuples.facade;

import com.mmnaseri.utils.tuples.FixedTuple;
import com.mmnaseri.utils.tuples.Tuple;

import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * Defines methods that work with the sixth element of a {@link FixedTuple}.
 *
 * @param <Z> the super-type of the tuple's main data type.
 * @param <A> the type of the object at the sixth position.
 * @param <T> the concrete type of the fixed-size tuple.
 * @author Milad Naseri (m.m.naseri@gmail.com)
 */
public interface HasSixth<Z, A extends Z, T extends HasSixth<Z, A, T>>
        extends
        FixedTuple<Z, T> {

    /**
     * Returns the sixth element in the current tuple.
     */
    @SuppressWarnings("unchecked")
    default A sixth() {
        return (A) get(5);
    }

    /**
     * Sets the sixth element of the tuple to the indicated value.
     */
    <X extends Z> Tuple<Z> sixth(X value);

    /**
     * Sets the sixth element of the tuple to the supplied value.
     */
    <X extends Z> Tuple<Z> sixth(Supplier<X> supplier);

    /**
     * Sets the sixth element of the tuple to the value returned from the function.
     */
    <X extends Z> Tuple<Z> sixth(Function<A, X> function);

    /**
     * Drops the sixth element of the tuple, to return a tuple of one size smaller.
     */
    Tuple<Z> dropSixth();

    /**
     * Checks to see if the sixth element of this tuple matches the given predicate.
     */
    default boolean checkSixth(Predicate<A> predicate) {
        return predicate.test(sixth());
    }

}


package com.mmnaseri.utils.tuples.facade;

import com.mmnaseri.utils.tuples.FixedTuple;
import com.mmnaseri.utils.tuples.Tuple;

import java.util.function.Predicate;

public interface HasSeventh<Z, T extends FixedTuple<Z, T>, A extends Z> extends FixedTuple<Z, T> {

    @SuppressWarnings("unchecked")
    default A seventh() {
        return (A) get(7);
    }

    default T seventh(A value) {
        return change(0, value);
    }

    Tuple<Z> dropSeventh();


    default boolean checkSeventh(Predicate<A> predicate) {
        return predicate.test(seventh());
    }

}

package com.mmnaseri.utils.tuples.facade;

import com.mmnaseri.utils.tuples.FixedTuple;
import com.mmnaseri.utils.tuples.Tuple;

import java.util.function.Predicate;

public interface HasTenth<Z, T extends FixedTuple<Z, T>, A extends Z> extends FixedTuple<Z, T> {

    @SuppressWarnings("unchecked")
    default A tenth() {
        return (A) get(9);
    }

    default T tenth(A value) {
        return change(0, value);
    }

    Tuple<Z> dropTenth();


    default boolean checkTenth(Predicate<A> predicate) {
        return predicate.test(tenth());
    }

}

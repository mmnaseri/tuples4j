package com.mmnaseri.utils.tuples.facade;

import com.mmnaseri.utils.tuples.FixedTuple;
import com.mmnaseri.utils.tuples.Tuple;

import java.util.function.Predicate;

public interface HasFirst<Z, T extends FixedTuple<Z, T>, A extends Z> extends FixedTuple<Z, T> {

    @SuppressWarnings("unchecked")
    default A first() {
        return (A) get(0);
    }

    default T first(A value) {
        return change(0, value);
    }

    Tuple<Z> dropFirst();


    default boolean checkFirst(Predicate<A> predicate) {
        return predicate.test(first());
    }

}
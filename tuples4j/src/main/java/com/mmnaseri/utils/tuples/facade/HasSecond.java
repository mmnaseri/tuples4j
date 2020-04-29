package com.mmnaseri.utils.tuples.facade;

import com.mmnaseri.utils.tuples.FixedTuple;
import com.mmnaseri.utils.tuples.Tuple;

import java.util.function.Predicate;

public interface HasSecond<Z, T extends FixedTuple<Z, T>, A extends Z> extends FixedTuple<Z, T> {

    @SuppressWarnings("unchecked")
    default A second() {
        return (A) get(1);
    }

    default T second(A value) {
        return change(0, value);
    }

    Tuple<Z> dropSecond();


    default boolean checkSecond(Predicate<A> predicate) {
        return predicate.test(second());
    }

}

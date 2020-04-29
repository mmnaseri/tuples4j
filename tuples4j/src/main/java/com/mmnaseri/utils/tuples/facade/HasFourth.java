package com.mmnaseri.utils.tuples.facade;

import com.mmnaseri.utils.tuples.FixedTuple;
import com.mmnaseri.utils.tuples.Tuple;

import java.util.function.Predicate;

public interface HasFourth<Z, T extends FixedTuple<Z, T>, A extends Z> extends FixedTuple<Z, T> {

    @SuppressWarnings("unchecked")
    default A fourth() {
        return (A) get(3);
    }

    default T fourth(A value) {
        return change(0, value);
    }

    Tuple<Z> dropFourth();


    default boolean checkFourth(Predicate<A> predicate) {
        return predicate.test(fourth());
    }

}

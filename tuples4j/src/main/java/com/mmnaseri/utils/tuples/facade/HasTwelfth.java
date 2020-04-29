package com.mmnaseri.utils.tuples.facade;

import com.mmnaseri.utils.tuples.FixedTuple;
import com.mmnaseri.utils.tuples.Tuple;

import java.util.function.Predicate;

public interface HasTwelfth<Z, T extends FixedTuple<Z, T>, A extends Z> extends FixedTuple<Z, T> {

    @SuppressWarnings("unchecked")
    default A twelfth() {
        return (A) get(11);
    }

    default T twelfth(A value) {
        return change(0, value);
    }

    Tuple<Z> dropTwelfth();


    default boolean checkTwelfth(Predicate<A> predicate) {
        return predicate.test(twelfth());
    }

}

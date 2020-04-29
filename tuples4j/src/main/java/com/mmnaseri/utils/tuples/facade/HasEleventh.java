package com.mmnaseri.utils.tuples.facade;

import com.mmnaseri.utils.tuples.FixedTuple;
import com.mmnaseri.utils.tuples.Tuple;

import java.util.function.Predicate;

public interface HasEleventh<Z, T extends FixedTuple<Z, T>, A extends Z> extends FixedTuple<Z, T> {

    @SuppressWarnings("unchecked")
    default A eleventh() {
        return (A) get(10);
    }

    default T eleventh(A value) {
        return change(0, value);
    }

    Tuple<Z> dropEleventh();


    default boolean checkEleventh(Predicate<A> predicate) {
        return predicate.test(eleventh());
    }

    static <Z, T extends FixedTuple<Z, T>, A extends Z> Predicate<HasEleventh<Z, T, A>> matchingEleventh(
            Predicate<A> predicate) {
        return tuple -> predicate.test(tuple.eleventh());
    }
}

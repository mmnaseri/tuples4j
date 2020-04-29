package com.mmnaseri.utils.tuples.facade;

import com.mmnaseri.utils.tuples.FixedTuple;
import com.mmnaseri.utils.tuples.Tuple;

import java.util.function.Predicate;

public interface HasNinth<Z, T extends FixedTuple<Z, T>, A extends Z> extends FixedTuple<Z, T> {

    @SuppressWarnings("unchecked")
    default A ninth() {
        return (A) get(8);
    }

    default T ninth(A value) {
        return change(0, value);
    }

    Tuple<Z> dropNinth();


    default Predicate<? extends HasNinth<Z, T, A>> checkNinth(Predicate<A> predicate) {
        return tuple -> predicate.test(ninth());
    }

    static <Z, T extends FixedTuple<Z, T>, A extends Z> Predicate<? extends HasNinth<Z, T, A>> matchingNinth(
            Predicate<A> predicate) {
        return tuple -> predicate.test(tuple.ninth());
    }
}

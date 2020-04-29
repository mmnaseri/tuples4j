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


    default Predicate<? extends HasFirst<Z, T, A>> checkFirst(Predicate<A> predicate) {
        return tuple -> predicate.test(first());
    }

    static <Z, T extends FixedTuple<Z, T>, A extends Z> Predicate<? extends HasFirst<Z, T, A>> matchingFirst(
            Predicate<A> predicate) {
        return tuple -> predicate.test(tuple.first());
    }
}
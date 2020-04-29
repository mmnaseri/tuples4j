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


    default Predicate<? extends HasSecond<Z, T, A>> checkSecond(Predicate<A> predicate) {
        return tuple -> predicate.test(second());
    }

    static <Z, T extends FixedTuple<Z, T>, A extends Z> Predicate<? extends HasSecond<Z, T, A>> matchingSecond(
            Predicate<A> predicate) {
        return tuple -> predicate.test(tuple.second());
    }
}

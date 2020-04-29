package com.mmnaseri.utils.tuples.facade;

import com.mmnaseri.utils.tuples.FixedTuple;
import com.mmnaseri.utils.tuples.Tuple;

import java.util.function.Predicate;

public interface HasThird<Z, T extends FixedTuple<Z, T>, A extends Z> extends FixedTuple<Z, T> {

    @SuppressWarnings("unchecked")
    default A third() {
        return (A) get(2);
    }

    default T third(A value) {
        return change(0, value);
    }

    Tuple<Z> dropThird();


    default Predicate<? extends HasThird<Z, T, A>> checkThird(Predicate<A> predicate) {
        return tuple -> predicate.test(third());
    }

    static <Z, T extends FixedTuple<Z, T>, A extends Z> Predicate<? extends HasThird<Z, T, A>> matchingThird(
            Predicate<A> predicate) {
        return tuple -> predicate.test(tuple.third());
    }
}

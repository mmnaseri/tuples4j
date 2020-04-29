package com.mmnaseri.utils.tuples.facade;

import com.mmnaseri.utils.tuples.FixedTuple;
import com.mmnaseri.utils.tuples.Tuple;

import java.util.function.Predicate;

public interface HasFifth<Z, T extends FixedTuple<Z, T>, A extends Z> extends FixedTuple<Z, T> {

    @SuppressWarnings("unchecked")
    default A fifth() {
        return (A) get(4);
    }

    default T fifth(A value) {
        return change(0, value);
    }

    Tuple<Z> dropFifth();


    default Predicate<? extends HasFifth<Z, T, A>> checkFifth(Predicate<A> predicate) {
        return tuple -> predicate.test(fifth());
    }

    static <Z, T extends FixedTuple<Z, T>, A extends Z> Predicate<? extends HasFifth<Z, T, A>> matchingFifth(
            Predicate<A> predicate) {
        return tuple -> predicate.test(tuple.fifth());
    }
}

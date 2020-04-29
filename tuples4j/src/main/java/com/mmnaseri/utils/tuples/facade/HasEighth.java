package com.mmnaseri.utils.tuples.facade;

import com.mmnaseri.utils.tuples.FixedTuple;
import com.mmnaseri.utils.tuples.Tuple;

import java.util.function.Predicate;

public interface HasEighth<Z, T extends FixedTuple<Z, T>, A extends Z> extends FixedTuple<Z, T> {

    @SuppressWarnings("unchecked")
    default A eighth() {
        return (A) get(7);
    }

    default T eighth(A value) {
        return change(0, value);
    }

    Tuple<Z> dropEighth();


    default Predicate<? extends HasEighth<Z, T, A>> checkEighth(Predicate<A> predicate) {
        return tuple -> predicate.test(eighth());
    }

    static <Z, T extends FixedTuple<Z, T>, A extends Z> Predicate<? extends HasEighth<Z, T, A>> matchingEighth(
            Predicate<A> predicate) {
        return tuple -> predicate.test(tuple.eighth());
    }
}
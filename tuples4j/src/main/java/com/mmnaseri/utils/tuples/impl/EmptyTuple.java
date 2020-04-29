package com.mmnaseri.utils.tuples.impl;

import java.util.function.Function;

import static com.mmnaseri.utils.tuples.utils.TupleUtils.checkIndex;

public class EmptyTuple<Z> extends AbstractFixedTuple<Z, EmptyTuple<Z>> {

    public EmptyTuple() {
        super();
    }

    @Override
    public EmptyTuple<Z> change(final int index, final Z value) {
        return checkIndex(index, size());
    }

    @Override
    public <X extends Z> OneTuple<Z, X> extend(final X value) {
        return new OneTuple<>(value);
    }

    public static <Z, X extends Z> Function<EmptyTuple<Z>, OneTuple<Z, X>> extendWith(X value) {
        return tuple -> tuple.extend(value);
    }

}

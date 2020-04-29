package com.mmnaseri.utils.tuples.impl;

import com.mmnaseri.utils.tuples.facade.HasFirst;

import java.util.function.Function;

import static com.mmnaseri.utils.tuples.utils.TupleUtils.checkIndex;

public class OneTuple<Z, A extends Z>
        extends AbstractFixedTuple<Z, OneTuple<Z, A>>
        implements
        HasFirst<Z, OneTuple<Z, A>, A> {

    public OneTuple(A first) {
        super(first);
    }

    @SuppressWarnings("unchecked")
    @Override
    public OneTuple<Z, A> change(final int index, final Z value) {
        checkIndex(index, size());
        return new OneTuple<>(index == 0 ? (A) value : first());
    }

    @Override
    public <X extends Z> TwoTuple<Z, A, X> extend(final X value) {
        return new TwoTuple<>(first(), value);
    }

    public static <Z, A extends Z, X extends Z> Function<OneTuple<Z, A>, TwoTuple<Z, A, X>> extendWith(
            X value) {
        return tuple -> tuple.extend(value);
    }

    @Override
    public EmptyTuple<Z> dropFirst() {
        return new EmptyTuple<>();
    }

    public static <Z, A extends Z> OneTuple<Z, A> of(A first) {
        return new OneTuple<>(first);
    }

}

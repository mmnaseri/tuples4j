package com.mmnaseri.utils.tuples.impl;

import com.mmnaseri.utils.tuples.facade.HasFirst;
import com.mmnaseri.utils.tuples.facade.HasSecond;

import java.util.function.Function;

import static com.mmnaseri.utils.tuples.utils.TupleUtils.checkIndex;

public class TwoTuple<Z, A extends Z, B extends Z>
        extends AbstractFixedTuple<Z, TwoTuple<Z, A, B>>
        implements
        HasFirst<Z, TwoTuple<Z, A, B>, A>,
        HasSecond<Z, TwoTuple<Z, A, B>, B> {

    public TwoTuple(A first, B second) {
        super(first, second);
    }

    @SuppressWarnings("unchecked")
    @Override
    public TwoTuple<Z, A, B> change(final int index, final Z value) {
        checkIndex(index, size());
        return new TwoTuple<>(index == 0 ? (A) value : first(),
                              index == 1 ? (B) value : second());
    }

    @Override
    public <X extends Z> ThreeTuple<Z, A, B, X> extend(final X value) {
        return new ThreeTuple<>(first(), second(), value);
    }

    public static <Z, A extends Z, B extends Z, X extends Z>
    Function<TwoTuple<Z, A, B>, ThreeTuple<Z, A, B, X>> extendWith(X value) {
        return tuple -> tuple.extend(value);
    }

    @Override
    public OneTuple<Z, B> dropFirst() {
        return new OneTuple<>(second());
    }

    @Override
    public OneTuple<Z, A> dropSecond() {
        return new OneTuple<>(first());
    }

    public Pair<A, B> asPair() {
        return new Pair<>(first(), second());
    }

    public KeyValue<A, B> asKeyValue() {
        return new KeyValue<>(first(), second());
    }

    public static <A, B> TwoTuple<Object, A, B> of(A first, B second) {
        return new TwoTuple<>(first, second);
    }

}

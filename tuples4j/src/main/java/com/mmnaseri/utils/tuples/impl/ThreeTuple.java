package com.mmnaseri.utils.tuples.impl;

import com.mmnaseri.utils.tuples.facade.HasFirst;
import com.mmnaseri.utils.tuples.facade.HasSecond;
import com.mmnaseri.utils.tuples.facade.HasThird;

import java.util.function.Function;

import static com.mmnaseri.utils.tuples.utils.TupleUtils.checkIndex;

public class ThreeTuple<Z, A extends Z, B extends Z, C extends Z>
        extends AbstractFixedTuple<Z, ThreeTuple<Z, A, B, C>>
        implements
        HasFirst<Z, ThreeTuple<Z, A, B, C>, A>,
        HasSecond<Z, ThreeTuple<Z, A, B, C>, B>,
        HasThird<Z, ThreeTuple<Z, A, B, C>, C> {

    public ThreeTuple(A first, B second, C third) {
        super(first, second, third);
    }

    @SuppressWarnings("unchecked")
    @Override
    public ThreeTuple<Z, A, B, C> change(final int index, final Z value) {
        checkIndex(index, size());
        return new ThreeTuple<>(index == 0 ? (A) value : first(),
                                index == 1 ? (B) value : second(),
                                index == 2 ? (C) value : third());
    }

    @Override
    public <X extends Z> FourTuple<Z, A, B, C, X> extend(final X value) {
        return new FourTuple<>(first(), second(), third(), value);
    }

    @Override
    public TwoTuple<Z, B, C> dropFirst() {
        return new TwoTuple<>(second(), third());
    }

    @Override
    public TwoTuple<Z, A, C> dropSecond() {
        return new TwoTuple<>(first(), third());
    }

    @Override
    public TwoTuple<Z, A, B> dropThird() {
        return new TwoTuple<>(first(), second());
    }

    public static <Z, A extends Z, B extends Z, C extends Z, X extends Z>
    Function<ThreeTuple<Z, A, B, C>, FourTuple<Z, A, B, C, X>> extendWith(X value) {
        return tuple -> tuple.extend(value);
    }

    public static <A, B, C> ThreeTuple<Object, A, B, C> of(A first,
            B second, C third) {
        return new ThreeTuple<>(first, second, third);
    }

}

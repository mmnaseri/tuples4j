package com.mmnaseri.utils.tuples.impl;

import com.mmnaseri.utils.tuples.facade.HasFirst;
import com.mmnaseri.utils.tuples.facade.HasFourth;
import com.mmnaseri.utils.tuples.facade.HasSecond;
import com.mmnaseri.utils.tuples.facade.HasThird;

import java.util.function.Function;

import static com.mmnaseri.utils.tuples.utils.TupleUtils.checkIndex;

public class FourTuple<Z, A extends Z, B extends Z, C extends Z, D extends Z>
        extends AbstractFixedTuple<Z, FourTuple<Z, A, B, C, D>>
        implements
        HasFirst<Z, FourTuple<Z, A, B, C, D>, A>,
        HasSecond<Z, FourTuple<Z, A, B, C, D>, B>,
        HasThird<Z, FourTuple<Z, A, B, C, D>, C>,
        HasFourth<Z, FourTuple<Z, A, B, C, D>, D> {

    public FourTuple(A first, B second, C third, D fourth) {
        super(first, second, third, fourth);
    }

    @SuppressWarnings("unchecked")
    @Override
    public FourTuple<Z, A, B, C, D> change(final int index, final Z value) {
        checkIndex(index, size());
        return new FourTuple<>(index == 0 ? (A) value : first(),
                               index == 1 ? (B) value : second(),
                               index == 2 ? (C) value : third(),
                               index == 3 ? (D) value : fourth());
    }

    @Override
    public <X extends Z> FiveTuple<Z, A, B, C, D, X> extend(final X value) {
        return new FiveTuple<>(first(), second(), third(), fourth(), value);
    }

    public static <Z, A extends Z, B extends Z, C extends Z, D extends Z, X extends Z>
    Function<FourTuple<Z, A, B, C, D>, FiveTuple<Z, A, B, C, D, X>> extendWith(X value) {
        return tuple -> tuple.extend(value);
    }

    @Override
    public ThreeTuple<Z, B, C, D> dropFirst() {
        return new ThreeTuple<>(second(), third(), fourth());
    }

    @Override
    public ThreeTuple<Z, A, C, D> dropSecond() {
        return new ThreeTuple<>(first(), third(), fourth());
    }

    @Override
    public ThreeTuple<Z, A, B, D> dropThird() {
        return new ThreeTuple<>(first(), second(), fourth());
    }

    @Override
    public ThreeTuple<Z, A, B, C> dropFourth() {
        return new ThreeTuple<>(first(), second(), third());
    }

}

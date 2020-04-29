package com.mmnaseri.utils.tuples.impl;

import com.mmnaseri.utils.tuples.facade.*;

import java.util.function.Function;

import static com.mmnaseri.utils.tuples.utils.TupleUtils.checkIndex;

public class FiveTuple<Z, A extends Z, B extends Z, C extends Z, D extends Z, E extends Z>
        extends AbstractFixedTuple<Z, FiveTuple<Z, A, B, C, D, E>>
        implements
        HasFirst<Z, FiveTuple<Z, A, B, C, D, E>, A>,
        HasSecond<Z, FiveTuple<Z, A, B, C, D, E>, B>,
        HasThird<Z, FiveTuple<Z, A, B, C, D, E>, C>,
        HasFourth<Z, FiveTuple<Z, A, B, C, D, E>, D>,
        HasFifth<Z, FiveTuple<Z, A, B, C, D, E>, E> {

    public FiveTuple(A first, B second, C third, D fourth, E fifth) {
        super(first, second, third, fourth, fifth);
    }

    @SuppressWarnings("unchecked")
    @Override
    public FiveTuple<Z, A, B, C, D, E> change(final int index, final Z value) {
        checkIndex(index, size());
        return new FiveTuple<>(index == 0 ? (A) value : first(),
                               index == 1 ? (B) value : second(),
                               index == 2 ? (C) value : third(),
                               index == 3 ? (D) value : fourth(),
                               index == 4 ? (E) value : fifth());
    }

    @Override
    public <X extends Z> SixTuple<Z, A, B, C, D, E, X> extend(final X value) {
        return new SixTuple<>(first(), second(), third(), fourth(), fifth(), value);
    }

    public static <Z, A extends Z, B extends Z, C extends Z, D extends Z, E extends Z, X extends Z>
    Function<FiveTuple<Z, A, B, C, D, E>, SixTuple<Z, A, B, C, D, E, X>> extendWith(X value) {
        return tuple -> tuple.extend(value);
    }

    @Override
    public FourTuple<Z, B, C, D, E> dropFirst() {
        return new FourTuple<>(second(), third(), fourth(), fifth());
    }

    @Override
    public FourTuple<Z, A, C, D, E> dropSecond() {
        return new FourTuple<>(first(), third(), fourth(), fifth());
    }

    @Override
    public FourTuple<Z, A, B, D, E> dropThird() {
        return new FourTuple<>(first(), second(), fourth(), fifth());
    }

    @Override
    public FourTuple<Z, A, B, C, E> dropFourth() {
        return new FourTuple<>(first(), second(), third(), fifth());
    }

    @Override
    public FourTuple<Z, A, B, C, D> dropFifth() {
        return new FourTuple<>(first(), second(), third(), fourth());
    }

    public static <A, B, C, D, E> FiveTuple<Object, A, B, C, D, E> of(
            A first, B second, C third, D fourth, E fifth) {
        return new FiveTuple<>(first, second, third, fourth, fifth);
    }

}

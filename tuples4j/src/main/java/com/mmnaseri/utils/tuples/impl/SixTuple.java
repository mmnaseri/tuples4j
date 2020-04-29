package com.mmnaseri.utils.tuples.impl;

import com.mmnaseri.utils.tuples.facade.*;

import java.util.function.Function;

import static com.mmnaseri.utils.tuples.utils.TupleUtils.checkIndex;

public class SixTuple<Z, A extends Z, B extends Z, C extends Z, D extends Z, E extends Z,
                             F extends Z>
        extends AbstractFixedTuple<Z, SixTuple<Z, A, B, C, D, E, F>>
        implements
        HasFirst<Z, SixTuple<Z, A, B, C, D, E, F>, A>,
        HasSecond<Z, SixTuple<Z, A, B, C, D, E, F>, B>,
        HasThird<Z, SixTuple<Z, A, B, C, D, E, F>, C>,
        HasFourth<Z, SixTuple<Z, A, B, C, D, E, F>, D>,
        HasFifth<Z, SixTuple<Z, A, B, C, D, E, F>, E>,
        HasSixth<Z, SixTuple<Z, A, B, C, D, E, F>, F> {

    public SixTuple(A first, B second, C third, D fourth, E fifth, F sixth) {
        super(first, second, third, fourth, fifth, sixth);
    }

    @SuppressWarnings("unchecked")
    @Override
    public SixTuple<Z, A, B, C, D, E, F> change(final int index, final Z value) {
        checkIndex(index, size());
        return new SixTuple<>(index == 0 ? (A) value : first(),
                              index == 1 ? (B) value : second(),
                              index == 2 ? (C) value : third(),
                              index == 3 ? (D) value : fourth(),
                              index == 4 ? (E) value : fifth(),
                              index == 5 ? (F) value : sixth());
    }

    @Override
    public <X extends Z> SevenTuple<Z, A, B, C, D, E, F, X> extend(final X value) {
        return new SevenTuple<>(first(), second(), third(), fourth(), fifth(), sixth(), value);
    }

    @Override
    public FiveTuple<Z, B, C, D, E, F> dropFirst() {
        return new FiveTuple<>(second(), third(), fourth(), fifth(), sixth());
    }

    @Override
    public FiveTuple<Z, A, C, D, E, F> dropSecond() {
        return new FiveTuple<>(first(), third(), fourth(), fifth(), sixth());
    }

    @Override
    public FiveTuple<Z, A, B, D, E, F> dropThird() {
        return new FiveTuple<>(first(), second(), fourth(), fifth(), sixth());
    }

    @Override
    public FiveTuple<Z, A, B, C, E, F> dropFourth() {
        return new FiveTuple<>(first(), second(), third(), fifth(), sixth());
    }

    @Override
    public FiveTuple<Z, A, B, C, D, F> dropFifth() {
        return new FiveTuple<>(first(), second(), third(), fourth(), sixth());
    }

    @Override
    public FiveTuple<Z, A, B, C, D, E> dropSixth() {
        return new FiveTuple<>(first(), second(), third(), fourth(), fifth());
    }

    public static <Z, A extends Z, B extends Z, C extends Z, D extends Z, E extends Z,
                          F extends Z, X extends Z>
    Function<SixTuple<Z, A, B, C, D, E, F>, SevenTuple<Z, A, B, C, D, E, F, X>> extendWith(
            X value) {
        return tuple -> tuple.extend(value);
    }

    public static <A, B, C, D, E,
                          F> SixTuple<Object, A, B, C, D, E, F> of(
            A first, B second, C third, D fourth, E fifth, F sixth) {
        return new SixTuple<>(first, second, third, fourth, fifth, sixth);
    }

}

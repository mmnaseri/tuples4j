package com.mmnaseri.utils.tuples.impl;

import com.mmnaseri.utils.tuples.facade.*;

import java.util.function.Function;

import static com.mmnaseri.utils.tuples.utils.TupleUtils.checkIndex;

public class SevenTuple<Z, A extends Z, B extends Z, C extends Z, D extends Z, E extends Z,
                               F extends Z, G extends Z>
        extends AbstractFixedTuple<Z, SevenTuple<Z, A, B, C, D, E, F, G>>
        implements
        HasFirst<Z, SevenTuple<Z, A, B, C, D, E, F, G>, A>,
        HasSecond<Z, SevenTuple<Z, A, B, C, D, E, F, G>, B>,
        HasThird<Z, SevenTuple<Z, A, B, C, D, E, F, G>, C>,
        HasFourth<Z, SevenTuple<Z, A, B, C, D, E, F, G>, D>,
        HasFifth<Z, SevenTuple<Z, A, B, C, D, E, F, G>, E>,
        HasSixth<Z, SevenTuple<Z, A, B, C, D, E, F, G>, F>,
        HasSeventh<Z, SevenTuple<Z, A, B, C, D, E, F, G>, G> {

    public SevenTuple(A first, B second, C third, D fourth, E fifth, F sixth, G seventh) {
        super(first, second, third, fourth, fifth, sixth, seventh);
    }

    @SuppressWarnings("unchecked")
    @Override
    public SevenTuple<Z, A, B, C, D, E, F, G> change(final int index, final Z value) {
        checkIndex(index, size());
        return new SevenTuple<>(index == 0 ? (A) value : first(),
                                index == 1 ? (B) value : second(),
                                index == 2 ? (C) value : third(),
                                index == 3 ? (D) value : fourth(),
                                index == 4 ? (E) value : fifth(),
                                index == 5 ? (F) value : sixth(),
                                index == 6 ? (G) value : seventh());
    }

    @Override
    public <X extends Z> EightTuple<Z, A, B, C, D, E, F, G, X> extend(final X value) {
        return new EightTuple<>(first(), second(), third(), fourth(), fifth(), sixth(), seventh(),
                                value);
    }

    public static <Z, A extends Z, B extends Z, C extends Z, D extends Z, E extends Z,
                          F extends Z, G extends Z, X extends Z>
    Function<SevenTuple<Z, A, B, C, D, E, F, G>, EightTuple<Z, A, B, C, D, E, F, G, X>> extendWith(
            X value) {
        return tuple -> tuple.extend(value);
    }

    @Override
    public SixTuple<Z, B, C, D, E, F, G> dropFirst() {
        return new SixTuple<>(second(), third(), fourth(), fifth(), sixth(), seventh());
    }

    @Override
    public SixTuple<Z, A, C, D, E, F, G> dropSecond() {
        return new SixTuple<>(first(), third(), fourth(), fifth(), sixth(), seventh());
    }

    @Override
    public SixTuple<Z, A, B, D, E, F, G> dropThird() {
        return new SixTuple<>(first(), second(), fourth(), fifth(), sixth(), seventh());
    }

    @Override
    public SixTuple<Z, A, B, C, E, F, G> dropFourth() {
        return new SixTuple<>(first(), second(), third(), fifth(), sixth(), seventh());
    }

    @Override
    public SixTuple<Z, A, B, C, D, F, G> dropFifth() {
        return new SixTuple<>(first(), second(), third(), fourth(), sixth(), seventh());
    }

    @Override
    public SixTuple<Z, A, B, C, D, E, G> dropSixth() {
        return new SixTuple<>(first(), second(), third(), fourth(), fifth(), seventh());
    }

    @Override
    public SixTuple<Z, A, B, C, D, E, F> dropSeventh() {
        return new SixTuple<>(first(), second(), third(), fourth(), fifth(), sixth());
    }

}

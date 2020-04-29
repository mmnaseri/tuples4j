package com.mmnaseri.utils.tuples.impl;

import com.mmnaseri.utils.tuples.facade.*;

import java.util.function.Function;

import static com.mmnaseri.utils.tuples.utils.TupleUtils.checkIndex;

public class EightTuple<Z, A extends Z, B extends Z, C extends Z, D extends Z, E extends Z,
                               F extends Z, G extends Z
                               , H extends Z>
        extends AbstractFixedTuple<Z, EightTuple<Z, A, B, C, D, E, F, G, H>>
        implements
        HasFirst<Z, EightTuple<Z, A, B, C, D, E, F, G, H>, A>,
        HasSecond<Z, EightTuple<Z, A, B, C, D, E, F, G, H>, B>,
        HasThird<Z, EightTuple<Z, A, B, C, D, E, F, G, H>, C>,
        HasFourth<Z, EightTuple<Z, A, B, C, D, E, F, G, H>, D>,
        HasFifth<Z, EightTuple<Z, A, B, C, D, E, F, G, H>, E>,
        HasSixth<Z, EightTuple<Z, A, B, C, D, E, F, G, H>, F>,
        HasSeventh<Z, EightTuple<Z, A, B, C, D, E, F, G, H>, G>,
        HasEighth<Z, EightTuple<Z, A, B, C, D, E, F, G, H>, H> {

    public EightTuple(A first, B second, C third, D fourth, E fifth, F sixth, G seventh, H eighth) {
        super(first, second, third, fourth, fifth, sixth, seventh, eighth);
    }

    @SuppressWarnings("unchecked")
    @Override
    public EightTuple<Z, A, B, C, D, E, F, G, H> change(final int index, final Z value) {
        checkIndex(index, size());
        return new EightTuple<>(index == 0 ? (A) value : first(),
                                index == 1 ? (B) value : second(),
                                index == 2 ? (C) value : third(),
                                index == 3 ? (D) value : fourth(),
                                index == 4 ? (E) value : fifth(),
                                index == 5 ? (F) value : sixth(),
                                index == 6 ? (G) value : seventh(),
                                index == 7 ? (H) value : eighth());
    }

    @Override
    public <X extends Z> NineTuple<Z, A, B, C, D, E, F, G, H, X> extend(final X value) {
        return new NineTuple<>(first(), second(), third(), fourth(), fifth(), sixth(), seventh(),
                               eighth(), value);
    }

    public static <Z, A extends Z, B extends Z, C extends Z, D extends Z, E extends Z,
                          F extends Z, G extends Z
                          , H extends Z, X extends Z>
    Function<EightTuple<Z, A, B, C, D, E, F, G, H>, NineTuple<Z, A, B, C, D, E, F, G, H, X>> extendWith(
            X value) {
        return tuple -> tuple.extend(value);
    }

    @Override
    public SevenTuple<Z, B, C, D, E, F, G, H> dropFirst() {
        return new SevenTuple<>(second(), third(), fourth(), fifth(), sixth(), seventh(), eighth());
    }

    @Override
    public SevenTuple<Z, A, C, D, E, F, G, H> dropSecond() {
        return new SevenTuple<>(first(), third(), fourth(), fifth(), sixth(), seventh(), eighth());
    }

    @Override
    public SevenTuple<Z, A, B, D, E, F, G, H> dropThird() {
        return new SevenTuple<>(first(), second(), fourth(), fifth(), sixth(), seventh(), eighth());
    }

    @Override
    public SevenTuple<Z, A, B, C, E, F, G, H> dropFourth() {
        return new SevenTuple<>(first(), second(), third(), fifth(), sixth(), seventh(), eighth());
    }

    @Override
    public SevenTuple<Z, A, B, C, D, F, G, H> dropFifth() {
        return new SevenTuple<>(first(), second(), third(), fourth(), sixth(), seventh(), eighth());
    }

    @Override
    public SevenTuple<Z, A, B, C, D, E, G, H> dropSixth() {
        return new SevenTuple<>(first(), second(), third(), fourth(), fifth(), seventh(), eighth());
    }

    @Override
    public SevenTuple<Z, A, B, C, D, E, F, H> dropSeventh() {
        return new SevenTuple<>(first(), second(), third(), fourth(), fifth(), sixth(), eighth());
    }

    @Override
    public SevenTuple<Z, A, B, C, D, E, F, G> dropEighth() {
        return new SevenTuple<>(first(), second(), third(), fourth(), fifth(), sixth(), seventh());
    }

}

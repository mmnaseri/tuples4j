package com.mmnaseri.utils.tuples.impl;

import com.mmnaseri.utils.tuples.facade.*;

import java.util.function.Function;

import static com.mmnaseri.utils.tuples.utils.TupleUtils.checkIndex;

public class TwelveTuple<Z, A extends Z, B extends Z, C extends Z, D extends Z, E extends Z, F extends Z, G extends Z
                                , H extends Z, I extends Z, J extends Z, K extends Z, L extends Z>
        extends AbstractFixedTuple<Z, TwelveTuple<Z, A, B, C, D, E, F, G, H, I, J, K, L>>
        implements
        HasFirst<Z, TwelveTuple<Z, A, B, C, D, E, F, G, H, I, J, K, L>, A>,
        HasSecond<Z, TwelveTuple<Z, A, B, C, D, E, F, G, H, I, J, K, L>, B>,
        HasThird<Z, TwelveTuple<Z, A, B, C, D, E, F, G, H, I, J, K, L>, C>,
        HasFourth<Z, TwelveTuple<Z, A, B, C, D, E, F, G, H, I, J, K, L>, D>,
        HasFifth<Z, TwelveTuple<Z, A, B, C, D, E, F, G, H, I, J, K, L>, E>,
        HasSixth<Z, TwelveTuple<Z, A, B, C, D, E, F, G, H, I, J, K, L>, F>,
        HasSeventh<Z, TwelveTuple<Z, A, B, C, D, E, F, G, H, I, J, K, L>, G>,
        HasEighth<Z, TwelveTuple<Z, A, B, C, D, E, F, G, H, I, J, K, L>, H>,
        HasNinth<Z, TwelveTuple<Z, A, B, C, D, E, F, G, H, I, J, K, L>, I>,
        HasTenth<Z, TwelveTuple<Z, A, B, C, D, E, F, G, H, I, J, K, L>, J>,
        HasEleventh<Z, TwelveTuple<Z, A, B, C, D, E, F, G, H, I, J, K, L>, K>,
        HasTwelfth<Z, TwelveTuple<Z, A, B, C, D, E, F, G, H, I, J, K, L>, L> {

    public TwelveTuple(A first, B second, C third, D fourth, E fifth, F sixth, G seventh, H eighth, I ninth, J tenth,
            K eleventh, L twelfth) {
        super(first, second, third, fourth, fifth, sixth, seventh, eighth, ninth, tenth, eleventh, twelfth);
    }

    @SuppressWarnings("unchecked")
    @Override
    public TwelveTuple<Z, A, B, C, D, E, F, G, H, I, J, K, L> change(final int index, final Z value) {
        checkIndex(index, size());
        return new TwelveTuple<>(index == 0 ? (A) value : first(),
                                 index == 1 ? (B) value : second(),
                                 index == 2 ? (C) value : third(),
                                 index == 3 ? (D) value : fourth(),
                                 index == 4 ? (E) value : fifth(),
                                 index == 5 ? (F) value : sixth(),
                                 index == 6 ? (G) value : seventh(),
                                 index == 7 ? (H) value : eighth(),
                                 index == 8 ? (I) value : ninth(),
                                 index == 9 ? (J) value : tenth(),
                                 index == 10 ? (K) value : eleventh(),
                                 index == 11 ? (L) value : twelfth());
    }

    @Override
    public <X extends Z> ThirteenOrMoreTuple<Z, A, B, C, D, E, F, G, H, I, J, K, L> extend(final X value) {
        return new ThirteenOrMoreTuple<>(first(), second(), third(), fourth(), fifth(), sixth(), seventh(), eighth(),
                                         ninth(), tenth(), eleventh(), twelfth(), value);
    }

    public static <Z, A extends Z, B extends Z, C extends Z, D extends Z, E extends Z, F extends Z, G extends Z
                          , H extends Z, I extends Z, J extends Z, K extends Z, L extends Z, X extends Z>
    Function<TwelveTuple<Z, A, B, C, D, E, F, G, H, I, J, K, L>,
                    ThirteenOrMoreTuple<Z, A, B, C, D, E, F, G, H, I, J, K, L>>
    extendWith(X value) {
        return tuple -> tuple.extend(value);
    }

    @Override
    public ElevenTuple<Z, B, C, D, E, F, G, H, I, J, K, L> dropFirst() {
        return new ElevenTuple<>(second(), third(), fourth(), fifth(), sixth(), seventh(), eighth(), ninth(), tenth(),
                                 eleventh(), twelfth());
    }

    @Override
    public ElevenTuple<Z, A, C, D, E, F, G, H, I, J, K, L> dropSecond() {
        return new ElevenTuple<>(first(), third(), fourth(), fifth(), sixth(), seventh(), eighth(), ninth(), tenth(),
                                 eleventh(), twelfth());
    }

    @Override
    public ElevenTuple<Z, A, B, D, E, F, G, H, I, J, K, L> dropThird() {
        return new ElevenTuple<>(first(), second(), fourth(), fifth(), sixth(), seventh(), eighth(), ninth(), tenth(),
                                 eleventh(), twelfth());
    }

    @Override
    public ElevenTuple<Z, A, B, C, E, F, G, H, I, J, K, L> dropFourth() {
        return new ElevenTuple<>(first(), second(), third(), fifth(), sixth(), seventh(), eighth(), ninth(), tenth(),
                                 eleventh(), twelfth());
    }

    @Override
    public ElevenTuple<Z, A, B, C, D, F, G, H, I, J, K, L> dropFifth() {
        return new ElevenTuple<>(first(), second(), third(), fourth(), sixth(), seventh(), eighth(), ninth(), tenth(),
                                 eleventh(), twelfth());
    }

    @Override
    public ElevenTuple<Z, A, B, C, D, E, G, H, I, J, K, L> dropSixth() {
        return new ElevenTuple<>(first(), second(), third(), fourth(), fifth(), seventh(), eighth(), ninth(), tenth(),
                                 eleventh(), twelfth());
    }

    @Override
    public ElevenTuple<Z, A, B, C, D, E, F, H, I, J, K, L> dropSeventh() {
        return new ElevenTuple<>(first(), second(), third(), fourth(), fifth(), sixth(), eighth(), ninth(), tenth(),
                                 eleventh(), twelfth());
    }

    @Override
    public ElevenTuple<Z, A, B, C, D, E, F, G, I, J, K, L> dropEighth() {
        return new ElevenTuple<>(first(), second(), third(), fourth(), fifth(), sixth(), seventh(), ninth(), tenth(),
                                 eleventh(), twelfth());
    }

    @Override
    public ElevenTuple<Z, A, B, C, D, E, F, G, H, J, K, L> dropNinth() {
        return new ElevenTuple<>(first(), second(), third(), fourth(), fifth(), sixth(), seventh(), eighth(), tenth(),
                                 eleventh(), twelfth());
    }

    @Override
    public ElevenTuple<Z, A, B, C, D, E, F, G, H, I, K, L> dropTenth() {
        return new ElevenTuple<>(first(), second(), third(), fourth(), fifth(), sixth(), seventh(), eighth(), ninth(),
                                 eleventh(), twelfth());
    }

    @Override
    public ElevenTuple<Z, A, B, C, D, E, F, G, H, I, J, L> dropEleventh() {
        return new ElevenTuple<>(first(), second(), third(), fourth(), fifth(), sixth(), seventh(), eighth(), ninth(),
                                 tenth(), twelfth());
    }

    @Override
    public ElevenTuple<Z, A, B, C, D, E, F, G, H, I, J, K> dropTwelfth() {
        return new ElevenTuple<>(first(), second(), third(), fourth(), fifth(), sixth(), seventh(), eighth(), ninth(),
                                 tenth(), eleventh());
    }
}

package com.mmnaseri.utils.tuples.impl;

import com.mmnaseri.utils.tuples.facade.*;

import java.util.function.Function;

import static com.mmnaseri.utils.tuples.utils.TupleUtils.checkIndex;

public class ElevenTuple<Z, A extends Z, B extends Z, C extends Z, D extends Z, E extends Z, F extends Z, G extends Z
                                , H extends Z, I extends Z, J extends Z, K extends Z>
        extends AbstractFixedTuple<Z, ElevenTuple<Z, A, B, C, D, E, F, G, H, I, J, K>>
        implements
        HasFirst<Z, ElevenTuple<Z, A, B, C, D, E, F, G, H, I, J, K>, A>,
        HasSecond<Z, ElevenTuple<Z, A, B, C, D, E, F, G, H, I, J, K>, B>,
        HasThird<Z, ElevenTuple<Z, A, B, C, D, E, F, G, H, I, J, K>, C>,
        HasFourth<Z, ElevenTuple<Z, A, B, C, D, E, F, G, H, I, J, K>, D>,
        HasFifth<Z, ElevenTuple<Z, A, B, C, D, E, F, G, H, I, J, K>, E>,
        HasSixth<Z, ElevenTuple<Z, A, B, C, D, E, F, G, H, I, J, K>, F>,
        HasSeventh<Z, ElevenTuple<Z, A, B, C, D, E, F, G, H, I, J, K>, G>,
        HasEighth<Z, ElevenTuple<Z, A, B, C, D, E, F, G, H, I, J, K>, H>,
        HasNinth<Z, ElevenTuple<Z, A, B, C, D, E, F, G, H, I, J, K>, I>,
        HasTenth<Z, ElevenTuple<Z, A, B, C, D, E, F, G, H, I, J, K>, J>,
        HasEleventh<Z, ElevenTuple<Z, A, B, C, D, E, F, G, H, I, J, K>, K> {

    public ElevenTuple(A first, B second, C third, D fourth, E fifth, F sixth, G seventh, H eighth, I ninth, J tenth,
            K eleventh) {
        super(first, second, third, fourth, fifth, sixth, seventh, eighth, ninth, tenth, eleventh);
    }

    @SuppressWarnings("unchecked")
    @Override
    public ElevenTuple<Z, A, B, C, D, E, F, G, H, I, J, K> change(final int index, final Z value) {
        checkIndex(index, size());
        return new ElevenTuple<>(index == 0 ? (A) value : first(),
                                 index == 1 ? (B) value : second(),
                                 index == 2 ? (C) value : third(),
                                 index == 3 ? (D) value : fourth(),
                                 index == 4 ? (E) value : fifth(),
                                 index == 5 ? (F) value : sixth(),
                                 index == 6 ? (G) value : seventh(),
                                 index == 7 ? (H) value : eighth(),
                                 index == 8 ? (I) value : ninth(),
                                 index == 9 ? (J) value : tenth(),
                                 index == 10 ? (K) value : eleventh());
    }

    @Override
    public <X extends Z> TwelveTuple<Z, A, B, C, D, E, F, G, H, I, J, K, X> extend(final X value) {
        return new TwelveTuple<>(first(), second(), third(), fourth(), fifth(), sixth(), seventh(), eighth(), ninth(),
                                 tenth(), eleventh(), value);
    }

    public static <Z, A extends Z, B extends Z, C extends Z, D extends Z, E extends Z, F extends Z, G extends Z
                          , H extends Z, I extends Z, J extends Z, K extends Z, X extends Z>
    Function<ElevenTuple<Z, A, B, C, D, E, F, G, H, I, J, K>, TwelveTuple<Z, A, B, C, D, E, F, G, H, I, J, K, X>>
    extendWith(X value) {
        return tuple -> tuple.extend(value);
    }

    @Override
    public TenTuple<Z, B, C, D, E, F, G, H, I, J, K> dropFirst() {
        return new TenTuple<>(second(), third(), fourth(), fifth(), sixth(), seventh(), eighth(), ninth(), tenth(),
                              eleventh());
    }

    @Override
    public TenTuple<Z, A, C, D, E, F, G, H, I, J, K> dropSecond() {
        return new TenTuple<>(first(), third(), fourth(), fifth(), sixth(), seventh(), eighth(), ninth(), tenth(),
                              eleventh());
    }

    @Override
    public TenTuple<Z, A, B, D, E, F, G, H, I, J, K> dropThird() {
        return new TenTuple<>(first(), second(), fourth(), fifth(), sixth(), seventh(), eighth(), ninth(), tenth(),
                              eleventh());
    }

    @Override
    public TenTuple<Z, A, B, C, E, F, G, H, I, J, K> dropFourth() {
        return new TenTuple<>(first(), second(), third(), fifth(), sixth(), seventh(), eighth(), ninth(), tenth(),
                              eleventh());
    }

    @Override
    public TenTuple<Z, A, B, C, D, F, G, H, I, J, K> dropFifth() {
        return new TenTuple<>(first(), second(), third(), fourth(), sixth(), seventh(), eighth(), ninth(), tenth(),
                              eleventh());
    }

    @Override
    public TenTuple<Z, A, B, C, D, E, G, H, I, J, K> dropSixth() {
        return new TenTuple<>(first(), second(), third(), fourth(), fifth(), seventh(), eighth(), ninth(), tenth(),
                              eleventh());
    }

    @Override
    public TenTuple<Z, A, B, C, D, E, F, H, I, J, K> dropSeventh() {
        return new TenTuple<>(first(), second(), third(), fourth(), fifth(), sixth(), eighth(), ninth(), tenth(),
                              eleventh());
    }

    @Override
    public TenTuple<Z, A, B, C, D, E, F, G, I, J, K> dropEighth() {
        return new TenTuple<>(first(), second(), third(), fourth(), fifth(), sixth(), seventh(), ninth(), tenth(),
                              eleventh());
    }

    @Override
    public TenTuple<Z, A, B, C, D, E, F, G, H, J, K> dropNinth() {
        return new TenTuple<>(first(), second(), third(), fourth(), fifth(), sixth(), seventh(), eighth(), tenth(),
                              eleventh());
    }

    @Override
    public TenTuple<Z, A, B, C, D, E, F, G, H, I, K> dropTenth() {
        return new TenTuple<>(first(), second(), third(), fourth(), fifth(), sixth(), seventh(), eighth(), ninth(),
                              eleventh());
    }

    @Override
    public TenTuple<Z, A, B, C, D, E, F, G, H, I, J> dropEleventh() {
        return new TenTuple<>(first(), second(), third(), fourth(), fifth(), sixth(), seventh(), eighth(), ninth(),
                              tenth());
    }

    public static <Z, A extends Z, B extends Z, C extends Z, D extends Z, E extends Z, F extends Z,
                   G extends Z, H extends Z, I extends Z, J extends Z, K extends Z>
    ElevenTuple<Z, A, B, C, D, E, F, G, H, I, J, K> of(A first, B second, C third, D fourth, E fifth, F sixth, G seventh, H eighth, I ninth, J tenth,
            K eleventh) {
        return new ElevenTuple<>(first, second, third, fourth, fifth, sixth, seventh, eighth, ninth, tenth, eleventh);
    }

}

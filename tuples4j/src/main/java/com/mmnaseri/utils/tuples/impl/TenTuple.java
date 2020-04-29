package com.mmnaseri.utils.tuples.impl;

import com.mmnaseri.utils.tuples.facade.*;

import java.util.function.Function;

import static com.mmnaseri.utils.tuples.utils.TupleUtils.checkIndex;

public class TenTuple<Z, A extends Z, B extends Z, C extends Z, D extends Z, E extends Z, F extends Z, G extends Z, H extends Z, I extends Z, J extends Z> extends AbstractFixedTuple<Z, TenTuple<Z, A, B, C, D, E, F, G, H, I, J>>
        implements
        HasFirst<Z, TenTuple<Z, A, B, C, D, E, F, G, H, I, J>, A>,
        HasSecond<Z, TenTuple<Z, A, B, C, D, E, F, G, H, I, J>, B>,
        HasThird<Z, TenTuple<Z, A, B, C, D, E, F, G, H, I, J>, C>,
        HasFourth<Z, TenTuple<Z, A, B, C, D, E, F, G, H, I, J>, D>,
        HasFifth<Z, TenTuple<Z, A, B, C, D, E, F, G, H, I, J>, E>,
        HasSixth<Z, TenTuple<Z, A, B, C, D, E, F, G, H, I, J>, F>,
        HasSeventh<Z, TenTuple<Z, A, B, C, D, E, F, G, H, I, J>, G>,
        HasEighth<Z, TenTuple<Z, A, B, C, D, E, F, G, H, I, J>, H>,
        HasNinth<Z, TenTuple<Z, A, B, C, D, E, F, G, H, I, J>, I>,
        HasTenth<Z, TenTuple<Z, A, B, C, D, E, F, G, H, I, J>, J> {

    public TenTuple(A first, B second, C third, D fourth, E fifth, F sixth, G seventh, H eighth, I ninth, J tenth) {
        super(first, second, third, fourth, fifth, sixth, seventh, eighth, ninth, tenth);
    }

    @SuppressWarnings("unchecked")
    @Override
    public TenTuple<Z, A, B, C, D, E, F, G, H, I, J> change(final int index, final Z value) {
        checkIndex(index, size());
        return new TenTuple<>(index == 0 ? (A) value : first(),
                              index == 1 ? (B) value : second(),
                              index == 2 ? (C) value : third(),
                              index == 3 ? (D) value : fourth(),
                              index == 4 ? (E) value : fifth(),
                              index == 5 ? (F) value : sixth(),
                              index == 6 ? (G) value : seventh(),
                              index == 7 ? (H) value : eighth(),
                              index == 8 ? (I) value : ninth(),
                              index == 9 ? (J) value : tenth());
    }

    @Override
    public <X extends Z> ElevenTuple<Z, A, B, C, D, E, F, G, H, I, J, X> extend(final X value) {
        return new ElevenTuple<>(first(), second(), third(), fourth(), fifth(), sixth(), seventh(), eighth(), ninth(), tenth(), value);
    }

    @Override
    public NineTuple<Z, B, C, D, E, F, G, H, I, J> dropFirst() {
        return new NineTuple<>(second(), third(), fourth(), fifth(), sixth(), seventh(), eighth(), ninth(), tenth());
    }

    @Override
    public NineTuple<Z, A, C, D, E, F, G, H, I, J> dropSecond() {
        return new NineTuple<>(first(), third(), fourth(), fifth(), sixth(), seventh(), eighth(), ninth(), tenth());
    }

    @Override
    public NineTuple<Z, A, B, D, E, F, G, H, I, J> dropThird() {
        return new NineTuple<>(first(), second(), fourth(), fifth(), sixth(), seventh(), eighth(), ninth(), tenth());
    }

    @Override
    public NineTuple<Z, A, B, C, E, F, G, H, I, J> dropFourth() {
        return new NineTuple<>(first(), second(), third(), fifth(), sixth(), seventh(), eighth(), ninth(), tenth());
    }

    @Override
    public NineTuple<Z, A, B, C, D, F, G, H, I, J> dropFifth() {
        return new NineTuple<>(first(), second(), third(), fourth(), sixth(), seventh(), eighth(), ninth(), tenth());
    }

    @Override
    public NineTuple<Z, A, B, C, D, E, G, H, I, J> dropSixth() {
        return new NineTuple<>(first(), second(), third(), fourth(), fifth(), seventh(), eighth(), ninth(), tenth());
    }

    @Override
    public NineTuple<Z, A, B, C, D, E, F, H, I, J> dropSeventh() {
        return new NineTuple<>(first(), second(), third(), fourth(), fifth(), sixth(), eighth(), ninth(), tenth());
    }

    @Override
    public NineTuple<Z, A, B, C, D, E, F, G, I, J> dropEighth() {
        return new NineTuple<>(first(), second(), third(), fourth(), fifth(), sixth(), seventh(), ninth(), tenth());
    }

    @Override
    public NineTuple<Z, A, B, C, D, E, F, G, H, J> dropNinth() {
        return new NineTuple<>(first(), second(), third(), fourth(), fifth(), sixth(), seventh(), eighth(), tenth());
    }

    @Override
    public NineTuple<Z, A, B, C, D, E, F, G, H, I> dropTenth() {
        return new NineTuple<>(first(), second(), third(), fourth(), fifth(), sixth(), seventh(), eighth(), ninth());
    }

    public static <Z, A extends Z, B extends Z, C extends Z, D extends Z, E extends Z, F extends Z, G extends Z, H extends Z, I extends Z, J extends Z, X extends Z> Function<TenTuple<Z, A, B, C, D, E, F, G, H, I, J>, ElevenTuple<Z, A, B, C, D, E, F, G, H, I, J, X>> extendWith(X value) {
        return tuple -> tuple.extend(value);
    }

    public static <A, B, C, D, E, F, G, H, I, J> TenTuple<Object, A, B, C, D, E, F, G, H, I, J> of(A first, B second, C third, D fourth, E fifth, F sixth, G seventh, H eighth, I ninth, J tenth) {
        return new TenTuple<>(first, second, third, fourth, fifth, sixth, seventh, eighth, ninth, tenth);
    }

}

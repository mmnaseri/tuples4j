package com.mmnaseri.utils.tuples.impl;

import com.mmnaseri.utils.tuples.facade.*;

import java.util.function.Function;

import static com.mmnaseri.utils.tuples.utils.TupleUtils.checkIndex;

public class NineTuple<Z, A extends Z, B extends Z, C extends Z, D extends Z, E extends Z,
                              F extends Z, G extends Z
                              , H extends Z, I extends Z>
        extends AbstractFixedTuple<Z, NineTuple<Z, A, B, C, D, E, F, G, H, I>>
        implements
        HasFirst<Z, NineTuple<Z, A, B, C, D, E, F, G, H, I>, A>,
        HasSecond<Z, NineTuple<Z, A, B, C, D, E, F, G, H, I>, B>,
        HasThird<Z, NineTuple<Z, A, B, C, D, E, F, G, H, I>, C>,
        HasFourth<Z, NineTuple<Z, A, B, C, D, E, F, G, H, I>, D>,
        HasFifth<Z, NineTuple<Z, A, B, C, D, E, F, G, H, I>, E>,
        HasSixth<Z, NineTuple<Z, A, B, C, D, E, F, G, H, I>, F>,
        HasSeventh<Z, NineTuple<Z, A, B, C, D, E, F, G, H, I>, G>,
        HasEighth<Z, NineTuple<Z, A, B, C, D, E, F, G, H, I>, H>,
        HasNinth<Z, NineTuple<Z, A, B, C, D, E, F, G, H, I>, I> {

    public NineTuple(A first, B second, C third, D fourth, E fifth, F sixth, G seventh, H eighth,
            I ninth) {
        super(first, second, third, fourth, fifth, sixth, seventh, eighth, ninth);
    }

    @SuppressWarnings("unchecked")
    @Override
    public NineTuple<Z, A, B, C, D, E, F, G, H, I> change(final int index, final Z value) {
        checkIndex(index, size());
        return new NineTuple<>(index == 0 ? (A) value : first(),
                               index == 1 ? (B) value : second(),
                               index == 2 ? (C) value : third(),
                               index == 3 ? (D) value : fourth(),
                               index == 4 ? (E) value : fifth(),
                               index == 5 ? (F) value : sixth(),
                               index == 6 ? (G) value : seventh(),
                               index == 7 ? (H) value : eighth(),
                               index == 8 ? (I) value : ninth());
    }

    @Override
    public <X extends Z> TenTuple<Z, A, B, C, D, E, F, G, H, I, X> extend(final X value) {
        return new TenTuple<>(first(), second(), third(), fourth(), fifth(), sixth(), seventh(),
                              eighth(), ninth(),
                              value);
    }

    @Override
    public EightTuple<Z, B, C, D, E, F, G, H, I> dropFirst() {
        return new EightTuple<>(second(), third(), fourth(), fifth(), sixth(), seventh(), eighth(),
                                ninth());
    }

    @Override
    public EightTuple<Z, A, C, D, E, F, G, H, I> dropSecond() {
        return new EightTuple<>(first(), third(), fourth(), fifth(), sixth(), seventh(), eighth(),
                                ninth());
    }

    @Override
    public EightTuple<Z, A, B, D, E, F, G, H, I> dropThird() {
        return new EightTuple<>(first(), second(), fourth(), fifth(), sixth(), seventh(), eighth(),
                                ninth());
    }

    @Override
    public EightTuple<Z, A, B, C, E, F, G, H, I> dropFourth() {
        return new EightTuple<>(first(), second(), third(), fifth(), sixth(), seventh(), eighth(),
                                ninth());
    }

    @Override
    public EightTuple<Z, A, B, C, D, F, G, H, I> dropFifth() {
        return new EightTuple<>(first(), second(), third(), fourth(), sixth(), seventh(), eighth(),
                                ninth());
    }

    @Override
    public EightTuple<Z, A, B, C, D, E, G, H, I> dropSixth() {
        return new EightTuple<>(first(), second(), third(), fourth(), fifth(), seventh(), eighth(),
                                ninth());
    }

    @Override
    public EightTuple<Z, A, B, C, D, E, F, H, I> dropSeventh() {
        return new EightTuple<>(first(), second(), third(), fourth(), fifth(), sixth(), eighth(),
                                ninth());
    }

    @Override
    public EightTuple<Z, A, B, C, D, E, F, G, I> dropEighth() {
        return new EightTuple<>(first(), second(), third(), fourth(), fifth(), sixth(), seventh(),
                                ninth());
    }

    @Override
    public EightTuple<Z, A, B, C, D, E, F, G, H> dropNinth() {
        return new EightTuple<>(first(), second(), third(), fourth(), fifth(), sixth(), seventh(),
                                eighth());
    }

    public static <Z, A extends Z, B extends Z, C extends Z, D extends Z, E extends Z,
                          F extends Z, G extends Z
                          , H extends Z, I extends Z, X extends Z>
    Function<NineTuple<Z, A, B, C, D, E, F, G, H, I>, TenTuple<Z, A, B, C, D, E, F, G, H, I, X>> extendWith(
            X value) {
        return tuple -> tuple.extend(value);
    }

    public static <A, B, C, D, E,
                          F, G,
                          H, I> NineTuple<Object, A, B, C, D, E, F, G, H, I> of(
            A first, B second, C third, D fourth, E fifth, F sixth, G seventh, H eighth, I ninth) {
        return new NineTuple<>(first, second, third, fourth, fifth, sixth, seventh, eighth, ninth);
    }
}

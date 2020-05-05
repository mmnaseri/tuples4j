package com.mmnaseri.utils.tuples.impl;

import com.mmnaseri.utils.tuples.facade.*;

import java.util.function.Function;
import java.util.function.Supplier;

import static com.mmnaseri.utils.tuples.utils.TupleUtils.checkIndex;

public class TwelveTuple<Z, A extends Z, B extends Z, C extends Z, D extends Z, E extends Z, F extends Z, G extends Z, H extends Z, I extends Z, J extends Z, K extends Z, L extends Z> extends AbstractFixedTuple<Z, TwelveTuple<Z, A, B, C, D, E, F, G, H, I, J, K, L>>
        implements
        HasFirst<Z, A, TwelveTuple<Z, A, B, C, D, E, F, G, H, I, J, K, L>>,
        HasSecond<Z, B, TwelveTuple<Z, A, B, C, D, E, F, G, H, I, J, K, L>>,
        HasThird<Z, C, TwelveTuple<Z, A, B, C, D, E, F, G, H, I, J, K, L>>,
        HasFourth<Z, D, TwelveTuple<Z, A, B, C, D, E, F, G, H, I, J, K, L>>,
        HasFifth<Z, E, TwelveTuple<Z, A, B, C, D, E, F, G, H, I, J, K, L>>,
        HasSixth<Z, F, TwelveTuple<Z, A, B, C, D, E, F, G, H, I, J, K, L>>,
        HasSeventh<Z, G, TwelveTuple<Z, A, B, C, D, E, F, G, H, I, J, K, L>>,
        HasEighth<Z, H, TwelveTuple<Z, A, B, C, D, E, F, G, H, I, J, K, L>>,
        HasNinth<Z, I, TwelveTuple<Z, A, B, C, D, E, F, G, H, I, J, K, L>>,
        HasTenth<Z, J, TwelveTuple<Z, A, B, C, D, E, F, G, H, I, J, K, L>>,
        HasEleventh<Z, K, TwelveTuple<Z, A, B, C, D, E, F, G, H, I, J, K, L>>,
        HasTwelfth<Z, L, TwelveTuple<Z, A, B, C, D, E, F, G, H, I, J, K, L>> {

    public TwelveTuple(A first, B second, C third, D fourth, E fifth, F sixth, G seventh, H eighth, I ninth, J tenth, K eleventh, L twelfth) {
        super(first, second, third, fourth, fifth, sixth, seventh, eighth, ninth, tenth, eleventh, twelfth);
    }

    @Override
    public TwelveTuple<Z, Z, Z, Z, Z, Z, Z, Z, Z, Z, Z, Z, Z> change(int index, Supplier<? extends Z> supplier) {
        checkIndex(index, size());
        return new TwelveTuple<>(index == 0 ? supplier.get() : first(),
                                 index == 1 ? supplier.get() : second(),
                                 index == 2 ? supplier.get() : third(),
                                 index == 3 ? supplier.get() : fourth(),
                                 index == 4 ? supplier.get() : fifth(),
                                 index == 5 ? supplier.get() : sixth(),
                                 index == 6 ? supplier.get() : seventh(),
                                 index == 7 ? supplier.get() : eighth(),
                                 index == 8 ? supplier.get() : ninth(),
                                 index == 9 ? supplier.get() : tenth(),
                                 index == 10 ? supplier.get() : eleventh(),
                                 index == 11 ? supplier.get() : twelfth());
    }

    @Override
    public TwelveTuple<Z, Z, Z, Z, Z, Z, Z, Z, Z, Z, Z, Z, Z> change(int index, Function<TwelveTuple<Z, A, B, C, D, E, F, G, H, I, J, K, L>, ? extends Z> function) {
        checkIndex(index, size());
        return new TwelveTuple<>(index == 0 ? function.apply(this) : first(),
                                 index == 1 ? function.apply(this) : second(),
                                 index == 2 ? function.apply(this) : third(),
                                 index == 3 ? function.apply(this) : fourth(),
                                 index == 4 ? function.apply(this) : fifth(),
                                 index == 5 ? function.apply(this) : sixth(),
                                 index == 6 ? function.apply(this) : seventh(),
                                 index == 7 ? function.apply(this) : eighth(),
                                 index == 8 ? function.apply(this) : ninth(),
                                 index == 9 ? function.apply(this) : tenth(),
                                 index == 10 ? function.apply(this) : eleventh(),
                                 index == 11 ? function.apply(this) : twelfth());
    }

    @Override
    public <X extends Z> ThirteenOrMoreTuple<Z, A, B, C, D, E, F, G, H, I, J, K, L> extend(X value) {
        return new ThirteenOrMoreTuple<>(first(), second(), third(), fourth(), fifth(), sixth(), seventh(), eighth(), ninth(), tenth(), eleventh(), twelfth(), value);
    }

    @Override
    public <X extends Z> ThirteenOrMoreTuple<Z, A, B, C, D, E, F, G, H, I, J, K, L> extend(Supplier<X> supplier) {
        return new ThirteenOrMoreTuple<>(first(), second(), third(), fourth(), fifth(), sixth(), seventh(), eighth(), ninth(), tenth(), eleventh(), twelfth(), supplier.get());
    }

    @Override
    public <X extends Z> ThirteenOrMoreTuple<Z, A, B, C, D, E, F, G, H, I, J, K, L> extend(Function<TwelveTuple<Z, A, B, C, D, E, F, G, H, I, J, K, L>, X> function) {
        return new ThirteenOrMoreTuple<>(first(), second(), third(), fourth(), fifth(), sixth(), seventh(), eighth(), ninth(), tenth(), eleventh(), twelfth(), function.apply(this));
    }

    @Override
    public <X extends Z> TwelveTuple<Z, X, B, C, D, E, F, G, H, I, J, K, L> first(X value) {
        return new TwelveTuple<>(value, second(), third(), fourth(), fifth(), sixth(), seventh(), eighth(), ninth(), tenth(), eleventh(), twelfth());
    }

    @Override
    public <X extends Z> TwelveTuple<Z, X, B, C, D, E, F, G, H, I, J, K, L> first(Supplier<X> supplier) {
        return new TwelveTuple<>(supplier.get(), second(), third(), fourth(), fifth(), sixth(), seventh(), eighth(), ninth(), tenth(), eleventh(), twelfth());
    }

    @Override
    public <X extends Z> TwelveTuple<Z, X, B, C, D, E, F, G, H, I, J, K, L> first(Function<A, X> function) {
        return new TwelveTuple<>(function.apply(first()), second(), third(), fourth(), fifth(), sixth(), seventh(), eighth(), ninth(), tenth(), eleventh(), twelfth());
    }

    @Override
    public ElevenTuple<Z, B, C, D, E, F, G, H, I, J, K, L> dropFirst() {
        return new ElevenTuple<>(second(), third(), fourth(), fifth(), sixth(), seventh(), eighth(), ninth(), tenth(), eleventh(), twelfth());
    }

    @Override
    public <X extends Z> TwelveTuple<Z, A, X, C, D, E, F, G, H, I, J, K, L> second(X value) {
        return new TwelveTuple<>(first(), value, third(), fourth(), fifth(), sixth(), seventh(), eighth(), ninth(), tenth(), eleventh(), twelfth());
    }

    @Override
    public <X extends Z> TwelveTuple<Z, A, X, C, D, E, F, G, H, I, J, K, L> second(Supplier<X> supplier) {
        return new TwelveTuple<>(first(), supplier.get(), third(), fourth(), fifth(), sixth(), seventh(), eighth(), ninth(), tenth(), eleventh(), twelfth());
    }

    @Override
    public <X extends Z> TwelveTuple<Z, A, X, C, D, E, F, G, H, I, J, K, L> second(Function<B, X> function) {
        return new TwelveTuple<>(first(), function.apply(second()), third(), fourth(), fifth(), sixth(), seventh(), eighth(), ninth(), tenth(), eleventh(), twelfth());
    }

    @Override
    public ElevenTuple<Z, A, C, D, E, F, G, H, I, J, K, L> dropSecond() {
        return new ElevenTuple<>(first(), third(), fourth(), fifth(), sixth(), seventh(), eighth(), ninth(), tenth(), eleventh(), twelfth());
    }

    @Override
    public <X extends Z> TwelveTuple<Z, A, B, X, D, E, F, G, H, I, J, K, L> third(X value) {
        return new TwelveTuple<>(first(), second(), value, fourth(), fifth(), sixth(), seventh(), eighth(), ninth(), tenth(), eleventh(), twelfth());
    }

    @Override
    public <X extends Z> TwelveTuple<Z, A, B, X, D, E, F, G, H, I, J, K, L> third(Supplier<X> supplier) {
        return new TwelveTuple<>(first(), second(), supplier.get(), fourth(), fifth(), sixth(), seventh(), eighth(), ninth(), tenth(), eleventh(), twelfth());
    }

    @Override
    public <X extends Z> TwelveTuple<Z, A, B, X, D, E, F, G, H, I, J, K, L> third(Function<C, X> function) {
        return new TwelveTuple<>(first(), second(), function.apply(third()), fourth(), fifth(), sixth(), seventh(), eighth(), ninth(), tenth(), eleventh(), twelfth());
    }

    @Override
    public ElevenTuple<Z, A, B, D, E, F, G, H, I, J, K, L> dropThird() {
        return new ElevenTuple<>(first(), second(), fourth(), fifth(), sixth(), seventh(), eighth(), ninth(), tenth(), eleventh(), twelfth());
    }

    @Override
    public <X extends Z> TwelveTuple<Z, A, B, C, X, E, F, G, H, I, J, K, L> fourth(X value) {
        return new TwelveTuple<>(first(), second(), third(), value, fifth(), sixth(), seventh(), eighth(), ninth(), tenth(), eleventh(), twelfth());
    }

    @Override
    public <X extends Z> TwelveTuple<Z, A, B, C, X, E, F, G, H, I, J, K, L> fourth(Supplier<X> supplier) {
        return new TwelveTuple<>(first(), second(), third(), supplier.get(), fifth(), sixth(), seventh(), eighth(), ninth(), tenth(), eleventh(), twelfth());
    }

    @Override
    public <X extends Z> TwelveTuple<Z, A, B, C, X, E, F, G, H, I, J, K, L> fourth(Function<D, X> function) {
        return new TwelveTuple<>(first(), second(), third(), function.apply(fourth()), fifth(), sixth(), seventh(), eighth(), ninth(), tenth(), eleventh(), twelfth());
    }

    @Override
    public ElevenTuple<Z, A, B, C, E, F, G, H, I, J, K, L> dropFourth() {
        return new ElevenTuple<>(first(), second(), third(), fifth(), sixth(), seventh(), eighth(), ninth(), tenth(), eleventh(), twelfth());
    }

    @Override
    public <X extends Z> TwelveTuple<Z, A, B, C, D, X, F, G, H, I, J, K, L> fifth(X value) {
        return new TwelveTuple<>(first(), second(), third(), fourth(), value, sixth(), seventh(), eighth(), ninth(), tenth(), eleventh(), twelfth());
    }

    @Override
    public <X extends Z> TwelveTuple<Z, A, B, C, D, X, F, G, H, I, J, K, L> fifth(Supplier<X> supplier) {
        return new TwelveTuple<>(first(), second(), third(), fourth(), supplier.get(), sixth(), seventh(), eighth(), ninth(), tenth(), eleventh(), twelfth());
    }

    @Override
    public <X extends Z> TwelveTuple<Z, A, B, C, D, X, F, G, H, I, J, K, L> fifth(Function<E, X> function) {
        return new TwelveTuple<>(first(), second(), third(), fourth(), function.apply(fifth()), sixth(), seventh(), eighth(), ninth(), tenth(), eleventh(), twelfth());
    }

    @Override
    public ElevenTuple<Z, A, B, C, D, F, G, H, I, J, K, L> dropFifth() {
        return new ElevenTuple<>(first(), second(), third(), fourth(), sixth(), seventh(), eighth(), ninth(), tenth(), eleventh(), twelfth());
    }

    @Override
    public <X extends Z> TwelveTuple<Z, A, B, C, D, E, X, G, H, I, J, K, L> sixth(X value) {
        return new TwelveTuple<>(first(), second(), third(), fourth(), fifth(), value, seventh(), eighth(), ninth(), tenth(), eleventh(), twelfth());
    }

    @Override
    public <X extends Z> TwelveTuple<Z, A, B, C, D, E, X, G, H, I, J, K, L> sixth(Supplier<X> supplier) {
        return new TwelveTuple<>(first(), second(), third(), fourth(), fifth(), supplier.get(), seventh(), eighth(), ninth(), tenth(), eleventh(), twelfth());
    }

    @Override
    public <X extends Z> TwelveTuple<Z, A, B, C, D, E, X, G, H, I, J, K, L> sixth(Function<F, X> function) {
        return new TwelveTuple<>(first(), second(), third(), fourth(), fifth(), function.apply(sixth()), seventh(), eighth(), ninth(), tenth(), eleventh(), twelfth());
    }

    @Override
    public ElevenTuple<Z, A, B, C, D, E, G, H, I, J, K, L> dropSixth() {
        return new ElevenTuple<>(first(), second(), third(), fourth(), fifth(), seventh(), eighth(), ninth(), tenth(), eleventh(), twelfth());
    }

    @Override
    public <X extends Z> TwelveTuple<Z, A, B, C, D, E, F, X, H, I, J, K, L> seventh(X value) {
        return new TwelveTuple<>(first(), second(), third(), fourth(), fifth(), sixth(), value, eighth(), ninth(), tenth(), eleventh(), twelfth());
    }

    @Override
    public <X extends Z> TwelveTuple<Z, A, B, C, D, E, F, X, H, I, J, K, L> seventh(Supplier<X> supplier) {
        return new TwelveTuple<>(first(), second(), third(), fourth(), fifth(), sixth(), supplier.get(), eighth(), ninth(), tenth(), eleventh(), twelfth());
    }

    @Override
    public <X extends Z> TwelveTuple<Z, A, B, C, D, E, F, X, H, I, J, K, L> seventh(Function<G, X> function) {
        return new TwelveTuple<>(first(), second(), third(), fourth(), fifth(), sixth(), function.apply(seventh()), eighth(), ninth(), tenth(), eleventh(), twelfth());
    }

    @Override
    public ElevenTuple<Z, A, B, C, D, E, F, H, I, J, K, L> dropSeventh() {
        return new ElevenTuple<>(first(), second(), third(), fourth(), fifth(), sixth(), eighth(), ninth(), tenth(), eleventh(), twelfth());
    }

    @Override
    public <X extends Z> TwelveTuple<Z, A, B, C, D, E, F, G, X, I, J, K, L> eighth(X value) {
        return new TwelveTuple<>(first(), second(), third(), fourth(), fifth(), sixth(), seventh(), value, ninth(), tenth(), eleventh(), twelfth());
    }

    @Override
    public <X extends Z> TwelveTuple<Z, A, B, C, D, E, F, G, X, I, J, K, L> eighth(Supplier<X> supplier) {
        return new TwelveTuple<>(first(), second(), third(), fourth(), fifth(), sixth(), seventh(), supplier.get(), ninth(), tenth(), eleventh(), twelfth());
    }

    @Override
    public <X extends Z> TwelveTuple<Z, A, B, C, D, E, F, G, X, I, J, K, L> eighth(Function<H, X> function) {
        return new TwelveTuple<>(first(), second(), third(), fourth(), fifth(), sixth(), seventh(), function.apply(eighth()), ninth(), tenth(), eleventh(), twelfth());
    }

    @Override
    public ElevenTuple<Z, A, B, C, D, E, F, G, I, J, K, L> dropEighth() {
        return new ElevenTuple<>(first(), second(), third(), fourth(), fifth(), sixth(), seventh(), ninth(), tenth(), eleventh(), twelfth());
    }

    @Override
    public <X extends Z> TwelveTuple<Z, A, B, C, D, E, F, G, H, X, J, K, L> ninth(X value) {
        return new TwelveTuple<>(first(), second(), third(), fourth(), fifth(), sixth(), seventh(), eighth(), value, tenth(), eleventh(), twelfth());
    }

    @Override
    public <X extends Z> TwelveTuple<Z, A, B, C, D, E, F, G, H, X, J, K, L> ninth(Supplier<X> supplier) {
        return new TwelveTuple<>(first(), second(), third(), fourth(), fifth(), sixth(), seventh(), eighth(), supplier.get(), tenth(), eleventh(), twelfth());
    }

    @Override
    public <X extends Z> TwelveTuple<Z, A, B, C, D, E, F, G, H, X, J, K, L> ninth(Function<I, X> function) {
        return new TwelveTuple<>(first(), second(), third(), fourth(), fifth(), sixth(), seventh(), eighth(), function.apply(ninth()), tenth(), eleventh(), twelfth());
    }

    @Override
    public ElevenTuple<Z, A, B, C, D, E, F, G, H, J, K, L> dropNinth() {
        return new ElevenTuple<>(first(), second(), third(), fourth(), fifth(), sixth(), seventh(), eighth(), tenth(), eleventh(), twelfth());
    }

    @Override
    public <X extends Z> TwelveTuple<Z, A, B, C, D, E, F, G, H, I, X, K, L> tenth(X value) {
        return new TwelveTuple<>(first(), second(), third(), fourth(), fifth(), sixth(), seventh(), eighth(), ninth(), value, eleventh(), twelfth());
    }

    @Override
    public <X extends Z> TwelveTuple<Z, A, B, C, D, E, F, G, H, I, X, K, L> tenth(Supplier<X> supplier) {
        return new TwelveTuple<>(first(), second(), third(), fourth(), fifth(), sixth(), seventh(), eighth(), ninth(), supplier.get(), eleventh(), twelfth());
    }

    @Override
    public <X extends Z> TwelveTuple<Z, A, B, C, D, E, F, G, H, I, X, K, L> tenth(Function<J, X> function) {
        return new TwelveTuple<>(first(), second(), third(), fourth(), fifth(), sixth(), seventh(), eighth(), ninth(), function.apply(tenth()), eleventh(), twelfth());
    }

    @Override
    public ElevenTuple<Z, A, B, C, D, E, F, G, H, I, K, L> dropTenth() {
        return new ElevenTuple<>(first(), second(), third(), fourth(), fifth(), sixth(), seventh(), eighth(), ninth(), eleventh(), twelfth());
    }

    @Override
    public <X extends Z> TwelveTuple<Z, A, B, C, D, E, F, G, H, I, J, X, L> eleventh(X value) {
        return new TwelveTuple<>(first(), second(), third(), fourth(), fifth(), sixth(), seventh(), eighth(), ninth(), tenth(), value, twelfth());
    }

    @Override
    public <X extends Z> TwelveTuple<Z, A, B, C, D, E, F, G, H, I, J, X, L> eleventh(Supplier<X> supplier) {
        return new TwelveTuple<>(first(), second(), third(), fourth(), fifth(), sixth(), seventh(), eighth(), ninth(), tenth(), supplier.get(), twelfth());
    }

    @Override
    public <X extends Z> TwelveTuple<Z, A, B, C, D, E, F, G, H, I, J, X, L> eleventh(Function<K, X> function) {
        return new TwelveTuple<>(first(), second(), third(), fourth(), fifth(), sixth(), seventh(), eighth(), ninth(), tenth(), function.apply(eleventh()), twelfth());
    }

    @Override
    public ElevenTuple<Z, A, B, C, D, E, F, G, H, I, J, L> dropEleventh() {
        return new ElevenTuple<>(first(), second(), third(), fourth(), fifth(), sixth(), seventh(), eighth(), ninth(), tenth(), twelfth());
    }

    @Override
    public <X extends Z> TwelveTuple<Z, A, B, C, D, E, F, G, H, I, J, K, X> twelfth(X value) {
        return new TwelveTuple<>(first(), second(), third(), fourth(), fifth(), sixth(), seventh(), eighth(), ninth(), tenth(), eleventh(), value);
    }

    @Override
    public <X extends Z> TwelveTuple<Z, A, B, C, D, E, F, G, H, I, J, K, X> twelfth(Supplier<X> supplier) {
        return new TwelveTuple<>(first(), second(), third(), fourth(), fifth(), sixth(), seventh(), eighth(), ninth(), tenth(), eleventh(), supplier.get());
    }

    @Override
    public <X extends Z> TwelveTuple<Z, A, B, C, D, E, F, G, H, I, J, K, X> twelfth(Function<L, X> function) {
        return new TwelveTuple<>(first(), second(), third(), fourth(), fifth(), sixth(), seventh(), eighth(), ninth(), tenth(), eleventh(), function.apply(twelfth()));
    }

    @Override
    public ElevenTuple<Z, A, B, C, D, E, F, G, H, I, J, K> dropTwelfth() {
        return new ElevenTuple<>(first(), second(), third(), fourth(), fifth(), sixth(), seventh(), eighth(), ninth(), tenth(), eleventh());
    }

    public static <Z, A extends Z, B extends Z, C extends Z, D extends Z, E extends Z, F extends Z, G extends Z, H extends Z, I extends Z, J extends Z, K extends Z, L extends Z, X extends Z> Function<TwelveTuple<Z, A, B, C, D, E, F, G, H, I, J, K, L>, ThirteenOrMoreTuple<Z, A, B, C, D, E, F, G, H, I, J, K, L>> extendWith(X value) {
        return tuple -> tuple.extend(value);
    }

    public static <Z, A extends Z, B extends Z, C extends Z, D extends Z, E extends Z, F extends Z, G extends Z, H extends Z, I extends Z, J extends Z, K extends Z, L extends Z, X extends Z> Function<TwelveTuple<Z, A, B, C, D, E, F, G, H, I, J, K, L>, ThirteenOrMoreTuple<Z, A, B, C, D, E, F, G, H, I, J, K, L>> extendWith(Supplier<X> supplier) {
        return tuple -> tuple.extend(supplier);
    }

    public static <Z, A extends Z, B extends Z, C extends Z, D extends Z, E extends Z, F extends Z, G extends Z, H extends Z, I extends Z, J extends Z, K extends Z, L extends Z, X extends Z> Function<TwelveTuple<Z, A, B, C, D, E, F, G, H, I, J, K, L>, ThirteenOrMoreTuple<Z, A, B, C, D, E, F, G, H, I, J, K, L>> extendWith(
            Function<TwelveTuple<Z, A, B, C, D, E, F, G, H, I, J, K, L>, X> function) {
        return tuple -> tuple.extend(function);
    }

    public static <Z, A extends Z, B extends Z, C extends Z, D extends Z, E extends Z, F extends Z, G extends Z, H extends Z, I extends Z, J extends Z, K extends Z, L extends Z> TwelveTuple<Z, A, B, C, D, E, F, G, H, I, J, K, L> of(A first, B second, C third, D fourth, E fifth, F sixth, G seventh, H eighth, I ninth, J tenth, K eleventh,
            L twelfth) {
        return new TwelveTuple<>(first, second, third, fourth, fifth, sixth, seventh, eighth, ninth, tenth, eleventh, twelfth);
    }

}


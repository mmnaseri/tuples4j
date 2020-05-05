package com.mmnaseri.utils.tuples.impl;

import com.mmnaseri.utils.tuples.facade.*;

import java.util.function.Function;
import java.util.function.Supplier;

import static com.mmnaseri.utils.tuples.utils.TupleUtils.checkIndex;

public class ElevenTuple<Z, A extends Z, B extends Z, C extends Z, D extends Z, E extends Z, F extends Z, G extends Z, H extends Z, I extends Z, J extends Z, K extends Z> extends AbstractFixedTuple<Z, ElevenTuple<Z, A, B, C, D, E, F, G, H, I, J, K>>
        implements
        HasFirst<Z, A, ElevenTuple<Z, A, B, C, D, E, F, G, H, I, J, K>>,
        HasSecond<Z, B, ElevenTuple<Z, A, B, C, D, E, F, G, H, I, J, K>>,
        HasThird<Z, C, ElevenTuple<Z, A, B, C, D, E, F, G, H, I, J, K>>,
        HasFourth<Z, D, ElevenTuple<Z, A, B, C, D, E, F, G, H, I, J, K>>,
        HasFifth<Z, E, ElevenTuple<Z, A, B, C, D, E, F, G, H, I, J, K>>,
        HasSixth<Z, F, ElevenTuple<Z, A, B, C, D, E, F, G, H, I, J, K>>,
        HasSeventh<Z, G, ElevenTuple<Z, A, B, C, D, E, F, G, H, I, J, K>>,
        HasEighth<Z, H, ElevenTuple<Z, A, B, C, D, E, F, G, H, I, J, K>>,
        HasNinth<Z, I, ElevenTuple<Z, A, B, C, D, E, F, G, H, I, J, K>>,
        HasTenth<Z, J, ElevenTuple<Z, A, B, C, D, E, F, G, H, I, J, K>>,
        HasEleventh<Z, K, ElevenTuple<Z, A, B, C, D, E, F, G, H, I, J, K>> {

    public ElevenTuple(A first, B second, C third, D fourth, E fifth, F sixth, G seventh, H eighth, I ninth, J tenth, K eleventh) {
        super(first, second, third, fourth, fifth, sixth, seventh, eighth, ninth, tenth, eleventh);
    }

    @Override
    public ElevenTuple<Z, Z, Z, Z, Z, Z, Z, Z, Z, Z, Z, Z> change(int index, Supplier<? extends Z> supplier) {
        checkIndex(index, size());
        return new ElevenTuple<>(index == 0 ? supplier.get() : first(),
                                 index == 1 ? supplier.get() : second(),
                                 index == 2 ? supplier.get() : third(),
                                 index == 3 ? supplier.get() : fourth(),
                                 index == 4 ? supplier.get() : fifth(),
                                 index == 5 ? supplier.get() : sixth(),
                                 index == 6 ? supplier.get() : seventh(),
                                 index == 7 ? supplier.get() : eighth(),
                                 index == 8 ? supplier.get() : ninth(),
                                 index == 9 ? supplier.get() : tenth(),
                                 index == 10 ? supplier.get() : eleventh());
    }

    @Override
    public ElevenTuple<Z, Z, Z, Z, Z, Z, Z, Z, Z, Z, Z, Z> change(int index, Function<ElevenTuple<Z, A, B, C, D, E, F, G, H, I, J, K>, ? extends Z> function) {
        checkIndex(index, size());
        return new ElevenTuple<>(index == 0 ? function.apply(this) : first(),
                                 index == 1 ? function.apply(this) : second(),
                                 index == 2 ? function.apply(this) : third(),
                                 index == 3 ? function.apply(this) : fourth(),
                                 index == 4 ? function.apply(this) : fifth(),
                                 index == 5 ? function.apply(this) : sixth(),
                                 index == 6 ? function.apply(this) : seventh(),
                                 index == 7 ? function.apply(this) : eighth(),
                                 index == 8 ? function.apply(this) : ninth(),
                                 index == 9 ? function.apply(this) : tenth(),
                                 index == 10 ? function.apply(this) : eleventh());
    }

    @Override
    public <X extends Z> TwelveTuple<Z, A, B, C, D, E, F, G, H, I, J, K, X> extend(X value) {
        return new TwelveTuple<>(first(), second(), third(), fourth(), fifth(), sixth(), seventh(), eighth(), ninth(), tenth(), eleventh(), value);
    }

    @Override
    public <X extends Z> TwelveTuple<Z, A, B, C, D, E, F, G, H, I, J, K, X> extend(Supplier<X> supplier) {
        return new TwelveTuple<>(first(), second(), third(), fourth(), fifth(), sixth(), seventh(), eighth(), ninth(), tenth(), eleventh(), supplier.get());
    }

    @Override
    public <X extends Z> TwelveTuple<Z, A, B, C, D, E, F, G, H, I, J, K, X> extend(Function<ElevenTuple<Z, A, B, C, D, E, F, G, H, I, J, K>, X> function) {
        return new TwelveTuple<>(first(), second(), third(), fourth(), fifth(), sixth(), seventh(), eighth(), ninth(), tenth(), eleventh(), function.apply(this));
    }

    @Override
    public <X extends Z> ElevenTuple<Z, X, B, C, D, E, F, G, H, I, J, K> first(X value) {
        return new ElevenTuple<>(value, second(), third(), fourth(), fifth(), sixth(), seventh(), eighth(), ninth(), tenth(), eleventh());
    }

    @Override
    public <X extends Z> ElevenTuple<Z, X, B, C, D, E, F, G, H, I, J, K> first(Supplier<X> supplier) {
        return new ElevenTuple<>(supplier.get(), second(), third(), fourth(), fifth(), sixth(), seventh(), eighth(), ninth(), tenth(), eleventh());
    }

    @Override
    public <X extends Z> ElevenTuple<Z, X, B, C, D, E, F, G, H, I, J, K> first(Function<A, X> function) {
        return new ElevenTuple<>(function.apply(first()), second(), third(), fourth(), fifth(), sixth(), seventh(), eighth(), ninth(), tenth(), eleventh());
    }

    @Override
    public TenTuple<Z, B, C, D, E, F, G, H, I, J, K> dropFirst() {
        return new TenTuple<>(second(), third(), fourth(), fifth(), sixth(), seventh(), eighth(), ninth(), tenth(), eleventh());
    }

    @Override
    public <X extends Z> ElevenTuple<Z, A, X, C, D, E, F, G, H, I, J, K> second(X value) {
        return new ElevenTuple<>(first(), value, third(), fourth(), fifth(), sixth(), seventh(), eighth(), ninth(), tenth(), eleventh());
    }

    @Override
    public <X extends Z> ElevenTuple<Z, A, X, C, D, E, F, G, H, I, J, K> second(Supplier<X> supplier) {
        return new ElevenTuple<>(first(), supplier.get(), third(), fourth(), fifth(), sixth(), seventh(), eighth(), ninth(), tenth(), eleventh());
    }

    @Override
    public <X extends Z> ElevenTuple<Z, A, X, C, D, E, F, G, H, I, J, K> second(Function<B, X> function) {
        return new ElevenTuple<>(first(), function.apply(second()), third(), fourth(), fifth(), sixth(), seventh(), eighth(), ninth(), tenth(), eleventh());
    }

    @Override
    public TenTuple<Z, A, C, D, E, F, G, H, I, J, K> dropSecond() {
        return new TenTuple<>(first(), third(), fourth(), fifth(), sixth(), seventh(), eighth(), ninth(), tenth(), eleventh());
    }

    @Override
    public <X extends Z> ElevenTuple<Z, A, B, X, D, E, F, G, H, I, J, K> third(X value) {
        return new ElevenTuple<>(first(), second(), value, fourth(), fifth(), sixth(), seventh(), eighth(), ninth(), tenth(), eleventh());
    }

    @Override
    public <X extends Z> ElevenTuple<Z, A, B, X, D, E, F, G, H, I, J, K> third(Supplier<X> supplier) {
        return new ElevenTuple<>(first(), second(), supplier.get(), fourth(), fifth(), sixth(), seventh(), eighth(), ninth(), tenth(), eleventh());
    }

    @Override
    public <X extends Z> ElevenTuple<Z, A, B, X, D, E, F, G, H, I, J, K> third(Function<C, X> function) {
        return new ElevenTuple<>(first(), second(), function.apply(third()), fourth(), fifth(), sixth(), seventh(), eighth(), ninth(), tenth(), eleventh());
    }

    @Override
    public TenTuple<Z, A, B, D, E, F, G, H, I, J, K> dropThird() {
        return new TenTuple<>(first(), second(), fourth(), fifth(), sixth(), seventh(), eighth(), ninth(), tenth(), eleventh());
    }

    @Override
    public <X extends Z> ElevenTuple<Z, A, B, C, X, E, F, G, H, I, J, K> fourth(X value) {
        return new ElevenTuple<>(first(), second(), third(), value, fifth(), sixth(), seventh(), eighth(), ninth(), tenth(), eleventh());
    }

    @Override
    public <X extends Z> ElevenTuple<Z, A, B, C, X, E, F, G, H, I, J, K> fourth(Supplier<X> supplier) {
        return new ElevenTuple<>(first(), second(), third(), supplier.get(), fifth(), sixth(), seventh(), eighth(), ninth(), tenth(), eleventh());
    }

    @Override
    public <X extends Z> ElevenTuple<Z, A, B, C, X, E, F, G, H, I, J, K> fourth(Function<D, X> function) {
        return new ElevenTuple<>(first(), second(), third(), function.apply(fourth()), fifth(), sixth(), seventh(), eighth(), ninth(), tenth(), eleventh());
    }

    @Override
    public TenTuple<Z, A, B, C, E, F, G, H, I, J, K> dropFourth() {
        return new TenTuple<>(first(), second(), third(), fifth(), sixth(), seventh(), eighth(), ninth(), tenth(), eleventh());
    }

    @Override
    public <X extends Z> ElevenTuple<Z, A, B, C, D, X, F, G, H, I, J, K> fifth(X value) {
        return new ElevenTuple<>(first(), second(), third(), fourth(), value, sixth(), seventh(), eighth(), ninth(), tenth(), eleventh());
    }

    @Override
    public <X extends Z> ElevenTuple<Z, A, B, C, D, X, F, G, H, I, J, K> fifth(Supplier<X> supplier) {
        return new ElevenTuple<>(first(), second(), third(), fourth(), supplier.get(), sixth(), seventh(), eighth(), ninth(), tenth(), eleventh());
    }

    @Override
    public <X extends Z> ElevenTuple<Z, A, B, C, D, X, F, G, H, I, J, K> fifth(Function<E, X> function) {
        return new ElevenTuple<>(first(), second(), third(), fourth(), function.apply(fifth()), sixth(), seventh(), eighth(), ninth(), tenth(), eleventh());
    }

    @Override
    public TenTuple<Z, A, B, C, D, F, G, H, I, J, K> dropFifth() {
        return new TenTuple<>(first(), second(), third(), fourth(), sixth(), seventh(), eighth(), ninth(), tenth(), eleventh());
    }

    @Override
    public <X extends Z> ElevenTuple<Z, A, B, C, D, E, X, G, H, I, J, K> sixth(X value) {
        return new ElevenTuple<>(first(), second(), third(), fourth(), fifth(), value, seventh(), eighth(), ninth(), tenth(), eleventh());
    }

    @Override
    public <X extends Z> ElevenTuple<Z, A, B, C, D, E, X, G, H, I, J, K> sixth(Supplier<X> supplier) {
        return new ElevenTuple<>(first(), second(), third(), fourth(), fifth(), supplier.get(), seventh(), eighth(), ninth(), tenth(), eleventh());
    }

    @Override
    public <X extends Z> ElevenTuple<Z, A, B, C, D, E, X, G, H, I, J, K> sixth(Function<F, X> function) {
        return new ElevenTuple<>(first(), second(), third(), fourth(), fifth(), function.apply(sixth()), seventh(), eighth(), ninth(), tenth(), eleventh());
    }

    @Override
    public TenTuple<Z, A, B, C, D, E, G, H, I, J, K> dropSixth() {
        return new TenTuple<>(first(), second(), third(), fourth(), fifth(), seventh(), eighth(), ninth(), tenth(), eleventh());
    }

    @Override
    public <X extends Z> ElevenTuple<Z, A, B, C, D, E, F, X, H, I, J, K> seventh(X value) {
        return new ElevenTuple<>(first(), second(), third(), fourth(), fifth(), sixth(), value, eighth(), ninth(), tenth(), eleventh());
    }

    @Override
    public <X extends Z> ElevenTuple<Z, A, B, C, D, E, F, X, H, I, J, K> seventh(Supplier<X> supplier) {
        return new ElevenTuple<>(first(), second(), third(), fourth(), fifth(), sixth(), supplier.get(), eighth(), ninth(), tenth(), eleventh());
    }

    @Override
    public <X extends Z> ElevenTuple<Z, A, B, C, D, E, F, X, H, I, J, K> seventh(Function<G, X> function) {
        return new ElevenTuple<>(first(), second(), third(), fourth(), fifth(), sixth(), function.apply(seventh()), eighth(), ninth(), tenth(), eleventh());
    }

    @Override
    public TenTuple<Z, A, B, C, D, E, F, H, I, J, K> dropSeventh() {
        return new TenTuple<>(first(), second(), third(), fourth(), fifth(), sixth(), eighth(), ninth(), tenth(), eleventh());
    }

    @Override
    public <X extends Z> ElevenTuple<Z, A, B, C, D, E, F, G, X, I, J, K> eighth(X value) {
        return new ElevenTuple<>(first(), second(), third(), fourth(), fifth(), sixth(), seventh(), value, ninth(), tenth(), eleventh());
    }

    @Override
    public <X extends Z> ElevenTuple<Z, A, B, C, D, E, F, G, X, I, J, K> eighth(Supplier<X> supplier) {
        return new ElevenTuple<>(first(), second(), third(), fourth(), fifth(), sixth(), seventh(), supplier.get(), ninth(), tenth(), eleventh());
    }

    @Override
    public <X extends Z> ElevenTuple<Z, A, B, C, D, E, F, G, X, I, J, K> eighth(Function<H, X> function) {
        return new ElevenTuple<>(first(), second(), third(), fourth(), fifth(), sixth(), seventh(), function.apply(eighth()), ninth(), tenth(), eleventh());
    }

    @Override
    public TenTuple<Z, A, B, C, D, E, F, G, I, J, K> dropEighth() {
        return new TenTuple<>(first(), second(), third(), fourth(), fifth(), sixth(), seventh(), ninth(), tenth(), eleventh());
    }

    @Override
    public <X extends Z> ElevenTuple<Z, A, B, C, D, E, F, G, H, X, J, K> ninth(X value) {
        return new ElevenTuple<>(first(), second(), third(), fourth(), fifth(), sixth(), seventh(), eighth(), value, tenth(), eleventh());
    }

    @Override
    public <X extends Z> ElevenTuple<Z, A, B, C, D, E, F, G, H, X, J, K> ninth(Supplier<X> supplier) {
        return new ElevenTuple<>(first(), second(), third(), fourth(), fifth(), sixth(), seventh(), eighth(), supplier.get(), tenth(), eleventh());
    }

    @Override
    public <X extends Z> ElevenTuple<Z, A, B, C, D, E, F, G, H, X, J, K> ninth(Function<I, X> function) {
        return new ElevenTuple<>(first(), second(), third(), fourth(), fifth(), sixth(), seventh(), eighth(), function.apply(ninth()), tenth(), eleventh());
    }

    @Override
    public TenTuple<Z, A, B, C, D, E, F, G, H, J, K> dropNinth() {
        return new TenTuple<>(first(), second(), third(), fourth(), fifth(), sixth(), seventh(), eighth(), tenth(), eleventh());
    }

    @Override
    public <X extends Z> ElevenTuple<Z, A, B, C, D, E, F, G, H, I, X, K> tenth(X value) {
        return new ElevenTuple<>(first(), second(), third(), fourth(), fifth(), sixth(), seventh(), eighth(), ninth(), value, eleventh());
    }

    @Override
    public <X extends Z> ElevenTuple<Z, A, B, C, D, E, F, G, H, I, X, K> tenth(Supplier<X> supplier) {
        return new ElevenTuple<>(first(), second(), third(), fourth(), fifth(), sixth(), seventh(), eighth(), ninth(), supplier.get(), eleventh());
    }

    @Override
    public <X extends Z> ElevenTuple<Z, A, B, C, D, E, F, G, H, I, X, K> tenth(Function<J, X> function) {
        return new ElevenTuple<>(first(), second(), third(), fourth(), fifth(), sixth(), seventh(), eighth(), ninth(), function.apply(tenth()), eleventh());
    }

    @Override
    public TenTuple<Z, A, B, C, D, E, F, G, H, I, K> dropTenth() {
        return new TenTuple<>(first(), second(), third(), fourth(), fifth(), sixth(), seventh(), eighth(), ninth(), eleventh());
    }

    @Override
    public <X extends Z> ElevenTuple<Z, A, B, C, D, E, F, G, H, I, J, X> eleventh(X value) {
        return new ElevenTuple<>(first(), second(), third(), fourth(), fifth(), sixth(), seventh(), eighth(), ninth(), tenth(), value);
    }

    @Override
    public <X extends Z> ElevenTuple<Z, A, B, C, D, E, F, G, H, I, J, X> eleventh(Supplier<X> supplier) {
        return new ElevenTuple<>(first(), second(), third(), fourth(), fifth(), sixth(), seventh(), eighth(), ninth(), tenth(), supplier.get());
    }

    @Override
    public <X extends Z> ElevenTuple<Z, A, B, C, D, E, F, G, H, I, J, X> eleventh(Function<K, X> function) {
        return new ElevenTuple<>(first(), second(), third(), fourth(), fifth(), sixth(), seventh(), eighth(), ninth(), tenth(), function.apply(eleventh()));
    }

    @Override
    public TenTuple<Z, A, B, C, D, E, F, G, H, I, J> dropEleventh() {
        return new TenTuple<>(first(), second(), third(), fourth(), fifth(), sixth(), seventh(), eighth(), ninth(), tenth());
    }

    public static <Z, A extends Z, B extends Z, C extends Z, D extends Z, E extends Z, F extends Z, G extends Z, H extends Z, I extends Z, J extends Z, K extends Z, X extends Z> Function<ElevenTuple<Z, A, B, C, D, E, F, G, H, I, J, K>, TwelveTuple<Z, A, B, C, D, E, F, G, H, I, J, K, X>> extendWith(X value) {
        return tuple -> tuple.extend(value);
    }

    public static <Z, A extends Z, B extends Z, C extends Z, D extends Z, E extends Z, F extends Z, G extends Z, H extends Z, I extends Z, J extends Z, K extends Z, X extends Z> Function<ElevenTuple<Z, A, B, C, D, E, F, G, H, I, J, K>, TwelveTuple<Z, A, B, C, D, E, F, G, H, I, J, K, X>> extendWith(Supplier<X> supplier) {
        return tuple -> tuple.extend(supplier);
    }

    public static <Z, A extends Z, B extends Z, C extends Z, D extends Z, E extends Z, F extends Z, G extends Z, H extends Z, I extends Z, J extends Z, K extends Z, X extends Z> Function<ElevenTuple<Z, A, B, C, D, E, F, G, H, I, J, K>, TwelveTuple<Z, A, B, C, D, E, F, G, H, I, J, K, X>> extendWith(
            Function<ElevenTuple<Z, A, B, C, D, E, F, G, H, I, J, K>, X> function) {
        return tuple -> tuple.extend(function);
    }

    public static <Z, A extends Z, B extends Z, C extends Z, D extends Z, E extends Z, F extends Z, G extends Z, H extends Z, I extends Z, J extends Z, K extends Z> ElevenTuple<Z, A, B, C, D, E, F, G, H, I, J, K> of(A first, B second, C third, D fourth, E fifth, F sixth, G seventh, H eighth, I ninth, J tenth, K eleventh) {
        return new ElevenTuple<>(first, second, third, fourth, fifth, sixth, seventh, eighth, ninth, tenth, eleventh);
    }

}


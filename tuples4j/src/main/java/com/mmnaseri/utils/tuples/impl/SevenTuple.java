package com.mmnaseri.utils.tuples.impl;

import com.mmnaseri.utils.tuples.facade.*;

import java.util.function.Function;
import java.util.function.Supplier;

import static com.mmnaseri.utils.tuples.utils.TupleUtils.checkIndex;

public class SevenTuple<Z, A extends Z, B extends Z, C extends Z, D extends Z, E extends Z, F extends Z, G extends Z> extends AbstractFixedTuple<Z, SevenTuple<Z, A, B, C, D, E, F, G>>
        implements
        HasFirst<Z, A, SevenTuple<Z, A, B, C, D, E, F, G>>,
        HasSecond<Z, B, SevenTuple<Z, A, B, C, D, E, F, G>>,
        HasThird<Z, C, SevenTuple<Z, A, B, C, D, E, F, G>>,
        HasFourth<Z, D, SevenTuple<Z, A, B, C, D, E, F, G>>,
        HasFifth<Z, E, SevenTuple<Z, A, B, C, D, E, F, G>>,
        HasSixth<Z, F, SevenTuple<Z, A, B, C, D, E, F, G>>,
        HasSeventh<Z, G, SevenTuple<Z, A, B, C, D, E, F, G>> {

    public SevenTuple(A first, B second, C third, D fourth, E fifth, F sixth, G seventh) {
        super(first, second, third, fourth, fifth, sixth, seventh);
    }

    @Override
    public SevenTuple<Z, Z, Z, Z, Z, Z, Z, Z> change(int index, Supplier<? extends Z> supplier) {
        checkIndex(index, size());
        return new SevenTuple<>(index == 0 ? supplier.get() : first(),
                                index == 1 ? supplier.get() : second(),
                                index == 2 ? supplier.get() : third(),
                                index == 3 ? supplier.get() : fourth(),
                                index == 4 ? supplier.get() : fifth(),
                                index == 5 ? supplier.get() : sixth(),
                                index == 6 ? supplier.get() : seventh());
    }

    @Override
    public SevenTuple<Z, Z, Z, Z, Z, Z, Z, Z> change(int index, Function<SevenTuple<Z, A, B, C, D, E, F, G>, ? extends Z> function) {
        checkIndex(index, size());
        return new SevenTuple<>(index == 0 ? function.apply(this) : first(),
                                index == 1 ? function.apply(this) : second(),
                                index == 2 ? function.apply(this) : third(),
                                index == 3 ? function.apply(this) : fourth(),
                                index == 4 ? function.apply(this) : fifth(),
                                index == 5 ? function.apply(this) : sixth(),
                                index == 6 ? function.apply(this) : seventh());
    }

    @Override
    public <X extends Z> EightTuple<Z, A, B, C, D, E, F, G, X> extend(X value) {
        return new EightTuple<>(first(), second(), third(), fourth(), fifth(), sixth(), seventh(), value);
    }

    @Override
    public <X extends Z> EightTuple<Z, A, B, C, D, E, F, G, X> extend(Supplier<X> supplier) {
        return new EightTuple<>(first(), second(), third(), fourth(), fifth(), sixth(), seventh(), supplier.get());
    }

    @Override
    public <X extends Z> EightTuple<Z, A, B, C, D, E, F, G, X> extend(Function<SevenTuple<Z, A, B, C, D, E, F, G>, X> function) {
        return new EightTuple<>(first(), second(), third(), fourth(), fifth(), sixth(), seventh(), function.apply(this));
    }

    @Override
    public <X extends Z> SevenTuple<Z, X, B, C, D, E, F, G> first(X value) {
        return new SevenTuple<>(value, second(), third(), fourth(), fifth(), sixth(), seventh());
    }

    @Override
    public <X extends Z> SevenTuple<Z, X, B, C, D, E, F, G> first(Supplier<X> supplier) {
        return new SevenTuple<>(supplier.get(), second(), third(), fourth(), fifth(), sixth(), seventh());
    }

    @Override
    public <X extends Z> SevenTuple<Z, X, B, C, D, E, F, G> first(Function<A, X> function) {
        return new SevenTuple<>(function.apply(first()), second(), third(), fourth(), fifth(), sixth(), seventh());
    }

    @Override
    public SixTuple<Z, B, C, D, E, F, G> dropFirst() {
        return new SixTuple<>(second(), third(), fourth(), fifth(), sixth(), seventh());
    }

    @Override
    public <X extends Z> SevenTuple<Z, A, X, C, D, E, F, G> second(X value) {
        return new SevenTuple<>(first(), value, third(), fourth(), fifth(), sixth(), seventh());
    }

    @Override
    public <X extends Z> SevenTuple<Z, A, X, C, D, E, F, G> second(Supplier<X> supplier) {
        return new SevenTuple<>(first(), supplier.get(), third(), fourth(), fifth(), sixth(), seventh());
    }

    @Override
    public <X extends Z> SevenTuple<Z, A, X, C, D, E, F, G> second(Function<B, X> function) {
        return new SevenTuple<>(first(), function.apply(second()), third(), fourth(), fifth(), sixth(), seventh());
    }

    @Override
    public SixTuple<Z, A, C, D, E, F, G> dropSecond() {
        return new SixTuple<>(first(), third(), fourth(), fifth(), sixth(), seventh());
    }

    @Override
    public <X extends Z> SevenTuple<Z, A, B, X, D, E, F, G> third(X value) {
        return new SevenTuple<>(first(), second(), value, fourth(), fifth(), sixth(), seventh());
    }

    @Override
    public <X extends Z> SevenTuple<Z, A, B, X, D, E, F, G> third(Supplier<X> supplier) {
        return new SevenTuple<>(first(), second(), supplier.get(), fourth(), fifth(), sixth(), seventh());
    }

    @Override
    public <X extends Z> SevenTuple<Z, A, B, X, D, E, F, G> third(Function<C, X> function) {
        return new SevenTuple<>(first(), second(), function.apply(third()), fourth(), fifth(), sixth(), seventh());
    }

    @Override
    public SixTuple<Z, A, B, D, E, F, G> dropThird() {
        return new SixTuple<>(first(), second(), fourth(), fifth(), sixth(), seventh());
    }

    @Override
    public <X extends Z> SevenTuple<Z, A, B, C, X, E, F, G> fourth(X value) {
        return new SevenTuple<>(first(), second(), third(), value, fifth(), sixth(), seventh());
    }

    @Override
    public <X extends Z> SevenTuple<Z, A, B, C, X, E, F, G> fourth(Supplier<X> supplier) {
        return new SevenTuple<>(first(), second(), third(), supplier.get(), fifth(), sixth(), seventh());
    }

    @Override
    public <X extends Z> SevenTuple<Z, A, B, C, X, E, F, G> fourth(Function<D, X> function) {
        return new SevenTuple<>(first(), second(), third(), function.apply(fourth()), fifth(), sixth(), seventh());
    }

    @Override
    public SixTuple<Z, A, B, C, E, F, G> dropFourth() {
        return new SixTuple<>(first(), second(), third(), fifth(), sixth(), seventh());
    }

    @Override
    public <X extends Z> SevenTuple<Z, A, B, C, D, X, F, G> fifth(X value) {
        return new SevenTuple<>(first(), second(), third(), fourth(), value, sixth(), seventh());
    }

    @Override
    public <X extends Z> SevenTuple<Z, A, B, C, D, X, F, G> fifth(Supplier<X> supplier) {
        return new SevenTuple<>(first(), second(), third(), fourth(), supplier.get(), sixth(), seventh());
    }

    @Override
    public <X extends Z> SevenTuple<Z, A, B, C, D, X, F, G> fifth(Function<E, X> function) {
        return new SevenTuple<>(first(), second(), third(), fourth(), function.apply(fifth()), sixth(), seventh());
    }

    @Override
    public SixTuple<Z, A, B, C, D, F, G> dropFifth() {
        return new SixTuple<>(first(), second(), third(), fourth(), sixth(), seventh());
    }

    @Override
    public <X extends Z> SevenTuple<Z, A, B, C, D, E, X, G> sixth(X value) {
        return new SevenTuple<>(first(), second(), third(), fourth(), fifth(), value, seventh());
    }

    @Override
    public <X extends Z> SevenTuple<Z, A, B, C, D, E, X, G> sixth(Supplier<X> supplier) {
        return new SevenTuple<>(first(), second(), third(), fourth(), fifth(), supplier.get(), seventh());
    }

    @Override
    public <X extends Z> SevenTuple<Z, A, B, C, D, E, X, G> sixth(Function<F, X> function) {
        return new SevenTuple<>(first(), second(), third(), fourth(), fifth(), function.apply(sixth()), seventh());
    }

    @Override
    public SixTuple<Z, A, B, C, D, E, G> dropSixth() {
        return new SixTuple<>(first(), second(), third(), fourth(), fifth(), seventh());
    }

    @Override
    public <X extends Z> SevenTuple<Z, A, B, C, D, E, F, X> seventh(X value) {
        return new SevenTuple<>(first(), second(), third(), fourth(), fifth(), sixth(), value);
    }

    @Override
    public <X extends Z> SevenTuple<Z, A, B, C, D, E, F, X> seventh(Supplier<X> supplier) {
        return new SevenTuple<>(first(), second(), third(), fourth(), fifth(), sixth(), supplier.get());
    }

    @Override
    public <X extends Z> SevenTuple<Z, A, B, C, D, E, F, X> seventh(Function<G, X> function) {
        return new SevenTuple<>(first(), second(), third(), fourth(), fifth(), sixth(), function.apply(seventh()));
    }

    @Override
    public SixTuple<Z, A, B, C, D, E, F> dropSeventh() {
        return new SixTuple<>(first(), second(), third(), fourth(), fifth(), sixth());
    }

    public static <Z, A extends Z, B extends Z, C extends Z, D extends Z, E extends Z, F extends Z, G extends Z, X extends Z> Function<SevenTuple<Z, A, B, C, D, E, F, G>, EightTuple<Z, A, B, C, D, E, F, G, X>> extendWith(X value) {
        return tuple -> tuple.extend(value);
    }

    public static <Z, A extends Z, B extends Z, C extends Z, D extends Z, E extends Z, F extends Z, G extends Z, X extends Z> Function<SevenTuple<Z, A, B, C, D, E, F, G>, EightTuple<Z, A, B, C, D, E, F, G, X>> extendWith(Supplier<X> supplier) {
        return tuple -> tuple.extend(supplier);
    }

    public static <Z, A extends Z, B extends Z, C extends Z, D extends Z, E extends Z, F extends Z, G extends Z, X extends Z> Function<SevenTuple<Z, A, B, C, D, E, F, G>, EightTuple<Z, A, B, C, D, E, F, G, X>> extendWith(Function<SevenTuple<Z, A, B, C, D, E, F, G>, X> function) {
        return tuple -> tuple.extend(function);
    }

    public static <Z, A extends Z, B extends Z, C extends Z, D extends Z, E extends Z, F extends Z, G extends Z> SevenTuple<Z, A, B, C, D, E, F, G> of(A first, B second, C third, D fourth, E fifth, F sixth, G seventh) {
        return new SevenTuple<>(first, second, third, fourth, fifth, sixth, seventh);
    }

}


package com.mmnaseri.utils.tuples.impl;

import com.mmnaseri.utils.tuples.facade.*;

import java.util.function.Function;
import java.util.function.Supplier;

import static com.mmnaseri.utils.tuples.utils.TupleUtils.checkIndex;

public class SixTuple<Z, A extends Z, B extends Z, C extends Z, D extends Z, E extends Z, F extends Z> extends AbstractFixedTuple<Z, SixTuple<Z, A, B, C, D, E, F>>
        implements
        HasFirst<Z, A, SixTuple<Z, A, B, C, D, E, F>>,
        HasSecond<Z, B, SixTuple<Z, A, B, C, D, E, F>>,
        HasThird<Z, C, SixTuple<Z, A, B, C, D, E, F>>,
        HasFourth<Z, D, SixTuple<Z, A, B, C, D, E, F>>,
        HasFifth<Z, E, SixTuple<Z, A, B, C, D, E, F>>,
        HasSixth<Z, F, SixTuple<Z, A, B, C, D, E, F>> {

    public SixTuple(A first, B second, C third, D fourth, E fifth, F sixth) {
        super(first, second, third, fourth, fifth, sixth);
    }

    @Override
    public SixTuple<Z, Z, Z, Z, Z, Z, Z> change(int index, Supplier<? extends Z> supplier) {
        checkIndex(index, size());
        return new SixTuple<>(index == 0 ? supplier.get() : first(),
                              index == 1 ? supplier.get() : second(),
                              index == 2 ? supplier.get() : third(),
                              index == 3 ? supplier.get() : fourth(),
                              index == 4 ? supplier.get() : fifth(),
                              index == 5 ? supplier.get() : sixth());
    }

    @Override
    public SixTuple<Z, Z, Z, Z, Z, Z, Z> change(int index, Function<SixTuple<Z, A, B, C, D, E, F>, ? extends Z> function) {
        checkIndex(index, size());
        return new SixTuple<>(index == 0 ? function.apply(this) : first(),
                              index == 1 ? function.apply(this) : second(),
                              index == 2 ? function.apply(this) : third(),
                              index == 3 ? function.apply(this) : fourth(),
                              index == 4 ? function.apply(this) : fifth(),
                              index == 5 ? function.apply(this) : sixth());
    }

    @Override
    public <X extends Z> SevenTuple<Z, A, B, C, D, E, F, X> extend(X value) {
        return new SevenTuple<>(first(), second(), third(), fourth(), fifth(), sixth(), value);
    }

    @Override
    public <X extends Z> SevenTuple<Z, A, B, C, D, E, F, X> extend(Supplier<X> supplier) {
        return new SevenTuple<>(first(), second(), third(), fourth(), fifth(), sixth(), supplier.get());
    }

    @Override
    public <X extends Z> SevenTuple<Z, A, B, C, D, E, F, X> extend(Function<SixTuple<Z, A, B, C, D, E, F>, X> function) {
        return new SevenTuple<>(first(), second(), third(), fourth(), fifth(), sixth(), function.apply(this));
    }

    @Override
    public <X extends Z> SixTuple<Z, X, B, C, D, E, F> first(X value) {
        return new SixTuple<>(value, second(), third(), fourth(), fifth(), sixth());
    }

    @Override
    public <X extends Z> SixTuple<Z, X, B, C, D, E, F> first(Supplier<X> supplier) {
        return new SixTuple<>(supplier.get(), second(), third(), fourth(), fifth(), sixth());
    }

    @Override
    public <X extends Z> SixTuple<Z, X, B, C, D, E, F> first(Function<A, X> function) {
        return new SixTuple<>(function.apply(first()), second(), third(), fourth(), fifth(), sixth());
    }

    @Override
    public FiveTuple<Z, B, C, D, E, F> dropFirst() {
        return new FiveTuple<>(second(), third(), fourth(), fifth(), sixth());
    }

    @Override
    public <X extends Z> SixTuple<Z, A, X, C, D, E, F> second(X value) {
        return new SixTuple<>(first(), value, third(), fourth(), fifth(), sixth());
    }

    @Override
    public <X extends Z> SixTuple<Z, A, X, C, D, E, F> second(Supplier<X> supplier) {
        return new SixTuple<>(first(), supplier.get(), third(), fourth(), fifth(), sixth());
    }

    @Override
    public <X extends Z> SixTuple<Z, A, X, C, D, E, F> second(Function<B, X> function) {
        return new SixTuple<>(first(), function.apply(second()), third(), fourth(), fifth(), sixth());
    }

    @Override
    public FiveTuple<Z, A, C, D, E, F> dropSecond() {
        return new FiveTuple<>(first(), third(), fourth(), fifth(), sixth());
    }

    @Override
    public <X extends Z> SixTuple<Z, A, B, X, D, E, F> third(X value) {
        return new SixTuple<>(first(), second(), value, fourth(), fifth(), sixth());
    }

    @Override
    public <X extends Z> SixTuple<Z, A, B, X, D, E, F> third(Supplier<X> supplier) {
        return new SixTuple<>(first(), second(), supplier.get(), fourth(), fifth(), sixth());
    }

    @Override
    public <X extends Z> SixTuple<Z, A, B, X, D, E, F> third(Function<C, X> function) {
        return new SixTuple<>(first(), second(), function.apply(third()), fourth(), fifth(), sixth());
    }

    @Override
    public FiveTuple<Z, A, B, D, E, F> dropThird() {
        return new FiveTuple<>(first(), second(), fourth(), fifth(), sixth());
    }

    @Override
    public <X extends Z> SixTuple<Z, A, B, C, X, E, F> fourth(X value) {
        return new SixTuple<>(first(), second(), third(), value, fifth(), sixth());
    }

    @Override
    public <X extends Z> SixTuple<Z, A, B, C, X, E, F> fourth(Supplier<X> supplier) {
        return new SixTuple<>(first(), second(), third(), supplier.get(), fifth(), sixth());
    }

    @Override
    public <X extends Z> SixTuple<Z, A, B, C, X, E, F> fourth(Function<D, X> function) {
        return new SixTuple<>(first(), second(), third(), function.apply(fourth()), fifth(), sixth());
    }

    @Override
    public FiveTuple<Z, A, B, C, E, F> dropFourth() {
        return new FiveTuple<>(first(), second(), third(), fifth(), sixth());
    }

    @Override
    public <X extends Z> SixTuple<Z, A, B, C, D, X, F> fifth(X value) {
        return new SixTuple<>(first(), second(), third(), fourth(), value, sixth());
    }

    @Override
    public <X extends Z> SixTuple<Z, A, B, C, D, X, F> fifth(Supplier<X> supplier) {
        return new SixTuple<>(first(), second(), third(), fourth(), supplier.get(), sixth());
    }

    @Override
    public <X extends Z> SixTuple<Z, A, B, C, D, X, F> fifth(Function<E, X> function) {
        return new SixTuple<>(first(), second(), third(), fourth(), function.apply(fifth()), sixth());
    }

    @Override
    public FiveTuple<Z, A, B, C, D, F> dropFifth() {
        return new FiveTuple<>(first(), second(), third(), fourth(), sixth());
    }

    @Override
    public <X extends Z> SixTuple<Z, A, B, C, D, E, X> sixth(X value) {
        return new SixTuple<>(first(), second(), third(), fourth(), fifth(), value);
    }

    @Override
    public <X extends Z> SixTuple<Z, A, B, C, D, E, X> sixth(Supplier<X> supplier) {
        return new SixTuple<>(first(), second(), third(), fourth(), fifth(), supplier.get());
    }

    @Override
    public <X extends Z> SixTuple<Z, A, B, C, D, E, X> sixth(Function<F, X> function) {
        return new SixTuple<>(first(), second(), third(), fourth(), fifth(), function.apply(sixth()));
    }

    @Override
    public FiveTuple<Z, A, B, C, D, E> dropSixth() {
        return new FiveTuple<>(first(), second(), third(), fourth(), fifth());
    }

    public static <Z, A extends Z, B extends Z, C extends Z, D extends Z, E extends Z, F extends Z, X extends Z> Function<SixTuple<Z, A, B, C, D, E, F>, SevenTuple<Z, A, B, C, D, E, F, X>> extendWith(X value) {
        return tuple -> tuple.extend(value);
    }

    public static <Z, A extends Z, B extends Z, C extends Z, D extends Z, E extends Z, F extends Z, X extends Z> Function<SixTuple<Z, A, B, C, D, E, F>, SevenTuple<Z, A, B, C, D, E, F, X>> extendWith(Supplier<X> supplier) {
        return tuple -> tuple.extend(supplier);
    }

    public static <Z, A extends Z, B extends Z, C extends Z, D extends Z, E extends Z, F extends Z, X extends Z> Function<SixTuple<Z, A, B, C, D, E, F>, SevenTuple<Z, A, B, C, D, E, F, X>> extendWith(Function<SixTuple<Z, A, B, C, D, E, F>, X> function) {
        return tuple -> tuple.extend(function);
    }

    public static <Z, A extends Z, B extends Z, C extends Z, D extends Z, E extends Z, F extends Z> SixTuple<Z, A, B, C, D, E, F> of(A first, B second, C third, D fourth, E fifth, F sixth) {
        return new SixTuple<>(first, second, third, fourth, fifth, sixth);
    }

}


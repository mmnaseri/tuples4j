package com.mmnaseri.utils.tuples.impl;

import com.mmnaseri.utils.tuples.facade.*;

import java.util.function.Function;
import java.util.function.Supplier;

import static com.mmnaseri.utils.tuples.utils.TupleUtils.checkIndex;

public class NineTuple<Z, A extends Z, B extends Z, C extends Z, D extends Z, E extends Z, F extends Z, G extends Z, H extends Z, I extends Z> extends AbstractFixedTuple<Z, NineTuple<Z, A, B, C, D, E, F, G, H, I>>
        implements
        HasFirst<Z, A, NineTuple<Z, A, B, C, D, E, F, G, H, I>>,
        HasSecond<Z, B, NineTuple<Z, A, B, C, D, E, F, G, H, I>>,
        HasThird<Z, C, NineTuple<Z, A, B, C, D, E, F, G, H, I>>,
        HasFourth<Z, D, NineTuple<Z, A, B, C, D, E, F, G, H, I>>,
        HasFifth<Z, E, NineTuple<Z, A, B, C, D, E, F, G, H, I>>,
        HasSixth<Z, F, NineTuple<Z, A, B, C, D, E, F, G, H, I>>,
        HasSeventh<Z, G, NineTuple<Z, A, B, C, D, E, F, G, H, I>>,
        HasEighth<Z, H, NineTuple<Z, A, B, C, D, E, F, G, H, I>>,
        HasNinth<Z, I, NineTuple<Z, A, B, C, D, E, F, G, H, I>> {

    public NineTuple(A first, B second, C third, D fourth, E fifth, F sixth, G seventh, H eighth, I ninth) {
        super(first, second, third, fourth, fifth, sixth, seventh, eighth, ninth);
    }

    @Override
    public NineTuple<Z, Z, Z, Z, Z, Z, Z, Z, Z, Z> change(int index, Supplier<? extends Z> supplier) {
        checkIndex(index, size());
        return new NineTuple<>(index == 0 ? supplier.get() : first(),
                               index == 1 ? supplier.get() : second(),
                               index == 2 ? supplier.get() : third(),
                               index == 3 ? supplier.get() : fourth(),
                               index == 4 ? supplier.get() : fifth(),
                               index == 5 ? supplier.get() : sixth(),
                               index == 6 ? supplier.get() : seventh(),
                               index == 7 ? supplier.get() : eighth(),
                               index == 8 ? supplier.get() : ninth());
    }

    @Override
    public NineTuple<Z, Z, Z, Z, Z, Z, Z, Z, Z, Z> change(int index, Function<NineTuple<Z, A, B, C, D, E, F, G, H, I>, ? extends Z> function) {
        checkIndex(index, size());
        return new NineTuple<>(index == 0 ? function.apply(this) : first(),
                               index == 1 ? function.apply(this) : second(),
                               index == 2 ? function.apply(this) : third(),
                               index == 3 ? function.apply(this) : fourth(),
                               index == 4 ? function.apply(this) : fifth(),
                               index == 5 ? function.apply(this) : sixth(),
                               index == 6 ? function.apply(this) : seventh(),
                               index == 7 ? function.apply(this) : eighth(),
                               index == 8 ? function.apply(this) : ninth());
    }

    @Override
    public <X extends Z> TenTuple<Z, A, B, C, D, E, F, G, H, I, X> extend(X value) {
        return new TenTuple<>(first(), second(), third(), fourth(), fifth(), sixth(), seventh(), eighth(), ninth(), value);
    }

    @Override
    public <X extends Z> TenTuple<Z, A, B, C, D, E, F, G, H, I, X> extend(Supplier<X> supplier) {
        return new TenTuple<>(first(), second(), third(), fourth(), fifth(), sixth(), seventh(), eighth(), ninth(), supplier.get());
    }

    @Override
    public <X extends Z> TenTuple<Z, A, B, C, D, E, F, G, H, I, X> extend(Function<NineTuple<Z, A, B, C, D, E, F, G, H, I>, X> function) {
        return new TenTuple<>(first(), second(), third(), fourth(), fifth(), sixth(), seventh(), eighth(), ninth(), function.apply(this));
    }

    @Override
    public <X extends Z> NineTuple<Z, X, B, C, D, E, F, G, H, I> first(X value) {
        return new NineTuple<>(value, second(), third(), fourth(), fifth(), sixth(), seventh(), eighth(), ninth());
    }

    @Override
    public <X extends Z> NineTuple<Z, X, B, C, D, E, F, G, H, I> first(Supplier<X> supplier) {
        return new NineTuple<>(supplier.get(), second(), third(), fourth(), fifth(), sixth(), seventh(), eighth(), ninth());
    }

    @Override
    public <X extends Z> NineTuple<Z, X, B, C, D, E, F, G, H, I> first(Function<A, X> function) {
        return new NineTuple<>(function.apply(first()), second(), third(), fourth(), fifth(), sixth(), seventh(), eighth(), ninth());
    }

    @Override
    public EightTuple<Z, B, C, D, E, F, G, H, I> dropFirst() {
        return new EightTuple<>(second(), third(), fourth(), fifth(), sixth(), seventh(), eighth(), ninth());
    }

    @Override
    public <X extends Z> NineTuple<Z, A, X, C, D, E, F, G, H, I> second(X value) {
        return new NineTuple<>(first(), value, third(), fourth(), fifth(), sixth(), seventh(), eighth(), ninth());
    }

    @Override
    public <X extends Z> NineTuple<Z, A, X, C, D, E, F, G, H, I> second(Supplier<X> supplier) {
        return new NineTuple<>(first(), supplier.get(), third(), fourth(), fifth(), sixth(), seventh(), eighth(), ninth());
    }

    @Override
    public <X extends Z> NineTuple<Z, A, X, C, D, E, F, G, H, I> second(Function<B, X> function) {
        return new NineTuple<>(first(), function.apply(second()), third(), fourth(), fifth(), sixth(), seventh(), eighth(), ninth());
    }

    @Override
    public EightTuple<Z, A, C, D, E, F, G, H, I> dropSecond() {
        return new EightTuple<>(first(), third(), fourth(), fifth(), sixth(), seventh(), eighth(), ninth());
    }

    @Override
    public <X extends Z> NineTuple<Z, A, B, X, D, E, F, G, H, I> third(X value) {
        return new NineTuple<>(first(), second(), value, fourth(), fifth(), sixth(), seventh(), eighth(), ninth());
    }

    @Override
    public <X extends Z> NineTuple<Z, A, B, X, D, E, F, G, H, I> third(Supplier<X> supplier) {
        return new NineTuple<>(first(), second(), supplier.get(), fourth(), fifth(), sixth(), seventh(), eighth(), ninth());
    }

    @Override
    public <X extends Z> NineTuple<Z, A, B, X, D, E, F, G, H, I> third(Function<C, X> function) {
        return new NineTuple<>(first(), second(), function.apply(third()), fourth(), fifth(), sixth(), seventh(), eighth(), ninth());
    }

    @Override
    public EightTuple<Z, A, B, D, E, F, G, H, I> dropThird() {
        return new EightTuple<>(first(), second(), fourth(), fifth(), sixth(), seventh(), eighth(), ninth());
    }

    @Override
    public <X extends Z> NineTuple<Z, A, B, C, X, E, F, G, H, I> fourth(X value) {
        return new NineTuple<>(first(), second(), third(), value, fifth(), sixth(), seventh(), eighth(), ninth());
    }

    @Override
    public <X extends Z> NineTuple<Z, A, B, C, X, E, F, G, H, I> fourth(Supplier<X> supplier) {
        return new NineTuple<>(first(), second(), third(), supplier.get(), fifth(), sixth(), seventh(), eighth(), ninth());
    }

    @Override
    public <X extends Z> NineTuple<Z, A, B, C, X, E, F, G, H, I> fourth(Function<D, X> function) {
        return new NineTuple<>(first(), second(), third(), function.apply(fourth()), fifth(), sixth(), seventh(), eighth(), ninth());
    }

    @Override
    public EightTuple<Z, A, B, C, E, F, G, H, I> dropFourth() {
        return new EightTuple<>(first(), second(), third(), fifth(), sixth(), seventh(), eighth(), ninth());
    }

    @Override
    public <X extends Z> NineTuple<Z, A, B, C, D, X, F, G, H, I> fifth(X value) {
        return new NineTuple<>(first(), second(), third(), fourth(), value, sixth(), seventh(), eighth(), ninth());
    }

    @Override
    public <X extends Z> NineTuple<Z, A, B, C, D, X, F, G, H, I> fifth(Supplier<X> supplier) {
        return new NineTuple<>(first(), second(), third(), fourth(), supplier.get(), sixth(), seventh(), eighth(), ninth());
    }

    @Override
    public <X extends Z> NineTuple<Z, A, B, C, D, X, F, G, H, I> fifth(Function<E, X> function) {
        return new NineTuple<>(first(), second(), third(), fourth(), function.apply(fifth()), sixth(), seventh(), eighth(), ninth());
    }

    @Override
    public EightTuple<Z, A, B, C, D, F, G, H, I> dropFifth() {
        return new EightTuple<>(first(), second(), third(), fourth(), sixth(), seventh(), eighth(), ninth());
    }

    @Override
    public <X extends Z> NineTuple<Z, A, B, C, D, E, X, G, H, I> sixth(X value) {
        return new NineTuple<>(first(), second(), third(), fourth(), fifth(), value, seventh(), eighth(), ninth());
    }

    @Override
    public <X extends Z> NineTuple<Z, A, B, C, D, E, X, G, H, I> sixth(Supplier<X> supplier) {
        return new NineTuple<>(first(), second(), third(), fourth(), fifth(), supplier.get(), seventh(), eighth(), ninth());
    }

    @Override
    public <X extends Z> NineTuple<Z, A, B, C, D, E, X, G, H, I> sixth(Function<F, X> function) {
        return new NineTuple<>(first(), second(), third(), fourth(), fifth(), function.apply(sixth()), seventh(), eighth(), ninth());
    }

    @Override
    public EightTuple<Z, A, B, C, D, E, G, H, I> dropSixth() {
        return new EightTuple<>(first(), second(), third(), fourth(), fifth(), seventh(), eighth(), ninth());
    }

    @Override
    public <X extends Z> NineTuple<Z, A, B, C, D, E, F, X, H, I> seventh(X value) {
        return new NineTuple<>(first(), second(), third(), fourth(), fifth(), sixth(), value, eighth(), ninth());
    }

    @Override
    public <X extends Z> NineTuple<Z, A, B, C, D, E, F, X, H, I> seventh(Supplier<X> supplier) {
        return new NineTuple<>(first(), second(), third(), fourth(), fifth(), sixth(), supplier.get(), eighth(), ninth());
    }

    @Override
    public <X extends Z> NineTuple<Z, A, B, C, D, E, F, X, H, I> seventh(Function<G, X> function) {
        return new NineTuple<>(first(), second(), third(), fourth(), fifth(), sixth(), function.apply(seventh()), eighth(), ninth());
    }

    @Override
    public EightTuple<Z, A, B, C, D, E, F, H, I> dropSeventh() {
        return new EightTuple<>(first(), second(), third(), fourth(), fifth(), sixth(), eighth(), ninth());
    }

    @Override
    public <X extends Z> NineTuple<Z, A, B, C, D, E, F, G, X, I> eighth(X value) {
        return new NineTuple<>(first(), second(), third(), fourth(), fifth(), sixth(), seventh(), value, ninth());
    }

    @Override
    public <X extends Z> NineTuple<Z, A, B, C, D, E, F, G, X, I> eighth(Supplier<X> supplier) {
        return new NineTuple<>(first(), second(), third(), fourth(), fifth(), sixth(), seventh(), supplier.get(), ninth());
    }

    @Override
    public <X extends Z> NineTuple<Z, A, B, C, D, E, F, G, X, I> eighth(Function<H, X> function) {
        return new NineTuple<>(first(), second(), third(), fourth(), fifth(), sixth(), seventh(), function.apply(eighth()), ninth());
    }

    @Override
    public EightTuple<Z, A, B, C, D, E, F, G, I> dropEighth() {
        return new EightTuple<>(first(), second(), third(), fourth(), fifth(), sixth(), seventh(), ninth());
    }

    @Override
    public <X extends Z> NineTuple<Z, A, B, C, D, E, F, G, H, X> ninth(X value) {
        return new NineTuple<>(first(), second(), third(), fourth(), fifth(), sixth(), seventh(), eighth(), value);
    }

    @Override
    public <X extends Z> NineTuple<Z, A, B, C, D, E, F, G, H, X> ninth(Supplier<X> supplier) {
        return new NineTuple<>(first(), second(), third(), fourth(), fifth(), sixth(), seventh(), eighth(), supplier.get());
    }

    @Override
    public <X extends Z> NineTuple<Z, A, B, C, D, E, F, G, H, X> ninth(Function<I, X> function) {
        return new NineTuple<>(first(), second(), third(), fourth(), fifth(), sixth(), seventh(), eighth(), function.apply(ninth()));
    }

    @Override
    public EightTuple<Z, A, B, C, D, E, F, G, H> dropNinth() {
        return new EightTuple<>(first(), second(), third(), fourth(), fifth(), sixth(), seventh(), eighth());
    }

    public static <Z, A extends Z, B extends Z, C extends Z, D extends Z, E extends Z, F extends Z, G extends Z, H extends Z, I extends Z, X extends Z> Function<NineTuple<Z, A, B, C, D, E, F, G, H, I>, TenTuple<Z, A, B, C, D, E, F, G, H, I, X>> extendWith(X value) {
        return tuple -> tuple.extend(value);
    }

    public static <Z, A extends Z, B extends Z, C extends Z, D extends Z, E extends Z, F extends Z, G extends Z, H extends Z, I extends Z, X extends Z> Function<NineTuple<Z, A, B, C, D, E, F, G, H, I>, TenTuple<Z, A, B, C, D, E, F, G, H, I, X>> extendWith(Supplier<X> supplier) {
        return tuple -> tuple.extend(supplier);
    }

    public static <Z, A extends Z, B extends Z, C extends Z, D extends Z, E extends Z, F extends Z, G extends Z, H extends Z, I extends Z, X extends Z> Function<NineTuple<Z, A, B, C, D, E, F, G, H, I>, TenTuple<Z, A, B, C, D, E, F, G, H, I, X>> extendWith(Function<NineTuple<Z, A, B, C, D, E, F, G, H, I>, X> function) {
        return tuple -> tuple.extend(function);
    }

    public static <Z, A extends Z, B extends Z, C extends Z, D extends Z, E extends Z, F extends Z, G extends Z, H extends Z, I extends Z> NineTuple<Z, A, B, C, D, E, F, G, H, I> of(A first, B second, C third, D fourth, E fifth, F sixth, G seventh, H eighth, I ninth) {
        return new NineTuple<>(first, second, third, fourth, fifth, sixth, seventh, eighth, ninth);
    }

}


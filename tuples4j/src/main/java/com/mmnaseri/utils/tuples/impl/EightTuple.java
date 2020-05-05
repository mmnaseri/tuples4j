package com.mmnaseri.utils.tuples.impl;

import com.mmnaseri.utils.tuples.facade.*;

import java.util.function.Function;
import java.util.function.Supplier;

import static com.mmnaseri.utils.tuples.utils.TupleUtils.checkIndex;

/**
 * Class for dealing with a {@link com.mmnaseri.utils.tuples.FixedTuple} with eight elements.
 *
 * @author Milad Naseri (m.m.naseri@gmail.com)
 */
public class EightTuple<Z, A extends Z, B extends Z, C extends Z, D extends Z, E extends Z, F extends Z, G extends Z, H extends Z> extends AbstractFixedTuple<Z, EightTuple<Z, A, B, C, D, E, F, G, H>>
        implements
        HasFirst<Z, A, EightTuple<Z, A, B, C, D, E, F, G, H>>,
        HasSecond<Z, B, EightTuple<Z, A, B, C, D, E, F, G, H>>,
        HasThird<Z, C, EightTuple<Z, A, B, C, D, E, F, G, H>>,
        HasFourth<Z, D, EightTuple<Z, A, B, C, D, E, F, G, H>>,
        HasFifth<Z, E, EightTuple<Z, A, B, C, D, E, F, G, H>>,
        HasSixth<Z, F, EightTuple<Z, A, B, C, D, E, F, G, H>>,
        HasSeventh<Z, G, EightTuple<Z, A, B, C, D, E, F, G, H>>,
        HasEighth<Z, H, EightTuple<Z, A, B, C, D, E, F, G, H>> {

    /**
     * Creates a new instance of this class from the provided values.
     */
    public EightTuple(A first, B second, C third, D fourth, E fifth, F sixth, G seventh, H eighth) {
        super(first, second, third, fourth, fifth, sixth, seventh, eighth);
    }

    /**
     * Returns a new tuple by keeping all the values from this tuple and overriding the value at the provided index with the value returned from the supplier.
     */
    @Override
    public EightTuple<Z, Z, Z, Z, Z, Z, Z, Z, Z> change(int index, Supplier<? extends Z> supplier) {
        checkIndex(index, size());
        return new EightTuple<>(index == 0 ? supplier.get() : first(),
                                index == 1 ? supplier.get() : second(),
                                index == 2 ? supplier.get() : third(),
                                index == 3 ? supplier.get() : fourth(),
                                index == 4 ? supplier.get() : fifth(),
                                index == 5 ? supplier.get() : sixth(),
                                index == 6 ? supplier.get() : seventh(),
                                index == 7 ? supplier.get() : eighth());
    }

    /**
     * Returns a new tuple by keeping all the values from this tuple and overriding the value at the provided index with the value returned from the function.
     */
    @Override
    public EightTuple<Z, Z, Z, Z, Z, Z, Z, Z, Z> change(int index, Function<EightTuple<Z, A, B, C, D, E, F, G, H>, ? extends Z> function) {
        checkIndex(index, size());
        return new EightTuple<>(index == 0 ? function.apply(this) : first(),
                                index == 1 ? function.apply(this) : second(),
                                index == 2 ? function.apply(this) : third(),
                                index == 3 ? function.apply(this) : fourth(),
                                index == 4 ? function.apply(this) : fifth(),
                                index == 5 ? function.apply(this) : sixth(),
                                index == 6 ? function.apply(this) : seventh(),
                                index == 7 ? function.apply(this) : eighth());
    }

    /**
     * Returns a new tuple of one size larger by adding the provided value to the end of this tuple.
     */
    @Override
    public <X extends Z> NineTuple<Z, A, B, C, D, E, F, G, H, X> extend(X value) {
        return new NineTuple<>(first(), second(), third(), fourth(), fifth(), sixth(), seventh(), eighth(), value);
    }

    /**
     * Returns a new tuple of one size larger by adding the value returned from the supplier to the end of this tuple.
     */
    @Override
    public <X extends Z> NineTuple<Z, A, B, C, D, E, F, G, H, X> extend(Supplier<X> supplier) {
        return new NineTuple<>(first(), second(), third(), fourth(), fifth(), sixth(), seventh(), eighth(), supplier.get());
    }

    /**
     * Returns a new tuple of one size larger by adding the value returned from the function to the end of this tuple.
     */
    @Override
    public <X extends Z> NineTuple<Z, A, B, C, D, E, F, G, H, X> extend(Function<EightTuple<Z, A, B, C, D, E, F, G, H>, X> function) {
        return new NineTuple<>(first(), second(), third(), fourth(), fifth(), sixth(), seventh(), eighth(), function.apply(this));
    }

    /**
     * Returns a new tuple of the same size by keeping all the values from this tuple and overriding the first element with the provided value.
     */
    @Override
    public <X extends Z> EightTuple<Z, X, B, C, D, E, F, G, H> first(X value) {
        return new EightTuple<>(value, second(), third(), fourth(), fifth(), sixth(), seventh(), eighth());
    }

    /**
     * Returns a new tuple of the same size by keeping all the values from this tuple and overriding the first element with the value returned from the given supplier.
     */
    @Override
    public <X extends Z> EightTuple<Z, X, B, C, D, E, F, G, H> first(Supplier<X> supplier) {
        return new EightTuple<>(supplier.get(), second(), third(), fourth(), fifth(), sixth(), seventh(), eighth());
    }

    /**
     * Returns a new tuple of the same size by keeping all the values from this tuple and overriding the first element with the value returned by applying the given function to this tuple's first element.
     */
    @Override
    public <X extends Z> EightTuple<Z, X, B, C, D, E, F, G, H> first(Function<A, X> function) {
        return new EightTuple<>(function.apply(first()), second(), third(), fourth(), fifth(), sixth(), seventh(), eighth());
    }

    /**
     * Returns a new tuple of one size smaller by keeping all the values from this tuple except the first element.
     */
    @Override
    public SevenTuple<Z, B, C, D, E, F, G, H> dropFirst() {
        return new SevenTuple<>(second(), third(), fourth(), fifth(), sixth(), seventh(), eighth());
    }

    /**
     * Returns a new tuple of the same size by keeping all the values from this tuple and overriding the second element with the provided value.
     */
    @Override
    public <X extends Z> EightTuple<Z, A, X, C, D, E, F, G, H> second(X value) {
        return new EightTuple<>(first(), value, third(), fourth(), fifth(), sixth(), seventh(), eighth());
    }

    /**
     * Returns a new tuple of the same size by keeping all the values from this tuple and overriding the second element with the value returned from the given supplier.
     */
    @Override
    public <X extends Z> EightTuple<Z, A, X, C, D, E, F, G, H> second(Supplier<X> supplier) {
        return new EightTuple<>(first(), supplier.get(), third(), fourth(), fifth(), sixth(), seventh(), eighth());
    }

    /**
     * Returns a new tuple of the same size by keeping all the values from this tuple and overriding the second element with the value returned by applying the given function to this tuple's second element.
     */
    @Override
    public <X extends Z> EightTuple<Z, A, X, C, D, E, F, G, H> second(Function<B, X> function) {
        return new EightTuple<>(first(), function.apply(second()), third(), fourth(), fifth(), sixth(), seventh(), eighth());
    }

    /**
     * Returns a new tuple of one size smaller by keeping all the values from this tuple except the second element.
     */
    @Override
    public SevenTuple<Z, A, C, D, E, F, G, H> dropSecond() {
        return new SevenTuple<>(first(), third(), fourth(), fifth(), sixth(), seventh(), eighth());
    }

    /**
     * Returns a new tuple of the same size by keeping all the values from this tuple and overriding the third element with the provided value.
     */
    @Override
    public <X extends Z> EightTuple<Z, A, B, X, D, E, F, G, H> third(X value) {
        return new EightTuple<>(first(), second(), value, fourth(), fifth(), sixth(), seventh(), eighth());
    }

    /**
     * Returns a new tuple of the same size by keeping all the values from this tuple and overriding the third element with the value returned from the given supplier.
     */
    @Override
    public <X extends Z> EightTuple<Z, A, B, X, D, E, F, G, H> third(Supplier<X> supplier) {
        return new EightTuple<>(first(), second(), supplier.get(), fourth(), fifth(), sixth(), seventh(), eighth());
    }

    /**
     * Returns a new tuple of the same size by keeping all the values from this tuple and overriding the third element with the value returned by applying the given function to this tuple's third element.
     */
    @Override
    public <X extends Z> EightTuple<Z, A, B, X, D, E, F, G, H> third(Function<C, X> function) {
        return new EightTuple<>(first(), second(), function.apply(third()), fourth(), fifth(), sixth(), seventh(), eighth());
    }

    /**
     * Returns a new tuple of one size smaller by keeping all the values from this tuple except the third element.
     */
    @Override
    public SevenTuple<Z, A, B, D, E, F, G, H> dropThird() {
        return new SevenTuple<>(first(), second(), fourth(), fifth(), sixth(), seventh(), eighth());
    }

    /**
     * Returns a new tuple of the same size by keeping all the values from this tuple and overriding the fourth element with the provided value.
     */
    @Override
    public <X extends Z> EightTuple<Z, A, B, C, X, E, F, G, H> fourth(X value) {
        return new EightTuple<>(first(), second(), third(), value, fifth(), sixth(), seventh(), eighth());
    }

    /**
     * Returns a new tuple of the same size by keeping all the values from this tuple and overriding the fourth element with the value returned from the given supplier.
     */
    @Override
    public <X extends Z> EightTuple<Z, A, B, C, X, E, F, G, H> fourth(Supplier<X> supplier) {
        return new EightTuple<>(first(), second(), third(), supplier.get(), fifth(), sixth(), seventh(), eighth());
    }

    /**
     * Returns a new tuple of the same size by keeping all the values from this tuple and overriding the fourth element with the value returned by applying the given function to this tuple's fourth element.
     */
    @Override
    public <X extends Z> EightTuple<Z, A, B, C, X, E, F, G, H> fourth(Function<D, X> function) {
        return new EightTuple<>(first(), second(), third(), function.apply(fourth()), fifth(), sixth(), seventh(), eighth());
    }

    /**
     * Returns a new tuple of one size smaller by keeping all the values from this tuple except the fourth element.
     */
    @Override
    public SevenTuple<Z, A, B, C, E, F, G, H> dropFourth() {
        return new SevenTuple<>(first(), second(), third(), fifth(), sixth(), seventh(), eighth());
    }

    /**
     * Returns a new tuple of the same size by keeping all the values from this tuple and overriding the fifth element with the provided value.
     */
    @Override
    public <X extends Z> EightTuple<Z, A, B, C, D, X, F, G, H> fifth(X value) {
        return new EightTuple<>(first(), second(), third(), fourth(), value, sixth(), seventh(), eighth());
    }

    /**
     * Returns a new tuple of the same size by keeping all the values from this tuple and overriding the fifth element with the value returned from the given supplier.
     */
    @Override
    public <X extends Z> EightTuple<Z, A, B, C, D, X, F, G, H> fifth(Supplier<X> supplier) {
        return new EightTuple<>(first(), second(), third(), fourth(), supplier.get(), sixth(), seventh(), eighth());
    }

    /**
     * Returns a new tuple of the same size by keeping all the values from this tuple and overriding the fifth element with the value returned by applying the given function to this tuple's fifth element.
     */
    @Override
    public <X extends Z> EightTuple<Z, A, B, C, D, X, F, G, H> fifth(Function<E, X> function) {
        return new EightTuple<>(first(), second(), third(), fourth(), function.apply(fifth()), sixth(), seventh(), eighth());
    }

    /**
     * Returns a new tuple of one size smaller by keeping all the values from this tuple except the fifth element.
     */
    @Override
    public SevenTuple<Z, A, B, C, D, F, G, H> dropFifth() {
        return new SevenTuple<>(first(), second(), third(), fourth(), sixth(), seventh(), eighth());
    }

    /**
     * Returns a new tuple of the same size by keeping all the values from this tuple and overriding the sixth element with the provided value.
     */
    @Override
    public <X extends Z> EightTuple<Z, A, B, C, D, E, X, G, H> sixth(X value) {
        return new EightTuple<>(first(), second(), third(), fourth(), fifth(), value, seventh(), eighth());
    }

    /**
     * Returns a new tuple of the same size by keeping all the values from this tuple and overriding the sixth element with the value returned from the given supplier.
     */
    @Override
    public <X extends Z> EightTuple<Z, A, B, C, D, E, X, G, H> sixth(Supplier<X> supplier) {
        return new EightTuple<>(first(), second(), third(), fourth(), fifth(), supplier.get(), seventh(), eighth());
    }

    /**
     * Returns a new tuple of the same size by keeping all the values from this tuple and overriding the sixth element with the value returned by applying the given function to this tuple's sixth element.
     */
    @Override
    public <X extends Z> EightTuple<Z, A, B, C, D, E, X, G, H> sixth(Function<F, X> function) {
        return new EightTuple<>(first(), second(), third(), fourth(), fifth(), function.apply(sixth()), seventh(), eighth());
    }

    /**
     * Returns a new tuple of one size smaller by keeping all the values from this tuple except the sixth element.
     */
    @Override
    public SevenTuple<Z, A, B, C, D, E, G, H> dropSixth() {
        return new SevenTuple<>(first(), second(), third(), fourth(), fifth(), seventh(), eighth());
    }

    /**
     * Returns a new tuple of the same size by keeping all the values from this tuple and overriding the seventh element with the provided value.
     */
    @Override
    public <X extends Z> EightTuple<Z, A, B, C, D, E, F, X, H> seventh(X value) {
        return new EightTuple<>(first(), second(), third(), fourth(), fifth(), sixth(), value, eighth());
    }

    /**
     * Returns a new tuple of the same size by keeping all the values from this tuple and overriding the seventh element with the value returned from the given supplier.
     */
    @Override
    public <X extends Z> EightTuple<Z, A, B, C, D, E, F, X, H> seventh(Supplier<X> supplier) {
        return new EightTuple<>(first(), second(), third(), fourth(), fifth(), sixth(), supplier.get(), eighth());
    }

    /**
     * Returns a new tuple of the same size by keeping all the values from this tuple and overriding the seventh element with the value returned by applying the given function to this tuple's seventh element.
     */
    @Override
    public <X extends Z> EightTuple<Z, A, B, C, D, E, F, X, H> seventh(Function<G, X> function) {
        return new EightTuple<>(first(), second(), third(), fourth(), fifth(), sixth(), function.apply(seventh()), eighth());
    }

    /**
     * Returns a new tuple of one size smaller by keeping all the values from this tuple except the seventh element.
     */
    @Override
    public SevenTuple<Z, A, B, C, D, E, F, H> dropSeventh() {
        return new SevenTuple<>(first(), second(), third(), fourth(), fifth(), sixth(), eighth());
    }

    /**
     * Returns a new tuple of the same size by keeping all the values from this tuple and overriding the eighth element with the provided value.
     */
    @Override
    public <X extends Z> EightTuple<Z, A, B, C, D, E, F, G, X> eighth(X value) {
        return new EightTuple<>(first(), second(), third(), fourth(), fifth(), sixth(), seventh(), value);
    }

    /**
     * Returns a new tuple of the same size by keeping all the values from this tuple and overriding the eighth element with the value returned from the given supplier.
     */
    @Override
    public <X extends Z> EightTuple<Z, A, B, C, D, E, F, G, X> eighth(Supplier<X> supplier) {
        return new EightTuple<>(first(), second(), third(), fourth(), fifth(), sixth(), seventh(), supplier.get());
    }

    /**
     * Returns a new tuple of the same size by keeping all the values from this tuple and overriding the eighth element with the value returned by applying the given function to this tuple's eighth element.
     */
    @Override
    public <X extends Z> EightTuple<Z, A, B, C, D, E, F, G, X> eighth(Function<H, X> function) {
        return new EightTuple<>(first(), second(), third(), fourth(), fifth(), sixth(), seventh(), function.apply(eighth()));
    }

    /**
     * Returns a new tuple of one size smaller by keeping all the values from this tuple except the eighth element.
     */
    @Override
    public SevenTuple<Z, A, B, C, D, E, F, G> dropEighth() {
        return new SevenTuple<>(first(), second(), third(), fourth(), fifth(), sixth(), seventh());
    }

    /**
     * Extends the tuple to which this is applied by adding the provided value to the end.
     *
     * <p>This is especially useful in functional contexts. For instance:
     *
     * <pre>
     * nineTupleStream = eightTupleStream.map(EightTuple.extendWith(value));
     * </pre>
     *
     * @see #extend(Object)
     */
    public static <Z, A extends Z, B extends Z, C extends Z, D extends Z, E extends Z, F extends Z, G extends Z, H extends Z, X extends Z> Function<EightTuple<Z, A, B, C, D, E, F, G, H>, NineTuple<Z, A, B, C, D, E, F, G, H, X>> extendWith(X value) {
        return tuple -> tuple.extend(value);
    }

    /**
     * Extends the tuple to which this is applied by adding the value from the supplier to the end.
     *
     * <p>This is especially useful in functional contexts. For instance:
     *
     * <pre>
     * nineTupleStream = eightTupleStream.map(EightTuple.extendWith(supplier));
     * </pre>
     *
     * @see #extend(Object)
     */
    public static <Z, A extends Z, B extends Z, C extends Z, D extends Z, E extends Z, F extends Z, G extends Z, H extends Z, X extends Z> Function<EightTuple<Z, A, B, C, D, E, F, G, H>, NineTuple<Z, A, B, C, D, E, F, G, H, X>> extendWith(Supplier<X> supplier) {
        return tuple -> tuple.extend(supplier);
    }

    /**
     * Extends the tuple to which this is applied by adding the value from the function to the end.
     *
     * <p>This is especially useful in functional contexts. For instance:
     *
     * <pre>
     * nineTupleStream = eightTupleStream.map(EightTuple.extendWith(function));
     * </pre>
     *
     * @see #extend(Object)
     */
    public static <Z, A extends Z, B extends Z, C extends Z, D extends Z, E extends Z, F extends Z, G extends Z, H extends Z, X extends Z> Function<EightTuple<Z, A, B, C, D, E, F, G, H>, NineTuple<Z, A, B, C, D, E, F, G, H, X>> extendWith(Function<EightTuple<Z, A, B, C, D, E, F, G, H>, X> function) {
        return tuple -> tuple.extend(function);
    }

    /**
     * Creates a new instance of this class.
     */
    public static <Z, A extends Z, B extends Z, C extends Z, D extends Z, E extends Z, F extends Z, G extends Z, H extends Z> EightTuple<Z, A, B, C, D, E, F, G, H> of(A first, B second, C third, D fourth, E fifth, F sixth, G seventh, H eighth) {
        return new EightTuple<>(first, second, third, fourth, fifth, sixth, seventh, eighth);
    }

}


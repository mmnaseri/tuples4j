package com.mmnaseri.utils.tuples.impl;

import com.mmnaseri.utils.tuples.facade.*;

import java.util.function.Function;
import java.util.function.Supplier;

import static com.mmnaseri.utils.tuples.utils.TupleUtils.checkIndex;

/**
 * Class for dealing with a {@link com.mmnaseri.utils.tuples.FixedTuple} with ten elements.
 *
 * @author Milad Naseri (m.m.naseri@gmail.com)
 */
public class TenTuple<Z, A extends Z, B extends Z, C extends Z, D extends Z, E extends Z, F extends Z, G extends Z, H extends Z, I extends Z, J extends Z> extends AbstractFixedTuple<Z, TenTuple<Z, A, B, C, D, E, F, G, H, I, J>>
        implements
        HasFirst<Z, A, TenTuple<Z, A, B, C, D, E, F, G, H, I, J>>,
        HasSecond<Z, B, TenTuple<Z, A, B, C, D, E, F, G, H, I, J>>,
        HasThird<Z, C, TenTuple<Z, A, B, C, D, E, F, G, H, I, J>>,
        HasFourth<Z, D, TenTuple<Z, A, B, C, D, E, F, G, H, I, J>>,
        HasFifth<Z, E, TenTuple<Z, A, B, C, D, E, F, G, H, I, J>>,
        HasSixth<Z, F, TenTuple<Z, A, B, C, D, E, F, G, H, I, J>>,
        HasSeventh<Z, G, TenTuple<Z, A, B, C, D, E, F, G, H, I, J>>,
        HasEighth<Z, H, TenTuple<Z, A, B, C, D, E, F, G, H, I, J>>,
        HasNinth<Z, I, TenTuple<Z, A, B, C, D, E, F, G, H, I, J>>,
        HasTenth<Z, J, TenTuple<Z, A, B, C, D, E, F, G, H, I, J>> {

    /**
     * Creates a new instance of this class from the provided values.
     */
    public TenTuple(A first, B second, C third, D fourth, E fifth, F sixth, G seventh, H eighth, I ninth, J tenth) {
        super(first, second, third, fourth, fifth, sixth, seventh, eighth, ninth, tenth);
    }

    /**
     * Returns a new tuple by keeping all the values from this tuple and overriding the value at the provided index with the value returned from the supplier.
     */
    @Override
    public TenTuple<Z, Z, Z, Z, Z, Z, Z, Z, Z, Z, Z> change(int index, Supplier<? extends Z> supplier) {
        checkIndex(index, size());
        return new TenTuple<>(index == 0 ? supplier.get() : first(),
                              index == 1 ? supplier.get() : second(),
                              index == 2 ? supplier.get() : third(),
                              index == 3 ? supplier.get() : fourth(),
                              index == 4 ? supplier.get() : fifth(),
                              index == 5 ? supplier.get() : sixth(),
                              index == 6 ? supplier.get() : seventh(),
                              index == 7 ? supplier.get() : eighth(),
                              index == 8 ? supplier.get() : ninth(),
                              index == 9 ? supplier.get() : tenth());
    }

    /**
     * Returns a new tuple by keeping all the values from this tuple and overriding the value at the provided index with the value returned from the function.
     */
    @Override
    public TenTuple<Z, Z, Z, Z, Z, Z, Z, Z, Z, Z, Z> change(int index, Function<TenTuple<Z, A, B, C, D, E, F, G, H, I, J>, ? extends Z> function) {
        checkIndex(index, size());
        return new TenTuple<>(index == 0 ? function.apply(this) : first(),
                              index == 1 ? function.apply(this) : second(),
                              index == 2 ? function.apply(this) : third(),
                              index == 3 ? function.apply(this) : fourth(),
                              index == 4 ? function.apply(this) : fifth(),
                              index == 5 ? function.apply(this) : sixth(),
                              index == 6 ? function.apply(this) : seventh(),
                              index == 7 ? function.apply(this) : eighth(),
                              index == 8 ? function.apply(this) : ninth(),
                              index == 9 ? function.apply(this) : tenth());
    }

    /**
     * Returns a new tuple of one size larger by adding the provided value to the end of this tuple.
     */
    @Override
    public <X extends Z> ElevenTuple<Z, A, B, C, D, E, F, G, H, I, J, X> extend(X value) {
        return new ElevenTuple<>(first(), second(), third(), fourth(), fifth(), sixth(), seventh(), eighth(), ninth(), tenth(), value);
    }

    /**
     * Returns a new tuple of one size larger by adding the value returned from the supplier to the end of this tuple.
     */
    @Override
    public <X extends Z> ElevenTuple<Z, A, B, C, D, E, F, G, H, I, J, X> extend(Supplier<X> supplier) {
        return new ElevenTuple<>(first(), second(), third(), fourth(), fifth(), sixth(), seventh(), eighth(), ninth(), tenth(), supplier.get());
    }

    /**
     * Returns a new tuple of one size larger by adding the value returned from the function to the end of this tuple.
     */
    @Override
    public <X extends Z> ElevenTuple<Z, A, B, C, D, E, F, G, H, I, J, X> extend(Function<TenTuple<Z, A, B, C, D, E, F, G, H, I, J>, X> function) {
        return new ElevenTuple<>(first(), second(), third(), fourth(), fifth(), sixth(), seventh(), eighth(), ninth(), tenth(), function.apply(this));
    }

    /**
     * Returns a new tuple of the same size by keeping all the values from this tuple and overriding the first element with the provided value.
     */
    @Override
    public <X extends Z> TenTuple<Z, X, B, C, D, E, F, G, H, I, J> first(X value) {
        return new TenTuple<>(value, second(), third(), fourth(), fifth(), sixth(), seventh(), eighth(), ninth(), tenth());
    }

    /**
     * Returns a new tuple of the same size by keeping all the values from this tuple and overriding the first element with the value returned from the given supplier.
     */
    @Override
    public <X extends Z> TenTuple<Z, X, B, C, D, E, F, G, H, I, J> first(Supplier<X> supplier) {
        return new TenTuple<>(supplier.get(), second(), third(), fourth(), fifth(), sixth(), seventh(), eighth(), ninth(), tenth());
    }

    /**
     * Returns a new tuple of the same size by keeping all the values from this tuple and overriding the first element with the value returned by applying the given function to this tuple's first element.
     */
    @Override
    public <X extends Z> TenTuple<Z, X, B, C, D, E, F, G, H, I, J> first(Function<A, X> function) {
        return new TenTuple<>(function.apply(first()), second(), third(), fourth(), fifth(), sixth(), seventh(), eighth(), ninth(), tenth());
    }

    /**
     * Returns a new tuple of one size smaller by keeping all the values from this tuple except the first element.
     */
    @Override
    public NineTuple<Z, B, C, D, E, F, G, H, I, J> dropFirst() {
        return new NineTuple<>(second(), third(), fourth(), fifth(), sixth(), seventh(), eighth(), ninth(), tenth());
    }

    /**
     * Returns a new tuple of the same size by keeping all the values from this tuple and overriding the second element with the provided value.
     */
    @Override
    public <X extends Z> TenTuple<Z, A, X, C, D, E, F, G, H, I, J> second(X value) {
        return new TenTuple<>(first(), value, third(), fourth(), fifth(), sixth(), seventh(), eighth(), ninth(), tenth());
    }

    /**
     * Returns a new tuple of the same size by keeping all the values from this tuple and overriding the second element with the value returned from the given supplier.
     */
    @Override
    public <X extends Z> TenTuple<Z, A, X, C, D, E, F, G, H, I, J> second(Supplier<X> supplier) {
        return new TenTuple<>(first(), supplier.get(), third(), fourth(), fifth(), sixth(), seventh(), eighth(), ninth(), tenth());
    }

    /**
     * Returns a new tuple of the same size by keeping all the values from this tuple and overriding the second element with the value returned by applying the given function to this tuple's second element.
     */
    @Override
    public <X extends Z> TenTuple<Z, A, X, C, D, E, F, G, H, I, J> second(Function<B, X> function) {
        return new TenTuple<>(first(), function.apply(second()), third(), fourth(), fifth(), sixth(), seventh(), eighth(), ninth(), tenth());
    }

    /**
     * Returns a new tuple of one size smaller by keeping all the values from this tuple except the second element.
     */
    @Override
    public NineTuple<Z, A, C, D, E, F, G, H, I, J> dropSecond() {
        return new NineTuple<>(first(), third(), fourth(), fifth(), sixth(), seventh(), eighth(), ninth(), tenth());
    }

    /**
     * Returns a new tuple of the same size by keeping all the values from this tuple and overriding the third element with the provided value.
     */
    @Override
    public <X extends Z> TenTuple<Z, A, B, X, D, E, F, G, H, I, J> third(X value) {
        return new TenTuple<>(first(), second(), value, fourth(), fifth(), sixth(), seventh(), eighth(), ninth(), tenth());
    }

    /**
     * Returns a new tuple of the same size by keeping all the values from this tuple and overriding the third element with the value returned from the given supplier.
     */
    @Override
    public <X extends Z> TenTuple<Z, A, B, X, D, E, F, G, H, I, J> third(Supplier<X> supplier) {
        return new TenTuple<>(first(), second(), supplier.get(), fourth(), fifth(), sixth(), seventh(), eighth(), ninth(), tenth());
    }

    /**
     * Returns a new tuple of the same size by keeping all the values from this tuple and overriding the third element with the value returned by applying the given function to this tuple's third element.
     */
    @Override
    public <X extends Z> TenTuple<Z, A, B, X, D, E, F, G, H, I, J> third(Function<C, X> function) {
        return new TenTuple<>(first(), second(), function.apply(third()), fourth(), fifth(), sixth(), seventh(), eighth(), ninth(), tenth());
    }

    /**
     * Returns a new tuple of one size smaller by keeping all the values from this tuple except the third element.
     */
    @Override
    public NineTuple<Z, A, B, D, E, F, G, H, I, J> dropThird() {
        return new NineTuple<>(first(), second(), fourth(), fifth(), sixth(), seventh(), eighth(), ninth(), tenth());
    }

    /**
     * Returns a new tuple of the same size by keeping all the values from this tuple and overriding the fourth element with the provided value.
     */
    @Override
    public <X extends Z> TenTuple<Z, A, B, C, X, E, F, G, H, I, J> fourth(X value) {
        return new TenTuple<>(first(), second(), third(), value, fifth(), sixth(), seventh(), eighth(), ninth(), tenth());
    }

    /**
     * Returns a new tuple of the same size by keeping all the values from this tuple and overriding the fourth element with the value returned from the given supplier.
     */
    @Override
    public <X extends Z> TenTuple<Z, A, B, C, X, E, F, G, H, I, J> fourth(Supplier<X> supplier) {
        return new TenTuple<>(first(), second(), third(), supplier.get(), fifth(), sixth(), seventh(), eighth(), ninth(), tenth());
    }

    /**
     * Returns a new tuple of the same size by keeping all the values from this tuple and overriding the fourth element with the value returned by applying the given function to this tuple's fourth element.
     */
    @Override
    public <X extends Z> TenTuple<Z, A, B, C, X, E, F, G, H, I, J> fourth(Function<D, X> function) {
        return new TenTuple<>(first(), second(), third(), function.apply(fourth()), fifth(), sixth(), seventh(), eighth(), ninth(), tenth());
    }

    /**
     * Returns a new tuple of one size smaller by keeping all the values from this tuple except the fourth element.
     */
    @Override
    public NineTuple<Z, A, B, C, E, F, G, H, I, J> dropFourth() {
        return new NineTuple<>(first(), second(), third(), fifth(), sixth(), seventh(), eighth(), ninth(), tenth());
    }

    /**
     * Returns a new tuple of the same size by keeping all the values from this tuple and overriding the fifth element with the provided value.
     */
    @Override
    public <X extends Z> TenTuple<Z, A, B, C, D, X, F, G, H, I, J> fifth(X value) {
        return new TenTuple<>(first(), second(), third(), fourth(), value, sixth(), seventh(), eighth(), ninth(), tenth());
    }

    /**
     * Returns a new tuple of the same size by keeping all the values from this tuple and overriding the fifth element with the value returned from the given supplier.
     */
    @Override
    public <X extends Z> TenTuple<Z, A, B, C, D, X, F, G, H, I, J> fifth(Supplier<X> supplier) {
        return new TenTuple<>(first(), second(), third(), fourth(), supplier.get(), sixth(), seventh(), eighth(), ninth(), tenth());
    }

    /**
     * Returns a new tuple of the same size by keeping all the values from this tuple and overriding the fifth element with the value returned by applying the given function to this tuple's fifth element.
     */
    @Override
    public <X extends Z> TenTuple<Z, A, B, C, D, X, F, G, H, I, J> fifth(Function<E, X> function) {
        return new TenTuple<>(first(), second(), third(), fourth(), function.apply(fifth()), sixth(), seventh(), eighth(), ninth(), tenth());
    }

    /**
     * Returns a new tuple of one size smaller by keeping all the values from this tuple except the fifth element.
     */
    @Override
    public NineTuple<Z, A, B, C, D, F, G, H, I, J> dropFifth() {
        return new NineTuple<>(first(), second(), third(), fourth(), sixth(), seventh(), eighth(), ninth(), tenth());
    }

    /**
     * Returns a new tuple of the same size by keeping all the values from this tuple and overriding the sixth element with the provided value.
     */
    @Override
    public <X extends Z> TenTuple<Z, A, B, C, D, E, X, G, H, I, J> sixth(X value) {
        return new TenTuple<>(first(), second(), third(), fourth(), fifth(), value, seventh(), eighth(), ninth(), tenth());
    }

    /**
     * Returns a new tuple of the same size by keeping all the values from this tuple and overriding the sixth element with the value returned from the given supplier.
     */
    @Override
    public <X extends Z> TenTuple<Z, A, B, C, D, E, X, G, H, I, J> sixth(Supplier<X> supplier) {
        return new TenTuple<>(first(), second(), third(), fourth(), fifth(), supplier.get(), seventh(), eighth(), ninth(), tenth());
    }

    /**
     * Returns a new tuple of the same size by keeping all the values from this tuple and overriding the sixth element with the value returned by applying the given function to this tuple's sixth element.
     */
    @Override
    public <X extends Z> TenTuple<Z, A, B, C, D, E, X, G, H, I, J> sixth(Function<F, X> function) {
        return new TenTuple<>(first(), second(), third(), fourth(), fifth(), function.apply(sixth()), seventh(), eighth(), ninth(), tenth());
    }

    /**
     * Returns a new tuple of one size smaller by keeping all the values from this tuple except the sixth element.
     */
    @Override
    public NineTuple<Z, A, B, C, D, E, G, H, I, J> dropSixth() {
        return new NineTuple<>(first(), second(), third(), fourth(), fifth(), seventh(), eighth(), ninth(), tenth());
    }

    /**
     * Returns a new tuple of the same size by keeping all the values from this tuple and overriding the seventh element with the provided value.
     */
    @Override
    public <X extends Z> TenTuple<Z, A, B, C, D, E, F, X, H, I, J> seventh(X value) {
        return new TenTuple<>(first(), second(), third(), fourth(), fifth(), sixth(), value, eighth(), ninth(), tenth());
    }

    /**
     * Returns a new tuple of the same size by keeping all the values from this tuple and overriding the seventh element with the value returned from the given supplier.
     */
    @Override
    public <X extends Z> TenTuple<Z, A, B, C, D, E, F, X, H, I, J> seventh(Supplier<X> supplier) {
        return new TenTuple<>(first(), second(), third(), fourth(), fifth(), sixth(), supplier.get(), eighth(), ninth(), tenth());
    }

    /**
     * Returns a new tuple of the same size by keeping all the values from this tuple and overriding the seventh element with the value returned by applying the given function to this tuple's seventh element.
     */
    @Override
    public <X extends Z> TenTuple<Z, A, B, C, D, E, F, X, H, I, J> seventh(Function<G, X> function) {
        return new TenTuple<>(first(), second(), third(), fourth(), fifth(), sixth(), function.apply(seventh()), eighth(), ninth(), tenth());
    }

    /**
     * Returns a new tuple of one size smaller by keeping all the values from this tuple except the seventh element.
     */
    @Override
    public NineTuple<Z, A, B, C, D, E, F, H, I, J> dropSeventh() {
        return new NineTuple<>(first(), second(), third(), fourth(), fifth(), sixth(), eighth(), ninth(), tenth());
    }

    /**
     * Returns a new tuple of the same size by keeping all the values from this tuple and overriding the eighth element with the provided value.
     */
    @Override
    public <X extends Z> TenTuple<Z, A, B, C, D, E, F, G, X, I, J> eighth(X value) {
        return new TenTuple<>(first(), second(), third(), fourth(), fifth(), sixth(), seventh(), value, ninth(), tenth());
    }

    /**
     * Returns a new tuple of the same size by keeping all the values from this tuple and overriding the eighth element with the value returned from the given supplier.
     */
    @Override
    public <X extends Z> TenTuple<Z, A, B, C, D, E, F, G, X, I, J> eighth(Supplier<X> supplier) {
        return new TenTuple<>(first(), second(), third(), fourth(), fifth(), sixth(), seventh(), supplier.get(), ninth(), tenth());
    }

    /**
     * Returns a new tuple of the same size by keeping all the values from this tuple and overriding the eighth element with the value returned by applying the given function to this tuple's eighth element.
     */
    @Override
    public <X extends Z> TenTuple<Z, A, B, C, D, E, F, G, X, I, J> eighth(Function<H, X> function) {
        return new TenTuple<>(first(), second(), third(), fourth(), fifth(), sixth(), seventh(), function.apply(eighth()), ninth(), tenth());
    }

    /**
     * Returns a new tuple of one size smaller by keeping all the values from this tuple except the eighth element.
     */
    @Override
    public NineTuple<Z, A, B, C, D, E, F, G, I, J> dropEighth() {
        return new NineTuple<>(first(), second(), third(), fourth(), fifth(), sixth(), seventh(), ninth(), tenth());
    }

    /**
     * Returns a new tuple of the same size by keeping all the values from this tuple and overriding the ninth element with the provided value.
     */
    @Override
    public <X extends Z> TenTuple<Z, A, B, C, D, E, F, G, H, X, J> ninth(X value) {
        return new TenTuple<>(first(), second(), third(), fourth(), fifth(), sixth(), seventh(), eighth(), value, tenth());
    }

    /**
     * Returns a new tuple of the same size by keeping all the values from this tuple and overriding the ninth element with the value returned from the given supplier.
     */
    @Override
    public <X extends Z> TenTuple<Z, A, B, C, D, E, F, G, H, X, J> ninth(Supplier<X> supplier) {
        return new TenTuple<>(first(), second(), third(), fourth(), fifth(), sixth(), seventh(), eighth(), supplier.get(), tenth());
    }

    /**
     * Returns a new tuple of the same size by keeping all the values from this tuple and overriding the ninth element with the value returned by applying the given function to this tuple's ninth element.
     */
    @Override
    public <X extends Z> TenTuple<Z, A, B, C, D, E, F, G, H, X, J> ninth(Function<I, X> function) {
        return new TenTuple<>(first(), second(), third(), fourth(), fifth(), sixth(), seventh(), eighth(), function.apply(ninth()), tenth());
    }

    /**
     * Returns a new tuple of one size smaller by keeping all the values from this tuple except the ninth element.
     */
    @Override
    public NineTuple<Z, A, B, C, D, E, F, G, H, J> dropNinth() {
        return new NineTuple<>(first(), second(), third(), fourth(), fifth(), sixth(), seventh(), eighth(), tenth());
    }

    /**
     * Returns a new tuple of the same size by keeping all the values from this tuple and overriding the tenth element with the provided value.
     */
    @Override
    public <X extends Z> TenTuple<Z, A, B, C, D, E, F, G, H, I, X> tenth(X value) {
        return new TenTuple<>(first(), second(), third(), fourth(), fifth(), sixth(), seventh(), eighth(), ninth(), value);
    }

    /**
     * Returns a new tuple of the same size by keeping all the values from this tuple and overriding the tenth element with the value returned from the given supplier.
     */
    @Override
    public <X extends Z> TenTuple<Z, A, B, C, D, E, F, G, H, I, X> tenth(Supplier<X> supplier) {
        return new TenTuple<>(first(), second(), third(), fourth(), fifth(), sixth(), seventh(), eighth(), ninth(), supplier.get());
    }

    /**
     * Returns a new tuple of the same size by keeping all the values from this tuple and overriding the tenth element with the value returned by applying the given function to this tuple's tenth element.
     */
    @Override
    public <X extends Z> TenTuple<Z, A, B, C, D, E, F, G, H, I, X> tenth(Function<J, X> function) {
        return new TenTuple<>(first(), second(), third(), fourth(), fifth(), sixth(), seventh(), eighth(), ninth(), function.apply(tenth()));
    }

    /**
     * Returns a new tuple of one size smaller by keeping all the values from this tuple except the tenth element.
     */
    @Override
    public NineTuple<Z, A, B, C, D, E, F, G, H, I> dropTenth() {
        return new NineTuple<>(first(), second(), third(), fourth(), fifth(), sixth(), seventh(), eighth(), ninth());
    }

    /**
     * Extends the tuple to which this is applied by adding the provided value to the end.
     *
     * <p>This is especially useful in functional contexts. For instance:
     *
     * <pre>
     * elevenTupleStream = tenTupleStream.map(TenTuple.extendWith(value));
     * </pre>
     *
     * @see #extend(Object)
     */
    public static <Z, A extends Z, B extends Z, C extends Z, D extends Z, E extends Z, F extends Z, G extends Z, H extends Z, I extends Z, J extends Z, X extends Z> Function<TenTuple<Z, A, B, C, D, E, F, G, H, I, J>, ElevenTuple<Z, A, B, C, D, E, F, G, H, I, J, X>> extendWith(X value) {
        return tuple -> tuple.extend(value);
    }

    /**
     * Extends the tuple to which this is applied by adding the value from the supplier to the end.
     *
     * <p>This is especially useful in functional contexts. For instance:
     *
     * <pre>
     * elevenTupleStream = tenTupleStream.map(TenTuple.extendWith(supplier));
     * </pre>
     *
     * @see #extend(Object)
     */
    public static <Z, A extends Z, B extends Z, C extends Z, D extends Z, E extends Z, F extends Z, G extends Z, H extends Z, I extends Z, J extends Z, X extends Z> Function<TenTuple<Z, A, B, C, D, E, F, G, H, I, J>, ElevenTuple<Z, A, B, C, D, E, F, G, H, I, J, X>> extendWith(Supplier<X> supplier) {
        return tuple -> tuple.extend(supplier);
    }

    /**
     * Extends the tuple to which this is applied by adding the value from the function to the end.
     *
     * <p>This is especially useful in functional contexts. For instance:
     *
     * <pre>
     * elevenTupleStream = tenTupleStream.map(TenTuple.extendWith(function));
     * </pre>
     *
     * @see #extend(Object)
     */
    public static <Z, A extends Z, B extends Z, C extends Z, D extends Z, E extends Z, F extends Z, G extends Z, H extends Z, I extends Z, J extends Z, X extends Z> Function<TenTuple<Z, A, B, C, D, E, F, G, H, I, J>, ElevenTuple<Z, A, B, C, D, E, F, G, H, I, J, X>> extendWith(Function<TenTuple<Z, A, B, C, D, E, F, G, H, I, J>, X> function) {
        return tuple -> tuple.extend(function);
    }

    /**
     * Creates a new instance of this class.
     */
    public static <Z, A extends Z, B extends Z, C extends Z, D extends Z, E extends Z, F extends Z, G extends Z, H extends Z, I extends Z, J extends Z> TenTuple<Z, A, B, C, D, E, F, G, H, I, J> of(A first, B second, C third, D fourth, E fifth, F sixth, G seventh, H eighth, I ninth, J tenth) {
        return new TenTuple<>(first, second, third, fourth, fifth, sixth, seventh, eighth, ninth, tenth);
    }

}


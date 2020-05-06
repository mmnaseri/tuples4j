package com.mmnaseri.utils.tuples.impl;

import com.mmnaseri.utils.tuples.facade.HasEighth;
import com.mmnaseri.utils.tuples.facade.HasEleventh;
import com.mmnaseri.utils.tuples.facade.HasFifth;
import com.mmnaseri.utils.tuples.facade.HasFirst;
import com.mmnaseri.utils.tuples.facade.HasFourth;
import com.mmnaseri.utils.tuples.facade.HasNinth;
import com.mmnaseri.utils.tuples.facade.HasSecond;
import com.mmnaseri.utils.tuples.facade.HasSeventh;
import com.mmnaseri.utils.tuples.facade.HasSixth;
import com.mmnaseri.utils.tuples.facade.HasTenth;
import com.mmnaseri.utils.tuples.facade.HasThird;

import java.util.function.Function;
import java.util.function.Supplier;

import static com.mmnaseri.utils.tuples.utils.TupleUtils.checkIndex;

/**
 * Class for dealing with a {@link com.mmnaseri.utils.tuples.FixedTuple} with eleven elements.
 *
 * @author Milad Naseri (m.m.naseri@gmail.com)
 */
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

    /**
     * Creates a new instance of this class from the provided values.
     */
    public ElevenTuple(A first, B second, C third, D fourth, E fifth, F sixth, G seventh, H eighth, I ninth, J tenth, K eleventh) {
        super(first, second, third, fourth, fifth, sixth, seventh, eighth, ninth, tenth, eleventh);
    }

    /**
     * Returns a new tuple by keeping all the values from this tuple and overriding the value at the provided index with the value returned from the supplier.
     */
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

    /**
     * Returns a new tuple by keeping all the values from this tuple and overriding the value at the provided index with the value returned from the function.
     */
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

    /**
     * Returns a new tuple of one size larger by adding the provided value to the end of this tuple.
     */
    @Override
    public <X extends Z> TwelveTuple<Z, A, B, C, D, E, F, G, H, I, J, K, X> extend(X value) {
        return new TwelveTuple<>(first(), second(), third(), fourth(), fifth(), sixth(), seventh(), eighth(), ninth(), tenth(), eleventh(), value);
    }

    /**
     * Returns a new tuple of one size larger by adding the value returned from the supplier to the end of this tuple.
     */
    @Override
    public <X extends Z> TwelveTuple<Z, A, B, C, D, E, F, G, H, I, J, K, X> extend(Supplier<X> supplier) {
        return new TwelveTuple<>(first(), second(), third(), fourth(), fifth(), sixth(), seventh(), eighth(), ninth(), tenth(), eleventh(), supplier.get());
    }

    /**
     * Returns a new tuple of one size larger by adding the value returned from the function to the end of this tuple.
     */
    @Override
    public <X extends Z> TwelveTuple<Z, A, B, C, D, E, F, G, H, I, J, K, X> extend(Function<ElevenTuple<Z, A, B, C, D, E, F, G, H, I, J, K>, X> function) {
        return new TwelveTuple<>(first(), second(), third(), fourth(), fifth(), sixth(), seventh(), eighth(), ninth(), tenth(), eleventh(), function.apply(this));
    }

    /**
     * Returns a new tuple of the same size by keeping all the values from this tuple and overriding the first element with the provided value.
     */
    @Override
    public <X extends Z> ElevenTuple<Z, X, B, C, D, E, F, G, H, I, J, K> first(X value) {
        return new ElevenTuple<>(value, second(), third(), fourth(), fifth(), sixth(), seventh(), eighth(), ninth(), tenth(), eleventh());
    }

    /**
     * Returns a new tuple of the same size by keeping all the values from this tuple and overriding the first element with the value returned from the given supplier.
     */
    @Override
    public <X extends Z> ElevenTuple<Z, X, B, C, D, E, F, G, H, I, J, K> first(Supplier<X> supplier) {
        return new ElevenTuple<>(supplier.get(), second(), third(), fourth(), fifth(), sixth(), seventh(), eighth(), ninth(), tenth(), eleventh());
    }

    /**
     * Returns a new tuple of the same size by keeping all the values from this tuple and overriding the first element with the value returned by applying the given function to this tuple's first element.
     */
    @Override
    public <X extends Z> ElevenTuple<Z, X, B, C, D, E, F, G, H, I, J, K> first(Function<A, X> function) {
        return new ElevenTuple<>(function.apply(first()), second(), third(), fourth(), fifth(), sixth(), seventh(), eighth(), ninth(), tenth(), eleventh());
    }

    /**
     * Returns a new tuple of one size smaller by keeping all the values from this tuple except the first element.
     */
    @Override
    public TenTuple<Z, B, C, D, E, F, G, H, I, J, K> dropFirst() {
        return new TenTuple<>(second(), third(), fourth(), fifth(), sixth(), seventh(), eighth(), ninth(), tenth(), eleventh());
    }

    /**
     * Returns a new tuple of the same size by keeping all the values from this tuple and overriding the second element with the provided value.
     */
    @Override
    public <X extends Z> ElevenTuple<Z, A, X, C, D, E, F, G, H, I, J, K> second(X value) {
        return new ElevenTuple<>(first(), value, third(), fourth(), fifth(), sixth(), seventh(), eighth(), ninth(), tenth(), eleventh());
    }

    /**
     * Returns a new tuple of the same size by keeping all the values from this tuple and overriding the second element with the value returned from the given supplier.
     */
    @Override
    public <X extends Z> ElevenTuple<Z, A, X, C, D, E, F, G, H, I, J, K> second(Supplier<X> supplier) {
        return new ElevenTuple<>(first(), supplier.get(), third(), fourth(), fifth(), sixth(), seventh(), eighth(), ninth(), tenth(), eleventh());
    }

    /**
     * Returns a new tuple of the same size by keeping all the values from this tuple and overriding the second element with the value returned by applying the given function to this tuple's second element.
     */
    @Override
    public <X extends Z> ElevenTuple<Z, A, X, C, D, E, F, G, H, I, J, K> second(Function<B, X> function) {
        return new ElevenTuple<>(first(), function.apply(second()), third(), fourth(), fifth(), sixth(), seventh(), eighth(), ninth(), tenth(), eleventh());
    }

    /**
     * Returns a new tuple of one size smaller by keeping all the values from this tuple except the second element.
     */
    @Override
    public TenTuple<Z, A, C, D, E, F, G, H, I, J, K> dropSecond() {
        return new TenTuple<>(first(), third(), fourth(), fifth(), sixth(), seventh(), eighth(), ninth(), tenth(), eleventh());
    }

    /**
     * Returns a new tuple of the same size by keeping all the values from this tuple and overriding the third element with the provided value.
     */
    @Override
    public <X extends Z> ElevenTuple<Z, A, B, X, D, E, F, G, H, I, J, K> third(X value) {
        return new ElevenTuple<>(first(), second(), value, fourth(), fifth(), sixth(), seventh(), eighth(), ninth(), tenth(), eleventh());
    }

    /**
     * Returns a new tuple of the same size by keeping all the values from this tuple and overriding the third element with the value returned from the given supplier.
     */
    @Override
    public <X extends Z> ElevenTuple<Z, A, B, X, D, E, F, G, H, I, J, K> third(Supplier<X> supplier) {
        return new ElevenTuple<>(first(), second(), supplier.get(), fourth(), fifth(), sixth(), seventh(), eighth(), ninth(), tenth(), eleventh());
    }

    /**
     * Returns a new tuple of the same size by keeping all the values from this tuple and overriding the third element with the value returned by applying the given function to this tuple's third element.
     */
    @Override
    public <X extends Z> ElevenTuple<Z, A, B, X, D, E, F, G, H, I, J, K> third(Function<C, X> function) {
        return new ElevenTuple<>(first(), second(), function.apply(third()), fourth(), fifth(), sixth(), seventh(), eighth(), ninth(), tenth(), eleventh());
    }

    /**
     * Returns a new tuple of one size smaller by keeping all the values from this tuple except the third element.
     */
    @Override
    public TenTuple<Z, A, B, D, E, F, G, H, I, J, K> dropThird() {
        return new TenTuple<>(first(), second(), fourth(), fifth(), sixth(), seventh(), eighth(), ninth(), tenth(), eleventh());
    }

    /**
     * Returns a new tuple of the same size by keeping all the values from this tuple and overriding the fourth element with the provided value.
     */
    @Override
    public <X extends Z> ElevenTuple<Z, A, B, C, X, E, F, G, H, I, J, K> fourth(X value) {
        return new ElevenTuple<>(first(), second(), third(), value, fifth(), sixth(), seventh(), eighth(), ninth(), tenth(), eleventh());
    }

    /**
     * Returns a new tuple of the same size by keeping all the values from this tuple and overriding the fourth element with the value returned from the given supplier.
     */
    @Override
    public <X extends Z> ElevenTuple<Z, A, B, C, X, E, F, G, H, I, J, K> fourth(Supplier<X> supplier) {
        return new ElevenTuple<>(first(), second(), third(), supplier.get(), fifth(), sixth(), seventh(), eighth(), ninth(), tenth(), eleventh());
    }

    /**
     * Returns a new tuple of the same size by keeping all the values from this tuple and overriding the fourth element with the value returned by applying the given function to this tuple's fourth element.
     */
    @Override
    public <X extends Z> ElevenTuple<Z, A, B, C, X, E, F, G, H, I, J, K> fourth(Function<D, X> function) {
        return new ElevenTuple<>(first(), second(), third(), function.apply(fourth()), fifth(), sixth(), seventh(), eighth(), ninth(), tenth(), eleventh());
    }

    /**
     * Returns a new tuple of one size smaller by keeping all the values from this tuple except the fourth element.
     */
    @Override
    public TenTuple<Z, A, B, C, E, F, G, H, I, J, K> dropFourth() {
        return new TenTuple<>(first(), second(), third(), fifth(), sixth(), seventh(), eighth(), ninth(), tenth(), eleventh());
    }

    /**
     * Returns a new tuple of the same size by keeping all the values from this tuple and overriding the fifth element with the provided value.
     */
    @Override
    public <X extends Z> ElevenTuple<Z, A, B, C, D, X, F, G, H, I, J, K> fifth(X value) {
        return new ElevenTuple<>(first(), second(), third(), fourth(), value, sixth(), seventh(), eighth(), ninth(), tenth(), eleventh());
    }

    /**
     * Returns a new tuple of the same size by keeping all the values from this tuple and overriding the fifth element with the value returned from the given supplier.
     */
    @Override
    public <X extends Z> ElevenTuple<Z, A, B, C, D, X, F, G, H, I, J, K> fifth(Supplier<X> supplier) {
        return new ElevenTuple<>(first(), second(), third(), fourth(), supplier.get(), sixth(), seventh(), eighth(), ninth(), tenth(), eleventh());
    }

    /**
     * Returns a new tuple of the same size by keeping all the values from this tuple and overriding the fifth element with the value returned by applying the given function to this tuple's fifth element.
     */
    @Override
    public <X extends Z> ElevenTuple<Z, A, B, C, D, X, F, G, H, I, J, K> fifth(Function<E, X> function) {
        return new ElevenTuple<>(first(), second(), third(), fourth(), function.apply(fifth()), sixth(), seventh(), eighth(), ninth(), tenth(), eleventh());
    }

    /**
     * Returns a new tuple of one size smaller by keeping all the values from this tuple except the fifth element.
     */
    @Override
    public TenTuple<Z, A, B, C, D, F, G, H, I, J, K> dropFifth() {
        return new TenTuple<>(first(), second(), third(), fourth(), sixth(), seventh(), eighth(), ninth(), tenth(), eleventh());
    }

    /**
     * Returns a new tuple of the same size by keeping all the values from this tuple and overriding the sixth element with the provided value.
     */
    @Override
    public <X extends Z> ElevenTuple<Z, A, B, C, D, E, X, G, H, I, J, K> sixth(X value) {
        return new ElevenTuple<>(first(), second(), third(), fourth(), fifth(), value, seventh(), eighth(), ninth(), tenth(), eleventh());
    }

    /**
     * Returns a new tuple of the same size by keeping all the values from this tuple and overriding the sixth element with the value returned from the given supplier.
     */
    @Override
    public <X extends Z> ElevenTuple<Z, A, B, C, D, E, X, G, H, I, J, K> sixth(Supplier<X> supplier) {
        return new ElevenTuple<>(first(), second(), third(), fourth(), fifth(), supplier.get(), seventh(), eighth(), ninth(), tenth(), eleventh());
    }

    /**
     * Returns a new tuple of the same size by keeping all the values from this tuple and overriding the sixth element with the value returned by applying the given function to this tuple's sixth element.
     */
    @Override
    public <X extends Z> ElevenTuple<Z, A, B, C, D, E, X, G, H, I, J, K> sixth(Function<F, X> function) {
        return new ElevenTuple<>(first(), second(), third(), fourth(), fifth(), function.apply(sixth()), seventh(), eighth(), ninth(), tenth(), eleventh());
    }

    /**
     * Returns a new tuple of one size smaller by keeping all the values from this tuple except the sixth element.
     */
    @Override
    public TenTuple<Z, A, B, C, D, E, G, H, I, J, K> dropSixth() {
        return new TenTuple<>(first(), second(), third(), fourth(), fifth(), seventh(), eighth(), ninth(), tenth(), eleventh());
    }

    /**
     * Returns a new tuple of the same size by keeping all the values from this tuple and overriding the seventh element with the provided value.
     */
    @Override
    public <X extends Z> ElevenTuple<Z, A, B, C, D, E, F, X, H, I, J, K> seventh(X value) {
        return new ElevenTuple<>(first(), second(), third(), fourth(), fifth(), sixth(), value, eighth(), ninth(), tenth(), eleventh());
    }

    /**
     * Returns a new tuple of the same size by keeping all the values from this tuple and overriding the seventh element with the value returned from the given supplier.
     */
    @Override
    public <X extends Z> ElevenTuple<Z, A, B, C, D, E, F, X, H, I, J, K> seventh(Supplier<X> supplier) {
        return new ElevenTuple<>(first(), second(), third(), fourth(), fifth(), sixth(), supplier.get(), eighth(), ninth(), tenth(), eleventh());
    }

    /**
     * Returns a new tuple of the same size by keeping all the values from this tuple and overriding the seventh element with the value returned by applying the given function to this tuple's seventh element.
     */
    @Override
    public <X extends Z> ElevenTuple<Z, A, B, C, D, E, F, X, H, I, J, K> seventh(Function<G, X> function) {
        return new ElevenTuple<>(first(), second(), third(), fourth(), fifth(), sixth(), function.apply(seventh()), eighth(), ninth(), tenth(), eleventh());
    }

    /**
     * Returns a new tuple of one size smaller by keeping all the values from this tuple except the seventh element.
     */
    @Override
    public TenTuple<Z, A, B, C, D, E, F, H, I, J, K> dropSeventh() {
        return new TenTuple<>(first(), second(), third(), fourth(), fifth(), sixth(), eighth(), ninth(), tenth(), eleventh());
    }

    /**
     * Returns a new tuple of the same size by keeping all the values from this tuple and overriding the eighth element with the provided value.
     */
    @Override
    public <X extends Z> ElevenTuple<Z, A, B, C, D, E, F, G, X, I, J, K> eighth(X value) {
        return new ElevenTuple<>(first(), second(), third(), fourth(), fifth(), sixth(), seventh(), value, ninth(), tenth(), eleventh());
    }

    /**
     * Returns a new tuple of the same size by keeping all the values from this tuple and overriding the eighth element with the value returned from the given supplier.
     */
    @Override
    public <X extends Z> ElevenTuple<Z, A, B, C, D, E, F, G, X, I, J, K> eighth(Supplier<X> supplier) {
        return new ElevenTuple<>(first(), second(), third(), fourth(), fifth(), sixth(), seventh(), supplier.get(), ninth(), tenth(), eleventh());
    }

    /**
     * Returns a new tuple of the same size by keeping all the values from this tuple and overriding the eighth element with the value returned by applying the given function to this tuple's eighth element.
     */
    @Override
    public <X extends Z> ElevenTuple<Z, A, B, C, D, E, F, G, X, I, J, K> eighth(Function<H, X> function) {
        return new ElevenTuple<>(first(), second(), third(), fourth(), fifth(), sixth(), seventh(), function.apply(eighth()), ninth(), tenth(), eleventh());
    }

    /**
     * Returns a new tuple of one size smaller by keeping all the values from this tuple except the eighth element.
     */
    @Override
    public TenTuple<Z, A, B, C, D, E, F, G, I, J, K> dropEighth() {
        return new TenTuple<>(first(), second(), third(), fourth(), fifth(), sixth(), seventh(), ninth(), tenth(), eleventh());
    }

    /**
     * Returns a new tuple of the same size by keeping all the values from this tuple and overriding the ninth element with the provided value.
     */
    @Override
    public <X extends Z> ElevenTuple<Z, A, B, C, D, E, F, G, H, X, J, K> ninth(X value) {
        return new ElevenTuple<>(first(), second(), third(), fourth(), fifth(), sixth(), seventh(), eighth(), value, tenth(), eleventh());
    }

    /**
     * Returns a new tuple of the same size by keeping all the values from this tuple and overriding the ninth element with the value returned from the given supplier.
     */
    @Override
    public <X extends Z> ElevenTuple<Z, A, B, C, D, E, F, G, H, X, J, K> ninth(Supplier<X> supplier) {
        return new ElevenTuple<>(first(), second(), third(), fourth(), fifth(), sixth(), seventh(), eighth(), supplier.get(), tenth(), eleventh());
    }

    /**
     * Returns a new tuple of the same size by keeping all the values from this tuple and overriding the ninth element with the value returned by applying the given function to this tuple's ninth element.
     */
    @Override
    public <X extends Z> ElevenTuple<Z, A, B, C, D, E, F, G, H, X, J, K> ninth(Function<I, X> function) {
        return new ElevenTuple<>(first(), second(), third(), fourth(), fifth(), sixth(), seventh(), eighth(), function.apply(ninth()), tenth(), eleventh());
    }

    /**
     * Returns a new tuple of one size smaller by keeping all the values from this tuple except the ninth element.
     */
    @Override
    public TenTuple<Z, A, B, C, D, E, F, G, H, J, K> dropNinth() {
        return new TenTuple<>(first(), second(), third(), fourth(), fifth(), sixth(), seventh(), eighth(), tenth(), eleventh());
    }

    /**
     * Returns a new tuple of the same size by keeping all the values from this tuple and overriding the tenth element with the provided value.
     */
    @Override
    public <X extends Z> ElevenTuple<Z, A, B, C, D, E, F, G, H, I, X, K> tenth(X value) {
        return new ElevenTuple<>(first(), second(), third(), fourth(), fifth(), sixth(), seventh(), eighth(), ninth(), value, eleventh());
    }

    /**
     * Returns a new tuple of the same size by keeping all the values from this tuple and overriding the tenth element with the value returned from the given supplier.
     */
    @Override
    public <X extends Z> ElevenTuple<Z, A, B, C, D, E, F, G, H, I, X, K> tenth(Supplier<X> supplier) {
        return new ElevenTuple<>(first(), second(), third(), fourth(), fifth(), sixth(), seventh(), eighth(), ninth(), supplier.get(), eleventh());
    }

    /**
     * Returns a new tuple of the same size by keeping all the values from this tuple and overriding the tenth element with the value returned by applying the given function to this tuple's tenth element.
     */
    @Override
    public <X extends Z> ElevenTuple<Z, A, B, C, D, E, F, G, H, I, X, K> tenth(Function<J, X> function) {
        return new ElevenTuple<>(first(), second(), third(), fourth(), fifth(), sixth(), seventh(), eighth(), ninth(), function.apply(tenth()), eleventh());
    }

    /**
     * Returns a new tuple of one size smaller by keeping all the values from this tuple except the tenth element.
     */
    @Override
    public TenTuple<Z, A, B, C, D, E, F, G, H, I, K> dropTenth() {
        return new TenTuple<>(first(), second(), third(), fourth(), fifth(), sixth(), seventh(), eighth(), ninth(), eleventh());
    }

    /**
     * Returns a new tuple of the same size by keeping all the values from this tuple and overriding the eleventh element with the provided value.
     */
    @Override
    public <X extends Z> ElevenTuple<Z, A, B, C, D, E, F, G, H, I, J, X> eleventh(X value) {
        return new ElevenTuple<>(first(), second(), third(), fourth(), fifth(), sixth(), seventh(), eighth(), ninth(), tenth(), value);
    }

    /**
     * Returns a new tuple of the same size by keeping all the values from this tuple and overriding the eleventh element with the value returned from the given supplier.
     */
    @Override
    public <X extends Z> ElevenTuple<Z, A, B, C, D, E, F, G, H, I, J, X> eleventh(Supplier<X> supplier) {
        return new ElevenTuple<>(first(), second(), third(), fourth(), fifth(), sixth(), seventh(), eighth(), ninth(), tenth(), supplier.get());
    }

    /**
     * Returns a new tuple of the same size by keeping all the values from this tuple and overriding the eleventh element with the value returned by applying the given function to this tuple's eleventh element.
     */
    @Override
    public <X extends Z> ElevenTuple<Z, A, B, C, D, E, F, G, H, I, J, X> eleventh(Function<K, X> function) {
        return new ElevenTuple<>(first(), second(), third(), fourth(), fifth(), sixth(), seventh(), eighth(), ninth(), tenth(), function.apply(eleventh()));
    }

    /**
     * Returns a new tuple of one size smaller by keeping all the values from this tuple except the eleventh element.
     */
    @Override
    public TenTuple<Z, A, B, C, D, E, F, G, H, I, J> dropEleventh() {
        return new TenTuple<>(first(), second(), third(), fourth(), fifth(), sixth(), seventh(), eighth(), ninth(), tenth());
    }

    /**
     * Extends the tuple to which this is applied by adding the provided value to the end.
     *
     * <p>This is especially useful in functional contexts. For instance:
     *
     * <pre>
     * twelveTupleStream = elevenTupleStream.map(ElevenTuple.extendWith(value));
     * </pre>
     *
     * @see #extend(Object)
     */
    public static <Z, A extends Z, B extends Z, C extends Z, D extends Z, E extends Z, F extends Z, G extends Z, H extends Z, I extends Z, J extends Z, K extends Z, X extends Z> Function<ElevenTuple<Z, A, B, C, D, E, F, G, H, I, J, K>, TwelveTuple<Z, A, B, C, D, E, F, G, H, I, J, K, X>> extendWith(X value) {
        return tuple -> tuple.extend(value);
    }

    /**
     * Extends the tuple to which this is applied by adding the value from the supplier to the end.
     *
     * <p>This is especially useful in functional contexts. For instance:
     *
     * <pre>
     * twelveTupleStream = elevenTupleStream.map(ElevenTuple.extendWith(supplier));
     * </pre>
     *
     * @see #extend(Object)
     */
    public static <Z, A extends Z, B extends Z, C extends Z, D extends Z, E extends Z, F extends Z, G extends Z, H extends Z, I extends Z, J extends Z, K extends Z, X extends Z> Function<ElevenTuple<Z, A, B, C, D, E, F, G, H, I, J, K>, TwelveTuple<Z, A, B, C, D, E, F, G, H, I, J, K, X>> extendWith(Supplier<X> supplier) {
        return tuple -> tuple.extend(supplier);
    }

    /**
     * Extends the tuple to which this is applied by adding the value from the function to the end.
     *
     * <p>This is especially useful in functional contexts. For instance:
     *
     * <pre>
     * twelveTupleStream = elevenTupleStream.map(ElevenTuple.extendWith(function));
     * </pre>
     *
     * @see #extend(Object)
     */
    public static <Z, A extends Z, B extends Z, C extends Z, D extends Z, E extends Z, F extends Z, G extends Z, H extends Z, I extends Z, J extends Z, K extends Z, X extends Z> Function<ElevenTuple<Z, A, B, C, D, E, F, G, H, I, J, K>, TwelveTuple<Z, A, B, C, D, E, F, G, H, I, J, K, X>> extendWith(
            Function<ElevenTuple<Z, A, B, C, D, E, F, G, H, I, J, K>, X> function) {
        return tuple -> tuple.extend(function);
    }

    /**
     * Creates a new instance of this class.
     */
    public static <Z, A extends Z, B extends Z, C extends Z, D extends Z, E extends Z, F extends Z, G extends Z, H extends Z, I extends Z, J extends Z, K extends Z> ElevenTuple<Z, A, B, C, D, E, F, G, H, I, J, K> of(A first, B second, C third, D fourth, E fifth, F sixth, G seventh, H eighth, I ninth, J tenth, K eleventh) {
        return new ElevenTuple<>(first, second, third, fourth, fifth, sixth, seventh, eighth, ninth, tenth, eleventh);
    }

}


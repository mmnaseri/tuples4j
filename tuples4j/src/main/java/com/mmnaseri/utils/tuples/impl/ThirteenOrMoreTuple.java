package com.mmnaseri.utils.tuples.impl;

import com.mmnaseri.utils.tuples.Tuple;
import com.mmnaseri.utils.tuples.facade.*;
import com.mmnaseri.utils.tuples.utils.FluentList;

import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;

import static com.mmnaseri.utils.tuples.utils.TupleUtils.checkIndex;

/**
 * Class for dealing with a {@link com.mmnaseri.utils.tuples.FixedTuple} with thirteen or more elements.
 *
 * @author Milad Naseri (m.m.naseri@gmail.com)
 */
public class ThirteenOrMoreTuple<Z, A extends Z, B extends Z, C extends Z, D extends Z, E extends Z, F extends Z, G extends Z, H extends Z, I extends Z, J extends Z, K extends Z, L extends Z> extends AbstractFixedTuple<Z, ThirteenOrMoreTuple<Z, A, B, C, D, E, F, G, H, I, J, K, L>>
        implements
        HasFirst<Z, A, ThirteenOrMoreTuple<Z, A, B, C, D, E, F, G, H, I, J, K, L>>,
        HasSecond<Z, B, ThirteenOrMoreTuple<Z, A, B, C, D, E, F, G, H, I, J, K, L>>,
        HasThird<Z, C, ThirteenOrMoreTuple<Z, A, B, C, D, E, F, G, H, I, J, K, L>>,
        HasFourth<Z, D, ThirteenOrMoreTuple<Z, A, B, C, D, E, F, G, H, I, J, K, L>>,
        HasFifth<Z, E, ThirteenOrMoreTuple<Z, A, B, C, D, E, F, G, H, I, J, K, L>>,
        HasSixth<Z, F, ThirteenOrMoreTuple<Z, A, B, C, D, E, F, G, H, I, J, K, L>>,
        HasSeventh<Z, G, ThirteenOrMoreTuple<Z, A, B, C, D, E, F, G, H, I, J, K, L>>,
        HasEighth<Z, H, ThirteenOrMoreTuple<Z, A, B, C, D, E, F, G, H, I, J, K, L>>,
        HasNinth<Z, I, ThirteenOrMoreTuple<Z, A, B, C, D, E, F, G, H, I, J, K, L>>,
        HasTenth<Z, J, ThirteenOrMoreTuple<Z, A, B, C, D, E, F, G, H, I, J, K, L>>,
        HasEleventh<Z, K, ThirteenOrMoreTuple<Z, A, B, C, D, E, F, G, H, I, J, K, L>>,
        HasTwelfth<Z, L, ThirteenOrMoreTuple<Z, A, B, C, D, E, F, G, H, I, J, K, L>> {

    /**
     * Creates a new instance of this class from the provided values.
     */
    @SafeVarargs
    public ThirteenOrMoreTuple(A first, B second, C third, D fourth, E fifth, F sixth, G seventh, H eighth, I ninth, J tenth, K eleventh, L twelfth, Z thirteenth, Z... rest) {
        //noinspection unchecked
        this(FluentList.of(first, second, third, fourth, fifth, sixth, seventh, eighth, ninth, tenth, eleventh, twelfth, thirteenth).withAll(rest));
    }

    private ThirteenOrMoreTuple(List<Z> values) {
        super(values);
    }

    @Override
    public ThirteenOrMoreTuple<Z, Z, Z, Z, Z, Z, Z, Z, Z, Z, Z, Z, Z> change(int index, Z value) {
        checkIndex(index, size());
        return new ThirteenOrMoreTuple<>(asList().change(index, value));
    }

    /**
     * Returns a new tuple by keeping all the values from this tuple and overriding the value at the provided index with the value returned from the supplier.
     */
    @Override
    public ThirteenOrMoreTuple<Z, Z, Z, Z, Z, Z, Z, Z, Z, Z, Z, Z, Z> change(int index, Supplier<? extends Z> supplier) {
        checkIndex(index, size());
        return new ThirteenOrMoreTuple<>(asList().change(index, supplier.get()));
    }

    /**
     * Returns a new tuple by keeping all the values from this tuple and overriding the value at the provided index with the value returned from the function.
     */
    @Override
    public ThirteenOrMoreTuple<Z, Z, Z, Z, Z, Z, Z, Z, Z, Z, Z, Z, Z> change(int index, Function<ThirteenOrMoreTuple<Z, A, B, C, D, E, F, G, H, I, J, K, L>, ? extends Z> function) {
        checkIndex(index, size());
        return new ThirteenOrMoreTuple<>(asList().change(index, function.apply(this)));
    }

    /**
     * Returns a new tuple of one size larger by adding the provided value to the end of this tuple.
     */
    @Override
    public <X extends Z> ThirteenOrMoreTuple<Z, A, B, C, D, E, F, G, H, I, J, K, L> extend(X value) {
        return new ThirteenOrMoreTuple<>(asList().with(value));
    }

    /**
     * Returns a new tuple of one size larger by adding the value returned from the supplier to the end of this tuple.
     */
    @Override
    public <X extends Z> ThirteenOrMoreTuple<Z, A, B, C, D, E, F, G, H, I, J, K, L> extend(Supplier<X> supplier) {
        return new ThirteenOrMoreTuple<>(asList().with(supplier.get()));
    }

    /**
     * Returns a new tuple of one size larger by adding the value returned from the function to the end of this tuple.
     */
    @Override
    public <X extends Z> ThirteenOrMoreTuple<Z, A, B, C, D, E, F, G, H, I, J, K, L> extend(Function<ThirteenOrMoreTuple<Z, A, B, C, D, E, F, G, H, I, J, K, L>, X> function) {
        return new ThirteenOrMoreTuple<>(asList().with(function.apply(this)));
    }

    /**
     * Returns a new tuple of the same size by keeping all the values from this tuple and overriding the first element with the provided value.
     */
    @Override
    public <X extends Z> Tuple<Z> first(X value) {
        return change(0, value);
    }

    /**
     * Returns a new tuple of the same size by keeping all the values from this tuple and overriding the first element with the value returned from the given supplier.
     */
    @Override
    public <X extends Z> Tuple<Z> first(Supplier<X> supplier) {
        return change(0, supplier.get());
    }

    /**
     * Returns a new tuple of the same size by keeping all the values from this tuple and overriding the first element with the value returned by applying the given function to this tuple's first element.
     */
    @Override
    public <X extends Z> Tuple<Z> first(Function<A, X> function) {
        return change(0, function.apply(first()));
    }

    /**
     * Returns a new tuple of one size smaller by keeping all the values from this tuple except the first element.
     */
    @Override
    public Tuple<Z> dropFirst() {
        return dropAtIndex(0);
    }

    /**
     * Returns a new tuple of the same size by keeping all the values from this tuple and overriding the second element with the provided value.
     */
    @Override
    public <X extends Z> Tuple<Z> second(X value) {
        return change(0, value);
    }

    /**
     * Returns a new tuple of the same size by keeping all the values from this tuple and overriding the second element with the value returned from the given supplier.
     */
    @Override
    public <X extends Z> Tuple<Z> second(Supplier<X> supplier) {
        return change(0, supplier.get());
    }

    /**
     * Returns a new tuple of the same size by keeping all the values from this tuple and overriding the second element with the value returned by applying the given function to this tuple's second element.
     */
    @Override
    public <X extends Z> Tuple<Z> second(Function<B, X> function) {
        return change(0, function.apply(second()));
    }

    /**
     * Returns a new tuple of one size smaller by keeping all the values from this tuple except the second element.
     */
    @Override
    public Tuple<Z> dropSecond() {
        return dropAtIndex(1);
    }

    /**
     * Returns a new tuple of the same size by keeping all the values from this tuple and overriding the third element with the provided value.
     */
    @Override
    public <X extends Z> Tuple<Z> third(X value) {
        return change(0, value);
    }

    /**
     * Returns a new tuple of the same size by keeping all the values from this tuple and overriding the third element with the value returned from the given supplier.
     */
    @Override
    public <X extends Z> Tuple<Z> third(Supplier<X> supplier) {
        return change(0, supplier.get());
    }

    /**
     * Returns a new tuple of the same size by keeping all the values from this tuple and overriding the third element with the value returned by applying the given function to this tuple's third element.
     */
    @Override
    public <X extends Z> Tuple<Z> third(Function<C, X> function) {
        return change(0, function.apply(third()));
    }

    /**
     * Returns a new tuple of one size smaller by keeping all the values from this tuple except the third element.
     */
    @Override
    public Tuple<Z> dropThird() {
        return dropAtIndex(2);
    }

    /**
     * Returns a new tuple of the same size by keeping all the values from this tuple and overriding the fourth element with the provided value.
     */
    @Override
    public <X extends Z> Tuple<Z> fourth(X value) {
        return change(0, value);
    }

    /**
     * Returns a new tuple of the same size by keeping all the values from this tuple and overriding the fourth element with the value returned from the given supplier.
     */
    @Override
    public <X extends Z> Tuple<Z> fourth(Supplier<X> supplier) {
        return change(0, supplier.get());
    }

    /**
     * Returns a new tuple of the same size by keeping all the values from this tuple and overriding the fourth element with the value returned by applying the given function to this tuple's fourth element.
     */
    @Override
    public <X extends Z> Tuple<Z> fourth(Function<D, X> function) {
        return change(0, function.apply(fourth()));
    }

    /**
     * Returns a new tuple of one size smaller by keeping all the values from this tuple except the fourth element.
     */
    @Override
    public Tuple<Z> dropFourth() {
        return dropAtIndex(3);
    }

    /**
     * Returns a new tuple of the same size by keeping all the values from this tuple and overriding the fifth element with the provided value.
     */
    @Override
    public <X extends Z> Tuple<Z> fifth(X value) {
        return change(0, value);
    }

    /**
     * Returns a new tuple of the same size by keeping all the values from this tuple and overriding the fifth element with the value returned from the given supplier.
     */
    @Override
    public <X extends Z> Tuple<Z> fifth(Supplier<X> supplier) {
        return change(0, supplier.get());
    }

    /**
     * Returns a new tuple of the same size by keeping all the values from this tuple and overriding the fifth element with the value returned by applying the given function to this tuple's fifth element.
     */
    @Override
    public <X extends Z> Tuple<Z> fifth(Function<E, X> function) {
        return change(0, function.apply(fifth()));
    }

    /**
     * Returns a new tuple of one size smaller by keeping all the values from this tuple except the fifth element.
     */
    @Override
    public Tuple<Z> dropFifth() {
        return dropAtIndex(4);
    }

    /**
     * Returns a new tuple of the same size by keeping all the values from this tuple and overriding the sixth element with the provided value.
     */
    @Override
    public <X extends Z> Tuple<Z> sixth(X value) {
        return change(0, value);
    }

    /**
     * Returns a new tuple of the same size by keeping all the values from this tuple and overriding the sixth element with the value returned from the given supplier.
     */
    @Override
    public <X extends Z> Tuple<Z> sixth(Supplier<X> supplier) {
        return change(0, supplier.get());
    }

    /**
     * Returns a new tuple of the same size by keeping all the values from this tuple and overriding the sixth element with the value returned by applying the given function to this tuple's sixth element.
     */
    @Override
    public <X extends Z> Tuple<Z> sixth(Function<F, X> function) {
        return change(0, function.apply(sixth()));
    }

    /**
     * Returns a new tuple of one size smaller by keeping all the values from this tuple except the sixth element.
     */
    @Override
    public Tuple<Z> dropSixth() {
        return dropAtIndex(5);
    }

    /**
     * Returns a new tuple of the same size by keeping all the values from this tuple and overriding the seventh element with the provided value.
     */
    @Override
    public <X extends Z> Tuple<Z> seventh(X value) {
        return change(0, value);
    }

    /**
     * Returns a new tuple of the same size by keeping all the values from this tuple and overriding the seventh element with the value returned from the given supplier.
     */
    @Override
    public <X extends Z> Tuple<Z> seventh(Supplier<X> supplier) {
        return change(0, supplier.get());
    }

    /**
     * Returns a new tuple of the same size by keeping all the values from this tuple and overriding the seventh element with the value returned by applying the given function to this tuple's seventh element.
     */
    @Override
    public <X extends Z> Tuple<Z> seventh(Function<G, X> function) {
        return change(0, function.apply(seventh()));
    }

    /**
     * Returns a new tuple of one size smaller by keeping all the values from this tuple except the seventh element.
     */
    @Override
    public Tuple<Z> dropSeventh() {
        return dropAtIndex(6);
    }

    /**
     * Returns a new tuple of the same size by keeping all the values from this tuple and overriding the eighth element with the provided value.
     */
    @Override
    public <X extends Z> Tuple<Z> eighth(X value) {
        return change(0, value);
    }

    /**
     * Returns a new tuple of the same size by keeping all the values from this tuple and overriding the eighth element with the value returned from the given supplier.
     */
    @Override
    public <X extends Z> Tuple<Z> eighth(Supplier<X> supplier) {
        return change(0, supplier.get());
    }

    /**
     * Returns a new tuple of the same size by keeping all the values from this tuple and overriding the eighth element with the value returned by applying the given function to this tuple's eighth element.
     */
    @Override
    public <X extends Z> Tuple<Z> eighth(Function<H, X> function) {
        return change(0, function.apply(eighth()));
    }

    /**
     * Returns a new tuple of one size smaller by keeping all the values from this tuple except the eighth element.
     */
    @Override
    public Tuple<Z> dropEighth() {
        return dropAtIndex(7);
    }

    /**
     * Returns a new tuple of the same size by keeping all the values from this tuple and overriding the ninth element with the provided value.
     */
    @Override
    public <X extends Z> Tuple<Z> ninth(X value) {
        return change(0, value);
    }

    /**
     * Returns a new tuple of the same size by keeping all the values from this tuple and overriding the ninth element with the value returned from the given supplier.
     */
    @Override
    public <X extends Z> Tuple<Z> ninth(Supplier<X> supplier) {
        return change(0, supplier.get());
    }

    /**
     * Returns a new tuple of the same size by keeping all the values from this tuple and overriding the ninth element with the value returned by applying the given function to this tuple's ninth element.
     */
    @Override
    public <X extends Z> Tuple<Z> ninth(Function<I, X> function) {
        return change(0, function.apply(ninth()));
    }

    /**
     * Returns a new tuple of one size smaller by keeping all the values from this tuple except the ninth element.
     */
    @Override
    public Tuple<Z> dropNinth() {
        return dropAtIndex(8);
    }

    /**
     * Returns a new tuple of the same size by keeping all the values from this tuple and overriding the tenth element with the provided value.
     */
    @Override
    public <X extends Z> Tuple<Z> tenth(X value) {
        return change(0, value);
    }

    /**
     * Returns a new tuple of the same size by keeping all the values from this tuple and overriding the tenth element with the value returned from the given supplier.
     */
    @Override
    public <X extends Z> Tuple<Z> tenth(Supplier<X> supplier) {
        return change(0, supplier.get());
    }

    /**
     * Returns a new tuple of the same size by keeping all the values from this tuple and overriding the tenth element with the value returned by applying the given function to this tuple's tenth element.
     */
    @Override
    public <X extends Z> Tuple<Z> tenth(Function<J, X> function) {
        return change(0, function.apply(tenth()));
    }

    /**
     * Returns a new tuple of one size smaller by keeping all the values from this tuple except the tenth element.
     */
    @Override
    public Tuple<Z> dropTenth() {
        return dropAtIndex(9);
    }

    /**
     * Returns a new tuple of the same size by keeping all the values from this tuple and overriding the eleventh element with the provided value.
     */
    @Override
    public <X extends Z> Tuple<Z> eleventh(X value) {
        return change(0, value);
    }

    /**
     * Returns a new tuple of the same size by keeping all the values from this tuple and overriding the eleventh element with the value returned from the given supplier.
     */
    @Override
    public <X extends Z> Tuple<Z> eleventh(Supplier<X> supplier) {
        return change(0, supplier.get());
    }

    /**
     * Returns a new tuple of the same size by keeping all the values from this tuple and overriding the eleventh element with the value returned by applying the given function to this tuple's eleventh element.
     */
    @Override
    public <X extends Z> Tuple<Z> eleventh(Function<K, X> function) {
        return change(0, function.apply(eleventh()));
    }

    /**
     * Returns a new tuple of one size smaller by keeping all the values from this tuple except the eleventh element.
     */
    @Override
    public Tuple<Z> dropEleventh() {
        return dropAtIndex(10);
    }

    /**
     * Returns a new tuple of the same size by keeping all the values from this tuple and overriding the twelfth element with the provided value.
     */
    @Override
    public <X extends Z> Tuple<Z> twelfth(X value) {
        return change(0, value);
    }

    /**
     * Returns a new tuple of the same size by keeping all the values from this tuple and overriding the twelfth element with the value returned from the given supplier.
     */
    @Override
    public <X extends Z> Tuple<Z> twelfth(Supplier<X> supplier) {
        return change(0, supplier.get());
    }

    /**
     * Returns a new tuple of the same size by keeping all the values from this tuple and overriding the twelfth element with the value returned by applying the given function to this tuple's twelfth element.
     */
    @Override
    public <X extends Z> Tuple<Z> twelfth(Function<L, X> function) {
        return change(0, function.apply(twelfth()));
    }

    /**
     * Returns a new tuple of one size smaller by keeping all the values from this tuple except the twelfth element.
     */
    @Override
    public Tuple<Z> dropTwelfth() {
        return dropAtIndex(11);
    }

    @Override
    protected Tuple<Z> dropAtIndex(int index) {
        if (size() == 13) {
            switch (index) {
                case 0:
                    return new TwelveTuple<>(second(), third(), fourth(), fifth(), sixth(), seventh(), eighth(), ninth(), tenth(), eleventh(), twelfth(), get(12));
                case 1:
                    return new TwelveTuple<>(first(), third(), fourth(), fifth(), sixth(), seventh(), eighth(), ninth(), tenth(), eleventh(), twelfth(), get(12));
                case 2:
                    return new TwelveTuple<>(first(), second(), fourth(), fifth(), sixth(), seventh(), eighth(), ninth(), tenth(), eleventh(), twelfth(), get(12));
                case 3:
                    return new TwelveTuple<>(first(), second(), third(), fifth(), sixth(), seventh(), eighth(), ninth(), tenth(), eleventh(), twelfth(), get(12));
                case 4:
                    return new TwelveTuple<>(first(), second(), third(), fourth(), sixth(), seventh(), eighth(), ninth(), tenth(), eleventh(), twelfth(), get(12));
                case 5:
                    return new TwelveTuple<>(first(), second(), third(), fourth(), fifth(), seventh(), eighth(), ninth(), tenth(), eleventh(), twelfth(), get(12));
                case 6:
                    return new TwelveTuple<>(first(), second(), third(), fourth(), fifth(), sixth(), eighth(), ninth(), tenth(), eleventh(), twelfth(), get(12));
                case 7:
                    return new TwelveTuple<>(first(), second(), third(), fourth(), fifth(), sixth(), seventh(), ninth(), tenth(), eleventh(), twelfth(), get(12));
                case 8:
                    return new TwelveTuple<>(first(), second(), third(), fourth(), fifth(), sixth(), seventh(), eighth(), tenth(), eleventh(), twelfth(), get(12));
                case 9:
                    return new TwelveTuple<>(first(), second(), third(), fourth(), fifth(), sixth(), seventh(), eighth(), ninth(), eleventh(), twelfth(), get(12));
                case 10:
                    return new TwelveTuple<>(first(), second(), third(), fourth(), fifth(), sixth(), seventh(), eighth(), ninth(), tenth(), twelfth(), get(12));
                case 11:
                    return new TwelveTuple<>(first(), second(), third(), fourth(), fifth(), sixth(), seventh(), eighth(), ninth(), tenth(), eleventh(), get(12));
                case 12:
                    return new TwelveTuple<>(first(), second(), third(), fourth(), fifth(), sixth(), seventh(), eighth(), ninth(), tenth(), eleventh(), twelfth());
                default:
                    throw new IllegalStateException("Unexpected value: " + index);
            }
        } else {
            return new ThirteenOrMoreTuple<>(asList().without(index));
        }
    }

    /**
     * Extends the tuple to which this is applied by adding the provided value to the end.
     *
     * <p>This is especially useful in functional contexts. For instance:
     *
     * <pre>
     * thirteenOrMoreTupleStream = thirteenOrMoreTupleStream.map(ThirteenOrMoreTuple.extendWith(value));
     * </pre>
     *
     * @see #extend(Object)
     */
    public static <Z, A extends Z, B extends Z, C extends Z, D extends Z, E extends Z, F extends Z, G extends Z, H extends Z, I extends Z, J extends Z, K extends Z, L extends Z, X extends Z> Function<ThirteenOrMoreTuple<Z, A, B, C, D, E, F, G, H, I, J, K, L>, ThirteenOrMoreTuple<Z, A, B, C, D, E, F, G, H, I, J, K, L>> extendWith(X value) {
        return tuple -> tuple.extend(value);
    }

    /**
     * Extends the tuple to which this is applied by adding the value from the supplier to the end.
     *
     * <p>This is especially useful in functional contexts. For instance:
     *
     * <pre>
     * thirteenOrMoreTupleStream = thirteenOrMoreTupleStream.map(ThirteenOrMoreTuple.extendWith(supplier));
     * </pre>
     *
     * @see #extend(Object)
     */
    public static <Z, A extends Z, B extends Z, C extends Z, D extends Z, E extends Z, F extends Z, G extends Z, H extends Z, I extends Z, J extends Z, K extends Z, L extends Z, X extends Z> Function<ThirteenOrMoreTuple<Z, A, B, C, D, E, F, G, H, I, J, K, L>, ThirteenOrMoreTuple<Z, A, B, C, D, E, F, G, H, I, J, K, L>> extendWith(
            Supplier<X> supplier) {
        return tuple -> tuple.extend(supplier);
    }

    /**
     * Extends the tuple to which this is applied by adding the value from the function to the end.
     *
     * <p>This is especially useful in functional contexts. For instance:
     *
     * <pre>
     * thirteenOrMoreTupleStream = thirteenOrMoreTupleStream.map(ThirteenOrMoreTuple.extendWith(function));
     * </pre>
     *
     * @see #extend(Object)
     */
    public static <Z, A extends Z, B extends Z, C extends Z, D extends Z, E extends Z, F extends Z, G extends Z, H extends Z, I extends Z, J extends Z, K extends Z, L extends Z, X extends Z> Function<ThirteenOrMoreTuple<Z, A, B, C, D, E, F, G, H, I, J, K, L>, ThirteenOrMoreTuple<Z, A, B, C, D, E, F, G, H, I, J, K, L>> extendWith(
            Function<ThirteenOrMoreTuple<Z, A, B, C, D, E, F, G, H, I, J, K, L>, X> function) {
        return tuple -> tuple.extend(function);
    }

    /**
     * Creates a new instance of this class.
     */
    @SafeVarargs
    public static <Z, A extends Z, B extends Z, C extends Z, D extends Z, E extends Z, F extends Z, G extends Z, H extends Z, I extends Z, J extends Z, K extends Z, L extends Z> ThirteenOrMoreTuple<Z, A, B, C, D, E, F, G, H, I, J, K, L> of(A first, B second, C third, D fourth, E fifth, F sixth, G seventh, H eighth, I ninth, J tenth, K eleventh,
            L twelfth, Z thirteenth, Z... rest) {
        return new ThirteenOrMoreTuple<>(first, second, third, fourth, fifth, sixth, seventh, eighth, ninth, tenth, eleventh, twelfth, thirteenth, rest);
    }

}


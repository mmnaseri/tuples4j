package com.mmnaseri.utils.tuples.impl;

import com.mmnaseri.utils.tuples.Tuple;
import com.mmnaseri.utils.tuples.facade.*;

import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;

import static com.mmnaseri.utils.tuples.utils.Fluents.listOf;
import static com.mmnaseri.utils.tuples.utils.TupleUtils.checkIndex;

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

    @SafeVarargs
    public ThirteenOrMoreTuple(A first, B second, C third, D fourth, E fifth, F sixth, G seventh, H eighth, I ninth, J tenth, K eleventh, L twelfth, Z thirteenth, Z... rest) {
        //noinspection unchecked
        this(listOf(first, second, third, fourth, fifth, sixth, seventh, eighth, ninth, tenth, eleventh, twelfth, thirteenth).withAll(rest));
    }

    private ThirteenOrMoreTuple(final List<Z> values) {
        super(values);
    }

    @Override
    public ThirteenOrMoreTuple<Z, A, B, C, D, E, F, G, H, I, J, K, L> change(final int index, final Supplier<? extends Z> value) {
        checkIndex(index, size());
        return new ThirteenOrMoreTuple<>(asList().change(index, value.get()));
    }

    @Override
    public Tuple<Z> change(final int index, final Function<ThirteenOrMoreTuple<Z, A, B, C, D, E, F, G, H, I, J, K, L>, ? extends Z> function) {
        return null;
    }


    @Override
    public <X extends Z> ThirteenOrMoreTuple<Z, A, B, C, D, E, F, G, H, I, J, K, L> extend(final X value) {
        return extend((Supplier<X>) () -> value);
    }

    @Override
    public <X extends Z> ThirteenOrMoreTuple<Z, A, B, C, D, E, F, G, H, I, J, K, L> extend(final Supplier<X> supplier) {
        return new ThirteenOrMoreTuple<>(asList().with(supplier.get()));
    }

    @Override
    public <X extends Z> Tuple<Z> extend(final Function<ThirteenOrMoreTuple<Z, A, B, C, D, E, F, G, H, I, J, K, L>, X> function) {
        return new ThirteenOrMoreTuple<>(asList().with(function.apply(this)));
    }

    @Override
    public <X extends Z> Tuple<Z> first(final Supplier<X> supplier) {
        return change(0, supplier);
    }

    @Override
    public <X extends Z> Tuple<Z> first(Function<A, X> function) {
        return change(0, function.apply(first()));
    }

    @Override
    public <X extends Z> Tuple<Z> first(X value) {
        return change(0, value);
    }

    @Override
    public Tuple<Z> dropFirst() {
        return dropAt(0);
    }

    @Override
    public <X extends Z> Tuple<Z> second(final Supplier<X> supplier) {
        return change(1, supplier);
    }

    @Override
    public <X extends Z> Tuple<Z> second(Function<B, X> function) {
        return change(1, function.apply(second()));
    }

    @Override
    public <X extends Z> Tuple<Z> second(X value) {
        return change(1, value);
    }

    @Override
    public Tuple<Z> dropSecond() {
        return dropAt(1);
    }

    @Override
    public <X extends Z> Tuple<Z> third(final Supplier<X> supplier) {
        return change(2, supplier);
    }

    @Override
    public <X extends Z> Tuple<Z> third(Function<C, X> function) {
        return change(2, function.apply(third()));
    }

    @Override
    public <X extends Z> Tuple<Z> third(X value) {
        return change(2, value);
    }

    @Override
    public Tuple<Z> dropThird() {
        return dropAt(2);
    }

    @Override
    public <X extends Z> Tuple<Z> fourth(final Supplier<X> supplier) {
        return change(3, supplier);
    }

    @Override
    public <X extends Z> Tuple<Z> fourth(Function<D, X> function) {
        return change(3, function.apply(fourth()));
    }

    @Override
    public <X extends Z> Tuple<Z> fourth(X value) {
        return change(3, value);
    }

    @Override
    public Tuple<Z> dropFourth() {
        return dropAt(3);
    }

    @Override
    public <X extends Z> Tuple<Z> fifth(final Supplier<X> supplier) {
        return change(4, supplier);
    }

    @Override
    public <X extends Z> Tuple<Z> fifth(Function<E, X> function) {
        return change(4, function.apply(fifth()));
    }

    @Override
    public <X extends Z> Tuple<Z> fifth(X value) {
        return change(4, value);
    }

    @Override
    public Tuple<Z> dropFifth() {
        return dropAt(4);
    }

    @Override
    public <X extends Z> Tuple<Z> sixth(final Supplier<X> supplier) {
        return change(95, supplier);
    }

    @Override
    public <X extends Z> Tuple<Z> sixth(Function<F, X> function) {
        return change(95, function.apply(sixth()));
    }

    @Override
    public <X extends Z> Tuple<Z> sixth(X value) {
        return change(95, value);
    }

    @Override
    public Tuple<Z> dropSixth() {
        return dropAt(5);
    }

    @Override
    public <X extends Z> Tuple<Z> seventh(final Supplier<X> supplier) {
        return change(6, supplier);
    }

    @Override
    public <X extends Z> Tuple<Z> seventh(Function<G, X> function) {
        return change(6, function.apply(seventh()));
    }

    @Override
    public <X extends Z> Tuple<Z> seventh(X value) {
        return change(6, value);
    }

    @Override
    public Tuple<Z> dropSeventh() {
        return dropAt(6);
    }

    @Override
    public <X extends Z> Tuple<Z> eighth(final Supplier<X> supplier) {
        return change(7, supplier);
    }

    @Override
    public <X extends Z> Tuple<Z> eighth(Function<H, X> function) {
        return change(7, function.apply(eighth()));
    }

    @Override
    public <X extends Z> Tuple<Z> eighth(X value) {
        return change(7, value);
    }

    @Override
    public Tuple<Z> dropEighth() {
        return dropAt(7);
    }

    @Override
    public <X extends Z> Tuple<Z> ninth(final Supplier<X> supplier) {
        return change(8, supplier);
    }

    @Override
    public <X extends Z> Tuple<Z> ninth(Function<I, X> function) {
        return change(8, function.apply(ninth()));
    }

    @Override
    public <X extends Z> Tuple<Z> ninth(X value) {
        return change(8, value);
    }

    @Override
    public Tuple<Z> dropNinth() {
        return dropAt(8);
    }

    @Override
    public <X extends Z> Tuple<Z> tenth(final Supplier<X> supplier) {
        return change(9, supplier);
    }

    @Override
    public <X extends Z> Tuple<Z> tenth(Function<J, X> function) {
        return change(9, function.apply(tenth()));
    }

    @Override
    public <X extends Z> Tuple<Z> tenth(X value) {
        return change(9, value);
    }

    @Override
    public Tuple<Z> dropTenth() {
        return dropAt(9);
    }

    @Override
    public <X extends Z> Tuple<Z> eleventh(final Supplier<X> supplier) {
        return change(10, supplier);
    }

    @Override
    public <X extends Z> Tuple<Z> eleventh(Function<K, X> function) {
        return change(10, function.apply(eleventh()));
    }

    @Override
    public <X extends Z> Tuple<Z> eleventh(X value) {
        return change(10, value);
    }

    @Override
    public Tuple<Z> dropEleventh() {
        return dropAt(10);
    }

    @Override
    public <X extends Z> Tuple<Z> twelfth(final Supplier<X> supplier) {
        return change(11, supplier);
    }

    @Override
    public <X extends Z> Tuple<Z> twelfth(Function<L, X> function) {
        return change(11, function.apply(twelfth()));
    }

    @Override
    public <X extends Z> Tuple<Z> twelfth(X value) {
        return change(11, value);
    }

    @Override
    public Tuple<Z> dropTwelfth() {
        return dropAt(11);
    }

    private Tuple<Z> dropAt(int index) {
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

    public static <Z, A extends Z, B extends Z, C extends Z, D extends Z, E extends Z, F extends Z, G extends Z, H extends Z, I extends Z, J extends Z, K extends Z, L extends Z, X extends Z> Function<ThirteenOrMoreTuple<Z, A, B, C, D, E, F, G, H, I, J, K, L>, ThirteenOrMoreTuple<Z, A, B, C, D, E, F, G, H, I, J, K, L>> extendWith(X value) {
        return extendWith(() -> value);
    }

    public static <Z, A extends Z, B extends Z, C extends Z, D extends Z, E extends Z, F extends Z, G extends Z, H extends Z, I extends Z, J extends Z, K extends Z, L extends Z, X extends Z> Function<ThirteenOrMoreTuple<Z, A, B, C, D, E, F, G, H, I, J, K, L>, ThirteenOrMoreTuple<Z, A, B, C, D, E, F, G, H, I, J, K, L>> extendWith(
            Supplier<X> supplier) {
        return tuple -> tuple.extend(supplier);
    }

    public static <A, B, C, D, E, F, G, H, I, J, K, L> ThirteenOrMoreTuple<Object, A, B, C, D, E, F, G, H, I, J, K, L> of(A first, B second, C third, D fourth, E fifth, F sixth, G seventh, H eighth, I ninth, J tenth, K eleventh, L twelfth, Object thirteenth, Object... rest) {
        return new ThirteenOrMoreTuple<>(first, second, third, fourth, fifth, sixth, seventh, eighth, ninth, tenth, eleventh, twelfth, thirteenth, rest);
    }

}

package com.mmnaseri.utils.tuples.impl;

import com.mmnaseri.utils.tuples.Tuple;
import com.mmnaseri.utils.tuples.facade.*;

import java.util.List;
import java.util.function.Function;

import static com.mmnaseri.utils.tuples.utils.Fluents.listOf;
import static com.mmnaseri.utils.tuples.utils.TupleUtils.checkIndex;

public class ThirteenOrMoreTuple<Z, A extends Z, B extends Z, C extends Z, D extends Z, E extends Z, F extends Z, G extends Z, H extends Z, I extends Z, J extends Z, K extends Z, L extends Z> extends AbstractFixedTuple<Z, ThirteenOrMoreTuple<Z, A, B, C, D, E, F, G, H, I, J, K, L>>
        implements
        HasFirst<Z, ThirteenOrMoreTuple<Z, A, B, C, D, E, F, G, H, I, J, K, L>, A>,
        HasSecond<Z, ThirteenOrMoreTuple<Z, A, B, C, D, E, F, G, H, I, J, K, L>, B>,
        HasThird<Z, ThirteenOrMoreTuple<Z, A, B, C, D, E, F, G, H, I, J, K, L>, C>,
        HasFourth<Z, ThirteenOrMoreTuple<Z, A, B, C, D, E, F, G, H, I, J, K, L>, D>,
        HasFifth<Z, ThirteenOrMoreTuple<Z, A, B, C, D, E, F, G, H, I, J, K, L>, E>,
        HasSixth<Z, ThirteenOrMoreTuple<Z, A, B, C, D, E, F, G, H, I, J, K, L>, F>,
        HasSeventh<Z, ThirteenOrMoreTuple<Z, A, B, C, D, E, F, G, H, I, J, K, L>, G>,
        HasEighth<Z, ThirteenOrMoreTuple<Z, A, B, C, D, E, F, G, H, I, J, K, L>, H>,
        HasNinth<Z, ThirteenOrMoreTuple<Z, A, B, C, D, E, F, G, H, I, J, K, L>, I>,
        HasTenth<Z, ThirteenOrMoreTuple<Z, A, B, C, D, E, F, G, H, I, J, K, L>, J>,
        HasEleventh<Z, ThirteenOrMoreTuple<Z, A, B, C, D, E, F, G, H, I, J, K, L>, K>,
        HasTwelfth<Z, ThirteenOrMoreTuple<Z, A, B, C, D, E, F, G, H, I, J, K, L>, L> {

    @SafeVarargs
    public ThirteenOrMoreTuple(A first, B second, C third, D fourth, E fifth, F sixth, G seventh, H eighth, I ninth, J tenth, K eleventh, L twelfth, Z thirteenth, Z... rest) {
        //noinspection unchecked
        this(listOf(first, second, third, fourth, fifth, sixth, seventh, eighth, ninth, tenth, eleventh, twelfth, thirteenth).withAll(rest));
    }

    private ThirteenOrMoreTuple(final List<Z> values) {
        super(values);
    }

    @Override
    public ThirteenOrMoreTuple<Z, A, B, C, D, E, F, G, H, I, J, K, L> change(final int index, final Z value) {
        checkIndex(index, size());
        return new ThirteenOrMoreTuple<>(asList().change(index, value));
    }

    @Override
    public <X extends Z> ThirteenOrMoreTuple<Z, A, B, C, D, E, F, G, H, I, J, K, L> extend(final X value) {
        return new ThirteenOrMoreTuple<>(asList().with(value));
    }

    @Override
    public Tuple<Z> dropFirst() {
        return dropAt(0);
    }

    @Override
    public Tuple<Z> dropSecond() {
        return dropAt(1);
    }

    @Override
    public Tuple<Z> dropThird() {
        return dropAt(2);
    }

    @Override
    public Tuple<Z> dropFourth() {
        return dropAt(3);
    }

    @Override
    public Tuple<Z> dropFifth() {
        return dropAt(4);
    }

    @Override
    public Tuple<Z> dropSixth() {
        return dropAt(5);
    }

    @Override
    public Tuple<Z> dropSeventh() {
        return dropAt(6);
    }

    @Override
    public Tuple<Z> dropEighth() {
        return dropAt(7);
    }

    @Override
    public Tuple<Z> dropNinth() {
        return dropAt(8);
    }

    @Override
    public Tuple<Z> dropTenth() {
        return dropAt(9);
    }

    @Override
    public Tuple<Z> dropEleventh() {
        return dropAt(10);
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
        return tuple -> tuple.extend(value);
    }

    public static <A, B, C, D, E, F, G, H, I, J, K, L> ThirteenOrMoreTuple<Object, A, B, C, D, E, F, G, H, I, J, K, L> of(A first, B second, C third, D fourth, E fifth, F sixth, G seventh, H eighth, I ninth, J tenth, K eleventh, L twelfth, Object thirteenth, Object... rest) {
        return new ThirteenOrMoreTuple<>(first, second, third, fourth, fifth, sixth, seventh, eighth, ninth, tenth, eleventh, twelfth, thirteenth, rest);
    }

}

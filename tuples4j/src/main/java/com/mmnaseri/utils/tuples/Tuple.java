package com.mmnaseri.utils.tuples;

import com.mmnaseri.utils.tuples.facade.*;
import com.mmnaseri.utils.tuples.impl.*;
import com.mmnaseri.utils.tuples.utils.Fluents;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static com.mmnaseri.utils.tuples.utils.TupleUtils.checkSize;
import static java.util.stream.Collectors.toCollection;

public interface Tuple<Z> {

    int size();

    Z get(int i);

    Tuple<Z> change(int index, Z value);

    default Tuple<Z> clear() {
        return EmptyTuple.of();
    }

    Tuple<Z> drop(int index);

    default Stream<Z> stream() {
        return IntStream.range(0, size()).boxed().map(this::get);
    }

    default Fluents.FluentList<Z> asList() {
        return stream().collect(toCollection(Fluents.FluentList::new));
    }

    <X extends Z> Tuple<Z> extend(X value);

    default boolean check(int index, Predicate<Z> predicate) {
        return predicate.test(get(index));
    }

    default LabeledTuple<Z> withLabels(String... labels) {
        return withLabels(Arrays.asList(labels));
    }

    default LabeledTuple<Z> withLabels(List<String> labels) {
        return new DefaultLabeledTuple<>(this, labels);
    }

    default EmptyTuple<Z> asEmpty() {
        return EmptyTuple.of();
    }

    default OneTuple<Object, Z> asOne() {
        checkSize(size(), 1);
        return OneTuple.of(get(0));
    }

    default TwoTuple<Object, Z, Z> asTwo() {
        checkSize(size(), 2);
        return of(get(0), get(1));
    }

    default ThreeTuple<Object, Z, Z, Z> asThree() {
        checkSize(size(), 3);
        return of(get(0), get(1), get(2));
    }

    default FourTuple<Object, Z, Z, Z, Z> asFour() {
        checkSize(size(), 4);
        return of(get(0), get(1), get(2), get(3));
    }

    default FiveTuple<Object, Z, Z, Z, Z, Z> asFive() {
        checkSize(size(), 5);
        return of(get(0), get(1), get(2), get(3), get(4));
    }

    default SixTuple<Object, Z, Z, Z, Z, Z, Z> asSix() {
        checkSize(size(), 6);
        return of(get(0), get(1), get(2), get(3), get(4), get(5));
    }

    default SevenTuple<Object, Z, Z, Z, Z, Z, Z, Z> asSeven() {
        checkSize(size(), 7);
        return of(get(0), get(1), get(2), get(3), get(4), get(5), get(6));
    }

    default EightTuple<Object, Z, Z, Z, Z, Z, Z, Z, Z> asEight() {
        checkSize(size(), 8);
        return of(get(0), get(1), get(2), get(3), get(4), get(5), get(6), get(7));
    }

    default NineTuple<Object, Z, Z, Z, Z, Z, Z, Z, Z, Z> asNine() {
        checkSize(size(), 9);
        return of(get(0), get(1), get(2), get(3), get(4), get(5), get(6), get(7), get(8));
    }

    default TenTuple<Object, Z, Z, Z, Z, Z, Z, Z, Z, Z, Z> asTen() {
        checkSize(size(), 10);
        return of(get(0), get(1), get(2), get(3), get(4), get(5), get(6), get(7), get(8), get(9));
    }

    default ElevenTuple<Object, Z, Z, Z, Z, Z, Z, Z, Z, Z, Z, Z> asEleven() {
        checkSize(size(), 11);
        return of(get(0), get(1), get(2), get(3), get(4), get(5), get(6), get(7), get(8), get(9), get(10));
    }

    default TwelveTuple<Object, Z, Z, Z, Z, Z, Z, Z, Z, Z, Z, Z, Z> asTwelve() {
        checkSize(size(), 12);
        return of(get(0), get(1), get(2), get(3), get(4), get(5), get(6), get(7), get(8), get(9), get(10), get(11));
    }

    static <Z> Function<Tuple<Z>, LabeledTuple<Z>> labelWith(String... labels) {
        return labelWith(Arrays.asList(labels));
    }

    static <Z> Function<Tuple<Z>, LabeledTuple<Z>> labelWith(List<String> labels) {
        return zTuple -> zTuple.withLabels(labels);
    }

    static <Z> Tuple<Z> asTuple(List<? extends Z> values) {
        return new ImmutableTuple<>(values);
    }

    static <Z> Collector<Z, List<Z>, Tuple<Z>> toTuple() {
        return toTuple(ArrayList::new);
    }

    static <Z> Collector<Z, List<Z>, Tuple<Z>> toTuple(final Supplier<List<Z>> listSupplier) {
        return Collector.of(listSupplier, List::add, (left, right) -> {
            left.addAll(right);
            return left;
        }, ImmutableTuple::new);
    }

    static <Z> EmptyTuple<Z> empty() {
        return new EmptyTuple<>();
    }

    static <A> OneTuple<Object, A> one(A first) {
        return new OneTuple<>(first);
    }

    static <A, B> TwoTuple<Object, A, B> two(A first, B second) {
        return new TwoTuple<>(first, second);
    }

    static <A, B, C> ThreeTuple<Object, A, B, C> three(A first, B second, C third) {
        return new ThreeTuple<>(first, second, third);
    }

    static <A, B, C, D> FourTuple<Object, A, B, C, D> four(A first, B second, C third, D fourth) {
        return new FourTuple<>(first, second, third, fourth);
    }

    static <A, B, C, D, E> FiveTuple<Object, A, B, C, D, E> five(A first, B second, C third, D fourth, E fifth) {
        return new FiveTuple<>(first, second, third, fourth, fifth);
    }

    static <A, B, C, D, E, F> SixTuple<Object, A, B, C, D, E, F> six(A first, B second, C third, D fourth, E fifth, F sixth) {
        return new SixTuple<>(first, second, third, fourth, fifth, sixth);
    }

    static <A, B, C, D, E, F, G> SevenTuple<Object, A, B, C, D, E, F, G> seven(A first, B second, C third, D fourth, E fifth, F sixth, G seventh) {
        return new SevenTuple<>(first, second, third, fourth, fifth, sixth, seventh);
    }

    static <A, B, C, D, E, F, G, H> EightTuple<Object, A, B, C, D, E, F, G, H> eight(A first, B second, C third, D fourth, E fifth, F sixth, G seventh, H eighth) {
        return new EightTuple<>(first, second, third, fourth, fifth, sixth, seventh, eighth);
    }

    static <A, B, C, D, E, F, G, H, I> NineTuple<Object, A, B, C, D, E, F, G, H, I> nine(A first, B second, C third, D fourth, E fifth, F sixth, G seventh, H eighth, I ninth) {
        return new NineTuple<>(first, second, third, fourth, fifth, sixth, seventh, eighth, ninth);
    }

    static <A, B, C, D, E, F, G, H, I, J> TenTuple<Object, A, B, C, D, E, F, G, H, I, J> ten(A first, B second, C third, D fourth, E fifth, F sixth, G seventh, H eighth, I ninth, J tenth) {
        return new TenTuple<>(first, second, third, fourth, fifth, sixth, seventh, eighth, ninth, tenth);
    }

    static <A, B, C, D, E, F, G, H, I, J, K> ElevenTuple<Object, A, B, C, D, E, F, G, H, I, J, K> eleven(A first, B second, C third, D fourth, E fifth, F sixth, G seventh, H eighth, I ninth, J tenth, K eleventh) {
        return new ElevenTuple<>(first, second, third, fourth, fifth, sixth, seventh, eighth, ninth, tenth, eleventh);
    }

    static <A, B, C, D, E, F, G, H, I, J, K, L> TwelveTuple<Object, A, B, C, D, E, F, G, H, I, J, K, L> twelve(A first, B second, C third, D fourth, E fifth, F sixth, G seventh, H eighth, I ninth, J tenth, K eleventh, L twelfth) {
        return new TwelveTuple<>(first, second, third, fourth, fifth, sixth, seventh, eighth, ninth, tenth, eleventh, twelfth);
    }

    static <A, B, C, D, E, F, G, H, I, J, K, L> ThirteenOrMoreTuple<Object, A, B, C, D, E, F, G, H, I, J, K, L> large(A first, B second, C third, D fourth, E fifth, F sixth, G seventh, H eighth, I ninth, J tenth, K eleventh, L twelfth, Object thirteenth, Object... rest) {
        return new ThirteenOrMoreTuple<>(first, second, third, fourth, fifth, sixth, seventh, eighth, ninth, tenth, eleventh, twelfth, thirteenth, rest);
    }

    static <Z> EmptyTuple<Z> of() {
        return empty();
    }

    static <A> OneTuple<Object, A> of(A first) {
        return new OneTuple<>(first);
    }

    static <A, B> TwoTuple<Object, A, B> of(A first, B second) {
        return new TwoTuple<>(first, second);
    }

    static <A, B, C> ThreeTuple<Object, A, B, C> of(A first, B second, C third) {
        return new ThreeTuple<>(first, second, third);
    }

    static <A, B, C, D> FourTuple<Object, A, B, C, D> of(A first, B second, C third, D fourth) {
        return new FourTuple<>(first, second, third, fourth);
    }

    static <A, B, C, D, E> FiveTuple<Object, A, B, C, D, E> of(A first, B second, C third, D fourth, E fifth) {
        return new FiveTuple<>(first, second, third, fourth, fifth);
    }

    static <A, B, C, D, E, F> SixTuple<Object, A, B, C, D, E, F> of(A first, B second, C third, D fourth, E fifth, F sixth) {
        return new SixTuple<>(first, second, third, fourth, fifth, sixth);
    }

    static <A, B, C, D, E, F, G> SevenTuple<Object, A, B, C, D, E, F, G> of(A first, B second, C third, D fourth, E fifth, F sixth, G seventh) {
        return new SevenTuple<>(first, second, third, fourth, fifth, sixth, seventh);
    }

    static <A, B, C, D, E, F, G, H> EightTuple<Object, A, B, C, D, E, F, G, H> of(A first, B second, C third, D fourth, E fifth, F sixth, G seventh, H eighth) {
        return new EightTuple<>(first, second, third, fourth, fifth, sixth, seventh, eighth);
    }

    static <A, B, C, D, E, F, G, H, I> NineTuple<Object, A, B, C, D, E, F, G, H, I> of(A first, B second, C third, D fourth, E fifth, F sixth, G seventh, H eighth, I ninth) {
        return new NineTuple<>(first, second, third, fourth, fifth, sixth, seventh, eighth, ninth);
    }

    static <A, B, C, D, E, F, G, H, I, J> TenTuple<Object, A, B, C, D, E, F, G, H, I, J> of(A first, B second, C third, D fourth, E fifth, F sixth, G seventh, H eighth, I ninth, J tenth) {
        return new TenTuple<>(first, second, third, fourth, fifth, sixth, seventh, eighth, ninth, tenth);
    }

    static <A, B, C, D, E, F, G, H, I, J, K> ElevenTuple<Object, A, B, C, D, E, F, G, H, I, J, K> of(A first, B second, C third, D fourth, E fifth, F sixth, G seventh, H eighth, I ninth, J tenth, K eleventh) {
        return new ElevenTuple<>(first, second, third, fourth, fifth, sixth, seventh, eighth, ninth, tenth, eleventh);
    }

    static <A, B, C, D, E, F, G, H, I, J, K, L> TwelveTuple<Object, A, B, C, D, E, F, G, H, I, J, K, L> of(A first, B second, C third, D fourth, E fifth, F sixth, G seventh, H eighth, I ninth, J tenth, K eleventh, L twelfth) {
        return new TwelveTuple<>(first, second, third, fourth, fifth, sixth, seventh, eighth, ninth, tenth, eleventh, twelfth);
    }

    static <A, B, C, D, E, F, G, H, I, J, K, L> ThirteenOrMoreTuple<Object, A, B, C, D, E, F, G, H, I, J, K, L> of(A first, B second, C third, D fourth, E fifth, F sixth, G seventh, H eighth, I ninth, J tenth, K eleventh, L twelfth, Object thirteenth, Object... rest) {
        return new ThirteenOrMoreTuple<>(first, second, third, fourth, fifth, sixth, seventh, eighth, ninth, tenth, eleventh, twelfth, thirteenth, rest);
    }

    static <Z, X extends Z> Function<EmptyTuple<Z>, OneTuple<Z, X>> extendEmpty(X value) {
        return tuple -> tuple.extend(value);
    }

    static <Z, A extends Z, X extends Z> Function<OneTuple<Z, A>, TwoTuple<Z, A, X>> extendOne(X value) {
        return tuple -> tuple.extend(value);
    }

    static <Z, A extends Z, B extends Z, X extends Z> Function<TwoTuple<Z, A, B>, ThreeTuple<Z, A, B, X>> extendTwo(X value) {
        return tuple -> tuple.extend(value);
    }

    static <Z, A extends Z, B extends Z, C extends Z, X extends Z> Function<ThreeTuple<Z, A, B, C>, FourTuple<Z, A, B, C, X>> extendThree(X value) {
        return tuple -> tuple.extend(value);
    }

    static <Z, A extends Z, B extends Z, C extends Z, D extends Z, X extends Z> Function<FourTuple<Z, A, B, C, D>, FiveTuple<Z, A, B, C, D, X>> extendFour(X value) {
        return tuple -> tuple.extend(value);
    }

    static <Z, A extends Z, B extends Z, C extends Z, D extends Z, E extends Z, X extends Z> Function<FiveTuple<Z, A, B, C, D, E>, SixTuple<Z, A, B, C, D, E, X>> extendFive(X value) {
        return tuple -> tuple.extend(value);
    }

    static <Z, A extends Z, B extends Z, C extends Z, D extends Z, E extends Z, F extends Z, X extends Z> Function<SixTuple<Z, A, B, C, D, E, F>, SevenTuple<Z, A, B, C, D, E, F, X>> extendSix(X value) {
        return tuple -> tuple.extend(value);
    }

    static <Z, A extends Z, B extends Z, C extends Z, D extends Z, E extends Z, F extends Z, G extends Z, X extends Z> Function<SevenTuple<Z, A, B, C, D, E, F, G>, EightTuple<Z, A, B, C, D, E, F, G, X>> extendSeven(X value) {
        return tuple -> tuple.extend(value);
    }

    static <Z, A extends Z, B extends Z, C extends Z, D extends Z, E extends Z, F extends Z, G extends Z, H extends Z, X extends Z> Function<EightTuple<Z, A, B, C, D, E, F, G, H>, NineTuple<Z, A, B, C, D, E, F, G, H, X>> extendEight(X value) {
        return tuple -> tuple.extend(value);
    }

    static <Z, A extends Z, B extends Z, C extends Z, D extends Z, E extends Z, F extends Z, G extends Z, H extends Z, I extends Z, X extends Z> Function<NineTuple<Z, A, B, C, D, E, F, G, H, I>, TenTuple<Z, A, B, C, D, E, F, G, H, I, X>> extendNine(X value) {
        return tuple -> tuple.extend(value);
    }

    static <Z, A extends Z, B extends Z, C extends Z, D extends Z, E extends Z, F extends Z, G extends Z, H extends Z, I extends Z, J extends Z, X extends Z> Function<TenTuple<Z, A, B, C, D, E, F, G, H, I, J>, ElevenTuple<Z, A, B, C, D, E, F, G, H, I, J, X>> extendTen(X value) {
        return tuple -> tuple.extend(value);
    }

    static <Z, A extends Z, B extends Z, C extends Z, D extends Z, E extends Z, F extends Z, G extends Z, H extends Z, I extends Z, J extends Z, K extends Z, X extends Z> Function<ElevenTuple<Z, A, B, C, D, E, F, G, H, I, J, K>, TwelveTuple<Z, A, B, C, D, E, F, G, H, I, J, K, X>> extendEleven(X value) {
        return tuple -> tuple.extend(value);
    }

    static <Z, A extends Z, B extends Z, C extends Z, D extends Z, E extends Z, F extends Z, G extends Z, H extends Z, I extends Z, J extends Z, K extends Z, L extends Z, X extends Z> Function<TwelveTuple<Z, A, B, C, D, E, F, G, H, I, J, K, L>, ThirteenOrMoreTuple<Z, A, B, C, D, E, F, G, H, I, J, K, L>> extendTwelve(X value) {
        return tuple -> tuple.extend(value);
    }

    static <Z, A extends Z, B extends Z, C extends Z, D extends Z, E extends Z, F extends Z, G extends Z, H extends Z, I extends Z, J extends Z, K extends Z, L extends Z, X extends Z> Function<ThirteenOrMoreTuple<Z, A, B, C, D, E, F, G, H, I, J, K, L>, ThirteenOrMoreTuple<Z, A, B, C, D, E, F, G, H, I, J, K, L>> extendLarge(X value) {
        return tuple -> tuple.extend(value);
    }

    static <Z, T extends FixedTuple<Z, T>, A extends Z> Predicate<HasFirst<Z, T, A>> checkFirst(Predicate<A> predicate) {
        return tuple -> tuple.checkFirst(predicate);
    }

    static <Z, T extends FixedTuple<Z, T>, A extends Z> Predicate<HasSecond<Z, T, A>> checkSecond(Predicate<A> predicate) {
        return tuple -> tuple.checkSecond(predicate);
    }

    static <Z, T extends FixedTuple<Z, T>, A extends Z> Predicate<HasThird<Z, T, A>> checkThird(Predicate<A> predicate) {
        return tuple -> tuple.checkThird(predicate);
    }

    static <Z, T extends FixedTuple<Z, T>, A extends Z> Predicate<HasFourth<Z, T, A>> checkFourth(Predicate<A> predicate) {
        return tuple -> tuple.checkFourth(predicate);
    }

    static <Z, T extends FixedTuple<Z, T>, A extends Z> Predicate<HasFifth<Z, T, A>> checkFifth(Predicate<A> predicate) {
        return tuple -> tuple.checkFifth(predicate);
    }

    static <Z, T extends FixedTuple<Z, T>, A extends Z> Predicate<HasSixth<Z, T, A>> checkSixth(Predicate<A> predicate) {
        return tuple -> tuple.checkSixth(predicate);
    }

    static <Z, T extends FixedTuple<Z, T>, A extends Z> Predicate<HasSeventh<Z, T, A>> checkSeventh(Predicate<A> predicate) {
        return tuple -> tuple.checkSeventh(predicate);
    }

    static <Z, T extends FixedTuple<Z, T>, A extends Z> Predicate<HasEighth<Z, T, A>> checkEighth(Predicate<A> predicate) {
        return tuple -> tuple.checkEighth(predicate);
    }

    static <Z, T extends FixedTuple<Z, T>, A extends Z> Predicate<HasNinth<Z, T, A>> checkNinth(Predicate<A> predicate) {
        return tuple -> tuple.checkNinth(predicate);
    }

    static <Z, T extends FixedTuple<Z, T>, A extends Z> Predicate<HasTenth<Z, T, A>> checkTenth(Predicate<A> predicate) {
        return tuple -> tuple.checkTenth(predicate);
    }

    static <Z, T extends FixedTuple<Z, T>, A extends Z> Predicate<HasEleventh<Z, T, A>> checkEleventh(Predicate<A> predicate) {
        return tuple -> tuple.checkEleventh(predicate);
    }

    static <Z, T extends FixedTuple<Z, T>, A extends Z> Predicate<HasTwelfth<Z, T, A>> checkTwelfth(Predicate<A> predicate) {
        return tuple -> tuple.checkTwelfth(predicate);
    }

    static <Z> Predicate<Tuple<Z>> checkNth(int index, Predicate<Z> predicate) {
        return tuple -> tuple.check(index, predicate);
    }

    static <Z, T extends HasFirst<Z, T, A>, A extends Z> Function<T, T> mapFirst(A value) {
        return tuple -> tuple.first(value);
    }

    static <Z, T extends HasSecond<Z, T, A>, A extends Z> Function<T, T> mapSecond(A value) {
        return tuple -> tuple.second(value);
    }

    static <Z, T extends HasThird<Z, T, A>, A extends Z> Function<T, T> mapThird(A value) {
        return tuple -> tuple.third(value);
    }

    static <Z, T extends HasFourth<Z, T, A>, A extends Z> Function<T, T> mapFourth(A value) {
        return tuple -> tuple.fourth(value);
    }

    static <Z, T extends HasFifth<Z, T, A>, A extends Z> Function<T, T> mapFifth(A value) {
        return tuple -> tuple.fifth(value);
    }

    static <Z, T extends HasSixth<Z, T, A>, A extends Z> Function<T, T> mapSixth(A value) {
        return tuple -> tuple.sixth(value);
    }

    static <Z, T extends HasSeventh<Z, T, A>, A extends Z> Function<T, T> mapSeventh(A value) {
        return tuple -> tuple.seventh(value);
    }

    static <Z, T extends HasEighth<Z, T, A>, A extends Z> Function<T, T> mapEighth(A value) {
        return tuple -> tuple.eighth(value);
    }

    static <Z, T extends HasNinth<Z, T, A>, A extends Z> Function<T, T> mapNinth(A value) {
        return tuple -> tuple.ninth(value);
    }

    static <Z, T extends HasTenth<Z, T, A>, A extends Z> Function<T, T> mapTenth(A value) {
        return tuple -> tuple.tenth(value);
    }

    static <Z, T extends HasEleventh<Z, T, A>, A extends Z> Function<T, T> mapEleventh(A value) {
        return tuple -> tuple.eleventh(value);
    }

    static <Z, T extends HasTwelfth<Z, T, A>, A extends Z> Function<T, T> mapTwelfth(A value) {
        return tuple -> tuple.twelfth(value);
    }

    static <Z, T extends FixedTuple<Z, T>> Function<T, T> mapNth(int index, Z value) {
        return tuple -> tuple.change(index, value);
    }

}

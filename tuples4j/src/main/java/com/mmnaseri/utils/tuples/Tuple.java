package com.mmnaseri.utils.tuples;

import com.mmnaseri.utils.tuples.facade.*;
import com.mmnaseri.utils.tuples.impl.*;
import com.mmnaseri.utils.tuples.utils.Fluents;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static com.mmnaseri.utils.tuples.utils.TupleUtils.checkSize;
import static java.util.stream.Collectors.toCollection;

public interface Tuple<Z> {

    int size();

    Z get(int index);

    default Tuple<Z> change(int index, Z value) {
        return change(index, () -> value);
    }

    Tuple<Z> change(int index, Supplier<? extends Z> value);

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

    default <X extends Z> Tuple<Z> extend(X value) {
        return extend((Supplier<X>) () -> value);
    }

    <X extends Z> Tuple<Z> extend(Supplier<X> value);

    default boolean check(int index, Predicate<Z> predicate) {
        return predicate.test(get(index));
    }

    default LabeledTuple<Z> withLabels(String... labels) {
        return withLabels(Arrays.asList(labels));
    }

    default LabeledTuple<Z> withLabels(List<String> labels) {
        return new DefaultLabeledTuple<>(this, labels);
    }

    default EmptyTuple<Object> asEmpty() {
        checkSize(size(), 0);
        return of();
    }

    default OneTuple<Object, Z> asOne() {
        checkSize(size(), 1);
        return of(get(0));
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

    // Static utility and builder methods.

    static <Z> Function<Tuple<Z>, LabeledTuple<Z>> labelWith(String... labels) {
        return labelWith(Arrays.asList(labels));
    }

    static <Z> Function<Tuple<Z>, LabeledTuple<Z>> labelWith(List<String> labels) {
        return tuple -> tuple.withLabels(labels);
    }

    static EmptyTuple<Object> of() {
        return new EmptyTuple<>();
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

    static <A, B, C, D, E, F, G, H, I, J, K, L> EmptyTuple<Object> empty() {
        return of();
    }

    static <A, B, C, D, E, F, G, H, I, J, K, L> OneTuple<Object, A> one(A first) {
        return of(first);
    }

    static <A, B, C, D, E, F, G, H, I, J, K, L> TwoTuple<Object, A, B> two(A first, B second) {
        return of(first, second);
    }

    static <A, B, C, D, E, F, G, H, I, J, K, L> ThreeTuple<Object, A, B, C> three(A first, B second, C third) {
        return of(first, second, third);
    }

    static <A, B, C, D, E, F, G, H, I, J, K, L> FourTuple<Object, A, B, C, D> four(A first, B second, C third, D fourth) {
        return of(first, second, third, fourth);
    }

    static <A, B, C, D, E, F, G, H, I, J, K, L> FiveTuple<Object, A, B, C, D, E> five(A first, B second, C third, D fourth, E fifth) {
        return of(first, second, third, fourth, fifth);
    }

    static <A, B, C, D, E, F, G, H, I, J, K, L> SixTuple<Object, A, B, C, D, E, F> six(A first, B second, C third, D fourth, E fifth, F sixth) {
        return of(first, second, third, fourth, fifth, sixth);
    }

    static <A, B, C, D, E, F, G, H, I, J, K, L> SevenTuple<Object, A, B, C, D, E, F, G> seven(A first, B second, C third, D fourth, E fifth, F sixth, G seventh) {
        return of(first, second, third, fourth, fifth, sixth, seventh);
    }

    static <A, B, C, D, E, F, G, H, I, J, K, L> EightTuple<Object, A, B, C, D, E, F, G, H> eight(A first, B second, C third, D fourth, E fifth, F sixth, G seventh, H eighth) {
        return of(first, second, third, fourth, fifth, sixth, seventh, eighth);
    }

    static <A, B, C, D, E, F, G, H, I, J, K, L> NineTuple<Object, A, B, C, D, E, F, G, H, I> nine(A first, B second, C third, D fourth, E fifth, F sixth, G seventh, H eighth, I ninth) {
        return of(first, second, third, fourth, fifth, sixth, seventh, eighth, ninth);
    }

    static <A, B, C, D, E, F, G, H, I, J, K, L> TenTuple<Object, A, B, C, D, E, F, G, H, I, J> ten(A first, B second, C third, D fourth, E fifth, F sixth, G seventh, H eighth, I ninth, J tenth) {
        return of(first, second, third, fourth, fifth, sixth, seventh, eighth, ninth, tenth);
    }

    static <A, B, C, D, E, F, G, H, I, J, K, L> ElevenTuple<Object, A, B, C, D, E, F, G, H, I, J, K> eleven(A first, B second, C third, D fourth, E fifth, F sixth, G seventh, H eighth, I ninth, J tenth, K eleventh) {
        return of(first, second, third, fourth, fifth, sixth, seventh, eighth, ninth, tenth, eleventh);
    }

    static <A, B, C, D, E, F, G, H, I, J, K, L> TwelveTuple<Object, A, B, C, D, E, F, G, H, I, J, K, L> twelve(A first, B second, C third, D fourth, E fifth, F sixth, G seventh, H eighth, I ninth, J tenth, K eleventh, L twelfth) {
        return of(first, second, third, fourth, fifth, sixth, seventh, eighth, ninth, tenth, eleventh, twelfth);
    }

    static <A, B, C, D, E, F, G, H, I, J, K, L> ThirteenOrMoreTuple<Object, A, B, C, D, E, F, G, H, I, J, K, L> large(A first, B second, C third, D fourth, E fifth, F sixth, G seventh, H eighth, I ninth, J tenth, K eleventh, L twelfth, Object thirteenth, Object... rest) {
        return of(first, second, third, fourth, fifth, sixth, seventh, eighth, ninth, tenth, eleventh, twelfth, thirteenth, rest);
    }

    static <Z, X extends Z> Function<EmptyTuple<Z>, OneTuple<Z, X>> extendEmpty(X value) {
        return tuple -> tuple.extend(value);
    }

    static <Z, X extends Z> Function<EmptyTuple<Z>, OneTuple<Z, X>> extendEmpty(Supplier<X> supplier) {
        return tuple -> tuple.extend(supplier);
    }

    static <Z, X extends Z> Function<EmptyTuple<Z>, OneTuple<Z, X>> extendEmpty(Function<EmptyTuple<Z>, X> function) {
        return tuple -> tuple.extend(function);
    }

    static <Z, A extends Z, X extends Z> Function<OneTuple<Z, A>, TwoTuple<Z, A, X>> extendOne(X value) {
        return tuple -> tuple.extend(value);
    }

    static <Z, A extends Z, X extends Z> Function<OneTuple<Z, A>, TwoTuple<Z, A, X>> extendOne(Supplier<X> supplier) {
        return tuple -> tuple.extend(supplier);
    }

    static <Z, A extends Z, X extends Z> Function<OneTuple<Z, A>, TwoTuple<Z, A, X>> extendOne(Function<OneTuple<Z, A>, X> function) {
        return tuple -> tuple.extend(function);
    }

    static <Z, A extends Z, B extends Z, X extends Z> Function<TwoTuple<Z, A, B>, ThreeTuple<Z, A, B, X>> extendTwo(X value) {
        return tuple -> tuple.extend(value);
    }

    static <Z, A extends Z, B extends Z, X extends Z> Function<TwoTuple<Z, A, B>, ThreeTuple<Z, A, B, X>> extendTwo(Supplier<X> supplier) {
        return tuple -> tuple.extend(supplier);
    }

    static <Z, A extends Z, B extends Z, X extends Z> Function<TwoTuple<Z, A, B>, ThreeTuple<Z, A, B, X>> extendTwo(Function<TwoTuple<Z, A, B>, X> function) {
        return tuple -> tuple.extend(function);
    }

    static <Z, A extends Z, B extends Z, C extends Z, X extends Z> Function<ThreeTuple<Z, A, B, C>, FourTuple<Z, A, B, C, X>> extendThree(X value) {
        return tuple -> tuple.extend(value);
    }

    static <Z, A extends Z, B extends Z, C extends Z, X extends Z> Function<ThreeTuple<Z, A, B, C>, FourTuple<Z, A, B, C, X>> extendThree(Supplier<X> supplier) {
        return tuple -> tuple.extend(supplier);
    }

    static <Z, A extends Z, B extends Z, C extends Z, X extends Z> Function<ThreeTuple<Z, A, B, C>, FourTuple<Z, A, B, C, X>> extendThree(Function<ThreeTuple<Z, A, B, C>, X> function) {
        return tuple -> tuple.extend(function);
    }

    static <Z, A extends Z, B extends Z, C extends Z, D extends Z, X extends Z> Function<FourTuple<Z, A, B, C, D>, FiveTuple<Z, A, B, C, D, X>> extendFour(X value) {
        return tuple -> tuple.extend(value);
    }

    static <Z, A extends Z, B extends Z, C extends Z, D extends Z, X extends Z> Function<FourTuple<Z, A, B, C, D>, FiveTuple<Z, A, B, C, D, X>> extendFour(Supplier<X> supplier) {
        return tuple -> tuple.extend(supplier);
    }

    static <Z, A extends Z, B extends Z, C extends Z, D extends Z, X extends Z> Function<FourTuple<Z, A, B, C, D>, FiveTuple<Z, A, B, C, D, X>> extendFour(Function<FourTuple<Z, A, B, C, D>, X> function) {
        return tuple -> tuple.extend(function);
    }

    static <Z, A extends Z, B extends Z, C extends Z, D extends Z, E extends Z, X extends Z> Function<FiveTuple<Z, A, B, C, D, E>, SixTuple<Z, A, B, C, D, E, X>> extendFive(X value) {
        return tuple -> tuple.extend(value);
    }

    static <Z, A extends Z, B extends Z, C extends Z, D extends Z, E extends Z, X extends Z> Function<FiveTuple<Z, A, B, C, D, E>, SixTuple<Z, A, B, C, D, E, X>> extendFive(Supplier<X> supplier) {
        return tuple -> tuple.extend(supplier);
    }

    static <Z, A extends Z, B extends Z, C extends Z, D extends Z, E extends Z, X extends Z> Function<FiveTuple<Z, A, B, C, D, E>, SixTuple<Z, A, B, C, D, E, X>> extendFive(Function<FiveTuple<Z, A, B, C, D, E>, X> function) {
        return tuple -> tuple.extend(function);
    }

    static <Z, A extends Z, B extends Z, C extends Z, D extends Z, E extends Z, F extends Z, X extends Z> Function<SixTuple<Z, A, B, C, D, E, F>, SevenTuple<Z, A, B, C, D, E, F, X>> extendSix(X value) {
        return tuple -> tuple.extend(value);
    }

    static <Z, A extends Z, B extends Z, C extends Z, D extends Z, E extends Z, F extends Z, X extends Z> Function<SixTuple<Z, A, B, C, D, E, F>, SevenTuple<Z, A, B, C, D, E, F, X>> extendSix(Supplier<X> supplier) {
        return tuple -> tuple.extend(supplier);
    }

    static <Z, A extends Z, B extends Z, C extends Z, D extends Z, E extends Z, F extends Z, X extends Z> Function<SixTuple<Z, A, B, C, D, E, F>, SevenTuple<Z, A, B, C, D, E, F, X>> extendSix(Function<SixTuple<Z, A, B, C, D, E, F>, X> function) {
        return tuple -> tuple.extend(function);
    }

    static <Z, A extends Z, B extends Z, C extends Z, D extends Z, E extends Z, F extends Z, G extends Z, X extends Z> Function<SevenTuple<Z, A, B, C, D, E, F, G>, EightTuple<Z, A, B, C, D, E, F, G, X>> extendSeven(X value) {
        return tuple -> tuple.extend(value);
    }

    static <Z, A extends Z, B extends Z, C extends Z, D extends Z, E extends Z, F extends Z, G extends Z, X extends Z> Function<SevenTuple<Z, A, B, C, D, E, F, G>, EightTuple<Z, A, B, C, D, E, F, G, X>> extendSeven(Supplier<X> supplier) {
        return tuple -> tuple.extend(supplier);
    }

    static <Z, A extends Z, B extends Z, C extends Z, D extends Z, E extends Z, F extends Z, G extends Z, X extends Z> Function<SevenTuple<Z, A, B, C, D, E, F, G>, EightTuple<Z, A, B, C, D, E, F, G, X>> extendSeven(Function<SevenTuple<Z, A, B, C, D, E, F, G>, X> function) {
        return tuple -> tuple.extend(function);
    }

    static <Z, A extends Z, B extends Z, C extends Z, D extends Z, E extends Z, F extends Z, G extends Z, H extends Z, X extends Z> Function<EightTuple<Z, A, B, C, D, E, F, G, H>, NineTuple<Z, A, B, C, D, E, F, G, H, X>> extendEight(X value) {
        return tuple -> tuple.extend(value);
    }

    static <Z, A extends Z, B extends Z, C extends Z, D extends Z, E extends Z, F extends Z, G extends Z, H extends Z, X extends Z> Function<EightTuple<Z, A, B, C, D, E, F, G, H>, NineTuple<Z, A, B, C, D, E, F, G, H, X>> extendEight(Supplier<X> supplier) {
        return tuple -> tuple.extend(supplier);
    }

    static <Z, A extends Z, B extends Z, C extends Z, D extends Z, E extends Z, F extends Z, G extends Z, H extends Z, X extends Z> Function<EightTuple<Z, A, B, C, D, E, F, G, H>, NineTuple<Z, A, B, C, D, E, F, G, H, X>> extendEight(Function<EightTuple<Z, A, B, C, D, E, F, G, H>, X> function) {
        return tuple -> tuple.extend(function);
    }

    static <Z, A extends Z, B extends Z, C extends Z, D extends Z, E extends Z, F extends Z, G extends Z, H extends Z, I extends Z, X extends Z> Function<NineTuple<Z, A, B, C, D, E, F, G, H, I>, TenTuple<Z, A, B, C, D, E, F, G, H, I, X>> extendNine(X value) {
        return tuple -> tuple.extend(value);
    }

    static <Z, A extends Z, B extends Z, C extends Z, D extends Z, E extends Z, F extends Z, G extends Z, H extends Z, I extends Z, X extends Z> Function<NineTuple<Z, A, B, C, D, E, F, G, H, I>, TenTuple<Z, A, B, C, D, E, F, G, H, I, X>> extendNine(Supplier<X> supplier) {
        return tuple -> tuple.extend(supplier);
    }

    static <Z, A extends Z, B extends Z, C extends Z, D extends Z, E extends Z, F extends Z, G extends Z, H extends Z, I extends Z, X extends Z> Function<NineTuple<Z, A, B, C, D, E, F, G, H, I>, TenTuple<Z, A, B, C, D, E, F, G, H, I, X>> extendNine(Function<NineTuple<Z, A, B, C, D, E, F, G, H, I>, X> function) {
        return tuple -> tuple.extend(function);
    }

    static <Z, A extends Z, B extends Z, C extends Z, D extends Z, E extends Z, F extends Z, G extends Z, H extends Z, I extends Z, J extends Z, X extends Z> Function<TenTuple<Z, A, B, C, D, E, F, G, H, I, J>, ElevenTuple<Z, A, B, C, D, E, F, G, H, I, J, X>> extendTen(X value) {
        return tuple -> tuple.extend(value);
    }

    static <Z, A extends Z, B extends Z, C extends Z, D extends Z, E extends Z, F extends Z, G extends Z, H extends Z, I extends Z, J extends Z, X extends Z> Function<TenTuple<Z, A, B, C, D, E, F, G, H, I, J>, ElevenTuple<Z, A, B, C, D, E, F, G, H, I, J, X>> extendTen(Supplier<X> supplier) {
        return tuple -> tuple.extend(supplier);
    }

    static <Z, A extends Z, B extends Z, C extends Z, D extends Z, E extends Z, F extends Z, G extends Z, H extends Z, I extends Z, J extends Z, X extends Z> Function<TenTuple<Z, A, B, C, D, E, F, G, H, I, J>, ElevenTuple<Z, A, B, C, D, E, F, G, H, I, J, X>> extendTen(Function<TenTuple<Z, A, B, C, D, E, F, G, H, I, J>, X> function) {
        return tuple -> tuple.extend(function);
    }

    static <Z, A extends Z, B extends Z, C extends Z, D extends Z, E extends Z, F extends Z, G extends Z, H extends Z, I extends Z, J extends Z, K extends Z, X extends Z> Function<ElevenTuple<Z, A, B, C, D, E, F, G, H, I, J, K>, TwelveTuple<Z, A, B, C, D, E, F, G, H, I, J, K, X>> extendEleven(X value) {
        return tuple -> tuple.extend(value);
    }

    static <Z, A extends Z, B extends Z, C extends Z, D extends Z, E extends Z, F extends Z, G extends Z, H extends Z, I extends Z, J extends Z, K extends Z, X extends Z> Function<ElevenTuple<Z, A, B, C, D, E, F, G, H, I, J, K>, TwelveTuple<Z, A, B, C, D, E, F, G, H, I, J, K, X>> extendEleven(Supplier<X> supplier) {
        return tuple -> tuple.extend(supplier);
    }

    static <Z, A extends Z, B extends Z, C extends Z, D extends Z, E extends Z, F extends Z, G extends Z, H extends Z, I extends Z, J extends Z, K extends Z, X extends Z> Function<ElevenTuple<Z, A, B, C, D, E, F, G, H, I, J, K>, TwelveTuple<Z, A, B, C, D, E, F, G, H, I, J, K, X>> extendEleven(
            Function<ElevenTuple<Z, A, B, C, D, E, F, G, H, I, J, K>, X> function) {
        return tuple -> tuple.extend(function);
    }

    static <Z, A extends Z, B extends Z, C extends Z, D extends Z, E extends Z, F extends Z, G extends Z, H extends Z, I extends Z, J extends Z, K extends Z, L extends Z, X extends Z> Function<TwelveTuple<Z, A, B, C, D, E, F, G, H, I, J, K, L>, ThirteenOrMoreTuple<Z, A, B, C, D, E, F, G, H, I, J, K, L>> extendTwelve(X value) {
        return tuple -> tuple.extend(value);
    }

    static <Z, A extends Z, B extends Z, C extends Z, D extends Z, E extends Z, F extends Z, G extends Z, H extends Z, I extends Z, J extends Z, K extends Z, L extends Z, X extends Z> Function<TwelveTuple<Z, A, B, C, D, E, F, G, H, I, J, K, L>, ThirteenOrMoreTuple<Z, A, B, C, D, E, F, G, H, I, J, K, L>> extendTwelve(Supplier<X> supplier) {
        return tuple -> tuple.extend(supplier);
    }

    static <Z, A extends Z, B extends Z, C extends Z, D extends Z, E extends Z, F extends Z, G extends Z, H extends Z, I extends Z, J extends Z, K extends Z, L extends Z, X extends Z> Function<TwelveTuple<Z, A, B, C, D, E, F, G, H, I, J, K, L>, ThirteenOrMoreTuple<Z, A, B, C, D, E, F, G, H, I, J, K, L>> extendTwelve(
            Function<TwelveTuple<Z, A, B, C, D, E, F, G, H, I, J, K, L>, X> function) {
        return tuple -> tuple.extend(function);
    }

    static <Z, A extends Z, B extends Z, C extends Z, D extends Z, E extends Z, F extends Z, G extends Z, H extends Z, I extends Z, J extends Z, K extends Z, L extends Z, X extends Z> Function<ThirteenOrMoreTuple<Z, A, B, C, D, E, F, G, H, I, J, K, L>, ThirteenOrMoreTuple<Z, A, B, C, D, E, F, G, H, I, J, K, L>> extendLarge(X value) {
        return tuple -> tuple.extend(value);
    }

    static <Z, A extends Z, B extends Z, C extends Z, D extends Z, E extends Z, F extends Z, G extends Z, H extends Z, I extends Z, J extends Z, K extends Z, L extends Z, X extends Z> Function<ThirteenOrMoreTuple<Z, A, B, C, D, E, F, G, H, I, J, K, L>, ThirteenOrMoreTuple<Z, A, B, C, D, E, F, G, H, I, J, K, L>> extendLarge(Supplier<X> supplier) {
        return tuple -> tuple.extend(supplier);
    }

    static <Z, A extends Z, B extends Z, C extends Z, D extends Z, E extends Z, F extends Z, G extends Z, H extends Z, I extends Z, J extends Z, K extends Z, L extends Z, X extends Z> Function<ThirteenOrMoreTuple<Z, A, B, C, D, E, F, G, H, I, J, K, L>, ThirteenOrMoreTuple<Z, A, B, C, D, E, F, G, H, I, J, K, L>> extendLarge(
            Function<ThirteenOrMoreTuple<Z, A, B, C, D, E, F, G, H, I, J, K, L>, X> function) {
        return tuple -> tuple.extend(function);
    }

    @SuppressWarnings("unchecked")
    static <Z, A extends Z, X extends Z, T extends HasFirst<Z, A, T>, U extends HasFirst<Z, X, U>> Function<T, U> mapFirst(X value) {
        return tuple -> (U) tuple.first(value);
    }

    @SuppressWarnings("unchecked")
    static <Z, A extends Z, X extends Z, T extends HasFirst<Z, A, T>, U extends HasFirst<Z, X, U>> Function<T, U> mapFirst(Supplier<X> supplier) {
        return tuple -> (U) tuple.first(supplier);
    }

    @SuppressWarnings("unchecked")
    static <Z, A extends Z, X extends Z, T extends HasFirst<Z, A, T>, U extends HasFirst<Z, X, U>> Function<T, U> mapFirst(Function<A, X> function) {
        return tuple -> (U) tuple.first(function);
    }

    @SuppressWarnings("unchecked")
    static <Z, A extends Z, X extends Z, T extends HasSecond<Z, A, T>, U extends HasSecond<Z, X, U>> Function<T, U> mapSecond(X value) {
        return tuple -> (U) tuple.second(value);
    }

    @SuppressWarnings("unchecked")
    static <Z, A extends Z, X extends Z, T extends HasSecond<Z, A, T>, U extends HasSecond<Z, X, U>> Function<T, U> mapSecond(Supplier<X> supplier) {
        return tuple -> (U) tuple.second(supplier);
    }

    @SuppressWarnings("unchecked")
    static <Z, A extends Z, X extends Z, T extends HasSecond<Z, A, T>, U extends HasSecond<Z, X, U>> Function<T, U> mapSecond(Function<A, X> function) {
        return tuple -> (U) tuple.second(function);
    }

    @SuppressWarnings("unchecked")
    static <Z, A extends Z, X extends Z, T extends HasThird<Z, A, T>, U extends HasThird<Z, X, U>> Function<T, U> mapThird(X value) {
        return tuple -> (U) tuple.third(value);
    }

    @SuppressWarnings("unchecked")
    static <Z, A extends Z, X extends Z, T extends HasThird<Z, A, T>, U extends HasThird<Z, X, U>> Function<T, U> mapThird(Supplier<X> supplier) {
        return tuple -> (U) tuple.third(supplier);
    }

    @SuppressWarnings("unchecked")
    static <Z, A extends Z, X extends Z, T extends HasThird<Z, A, T>, U extends HasThird<Z, X, U>> Function<T, U> mapThird(Function<A, X> function) {
        return tuple -> (U) tuple.third(function);
    }

    @SuppressWarnings("unchecked")
    static <Z, A extends Z, X extends Z, T extends HasFourth<Z, A, T>, U extends HasFourth<Z, X, U>> Function<T, U> mapFourth(X value) {
        return tuple -> (U) tuple.fourth(value);
    }

    @SuppressWarnings("unchecked")
    static <Z, A extends Z, X extends Z, T extends HasFourth<Z, A, T>, U extends HasFourth<Z, X, U>> Function<T, U> mapFourth(Supplier<X> supplier) {
        return tuple -> (U) tuple.fourth(supplier);
    }

    @SuppressWarnings("unchecked")
    static <Z, A extends Z, X extends Z, T extends HasFourth<Z, A, T>, U extends HasFourth<Z, X, U>> Function<T, U> mapFourth(Function<A, X> function) {
        return tuple -> (U) tuple.fourth(function);
    }

    @SuppressWarnings("unchecked")
    static <Z, A extends Z, X extends Z, T extends HasFifth<Z, A, T>, U extends HasFifth<Z, X, U>> Function<T, U> mapFifth(X value) {
        return tuple -> (U) tuple.fifth(value);
    }

    @SuppressWarnings("unchecked")
    static <Z, A extends Z, X extends Z, T extends HasFifth<Z, A, T>, U extends HasFifth<Z, X, U>> Function<T, U> mapFifth(Supplier<X> supplier) {
        return tuple -> (U) tuple.fifth(supplier);
    }

    @SuppressWarnings("unchecked")
    static <Z, A extends Z, X extends Z, T extends HasFifth<Z, A, T>, U extends HasFifth<Z, X, U>> Function<T, U> mapFifth(Function<A, X> function) {
        return tuple -> (U) tuple.fifth(function);
    }

    @SuppressWarnings("unchecked")
    static <Z, A extends Z, X extends Z, T extends HasSixth<Z, A, T>, U extends HasSixth<Z, X, U>> Function<T, U> mapSixth(X value) {
        return tuple -> (U) tuple.sixth(value);
    }

    @SuppressWarnings("unchecked")
    static <Z, A extends Z, X extends Z, T extends HasSixth<Z, A, T>, U extends HasSixth<Z, X, U>> Function<T, U> mapSixth(Supplier<X> supplier) {
        return tuple -> (U) tuple.sixth(supplier);
    }

    @SuppressWarnings("unchecked")
    static <Z, A extends Z, X extends Z, T extends HasSixth<Z, A, T>, U extends HasSixth<Z, X, U>> Function<T, U> mapSixth(Function<A, X> function) {
        return tuple -> (U) tuple.sixth(function);
    }

    @SuppressWarnings("unchecked")
    static <Z, A extends Z, X extends Z, T extends HasSeventh<Z, A, T>, U extends HasSeventh<Z, X, U>> Function<T, U> mapSeventh(X value) {
        return tuple -> (U) tuple.seventh(value);
    }

    @SuppressWarnings("unchecked")
    static <Z, A extends Z, X extends Z, T extends HasSeventh<Z, A, T>, U extends HasSeventh<Z, X, U>> Function<T, U> mapSeventh(Supplier<X> supplier) {
        return tuple -> (U) tuple.seventh(supplier);
    }

    @SuppressWarnings("unchecked")
    static <Z, A extends Z, X extends Z, T extends HasSeventh<Z, A, T>, U extends HasSeventh<Z, X, U>> Function<T, U> mapSeventh(Function<A, X> function) {
        return tuple -> (U) tuple.seventh(function);
    }

    @SuppressWarnings("unchecked")
    static <Z, A extends Z, X extends Z, T extends HasEighth<Z, A, T>, U extends HasEighth<Z, X, U>> Function<T, U> mapEighth(X value) {
        return tuple -> (U) tuple.eighth(value);
    }

    @SuppressWarnings("unchecked")
    static <Z, A extends Z, X extends Z, T extends HasEighth<Z, A, T>, U extends HasEighth<Z, X, U>> Function<T, U> mapEighth(Supplier<X> supplier) {
        return tuple -> (U) tuple.eighth(supplier);
    }

    @SuppressWarnings("unchecked")
    static <Z, A extends Z, X extends Z, T extends HasEighth<Z, A, T>, U extends HasEighth<Z, X, U>> Function<T, U> mapEighth(Function<A, X> function) {
        return tuple -> (U) tuple.eighth(function);
    }

    @SuppressWarnings("unchecked")
    static <Z, A extends Z, X extends Z, T extends HasNinth<Z, A, T>, U extends HasNinth<Z, X, U>> Function<T, U> mapNinth(X value) {
        return tuple -> (U) tuple.ninth(value);
    }

    @SuppressWarnings("unchecked")
    static <Z, A extends Z, X extends Z, T extends HasNinth<Z, A, T>, U extends HasNinth<Z, X, U>> Function<T, U> mapNinth(Supplier<X> supplier) {
        return tuple -> (U) tuple.ninth(supplier);
    }

    @SuppressWarnings("unchecked")
    static <Z, A extends Z, X extends Z, T extends HasNinth<Z, A, T>, U extends HasNinth<Z, X, U>> Function<T, U> mapNinth(Function<A, X> function) {
        return tuple -> (U) tuple.ninth(function);
    }

    @SuppressWarnings("unchecked")
    static <Z, A extends Z, X extends Z, T extends HasTenth<Z, A, T>, U extends HasTenth<Z, X, U>> Function<T, U> mapTenth(X value) {
        return tuple -> (U) tuple.tenth(value);
    }

    @SuppressWarnings("unchecked")
    static <Z, A extends Z, X extends Z, T extends HasTenth<Z, A, T>, U extends HasTenth<Z, X, U>> Function<T, U> mapTenth(Supplier<X> supplier) {
        return tuple -> (U) tuple.tenth(supplier);
    }

    @SuppressWarnings("unchecked")
    static <Z, A extends Z, X extends Z, T extends HasTenth<Z, A, T>, U extends HasTenth<Z, X, U>> Function<T, U> mapTenth(Function<A, X> function) {
        return tuple -> (U) tuple.tenth(function);
    }

    @SuppressWarnings("unchecked")
    static <Z, A extends Z, X extends Z, T extends HasEleventh<Z, A, T>, U extends HasEleventh<Z, X, U>> Function<T, U> mapEleventh(X value) {
        return tuple -> (U) tuple.eleventh(value);
    }

    @SuppressWarnings("unchecked")
    static <Z, A extends Z, X extends Z, T extends HasEleventh<Z, A, T>, U extends HasEleventh<Z, X, U>> Function<T, U> mapEleventh(Supplier<X> supplier) {
        return tuple -> (U) tuple.eleventh(supplier);
    }

    @SuppressWarnings("unchecked")
    static <Z, A extends Z, X extends Z, T extends HasEleventh<Z, A, T>, U extends HasEleventh<Z, X, U>> Function<T, U> mapEleventh(Function<A, X> function) {
        return tuple -> (U) tuple.eleventh(function);
    }

    @SuppressWarnings("unchecked")
    static <Z, A extends Z, X extends Z, T extends HasTwelfth<Z, A, T>, U extends HasTwelfth<Z, X, U>> Function<T, U> mapTwelfth(X value) {
        return tuple -> (U) tuple.twelfth(value);
    }

    @SuppressWarnings("unchecked")
    static <Z, A extends Z, X extends Z, T extends HasTwelfth<Z, A, T>, U extends HasTwelfth<Z, X, U>> Function<T, U> mapTwelfth(Supplier<X> supplier) {
        return tuple -> (U) tuple.twelfth(supplier);
    }

    @SuppressWarnings("unchecked")
    static <Z, A extends Z, X extends Z, T extends HasTwelfth<Z, A, T>, U extends HasTwelfth<Z, X, U>> Function<T, U> mapTwelfth(Function<A, X> function) {
        return tuple -> (U) tuple.twelfth(function);
    }

    static <Z, A extends Z> Function<Tuple<Z>, Tuple<Z>> mapNth(int index, A value) {
        return tuple -> tuple.change(index, value);
    }

    static <Z, A extends Z> Function<Tuple<Z>, Tuple<Z>> mapNth(int index, Supplier<A> supplier) {
        return tuple -> tuple.change(index, supplier);
    }

    static <Z, T extends HasFirst<Z, A, T>, A extends Z> Predicate<HasFirst<Z, A, T>> checkFirst(Predicate<A> predicate) {
        return tuple -> tuple.checkFirst(predicate);
    }

    static <Z, T extends HasSecond<Z, A, T>, A extends Z> Predicate<HasSecond<Z, A, T>> checkSecond(Predicate<A> predicate) {
        return tuple -> tuple.checkSecond(predicate);
    }

    static <Z, T extends HasThird<Z, A, T>, A extends Z> Predicate<HasThird<Z, A, T>> checkThird(Predicate<A> predicate) {
        return tuple -> tuple.checkThird(predicate);
    }

    static <Z, T extends HasFourth<Z, A, T>, A extends Z> Predicate<HasFourth<Z, A, T>> checkFourth(Predicate<A> predicate) {
        return tuple -> tuple.checkFourth(predicate);
    }

    static <Z, T extends HasFifth<Z, A, T>, A extends Z> Predicate<HasFifth<Z, A, T>> checkFifth(Predicate<A> predicate) {
        return tuple -> tuple.checkFifth(predicate);
    }

    static <Z, T extends HasSixth<Z, A, T>, A extends Z> Predicate<HasSixth<Z, A, T>> checkSixth(Predicate<A> predicate) {
        return tuple -> tuple.checkSixth(predicate);
    }

    static <Z, T extends HasSeventh<Z, A, T>, A extends Z> Predicate<HasSeventh<Z, A, T>> checkSeventh(Predicate<A> predicate) {
        return tuple -> tuple.checkSeventh(predicate);
    }

    static <Z, T extends HasEighth<Z, A, T>, A extends Z> Predicate<HasEighth<Z, A, T>> checkEighth(Predicate<A> predicate) {
        return tuple -> tuple.checkEighth(predicate);
    }

    static <Z, T extends HasNinth<Z, A, T>, A extends Z> Predicate<HasNinth<Z, A, T>> checkNinth(Predicate<A> predicate) {
        return tuple -> tuple.checkNinth(predicate);
    }

    static <Z, T extends HasTenth<Z, A, T>, A extends Z> Predicate<HasTenth<Z, A, T>> checkTenth(Predicate<A> predicate) {
        return tuple -> tuple.checkTenth(predicate);
    }

    static <Z, T extends HasEleventh<Z, A, T>, A extends Z> Predicate<HasEleventh<Z, A, T>> checkEleventh(Predicate<A> predicate) {
        return tuple -> tuple.checkEleventh(predicate);
    }

    static <Z, T extends HasTwelfth<Z, A, T>, A extends Z> Predicate<HasTwelfth<Z, A, T>> checkTwelfth(Predicate<A> predicate) {
        return tuple -> tuple.checkTwelfth(predicate);
    }

    static <Z> Predicate<Tuple<Z>> checkNth(int index, Predicate<Z> predicate) {
        return tuple -> tuple.check(index, predicate);
    }

}

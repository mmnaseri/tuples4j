package com.mmnaseri.utils.tuples;

import com.mmnaseri.utils.tuples.impl.*;

import java.util.function.Function;

public final class Tuples {

    private Tuples() {
        throw new IllegalStateException("This class should not be instantiated.");
    }

    public static <K, V> KeyValue<K, V> keyValue(K key, V value) {
        return new KeyValue<>(key, value);
    }

    public static <A, B> Pair<A, B> pair(A first, B second) {
        return new Pair<>(first, second);
    }

    public static <Z> EmptyTuple<Z> tuple() {
        return new EmptyTuple<>();
    }

    public static <A> OneTuple<Object, A> tuple(A first) {
        return new OneTuple<>(first);
    }

    public static <A, B> TwoTuple<Object, A, B> tuple(A first, B second) {
        return new TwoTuple<>(first, second);
    }

    public static <A, B, C> ThreeTuple<Object, A, B, C> tuple(A first,
            B second, C third) {
        return new ThreeTuple<>(first, second, third);
    }

    public static <A, B, C, D>
    FourTuple<Object, A, B, C, D> tuple(A first, B second, C third, D fourth) {
        return new FourTuple<>(first, second, third, fourth);
    }

    public static <A, B, C, D, E> FiveTuple<Object, A, B, C, D, E> tuple(
            A first, B second, C third, D fourth, E fifth) {
        return new FiveTuple<>(first, second, third, fourth, fifth);
    }

    public static <A, B, C, D, E,
                          F> SixTuple<Object, A, B, C, D, E, F> tuple(
            A first, B second, C third, D fourth, E fifth, F sixth) {
        return new SixTuple<>(first, second, third, fourth, fifth, sixth);
    }

    public static <A, B, C, D, E,
                          F, G> SevenTuple<Object, A, B, C, D, E, F, G> tuple(
            A first, B second, C third, D fourth, E fifth, F sixth, G seventh) {
        return new SevenTuple<>(first, second, third, fourth, fifth, sixth, seventh);
    }

    public static <A, B, C, D, E,
                          F, G,
                          H> EightTuple<Object, A, B, C, D, E, F, G, H> tuple(
            A first, B second, C third, D fourth, E fifth, F sixth, G seventh, H eighth) {
        return new EightTuple<>(first, second, third, fourth, fifth, sixth, seventh, eighth);
    }

    public static <A, B, C, D, E,
                          F, G,
                          H, I> NineTuple<Object, A, B, C, D, E, F, G, H, I> tuple(
            A first, B second, C third, D fourth, E fifth, F sixth, G seventh, H eighth, I ninth) {
        return new NineTuple<>(first, second, third, fourth, fifth, sixth, seventh, eighth, ninth);
    }

    public static <A, B, C, D, E,
                          F, G,
                          H, I, J> TenTuple<Object, A, B, C, D, E, F, G, H, I, J> tuple(
            A first, B second, C third, D fourth, E fifth, F sixth, G seventh, H eighth, I ninth,
            J tenth) {
        return new TenTuple<>(first, second, third, fourth, fifth, sixth, seventh, eighth, ninth,
                              tenth);
    }

    public static <A, B, C, D, E,
                          F, G,
                          H, I, J, K>
    ElevenTuple<Object, A, B, C, D, E, F, G, H, I, J, K> tuple(
            A first, B second, C third, D fourth, E fifth, F sixth, G seventh, H eighth, I ninth,
            J tenth, K eleventh) {
        return new ElevenTuple<>(first, second, third, fourth, fifth, sixth, seventh, eighth, ninth,
                                 tenth, eleventh);
    }

    public static <A, B, C, D, E,
                          F, G,
                          H, I, J, K, L> TwelveTuple<Object, A, B, C, D, E, F, G, H, I, J, K, L> tuple(
            A first, B second, C third, D fourth, E fifth, F sixth, G seventh, H eighth, I ninth,
            J tenth, K eleventh,
            L twelfth) {
        return new TwelveTuple<>(first, second, third, fourth, fifth, sixth, seventh, eighth, ninth,
                                 tenth, eleventh,
                                 twelfth);
    }

    public static <A, B, C, D, E,
                          F, G,
                          H, I, J, K, L> ThirteenOrMoreTuple<Object, A, B, C, D, E, F, G, H, I, J, K, L> tuple(
            A first, B second, C third, D fourth, E fifth, F sixth, G seventh, H eighth, I ninth,
            J tenth, K eleventh,
            L twelfth, Object thirteenth, Object... rest) {
        return new ThirteenOrMoreTuple<>(first, second, third, fourth, fifth, sixth, seventh,
                                         eighth, ninth, tenth,
                                         eleventh, twelfth, thirteenth, rest);
    }

    public static <Z, X extends Z> Function<EmptyTuple<Z>, OneTuple<Z, X>> extendEmpty(X value) {
        return tuple -> tuple.extend(value);
    }

    public static <Z, A extends Z, X extends Z> Function<OneTuple<Z, A>, TwoTuple<Z, A, X>> extendOne(
            X value) {
        return tuple -> tuple.extend(value);
    }

    public static <Z, A extends Z, B extends Z, X extends Z>
    Function<TwoTuple<Z, A, B>, ThreeTuple<Z, A, B, X>> extendTwo(X value) {
        return tuple -> tuple.extend(value);
    }

    public static <Z, A extends Z, B extends Z, C extends Z, X extends Z>
    Function<ThreeTuple<Z, A, B, C>, FourTuple<Z, A, B, C, X>> extendThree(X value) {
        return tuple -> tuple.extend(value);
    }

    public static <Z, A extends Z, B extends Z, C extends Z, D extends Z, X extends Z>
    Function<FourTuple<Z, A, B, C, D>, FiveTuple<Z, A, B, C, D, X>> extendFour(X value) {
        return tuple -> tuple.extend(value);
    }

    public static <Z, A extends Z, B extends Z, C extends Z, D extends Z, E extends Z, X extends Z>
    Function<FiveTuple<Z, A, B, C, D, E>, SixTuple<Z, A, B, C, D, E, X>> extendFive(X value) {
        return tuple -> tuple.extend(value);
    }

    public static <Z, A extends Z, B extends Z, C extends Z, D extends Z, E extends Z,
                          F extends Z, X extends Z>
    Function<SixTuple<Z, A, B, C, D, E, F>, SevenTuple<Z, A, B, C, D, E, F, X>> extendSix(
            X value) {
        return tuple -> tuple.extend(value);
    }

    public static <Z, A extends Z, B extends Z, C extends Z, D extends Z, E extends Z,
                          F extends Z, G extends Z, X extends Z>
    Function<SevenTuple<Z, A, B, C, D, E, F, G>, EightTuple<Z, A, B, C, D, E, F, G, X>> extendSeven(
            X value) {
        return tuple -> tuple.extend(value);
    }

    public static <Z, A extends Z, B extends Z, C extends Z, D extends Z, E extends Z,
                          F extends Z, G extends Z
                          , H extends Z, X extends Z>
    Function<EightTuple<Z, A, B, C, D, E, F, G, H>, NineTuple<Z, A, B, C, D, E, F, G, H, X>> extendEight(
            X value) {
        return tuple -> tuple.extend(value);
    }

    public static <Z, A extends Z, B extends Z, C extends Z, D extends Z, E extends Z,
                          F extends Z, G extends Z
                          , H extends Z, I extends Z, X extends Z>
    Function<NineTuple<Z, A, B, C, D, E, F, G, H, I>, TenTuple<Z, A, B, C, D, E, F, G, H, I, X>> extendNine(
            X value) {
        return tuple -> tuple.extend(value);
    }

    public static <Z, A extends Z, B extends Z, C extends Z, D extends Z, E extends Z,
                          F extends Z, G extends Z
                          , H extends Z, I extends Z, J extends Z, X extends Z>
    Function<TenTuple<Z, A, B, C, D, E, F, G, H, I, J>, ElevenTuple<Z, A, B, C, D, E, F, G, H, I, J, X>>
    extendTen(X value) {
        return tuple -> tuple.extend(value);
    }

    public static <Z, A extends Z, B extends Z, C extends Z, D extends Z, E extends Z, F extends Z, G extends Z
                          , H extends Z, I extends Z, J extends Z, K extends Z, X extends Z>
    Function<ElevenTuple<Z, A, B, C, D, E, F, G, H, I, J, K>, TwelveTuple<Z, A, B, C, D, E, F, G, H, I, J, K, X>>
    extendEleven(X value) {
        return tuple -> tuple.extend(value);
    }

    public static <Z, A extends Z, B extends Z, C extends Z, D extends Z, E extends Z, F extends Z, G extends Z
                          , H extends Z, I extends Z, J extends Z, K extends Z, L extends Z, X extends Z>
    Function<TwelveTuple<Z, A, B, C, D, E, F, G, H, I, J, K, L>,
                    ThirteenOrMoreTuple<Z, A, B, C, D, E, F, G, H, I, J, K, L>>
    extendTwelve(X value) {
        return tuple -> tuple.extend(value);
    }

    public static <Z, A extends Z, B extends Z, C extends Z, D extends Z, E extends Z, F extends Z,
                          G extends Z, H extends Z, I extends Z, J extends Z, K extends Z,
                          L extends Z, X extends Z>
    Function<ThirteenOrMoreTuple<Z, A, B, C, D, E, F, G, H, I, J, K, L>,
                    ThirteenOrMoreTuple<Z, A, B, C, D, E, F, G, H, I, J, K, L>>
    extendLarge(X value) {
        return tuple -> tuple.extend(value);
    }

}
package com.mmnaseri.utils.tuples;

import com.mmnaseri.utils.tuples.impl.*;

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
}
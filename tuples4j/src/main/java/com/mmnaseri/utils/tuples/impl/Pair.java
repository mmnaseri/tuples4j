package com.mmnaseri.utils.tuples.impl;

public class Pair<A, B> extends TwoTuple<Object, A, B> {

    public Pair(final A first, final B second) {
        super(first, second);
    }

    public static <A, B> Pair<A, B> of(A first, B second) {
        return new Pair<>(first, second);
    }

}

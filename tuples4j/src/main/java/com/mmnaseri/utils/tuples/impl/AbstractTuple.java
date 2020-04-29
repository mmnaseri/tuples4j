package com.mmnaseri.utils.tuples.impl;

import com.mmnaseri.utils.tuples.Tuple;

import java.util.Objects;

public abstract class AbstractTuple<Z> implements Tuple<Z> {

    @Override
    public String toString() {
        return asList().toString();
    }

    @Override
    public boolean equals(final Object obj) {
        return obj instanceof Tuple && Objects.equals(asList(), ((Tuple<?>) obj).asList());
    }

    @Override
    public int hashCode() {
        return asList().hashCode();
    }

}

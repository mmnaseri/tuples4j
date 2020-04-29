package com.mmnaseri.utils.tuples.impl;

import com.mmnaseri.utils.tuples.Tuple;
import com.mmnaseri.utils.tuples.utils.Fluents;

import java.util.List;
import java.util.Objects;

import static com.mmnaseri.utils.tuples.utils.TupleUtils.checkIndex;
import static java.util.stream.Collectors.joining;

public abstract class AbstractTuple<Z> implements Tuple<Z> {

    private static final String STRING_FORMAT = "<%s>";
    private final String string;
    private final int hashCode;
    private final Fluents.FluentList<Z> values;

    protected AbstractTuple(List<? extends Z> values) {
        this.values = Fluents.listOf(values);
        string = String.format(STRING_FORMAT, stream().map(Objects::toString).collect(joining(", ")));
        hashCode = Objects.hashCode(asList());
    }

    @Override
    public Fluents.FluentList<Z> asList() {
        return values;
    }

    @Override
    public int size() {
        return values.size();
    }

    @Override
    public Z get(final int i) {
        checkIndex(i, size());
        return values.get(i);
    }

    @Override
    public String toString() {
        return string;
    }

    @Override
    public boolean equals(final Object obj) {
        return obj instanceof Tuple && Objects.equals(asList(), ((Tuple<?>) obj).asList());
    }

    @Override
    public int hashCode() {
        return hashCode;
    }

}

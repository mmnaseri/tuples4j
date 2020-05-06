package com.mmnaseri.utils.tuples.impl;

import com.mmnaseri.utils.tuples.Tuple;
import com.mmnaseri.utils.tuples.utils.FluentList;

import java.util.List;
import java.util.Objects;

import static com.mmnaseri.utils.tuples.utils.TupleUtils.checkIndex;
import static java.util.stream.Collectors.joining;

/**
 * The base class for the tuples. This class caches the list value for the tuple and uses that to calculate the hash code and string representation of the tuple.
 */
public abstract class AbstractTuple<Z> implements Tuple<Z> {

    private static final String STRING_FORMAT = "<%s>";
    private final String string;
    private final int hashCode;
    private final FluentList<Z> values;

    protected AbstractTuple(List<? extends Z> values) {
        this.values = FluentList.of(values);
        string = String.format(STRING_FORMAT, stream().map(Objects::toString).collect(joining(", ")));
        hashCode = Objects.hashCode(asList());
    }

    @Override
    public FluentList<Z> asList() {
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

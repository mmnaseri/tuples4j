package com.mmnaseri.utils.tuples.impl;

import com.mmnaseri.utils.tuples.Tuple;
import com.mmnaseri.utils.tuples.utils.Fluents;

import java.util.Objects;

import static java.util.stream.Collectors.toList;

public abstract class AbstractTuple<Z> implements Tuple<Z> {

    private Fluents.FluentList<Z> list;

    @Override
    public Fluents.FluentList<Z> asList() {
        if (list == null) {
            list = new Fluents.FluentList<Z>().withAll(stream().collect(toList()));
        }
        return list;
    }

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

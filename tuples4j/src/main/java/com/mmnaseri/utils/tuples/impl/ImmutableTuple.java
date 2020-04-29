package com.mmnaseri.utils.tuples.impl;

import com.mmnaseri.utils.tuples.Tuple;

import java.util.Collections;
import java.util.List;

import static com.mmnaseri.utils.tuples.utils.TupleUtils.checkIndex;

public class ImmutableTuple<Z> extends AbstractTuple<Z> {

    private final List<Z> values;

    public ImmutableTuple() {
        this(Collections.emptyList());
    }

    public ImmutableTuple(final List<Z> values) {
        this.values = Collections.unmodifiableList(values);
    }

    @Override
    public int size() {
        return values.size();
    }

    @Override
    public Z get(final int i) {
        return values.get(i);
    }

    @Override
    public Tuple<Z> change(final int index, final Z value) {
        checkIndex(index, size());
        return new ImmutableTuple<>(asList().change(index, value));
    }

    @Override
    public Tuple<Z> clear() {
        return new ImmutableTuple<>(Collections.emptyList());
    }

    @Override
    public Tuple<Z> drop(final int index) {
        checkIndex(index, size());
        return new ImmutableTuple<>(asList().without(index));
    }

    @Override
    public <X extends Z> Tuple<Z> extend(final X value) {
        return new ImmutableTuple<>(asList().with(value));
    }

}

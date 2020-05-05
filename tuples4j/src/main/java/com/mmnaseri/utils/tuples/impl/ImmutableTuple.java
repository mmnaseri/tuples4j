package com.mmnaseri.utils.tuples.impl;

import com.mmnaseri.utils.tuples.Tuple;
import com.mmnaseri.utils.tuples.utils.Fluents;

import java.util.Collections;
import java.util.List;
import java.util.function.Supplier;

import static com.mmnaseri.utils.tuples.utils.TupleUtils.checkIndex;

public class ImmutableTuple<Z> extends AbstractTuple<Z> {

    public ImmutableTuple(final List<? extends Z> values) {
        super(values);
    }

    @Override
    public Tuple<Z> change(final int index, final Z value) {
        return change(index, () -> value);
    }

    @Override
    public Tuple<Z> change(final int index, final Supplier<? extends Z> value) {
        checkIndex(index, size());
        return new ImmutableTuple<>(asList().change(index, value.get()));
    }

    @Override
    public Tuple<Z> drop(final int index) {
        checkIndex(index, size());
        return new ImmutableTuple<>(asList().without(index));
    }

    @Override
    public <X extends Z> Tuple<Z> extend(final X value) {
        return new ImmutableTuple<>(Fluents.listOf(asList()).with(value));
    }

    @Override
    public <X extends Z> Tuple<Z> extend(final Supplier<X> value) {
        return null;
    }

}

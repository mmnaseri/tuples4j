package com.mmnaseri.utils.tuples.impl;

import com.mmnaseri.utils.tuples.LabeledTuple;
import com.mmnaseri.utils.tuples.Tuple;
import com.mmnaseri.utils.tuples.utils.Fluents;

import java.util.*;
import java.util.stream.IntStream;

import static com.mmnaseri.utils.tuples.utils.Fluents.mapOf;

public class DefaultLabeledTuple<Z> implements LabeledTuple<Z> {

    private final Tuple<Z> tuple;
    private final List<String> labels;
    private Fluents.FluentMap<String, Z> map;

    public DefaultLabeledTuple(final Tuple<Z> tuple, final List<String> labels) {
        this.tuple = Objects.requireNonNull(tuple);
        this.labels = Collections.unmodifiableList(Objects.requireNonNull(labels));
        if (labels.size() != size()) {
            throw new IllegalArgumentException("Expected " + size() + " labels, but received " + labels.size());
        }
    }

    @Override
    public String toString() {
        return asMap().toString();
    }

    @Override
    public int hashCode() {
        return asMap().hashCode();
    }

    @Override
    public boolean equals(final Object obj) {
        return obj instanceof LabeledTuple && Objects.equals(asMap(), ((LabeledTuple<?>) obj).asMap());
    }

    @Override
    public Fluents.FluentList<Z> asList() {
        return tuple.asList();
    }

    @Override
    public Fluents.FluentMap<String, Z> asMap() {
        if (map == null) {
            map = mapOf(IntStream.range(0, size())
                                 .boxed()
                                 .collect(HashMap::new, (map, index) -> map.put(label(index), get(index)), Map::putAll));
        }
        return map;
    }

    @Override
    public List<String> labels() {
        return labels;
    }

    @Override
    public int size() {
        return tuple.size();
    }

    @Override
    public Z get(final int i) {
        return tuple.get(i);
    }

    @Override
    public Tuple<Z> change(final int index, final Z value) {
        return tuple.change(index, value);
    }

    @Override
    public Tuple<Z> clear() {
        return tuple.clear();
    }

    @Override
    public Tuple<Z> drop(final int index) {
        return tuple.drop(index);
    }

    @Override
    public <X extends Z> Tuple<Z> extend(final X value) {
        return tuple.extend(value);
    }

}

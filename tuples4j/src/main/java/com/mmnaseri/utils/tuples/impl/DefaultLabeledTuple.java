package com.mmnaseri.utils.tuples.impl;

import com.mmnaseri.utils.tuples.LabeledTuple;
import com.mmnaseri.utils.tuples.Tuple;
import com.mmnaseri.utils.tuples.utils.Fluents;

import java.util.*;
import java.util.stream.IntStream;

import static com.mmnaseri.utils.tuples.utils.Fluents.listOf;
import static com.mmnaseri.utils.tuples.utils.Fluents.mapOf;

public class DefaultLabeledTuple<Z> implements LabeledTuple<Z> {

    private final Tuple<Z> tuple;
    private final List<String> labels;
    private final Fluents.FluentMap<String, Z> map;
    private final String string;
    private final int hashCode;

    public DefaultLabeledTuple(final Tuple<Z> tuple, final List<String> labels) {
        if (labels.size() != tuple.size()) {
            throw new IllegalArgumentException("Expected " + tuple.size() + " labels, but received " + labels.size());
        }
        if (labels.stream().distinct().count() != labels.size()) {
            throw new IllegalArgumentException("Provided set of labels contains duplicates: " + labels);
        }
        this.tuple = Objects.requireNonNull(tuple);
        this.labels = Collections.unmodifiableList(Objects.requireNonNull(labels));
        map = mapOf(IntStream.range(0, size())
                             .boxed()
                             .collect(HashMap::new, (map, index) -> map.put(label(index), get(index)), Map::putAll));
        string = map.toString();
        hashCode = map.hashCode();
    }

    @Override
    public String toString() {
        return string;
    }

    @Override
    public int hashCode() {
        return hashCode;
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
    public LabeledTuple<Z> change(final int index, final Z value) {
        return new DefaultLabeledTuple<>(tuple.change(index, value), labels);
    }

    @Override
    public LabeledTuple<Z> drop(final int index) {
        return new DefaultLabeledTuple<>(tuple.drop(index), listOf(labels).without(index));
    }

    @Override
    public LabeledTuple<Z> relabel(final int index, final String newLabel) {
        if (labels().contains(newLabel)) {
            throw new IllegalArgumentException("Label " + newLabel + " already exists on this tuple");
        }
        return new DefaultLabeledTuple<>(tuple, listOf(labels).change(index, newLabel));
    }

    @Override
    public <X extends Z> LabeledTuple<Z> extend(final X value) {
        return new DefaultLabeledTuple<>(tuple.extend(value), listOf(labels).with("l" + (labels.size() + 1)));
    }

}

package com.mmnaseri.utils.tuples;

import com.mmnaseri.utils.tuples.impl.DefaultLabeledTuple;
import com.mmnaseri.utils.tuples.utils.Fluents;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toCollection;

public interface Tuple<Z> {

    int size();

    Z get(int i);

    Tuple<Z> change(int index, Z value);

    Tuple<Z> clear();

    Tuple<Z> drop(int index);

    default Fluents.FluentList<Z> asList() {
        return IntStream.range(0, size()).boxed()
                        .map(this::get)
                        .collect(toCollection(Fluents.FluentList::new));
    }

    <X extends Z> Tuple<Z> extend(X value);

    default LabeledTuple<Z> withLabels(String... labels) {
        return withLabels(Arrays.asList(labels));
    }

    default LabeledTuple<Z> withLabels(List<String> labels) {
        return new DefaultLabeledTuple<>(this, labels);
    }

    static <Z> Function<Tuple<Z>, LabeledTuple<Z>> labelWith(String... labels) {
        return labelWith(Arrays.asList(labels));
    }

    static <Z> Function<Tuple<Z>, LabeledTuple<Z>> labelWith(List<String> labels) {
        return zTuple -> zTuple.withLabels(labels);
    }

}

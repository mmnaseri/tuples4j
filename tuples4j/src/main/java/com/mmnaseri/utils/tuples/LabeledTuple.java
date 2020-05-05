package com.mmnaseri.utils.tuples;

import com.mmnaseri.utils.tuples.impl.DefaultLabeledTuple;
import com.mmnaseri.utils.tuples.utils.Fluents;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;
import java.util.stream.IntStream;

import static com.mmnaseri.utils.tuples.utils.TupleUtils.checkIndex;

public interface LabeledTuple<Z> extends Tuple<Z> {

    List<String> labels();

    @Override
    default LabeledTuple<Z> clear() {
        return empty();
    }

    default String label(int index) {
        checkIndex(index, size());
        return labels().get(index);
    }

    default Z get(String label) {
        final int index = labels().indexOf(label);
        checkIndex(index, size());
        return get(index);
    }

    @Override
    default LabeledTuple<Z> change(int index, Z value) {
        return change(index, () -> value);
    }

    @Override
    LabeledTuple<Z> change(int index, Supplier<? extends Z> value);

    default LabeledTuple<Z> change(String label, Z value) {
        final int index = labels().indexOf(label);
        checkIndex(index, size());
        return change(index, value);
    }

    default Tuple<Z> drop(String label) {
        final int index = labels().indexOf(label);
        checkIndex(index, size());
        return drop(index);
    }

    @Override
    LabeledTuple<Z> drop(int index);

    LabeledTuple<Z> relabel(int index, String newLabel);

    default LabeledTuple<Z> relabel(String oldLabel, String newLabel) {
        final int index = labels().indexOf(oldLabel);
        checkIndex(index, size());
        return relabel(index, newLabel);
    }

    @Override
    <X extends Z> LabeledTuple<Z> extend(X value);

    default <X extends Z> LabeledTuple<Z> extend(X value, String label) {
        return extend(value).relabel(size(), label);
    }

    default Fluents.FluentMap<String, Z> asMap() {
        return IntStream.range(0, size())
                        .boxed()
                        .collect(Fluents.FluentMap::new, (map, index) -> map.put(label(index), get(index)), Map::putAll);
    }

    static <Z> LabeledTuple<Z> empty() {
        return new DefaultLabeledTuple<>(Tuple.empty(), Collections.emptyList());
    }

}

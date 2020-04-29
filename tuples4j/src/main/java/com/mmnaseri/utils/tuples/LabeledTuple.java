package com.mmnaseri.utils.tuples;

import com.mmnaseri.utils.tuples.utils.Fluents;

import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

import static com.mmnaseri.utils.tuples.utils.TupleUtils.checkIndex;

public interface LabeledTuple<Z> extends Tuple<Z> {

    List<String> labels();

    default String label(int index) {
        checkIndex(index, size());
        return labels().get(index);
    }

    default Z get(String label) {
        final int index = labels().indexOf(label);
        checkIndex(index, size());
        return get(index);
    }

    default Tuple<Z> change(String label, Z value) {
        final int index = labels().indexOf(label);
        checkIndex(index, size());
        return change(index, value);
    }

    default Tuple<Z> drop(String label) {
        final int index = labels().indexOf(label);
        checkIndex(index, size());
        return drop(index);
    }

    default Fluents.FluentMap<String, Z> asMap() {
        return IntStream.range(0, size())
                        .boxed()
                        .collect(Fluents.FluentMap::new, (map, index) -> map.put(label(index), get(index)), Map::putAll);
    }

}

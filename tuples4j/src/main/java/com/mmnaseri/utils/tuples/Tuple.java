package com.mmnaseri.utils.tuples;

import com.mmnaseri.utils.tuples.utils.Fluents;

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

}

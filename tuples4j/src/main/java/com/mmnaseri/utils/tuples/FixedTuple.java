package com.mmnaseri.utils.tuples;

import com.mmnaseri.utils.tuples.impl.EmptyTuple;

public interface FixedTuple<Z, T extends FixedTuple<Z, T>> extends Tuple<Z> {

    T change(int index, Z value);

    default EmptyTuple<Z> clear() {
        return new EmptyTuple<>();
    }

    <X extends Z> Tuple<Z> extend(X value);

}

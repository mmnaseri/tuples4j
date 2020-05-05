package com.mmnaseri.utils.tuples;

import com.mmnaseri.utils.tuples.impl.EmptyTuple;

import java.util.function.Function;

public interface FixedTuple<Z, T extends FixedTuple<Z, T>> extends Tuple<Z> {

    @Override
    default EmptyTuple<Z> clear() {
        return EmptyTuple.of();
    }

    <X extends Z> Tuple<Z> extend(Function<T, X> function);

    Tuple<Z> change(int index, Function<T, ? extends Z> function);
}

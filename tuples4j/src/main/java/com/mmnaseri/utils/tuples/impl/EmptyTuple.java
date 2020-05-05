package com.mmnaseri.utils.tuples.impl;

import java.util.function.Function;
import java.util.function.Supplier;

import static com.mmnaseri.utils.tuples.utils.TupleUtils.checkIndex;

/**
 * Class for dealing with a {@link com.mmnaseri.utils.tuples.FixedTuple} with empty elements.
 *
 * @author Milad Naseri (m.m.naseri@gmail.com)
 */
public class EmptyTuple<Z> extends AbstractFixedTuple<Z, EmptyTuple<Z>> {

    /**
     * Creates a new instance of this class from the provided values.
     */
    public EmptyTuple() {
        super();
    }

    /**
     * Returns a new tuple by keeping all the values from this tuple and overriding the value at the provided index with the value returned from the supplier.
     */
    @Override
    public EmptyTuple<Z> change(int index, Supplier<? extends Z> supplier) {
        checkIndex(index, size());
        return new EmptyTuple<>();
    }

    /**
     * Returns a new tuple by keeping all the values from this tuple and overriding the value at the provided index with the value returned from the function.
     */
    @Override
    public EmptyTuple<Z> change(int index, Function<EmptyTuple<Z>, ? extends Z> function) {
        checkIndex(index, size());
        return new EmptyTuple<>();
    }

    /**
     * Returns a new tuple of one size larger by adding the provided value to the end of this tuple.
     */
    @Override
    public <X extends Z> OneTuple<Z, X> extend(X value) {
        return new OneTuple<>(value);
    }

    /**
     * Returns a new tuple of one size larger by adding the value returned from the supplier to the end of this tuple.
     */
    @Override
    public <X extends Z> OneTuple<Z, X> extend(Supplier<X> supplier) {
        return new OneTuple<>(supplier.get());
    }

    /**
     * Returns a new tuple of one size larger by adding the value returned from the function to the end of this tuple.
     */
    @Override
    public <X extends Z> OneTuple<Z, X> extend(Function<EmptyTuple<Z>, X> function) {
        return new OneTuple<>(function.apply(this));
    }

    /**
     * Extends the tuple to which this is applied by adding the provided value to the end.
     *
     * <p>This is especially useful in functional contexts. For instance:
     *
     * <pre>
     * oneTupleStream = emptyTupleStream.map(EmptyTuple.extendWith(value));
     * </pre>
     *
     * @see #extend(Object)
     */
    public static <Z, X extends Z> Function<EmptyTuple<Z>, OneTuple<Z, X>> extendWith(X value) {
        return tuple -> tuple.extend(value);
    }

    /**
     * Extends the tuple to which this is applied by adding the value from the supplier to the end.
     *
     * <p>This is especially useful in functional contexts. For instance:
     *
     * <pre>
     * oneTupleStream = emptyTupleStream.map(EmptyTuple.extendWith(supplier));
     * </pre>
     *
     * @see #extend(Object)
     */
    public static <Z, X extends Z> Function<EmptyTuple<Z>, OneTuple<Z, X>> extendWith(Supplier<X> supplier) {
        return tuple -> tuple.extend(supplier);
    }

    /**
     * Extends the tuple to which this is applied by adding the value from the function to the end.
     *
     * <p>This is especially useful in functional contexts. For instance:
     *
     * <pre>
     * oneTupleStream = emptyTupleStream.map(EmptyTuple.extendWith(function));
     * </pre>
     *
     * @see #extend(Object)
     */
    public static <Z, X extends Z> Function<EmptyTuple<Z>, OneTuple<Z, X>> extendWith(Function<EmptyTuple<Z>, X> function) {
        return tuple -> tuple.extend(function);
    }

    /**
     * Creates a new instance of this class.
     */
    public static <Z> EmptyTuple<Z> of() {
        return new EmptyTuple<>();
    }

}


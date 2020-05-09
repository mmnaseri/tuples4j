package com.mmnaseri.utils.tuples;

import com.mmnaseri.utils.tuples.impl.DefaultLabeledTuple;
import com.mmnaseri.utils.tuples.utils.FluentMap;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;
import java.util.stream.IntStream;

import static com.mmnaseri.utils.tuples.utils.TupleUtils.checkIndex;

/**
 * Base interface for all tuples that have labels attached to each element.
 *
 * @author Milad Naseri (m.m.naseri@gmail.com)
 */
public interface LabeledTuple<Z> extends Tuple<Z> {

    /**
     * Returns the labels for the elements. This is guaranteed to have the same size as {@link #size()}.
     */
    List<String> labels();

    /**
     * Returns an empty labeled tuple.
     */
    @Override
    default LabeledTuple<Z> clear() {
        return new DefaultLabeledTuple<>(Tuple.empty().tighten());
    }

    /**
     * Returns the label of the element at the given index.
     */
    default String label(int index) {
        checkIndex(index, size());
        return labels().get(index);
    }

    /**
     * Returns the value of the element with the provided label.
     */
    default Z get(String label) {
        final int index = labels().indexOf(label);
        checkIndex(index, size(), label);
        return get(index);
    }

    /**
     * Changes the value of the element at the given index.
     */
    @Override
    default LabeledTuple<Z> change(int index, Z value) {
        return change(index, () -> value);
    }

    /**
     * Changes the value of the element at the given index.
     */
    @Override
    LabeledTuple<Z> change(int index, Supplier<? extends Z> value);

    /**
     * Changes the value of the element at the given label.
     */
    default LabeledTuple<Z> change(String label, Z value) {
        return change(label, () -> value);
    }

    /**
     * Changes the value of the element at the given label.
     */
    default LabeledTuple<Z> change(String label, Supplier<Z> value) {
        final int index = labels().indexOf(label);
        checkIndex(index, size(), label);
        return change(index, value);
    }

    /**
     * Drops the element with the provided label.
     */
    default LabeledTuple<Z> drop(String label) {
        final int index = labels().indexOf(label);
        checkIndex(index, size(), label);
        return drop(index);
    }

    @Override
    LabeledTuple<Z> drop(int index);

    /**
     * Returns a new tuple where the element at the given index has the new label.
     */
    LabeledTuple<Z> relabel(int index, String newLabel);

    /**
     * Returns a new tuple where the element with the provided label assumes the new label.
     */
    default LabeledTuple<Z> relabel(String oldLabel, String newLabel) {
        final int index = labels().indexOf(oldLabel);
        checkIndex(index, size(), oldLabel);
        return relabel(index, newLabel);
    }

    /**
     * Extends the tuple by adding the value and labelling it automatically. You can later relabel this by {@link #relabel(int, String)} or instead, you can guarantee a custom label by using {@link #extend(Object, String)}.
     */
    @Override
    <X extends Z> LabeledTuple<Z> extend(X value);

    /**
     * Extends the tuple by adding the value and labelling it automatically. You can later relabel this by {@link #relabel(int, String)} or instead, you can guarantee a custom label by using {@link #extend(Supplier, String)}.
     */
    @Override
    <X extends Z> LabeledTuple<Z> extend(Supplier<X> value);

    /**
     * Extends the tuple and labels the resulting element with the provided label.
     */
    default <X extends Z> LabeledTuple<Z> extend(X value, String label) {
        return extend(value).relabel(size(), label);
    }

    /**
     * Extends the tuple and labels the resulting element with the provided label.
     */
    default <X extends Z> LabeledTuple<Z> extend(Supplier<X> value, String label) {
        return extend(value).relabel(size(), label);
    }

    /**
     * Returns a map from the labels to the values of this tuple.
     */
    FluentMap<String, Z> asMap();

    @SuppressWarnings("unchecked")
    @Override
    default <X extends Z> LabeledTuple<X> tighten() {
        return (LabeledTuple<X>) this;
    }

    /**
     * Determines if the tuple has the given label.
     */
    default boolean has(String label) {
        return labels().contains(label);
    }

    /**
     * Returns an empty labeled tuple.
     */
    static LabeledTuple<Object> empty() {
        return new DefaultLabeledTuple<>(Tuple.empty(), Collections.emptyList());
    }

    /**
     * Creates a labeled tuple with one element.
     */
    static LabeledTuple<Object> of(String label, Object value) {
        return new DefaultLabeledTuple<>(Tuple.of(value), label);
    }

    /**
     * Creates a labeled tuple with two elements.
     */
    static LabeledTuple<Object> of(String label1, Object value1, String label2, Object value2) {
        return new DefaultLabeledTuple<>(Tuple.of(value1, value2), label1, label2);
    }

    /**
     * Creates a labeled tuple with three elements.
     */
    static LabeledTuple<Object> of(String label1, Object value1, String label2, Object value2, String label3, Object value3) {
        return new DefaultLabeledTuple<>(Tuple.of(value1, value2, value3), label1, label2, label3);
    }

}

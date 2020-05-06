package com.mmnaseri.utils.tuples.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

/**
 * A fluent list which can be modified using a builder-style API.
 *
 * @param <E>
 */
public class FluentList<E> extends ArrayList<E> {

    public FluentList() {
    }

    public FluentList(final Collection<? extends E> c) {
        super(c);
    }

    /**
     * Adds the given value to the current list.
     */
    public FluentList<E> with(E value) {
        FluentList<E> list = new FluentList<>(this);
        list.add(value);
        return list;
    }

    /**
     * Removes the given value from the current list.
     */
    public FluentList<E> without(E value) {
        FluentList<E> list = new FluentList<>(this);
        list.remove(value);
        return list;
    }

    /**
     * Removes the value at the given index from the current list.
     */
    public FluentList<E> without(int index) {
        FluentList<E> list = new FluentList<>(this);
        list.remove(index);
        return list;
    }

    /**
     * Adds all the provided items to this list.
     */
    @SafeVarargs
    public final FluentList<E> withAll(E... value) {
        return withAll(Arrays.asList(value));
    }

    /**
     * Adds all the provided items to this list.
     */
    public final FluentList<E> withAll(Collection<? extends E> values) {
        FluentList<E> list = new FluentList<>(this);
        list.addAll(values);
        return list;
    }

    /**
     * Changes the value of the item at the given index.
     */
    public FluentList<E> change(final int index, final E value) {
        FluentList<E> list = new FluentList<>(this);
        list.set(index, value);
        return list;
    }

    /**
     * Returns a fluent list from the provided objects.
     */
    @SuppressWarnings("unchecked")
    public static <E> FluentList<E> of(E... values) {
        return new FluentList<E>().withAll(values);
    }

    /**
     * Returns a fluent list from the provided objects.
     */
    public static <E> FluentList<E> of(Collection<? extends E> values) {
        return new FluentList<E>().withAll(values);
    }
}

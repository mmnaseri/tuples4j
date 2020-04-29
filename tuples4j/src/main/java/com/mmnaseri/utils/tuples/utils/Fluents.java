package com.mmnaseri.utils.tuples.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public final class Fluents {

    private Fluents() {
        throw new IllegalStateException("This class should not be instantiated.");
    }

    @SuppressWarnings("unchecked")
    public static <E> FluentList<E> listOf(E... values) {
        return new FluentList<E>().withAll(values);
    }

    public static class FluentList<E> extends ArrayList<E> {

        public FluentList<E> with(E value) {
            add(value);
            return this;
        }

        public FluentList<E> without(E value) {
            remove(value);
            return this;
        }

        public FluentList<E> without(int index) {
            remove(index);
            return this;
        }

        @SafeVarargs
        public final FluentList<E> withAll(E... value) {
            return withAll(Arrays.asList(value));
        }

        public final FluentList<E> withAll(Collection<? extends E> values) {
            addAll(values);
            return this;
        }

        public FluentList<E> change(final int index, final E value) {
            set(index, value);
            return this;
        }
    }

}

package com.mmnaseri.utils.tuples.utils;

import java.util.*;

public final class Fluents {

    private Fluents() {
        throw new IllegalStateException("This class should not be instantiated.");
    }

    @SuppressWarnings("unchecked")
    public static <E> FluentList<E> listOf(E... values) {
        return new FluentList<E>().withAll(values);
    }

    public static <E> FluentList<E> listOf(Collection<? extends E> values) {
        return new FluentList<E>().withAll(values);
    }

    public static <K, V> FluentMap<K, V> mapOf(Map<? extends K, ? extends V> map) {
        return new FluentMap<K, V>().withAll(map);
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

    public static class FluentMap<K, V> extends HashMap<K, V> {

        public FluentMap<K, V> with(K key, V value) {
            put(key, value);
            return this;
        }

        public FluentMap<K, V> withAll(Map<? extends K, ? extends V> values) {
            putAll(values);
            return this;
        }

        public FluentMap<K, V> without(K key) {
            remove(key);
            return this;
        }

        public FluentMap<K, V> without(K key, V value) {
            remove(key, value);
            return this;
        }

    }

}

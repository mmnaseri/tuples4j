package com.mmnaseri.utils.tuples.utils;

import java.util.*;

/**
 * Class for creating fluent collections and maps.
 */
public final class Fluents {

    private Fluents() {
        throw new IllegalStateException("This class should not be instantiated.");
    }

    /**
     * Returns a fluent list from the provided objects.
     */
    @SuppressWarnings("unchecked")
    public static <E> FluentList<E> listOf(E... values) {
        return new FluentList<E>().withAll(values);
    }

    /**
     * Returns a fluent list from the provided objects.
     */
    public static <E> FluentList<E> listOf(Collection<? extends E> values) {
        return new FluentList<E>().withAll(values);
    }

    /**
     * Returns a fluent map from the provided map.
     */
    public static <K, V> FluentMap<K, V> mapOf(Map<? extends K, ? extends V> map) {
        return new FluentMap<K, V>().withAll(map);
    }

    /**
     * A fluent list which can be modified using a builder-style API.
     *
     * @param <E>
     */
    public static class FluentList<E> extends ArrayList<E> {

        /**
         * Adds the given value to the current list.
         */
        public FluentList<E> with(E value) {
            add(value);
            return this;
        }

        /**
         * Removes the given value from the current list.
         */
        public FluentList<E> without(E value) {
            remove(value);
            return this;
        }

        /**
         * Removes the value at the given index from the current list.
         */
        public FluentList<E> without(int index) {
            remove(index);
            return this;
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
            addAll(values);
            return this;
        }

        /**
         * Changes the value of the item at the given index.
         */
        public FluentList<E> change(final int index, final E value) {
            set(index, value);
            return this;
        }
    }

    /**
     * A {@link HashMap} with a fluent, build-like API.
     */
    public static class FluentMap<K, V> extends HashMap<K, V> {

        /**
         * Adds the provided key and value to the current map.
         */
        public FluentMap<K, V> with(K key, V value) {
            put(key, value);
            return this;
        }

        /**
         * Adds all the items from the provided map to this map.
         */
        public FluentMap<K, V> withAll(Map<? extends K, ? extends V> values) {
            putAll(values);
            return this;
        }

        /**
         * Removes the item with the given key from this map.
         */
        public FluentMap<K, V> without(K key) {
            remove(key);
            return this;
        }

        /**
         * Removes the item with the given key and value from the map.
         */
        public FluentMap<K, V> without(K key, V value) {
            remove(key, value);
            return this;
        }

    }

}

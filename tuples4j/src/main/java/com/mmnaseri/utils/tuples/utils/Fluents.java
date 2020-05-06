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
    }

    /**
     * A {@link HashMap} with a fluent, build-like API.
     */
    public static class FluentMap<K, V> extends HashMap<K, V> {

        public FluentMap() {
        }

        public FluentMap(final Map<? extends K, ? extends V> m) {
            super(m);
        }

        /**
         * Adds the provided key and value to the current map.
         */
        public FluentMap<K, V> with(K key, V value) {
            FluentMap<K, V> map = new FluentMap<>(this);
            map.put(key, value);
            return map;
        }

        /**
         * Adds all the items from the provided map to this map.
         */
        public FluentMap<K, V> withAll(Map<? extends K, ? extends V> values) {
            FluentMap<K, V> map = new FluentMap<>(this);
            map.putAll(values);
            return map;
        }

        /**
         * Removes the item with the given key from this map.
         */
        public FluentMap<K, V> without(K key) {
            FluentMap<K, V> map = new FluentMap<>(this);
            map.remove(key);
            return map;
        }

        /**
         * Removes the item with the given key and value from the map.
         */
        public FluentMap<K, V> without(K key, V value) {
            FluentMap<K, V> map = new FluentMap<>(this);
            map.remove(key, value);
            return map;
        }

    }

}

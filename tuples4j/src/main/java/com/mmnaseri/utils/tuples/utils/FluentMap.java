package com.mmnaseri.utils.tuples.utils;

import java.util.HashMap;
import java.util.Map;

/**
 * A {@link HashMap} with a fluent, build-like API.
 */
public class FluentMap<K, V> extends HashMap<K, V> {

    public FluentMap(final Map<? extends K, ? extends V> m) {
        super(m);
    }

    public FluentMap() {
    }

    /**
     * Adds the provided key and value to the current map.
     */
    public FluentMap<K, V> with(K key, V value) {
        FluentMap<K, V> map = of(this);
        map.put(key, value);
        return map;
    }

    /**
     * Adds all the items from the provided map to this map.
     */
    public FluentMap<K, V> with(Map<? extends K, ? extends V> values) {
        FluentMap<K, V> map = of(this);
        map.putAll(values);
        return map;
    }

    /**
     * Removes the item with the given key from this map.
     */
    public FluentMap<K, V> without(K key) {
        FluentMap<K, V> map = of(this);
        map.remove(key);
        return map;
    }

    /**
     * Removes the item with the given key and value from the map.
     */
    public FluentMap<K, V> without(K key, V value) {
        FluentMap<K, V> map = of(this);
        map.remove(key, value);
        return map;
    }

    /**
     * Returns a fluent map from the provided map.
     */
    public static <K, V> FluentMap<K, V> of(Map<? extends K, ? extends V> map) {
        return new FluentMap<>(map);
    }

    /**
     * Returns a fluent map with the first item as given.
     */
    public static <K, V> FluentMap<K, V> of(K key, V value) {
        FluentMap<K, V> map = new FluentMap<>();
        map.put(key, value);
        return map;
    }
}

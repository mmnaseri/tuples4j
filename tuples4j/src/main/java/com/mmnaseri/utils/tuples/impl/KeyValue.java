package com.mmnaseri.utils.tuples.impl;

import java.util.Map;

/**
 * Represents a key-value pair of items. This is in essence just a {@link TwoTuple} with with some facade methods.
 *
 * @author Milad Naseri (m.m.naseri@gmail.com)
 */

public class KeyValue<K, V> extends TwoTuple<Object, K, V> {

    public KeyValue(final K key, final V value) {
        super(key, value);
    }

    /**
     * Returns the key (the first item in the pair).
     *
     * @see #first()
     */
    public K key() {
        return first();
    }

    /**
     * Returns the value (the second item in the pair).
     *
     * @see #second()
     */
    public V value() {
        return second();
    }

    /**
     * Creates a new {@link KeyValue} instance.
     */
    public static <K, V> KeyValue<K, V> create(K key, V value) {
        return new KeyValue<>(key, value);
    }

    /**
     * Creates a new {@link KeyValue} instance from the given map entry.
     *
     * <p>This can be used to create a stream of tuples from a map:</p>
     *
     * <pre>
     * map.entrySet().stream().map(KeyValue::create);
     * </pre>
     */
    public static <K, V> KeyValue<K, V> create(Map.Entry<K, V> entry) {
        return new KeyValue<>(entry.getKey(), entry.getValue());
    }

}

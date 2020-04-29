package com.mmnaseri.utils.tuples.impl;

public class KeyValue<K, V> extends TwoTuple<Object, K, V> {

    public KeyValue(final K key, final V value) {
        super(key, value);
    }

    public K key() {
        return first();
    }

    public V value() {
        return second();
    }

    public static <K, V> KeyValue<K, V> of(K key, V value) {
        return new KeyValue<>(key, value);
    }

}

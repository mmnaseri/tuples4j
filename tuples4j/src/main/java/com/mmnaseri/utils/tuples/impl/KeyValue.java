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

}

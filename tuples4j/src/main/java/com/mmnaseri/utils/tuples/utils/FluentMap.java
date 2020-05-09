package com.mmnaseri.utils.tuples.utils;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.function.Supplier;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.mapping;
import static java.util.stream.Collectors.toMap;
import static java.util.stream.Collectors.toSet;

/** A {@link HashMap} with a fluent, build-like API. */
public class FluentMap<K, V> extends HashMap<K, V> {

  public FluentMap(final Map<? extends K, ? extends V> m) {
    super(m);
  }

  public FluentMap() {}

  /** Adds the provided key and value to the current map. */
  public FluentMap<K, V> with(K key, V value) {
    FluentMap<K, V> map = of(this);
    map.put(key, value);
    return map;
  }

  /** Adds all the items from the provided map to this map. */
  public FluentMap<K, V> with(Map<? extends K, ? extends V> values) {
    FluentMap<K, V> map = of(this);
    map.putAll(values);
    return map;
  }

  /** Removes the item with the given key from this map. */
  public FluentMap<K, V> without(K key) {
    FluentMap<K, V> map = of(this);
    map.remove(key);
    return map;
  }

  /** Removes the item with the given key and value from the map. */
  public FluentMap<K, V> without(K key, V value) {
    FluentMap<K, V> map = of(this);
    map.remove(key, value);
    return map;
  }

  /** Returns a map that holds the reverse of this map. */
  public FluentMap<V, Set<K>> inverse() {
    return entrySet().stream()
        .collect(
            groupingBy(
                (Function<Entry<K, V>, V>) Entry::getValue,
                FluentMap::new,
                mapping((Function<Entry<K, V>, K>) Entry::getKey, toSet())));
  }

  /**
   * Returns a map that holds the reverse of this map. Unlike {@link #inverse()} this method is
   * lossy, meaning that any value which is pointed to by more than one key will only point back to
   * one of those keys.
   *
   * <p><strong>NB:</strong> In case of collision, handling is non-deterministic.
   */
  public FluentMap<V, K> inverseLossy() {
    return entrySet().stream()
        .collect(
            toMap(
                Entry::getValue,
                Entry::getKey,
                (a, b) -> b,
                (Supplier<FluentMap<V, K>>) FluentMap::new));
  }

  /** Returns a fluent map from the provided map. */
  public static <K, V> FluentMap<K, V> of(Map<? extends K, ? extends V> map) {
    return new FluentMap<>(map);
  }

  /** Returns a fluent map with the first item as given. */
  public static <K, V> FluentMap<K, V> of(K key, V value) {
    FluentMap<K, V> map = new FluentMap<>();
    map.put(key, value);
    return map;
  }
}

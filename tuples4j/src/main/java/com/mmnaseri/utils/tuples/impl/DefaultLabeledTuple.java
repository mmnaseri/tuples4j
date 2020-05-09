package com.mmnaseri.utils.tuples.impl;

import com.mmnaseri.utils.tuples.LabeledTuple;
import com.mmnaseri.utils.tuples.Tuple;
import com.mmnaseri.utils.tuples.utils.FluentList;
import com.mmnaseri.utils.tuples.utils.FluentMap;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Supplier;
import java.util.stream.IntStream;

/**
 * The default implementation for {@link LabeledTuple}.
 *
 * @author Milad Naseri (m.m.naseri@gmail.com)
 */
public class DefaultLabeledTuple<Z> implements LabeledTuple<Z> {

  private final Tuple<Z> tuple;
  private final List<String> labels;
  private final FluentMap<String, Z> map;
  private final String string;
  private final int hashCode;

  public DefaultLabeledTuple(final Tuple<Z> tuple, String... labels) {
    this(tuple, Arrays.asList(labels));
  }

  public DefaultLabeledTuple(final Tuple<Z> tuple, final List<String> labels) {
    if (labels.size() != tuple.size()) {
      throw new IllegalArgumentException(
          "Expected " + tuple.size() + " labels, but received " + labels.size());
    }
    if (labels.stream().distinct().count() != labels.size()) {
      throw new IllegalArgumentException("Provided set of labels contains duplicates: " + labels);
    }
    this.tuple = Objects.requireNonNull(tuple);
    this.labels = Collections.unmodifiableList(Objects.requireNonNull(labels));
    map =
        FluentMap.of(
            IntStream.range(0, size())
                .boxed()
                .collect(
                    HashMap::new, (map, index) -> map.put(label(index), get(index)), Map::putAll));
    string = map.toString();
    hashCode = map.hashCode();
  }

  @Override
  public String toString() {
    return string;
  }

  @Override
  public int hashCode() {
    return hashCode;
  }

  @Override
  public boolean equals(final Object obj) {
    return obj instanceof LabeledTuple && Objects.equals(asMap(), ((LabeledTuple<?>) obj).asMap());
  }

  @Override
  public FluentList<Z> asList() {
    return tuple.asList();
  }

  @Override
  public FluentMap<String, Z> asMap() {
    return map;
  }

  @Override
  public List<String> labels() {
    return labels;
  }

  @Override
  public int size() {
    return tuple.size();
  }

  @Override
  public Z get(final int i) {
    return tuple.get(i);
  }

  @Override
  public LabeledTuple<Z> change(final int index, final Supplier<? extends Z> value) {
    return new DefaultLabeledTuple<>(tuple.change(index, value), labels);
  }

  @Override
  public LabeledTuple<Z> drop(final int index) {
    return new DefaultLabeledTuple<>(tuple.drop(index), FluentList.of(labels).without(index));
  }

  @Override
  public LabeledTuple<Z> relabel(final int index, final String newLabel) {
    if (labels().contains(newLabel)) {
      throw new IllegalArgumentException("Label " + newLabel + " already exists on this tuple");
    }
    return new DefaultLabeledTuple<>(tuple, FluentList.of(labels).change(index, newLabel));
  }

  @Override
  public <X extends Z> LabeledTuple<Z> extend(final X value) {
    return extend((Supplier<X>) () -> value);
  }

  @Override
  public <X extends Z> LabeledTuple<Z> extend(final Supplier<X> value) {
    return new DefaultLabeledTuple<>(
        tuple.extend(value.get()), FluentList.of(labels).with("l" + (labels.size() + 1)));
  }
}

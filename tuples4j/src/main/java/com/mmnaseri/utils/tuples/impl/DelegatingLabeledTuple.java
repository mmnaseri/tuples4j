package com.mmnaseri.utils.tuples.impl;

import com.mmnaseri.utils.tuples.LabeledTuple;
import com.mmnaseri.utils.tuples.utils.FluentList;
import com.mmnaseri.utils.tuples.utils.FluentMap;

import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class DelegatingLabeledTuple<Z> implements LabeledTuple<Z> {

  private final LabeledTuple<Z> delegate;

  public DelegatingLabeledTuple(final LabeledTuple<Z> delegate) {
    this.delegate = delegate;
  }

  @Override
  public List<String> labels() {
    return delegate.labels();
  }

  @Override
  public int size() {
    return delegate.size();
  }

  @Override
  public Z get(final int index) {
    return delegate.get(index);
  }

  @Override
  public LabeledTuple<Z> change(final int index, final Supplier<? extends Z> value) {
    return delegate.change(index, value);
  }

  @Override
  public LabeledTuple<Z> drop(final int index) {
    return delegate.drop(index);
  }

  @Override
  public LabeledTuple<Z> relabel(final int index, final String newLabel) {
    return delegate.relabel(index, newLabel);
  }

  @Override
  public <X extends Z> LabeledTuple<Z> extend(final X value) {
    return delegate.extend(value);
  }

  @Override
  public <X extends Z> LabeledTuple<Z> extend(final Supplier<X> value) {
    return delegate.extend(value);
  }

  @Override
  public FluentMap<String, Z> asMap() {
    return delegate.asMap();
  }

  @Override
  public Stream<Z> stream() {
    return delegate.stream();
  }

  @Override
  public FluentList<Z> asList() {
    return delegate.asList();
  }
}

package com.mmnaseri.utils.tuples.impl;

import com.mmnaseri.utils.tuples.Tuple;
import com.mmnaseri.utils.tuples.utils.FluentList;

import java.util.function.Supplier;
import java.util.stream.Stream;

public class DelegatingTuple<Z> implements Tuple<Z> {

  private final Tuple<Z> delegate;

  public DelegatingTuple(Tuple<Z> delegate) {
    this.delegate = delegate;
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
  public Tuple<Z> change(final int index, final Supplier<? extends Z> value) {
    return delegate.change(index, value);
  }

  @Override
  public Tuple<Z> drop(final int index) {
    return delegate.drop(index);
  }

  @Override
  public <X extends Z> Tuple<Z> extend(final Supplier<X> value) {
    return delegate.extend(value);
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

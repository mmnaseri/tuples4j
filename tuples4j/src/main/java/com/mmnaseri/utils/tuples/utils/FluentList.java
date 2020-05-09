package com.mmnaseri.utils.tuples.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

/**
 * A fluent list which can be modified using a builder-style API.
 *
 * @param <E>
 */
public class FluentList<E> extends ArrayList<E> {

  public FluentList(final Collection<? extends E> c) {
    super(c);
  }

  public FluentList() {}

  /** Removes the given value from the current list. */
  public FluentList<E> without(E value) {
    FluentList<E> list = of(this);
    list.remove(value);
    return list;
  }

  /** Removes the value at the given index from the current list. */
  public FluentList<E> without(int index) {
    FluentList<E> list = of(this);
    list.remove(index);
    return list;
  }

  /** Adds the given value to the current list. */
  public FluentList<E> with(E value) {
    FluentList<E> list = of(this);
    list.add(value);
    return list;
  }

  /** Adds all the provided items to this list. */
  @SafeVarargs
  public final FluentList<E> with(E... value) {
    return with(Arrays.asList(value));
  }

  /** Adds all the provided items to this list. */
  public final FluentList<E> with(Collection<? extends E> values) {
    FluentList<E> list = of(this);
    list.addAll(values);
    return list;
  }

  /** Changes the value of the item at the given index. */
  public FluentList<E> change(final int index, final E value) {
    FluentList<E> list = of(this);
    list.set(index, value);
    return list;
  }

  /** Returns a fluent list from the provided objects. */
  @SuppressWarnings("unchecked")
  public static <E> FluentList<E> of(E... values) {
    return of(Arrays.asList(values));
  }

  /** Returns a fluent list from the provided objects. */
  public static <E> FluentList<E> of(Collection<? extends E> values) {
    return new FluentList<>(values);
  }

  /** Returns an empty fluent list. */
  public static <E> FluentList<E> empty() {
    return new FluentList<>();
  }
}

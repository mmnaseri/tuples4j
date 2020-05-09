package com.mmnaseri.utils.tuples.impl;

/**
 * Represents a pair of items. This is in essence just a {@link TwoTuple} with without any changes.
 *
 * @author Milad Naseri (m.m.naseri@gmail.com)
 */
public class Pair<A, B> extends TwoTuple<Object, A, B> {

  public Pair(final A first, final B second) {
    super(first, second);
  }

  /** Creates a new instance of {@link Pair}. */
  public static <A, B> Pair<A, B> create(A first, B second) {
    return new Pair<>(first, second);
  }
}

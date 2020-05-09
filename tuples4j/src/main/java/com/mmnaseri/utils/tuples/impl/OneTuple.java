package com.mmnaseri.utils.tuples.impl;

import com.mmnaseri.utils.tuples.facade.HasFirst;

import java.util.function.Function;
import java.util.function.Supplier;

import static com.mmnaseri.utils.tuples.utils.TupleUtils.checkIndex;

/**
 * Class for dealing with a {@link com.mmnaseri.utils.tuples.FixedTuple} with one elements.
 *
 * @author Milad Naseri (m.m.naseri@gmail.com)
 */
public class OneTuple<Z, A extends Z> extends AbstractFixedTuple<Z, OneTuple<Z, A>>
    implements HasFirst<Z, A, OneTuple<Z, A>> {

  /** Creates a new instance of this class from the provided values. */
  public OneTuple(A first) {
    super(first);
  }

  /**
   * Returns a new tuple by keeping all the values from this tuple and overriding the value at the
   * provided index with the value returned from the supplier.
   */
  @Override
  public OneTuple<Z, Z> change(int index, Supplier<? extends Z> supplier) {
    checkIndex(index, size());
    return new OneTuple<>(index == 0 ? supplier.get() : first());
  }

  /**
   * Returns a new tuple by keeping all the values from this tuple and overriding the value at the
   * provided index with the value returned from the function.
   */
  @Override
  public OneTuple<Z, Z> change(int index, Function<OneTuple<Z, A>, ? extends Z> function) {
    checkIndex(index, size());
    return new OneTuple<>(index == 0 ? function.apply(this) : first());
  }

  /**
   * Returns a new tuple of one size larger by adding the provided value to the end of this tuple.
   */
  @Override
  public <X extends Z> TwoTuple<Z, A, X> extend(X value) {
    return new TwoTuple<>(first(), value);
  }

  /**
   * Returns a new tuple of one size larger by adding the value returned from the supplier to the
   * end of this tuple.
   */
  @Override
  public <X extends Z> TwoTuple<Z, A, X> extend(Supplier<X> supplier) {
    return new TwoTuple<>(first(), supplier.get());
  }

  /**
   * Returns a new tuple of one size larger by adding the value returned from the function to the
   * end of this tuple.
   */
  @Override
  public <X extends Z> TwoTuple<Z, A, X> extend(Function<OneTuple<Z, A>, X> function) {
    return new TwoTuple<>(first(), function.apply(this));
  }

  /**
   * Returns a new tuple of the same size by keeping all the values from this tuple and overriding
   * the first element with the provided value.
   */
  @Override
  public <X extends Z> OneTuple<Z, X> first(X value) {
    return new OneTuple<>(value);
  }

  /**
   * Returns a new tuple of the same size by keeping all the values from this tuple and overriding
   * the first element with the value returned from the given supplier.
   */
  @Override
  public <X extends Z> OneTuple<Z, X> first(Supplier<X> supplier) {
    return new OneTuple<>(supplier.get());
  }

  /**
   * Returns a new tuple of the same size by keeping all the values from this tuple and overriding
   * the first element with the value returned by applying the given function to this tuple's first
   * element.
   */
  @Override
  public <X extends Z> OneTuple<Z, X> first(Function<A, X> function) {
    return new OneTuple<>(function.apply(first()));
  }

  /**
   * Returns a new tuple of one size smaller by keeping all the values from this tuple except the
   * first element.
   */
  @Override
  public EmptyTuple<Z> dropFirst() {
    return new EmptyTuple<>();
  }

  /**
   * Extends the tuple to which this is applied by adding the provided value to the end.
   *
   * <p>This is especially useful in functional contexts. For instance:
   *
   * <pre>
   * twoTupleStream = oneTupleStream.map(OneTuple.extendWith(value));
   * </pre>
   *
   * @see #extend(Object)
   */
  public static <Z, A extends Z, X extends Z>
      Function<OneTuple<Z, A>, TwoTuple<Z, A, X>> extendWith(X value) {
    return tuple -> tuple.extend(value);
  }

  /**
   * Extends the tuple to which this is applied by adding the value from the supplier to the end.
   *
   * <p>This is especially useful in functional contexts. For instance:
   *
   * <pre>
   * twoTupleStream = oneTupleStream.map(OneTuple.extendWith(supplier));
   * </pre>
   *
   * @see #extend(Object)
   */
  public static <Z, A extends Z, X extends Z>
      Function<OneTuple<Z, A>, TwoTuple<Z, A, X>> extendWith(Supplier<X> supplier) {
    return tuple -> tuple.extend(supplier);
  }

  /**
   * Extends the tuple to which this is applied by adding the value from the function to the end.
   *
   * <p>This is especially useful in functional contexts. For instance:
   *
   * <pre>
   * twoTupleStream = oneTupleStream.map(OneTuple.extendWith(function));
   * </pre>
   *
   * @see #extend(Object)
   */
  public static <Z, A extends Z, X extends Z>
      Function<OneTuple<Z, A>, TwoTuple<Z, A, X>> extendWith(Function<OneTuple<Z, A>, X> function) {
    return tuple -> tuple.extend(function);
  }

  /** Creates a new instance of this class. */
  public static <Z, A extends Z> OneTuple<Z, A> of(A first) {
    return new OneTuple<>(first);
  }
}

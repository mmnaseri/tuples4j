package com.mmnaseri.utils.tuples.impl;

import com.mmnaseri.utils.tuples.facade.HasFirst;
import com.mmnaseri.utils.tuples.facade.HasSecond;

import java.util.function.Function;
import java.util.function.Supplier;

import static com.mmnaseri.utils.tuples.utils.TupleUtils.checkIndex;

/**
 * Class for dealing with a {@link com.mmnaseri.utils.tuples.FixedTuple} with two elements.
 *
 * @author Milad Naseri (m.m.naseri@gmail.com)
 */
public class TwoTuple<Z, A extends Z, B extends Z> extends AbstractFixedTuple<Z, TwoTuple<Z, A, B>>
    implements HasFirst<Z, A, TwoTuple<Z, A, B>>, HasSecond<Z, B, TwoTuple<Z, A, B>> {

  /** Creates a new instance of this class from the provided values. */
  public TwoTuple(A first, B second) {
    super(first, second);
  }

  /**
   * Returns a new tuple by keeping all the values from this tuple and overriding the value at the
   * provided index with the value returned from the supplier.
   */
  @Override
  public TwoTuple<Z, Z, Z> change(int index, Supplier<? extends Z> supplier) {
    checkIndex(index, size());
    return new TwoTuple<>(
        index == 0 ? supplier.get() : first(), index == 1 ? supplier.get() : second());
  }

  /**
   * Returns a new tuple by keeping all the values from this tuple and overriding the value at the
   * provided index with the value returned from the function.
   */
  @Override
  public TwoTuple<Z, Z, Z> change(int index, Function<TwoTuple<Z, A, B>, ? extends Z> function) {
    checkIndex(index, size());
    return new TwoTuple<>(
        index == 0 ? function.apply(this) : first(), index == 1 ? function.apply(this) : second());
  }

  /**
   * Returns a new tuple of one size larger by adding the provided value to the end of this tuple.
   */
  @Override
  public <X extends Z> ThreeTuple<Z, A, B, X> extend(X value) {
    return new ThreeTuple<>(first(), second(), value);
  }

  /**
   * Returns a new tuple of one size larger by adding the value returned from the supplier to the
   * end of this tuple.
   */
  @Override
  public <X extends Z> ThreeTuple<Z, A, B, X> extend(Supplier<X> supplier) {
    return new ThreeTuple<>(first(), second(), supplier.get());
  }

  /**
   * Returns a new tuple of one size larger by adding the value returned from the function to the
   * end of this tuple.
   */
  @Override
  public <X extends Z> ThreeTuple<Z, A, B, X> extend(Function<TwoTuple<Z, A, B>, X> function) {
    return new ThreeTuple<>(first(), second(), function.apply(this));
  }

  /**
   * Returns a new tuple of the same size by keeping all the values from this tuple and overriding
   * the first element with the provided value.
   */
  @Override
  public <X extends Z> TwoTuple<Z, X, B> first(X value) {
    return new TwoTuple<>(value, second());
  }

  /**
   * Returns a new tuple of the same size by keeping all the values from this tuple and overriding
   * the first element with the value returned from the given supplier.
   */
  @Override
  public <X extends Z> TwoTuple<Z, X, B> first(Supplier<X> supplier) {
    return new TwoTuple<>(supplier.get(), second());
  }

  /**
   * Returns a new tuple of the same size by keeping all the values from this tuple and overriding
   * the first element with the value returned by applying the given function to this tuple's first
   * element.
   */
  @Override
  public <X extends Z> TwoTuple<Z, X, B> first(Function<A, X> function) {
    return new TwoTuple<>(function.apply(first()), second());
  }

  /**
   * Returns a new tuple of one size smaller by keeping all the values from this tuple except the
   * first element.
   */
  @Override
  public OneTuple<Z, B> dropFirst() {
    return new OneTuple<>(second());
  }

  /**
   * Returns a new tuple of the same size by keeping all the values from this tuple and overriding
   * the second element with the provided value.
   */
  @Override
  public <X extends Z> TwoTuple<Z, A, X> second(X value) {
    return new TwoTuple<>(first(), value);
  }

  /**
   * Returns a new tuple of the same size by keeping all the values from this tuple and overriding
   * the second element with the value returned from the given supplier.
   */
  @Override
  public <X extends Z> TwoTuple<Z, A, X> second(Supplier<X> supplier) {
    return new TwoTuple<>(first(), supplier.get());
  }

  /**
   * Returns a new tuple of the same size by keeping all the values from this tuple and overriding
   * the second element with the value returned by applying the given function to this tuple's
   * second element.
   */
  @Override
  public <X extends Z> TwoTuple<Z, A, X> second(Function<B, X> function) {
    return new TwoTuple<>(first(), function.apply(second()));
  }

  /**
   * Returns a new tuple of one size smaller by keeping all the values from this tuple except the
   * second element.
   */
  @Override
  public OneTuple<Z, A> dropSecond() {
    return new OneTuple<>(first());
  }

  /**
   * Extends the tuple to which this is applied by adding the provided value to the end.
   *
   * <p>This is especially useful in functional contexts. For instance:
   *
   * <pre>
   * threeTupleStream = twoTupleStream.map(TwoTuple.extendWith(value));
   * </pre>
   *
   * @see #extend(Object)
   */
  public static <Z, A extends Z, B extends Z, X extends Z>
      Function<TwoTuple<Z, A, B>, ThreeTuple<Z, A, B, X>> extendWith(X value) {
    return tuple -> tuple.extend(value);
  }

  /**
   * Extends the tuple to which this is applied by adding the value from the supplier to the end.
   *
   * <p>This is especially useful in functional contexts. For instance:
   *
   * <pre>
   * threeTupleStream = twoTupleStream.map(TwoTuple.extendWith(supplier));
   * </pre>
   *
   * @see #extend(Object)
   */
  public static <Z, A extends Z, B extends Z, X extends Z>
      Function<TwoTuple<Z, A, B>, ThreeTuple<Z, A, B, X>> extendWith(Supplier<X> supplier) {
    return tuple -> tuple.extend(supplier);
  }

  /**
   * Extends the tuple to which this is applied by adding the value from the function to the end.
   *
   * <p>This is especially useful in functional contexts. For instance:
   *
   * <pre>
   * threeTupleStream = twoTupleStream.map(TwoTuple.extendWith(function));
   * </pre>
   *
   * @see #extend(Object)
   */
  public static <Z, A extends Z, B extends Z, X extends Z>
      Function<TwoTuple<Z, A, B>, ThreeTuple<Z, A, B, X>> extendWith(
          Function<TwoTuple<Z, A, B>, X> function) {
    return tuple -> tuple.extend(function);
  }

  /** Creates a new instance of this class. */
  public static <Z, A extends Z, B extends Z> TwoTuple<Z, A, B> of(A first, B second) {
    return new TwoTuple<>(first, second);
  }
}

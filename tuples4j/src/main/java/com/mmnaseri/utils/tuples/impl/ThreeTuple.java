package com.mmnaseri.utils.tuples.impl;

import com.mmnaseri.utils.tuples.facade.HasFirst;
import com.mmnaseri.utils.tuples.facade.HasSecond;
import com.mmnaseri.utils.tuples.facade.HasThird;

import java.util.function.Function;
import java.util.function.Supplier;

import static com.mmnaseri.utils.tuples.utils.TupleUtils.checkIndex;

/**
 * Class for dealing with a {@link com.mmnaseri.utils.tuples.FixedTuple} with three elements.
 *
 * @author Milad Naseri (m.m.naseri@gmail.com)
 */
public class ThreeTuple<Z, A extends Z, B extends Z, C extends Z>
    extends AbstractFixedTuple<Z, ThreeTuple<Z, A, B, C>>
    implements HasFirst<Z, A, ThreeTuple<Z, A, B, C>>,
        HasSecond<Z, B, ThreeTuple<Z, A, B, C>>,
        HasThird<Z, C, ThreeTuple<Z, A, B, C>> {

  /** Creates a new instance of this class from the provided values. */
  public ThreeTuple(A first, B second, C third) {
    super(first, second, third);
  }

  /**
   * Returns a new tuple by keeping all the values from this tuple and overriding the value at the
   * provided index with the value returned from the supplier.
   */
  @Override
  public ThreeTuple<Z, Z, Z, Z> change(int index, Supplier<? extends Z> supplier) {
    checkIndex(index, size());
    return new ThreeTuple<>(
        index == 0 ? supplier.get() : first(),
        index == 1 ? supplier.get() : second(),
        index == 2 ? supplier.get() : third());
  }

  /**
   * Returns a new tuple by keeping all the values from this tuple and overriding the value at the
   * provided index with the value returned from the function.
   */
  @Override
  public ThreeTuple<Z, Z, Z, Z> change(
      int index, Function<ThreeTuple<Z, A, B, C>, ? extends Z> function) {
    checkIndex(index, size());
    return new ThreeTuple<>(
        index == 0 ? function.apply(this) : first(),
        index == 1 ? function.apply(this) : second(),
        index == 2 ? function.apply(this) : third());
  }

  /**
   * Returns a new tuple of one size larger by adding the provided value to the end of this tuple.
   */
  @Override
  public <X extends Z> FourTuple<Z, A, B, C, X> extend(X value) {
    return new FourTuple<>(first(), second(), third(), value);
  }

  /**
   * Returns a new tuple of one size larger by adding the value returned from the supplier to the
   * end of this tuple.
   */
  @Override
  public <X extends Z> FourTuple<Z, A, B, C, X> extend(Supplier<X> supplier) {
    return new FourTuple<>(first(), second(), third(), supplier.get());
  }

  /**
   * Returns a new tuple of one size larger by adding the value returned from the function to the
   * end of this tuple.
   */
  @Override
  public <X extends Z> FourTuple<Z, A, B, C, X> extend(
      Function<ThreeTuple<Z, A, B, C>, X> function) {
    return new FourTuple<>(first(), second(), third(), function.apply(this));
  }

  /**
   * Returns a new tuple of the same size by keeping all the values from this tuple and overriding
   * the first element with the provided value.
   */
  @Override
  public <X extends Z> ThreeTuple<Z, X, B, C> first(X value) {
    return new ThreeTuple<>(value, second(), third());
  }

  /**
   * Returns a new tuple of the same size by keeping all the values from this tuple and overriding
   * the first element with the value returned from the given supplier.
   */
  @Override
  public <X extends Z> ThreeTuple<Z, X, B, C> first(Supplier<X> supplier) {
    return new ThreeTuple<>(supplier.get(), second(), third());
  }

  /**
   * Returns a new tuple of the same size by keeping all the values from this tuple and overriding
   * the first element with the value returned by applying the given function to this tuple's first
   * element.
   */
  @Override
  public <X extends Z> ThreeTuple<Z, X, B, C> first(Function<A, X> function) {
    return new ThreeTuple<>(function.apply(first()), second(), third());
  }

  /**
   * Returns a new tuple of one size smaller by keeping all the values from this tuple except the
   * first element.
   */
  @Override
  public TwoTuple<Z, B, C> dropFirst() {
    return new TwoTuple<>(second(), third());
  }

  /**
   * Returns a new tuple of the same size by keeping all the values from this tuple and overriding
   * the second element with the provided value.
   */
  @Override
  public <X extends Z> ThreeTuple<Z, A, X, C> second(X value) {
    return new ThreeTuple<>(first(), value, third());
  }

  /**
   * Returns a new tuple of the same size by keeping all the values from this tuple and overriding
   * the second element with the value returned from the given supplier.
   */
  @Override
  public <X extends Z> ThreeTuple<Z, A, X, C> second(Supplier<X> supplier) {
    return new ThreeTuple<>(first(), supplier.get(), third());
  }

  /**
   * Returns a new tuple of the same size by keeping all the values from this tuple and overriding
   * the second element with the value returned by applying the given function to this tuple's
   * second element.
   */
  @Override
  public <X extends Z> ThreeTuple<Z, A, X, C> second(Function<B, X> function) {
    return new ThreeTuple<>(first(), function.apply(second()), third());
  }

  /**
   * Returns a new tuple of one size smaller by keeping all the values from this tuple except the
   * second element.
   */
  @Override
  public TwoTuple<Z, A, C> dropSecond() {
    return new TwoTuple<>(first(), third());
  }

  /**
   * Returns a new tuple of the same size by keeping all the values from this tuple and overriding
   * the third element with the provided value.
   */
  @Override
  public <X extends Z> ThreeTuple<Z, A, B, X> third(X value) {
    return new ThreeTuple<>(first(), second(), value);
  }

  /**
   * Returns a new tuple of the same size by keeping all the values from this tuple and overriding
   * the third element with the value returned from the given supplier.
   */
  @Override
  public <X extends Z> ThreeTuple<Z, A, B, X> third(Supplier<X> supplier) {
    return new ThreeTuple<>(first(), second(), supplier.get());
  }

  /**
   * Returns a new tuple of the same size by keeping all the values from this tuple and overriding
   * the third element with the value returned by applying the given function to this tuple's third
   * element.
   */
  @Override
  public <X extends Z> ThreeTuple<Z, A, B, X> third(Function<C, X> function) {
    return new ThreeTuple<>(first(), second(), function.apply(third()));
  }

  /**
   * Returns a new tuple of one size smaller by keeping all the values from this tuple except the
   * third element.
   */
  @Override
  public TwoTuple<Z, A, B> dropThird() {
    return new TwoTuple<>(first(), second());
  }

  /**
   * Extends the tuple to which this is applied by adding the provided value to the end.
   *
   * <p>This is especially useful in functional contexts. For instance:
   *
   * <pre>
   * fourTupleStream = threeTupleStream.map(ThreeTuple.extendWith(value));
   * </pre>
   *
   * @see #extend(Object)
   */
  public static <Z, A extends Z, B extends Z, C extends Z, X extends Z>
      Function<ThreeTuple<Z, A, B, C>, FourTuple<Z, A, B, C, X>> extendWith(X value) {
    return tuple -> tuple.extend(value);
  }

  /**
   * Extends the tuple to which this is applied by adding the value from the supplier to the end.
   *
   * <p>This is especially useful in functional contexts. For instance:
   *
   * <pre>
   * fourTupleStream = threeTupleStream.map(ThreeTuple.extendWith(supplier));
   * </pre>
   *
   * @see #extend(Object)
   */
  public static <Z, A extends Z, B extends Z, C extends Z, X extends Z>
      Function<ThreeTuple<Z, A, B, C>, FourTuple<Z, A, B, C, X>> extendWith(Supplier<X> supplier) {
    return tuple -> tuple.extend(supplier);
  }

  /**
   * Extends the tuple to which this is applied by adding the value from the function to the end.
   *
   * <p>This is especially useful in functional contexts. For instance:
   *
   * <pre>
   * fourTupleStream = threeTupleStream.map(ThreeTuple.extendWith(function));
   * </pre>
   *
   * @see #extend(Object)
   */
  public static <Z, A extends Z, B extends Z, C extends Z, X extends Z>
      Function<ThreeTuple<Z, A, B, C>, FourTuple<Z, A, B, C, X>> extendWith(
          Function<ThreeTuple<Z, A, B, C>, X> function) {
    return tuple -> tuple.extend(function);
  }

  /** Creates a new instance of this class. */
  public static <Z, A extends Z, B extends Z, C extends Z> ThreeTuple<Z, A, B, C> of(
      A first, B second, C third) {
    return new ThreeTuple<>(first, second, third);
  }
}

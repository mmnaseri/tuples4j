package com.mmnaseri.utils.tuples.impl;

import com.mmnaseri.utils.tuples.facade.HasFirst;
import com.mmnaseri.utils.tuples.facade.HasFourth;
import com.mmnaseri.utils.tuples.facade.HasSecond;
import com.mmnaseri.utils.tuples.facade.HasThird;

import java.util.function.Function;
import java.util.function.Supplier;

import static com.mmnaseri.utils.tuples.utils.TupleUtils.checkIndex;

/**
 * Class for dealing with a {@link com.mmnaseri.utils.tuples.FixedTuple} with four elements.
 *
 * @author Milad Naseri (m.m.naseri@gmail.com)
 */
public class FourTuple<Z, A extends Z, B extends Z, C extends Z, D extends Z>
    extends AbstractFixedTuple<Z, FourTuple<Z, A, B, C, D>>
    implements HasFirst<Z, A, FourTuple<Z, A, B, C, D>>,
        HasSecond<Z, B, FourTuple<Z, A, B, C, D>>,
        HasThird<Z, C, FourTuple<Z, A, B, C, D>>,
        HasFourth<Z, D, FourTuple<Z, A, B, C, D>> {

  /** Creates a new instance of this class from the provided values. */
  public FourTuple(A first, B second, C third, D fourth) {
    super(first, second, third, fourth);
  }

  /**
   * Returns a new tuple by keeping all the values from this tuple and overriding the value at the
   * provided index with the value returned from the supplier.
   */
  @Override
  public FourTuple<Z, Z, Z, Z, Z> change(int index, Supplier<? extends Z> supplier) {
    checkIndex(index, size());
    return new FourTuple<>(
        index == 0 ? supplier.get() : first(),
        index == 1 ? supplier.get() : second(),
        index == 2 ? supplier.get() : third(),
        index == 3 ? supplier.get() : fourth());
  }

  /**
   * Returns a new tuple by keeping all the values from this tuple and overriding the value at the
   * provided index with the value returned from the function.
   */
  @Override
  public FourTuple<Z, Z, Z, Z, Z> change(
      int index, Function<FourTuple<Z, A, B, C, D>, ? extends Z> function) {
    checkIndex(index, size());
    return new FourTuple<>(
        index == 0 ? function.apply(this) : first(),
        index == 1 ? function.apply(this) : second(),
        index == 2 ? function.apply(this) : third(),
        index == 3 ? function.apply(this) : fourth());
  }

  /**
   * Returns a new tuple of one size larger by adding the provided value to the end of this tuple.
   */
  @Override
  public <X extends Z> FiveTuple<Z, A, B, C, D, X> extend(X value) {
    return new FiveTuple<>(first(), second(), third(), fourth(), value);
  }

  /**
   * Returns a new tuple of one size larger by adding the value returned from the supplier to the
   * end of this tuple.
   */
  @Override
  public <X extends Z> FiveTuple<Z, A, B, C, D, X> extend(Supplier<X> supplier) {
    return new FiveTuple<>(first(), second(), third(), fourth(), supplier.get());
  }

  /**
   * Returns a new tuple of one size larger by adding the value returned from the function to the
   * end of this tuple.
   */
  @Override
  public <X extends Z> FiveTuple<Z, A, B, C, D, X> extend(
      Function<FourTuple<Z, A, B, C, D>, X> function) {
    return new FiveTuple<>(first(), second(), third(), fourth(), function.apply(this));
  }

  /**
   * Returns a new tuple of the same size by keeping all the values from this tuple and overriding
   * the first element with the provided value.
   */
  @Override
  public <X extends Z> FourTuple<Z, X, B, C, D> first(X value) {
    return new FourTuple<>(value, second(), third(), fourth());
  }

  /**
   * Returns a new tuple of the same size by keeping all the values from this tuple and overriding
   * the first element with the value returned from the given supplier.
   */
  @Override
  public <X extends Z> FourTuple<Z, X, B, C, D> first(Supplier<X> supplier) {
    return new FourTuple<>(supplier.get(), second(), third(), fourth());
  }

  /**
   * Returns a new tuple of the same size by keeping all the values from this tuple and overriding
   * the first element with the value returned by applying the given function to this tuple's first
   * element.
   */
  @Override
  public <X extends Z> FourTuple<Z, X, B, C, D> first(Function<A, X> function) {
    return new FourTuple<>(function.apply(first()), second(), third(), fourth());
  }

  /**
   * Returns a new tuple of one size smaller by keeping all the values from this tuple except the
   * first element.
   */
  @Override
  public ThreeTuple<Z, B, C, D> dropFirst() {
    return new ThreeTuple<>(second(), third(), fourth());
  }

  /**
   * Returns a new tuple of the same size by keeping all the values from this tuple and overriding
   * the second element with the provided value.
   */
  @Override
  public <X extends Z> FourTuple<Z, A, X, C, D> second(X value) {
    return new FourTuple<>(first(), value, third(), fourth());
  }

  /**
   * Returns a new tuple of the same size by keeping all the values from this tuple and overriding
   * the second element with the value returned from the given supplier.
   */
  @Override
  public <X extends Z> FourTuple<Z, A, X, C, D> second(Supplier<X> supplier) {
    return new FourTuple<>(first(), supplier.get(), third(), fourth());
  }

  /**
   * Returns a new tuple of the same size by keeping all the values from this tuple and overriding
   * the second element with the value returned by applying the given function to this tuple's
   * second element.
   */
  @Override
  public <X extends Z> FourTuple<Z, A, X, C, D> second(Function<B, X> function) {
    return new FourTuple<>(first(), function.apply(second()), third(), fourth());
  }

  /**
   * Returns a new tuple of one size smaller by keeping all the values from this tuple except the
   * second element.
   */
  @Override
  public ThreeTuple<Z, A, C, D> dropSecond() {
    return new ThreeTuple<>(first(), third(), fourth());
  }

  /**
   * Returns a new tuple of the same size by keeping all the values from this tuple and overriding
   * the third element with the provided value.
   */
  @Override
  public <X extends Z> FourTuple<Z, A, B, X, D> third(X value) {
    return new FourTuple<>(first(), second(), value, fourth());
  }

  /**
   * Returns a new tuple of the same size by keeping all the values from this tuple and overriding
   * the third element with the value returned from the given supplier.
   */
  @Override
  public <X extends Z> FourTuple<Z, A, B, X, D> third(Supplier<X> supplier) {
    return new FourTuple<>(first(), second(), supplier.get(), fourth());
  }

  /**
   * Returns a new tuple of the same size by keeping all the values from this tuple and overriding
   * the third element with the value returned by applying the given function to this tuple's third
   * element.
   */
  @Override
  public <X extends Z> FourTuple<Z, A, B, X, D> third(Function<C, X> function) {
    return new FourTuple<>(first(), second(), function.apply(third()), fourth());
  }

  /**
   * Returns a new tuple of one size smaller by keeping all the values from this tuple except the
   * third element.
   */
  @Override
  public ThreeTuple<Z, A, B, D> dropThird() {
    return new ThreeTuple<>(first(), second(), fourth());
  }

  /**
   * Returns a new tuple of the same size by keeping all the values from this tuple and overriding
   * the fourth element with the provided value.
   */
  @Override
  public <X extends Z> FourTuple<Z, A, B, C, X> fourth(X value) {
    return new FourTuple<>(first(), second(), third(), value);
  }

  /**
   * Returns a new tuple of the same size by keeping all the values from this tuple and overriding
   * the fourth element with the value returned from the given supplier.
   */
  @Override
  public <X extends Z> FourTuple<Z, A, B, C, X> fourth(Supplier<X> supplier) {
    return new FourTuple<>(first(), second(), third(), supplier.get());
  }

  /**
   * Returns a new tuple of the same size by keeping all the values from this tuple and overriding
   * the fourth element with the value returned by applying the given function to this tuple's
   * fourth element.
   */
  @Override
  public <X extends Z> FourTuple<Z, A, B, C, X> fourth(Function<D, X> function) {
    return new FourTuple<>(first(), second(), third(), function.apply(fourth()));
  }

  /**
   * Returns a new tuple of one size smaller by keeping all the values from this tuple except the
   * fourth element.
   */
  @Override
  public ThreeTuple<Z, A, B, C> dropFourth() {
    return new ThreeTuple<>(first(), second(), third());
  }

  /**
   * Extends the tuple to which this is applied by adding the provided value to the end.
   *
   * <p>This is especially useful in functional contexts. For instance:
   *
   * <pre>
   * fiveTupleStream = fourTupleStream.map(FourTuple.extendWith(value));
   * </pre>
   *
   * @see #extend(Object)
   */
  public static <Z, A extends Z, B extends Z, C extends Z, D extends Z, X extends Z>
      Function<FourTuple<Z, A, B, C, D>, FiveTuple<Z, A, B, C, D, X>> extendWith(X value) {
    return tuple -> tuple.extend(value);
  }

  /**
   * Extends the tuple to which this is applied by adding the value from the supplier to the end.
   *
   * <p>This is especially useful in functional contexts. For instance:
   *
   * <pre>
   * fiveTupleStream = fourTupleStream.map(FourTuple.extendWith(supplier));
   * </pre>
   *
   * @see #extend(Object)
   */
  public static <Z, A extends Z, B extends Z, C extends Z, D extends Z, X extends Z>
      Function<FourTuple<Z, A, B, C, D>, FiveTuple<Z, A, B, C, D, X>> extendWith(
          Supplier<X> supplier) {
    return tuple -> tuple.extend(supplier);
  }

  /**
   * Extends the tuple to which this is applied by adding the value from the function to the end.
   *
   * <p>This is especially useful in functional contexts. For instance:
   *
   * <pre>
   * fiveTupleStream = fourTupleStream.map(FourTuple.extendWith(function));
   * </pre>
   *
   * @see #extend(Object)
   */
  public static <Z, A extends Z, B extends Z, C extends Z, D extends Z, X extends Z>
      Function<FourTuple<Z, A, B, C, D>, FiveTuple<Z, A, B, C, D, X>> extendWith(
          Function<FourTuple<Z, A, B, C, D>, X> function) {
    return tuple -> tuple.extend(function);
  }

  /** Creates a new instance of this class. */
  public static <Z, A extends Z, B extends Z, C extends Z, D extends Z> FourTuple<Z, A, B, C, D> of(
      A first, B second, C third, D fourth) {
    return new FourTuple<>(first, second, third, fourth);
  }
}

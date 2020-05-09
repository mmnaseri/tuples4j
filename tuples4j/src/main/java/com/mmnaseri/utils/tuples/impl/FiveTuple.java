package com.mmnaseri.utils.tuples.impl;

import com.mmnaseri.utils.tuples.facade.HasFifth;
import com.mmnaseri.utils.tuples.facade.HasFirst;
import com.mmnaseri.utils.tuples.facade.HasFourth;
import com.mmnaseri.utils.tuples.facade.HasSecond;
import com.mmnaseri.utils.tuples.facade.HasThird;

import java.util.function.Function;
import java.util.function.Supplier;

import static com.mmnaseri.utils.tuples.utils.TupleUtils.checkIndex;

/**
 * Class for dealing with a {@link com.mmnaseri.utils.tuples.FixedTuple} with five elements.
 *
 * @author Milad Naseri (m.m.naseri@gmail.com)
 */
public class FiveTuple<Z, A extends Z, B extends Z, C extends Z, D extends Z, E extends Z>
    extends AbstractFixedTuple<Z, FiveTuple<Z, A, B, C, D, E>>
    implements HasFirst<Z, A, FiveTuple<Z, A, B, C, D, E>>,
        HasSecond<Z, B, FiveTuple<Z, A, B, C, D, E>>,
        HasThird<Z, C, FiveTuple<Z, A, B, C, D, E>>,
        HasFourth<Z, D, FiveTuple<Z, A, B, C, D, E>>,
        HasFifth<Z, E, FiveTuple<Z, A, B, C, D, E>> {

  /** Creates a new instance of this class from the provided values. */
  public FiveTuple(A first, B second, C third, D fourth, E fifth) {
    super(first, second, third, fourth, fifth);
  }

  /**
   * Returns a new tuple by keeping all the values from this tuple and overriding the value at the
   * provided index with the value returned from the supplier.
   */
  @Override
  public FiveTuple<Z, Z, Z, Z, Z, Z> change(int index, Supplier<? extends Z> supplier) {
    checkIndex(index, size());
    return new FiveTuple<>(
        index == 0 ? supplier.get() : first(),
        index == 1 ? supplier.get() : second(),
        index == 2 ? supplier.get() : third(),
        index == 3 ? supplier.get() : fourth(),
        index == 4 ? supplier.get() : fifth());
  }

  /**
   * Returns a new tuple by keeping all the values from this tuple and overriding the value at the
   * provided index with the value returned from the function.
   */
  @Override
  public FiveTuple<Z, Z, Z, Z, Z, Z> change(
      int index, Function<FiveTuple<Z, A, B, C, D, E>, ? extends Z> function) {
    checkIndex(index, size());
    return new FiveTuple<>(
        index == 0 ? function.apply(this) : first(),
        index == 1 ? function.apply(this) : second(),
        index == 2 ? function.apply(this) : third(),
        index == 3 ? function.apply(this) : fourth(),
        index == 4 ? function.apply(this) : fifth());
  }

  /**
   * Returns a new tuple of one size larger by adding the provided value to the end of this tuple.
   */
  @Override
  public <X extends Z> SixTuple<Z, A, B, C, D, E, X> extend(X value) {
    return new SixTuple<>(first(), second(), third(), fourth(), fifth(), value);
  }

  /**
   * Returns a new tuple of one size larger by adding the value returned from the supplier to the
   * end of this tuple.
   */
  @Override
  public <X extends Z> SixTuple<Z, A, B, C, D, E, X> extend(Supplier<X> supplier) {
    return new SixTuple<>(first(), second(), third(), fourth(), fifth(), supplier.get());
  }

  /**
   * Returns a new tuple of one size larger by adding the value returned from the function to the
   * end of this tuple.
   */
  @Override
  public <X extends Z> SixTuple<Z, A, B, C, D, E, X> extend(
      Function<FiveTuple<Z, A, B, C, D, E>, X> function) {
    return new SixTuple<>(first(), second(), third(), fourth(), fifth(), function.apply(this));
  }

  /**
   * Returns a new tuple of the same size by keeping all the values from this tuple and overriding
   * the first element with the provided value.
   */
  @Override
  public <X extends Z> FiveTuple<Z, X, B, C, D, E> first(X value) {
    return new FiveTuple<>(value, second(), third(), fourth(), fifth());
  }

  /**
   * Returns a new tuple of the same size by keeping all the values from this tuple and overriding
   * the first element with the value returned from the given supplier.
   */
  @Override
  public <X extends Z> FiveTuple<Z, X, B, C, D, E> first(Supplier<X> supplier) {
    return new FiveTuple<>(supplier.get(), second(), third(), fourth(), fifth());
  }

  /**
   * Returns a new tuple of the same size by keeping all the values from this tuple and overriding
   * the first element with the value returned by applying the given function to this tuple's first
   * element.
   */
  @Override
  public <X extends Z> FiveTuple<Z, X, B, C, D, E> first(Function<A, X> function) {
    return new FiveTuple<>(function.apply(first()), second(), third(), fourth(), fifth());
  }

  /**
   * Returns a new tuple of one size smaller by keeping all the values from this tuple except the
   * first element.
   */
  @Override
  public FourTuple<Z, B, C, D, E> dropFirst() {
    return new FourTuple<>(second(), third(), fourth(), fifth());
  }

  /**
   * Returns a new tuple of the same size by keeping all the values from this tuple and overriding
   * the second element with the provided value.
   */
  @Override
  public <X extends Z> FiveTuple<Z, A, X, C, D, E> second(X value) {
    return new FiveTuple<>(first(), value, third(), fourth(), fifth());
  }

  /**
   * Returns a new tuple of the same size by keeping all the values from this tuple and overriding
   * the second element with the value returned from the given supplier.
   */
  @Override
  public <X extends Z> FiveTuple<Z, A, X, C, D, E> second(Supplier<X> supplier) {
    return new FiveTuple<>(first(), supplier.get(), third(), fourth(), fifth());
  }

  /**
   * Returns a new tuple of the same size by keeping all the values from this tuple and overriding
   * the second element with the value returned by applying the given function to this tuple's
   * second element.
   */
  @Override
  public <X extends Z> FiveTuple<Z, A, X, C, D, E> second(Function<B, X> function) {
    return new FiveTuple<>(first(), function.apply(second()), third(), fourth(), fifth());
  }

  /**
   * Returns a new tuple of one size smaller by keeping all the values from this tuple except the
   * second element.
   */
  @Override
  public FourTuple<Z, A, C, D, E> dropSecond() {
    return new FourTuple<>(first(), third(), fourth(), fifth());
  }

  /**
   * Returns a new tuple of the same size by keeping all the values from this tuple and overriding
   * the third element with the provided value.
   */
  @Override
  public <X extends Z> FiveTuple<Z, A, B, X, D, E> third(X value) {
    return new FiveTuple<>(first(), second(), value, fourth(), fifth());
  }

  /**
   * Returns a new tuple of the same size by keeping all the values from this tuple and overriding
   * the third element with the value returned from the given supplier.
   */
  @Override
  public <X extends Z> FiveTuple<Z, A, B, X, D, E> third(Supplier<X> supplier) {
    return new FiveTuple<>(first(), second(), supplier.get(), fourth(), fifth());
  }

  /**
   * Returns a new tuple of the same size by keeping all the values from this tuple and overriding
   * the third element with the value returned by applying the given function to this tuple's third
   * element.
   */
  @Override
  public <X extends Z> FiveTuple<Z, A, B, X, D, E> third(Function<C, X> function) {
    return new FiveTuple<>(first(), second(), function.apply(third()), fourth(), fifth());
  }

  /**
   * Returns a new tuple of one size smaller by keeping all the values from this tuple except the
   * third element.
   */
  @Override
  public FourTuple<Z, A, B, D, E> dropThird() {
    return new FourTuple<>(first(), second(), fourth(), fifth());
  }

  /**
   * Returns a new tuple of the same size by keeping all the values from this tuple and overriding
   * the fourth element with the provided value.
   */
  @Override
  public <X extends Z> FiveTuple<Z, A, B, C, X, E> fourth(X value) {
    return new FiveTuple<>(first(), second(), third(), value, fifth());
  }

  /**
   * Returns a new tuple of the same size by keeping all the values from this tuple and overriding
   * the fourth element with the value returned from the given supplier.
   */
  @Override
  public <X extends Z> FiveTuple<Z, A, B, C, X, E> fourth(Supplier<X> supplier) {
    return new FiveTuple<>(first(), second(), third(), supplier.get(), fifth());
  }

  /**
   * Returns a new tuple of the same size by keeping all the values from this tuple and overriding
   * the fourth element with the value returned by applying the given function to this tuple's
   * fourth element.
   */
  @Override
  public <X extends Z> FiveTuple<Z, A, B, C, X, E> fourth(Function<D, X> function) {
    return new FiveTuple<>(first(), second(), third(), function.apply(fourth()), fifth());
  }

  /**
   * Returns a new tuple of one size smaller by keeping all the values from this tuple except the
   * fourth element.
   */
  @Override
  public FourTuple<Z, A, B, C, E> dropFourth() {
    return new FourTuple<>(first(), second(), third(), fifth());
  }

  /**
   * Returns a new tuple of the same size by keeping all the values from this tuple and overriding
   * the fifth element with the provided value.
   */
  @Override
  public <X extends Z> FiveTuple<Z, A, B, C, D, X> fifth(X value) {
    return new FiveTuple<>(first(), second(), third(), fourth(), value);
  }

  /**
   * Returns a new tuple of the same size by keeping all the values from this tuple and overriding
   * the fifth element with the value returned from the given supplier.
   */
  @Override
  public <X extends Z> FiveTuple<Z, A, B, C, D, X> fifth(Supplier<X> supplier) {
    return new FiveTuple<>(first(), second(), third(), fourth(), supplier.get());
  }

  /**
   * Returns a new tuple of the same size by keeping all the values from this tuple and overriding
   * the fifth element with the value returned by applying the given function to this tuple's fifth
   * element.
   */
  @Override
  public <X extends Z> FiveTuple<Z, A, B, C, D, X> fifth(Function<E, X> function) {
    return new FiveTuple<>(first(), second(), third(), fourth(), function.apply(fifth()));
  }

  /**
   * Returns a new tuple of one size smaller by keeping all the values from this tuple except the
   * fifth element.
   */
  @Override
  public FourTuple<Z, A, B, C, D> dropFifth() {
    return new FourTuple<>(first(), second(), third(), fourth());
  }

  /**
   * Extends the tuple to which this is applied by adding the provided value to the end.
   *
   * <p>This is especially useful in functional contexts. For instance:
   *
   * <pre>
   * sixTupleStream = fiveTupleStream.map(FiveTuple.extendWith(value));
   * </pre>
   *
   * @see #extend(Object)
   */
  public static <Z, A extends Z, B extends Z, C extends Z, D extends Z, E extends Z, X extends Z>
      Function<FiveTuple<Z, A, B, C, D, E>, SixTuple<Z, A, B, C, D, E, X>> extendWith(X value) {
    return tuple -> tuple.extend(value);
  }

  /**
   * Extends the tuple to which this is applied by adding the value from the supplier to the end.
   *
   * <p>This is especially useful in functional contexts. For instance:
   *
   * <pre>
   * sixTupleStream = fiveTupleStream.map(FiveTuple.extendWith(supplier));
   * </pre>
   *
   * @see #extend(Object)
   */
  public static <Z, A extends Z, B extends Z, C extends Z, D extends Z, E extends Z, X extends Z>
      Function<FiveTuple<Z, A, B, C, D, E>, SixTuple<Z, A, B, C, D, E, X>> extendWith(
          Supplier<X> supplier) {
    return tuple -> tuple.extend(supplier);
  }

  /**
   * Extends the tuple to which this is applied by adding the value from the function to the end.
   *
   * <p>This is especially useful in functional contexts. For instance:
   *
   * <pre>
   * sixTupleStream = fiveTupleStream.map(FiveTuple.extendWith(function));
   * </pre>
   *
   * @see #extend(Object)
   */
  public static <Z, A extends Z, B extends Z, C extends Z, D extends Z, E extends Z, X extends Z>
      Function<FiveTuple<Z, A, B, C, D, E>, SixTuple<Z, A, B, C, D, E, X>> extendWith(
          Function<FiveTuple<Z, A, B, C, D, E>, X> function) {
    return tuple -> tuple.extend(function);
  }

  /** Creates a new instance of this class. */
  public static <Z, A extends Z, B extends Z, C extends Z, D extends Z, E extends Z>
      FiveTuple<Z, A, B, C, D, E> of(A first, B second, C third, D fourth, E fifth) {
    return new FiveTuple<>(first, second, third, fourth, fifth);
  }
}

package com.mmnaseri.utils.tuples;

import com.mmnaseri.utils.tuples.facade.HasEighth;
import com.mmnaseri.utils.tuples.facade.HasEleventh;
import com.mmnaseri.utils.tuples.facade.HasFifth;
import com.mmnaseri.utils.tuples.facade.HasFirst;
import com.mmnaseri.utils.tuples.facade.HasFourth;
import com.mmnaseri.utils.tuples.facade.HasNinth;
import com.mmnaseri.utils.tuples.facade.HasSecond;
import com.mmnaseri.utils.tuples.facade.HasSeventh;
import com.mmnaseri.utils.tuples.facade.HasSixth;
import com.mmnaseri.utils.tuples.facade.HasTenth;
import com.mmnaseri.utils.tuples.facade.HasThird;
import com.mmnaseri.utils.tuples.facade.HasTwelfth;
import com.mmnaseri.utils.tuples.impl.DefaultLabeledTuple;
import com.mmnaseri.utils.tuples.impl.EightTuple;
import com.mmnaseri.utils.tuples.impl.ElevenTuple;
import com.mmnaseri.utils.tuples.impl.EmptyTuple;
import com.mmnaseri.utils.tuples.impl.FiveTuple;
import com.mmnaseri.utils.tuples.impl.FourTuple;
import com.mmnaseri.utils.tuples.impl.NineTuple;
import com.mmnaseri.utils.tuples.impl.OneTuple;
import com.mmnaseri.utils.tuples.impl.SevenTuple;
import com.mmnaseri.utils.tuples.impl.SixTuple;
import com.mmnaseri.utils.tuples.impl.TenTuple;
import com.mmnaseri.utils.tuples.impl.ThirteenOrMoreTuple;
import com.mmnaseri.utils.tuples.impl.ThreeTuple;
import com.mmnaseri.utils.tuples.impl.TwelveTuple;
import com.mmnaseri.utils.tuples.impl.TwoTuple;
import com.mmnaseri.utils.tuples.utils.FluentList;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static com.mmnaseri.utils.tuples.utils.TupleUtils.checkSize;
import static java.util.stream.Collectors.toCollection;

/**
 * The base definition for a tuple.
 *
 * @author Milad Naseri (m.m.naseri@gmail.com)
 */
public interface Tuple<Z> {

  /** Returns the size of the tuple. */
  int size();

  /**
   * Returns the element at the given position. Index must be between zero and the {@link #size()}
   * of this tuple.
   */
  Z get(int index);

  /** Changes the value of the element at the given index to the new value. */
  default Tuple<Z> change(int index, Z value) {
    return change(index, () -> value);
  }

  /** Changes the value of the element at the given index to the value provided by the supplier. */
  Tuple<Z> change(int index, Supplier<? extends Z> value);

  /** Returns a new, empty tuple. This is the same as called {@link #empty()}. */
  default Tuple<Z> clear() {
    return EmptyTuple.of();
  }

  /** Returns a new tuple formed by dropping the element at the indicated index. */
  Tuple<Z> drop(int index);

  /** Returns a stream of all the elements in this tuple. */
  default Stream<Z> stream() {
    return IntStream.range(0, size()).boxed().map(this::get);
  }

  /** Returns the items in the tuple as an instance of {@link FluentList}. */
  default FluentList<Z> asList() {
    return stream().collect(toCollection(FluentList::new));
  }

  /**
   * Extends this tuple by returning a new tuple that has the provided element added to the end of
   * the elements in this tuple.
   */
  default <X extends Z> Tuple<Z> extend(X value) {
    return extend((Supplier<X>) () -> value);
  }

  /**
   * Extends this tuple by returning a new tuple that has the element returned from the supplier
   * added to the end of the elements in this tuple.
   */
  <X extends Z> Tuple<Z> extend(Supplier<X> value);

  /** Checks the indicated element in the tuple against the provided predicate. */
  default boolean check(int index, Predicate<Z> predicate) {
    return predicate.test(get(index));
  }

  /**
   * Returns a new {@link LabeledTuple} by labeling the elements in the tuple with the corresponding
   * labels.
   */
  default LabeledTuple<Z> withLabels(String... labels) {
    return withLabels(Arrays.asList(labels));
  }

  /**
   * Returns a new {@link LabeledTuple} by labeling the elements in the tuple with the corresponding
   * labels.
   */
  default LabeledTuple<Z> withLabels(List<String> labels) {
    return new DefaultLabeledTuple<>(this, labels);
  }

  /**
   * Returns an instance of {@link EmptyTuple} that gets all of its corresponding values from this
   * tuple.
   */
  default EmptyTuple<Object> asEmpty() {
    checkSize(size(), 0);
    return of();
  }

  /**
   * Returns an instance of {@link OneTuple} that gets all of its corresponding values from this
   * tuple. This tuple must have at least 1 element.
   */
  default OneTuple<Object, Z> asOne() {
    checkSize(size(), 1);
    return of(get(0));
  }

  /**
   * Returns an instance of {@link TwoTuple} that gets all of its corresponding values from this
   * tuple. This tuple must have at least 2 elements.
   */
  default TwoTuple<Object, Z, Z> asTwo() {
    checkSize(size(), 2);
    return of(get(0), get(1));
  }

  /**
   * Returns an instance of {@link ThreeTuple} that gets all of its corresponding values from this
   * tuple. This tuple must have at least 3 elements.
   */
  default ThreeTuple<Object, Z, Z, Z> asThree() {
    checkSize(size(), 3);
    return of(get(0), get(1), get(2));
  }

  /**
   * Returns an instance of {@link FourTuple} that gets all of its corresponding values from this
   * tuple. This tuple must have at least 4 elements.
   */
  default FourTuple<Object, Z, Z, Z, Z> asFour() {
    checkSize(size(), 4);
    return of(get(0), get(1), get(2), get(3));
  }

  /**
   * Returns an instance of {@link FiveTuple} that gets all of its corresponding values from this
   * tuple. This tuple must have at least 5 elements.
   */
  default FiveTuple<Object, Z, Z, Z, Z, Z> asFive() {
    checkSize(size(), 5);
    return of(get(0), get(1), get(2), get(3), get(4));
  }

  /**
   * Returns an instance of {@link SixTuple} that gets all of its corresponding values from this
   * tuple. This tuple must have at least 6 elements.
   */
  default SixTuple<Object, Z, Z, Z, Z, Z, Z> asSix() {
    checkSize(size(), 6);
    return of(get(0), get(1), get(2), get(3), get(4), get(5));
  }

  /**
   * Returns an instance of {@link SevenTuple} that gets all of its corresponding values from this
   * tuple. This tuple must have at least 7 elements.
   */
  default SevenTuple<Object, Z, Z, Z, Z, Z, Z, Z> asSeven() {
    checkSize(size(), 7);
    return of(get(0), get(1), get(2), get(3), get(4), get(5), get(6));
  }

  /**
   * Returns an instance of {@link EightTuple} that gets all of its corresponding values from this
   * tuple. This tuple must have at least 8 elements.
   */
  default EightTuple<Object, Z, Z, Z, Z, Z, Z, Z, Z> asEight() {
    checkSize(size(), 8);
    return of(get(0), get(1), get(2), get(3), get(4), get(5), get(6), get(7));
  }

  /**
   * Returns an instance of {@link NineTuple} that gets all of its corresponding values from this
   * tuple. This tuple must have at least 9 elements.
   */
  default NineTuple<Object, Z, Z, Z, Z, Z, Z, Z, Z, Z> asNine() {
    checkSize(size(), 9);
    return of(get(0), get(1), get(2), get(3), get(4), get(5), get(6), get(7), get(8));
  }

  /**
   * Returns an instance of {@link TenTuple} that gets all of its corresponding values from this
   * tuple. This tuple must have at least 10 elements.
   */
  default TenTuple<Object, Z, Z, Z, Z, Z, Z, Z, Z, Z, Z> asTen() {
    checkSize(size(), 10);
    return of(get(0), get(1), get(2), get(3), get(4), get(5), get(6), get(7), get(8), get(9));
  }

  /**
   * Returns an instance of {@link ElevenTuple} that gets all of its corresponding values from this
   * tuple. This tuple must have at least 11 elements.
   */
  default ElevenTuple<Object, Z, Z, Z, Z, Z, Z, Z, Z, Z, Z, Z> asEleven() {
    checkSize(size(), 11);
    return of(
        get(0), get(1), get(2), get(3), get(4), get(5), get(6), get(7), get(8), get(9), get(10));
  }

  /**
   * Returns an instance of {@link TwelveTuple} that gets all of its corresponding values from this
   * tuple. This tuple must have at least 12 elements.
   */
  default TwelveTuple<Object, Z, Z, Z, Z, Z, Z, Z, Z, Z, Z, Z, Z> asTwelve() {
    checkSize(size(), 12);
    return of(
        get(0), get(1), get(2), get(3), get(4), get(5), get(6), get(7), get(8), get(9), get(10),
        get(11));
  }

  /**
   * Tightens the current tuple's super-type. If the tightened type is not applicable to all
   * elements, this would lead to an eventual {@link ClassCastException} when trying to access those
   * elements.
   */
  @SuppressWarnings("unchecked")
  default <X extends Z> Tuple<X> tighten() {
    return (Tuple<X>) this;
  }

  /**
   * Tightens the current tuple's super-type. If the tightened type is not applicable to all
   * elements, this would lead to an eventual {@link ClassCastException} when trying to access those
   * elements.
   */
  default <X extends Z> Tuple<X> tighten(Class<X> type) {
    return tighten();
  }

  // Static utility and builder methods.

  /**
   * Returns a function that can provided a {@link LabeledTuple} for the current tupe, with the
   * provided labels.
   *
   * @see #withLabels(String[])
   */
  static <Z> Function<Tuple<Z>, LabeledTuple<Z>> labelWith(String... labels) {
    return labelWith(Arrays.asList(labels));
  }

  /**
   * Returns a function that can provided a {@link LabeledTuple} for the current tupe, with the
   * provided labels.
   *
   * @see #withLabels(String[])
   */
  static <Z> Function<Tuple<Z>, LabeledTuple<Z>> labelWith(List<String> labels) {
    return tuple -> tuple.withLabels(labels);
  }

  /** Returns a new {@link EmptyTuple} from the provided values. */
  static EmptyTuple<Object> of() {
    return new EmptyTuple<>();
  }

  /** Returns a new {@link OneTuple} from the provided values. */
  static <A> OneTuple<Object, A> of(A first) {
    return new OneTuple<>(first);
  }

  /** Returns a new {@link TwoTuple} from the provided values. */
  static <A, B> TwoTuple<Object, A, B> of(A first, B second) {
    return new TwoTuple<>(first, second);
  }

  /** Returns a new {@link ThreeTuple} from the provided values. */
  static <A, B, C> ThreeTuple<Object, A, B, C> of(A first, B second, C third) {
    return new ThreeTuple<>(first, second, third);
  }

  /** Returns a new {@link FourTuple} from the provided values. */
  static <A, B, C, D> FourTuple<Object, A, B, C, D> of(A first, B second, C third, D fourth) {
    return new FourTuple<>(first, second, third, fourth);
  }

  /** Returns a new {@link FiveTuple} from the provided values. */
  static <A, B, C, D, E> FiveTuple<Object, A, B, C, D, E> of(
      A first, B second, C third, D fourth, E fifth) {
    return new FiveTuple<>(first, second, third, fourth, fifth);
  }

  /** Returns a new {@link SixTuple} from the provided values. */
  static <A, B, C, D, E, F> SixTuple<Object, A, B, C, D, E, F> of(
      A first, B second, C third, D fourth, E fifth, F sixth) {
    return new SixTuple<>(first, second, third, fourth, fifth, sixth);
  }

  /** Returns a new {@link SevenTuple} from the provided values. */
  static <A, B, C, D, E, F, G> SevenTuple<Object, A, B, C, D, E, F, G> of(
      A first, B second, C third, D fourth, E fifth, F sixth, G seventh) {
    return new SevenTuple<>(first, second, third, fourth, fifth, sixth, seventh);
  }

  /** Returns a new {@link EightTuple} from the provided values. */
  static <A, B, C, D, E, F, G, H> EightTuple<Object, A, B, C, D, E, F, G, H> of(
      A first, B second, C third, D fourth, E fifth, F sixth, G seventh, H eighth) {
    return new EightTuple<>(first, second, third, fourth, fifth, sixth, seventh, eighth);
  }

  /** Returns a new {@link NineTuple} from the provided values. */
  static <A, B, C, D, E, F, G, H, I> NineTuple<Object, A, B, C, D, E, F, G, H, I> of(
      A first, B second, C third, D fourth, E fifth, F sixth, G seventh, H eighth, I ninth) {
    return new NineTuple<>(first, second, third, fourth, fifth, sixth, seventh, eighth, ninth);
  }

  /** Returns a new {@link TenTuple} from the provided values. */
  static <A, B, C, D, E, F, G, H, I, J> TenTuple<Object, A, B, C, D, E, F, G, H, I, J> of(
      A first,
      B second,
      C third,
      D fourth,
      E fifth,
      F sixth,
      G seventh,
      H eighth,
      I ninth,
      J tenth) {
    return new TenTuple<>(
        first, second, third, fourth, fifth, sixth, seventh, eighth, ninth, tenth);
  }

  /** Returns a new {@link ElevenTuple} from the provided values. */
  static <A, B, C, D, E, F, G, H, I, J, K> ElevenTuple<Object, A, B, C, D, E, F, G, H, I, J, K> of(
      A first,
      B second,
      C third,
      D fourth,
      E fifth,
      F sixth,
      G seventh,
      H eighth,
      I ninth,
      J tenth,
      K eleventh) {
    return new ElevenTuple<>(
        first, second, third, fourth, fifth, sixth, seventh, eighth, ninth, tenth, eleventh);
  }

  /** Returns a new {@link TwelveTuple} from the provided values. */
  static <A, B, C, D, E, F, G, H, I, J, K, L>
      TwelveTuple<Object, A, B, C, D, E, F, G, H, I, J, K, L> of(
          A first,
          B second,
          C third,
          D fourth,
          E fifth,
          F sixth,
          G seventh,
          H eighth,
          I ninth,
          J tenth,
          K eleventh,
          L twelfth) {
    return new TwelveTuple<>(
        first, second, third, fourth, fifth, sixth, seventh, eighth, ninth, tenth, eleventh,
        twelfth);
  }

  /** Returns a new {@link ThirteenOrMoreTuple} from the provided values. */
  static <A, B, C, D, E, F, G, H, I, J, K, L>
      ThirteenOrMoreTuple<Object, A, B, C, D, E, F, G, H, I, J, K, L> of(
          A first,
          B second,
          C third,
          D fourth,
          E fifth,
          F sixth,
          G seventh,
          H eighth,
          I ninth,
          J tenth,
          K eleventh,
          L twelfth,
          Object thirteenth,
          Object... rest) {
    return new ThirteenOrMoreTuple<>(
        first,
        second,
        third,
        fourth,
        fifth,
        sixth,
        seventh,
        eighth,
        ninth,
        tenth,
        eleventh,
        twelfth,
        thirteenth,
        rest);
  }

  /**
   * Returns a new {@link EmptyTuple} from the provided values.
   *
   * @see #of()
   */
  static <A, B, C, D, E, F, G, H, I, J, K, L> EmptyTuple<Object> empty() {
    return of();
  }

  /**
   * Returns a new {@link OneTuple} from the provided values.
   *
   * @see #of(Object)
   */
  static <A, B, C, D, E, F, G, H, I, J, K, L> OneTuple<Object, A> one(A first) {
    return of(first);
  }

  /**
   * Returns a new {@link TwoTuple} from the provided values.
   *
   * @see #of(Object, Object)
   */
  static <A, B, C, D, E, F, G, H, I, J, K, L> TwoTuple<Object, A, B> two(A first, B second) {
    return of(first, second);
  }

  /**
   * Returns a new {@link ThreeTuple} from the provided values.
   *
   * @see #of(Object, Object, Object)
   */
  static <A, B, C, D, E, F, G, H, I, J, K, L> ThreeTuple<Object, A, B, C> three(
      A first, B second, C third) {
    return of(first, second, third);
  }

  /**
   * Returns a new {@link FourTuple} from the provided values.
   *
   * @see #of(Object, Object, Object, Object)
   */
  static <A, B, C, D, E, F, G, H, I, J, K, L> FourTuple<Object, A, B, C, D> four(
      A first, B second, C third, D fourth) {
    return of(first, second, third, fourth);
  }

  /**
   * Returns a new {@link FiveTuple} from the provided values.
   *
   * @see #of(Object, Object, Object, Object, Object)
   */
  static <A, B, C, D, E, F, G, H, I, J, K, L> FiveTuple<Object, A, B, C, D, E> five(
      A first, B second, C third, D fourth, E fifth) {
    return of(first, second, third, fourth, fifth);
  }

  /**
   * Returns a new {@link SixTuple} from the provided values.
   *
   * @see #of(Object, Object, Object, Object, Object, Object)
   */
  static <A, B, C, D, E, F, G, H, I, J, K, L> SixTuple<Object, A, B, C, D, E, F> six(
      A first, B second, C third, D fourth, E fifth, F sixth) {
    return of(first, second, third, fourth, fifth, sixth);
  }

  /**
   * Returns a new {@link SevenTuple} from the provided values.
   *
   * @see #of(Object, Object, Object, Object, Object, Object, Object)
   */
  static <A, B, C, D, E, F, G, H, I, J, K, L> SevenTuple<Object, A, B, C, D, E, F, G> seven(
      A first, B second, C third, D fourth, E fifth, F sixth, G seventh) {
    return of(first, second, third, fourth, fifth, sixth, seventh);
  }

  /**
   * Returns a new {@link EightTuple} from the provided values.
   *
   * @see #of(Object, Object, Object, Object, Object, Object, Object, Object)
   */
  static <A, B, C, D, E, F, G, H, I, J, K, L> EightTuple<Object, A, B, C, D, E, F, G, H> eight(
      A first, B second, C third, D fourth, E fifth, F sixth, G seventh, H eighth) {
    return of(first, second, third, fourth, fifth, sixth, seventh, eighth);
  }

  /**
   * Returns a new {@link NineTuple} from the provided values.
   *
   * @see #of(Object, Object, Object, Object, Object, Object, Object, Object, Object)
   */
  static <A, B, C, D, E, F, G, H, I, J, K, L> NineTuple<Object, A, B, C, D, E, F, G, H, I> nine(
      A first, B second, C third, D fourth, E fifth, F sixth, G seventh, H eighth, I ninth) {
    return of(first, second, third, fourth, fifth, sixth, seventh, eighth, ninth);
  }

  /**
   * Returns a new {@link TenTuple} from the provided values.
   *
   * @see #of(Object, Object, Object, Object, Object, Object, Object, Object, Object, Object)
   */
  static <A, B, C, D, E, F, G, H, I, J, K, L> TenTuple<Object, A, B, C, D, E, F, G, H, I, J> ten(
      A first,
      B second,
      C third,
      D fourth,
      E fifth,
      F sixth,
      G seventh,
      H eighth,
      I ninth,
      J tenth) {
    return of(first, second, third, fourth, fifth, sixth, seventh, eighth, ninth, tenth);
  }

  /**
   * Returns a new {@link ElevenTuple} from the provided values.
   *
   * @see #of(Object, Object, Object, Object, Object, Object, Object, Object, Object, Object,
   *     Object)
   */
  static <A, B, C, D, E, F, G, H, I, J, K, L>
      ElevenTuple<Object, A, B, C, D, E, F, G, H, I, J, K> eleven(
          A first,
          B second,
          C third,
          D fourth,
          E fifth,
          F sixth,
          G seventh,
          H eighth,
          I ninth,
          J tenth,
          K eleventh) {
    return of(first, second, third, fourth, fifth, sixth, seventh, eighth, ninth, tenth, eleventh);
  }

  /**
   * Returns a new {@link TwelveTuple} from the provided values.
   *
   * @see #of(Object, Object, Object, Object, Object, Object, Object, Object, Object, Object,
   *     Object, Object)
   */
  static <A, B, C, D, E, F, G, H, I, J, K, L>
      TwelveTuple<Object, A, B, C, D, E, F, G, H, I, J, K, L> twelve(
          A first,
          B second,
          C third,
          D fourth,
          E fifth,
          F sixth,
          G seventh,
          H eighth,
          I ninth,
          J tenth,
          K eleventh,
          L twelfth) {
    return of(
        first, second, third, fourth, fifth, sixth, seventh, eighth, ninth, tenth, eleventh,
        twelfth);
  }

  /**
   * Returns a new {@link ThirteenOrMoreTuple} from the provided values.
   *
   * @see #of(Object, Object, Object, Object, Object, Object, Object, Object, Object, Object,
   *     Object, Object, Object, Object[])
   */
  static <A, B, C, D, E, F, G, H, I, J, K, L>
      ThirteenOrMoreTuple<Object, A, B, C, D, E, F, G, H, I, J, K, L> large(
          A first,
          B second,
          C third,
          D fourth,
          E fifth,
          F sixth,
          G seventh,
          H eighth,
          I ninth,
          J tenth,
          K eleventh,
          L twelfth,
          Object thirteenth,
          Object... rest) {
    return of(
        first,
        second,
        third,
        fourth,
        fifth,
        sixth,
        seventh,
        eighth,
        ninth,
        tenth,
        eleventh,
        twelfth,
        thirteenth,
        rest);
  }

  /**
   * Returns a function that can extend an instance of {@link EmptyTuple} into an instance of {@link
   * OneTuple} using the provided value.
   *
   * <p>This is especially useful in functional contexts, for example:
   *
   * <pre>
   * oneTupleStream = emptyTupleStream.map(Tuple.extendEmpty(value));
   * </pre>
   */
  static <Z, X extends Z> Function<EmptyTuple<Z>, OneTuple<Z, X>> extendEmpty(X value) {
    return tuple -> tuple.extend(value);
  }

  /**
   * Returns a function that can extend an instance of {@link EmptyTuple} into an instance of {@link
   * OneTuple} using the value returned from the supplier.
   *
   * <p>This is especially useful in functional contexts, for example:
   *
   * <pre>
   * oneTupleStream = emptyTupleStream.map(Tuple.extendEmpty(() -&gt; value));
   * </pre>
   */
  static <Z, X extends Z> Function<EmptyTuple<Z>, OneTuple<Z, X>> extendEmpty(
      Supplier<X> supplier) {
    return tuple -> tuple.extend(supplier);
  }

  /**
   * Returns a function that can extend an instance of {@link EmptyTuple} into an instance of {@link
   * OneTuple} using the value returned from applying the provided function to the input tuple.
   *
   * <p>This is especially useful in functional contexts, for example:
   *
   * <pre>
   * oneTupleStream = emptyTupleStream.map(Tuple.extendEmpty(tuple -&gt; tuple.get(0)));
   * </pre>
   */
  static <Z, X extends Z> Function<EmptyTuple<Z>, OneTuple<Z, X>> extendEmpty(
      Function<EmptyTuple<Z>, X> function) {
    return tuple -> tuple.extend(function);
  }

  /**
   * Returns a function that can extend an instance of {@link OneTuple} into an instance of {@link
   * TwoTuple} using the provided value.
   *
   * <p>This is especially useful in functional contexts, for example:
   *
   * <pre>
   * twoTupleStream = oneTupleStream.map(Tuple.extendOne(value));
   * </pre>
   */
  static <Z, A extends Z, X extends Z> Function<OneTuple<Z, A>, TwoTuple<Z, A, X>> extendOne(
      X value) {
    return tuple -> tuple.extend(value);
  }

  /**
   * Returns a function that can extend an instance of {@link OneTuple} into an instance of {@link
   * TwoTuple} using the value returned from the supplier.
   *
   * <p>This is especially useful in functional contexts, for example:
   *
   * <pre>
   * twoTupleStream = oneTupleStream.map(Tuple.extendOne(() -&gt; value));
   * </pre>
   */
  static <Z, A extends Z, X extends Z> Function<OneTuple<Z, A>, TwoTuple<Z, A, X>> extendOne(
      Supplier<X> supplier) {
    return tuple -> tuple.extend(supplier);
  }

  /**
   * Returns a function that can extend an instance of {@link OneTuple} into an instance of {@link
   * TwoTuple} using the value returned from applying the provided function to the input tuple.
   *
   * <p>This is especially useful in functional contexts, for example:
   *
   * <pre>
   * twoTupleStream = oneTupleStream.map(Tuple.extendOne(tuple -&gt; tuple.get(0)));
   * </pre>
   */
  static <Z, A extends Z, X extends Z> Function<OneTuple<Z, A>, TwoTuple<Z, A, X>> extendOne(
      Function<OneTuple<Z, A>, X> function) {
    return tuple -> tuple.extend(function);
  }

  /**
   * Returns a function that can extend an instance of {@link TwoTuple} into an instance of {@link
   * ThreeTuple} using the provided value.
   *
   * <p>This is especially useful in functional contexts, for example:
   *
   * <pre>
   * threeTupleStream = twoTupleStream.map(Tuple.extendTwo(value));
   * </pre>
   */
  static <Z, A extends Z, B extends Z, X extends Z>
      Function<TwoTuple<Z, A, B>, ThreeTuple<Z, A, B, X>> extendTwo(X value) {
    return tuple -> tuple.extend(value);
  }

  /**
   * Returns a function that can extend an instance of {@link TwoTuple} into an instance of {@link
   * ThreeTuple} using the value returned from the supplier.
   *
   * <p>This is especially useful in functional contexts, for example:
   *
   * <pre>
   * threeTupleStream = twoTupleStream.map(Tuple.extendTwo(() -&gt; value));
   * </pre>
   */
  static <Z, A extends Z, B extends Z, X extends Z>
      Function<TwoTuple<Z, A, B>, ThreeTuple<Z, A, B, X>> extendTwo(Supplier<X> supplier) {
    return tuple -> tuple.extend(supplier);
  }

  /**
   * Returns a function that can extend an instance of {@link TwoTuple} into an instance of {@link
   * ThreeTuple} using the value returned from applying the provided function to the input tuple.
   *
   * <p>This is especially useful in functional contexts, for example:
   *
   * <pre>
   * threeTupleStream = twoTupleStream.map(Tuple.extendTwo(tuple -&gt; tuple.get(0)));
   * </pre>
   */
  static <Z, A extends Z, B extends Z, X extends Z>
      Function<TwoTuple<Z, A, B>, ThreeTuple<Z, A, B, X>> extendTwo(
          Function<TwoTuple<Z, A, B>, X> function) {
    return tuple -> tuple.extend(function);
  }

  /**
   * Returns a function that can extend an instance of {@link ThreeTuple} into an instance of {@link
   * FourTuple} using the provided value.
   *
   * <p>This is especially useful in functional contexts, for example:
   *
   * <pre>
   * fourTupleStream = threeTupleStream.map(Tuple.extendThree(value));
   * </pre>
   */
  static <Z, A extends Z, B extends Z, C extends Z, X extends Z>
      Function<ThreeTuple<Z, A, B, C>, FourTuple<Z, A, B, C, X>> extendThree(X value) {
    return tuple -> tuple.extend(value);
  }

  /**
   * Returns a function that can extend an instance of {@link ThreeTuple} into an instance of {@link
   * FourTuple} using the value returned from the supplier.
   *
   * <p>This is especially useful in functional contexts, for example:
   *
   * <pre>
   * fourTupleStream = threeTupleStream.map(Tuple.extendThree(() -&gt; value));
   * </pre>
   */
  static <Z, A extends Z, B extends Z, C extends Z, X extends Z>
      Function<ThreeTuple<Z, A, B, C>, FourTuple<Z, A, B, C, X>> extendThree(Supplier<X> supplier) {
    return tuple -> tuple.extend(supplier);
  }

  /**
   * Returns a function that can extend an instance of {@link ThreeTuple} into an instance of {@link
   * FourTuple} using the value returned from applying the provided function to the input tuple.
   *
   * <p>This is especially useful in functional contexts, for example:
   *
   * <pre>
   * fourTupleStream = threeTupleStream.map(Tuple.extendThree(tuple -&gt; tuple.get(0)));
   * </pre>
   */
  static <Z, A extends Z, B extends Z, C extends Z, X extends Z>
      Function<ThreeTuple<Z, A, B, C>, FourTuple<Z, A, B, C, X>> extendThree(
          Function<ThreeTuple<Z, A, B, C>, X> function) {
    return tuple -> tuple.extend(function);
  }

  /**
   * Returns a function that can extend an instance of {@link FourTuple} into an instance of {@link
   * FiveTuple} using the provided value.
   *
   * <p>This is especially useful in functional contexts, for example:
   *
   * <pre>
   * fiveTupleStream = fourTupleStream.map(Tuple.extendFour(value));
   * </pre>
   */
  static <Z, A extends Z, B extends Z, C extends Z, D extends Z, X extends Z>
      Function<FourTuple<Z, A, B, C, D>, FiveTuple<Z, A, B, C, D, X>> extendFour(X value) {
    return tuple -> tuple.extend(value);
  }

  /**
   * Returns a function that can extend an instance of {@link FourTuple} into an instance of {@link
   * FiveTuple} using the value returned from the supplier.
   *
   * <p>This is especially useful in functional contexts, for example:
   *
   * <pre>
   * fiveTupleStream = fourTupleStream.map(Tuple.extendFour(() -&gt; value));
   * </pre>
   */
  static <Z, A extends Z, B extends Z, C extends Z, D extends Z, X extends Z>
      Function<FourTuple<Z, A, B, C, D>, FiveTuple<Z, A, B, C, D, X>> extendFour(
          Supplier<X> supplier) {
    return tuple -> tuple.extend(supplier);
  }

  /**
   * Returns a function that can extend an instance of {@link FourTuple} into an instance of {@link
   * FiveTuple} using the value returned from applying the provided function to the input tuple.
   *
   * <p>This is especially useful in functional contexts, for example:
   *
   * <pre>
   * fiveTupleStream = fourTupleStream.map(Tuple.extendFour(tuple -&gt; tuple.get(0)));
   * </pre>
   */
  static <Z, A extends Z, B extends Z, C extends Z, D extends Z, X extends Z>
      Function<FourTuple<Z, A, B, C, D>, FiveTuple<Z, A, B, C, D, X>> extendFour(
          Function<FourTuple<Z, A, B, C, D>, X> function) {
    return tuple -> tuple.extend(function);
  }

  /**
   * Returns a function that can extend an instance of {@link FiveTuple} into an instance of {@link
   * SixTuple} using the provided value.
   *
   * <p>This is especially useful in functional contexts, for example:
   *
   * <pre>
   * sixTupleStream = fiveTupleStream.map(Tuple.extendFive(value));
   * </pre>
   */
  static <Z, A extends Z, B extends Z, C extends Z, D extends Z, E extends Z, X extends Z>
      Function<FiveTuple<Z, A, B, C, D, E>, SixTuple<Z, A, B, C, D, E, X>> extendFive(X value) {
    return tuple -> tuple.extend(value);
  }

  /**
   * Returns a function that can extend an instance of {@link FiveTuple} into an instance of {@link
   * SixTuple} using the value returned from the supplier.
   *
   * <p>This is especially useful in functional contexts, for example:
   *
   * <pre>
   * sixTupleStream = fiveTupleStream.map(Tuple.extendFive(() -&gt; value));
   * </pre>
   */
  static <Z, A extends Z, B extends Z, C extends Z, D extends Z, E extends Z, X extends Z>
      Function<FiveTuple<Z, A, B, C, D, E>, SixTuple<Z, A, B, C, D, E, X>> extendFive(
          Supplier<X> supplier) {
    return tuple -> tuple.extend(supplier);
  }

  /**
   * Returns a function that can extend an instance of {@link FiveTuple} into an instance of {@link
   * SixTuple} using the value returned from applying the provided function to the input tuple.
   *
   * <p>This is especially useful in functional contexts, for example:
   *
   * <pre>
   * sixTupleStream = fiveTupleStream.map(Tuple.extendFive(tuple -&gt; tuple.get(0)));
   * </pre>
   */
  static <Z, A extends Z, B extends Z, C extends Z, D extends Z, E extends Z, X extends Z>
      Function<FiveTuple<Z, A, B, C, D, E>, SixTuple<Z, A, B, C, D, E, X>> extendFive(
          Function<FiveTuple<Z, A, B, C, D, E>, X> function) {
    return tuple -> tuple.extend(function);
  }

  /**
   * Returns a function that can extend an instance of {@link SixTuple} into an instance of {@link
   * SevenTuple} using the provided value.
   *
   * <p>This is especially useful in functional contexts, for example:
   *
   * <pre>
   * sevenTupleStream = sixTupleStream.map(Tuple.extendSix(value));
   * </pre>
   */
  static <
          Z,
          A extends Z,
          B extends Z,
          C extends Z,
          D extends Z,
          E extends Z,
          F extends Z,
          X extends Z>
      Function<SixTuple<Z, A, B, C, D, E, F>, SevenTuple<Z, A, B, C, D, E, F, X>> extendSix(
          X value) {
    return tuple -> tuple.extend(value);
  }

  /**
   * Returns a function that can extend an instance of {@link SixTuple} into an instance of {@link
   * SevenTuple} using the value returned from the supplier.
   *
   * <p>This is especially useful in functional contexts, for example:
   *
   * <pre>
   * sevenTupleStream = sixTupleStream.map(Tuple.extendSix(() -&gt; value));
   * </pre>
   */
  static <
          Z,
          A extends Z,
          B extends Z,
          C extends Z,
          D extends Z,
          E extends Z,
          F extends Z,
          X extends Z>
      Function<SixTuple<Z, A, B, C, D, E, F>, SevenTuple<Z, A, B, C, D, E, F, X>> extendSix(
          Supplier<X> supplier) {
    return tuple -> tuple.extend(supplier);
  }

  /**
   * Returns a function that can extend an instance of {@link SixTuple} into an instance of {@link
   * SevenTuple} using the value returned from applying the provided function to the input tuple.
   *
   * <p>This is especially useful in functional contexts, for example:
   *
   * <pre>
   * sevenTupleStream = sixTupleStream.map(Tuple.extendSix(tuple -&gt; tuple.get(0)));
   * </pre>
   */
  static <
          Z,
          A extends Z,
          B extends Z,
          C extends Z,
          D extends Z,
          E extends Z,
          F extends Z,
          X extends Z>
      Function<SixTuple<Z, A, B, C, D, E, F>, SevenTuple<Z, A, B, C, D, E, F, X>> extendSix(
          Function<SixTuple<Z, A, B, C, D, E, F>, X> function) {
    return tuple -> tuple.extend(function);
  }

  /**
   * Returns a function that can extend an instance of {@link SevenTuple} into an instance of {@link
   * EightTuple} using the provided value.
   *
   * <p>This is especially useful in functional contexts, for example:
   *
   * <pre>
   * eightTupleStream = sevenTupleStream.map(Tuple.extendSeven(value));
   * </pre>
   */
  static <
          Z,
          A extends Z,
          B extends Z,
          C extends Z,
          D extends Z,
          E extends Z,
          F extends Z,
          G extends Z,
          X extends Z>
      Function<SevenTuple<Z, A, B, C, D, E, F, G>, EightTuple<Z, A, B, C, D, E, F, G, X>>
          extendSeven(X value) {
    return tuple -> tuple.extend(value);
  }

  /**
   * Returns a function that can extend an instance of {@link SevenTuple} into an instance of {@link
   * EightTuple} using the value returned from the supplier.
   *
   * <p>This is especially useful in functional contexts, for example:
   *
   * <pre>
   * eightTupleStream = sevenTupleStream.map(Tuple.extendSeven(() -&gt; value));
   * </pre>
   */
  static <
          Z,
          A extends Z,
          B extends Z,
          C extends Z,
          D extends Z,
          E extends Z,
          F extends Z,
          G extends Z,
          X extends Z>
      Function<SevenTuple<Z, A, B, C, D, E, F, G>, EightTuple<Z, A, B, C, D, E, F, G, X>>
          extendSeven(Supplier<X> supplier) {
    return tuple -> tuple.extend(supplier);
  }

  /**
   * Returns a function that can extend an instance of {@link SevenTuple} into an instance of {@link
   * EightTuple} using the value returned from applying the provided function to the input tuple.
   *
   * <p>This is especially useful in functional contexts, for example:
   *
   * <pre>
   * eightTupleStream = sevenTupleStream.map(Tuple.extendSeven(tuple -&gt; tuple.get(0)));
   * </pre>
   */
  static <
          Z,
          A extends Z,
          B extends Z,
          C extends Z,
          D extends Z,
          E extends Z,
          F extends Z,
          G extends Z,
          X extends Z>
      Function<SevenTuple<Z, A, B, C, D, E, F, G>, EightTuple<Z, A, B, C, D, E, F, G, X>>
          extendSeven(Function<SevenTuple<Z, A, B, C, D, E, F, G>, X> function) {
    return tuple -> tuple.extend(function);
  }

  /**
   * Returns a function that can extend an instance of {@link EightTuple} into an instance of {@link
   * NineTuple} using the provided value.
   *
   * <p>This is especially useful in functional contexts, for example:
   *
   * <pre>
   * nineTupleStream = eightTupleStream.map(Tuple.extendEight(value));
   * </pre>
   */
  static <
          Z,
          A extends Z,
          B extends Z,
          C extends Z,
          D extends Z,
          E extends Z,
          F extends Z,
          G extends Z,
          H extends Z,
          X extends Z>
      Function<EightTuple<Z, A, B, C, D, E, F, G, H>, NineTuple<Z, A, B, C, D, E, F, G, H, X>>
          extendEight(X value) {
    return tuple -> tuple.extend(value);
  }

  /**
   * Returns a function that can extend an instance of {@link EightTuple} into an instance of {@link
   * NineTuple} using the value returned from the supplier.
   *
   * <p>This is especially useful in functional contexts, for example:
   *
   * <pre>
   * nineTupleStream = eightTupleStream.map(Tuple.extendEight(() -&gt; value));
   * </pre>
   */
  static <
          Z,
          A extends Z,
          B extends Z,
          C extends Z,
          D extends Z,
          E extends Z,
          F extends Z,
          G extends Z,
          H extends Z,
          X extends Z>
      Function<EightTuple<Z, A, B, C, D, E, F, G, H>, NineTuple<Z, A, B, C, D, E, F, G, H, X>>
          extendEight(Supplier<X> supplier) {
    return tuple -> tuple.extend(supplier);
  }

  /**
   * Returns a function that can extend an instance of {@link EightTuple} into an instance of {@link
   * NineTuple} using the value returned from applying the provided function to the input tuple.
   *
   * <p>This is especially useful in functional contexts, for example:
   *
   * <pre>
   * nineTupleStream = eightTupleStream.map(Tuple.extendEight(tuple -&gt; tuple.get(0)));
   * </pre>
   */
  static <
          Z,
          A extends Z,
          B extends Z,
          C extends Z,
          D extends Z,
          E extends Z,
          F extends Z,
          G extends Z,
          H extends Z,
          X extends Z>
      Function<EightTuple<Z, A, B, C, D, E, F, G, H>, NineTuple<Z, A, B, C, D, E, F, G, H, X>>
          extendEight(Function<EightTuple<Z, A, B, C, D, E, F, G, H>, X> function) {
    return tuple -> tuple.extend(function);
  }

  /**
   * Returns a function that can extend an instance of {@link NineTuple} into an instance of {@link
   * TenTuple} using the provided value.
   *
   * <p>This is especially useful in functional contexts, for example:
   *
   * <pre>
   * tenTupleStream = nineTupleStream.map(Tuple.extendNine(value));
   * </pre>
   */
  static <
          Z,
          A extends Z,
          B extends Z,
          C extends Z,
          D extends Z,
          E extends Z,
          F extends Z,
          G extends Z,
          H extends Z,
          I extends Z,
          X extends Z>
      Function<NineTuple<Z, A, B, C, D, E, F, G, H, I>, TenTuple<Z, A, B, C, D, E, F, G, H, I, X>>
          extendNine(X value) {
    return tuple -> tuple.extend(value);
  }

  /**
   * Returns a function that can extend an instance of {@link NineTuple} into an instance of {@link
   * TenTuple} using the value returned from the supplier.
   *
   * <p>This is especially useful in functional contexts, for example:
   *
   * <pre>
   * tenTupleStream = nineTupleStream.map(Tuple.extendNine(() -&gt; value));
   * </pre>
   */
  static <
          Z,
          A extends Z,
          B extends Z,
          C extends Z,
          D extends Z,
          E extends Z,
          F extends Z,
          G extends Z,
          H extends Z,
          I extends Z,
          X extends Z>
      Function<NineTuple<Z, A, B, C, D, E, F, G, H, I>, TenTuple<Z, A, B, C, D, E, F, G, H, I, X>>
          extendNine(Supplier<X> supplier) {
    return tuple -> tuple.extend(supplier);
  }

  /**
   * Returns a function that can extend an instance of {@link NineTuple} into an instance of {@link
   * TenTuple} using the value returned from applying the provided function to the input tuple.
   *
   * <p>This is especially useful in functional contexts, for example:
   *
   * <pre>
   * tenTupleStream = nineTupleStream.map(Tuple.extendNine(tuple -&gt; tuple.get(0)));
   * </pre>
   */
  static <
          Z,
          A extends Z,
          B extends Z,
          C extends Z,
          D extends Z,
          E extends Z,
          F extends Z,
          G extends Z,
          H extends Z,
          I extends Z,
          X extends Z>
      Function<NineTuple<Z, A, B, C, D, E, F, G, H, I>, TenTuple<Z, A, B, C, D, E, F, G, H, I, X>>
          extendNine(Function<NineTuple<Z, A, B, C, D, E, F, G, H, I>, X> function) {
    return tuple -> tuple.extend(function);
  }

  /**
   * Returns a function that can extend an instance of {@link TenTuple} into an instance of {@link
   * ElevenTuple} using the provided value.
   *
   * <p>This is especially useful in functional contexts, for example:
   *
   * <pre>
   * elevenTupleStream = tenTupleStream.map(Tuple.extendTen(value));
   * </pre>
   */
  static <
          Z,
          A extends Z,
          B extends Z,
          C extends Z,
          D extends Z,
          E extends Z,
          F extends Z,
          G extends Z,
          H extends Z,
          I extends Z,
          J extends Z,
          X extends Z>
      Function<
              TenTuple<Z, A, B, C, D, E, F, G, H, I, J>,
              ElevenTuple<Z, A, B, C, D, E, F, G, H, I, J, X>>
          extendTen(X value) {
    return tuple -> tuple.extend(value);
  }

  /**
   * Returns a function that can extend an instance of {@link TenTuple} into an instance of {@link
   * ElevenTuple} using the value returned from the supplier.
   *
   * <p>This is especially useful in functional contexts, for example:
   *
   * <pre>
   * elevenTupleStream = tenTupleStream.map(Tuple.extendTen(() -&gt; value));
   * </pre>
   */
  static <
          Z,
          A extends Z,
          B extends Z,
          C extends Z,
          D extends Z,
          E extends Z,
          F extends Z,
          G extends Z,
          H extends Z,
          I extends Z,
          J extends Z,
          X extends Z>
      Function<
              TenTuple<Z, A, B, C, D, E, F, G, H, I, J>,
              ElevenTuple<Z, A, B, C, D, E, F, G, H, I, J, X>>
          extendTen(Supplier<X> supplier) {
    return tuple -> tuple.extend(supplier);
  }

  /**
   * Returns a function that can extend an instance of {@link TenTuple} into an instance of {@link
   * ElevenTuple} using the value returned from applying the provided function to the input tuple.
   *
   * <p>This is especially useful in functional contexts, for example:
   *
   * <pre>
   * elevenTupleStream = tenTupleStream.map(Tuple.extendTen(tuple -&gt; tuple.get(0)));
   * </pre>
   */
  static <
          Z,
          A extends Z,
          B extends Z,
          C extends Z,
          D extends Z,
          E extends Z,
          F extends Z,
          G extends Z,
          H extends Z,
          I extends Z,
          J extends Z,
          X extends Z>
      Function<
              TenTuple<Z, A, B, C, D, E, F, G, H, I, J>,
              ElevenTuple<Z, A, B, C, D, E, F, G, H, I, J, X>>
          extendTen(Function<TenTuple<Z, A, B, C, D, E, F, G, H, I, J>, X> function) {
    return tuple -> tuple.extend(function);
  }

  /**
   * Returns a function that can extend an instance of {@link ElevenTuple} into an instance of
   * {@link TwelveTuple} using the provided value.
   *
   * <p>This is especially useful in functional contexts, for example:
   *
   * <pre>
   * twelveTupleStream = elevenTupleStream.map(Tuple.extendEleven(value));
   * </pre>
   */
  static <
          Z,
          A extends Z,
          B extends Z,
          C extends Z,
          D extends Z,
          E extends Z,
          F extends Z,
          G extends Z,
          H extends Z,
          I extends Z,
          J extends Z,
          K extends Z,
          X extends Z>
      Function<
              ElevenTuple<Z, A, B, C, D, E, F, G, H, I, J, K>,
              TwelveTuple<Z, A, B, C, D, E, F, G, H, I, J, K, X>>
          extendEleven(X value) {
    return tuple -> tuple.extend(value);
  }

  /**
   * Returns a function that can extend an instance of {@link ElevenTuple} into an instance of
   * {@link TwelveTuple} using the value returned from the supplier.
   *
   * <p>This is especially useful in functional contexts, for example:
   *
   * <pre>
   * twelveTupleStream = elevenTupleStream.map(Tuple.extendEleven(() -&gt; value));
   * </pre>
   */
  static <
          Z,
          A extends Z,
          B extends Z,
          C extends Z,
          D extends Z,
          E extends Z,
          F extends Z,
          G extends Z,
          H extends Z,
          I extends Z,
          J extends Z,
          K extends Z,
          X extends Z>
      Function<
              ElevenTuple<Z, A, B, C, D, E, F, G, H, I, J, K>,
              TwelveTuple<Z, A, B, C, D, E, F, G, H, I, J, K, X>>
          extendEleven(Supplier<X> supplier) {
    return tuple -> tuple.extend(supplier);
  }

  /**
   * Returns a function that can extend an instance of {@link ElevenTuple} into an instance of
   * {@link TwelveTuple} using the value returned from applying the provided function to the input
   * tuple.
   *
   * <p>This is especially useful in functional contexts, for example:
   *
   * <pre>
   * twelveTupleStream = elevenTupleStream.map(Tuple.extendEleven(tuple -&gt; tuple.get(0)));
   * </pre>
   */
  static <
          Z,
          A extends Z,
          B extends Z,
          C extends Z,
          D extends Z,
          E extends Z,
          F extends Z,
          G extends Z,
          H extends Z,
          I extends Z,
          J extends Z,
          K extends Z,
          X extends Z>
      Function<
              ElevenTuple<Z, A, B, C, D, E, F, G, H, I, J, K>,
              TwelveTuple<Z, A, B, C, D, E, F, G, H, I, J, K, X>>
          extendEleven(Function<ElevenTuple<Z, A, B, C, D, E, F, G, H, I, J, K>, X> function) {
    return tuple -> tuple.extend(function);
  }

  /**
   * Returns a function that can extend an instance of {@link TwelveTuple} into an instance of
   * {@link ThirteenOrMoreTuple} using the provided value.
   *
   * <p>This is especially useful in functional contexts, for example:
   *
   * <pre>
   * thirteenOrMoreTupleStream = twelveTupleStream.map(Tuple.extendTwelve(value));
   * </pre>
   */
  static <
          Z,
          A extends Z,
          B extends Z,
          C extends Z,
          D extends Z,
          E extends Z,
          F extends Z,
          G extends Z,
          H extends Z,
          I extends Z,
          J extends Z,
          K extends Z,
          L extends Z,
          X extends Z>
      Function<
              TwelveTuple<Z, A, B, C, D, E, F, G, H, I, J, K, L>,
              ThirteenOrMoreTuple<Z, A, B, C, D, E, F, G, H, I, J, K, L>>
          extendTwelve(X value) {
    return tuple -> tuple.extend(value);
  }

  /**
   * Returns a function that can extend an instance of {@link TwelveTuple} into an instance of
   * {@link ThirteenOrMoreTuple} using the value returned from the supplier.
   *
   * <p>This is especially useful in functional contexts, for example:
   *
   * <pre>
   * thirteenOrMoreTupleStream = twelveTupleStream.map(Tuple.extendTwelve(() -&gt; value));
   * </pre>
   */
  static <
          Z,
          A extends Z,
          B extends Z,
          C extends Z,
          D extends Z,
          E extends Z,
          F extends Z,
          G extends Z,
          H extends Z,
          I extends Z,
          J extends Z,
          K extends Z,
          L extends Z,
          X extends Z>
      Function<
              TwelveTuple<Z, A, B, C, D, E, F, G, H, I, J, K, L>,
              ThirteenOrMoreTuple<Z, A, B, C, D, E, F, G, H, I, J, K, L>>
          extendTwelve(Supplier<X> supplier) {
    return tuple -> tuple.extend(supplier);
  }

  /**
   * Returns a function that can extend an instance of {@link TwelveTuple} into an instance of
   * {@link ThirteenOrMoreTuple} using the value returned from applying the provided function to the
   * input tuple.
   *
   * <p>This is especially useful in functional contexts, for example:
   *
   * <pre>
   * thirteenOrMoreTupleStream = twelveTupleStream.map(Tuple.extendTwelve(tuple -&gt; tuple.get(0)));
   * </pre>
   */
  static <
          Z,
          A extends Z,
          B extends Z,
          C extends Z,
          D extends Z,
          E extends Z,
          F extends Z,
          G extends Z,
          H extends Z,
          I extends Z,
          J extends Z,
          K extends Z,
          L extends Z,
          X extends Z>
      Function<
              TwelveTuple<Z, A, B, C, D, E, F, G, H, I, J, K, L>,
              ThirteenOrMoreTuple<Z, A, B, C, D, E, F, G, H, I, J, K, L>>
          extendTwelve(Function<TwelveTuple<Z, A, B, C, D, E, F, G, H, I, J, K, L>, X> function) {
    return tuple -> tuple.extend(function);
  }

  /**
   * Returns a function that can extend an instance of {@link ThirteenOrMoreTuple} into another
   * instance of {@link ThirteenOrMoreTuple} using the provided value.
   *
   * <p>This is especially useful in functional contexts, for example:
   *
   * <pre>
   * stream1 = stream2.map(Tuple.extendLarge(value));
   * </pre>
   */
  static <
          Z,
          A extends Z,
          B extends Z,
          C extends Z,
          D extends Z,
          E extends Z,
          F extends Z,
          G extends Z,
          H extends Z,
          I extends Z,
          J extends Z,
          K extends Z,
          L extends Z,
          X extends Z>
      Function<
              ThirteenOrMoreTuple<Z, A, B, C, D, E, F, G, H, I, J, K, L>,
              ThirteenOrMoreTuple<Z, A, B, C, D, E, F, G, H, I, J, K, L>>
          extendLarge(X value) {
    return tuple -> tuple.extend(value);
  }

  /**
   * Returns a function that can extend an instance of {@link ThirteenOrMoreTuple} into another
   * instance of {@link ThirteenOrMoreTuple} using the value returned from the supplier.
   *
   * <p>This is especially useful in functional contexts, for example:
   *
   * <pre>
   * stream1 = stream2.map(Tuple.extendLarge(() -&gt; value));
   * </pre>
   */
  static <
          Z,
          A extends Z,
          B extends Z,
          C extends Z,
          D extends Z,
          E extends Z,
          F extends Z,
          G extends Z,
          H extends Z,
          I extends Z,
          J extends Z,
          K extends Z,
          L extends Z,
          X extends Z>
      Function<
              ThirteenOrMoreTuple<Z, A, B, C, D, E, F, G, H, I, J, K, L>,
              ThirteenOrMoreTuple<Z, A, B, C, D, E, F, G, H, I, J, K, L>>
          extendLarge(Supplier<X> supplier) {
    return tuple -> tuple.extend(supplier);
  }

  /**
   * Returns a function that can extend an instance of {@link ThirteenOrMoreTuple} into another
   * instance of {@link ThirteenOrMoreTuple} using the value returned from applying the provided
   * function to the input tuple.
   *
   * <p>This is especially useful in functional contexts, for example:
   *
   * <pre>
   * stream1 = stream2.map(Tuple.extendLarge(tuple -&gt; tuple.get(0)));
   * </pre>
   */
  static <
          Z,
          A extends Z,
          B extends Z,
          C extends Z,
          D extends Z,
          E extends Z,
          F extends Z,
          G extends Z,
          H extends Z,
          I extends Z,
          J extends Z,
          K extends Z,
          L extends Z,
          X extends Z>
      Function<
              ThirteenOrMoreTuple<Z, A, B, C, D, E, F, G, H, I, J, K, L>,
              ThirteenOrMoreTuple<Z, A, B, C, D, E, F, G, H, I, J, K, L>>
          extendLarge(
              Function<ThirteenOrMoreTuple<Z, A, B, C, D, E, F, G, H, I, J, K, L>, X> function) {
    return tuple -> tuple.extend(function);
  }

  /**
   * Returns a function that can map the first element of the tuple into the provided value.
   *
   * <p><strong>NB:</strong> This method erases the type signature of the input tuple. If you need
   * to preserve the type signatures, please use {@link HasFirst#first(Object)}:
   *
   * <pre>
   * stream.map(tuple -&gt; tuple.first(value))
   * </pre>
   */
  @SuppressWarnings("unchecked")
  static <Z, A extends Z, X extends Z, T extends HasFirst<Z, A, T>, U extends HasFirst<Z, X, U>>
      Function<T, U> mapFirst(X value) {
    return tuple -> (U) tuple.first(value);
  }

  /**
   * Returns a function that can map the first element of the tuple into the value returned from the
   * supplier.
   *
   * <p><strong>NB:</strong> This method erases the type signature of the input tuple. If you need
   * to preserve the type signatures, please use {@link HasFirst#first(Supplier)}:
   *
   * <pre>
   * stream.map(tuple -&gt; tuple.first(supplier))
   * </pre>
   */
  @SuppressWarnings("unchecked")
  static <Z, A extends Z, X extends Z, T extends HasFirst<Z, A, T>, U extends HasFirst<Z, X, U>>
      Function<T, U> mapFirst(Supplier<X> supplier) {
    return tuple -> (U) tuple.first(supplier);
  }

  /**
   * Returns a function that can map the first element of the tuple into the value returned after
   * applying the provided function to the input tuple.
   *
   * <p><strong>NB:</strong> This method erases the type signature of the input tuple. If you need
   * to preserve the type signatures, please use {@link HasFirst#first(Function)}:
   *
   * <pre>
   * stream.map(tuple -&gt; tuple.first(function))
   * </pre>
   */
  @SuppressWarnings("unchecked")
  static <Z, A extends Z, X extends Z, T extends HasFirst<Z, A, T>, U extends HasFirst<Z, X, U>>
      Function<T, U> mapFirst(Function<A, X> function) {
    return tuple -> (U) tuple.first(function);
  }

  /**
   * Returns a function that can map the second element of the tuple into the provided value.
   *
   * <p><strong>NB:</strong> This method erases the type signature of the input tuple. If you need
   * to preserve the type signatures, please use {@link HasSecond#second(Object)}:
   *
   * <pre>
   * stream.map(tuple -&gt; tuple.second(value))
   * </pre>
   */
  @SuppressWarnings("unchecked")
  static <Z, A extends Z, X extends Z, T extends HasSecond<Z, A, T>, U extends HasSecond<Z, X, U>>
      Function<T, U> mapSecond(X value) {
    return tuple -> (U) tuple.second(value);
  }

  /**
   * Returns a function that can map the second element of the tuple into the value returned from
   * the supplier.
   *
   * <p><strong>NB:</strong> This method erases the type signature of the input tuple. If you need
   * to preserve the type signatures, please use {@link HasSecond#second(Supplier)}:
   *
   * <pre>
   * stream.map(tuple -&gt; tuple.second(supplier))
   * </pre>
   */
  @SuppressWarnings("unchecked")
  static <Z, A extends Z, X extends Z, T extends HasSecond<Z, A, T>, U extends HasSecond<Z, X, U>>
      Function<T, U> mapSecond(Supplier<X> supplier) {
    return tuple -> (U) tuple.second(supplier);
  }

  /**
   * Returns a function that can map the second element of the tuple into the value returned after
   * applying the provided function to the input tuple.
   *
   * <p><strong>NB:</strong> This method erases the type signature of the input tuple. If you need
   * to preserve the type signatures, please use {@link HasSecond#second(Function)}:
   *
   * <pre>
   * stream.map(tuple -&gt; tuple.second(function))
   * </pre>
   */
  @SuppressWarnings("unchecked")
  static <Z, A extends Z, X extends Z, T extends HasSecond<Z, A, T>, U extends HasSecond<Z, X, U>>
      Function<T, U> mapSecond(Function<A, X> function) {
    return tuple -> (U) tuple.second(function);
  }

  /**
   * Returns a function that can map the third element of the tuple into the provided value.
   *
   * <p><strong>NB:</strong> This method erases the type signature of the input tuple. If you need
   * to preserve the type signatures, please use {@link HasThird#third(Object)}:
   *
   * <pre>
   * stream.map(tuple -&gt; tuple.third(value))
   * </pre>
   */
  @SuppressWarnings("unchecked")
  static <Z, A extends Z, X extends Z, T extends HasThird<Z, A, T>, U extends HasThird<Z, X, U>>
      Function<T, U> mapThird(X value) {
    return tuple -> (U) tuple.third(value);
  }

  /**
   * Returns a function that can map the third element of the tuple into the value returned from the
   * supplier.
   *
   * <p><strong>NB:</strong> This method erases the type signature of the input tuple. If you need
   * to preserve the type signatures, please use {@link HasThird#third(Supplier)}:
   *
   * <pre>
   * stream.map(tuple -&gt; tuple.third(supplier))
   * </pre>
   */
  @SuppressWarnings("unchecked")
  static <Z, A extends Z, X extends Z, T extends HasThird<Z, A, T>, U extends HasThird<Z, X, U>>
      Function<T, U> mapThird(Supplier<X> supplier) {
    return tuple -> (U) tuple.third(supplier);
  }

  /**
   * Returns a function that can map the third element of the tuple into the value returned after
   * applying the provided function to the input tuple.
   *
   * <p><strong>NB:</strong> This method erases the type signature of the input tuple. If you need
   * to preserve the type signatures, please use {@link HasThird#third(Function)}:
   *
   * <pre>
   * stream.map(tuple -&gt; tuple.third(function))
   * </pre>
   */
  @SuppressWarnings("unchecked")
  static <Z, A extends Z, X extends Z, T extends HasThird<Z, A, T>, U extends HasThird<Z, X, U>>
      Function<T, U> mapThird(Function<A, X> function) {
    return tuple -> (U) tuple.third(function);
  }

  /**
   * Returns a function that can map the fourth element of the tuple into the provided value.
   *
   * <p><strong>NB:</strong> This method erases the type signature of the input tuple. If you need
   * to preserve the type signatures, please use {@link HasFourth#fourth(Object)}:
   *
   * <pre>
   * stream.map(tuple -&gt; tuple.fourth(value))
   * </pre>
   */
  @SuppressWarnings("unchecked")
  static <Z, A extends Z, X extends Z, T extends HasFourth<Z, A, T>, U extends HasFourth<Z, X, U>>
      Function<T, U> mapFourth(X value) {
    return tuple -> (U) tuple.fourth(value);
  }

  /**
   * Returns a function that can map the fourth element of the tuple into the value returned from
   * the supplier.
   *
   * <p><strong>NB:</strong> This method erases the type signature of the input tuple. If you need
   * to preserve the type signatures, please use {@link HasFourth#fourth(Supplier)}:
   *
   * <pre>
   * stream.map(tuple -&gt; tuple.fourth(supplier))
   * </pre>
   */
  @SuppressWarnings("unchecked")
  static <Z, A extends Z, X extends Z, T extends HasFourth<Z, A, T>, U extends HasFourth<Z, X, U>>
      Function<T, U> mapFourth(Supplier<X> supplier) {
    return tuple -> (U) tuple.fourth(supplier);
  }

  /**
   * Returns a function that can map the fourth element of the tuple into the value returned after
   * applying the provided function to the input tuple.
   *
   * <p><strong>NB:</strong> This method erases the type signature of the input tuple. If you need
   * to preserve the type signatures, please use {@link HasFourth#fourth(Function)}:
   *
   * <pre>
   * stream.map(tuple -&gt; tuple.fourth(function))
   * </pre>
   */
  @SuppressWarnings("unchecked")
  static <Z, A extends Z, X extends Z, T extends HasFourth<Z, A, T>, U extends HasFourth<Z, X, U>>
      Function<T, U> mapFourth(Function<A, X> function) {
    return tuple -> (U) tuple.fourth(function);
  }

  /**
   * Returns a function that can map the fifth element of the tuple into the provided value.
   *
   * <p><strong>NB:</strong> This method erases the type signature of the input tuple. If you need
   * to preserve the type signatures, please use {@link HasFifth#fifth(Object)}:
   *
   * <pre>
   * stream.map(tuple -&gt; tuple.fifth(value))
   * </pre>
   */
  @SuppressWarnings("unchecked")
  static <Z, A extends Z, X extends Z, T extends HasFifth<Z, A, T>, U extends HasFifth<Z, X, U>>
      Function<T, U> mapFifth(X value) {
    return tuple -> (U) tuple.fifth(value);
  }

  /**
   * Returns a function that can map the fifth element of the tuple into the value returned from the
   * supplier.
   *
   * <p><strong>NB:</strong> This method erases the type signature of the input tuple. If you need
   * to preserve the type signatures, please use {@link HasFifth#fifth(Supplier)}:
   *
   * <pre>
   * stream.map(tuple -&gt; tuple.fifth(supplier))
   * </pre>
   */
  @SuppressWarnings("unchecked")
  static <Z, A extends Z, X extends Z, T extends HasFifth<Z, A, T>, U extends HasFifth<Z, X, U>>
      Function<T, U> mapFifth(Supplier<X> supplier) {
    return tuple -> (U) tuple.fifth(supplier);
  }

  /**
   * Returns a function that can map the fifth element of the tuple into the value returned after
   * applying the provided function to the input tuple.
   *
   * <p><strong>NB:</strong> This method erases the type signature of the input tuple. If you need
   * to preserve the type signatures, please use {@link HasFifth#fifth(Function)}:
   *
   * <pre>
   * stream.map(tuple -&gt; tuple.fifth(function))
   * </pre>
   */
  @SuppressWarnings("unchecked")
  static <Z, A extends Z, X extends Z, T extends HasFifth<Z, A, T>, U extends HasFifth<Z, X, U>>
      Function<T, U> mapFifth(Function<A, X> function) {
    return tuple -> (U) tuple.fifth(function);
  }

  /**
   * Returns a function that can map the sixth element of the tuple into the provided value.
   *
   * <p><strong>NB:</strong> This method erases the type signature of the input tuple. If you need
   * to preserve the type signatures, please use {@link HasSixth#sixth(Object)}:
   *
   * <pre>
   * stream.map(tuple -&gt; tuple.sixth(value))
   * </pre>
   */
  @SuppressWarnings("unchecked")
  static <Z, A extends Z, X extends Z, T extends HasSixth<Z, A, T>, U extends HasSixth<Z, X, U>>
      Function<T, U> mapSixth(X value) {
    return tuple -> (U) tuple.sixth(value);
  }

  /**
   * Returns a function that can map the sixth element of the tuple into the value returned from the
   * supplier.
   *
   * <p><strong>NB:</strong> This method erases the type signature of the input tuple. If you need
   * to preserve the type signatures, please use {@link HasSixth#sixth(Supplier)}:
   *
   * <pre>
   * stream.map(tuple -&gt; tuple.sixth(supplier))
   * </pre>
   */
  @SuppressWarnings("unchecked")
  static <Z, A extends Z, X extends Z, T extends HasSixth<Z, A, T>, U extends HasSixth<Z, X, U>>
      Function<T, U> mapSixth(Supplier<X> supplier) {
    return tuple -> (U) tuple.sixth(supplier);
  }

  /**
   * Returns a function that can map the sixth element of the tuple into the value returned after
   * applying the provided function to the input tuple.
   *
   * <p><strong>NB:</strong> This method erases the type signature of the input tuple. If you need
   * to preserve the type signatures, please use {@link HasSixth#sixth(Function)}:
   *
   * <pre>
   * stream.map(tuple -&gt; tuple.sixth(function))
   * </pre>
   */
  @SuppressWarnings("unchecked")
  static <Z, A extends Z, X extends Z, T extends HasSixth<Z, A, T>, U extends HasSixth<Z, X, U>>
      Function<T, U> mapSixth(Function<A, X> function) {
    return tuple -> (U) tuple.sixth(function);
  }

  /**
   * Returns a function that can map the seventh element of the tuple into the provided value.
   *
   * <p><strong>NB:</strong> This method erases the type signature of the input tuple. If you need
   * to preserve the type signatures, please use {@link HasSeventh#seventh(Object)}:
   *
   * <pre>
   * stream.map(tuple -&gt; tuple.seventh(value))
   * </pre>
   */
  @SuppressWarnings("unchecked")
  static <Z, A extends Z, X extends Z, T extends HasSeventh<Z, A, T>, U extends HasSeventh<Z, X, U>>
      Function<T, U> mapSeventh(X value) {
    return tuple -> (U) tuple.seventh(value);
  }

  /**
   * Returns a function that can map the seventh element of the tuple into the value returned from
   * the supplier.
   *
   * <p><strong>NB:</strong> This method erases the type signature of the input tuple. If you need
   * to preserve the type signatures, please use {@link HasSeventh#seventh(Supplier)}:
   *
   * <pre>
   * stream.map(tuple -&gt; tuple.seventh(supplier))
   * </pre>
   */
  @SuppressWarnings("unchecked")
  static <Z, A extends Z, X extends Z, T extends HasSeventh<Z, A, T>, U extends HasSeventh<Z, X, U>>
      Function<T, U> mapSeventh(Supplier<X> supplier) {
    return tuple -> (U) tuple.seventh(supplier);
  }

  /**
   * Returns a function that can map the seventh element of the tuple into the value returned after
   * applying the provided function to the input tuple.
   *
   * <p><strong>NB:</strong> This method erases the type signature of the input tuple. If you need
   * to preserve the type signatures, please use {@link HasSeventh#seventh(Function)}:
   *
   * <pre>
   * stream.map(tuple -&gt; tuple.seventh(function))
   * </pre>
   */
  @SuppressWarnings("unchecked")
  static <Z, A extends Z, X extends Z, T extends HasSeventh<Z, A, T>, U extends HasSeventh<Z, X, U>>
      Function<T, U> mapSeventh(Function<A, X> function) {
    return tuple -> (U) tuple.seventh(function);
  }

  /**
   * Returns a function that can map the eighth element of the tuple into the provided value.
   *
   * <p><strong>NB:</strong> This method erases the type signature of the input tuple. If you need
   * to preserve the type signatures, please use {@link HasEighth#eighth(Object)}:
   *
   * <pre>
   * stream.map(tuple -&gt; tuple.eighth(value))
   * </pre>
   */
  @SuppressWarnings("unchecked")
  static <Z, A extends Z, X extends Z, T extends HasEighth<Z, A, T>, U extends HasEighth<Z, X, U>>
      Function<T, U> mapEighth(X value) {
    return tuple -> (U) tuple.eighth(value);
  }

  /**
   * Returns a function that can map the eighth element of the tuple into the value returned from
   * the supplier.
   *
   * <p><strong>NB:</strong> This method erases the type signature of the input tuple. If you need
   * to preserve the type signatures, please use {@link HasEighth#eighth(Supplier)}:
   *
   * <pre>
   * stream.map(tuple -&gt; tuple.eighth(supplier))
   * </pre>
   */
  @SuppressWarnings("unchecked")
  static <Z, A extends Z, X extends Z, T extends HasEighth<Z, A, T>, U extends HasEighth<Z, X, U>>
      Function<T, U> mapEighth(Supplier<X> supplier) {
    return tuple -> (U) tuple.eighth(supplier);
  }

  /**
   * Returns a function that can map the eighth element of the tuple into the value returned after
   * applying the provided function to the input tuple.
   *
   * <p><strong>NB:</strong> This method erases the type signature of the input tuple. If you need
   * to preserve the type signatures, please use {@link HasEighth#eighth(Function)}:
   *
   * <pre>
   * stream.map(tuple -&gt; tuple.eighth(function))
   * </pre>
   */
  @SuppressWarnings("unchecked")
  static <Z, A extends Z, X extends Z, T extends HasEighth<Z, A, T>, U extends HasEighth<Z, X, U>>
      Function<T, U> mapEighth(Function<A, X> function) {
    return tuple -> (U) tuple.eighth(function);
  }

  /**
   * Returns a function that can map the ninth element of the tuple into the provided value.
   *
   * <p><strong>NB:</strong> This method erases the type signature of the input tuple. If you need
   * to preserve the type signatures, please use {@link HasNinth#ninth(Object)}:
   *
   * <pre>
   * stream.map(tuple -&gt; tuple.ninth(value))
   * </pre>
   */
  @SuppressWarnings("unchecked")
  static <Z, A extends Z, X extends Z, T extends HasNinth<Z, A, T>, U extends HasNinth<Z, X, U>>
      Function<T, U> mapNinth(X value) {
    return tuple -> (U) tuple.ninth(value);
  }

  /**
   * Returns a function that can map the ninth element of the tuple into the value returned from the
   * supplier.
   *
   * <p><strong>NB:</strong> This method erases the type signature of the input tuple. If you need
   * to preserve the type signatures, please use {@link HasNinth#ninth(Supplier)}:
   *
   * <pre>
   * stream.map(tuple -&gt; tuple.ninth(supplier))
   * </pre>
   */
  @SuppressWarnings("unchecked")
  static <Z, A extends Z, X extends Z, T extends HasNinth<Z, A, T>, U extends HasNinth<Z, X, U>>
      Function<T, U> mapNinth(Supplier<X> supplier) {
    return tuple -> (U) tuple.ninth(supplier);
  }

  /**
   * Returns a function that can map the ninth element of the tuple into the value returned after
   * applying the provided function to the input tuple.
   *
   * <p><strong>NB:</strong> This method erases the type signature of the input tuple. If you need
   * to preserve the type signatures, please use {@link HasNinth#ninth(Function)}:
   *
   * <pre>
   * stream.map(tuple -&gt; tuple.ninth(function))
   * </pre>
   */
  @SuppressWarnings("unchecked")
  static <Z, A extends Z, X extends Z, T extends HasNinth<Z, A, T>, U extends HasNinth<Z, X, U>>
      Function<T, U> mapNinth(Function<A, X> function) {
    return tuple -> (U) tuple.ninth(function);
  }

  /**
   * Returns a function that can map the tenth element of the tuple into the provided value.
   *
   * <p><strong>NB:</strong> This method erases the type signature of the input tuple. If you need
   * to preserve the type signatures, please use {@link HasTenth#tenth(Object)}:
   *
   * <pre>
   * stream.map(tuple -&gt; tuple.tenth(value))
   * </pre>
   */
  @SuppressWarnings("unchecked")
  static <Z, A extends Z, X extends Z, T extends HasTenth<Z, A, T>, U extends HasTenth<Z, X, U>>
      Function<T, U> mapTenth(X value) {
    return tuple -> (U) tuple.tenth(value);
  }

  /**
   * Returns a function that can map the tenth element of the tuple into the value returned from the
   * supplier.
   *
   * <p><strong>NB:</strong> This method erases the type signature of the input tuple. If you need
   * to preserve the type signatures, please use {@link HasTenth#tenth(Supplier)}:
   *
   * <pre>
   * stream.map(tuple -&gt; tuple.tenth(supplier))
   * </pre>
   */
  @SuppressWarnings("unchecked")
  static <Z, A extends Z, X extends Z, T extends HasTenth<Z, A, T>, U extends HasTenth<Z, X, U>>
      Function<T, U> mapTenth(Supplier<X> supplier) {
    return tuple -> (U) tuple.tenth(supplier);
  }

  /**
   * Returns a function that can map the tenth element of the tuple into the value returned after
   * applying the provided function to the input tuple.
   *
   * <p><strong>NB:</strong> This method erases the type signature of the input tuple. If you need
   * to preserve the type signatures, please use {@link HasTenth#tenth(Function)}:
   *
   * <pre>
   * stream.map(tuple -&gt; tuple.tenth(function))
   * </pre>
   */
  @SuppressWarnings("unchecked")
  static <Z, A extends Z, X extends Z, T extends HasTenth<Z, A, T>, U extends HasTenth<Z, X, U>>
      Function<T, U> mapTenth(Function<A, X> function) {
    return tuple -> (U) tuple.tenth(function);
  }

  /**
   * Returns a function that can map the eleventh element of the tuple into the provided value.
   *
   * <p><strong>NB:</strong> This method erases the type signature of the input tuple. If you need
   * to preserve the type signatures, please use {@link HasEleventh#eleventh(Object)}:
   *
   * <pre>
   * stream.map(tuple -&gt; tuple.eleventh(value))
   * </pre>
   */
  @SuppressWarnings("unchecked")
  static <
          Z,
          A extends Z,
          X extends Z,
          T extends HasEleventh<Z, A, T>,
          U extends HasEleventh<Z, X, U>>
      Function<T, U> mapEleventh(X value) {
    return tuple -> (U) tuple.eleventh(value);
  }

  /**
   * Returns a function that can map the eleventh element of the tuple into the value returned from
   * the supplier.
   *
   * <p><strong>NB:</strong> This method erases the type signature of the input tuple. If you need
   * to preserve the type signatures, please use {@link HasEleventh#eleventh(Supplier)}:
   *
   * <pre>
   * stream.map(tuple -&gt; tuple.eleventh(supplier))
   * </pre>
   */
  @SuppressWarnings("unchecked")
  static <
          Z,
          A extends Z,
          X extends Z,
          T extends HasEleventh<Z, A, T>,
          U extends HasEleventh<Z, X, U>>
      Function<T, U> mapEleventh(Supplier<X> supplier) {
    return tuple -> (U) tuple.eleventh(supplier);
  }

  /**
   * Returns a function that can map the eleventh element of the tuple into the value returned after
   * applying the provided function to the input tuple.
   *
   * <p><strong>NB:</strong> This method erases the type signature of the input tuple. If you need
   * to preserve the type signatures, please use {@link HasEleventh#eleventh(Function)}:
   *
   * <pre>
   * stream.map(tuple -&gt; tuple.eleventh(function))
   * </pre>
   */
  @SuppressWarnings("unchecked")
  static <
          Z,
          A extends Z,
          X extends Z,
          T extends HasEleventh<Z, A, T>,
          U extends HasEleventh<Z, X, U>>
      Function<T, U> mapEleventh(Function<A, X> function) {
    return tuple -> (U) tuple.eleventh(function);
  }

  /**
   * Returns a function that can map the twelfth element of the tuple into the provided value.
   *
   * <p><strong>NB:</strong> This method erases the type signature of the input tuple. If you need
   * to preserve the type signatures, please use {@link HasTwelfth#twelfth(Object)}:
   *
   * <pre>
   * stream.map(tuple -&gt; tuple.twelfth(value))
   * </pre>
   */
  @SuppressWarnings("unchecked")
  static <Z, A extends Z, X extends Z, T extends HasTwelfth<Z, A, T>, U extends HasTwelfth<Z, X, U>>
      Function<T, U> mapTwelfth(X value) {
    return tuple -> (U) tuple.twelfth(value);
  }

  /**
   * Returns a function that can map the twelfth element of the tuple into the value returned from
   * the supplier.
   *
   * <p><strong>NB:</strong> This method erases the type signature of the input tuple. If you need
   * to preserve the type signatures, please use {@link HasTwelfth#twelfth(Supplier)}:
   *
   * <pre>
   * stream.map(tuple -&gt; tuple.twelfth(supplier))
   * </pre>
   */
  @SuppressWarnings("unchecked")
  static <Z, A extends Z, X extends Z, T extends HasTwelfth<Z, A, T>, U extends HasTwelfth<Z, X, U>>
      Function<T, U> mapTwelfth(Supplier<X> supplier) {
    return tuple -> (U) tuple.twelfth(supplier);
  }

  /**
   * Returns a function that can map the twelfth element of the tuple into the value returned after
   * applying the provided function to the input tuple.
   *
   * <p><strong>NB:</strong> This method erases the type signature of the input tuple. If you need
   * to preserve the type signatures, please use {@link HasTwelfth#twelfth(Function)}:
   *
   * <pre>
   * stream.map(tuple -&gt; tuple.twelfth(function))
   * </pre>
   */
  @SuppressWarnings("unchecked")
  static <Z, A extends Z, X extends Z, T extends HasTwelfth<Z, A, T>, U extends HasTwelfth<Z, X, U>>
      Function<T, U> mapTwelfth(Function<A, X> function) {
    return tuple -> (U) tuple.twelfth(function);
  }

  /**
   * Returns a function that can map the {@code nth} element of the tuple into the provided value.
   */
  static <Z, A extends Z> Function<Tuple<Z>, Tuple<Z>> mapNth(int index, A value) {
    return tuple -> tuple.change(index, value);
  }

  /**
   * Returns a function that can map the {@code nth} element of the tuple into the value returned
   * from the supplier.
   */
  static <Z, A extends Z> Function<Tuple<Z>, Tuple<Z>> mapNth(int index, Supplier<A> supplier) {
    return tuple -> tuple.change(index, supplier);
  }

  /**
   * Returns a predicate that can check the input tuple's first element against the provided
   * predicate.
   */
  static <Z, T extends HasFirst<Z, A, T>, A extends Z> Predicate<HasFirst<Z, A, T>> checkFirst(
      Predicate<A> predicate) {
    return tuple -> tuple.checkFirst(predicate);
  }

  /**
   * Returns a predicate that can check the input tuple's second element against the provided
   * predicate.
   */
  static <Z, T extends HasSecond<Z, A, T>, A extends Z> Predicate<HasSecond<Z, A, T>> checkSecond(
      Predicate<A> predicate) {
    return tuple -> tuple.checkSecond(predicate);
  }

  /**
   * Returns a predicate that can check the input tuple's third element against the provided
   * predicate.
   */
  static <Z, T extends HasThird<Z, A, T>, A extends Z> Predicate<HasThird<Z, A, T>> checkThird(
      Predicate<A> predicate) {
    return tuple -> tuple.checkThird(predicate);
  }

  /**
   * Returns a predicate that can check the input tuple's fourth element against the provided
   * predicate.
   */
  static <Z, T extends HasFourth<Z, A, T>, A extends Z> Predicate<HasFourth<Z, A, T>> checkFourth(
      Predicate<A> predicate) {
    return tuple -> tuple.checkFourth(predicate);
  }

  /**
   * Returns a predicate that can check the input tuple's fifth element against the provided
   * predicate.
   */
  static <Z, T extends HasFifth<Z, A, T>, A extends Z> Predicate<HasFifth<Z, A, T>> checkFifth(
      Predicate<A> predicate) {
    return tuple -> tuple.checkFifth(predicate);
  }

  /**
   * Returns a predicate that can check the input tuple's sixth element against the provided
   * predicate.
   */
  static <Z, T extends HasSixth<Z, A, T>, A extends Z> Predicate<HasSixth<Z, A, T>> checkSixth(
      Predicate<A> predicate) {
    return tuple -> tuple.checkSixth(predicate);
  }

  /**
   * Returns a predicate that can check the input tuple's seventh element against the provided
   * predicate.
   */
  static <Z, T extends HasSeventh<Z, A, T>, A extends Z>
      Predicate<HasSeventh<Z, A, T>> checkSeventh(Predicate<A> predicate) {
    return tuple -> tuple.checkSeventh(predicate);
  }

  /**
   * Returns a predicate that can check the input tuple's eighth element against the provided
   * predicate.
   */
  static <Z, T extends HasEighth<Z, A, T>, A extends Z> Predicate<HasEighth<Z, A, T>> checkEighth(
      Predicate<A> predicate) {
    return tuple -> tuple.checkEighth(predicate);
  }

  /**
   * Returns a predicate that can check the input tuple's ninth element against the provided
   * predicate.
   */
  static <Z, T extends HasNinth<Z, A, T>, A extends Z> Predicate<HasNinth<Z, A, T>> checkNinth(
      Predicate<A> predicate) {
    return tuple -> tuple.checkNinth(predicate);
  }

  /**
   * Returns a predicate that can check the input tuple's tenth element against the provided
   * predicate.
   */
  static <Z, T extends HasTenth<Z, A, T>, A extends Z> Predicate<HasTenth<Z, A, T>> checkTenth(
      Predicate<A> predicate) {
    return tuple -> tuple.checkTenth(predicate);
  }

  /**
   * Returns a predicate that can check the input tuple's eleventh element against the provided
   * predicate.
   */
  static <Z, T extends HasEleventh<Z, A, T>, A extends Z>
      Predicate<HasEleventh<Z, A, T>> checkEleventh(Predicate<A> predicate) {
    return tuple -> tuple.checkEleventh(predicate);
  }

  /**
   * Returns a predicate that can check the input tuple's twelfth element against the provided
   * predicate.
   */
  static <Z, T extends HasTwelfth<Z, A, T>, A extends Z>
      Predicate<HasTwelfth<Z, A, T>> checkTwelfth(Predicate<A> predicate) {
    return tuple -> tuple.checkTwelfth(predicate);
  }

  /**
   * Returns a predicate that can check the input tuple's {@code nth} element against the provided
   * predicate.
   */
  static <Z> Predicate<Tuple<Z>> checkNth(int index, Predicate<Z> predicate) {
    return tuple -> tuple.check(index, predicate);
  }
}

package com.mmnaseri.utils.tuples.impl;

import com.mmnaseri.utils.tuples.LabeledTuple;
import com.mmnaseri.utils.tuples.Tuple;
import org.testng.annotations.Test;

import java.util.List;

import static java.util.stream.Collectors.toList;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.arrayWithSize;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
/**
 * Tests for {@link OneTuple}.
 *
 * @author Milad Naseri (m.m.naseri@gmail.com)
 */
public class OneTupleTest {

  @Test
  public void creatingTuple() {
    OneTuple<Object, Integer> tuple = Tuple.one(0);
    assertThat(tuple, is(notNullValue()));
    assertThat(tuple.size(), is(1));
  }

  @Test
  public void testToArray() {
    Tuple<Object> tuple = Tuple.of(0);
    Object[] first = tuple.asArray();
    Object[] second = tuple.asArray(Object[]::new);
    assertThat(first, is(notNullValue()));
    assertThat(second, is(notNullValue()));
    assertThat(first, is(arrayWithSize(tuple.size())));
    assertThat(second, is(arrayWithSize(tuple.size())));
    for (int i = 0; i < tuple.size(); i++) {
      assertThat(first[i], is(tuple.get(i)));
      assertThat(second[i], is(tuple.get(i)));
    }
  }

  @Test
  public void testResizeAsEmpty() {
    Tuple<Object> tuple = Tuple.two(0, 1);
    EmptyTuple<Object> other = tuple.asEmpty();
    assertThat(other.size(), is(0));
  }

  @Test
  public void testResizeAsOne() {
    Tuple<Object> tuple = Tuple.two(0, 1);
    OneTuple<Object, Object> other = tuple.asOne();
    assertThat(other.size(), is(1));
    assertThat(other.first(), is(tuple.get(0)));
  }

  @Test
  public void testResizeAsTwo() {
    Tuple<Object> tuple = Tuple.two(0, 1);
    TwoTuple<Object, Object, Object> other = tuple.asTwo();
    assertThat(other.size(), is(2));
    assertThat(other.first(), is(tuple.get(0)));
    assertThat(other.second(), is(tuple.get(1)));
  }

  @Test(
      expectedExceptions = IllegalStateException.class,
      expectedExceptionsMessageRegExp = "Expected a size of at least \\d+ but received \\d+")
  public void testResizeAsThree() {
    Tuple<Object> tuple = Tuple.two(0, 1);
    ThreeTuple<Object, Object, Object, Object> other = tuple.asThree();
    assertThat(other.size(), is(3));
    assertThat(other.first(), is(tuple.get(0)));
    assertThat(other.second(), is(tuple.get(1)));
    assertThat(other.third(), is(tuple.get(2)));
  }

  @Test(
      expectedExceptions = IllegalStateException.class,
      expectedExceptionsMessageRegExp = "Expected a size of at least \\d+ but received \\d+")
  public void testResizeAsFour() {
    Tuple<Object> tuple = Tuple.two(0, 1);
    FourTuple<Object, Object, Object, Object, Object> other = tuple.asFour();
    assertThat(other.size(), is(4));
    assertThat(other.first(), is(tuple.get(0)));
    assertThat(other.second(), is(tuple.get(1)));
    assertThat(other.third(), is(tuple.get(2)));
    assertThat(other.fourth(), is(tuple.get(3)));
  }

  @Test(
      expectedExceptions = IllegalStateException.class,
      expectedExceptionsMessageRegExp = "Expected a size of at least \\d+ but received \\d+")
  public void testResizeAsFive() {
    Tuple<Object> tuple = Tuple.two(0, 1);
    FiveTuple<Object, Object, Object, Object, Object, Object> other = tuple.asFive();
    assertThat(other.size(), is(5));
    assertThat(other.first(), is(tuple.get(0)));
    assertThat(other.second(), is(tuple.get(1)));
    assertThat(other.third(), is(tuple.get(2)));
    assertThat(other.fourth(), is(tuple.get(3)));
    assertThat(other.fifth(), is(tuple.get(4)));
  }

  @Test(
      expectedExceptions = IllegalStateException.class,
      expectedExceptionsMessageRegExp = "Expected a size of at least \\d+ but received \\d+")
  public void testResizeAsSix() {
    Tuple<Object> tuple = Tuple.two(0, 1);
    SixTuple<Object, Object, Object, Object, Object, Object, Object> other = tuple.asSix();
    assertThat(other.size(), is(6));
    assertThat(other.first(), is(tuple.get(0)));
    assertThat(other.second(), is(tuple.get(1)));
    assertThat(other.third(), is(tuple.get(2)));
    assertThat(other.fourth(), is(tuple.get(3)));
    assertThat(other.fifth(), is(tuple.get(4)));
    assertThat(other.sixth(), is(tuple.get(5)));
  }

  @Test(
      expectedExceptions = IllegalStateException.class,
      expectedExceptionsMessageRegExp = "Expected a size of at least \\d+ but received \\d+")
  public void testResizeAsSeven() {
    Tuple<Object> tuple = Tuple.two(0, 1);
    SevenTuple<Object, Object, Object, Object, Object, Object, Object, Object> other =
        tuple.asSeven();
    assertThat(other.size(), is(7));
    assertThat(other.first(), is(tuple.get(0)));
    assertThat(other.second(), is(tuple.get(1)));
    assertThat(other.third(), is(tuple.get(2)));
    assertThat(other.fourth(), is(tuple.get(3)));
    assertThat(other.fifth(), is(tuple.get(4)));
    assertThat(other.sixth(), is(tuple.get(5)));
    assertThat(other.seventh(), is(tuple.get(6)));
  }

  @Test(
      expectedExceptions = IllegalStateException.class,
      expectedExceptionsMessageRegExp = "Expected a size of at least \\d+ but received \\d+")
  public void testResizeAsEight() {
    Tuple<Object> tuple = Tuple.two(0, 1);
    EightTuple<Object, Object, Object, Object, Object, Object, Object, Object, Object> other =
        tuple.asEight();
    assertThat(other.size(), is(8));
    assertThat(other.first(), is(tuple.get(0)));
    assertThat(other.second(), is(tuple.get(1)));
    assertThat(other.third(), is(tuple.get(2)));
    assertThat(other.fourth(), is(tuple.get(3)));
    assertThat(other.fifth(), is(tuple.get(4)));
    assertThat(other.sixth(), is(tuple.get(5)));
    assertThat(other.seventh(), is(tuple.get(6)));
    assertThat(other.eighth(), is(tuple.get(7)));
  }

  @Test(
      expectedExceptions = IllegalStateException.class,
      expectedExceptionsMessageRegExp = "Expected a size of at least \\d+ but received \\d+")
  public void testResizeAsNine() {
    Tuple<Object> tuple = Tuple.two(0, 1);
    NineTuple<Object, Object, Object, Object, Object, Object, Object, Object, Object, Object>
        other = tuple.asNine();
    assertThat(other.size(), is(9));
    assertThat(other.first(), is(tuple.get(0)));
    assertThat(other.second(), is(tuple.get(1)));
    assertThat(other.third(), is(tuple.get(2)));
    assertThat(other.fourth(), is(tuple.get(3)));
    assertThat(other.fifth(), is(tuple.get(4)));
    assertThat(other.sixth(), is(tuple.get(5)));
    assertThat(other.seventh(), is(tuple.get(6)));
    assertThat(other.eighth(), is(tuple.get(7)));
    assertThat(other.ninth(), is(tuple.get(8)));
  }

  @Test(
      expectedExceptions = IllegalStateException.class,
      expectedExceptionsMessageRegExp = "Expected a size of at least \\d+ but received \\d+")
  public void testResizeAsTen() {
    Tuple<Object> tuple = Tuple.two(0, 1);
    TenTuple<Object, Object, Object, Object, Object, Object, Object, Object, Object, Object, Object>
        other = tuple.asTen();
    assertThat(other.size(), is(10));
    assertThat(other.first(), is(tuple.get(0)));
    assertThat(other.second(), is(tuple.get(1)));
    assertThat(other.third(), is(tuple.get(2)));
    assertThat(other.fourth(), is(tuple.get(3)));
    assertThat(other.fifth(), is(tuple.get(4)));
    assertThat(other.sixth(), is(tuple.get(5)));
    assertThat(other.seventh(), is(tuple.get(6)));
    assertThat(other.eighth(), is(tuple.get(7)));
    assertThat(other.ninth(), is(tuple.get(8)));
    assertThat(other.tenth(), is(tuple.get(9)));
  }

  @Test(
      expectedExceptions = IllegalStateException.class,
      expectedExceptionsMessageRegExp = "Expected a size of at least \\d+ but received \\d+")
  public void testResizeAsEleven() {
    Tuple<Object> tuple = Tuple.two(0, 1);
    ElevenTuple<
            Object,
            Object,
            Object,
            Object,
            Object,
            Object,
            Object,
            Object,
            Object,
            Object,
            Object,
            Object>
        other = tuple.asEleven();
    assertThat(other.size(), is(11));
    assertThat(other.first(), is(tuple.get(0)));
    assertThat(other.second(), is(tuple.get(1)));
    assertThat(other.third(), is(tuple.get(2)));
    assertThat(other.fourth(), is(tuple.get(3)));
    assertThat(other.fifth(), is(tuple.get(4)));
    assertThat(other.sixth(), is(tuple.get(5)));
    assertThat(other.seventh(), is(tuple.get(6)));
    assertThat(other.eighth(), is(tuple.get(7)));
    assertThat(other.ninth(), is(tuple.get(8)));
    assertThat(other.tenth(), is(tuple.get(9)));
    assertThat(other.eleventh(), is(tuple.get(10)));
  }

  @Test(
      expectedExceptions = IllegalStateException.class,
      expectedExceptionsMessageRegExp = "Expected a size of at least \\d+ but received \\d+")
  public void testResizeAsTwelve() {
    Tuple<Object> tuple = Tuple.two(0, 1);
    TwelveTuple<
            Object,
            Object,
            Object,
            Object,
            Object,
            Object,
            Object,
            Object,
            Object,
            Object,
            Object,
            Object,
            Object>
        other = tuple.asTwelve();
    assertThat(other.size(), is(12));
    assertThat(other.first(), is(tuple.get(0)));
    assertThat(other.second(), is(tuple.get(1)));
    assertThat(other.third(), is(tuple.get(2)));
    assertThat(other.fourth(), is(tuple.get(3)));
    assertThat(other.fifth(), is(tuple.get(4)));
    assertThat(other.sixth(), is(tuple.get(5)));
    assertThat(other.seventh(), is(tuple.get(6)));
    assertThat(other.eighth(), is(tuple.get(7)));
    assertThat(other.ninth(), is(tuple.get(8)));
    assertThat(other.tenth(), is(tuple.get(9)));
    assertThat(other.eleventh(), is(tuple.get(10)));
    assertThat(other.twelfth(), is(tuple.get(11)));
  }

  @Test
  public void accessingMembers() {
    OneTuple<Object, Integer> tuple = Tuple.one(0);
    assertThat(tuple.get(0), is(0));
  }

  @Test
  public void changingElementByIndex() {
    OneTuple<Object, Integer> tuple = Tuple.one(0);
    for (int i = 0; i < 1; i++) {
      Tuple<?> other = tuple.change(i, -1);
      assertThat(other, is(notNullValue()));
      assertThat(other.size(), is(1));
      assertThat(other.get(i), is(-1));
    }
  }

  @Test
  public void changingElementByIndexThroughFunction() {
    OneTuple<Object, Integer> tuple = Tuple.one(0);
    for (int i = 0; i < 1; i++) {
      Tuple<?> other = tuple.change(i, t -> -1);
      assertThat(other, is(notNullValue()));
      assertThat(other.size(), is(1));
      assertThat(other.get(i), is(-1));
    }
  }

  @Test
  public void changingFirstElementByAccessor() {
    OneTuple<Object, Integer> tuple = Tuple.one(0);

    // Changing by value.
    OneTuple<Object, Integer> secondTuple = tuple.first(-1);
    assertThat(secondTuple, is(notNullValue()));
    assertThat(secondTuple.size(), is(tuple.size()));
    assertThat(secondTuple.first(), is(-1));

    // Changing by supplier.
    OneTuple<Object, Integer> thirdTuple = tuple.first(() -> -1);
    assertThat(thirdTuple, is(notNullValue()));
    assertThat(thirdTuple.size(), is(tuple.size()));
    assertThat(thirdTuple.first(), is(-1));

    // Changing by function.
    OneTuple<Object, Integer> fourthTuple = tuple.first(previous -> -1);
    assertThat(fourthTuple, is(notNullValue()));
    assertThat(fourthTuple.size(), is(tuple.size()));
    assertThat(fourthTuple.first(), is(-1));
  }

  @Test
  public void droppingByIndex() {
    OneTuple<Object, Integer> tuple = Tuple.one(0);
    for (int i = 0; i < 1; i++) {
      Tuple<?> other = tuple.drop(i);
      assertThat(other, is(notNullValue()));
      assertThat(other.size(), is(0));
    }
  }

  @Test
  public void droppingFirstElementByAccessor() {
    OneTuple<Object, Integer> tuple = Tuple.one(0);
    EmptyTuple<Object> other = tuple.dropFirst();
    assertThat(other, is(notNullValue()));
    assertThat(other.size(), is(0));
  }

  @Test
  public void clearingTuple() {
    OneTuple<Object, Integer> tuple = Tuple.one(0);
    Tuple<?> other = tuple.clear();
    assertThat(other, is(notNullValue()));
    assertThat(other.size(), is(0));
  }

  @Test
  public void streamingTuple() {
    OneTuple<Object, Integer> tuple = Tuple.one(0);
    List<Object> items = tuple.stream().collect(toList());
    assertThat(items, is(hasSize(1)));
    assertThat(items, is(contains(0)));
  }

  @Test
  public void gettingTupleAsList() {
    OneTuple<Object, Integer> tuple = Tuple.one(0);
    List<Object> items = tuple.asList();
    assertThat(items, is(hasSize(1)));
    assertThat(items, is(contains(0)));
  }

  @Test
  public void checkingPredicateByIndex() {
    OneTuple<Integer, Integer> tuple = OneTuple.of(0);
    assertThat(tuple.check(0, x -> x % 2 == 0), is(true));
  }

  @Test
  public void checkingPredicateByAccessor() {
    OneTuple<Integer, Integer> tuple = OneTuple.of(0);
    assertThat(tuple.checkFirst(x -> x % 2 == 0), is(true));
  }

  @Test
  public void extendingByValue() {
    OneTuple<Integer, Integer> tuple = OneTuple.of(0);
    TwoTuple<Integer, Integer, Integer> secondTuple = OneTuple.extendWith(-1).apply(tuple);
    assertThat(secondTuple, is(notNullValue()));
    assertThat(secondTuple.size(), is(2));
    assertThat(secondTuple.first(), is(tuple.first()));
    assertThat(secondTuple.second(), is(-1));
    assertThat(secondTuple.drop(1), is(tuple));
  }

  @Test
  public void extendingBySupplier() {
    OneTuple<Integer, Integer> tuple = OneTuple.of(0);
    TwoTuple<Integer, Integer, Integer> secondTuple = OneTuple.extendWith(() -> -1).apply(tuple);
    assertThat(secondTuple, is(notNullValue()));
    assertThat(secondTuple.size(), is(2));
    assertThat(secondTuple.first(), is(tuple.first()));
    assertThat(secondTuple.second(), is(-1));
    assertThat(secondTuple.drop(1), is(tuple));
  }

  @Test
  public void extendingByFunction() {
    OneTuple<Integer, Integer> tuple = OneTuple.of(0);
    TwoTuple<Integer, Integer, Integer> secondTuple =
        OneTuple.extendWith((OneTuple<Integer, Integer> t) -> -1).apply(tuple);
    assertThat(secondTuple, is(notNullValue()));
    assertThat(secondTuple.size(), is(2));
    assertThat(secondTuple.first(), is(tuple.first()));
    assertThat(secondTuple.second(), is(-1));
    assertThat(secondTuple.drop(1), is(tuple));
  }

  @Test
  public void labelingTuple() {
    OneTuple<Integer, Integer> tuple = OneTuple.of(0);
    LabeledTuple<Integer> other = tuple.withLabels("e0");
    assertThat(other, is(notNullValue()));
    assertThat(other.size(), is(1));
    assertThat(other.labels(), is(contains("e0")));
    assertThat(other.get("e0"), is(tuple.get(0)));
    LabeledTuple<Integer> extended = other.extend(-1, "last");
    assertThat(extended, is(notNullValue()));
    assertThat(extended.size(), is(2));
    assertThat(extended.get("last"), is(-1));
  }

  @Test
  public void equality() {
    OneTuple<Object, Integer> tuple = Tuple.one(0);
    OneTuple<Object, Integer> secondTuple = Tuple.one(0);
    assertThat(tuple, is(secondTuple));
  }

  @Test
  public void hashCodeCalculation() {
    OneTuple<Object, Integer> tuple = Tuple.one(0);
    OneTuple<Object, Integer> secondTuple = Tuple.one(0);
    assertThat(tuple.hashCode(), is(secondTuple.hashCode()));
  }

  @Test
  public void toStringCalculation() {
    OneTuple<Object, Integer> tuple = Tuple.one(0);
    OneTuple<Object, Integer> secondTuple = Tuple.one(0);
    assertThat(tuple.toString(), is(secondTuple.toString()));
  }
}

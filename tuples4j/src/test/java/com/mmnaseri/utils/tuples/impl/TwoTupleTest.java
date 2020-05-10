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
 * Tests for {@link TwoTuple}.
 *
 * @author Milad Naseri (m.m.naseri@gmail.com)
 */
public class TwoTupleTest {

  @Test
  public void creatingTuple() {
    TwoTuple<Object, Integer, Integer> tuple = Tuple.two(0, 1);
    assertThat(tuple, is(notNullValue()));
    assertThat(tuple.size(), is(2));
  }

  @Test
  public void testToArray() {
    Tuple<Object> tuple = Tuple.of(0, 1);
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
    Tuple<Object> tuple = Tuple.one(0);
    EmptyTuple<Object> other = tuple.asEmpty();
    assertThat(other.size(), is(0));
  }

  @Test
  public void testResizeAsOne() {
    Tuple<Object> tuple = Tuple.one(0);
    OneTuple<Object, Object> other = tuple.asOne();
    assertThat(other.size(), is(1));
    assertThat(other.first(), is(tuple.get(0)));
  }

  @Test(
      expectedExceptions = IllegalStateException.class,
      expectedExceptionsMessageRegExp = "Expected a size of at least \\d+ but received \\d+")
  public void testResizeAsTwo() {
    Tuple<Object> tuple = Tuple.one(0);
    TwoTuple<Object, Object, Object> other = tuple.asTwo();
    assertThat(other.size(), is(2));
    assertThat(other.first(), is(tuple.get(0)));
    assertThat(other.second(), is(tuple.get(1)));
  }

  @Test(
      expectedExceptions = IllegalStateException.class,
      expectedExceptionsMessageRegExp = "Expected a size of at least \\d+ but received \\d+")
  public void testResizeAsThree() {
    Tuple<Object> tuple = Tuple.one(0);
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
    Tuple<Object> tuple = Tuple.one(0);
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
    Tuple<Object> tuple = Tuple.one(0);
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
    Tuple<Object> tuple = Tuple.one(0);
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
    Tuple<Object> tuple = Tuple.one(0);
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
    Tuple<Object> tuple = Tuple.one(0);
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
    Tuple<Object> tuple = Tuple.one(0);
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
    Tuple<Object> tuple = Tuple.one(0);
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
    Tuple<Object> tuple = Tuple.one(0);
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
    Tuple<Object> tuple = Tuple.one(0);
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
    TwoTuple<Object, Integer, Integer> tuple = Tuple.two(0, 1);
    assertThat(tuple.get(0), is(0));
    assertThat(tuple.get(1), is(1));
  }

  @Test
  public void changingElementByIndex() {
    TwoTuple<Object, Integer, Integer> tuple = Tuple.two(0, 1);
    for (int i = 0; i < 2; i++) {
      Tuple<?> other = tuple.change(i, -1);
      assertThat(other, is(notNullValue()));
      assertThat(other.size(), is(2));
      assertThat(other.get(i), is(-1));
    }
  }

  @Test
  public void changingElementByIndexThroughFunction() {
    TwoTuple<Object, Integer, Integer> tuple = Tuple.two(0, 1);
    for (int i = 0; i < 2; i++) {
      Tuple<?> other = tuple.change(i, t -> -1);
      assertThat(other, is(notNullValue()));
      assertThat(other.size(), is(2));
      assertThat(other.get(i), is(-1));
    }
  }

  @Test
  public void changingFirstElementByAccessor() {
    TwoTuple<Object, Integer, Integer> tuple = Tuple.two(0, 1);

    // Changing by value.
    TwoTuple<Object, Integer, Integer> secondTuple = tuple.first(-1);
    assertThat(secondTuple, is(notNullValue()));
    assertThat(secondTuple.size(), is(tuple.size()));
    assertThat(secondTuple.first(), is(-1));
    assertThat(secondTuple.second(), is(1));

    // Changing by supplier.
    TwoTuple<Object, Integer, Integer> thirdTuple = tuple.first(() -> -1);
    assertThat(thirdTuple, is(notNullValue()));
    assertThat(thirdTuple.size(), is(tuple.size()));
    assertThat(thirdTuple.first(), is(-1));
    assertThat(thirdTuple.second(), is(1));

    // Changing by function.
    TwoTuple<Object, Integer, Integer> fourthTuple = tuple.first(previous -> -1);
    assertThat(fourthTuple, is(notNullValue()));
    assertThat(fourthTuple.size(), is(tuple.size()));
    assertThat(fourthTuple.first(), is(-1));
    assertThat(fourthTuple.second(), is(1));
  }

  @Test
  public void changingSecondElementByAccessor() {
    TwoTuple<Object, Integer, Integer> tuple = Tuple.two(0, 1);

    // Changing by value.
    TwoTuple<Object, Integer, Integer> secondTuple = tuple.second(-1);
    assertThat(secondTuple, is(notNullValue()));
    assertThat(secondTuple.size(), is(tuple.size()));
    assertThat(secondTuple.first(), is(0));
    assertThat(secondTuple.second(), is(-1));

    // Changing by supplier.
    TwoTuple<Object, Integer, Integer> thirdTuple = tuple.second(() -> -1);
    assertThat(thirdTuple, is(notNullValue()));
    assertThat(thirdTuple.size(), is(tuple.size()));
    assertThat(thirdTuple.first(), is(0));
    assertThat(thirdTuple.second(), is(-1));

    // Changing by function.
    TwoTuple<Object, Integer, Integer> fourthTuple = tuple.second(previous -> -1);
    assertThat(fourthTuple, is(notNullValue()));
    assertThat(fourthTuple.size(), is(tuple.size()));
    assertThat(fourthTuple.first(), is(0));
    assertThat(fourthTuple.second(), is(-1));
  }

  @Test
  public void droppingByIndex() {
    TwoTuple<Object, Integer, Integer> tuple = Tuple.two(0, 1);
    for (int i = 0; i < 2; i++) {
      Tuple<?> other = tuple.drop(i);
      assertThat(other, is(notNullValue()));
      assertThat(other.size(), is(1));
      for (int j = 0; j < 2; j++) {
        if (j == i) {
          continue;
        }
        assertThat(other.get(j < i ? j : j - 1), is(tuple.get(j)));
      }
    }
  }

  @Test
  public void droppingFirstElementByAccessor() {
    TwoTuple<Object, Integer, Integer> tuple = Tuple.two(0, 1);
    OneTuple<Object, Integer> other = tuple.dropFirst();
    assertThat(other, is(notNullValue()));
    assertThat(other.size(), is(1));
    assertThat(other.first(), is(tuple.second()));
  }

  @Test
  public void droppingSecondElementByAccessor() {
    TwoTuple<Object, Integer, Integer> tuple = Tuple.two(0, 1);
    OneTuple<Object, Integer> other = tuple.dropSecond();
    assertThat(other, is(notNullValue()));
    assertThat(other.size(), is(1));
    assertThat(other.first(), is(tuple.first()));
  }

  @Test
  public void clearingTuple() {
    TwoTuple<Object, Integer, Integer> tuple = Tuple.two(0, 1);
    Tuple<?> other = tuple.clear();
    assertThat(other, is(notNullValue()));
    assertThat(other.size(), is(0));
  }

  @Test
  public void streamingTuple() {
    TwoTuple<Object, Integer, Integer> tuple = Tuple.two(0, 1);
    List<Object> items = tuple.stream().collect(toList());
    assertThat(items, is(hasSize(2)));
    assertThat(items, is(contains(0, 1)));
  }

  @Test
  public void gettingTupleAsList() {
    TwoTuple<Object, Integer, Integer> tuple = Tuple.two(0, 1);
    List<Object> items = tuple.asList();
    assertThat(items, is(hasSize(2)));
    assertThat(items, is(contains(0, 1)));
  }

  @Test
  public void checkingPredicateByIndex() {
    TwoTuple<Integer, Integer, Integer> tuple = TwoTuple.of(0, 1);
    for (int i = 0; i < 2; i++) {
      assertThat(tuple.check(i, x -> x % 2 == 0), is(i % 2 == 0));
    }
  }

  @Test
  public void checkingPredicateByAccessor() {
    TwoTuple<Integer, Integer, Integer> tuple = TwoTuple.of(0, 1);
    assertThat(tuple.checkFirst(x -> x % 2 == 0), is(true));
    assertThat(tuple.checkSecond(x -> x % 2 == 0), is(false));
  }

  @Test
  public void extendingByValue() {
    TwoTuple<Integer, Integer, Integer> tuple = TwoTuple.of(0, 1);
    ThreeTuple<Integer, Integer, Integer, Integer> secondTuple =
        TwoTuple.extendWith(-1).apply(tuple);
    assertThat(secondTuple, is(notNullValue()));
    assertThat(secondTuple.size(), is(3));
    assertThat(secondTuple.first(), is(tuple.first()));
    assertThat(secondTuple.second(), is(tuple.second()));
    assertThat(secondTuple.third(), is(-1));
    assertThat(secondTuple.drop(2), is(tuple));
  }

  @Test
  public void extendingBySupplier() {
    TwoTuple<Integer, Integer, Integer> tuple = TwoTuple.of(0, 1);
    ThreeTuple<Integer, Integer, Integer, Integer> secondTuple =
        TwoTuple.extendWith(() -> -1).apply(tuple);
    assertThat(secondTuple, is(notNullValue()));
    assertThat(secondTuple.size(), is(3));
    assertThat(secondTuple.first(), is(tuple.first()));
    assertThat(secondTuple.second(), is(tuple.second()));
    assertThat(secondTuple.third(), is(-1));
    assertThat(secondTuple.drop(2), is(tuple));
  }

  @Test
  public void extendingByFunction() {
    TwoTuple<Integer, Integer, Integer> tuple = TwoTuple.of(0, 1);
    ThreeTuple<Integer, Integer, Integer, Integer> secondTuple =
        TwoTuple.extendWith((TwoTuple<Integer, Integer, Integer> t) -> -1).apply(tuple);
    assertThat(secondTuple, is(notNullValue()));
    assertThat(secondTuple.size(), is(3));
    assertThat(secondTuple.first(), is(tuple.first()));
    assertThat(secondTuple.second(), is(tuple.second()));
    assertThat(secondTuple.third(), is(-1));
    assertThat(secondTuple.drop(2), is(tuple));
  }

  @Test
  public void labelingTuple() {
    TwoTuple<Integer, Integer, Integer> tuple = TwoTuple.of(0, 1);
    LabeledTuple<Integer> other = tuple.withLabels("e0", "e1");
    assertThat(other, is(notNullValue()));
    assertThat(other.size(), is(2));
    assertThat(other.labels(), is(contains("e0", "e1")));
    assertThat(other.get("e0"), is(tuple.get(0)));
    assertThat(other.get("e1"), is(tuple.get(1)));
    LabeledTuple<Integer> extended = other.extend(-1, "last");
    assertThat(extended, is(notNullValue()));
    assertThat(extended.size(), is(3));
    assertThat(extended.get("last"), is(-1));
  }

  @Test
  public void equality() {
    TwoTuple<Object, Integer, Integer> tuple = Tuple.two(0, 1);
    TwoTuple<Object, Integer, Integer> secondTuple = Tuple.two(0, 1);
    assertThat(tuple, is(secondTuple));
  }

  @Test
  public void hashCodeCalculation() {
    TwoTuple<Object, Integer, Integer> tuple = Tuple.two(0, 1);
    TwoTuple<Object, Integer, Integer> secondTuple = Tuple.two(0, 1);
    assertThat(tuple.hashCode(), is(secondTuple.hashCode()));
  }

  @Test
  public void toStringCalculation() {
    TwoTuple<Object, Integer, Integer> tuple = Tuple.two(0, 1);
    TwoTuple<Object, Integer, Integer> secondTuple = Tuple.two(0, 1);
    assertThat(tuple.toString(), is(secondTuple.toString()));
  }
}

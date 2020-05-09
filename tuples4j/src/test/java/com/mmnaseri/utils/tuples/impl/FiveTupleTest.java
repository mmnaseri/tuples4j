package com.mmnaseri.utils.tuples.impl;

import com.mmnaseri.utils.tuples.LabeledTuple;
import com.mmnaseri.utils.tuples.Tuple;
import org.testng.annotations.Test;

import java.util.List;

import static java.util.stream.Collectors.toList;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
/**
 * Tests for {@link FiveTuple}.
 *
 * @author Milad Naseri (m.m.naseri@gmail.com)
 */
public class FiveTupleTest {

  @Test
  public void creatingTuple() {
    FiveTuple<Object, Integer, Integer, Integer, Integer, Integer> tuple =
        Tuple.five(0, 1, 2, 3, 4);
    assertThat(tuple, is(notNullValue()));
    assertThat(tuple.size(), is(5));
  }

  @Test
  public void accessingMembers() {
    FiveTuple<Object, Integer, Integer, Integer, Integer, Integer> tuple =
        Tuple.five(0, 1, 2, 3, 4);
    assertThat(tuple.get(0), is(0));
    assertThat(tuple.get(1), is(1));
    assertThat(tuple.get(2), is(2));
    assertThat(tuple.get(3), is(3));
    assertThat(tuple.get(4), is(4));
  }

  @Test
  public void changingElementByIndex() {
    FiveTuple<Object, Integer, Integer, Integer, Integer, Integer> tuple =
        Tuple.five(0, 1, 2, 3, 4);
    for (int i = 0; i < 5; i++) {
      Tuple<?> other = tuple.change(i, -1);
      assertThat(other, is(notNullValue()));
      assertThat(other.size(), is(5));
      assertThat(other.get(i), is(-1));
    }
  }

  @Test
  public void changingElementByIndexThroughFunction() {
    FiveTuple<Object, Integer, Integer, Integer, Integer, Integer> tuple =
        Tuple.five(0, 1, 2, 3, 4);
    for (int i = 0; i < 5; i++) {
      Tuple<?> other = tuple.change(i, t -> -1);
      assertThat(other, is(notNullValue()));
      assertThat(other.size(), is(5));
      assertThat(other.get(i), is(-1));
    }
  }

  @Test
  public void changingFirstElementByAccessor() {
    FiveTuple<Object, Integer, Integer, Integer, Integer, Integer> tuple =
        Tuple.five(0, 1, 2, 3, 4);

    // Changing by value.
    FiveTuple<Object, Integer, Integer, Integer, Integer, Integer> secondTuple = tuple.first(-1);
    assertThat(secondTuple, is(notNullValue()));
    assertThat(secondTuple.size(), is(tuple.size()));
    assertThat(secondTuple.first(), is(-1));
    assertThat(secondTuple.second(), is(1));
    assertThat(secondTuple.third(), is(2));
    assertThat(secondTuple.fourth(), is(3));
    assertThat(secondTuple.fifth(), is(4));

    // Changing by supplier.
    FiveTuple<Object, Integer, Integer, Integer, Integer, Integer> thirdTuple =
        tuple.first(() -> -1);
    assertThat(thirdTuple, is(notNullValue()));
    assertThat(thirdTuple.size(), is(tuple.size()));
    assertThat(thirdTuple.first(), is(-1));
    assertThat(thirdTuple.second(), is(1));
    assertThat(thirdTuple.third(), is(2));
    assertThat(thirdTuple.fourth(), is(3));
    assertThat(thirdTuple.fifth(), is(4));

    // Changing by function.
    FiveTuple<Object, Integer, Integer, Integer, Integer, Integer> fourthTuple =
        tuple.first(previous -> -1);
    assertThat(fourthTuple, is(notNullValue()));
    assertThat(fourthTuple.size(), is(tuple.size()));
    assertThat(fourthTuple.first(), is(-1));
    assertThat(fourthTuple.second(), is(1));
    assertThat(fourthTuple.third(), is(2));
    assertThat(fourthTuple.fourth(), is(3));
    assertThat(fourthTuple.fifth(), is(4));
  }

  @Test
  public void changingSecondElementByAccessor() {
    FiveTuple<Object, Integer, Integer, Integer, Integer, Integer> tuple =
        Tuple.five(0, 1, 2, 3, 4);

    // Changing by value.
    FiveTuple<Object, Integer, Integer, Integer, Integer, Integer> secondTuple = tuple.second(-1);
    assertThat(secondTuple, is(notNullValue()));
    assertThat(secondTuple.size(), is(tuple.size()));
    assertThat(secondTuple.first(), is(0));
    assertThat(secondTuple.second(), is(-1));
    assertThat(secondTuple.third(), is(2));
    assertThat(secondTuple.fourth(), is(3));
    assertThat(secondTuple.fifth(), is(4));

    // Changing by supplier.
    FiveTuple<Object, Integer, Integer, Integer, Integer, Integer> thirdTuple =
        tuple.second(() -> -1);
    assertThat(thirdTuple, is(notNullValue()));
    assertThat(thirdTuple.size(), is(tuple.size()));
    assertThat(thirdTuple.first(), is(0));
    assertThat(thirdTuple.second(), is(-1));
    assertThat(thirdTuple.third(), is(2));
    assertThat(thirdTuple.fourth(), is(3));
    assertThat(thirdTuple.fifth(), is(4));

    // Changing by function.
    FiveTuple<Object, Integer, Integer, Integer, Integer, Integer> fourthTuple =
        tuple.second(previous -> -1);
    assertThat(fourthTuple, is(notNullValue()));
    assertThat(fourthTuple.size(), is(tuple.size()));
    assertThat(fourthTuple.first(), is(0));
    assertThat(fourthTuple.second(), is(-1));
    assertThat(fourthTuple.third(), is(2));
    assertThat(fourthTuple.fourth(), is(3));
    assertThat(fourthTuple.fifth(), is(4));
  }

  @Test
  public void changingThirdElementByAccessor() {
    FiveTuple<Object, Integer, Integer, Integer, Integer, Integer> tuple =
        Tuple.five(0, 1, 2, 3, 4);

    // Changing by value.
    FiveTuple<Object, Integer, Integer, Integer, Integer, Integer> secondTuple = tuple.third(-1);
    assertThat(secondTuple, is(notNullValue()));
    assertThat(secondTuple.size(), is(tuple.size()));
    assertThat(secondTuple.first(), is(0));
    assertThat(secondTuple.second(), is(1));
    assertThat(secondTuple.third(), is(-1));
    assertThat(secondTuple.fourth(), is(3));
    assertThat(secondTuple.fifth(), is(4));

    // Changing by supplier.
    FiveTuple<Object, Integer, Integer, Integer, Integer, Integer> thirdTuple =
        tuple.third(() -> -1);
    assertThat(thirdTuple, is(notNullValue()));
    assertThat(thirdTuple.size(), is(tuple.size()));
    assertThat(thirdTuple.first(), is(0));
    assertThat(thirdTuple.second(), is(1));
    assertThat(thirdTuple.third(), is(-1));
    assertThat(thirdTuple.fourth(), is(3));
    assertThat(thirdTuple.fifth(), is(4));

    // Changing by function.
    FiveTuple<Object, Integer, Integer, Integer, Integer, Integer> fourthTuple =
        tuple.third(previous -> -1);
    assertThat(fourthTuple, is(notNullValue()));
    assertThat(fourthTuple.size(), is(tuple.size()));
    assertThat(fourthTuple.first(), is(0));
    assertThat(fourthTuple.second(), is(1));
    assertThat(fourthTuple.third(), is(-1));
    assertThat(fourthTuple.fourth(), is(3));
    assertThat(fourthTuple.fifth(), is(4));
  }

  @Test
  public void changingFourthElementByAccessor() {
    FiveTuple<Object, Integer, Integer, Integer, Integer, Integer> tuple =
        Tuple.five(0, 1, 2, 3, 4);

    // Changing by value.
    FiveTuple<Object, Integer, Integer, Integer, Integer, Integer> secondTuple = tuple.fourth(-1);
    assertThat(secondTuple, is(notNullValue()));
    assertThat(secondTuple.size(), is(tuple.size()));
    assertThat(secondTuple.first(), is(0));
    assertThat(secondTuple.second(), is(1));
    assertThat(secondTuple.third(), is(2));
    assertThat(secondTuple.fourth(), is(-1));
    assertThat(secondTuple.fifth(), is(4));

    // Changing by supplier.
    FiveTuple<Object, Integer, Integer, Integer, Integer, Integer> thirdTuple =
        tuple.fourth(() -> -1);
    assertThat(thirdTuple, is(notNullValue()));
    assertThat(thirdTuple.size(), is(tuple.size()));
    assertThat(thirdTuple.first(), is(0));
    assertThat(thirdTuple.second(), is(1));
    assertThat(thirdTuple.third(), is(2));
    assertThat(thirdTuple.fourth(), is(-1));
    assertThat(thirdTuple.fifth(), is(4));

    // Changing by function.
    FiveTuple<Object, Integer, Integer, Integer, Integer, Integer> fourthTuple =
        tuple.fourth(previous -> -1);
    assertThat(fourthTuple, is(notNullValue()));
    assertThat(fourthTuple.size(), is(tuple.size()));
    assertThat(fourthTuple.first(), is(0));
    assertThat(fourthTuple.second(), is(1));
    assertThat(fourthTuple.third(), is(2));
    assertThat(fourthTuple.fourth(), is(-1));
    assertThat(fourthTuple.fifth(), is(4));
  }

  @Test
  public void changingFifthElementByAccessor() {
    FiveTuple<Object, Integer, Integer, Integer, Integer, Integer> tuple =
        Tuple.five(0, 1, 2, 3, 4);

    // Changing by value.
    FiveTuple<Object, Integer, Integer, Integer, Integer, Integer> secondTuple = tuple.fifth(-1);
    assertThat(secondTuple, is(notNullValue()));
    assertThat(secondTuple.size(), is(tuple.size()));
    assertThat(secondTuple.first(), is(0));
    assertThat(secondTuple.second(), is(1));
    assertThat(secondTuple.third(), is(2));
    assertThat(secondTuple.fourth(), is(3));
    assertThat(secondTuple.fifth(), is(-1));

    // Changing by supplier.
    FiveTuple<Object, Integer, Integer, Integer, Integer, Integer> thirdTuple =
        tuple.fifth(() -> -1);
    assertThat(thirdTuple, is(notNullValue()));
    assertThat(thirdTuple.size(), is(tuple.size()));
    assertThat(thirdTuple.first(), is(0));
    assertThat(thirdTuple.second(), is(1));
    assertThat(thirdTuple.third(), is(2));
    assertThat(thirdTuple.fourth(), is(3));
    assertThat(thirdTuple.fifth(), is(-1));

    // Changing by function.
    FiveTuple<Object, Integer, Integer, Integer, Integer, Integer> fourthTuple =
        tuple.fifth(previous -> -1);
    assertThat(fourthTuple, is(notNullValue()));
    assertThat(fourthTuple.size(), is(tuple.size()));
    assertThat(fourthTuple.first(), is(0));
    assertThat(fourthTuple.second(), is(1));
    assertThat(fourthTuple.third(), is(2));
    assertThat(fourthTuple.fourth(), is(3));
    assertThat(fourthTuple.fifth(), is(-1));
  }

  @Test
  public void droppingByIndex() {
    FiveTuple<Object, Integer, Integer, Integer, Integer, Integer> tuple =
        Tuple.five(0, 1, 2, 3, 4);
    for (int i = 0; i < 5; i++) {
      Tuple<?> other = tuple.drop(i);
      assertThat(other, is(notNullValue()));
      assertThat(other.size(), is(4));
      for (int j = 0; j < 5; j++) {
        if (j == i) {
          continue;
        }
        assertThat(other.get(j < i ? j : j - 1), is(tuple.get(j)));
      }
    }
  }

  @Test
  public void droppingFirstElementByAccessor() {
    FiveTuple<Object, Integer, Integer, Integer, Integer, Integer> tuple =
        Tuple.five(0, 1, 2, 3, 4);
    FourTuple<Object, Integer, Integer, Integer, Integer> other = tuple.dropFirst();
    assertThat(other, is(notNullValue()));
    assertThat(other.size(), is(4));
    assertThat(other.first(), is(tuple.second()));
    assertThat(other.second(), is(tuple.third()));
    assertThat(other.third(), is(tuple.fourth()));
    assertThat(other.fourth(), is(tuple.fifth()));
  }

  @Test
  public void droppingSecondElementByAccessor() {
    FiveTuple<Object, Integer, Integer, Integer, Integer, Integer> tuple =
        Tuple.five(0, 1, 2, 3, 4);
    FourTuple<Object, Integer, Integer, Integer, Integer> other = tuple.dropSecond();
    assertThat(other, is(notNullValue()));
    assertThat(other.size(), is(4));
    assertThat(other.first(), is(tuple.first()));
    assertThat(other.second(), is(tuple.third()));
    assertThat(other.third(), is(tuple.fourth()));
    assertThat(other.fourth(), is(tuple.fifth()));
  }

  @Test
  public void droppingThirdElementByAccessor() {
    FiveTuple<Object, Integer, Integer, Integer, Integer, Integer> tuple =
        Tuple.five(0, 1, 2, 3, 4);
    FourTuple<Object, Integer, Integer, Integer, Integer> other = tuple.dropThird();
    assertThat(other, is(notNullValue()));
    assertThat(other.size(), is(4));
    assertThat(other.first(), is(tuple.first()));
    assertThat(other.second(), is(tuple.second()));
    assertThat(other.third(), is(tuple.fourth()));
    assertThat(other.fourth(), is(tuple.fifth()));
  }

  @Test
  public void droppingFourthElementByAccessor() {
    FiveTuple<Object, Integer, Integer, Integer, Integer, Integer> tuple =
        Tuple.five(0, 1, 2, 3, 4);
    FourTuple<Object, Integer, Integer, Integer, Integer> other = tuple.dropFourth();
    assertThat(other, is(notNullValue()));
    assertThat(other.size(), is(4));
    assertThat(other.first(), is(tuple.first()));
    assertThat(other.second(), is(tuple.second()));
    assertThat(other.third(), is(tuple.third()));
    assertThat(other.fourth(), is(tuple.fifth()));
  }

  @Test
  public void droppingFifthElementByAccessor() {
    FiveTuple<Object, Integer, Integer, Integer, Integer, Integer> tuple =
        Tuple.five(0, 1, 2, 3, 4);
    FourTuple<Object, Integer, Integer, Integer, Integer> other = tuple.dropFifth();
    assertThat(other, is(notNullValue()));
    assertThat(other.size(), is(4));
    assertThat(other.first(), is(tuple.first()));
    assertThat(other.second(), is(tuple.second()));
    assertThat(other.third(), is(tuple.third()));
    assertThat(other.fourth(), is(tuple.fourth()));
  }

  @Test
  public void clearingTuple() {
    FiveTuple<Object, Integer, Integer, Integer, Integer, Integer> tuple =
        Tuple.five(0, 1, 2, 3, 4);
    Tuple<?> other = tuple.clear();
    assertThat(other, is(notNullValue()));
    assertThat(other.size(), is(0));
  }

  @Test
  public void streamingTuple() {
    FiveTuple<Object, Integer, Integer, Integer, Integer, Integer> tuple =
        Tuple.five(0, 1, 2, 3, 4);
    List<Object> items = tuple.stream().collect(toList());
    assertThat(items, is(hasSize(5)));
    assertThat(items, is(contains(0, 1, 2, 3, 4)));
  }

  @Test
  public void gettingTupleAsList() {
    FiveTuple<Object, Integer, Integer, Integer, Integer, Integer> tuple =
        Tuple.five(0, 1, 2, 3, 4);
    List<Object> items = tuple.asList();
    assertThat(items, is(hasSize(5)));
    assertThat(items, is(contains(0, 1, 2, 3, 4)));
  }

  @Test
  public void checkingPredicateByIndex() {
    FiveTuple<Integer, Integer, Integer, Integer, Integer, Integer> tuple =
        FiveTuple.of(0, 1, 2, 3, 4);
    for (int i = 0; i < 5; i++) {
      assertThat(tuple.check(i, x -> x % 2 == 0), is(i % 2 == 0));
    }
  }

  @Test
  public void checkingPredicateByAccessor() {
    FiveTuple<Integer, Integer, Integer, Integer, Integer, Integer> tuple =
        FiveTuple.of(0, 1, 2, 3, 4);
    assertThat(tuple.checkFirst(x -> x % 2 == 0), is(true));
    assertThat(tuple.checkSecond(x -> x % 2 == 0), is(false));
    assertThat(tuple.checkThird(x -> x % 2 == 0), is(true));
    assertThat(tuple.checkFourth(x -> x % 2 == 0), is(false));
    assertThat(tuple.checkFifth(x -> x % 2 == 0), is(true));
  }

  @Test
  public void extendingByValue() {
    FiveTuple<Integer, Integer, Integer, Integer, Integer, Integer> tuple =
        FiveTuple.of(0, 1, 2, 3, 4);
    SixTuple<Integer, Integer, Integer, Integer, Integer, Integer, Integer> secondTuple =
        FiveTuple.extendWith(-1).apply(tuple);
    assertThat(secondTuple, is(notNullValue()));
    assertThat(secondTuple.size(), is(6));
    assertThat(secondTuple.first(), is(tuple.first()));
    assertThat(secondTuple.second(), is(tuple.second()));
    assertThat(secondTuple.third(), is(tuple.third()));
    assertThat(secondTuple.fourth(), is(tuple.fourth()));
    assertThat(secondTuple.fifth(), is(tuple.fifth()));
    assertThat(secondTuple.sixth(), is(-1));
    assertThat(secondTuple.drop(5), is(tuple));
  }

  @Test
  public void extendingBySupplier() {
    FiveTuple<Integer, Integer, Integer, Integer, Integer, Integer> tuple =
        FiveTuple.of(0, 1, 2, 3, 4);
    SixTuple<Integer, Integer, Integer, Integer, Integer, Integer, Integer> secondTuple =
        FiveTuple.extendWith(() -> -1).apply(tuple);
    assertThat(secondTuple, is(notNullValue()));
    assertThat(secondTuple.size(), is(6));
    assertThat(secondTuple.first(), is(tuple.first()));
    assertThat(secondTuple.second(), is(tuple.second()));
    assertThat(secondTuple.third(), is(tuple.third()));
    assertThat(secondTuple.fourth(), is(tuple.fourth()));
    assertThat(secondTuple.fifth(), is(tuple.fifth()));
    assertThat(secondTuple.sixth(), is(-1));
    assertThat(secondTuple.drop(5), is(tuple));
  }

  @Test
  public void extendingByFunction() {
    FiveTuple<Integer, Integer, Integer, Integer, Integer, Integer> tuple =
        FiveTuple.of(0, 1, 2, 3, 4);
    SixTuple<Integer, Integer, Integer, Integer, Integer, Integer, Integer> secondTuple =
        FiveTuple.extendWith(
                (FiveTuple<Integer, Integer, Integer, Integer, Integer, Integer> t) -> -1)
            .apply(tuple);
    assertThat(secondTuple, is(notNullValue()));
    assertThat(secondTuple.size(), is(6));
    assertThat(secondTuple.first(), is(tuple.first()));
    assertThat(secondTuple.second(), is(tuple.second()));
    assertThat(secondTuple.third(), is(tuple.third()));
    assertThat(secondTuple.fourth(), is(tuple.fourth()));
    assertThat(secondTuple.fifth(), is(tuple.fifth()));
    assertThat(secondTuple.sixth(), is(-1));
    assertThat(secondTuple.drop(5), is(tuple));
  }

  @Test
  public void labelingTuple() {
    FiveTuple<Integer, Integer, Integer, Integer, Integer, Integer> tuple =
        FiveTuple.of(0, 1, 2, 3, 4);
    LabeledTuple<Integer> other = tuple.withLabels("e0", "e1", "e2", "e3", "e4");
    assertThat(other, is(notNullValue()));
    assertThat(other.size(), is(5));
    assertThat(other.labels(), is(contains("e0", "e1", "e2", "e3", "e4")));
    assertThat(other.get("e0"), is(tuple.get(0)));
    assertThat(other.get("e1"), is(tuple.get(1)));
    assertThat(other.get("e2"), is(tuple.get(2)));
    assertThat(other.get("e3"), is(tuple.get(3)));
    assertThat(other.get("e4"), is(tuple.get(4)));
    LabeledTuple<Integer> extended = other.extend(-1, "last");
    assertThat(extended, is(notNullValue()));
    assertThat(extended.size(), is(6));
    assertThat(extended.get("last"), is(-1));
  }

  @Test
  public void equality() {
    FiveTuple<Object, Integer, Integer, Integer, Integer, Integer> tuple =
        Tuple.five(0, 1, 2, 3, 4);
    FiveTuple<Object, Integer, Integer, Integer, Integer, Integer> secondTuple =
        Tuple.five(0, 1, 2, 3, 4);
    assertThat(tuple, is(secondTuple));
  }

  @Test
  public void hashCodeCalculation() {
    FiveTuple<Object, Integer, Integer, Integer, Integer, Integer> tuple =
        Tuple.five(0, 1, 2, 3, 4);
    FiveTuple<Object, Integer, Integer, Integer, Integer, Integer> secondTuple =
        Tuple.five(0, 1, 2, 3, 4);
    assertThat(tuple.hashCode(), is(secondTuple.hashCode()));
  }

  @Test
  public void toStringCalculation() {
    FiveTuple<Object, Integer, Integer, Integer, Integer, Integer> tuple =
        Tuple.five(0, 1, 2, 3, 4);
    FiveTuple<Object, Integer, Integer, Integer, Integer, Integer> secondTuple =
        Tuple.five(0, 1, 2, 3, 4);
    assertThat(tuple.toString(), is(secondTuple.toString()));
  }
}

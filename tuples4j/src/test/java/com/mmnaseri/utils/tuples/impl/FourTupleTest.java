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
 * Tests for {@link FourTuple}.
 *
 * @author Milad Naseri (m.m.naseri@gmail.com)
 */
public class FourTupleTest {

  @Test
  public void creatingTuple() {
    FourTuple<Object, Integer, Integer, Integer, Integer> tuple = Tuple.four(0, 1, 2, 3);
    assertThat(tuple, is(notNullValue()));
    assertThat(tuple.size(), is(4));
  }

  @Test
  public void accessingMembers() {
    FourTuple<Object, Integer, Integer, Integer, Integer> tuple = Tuple.four(0, 1, 2, 3);
    assertThat(tuple.get(0), is(0));
    assertThat(tuple.get(1), is(1));
    assertThat(tuple.get(2), is(2));
    assertThat(tuple.get(3), is(3));
  }

  @Test
  public void changingElementByIndex() {
    FourTuple<Object, Integer, Integer, Integer, Integer> tuple = Tuple.four(0, 1, 2, 3);
    for (int i = 0; i < 4; i++) {
      Tuple<?> other = tuple.change(i, -1);
      assertThat(other, is(notNullValue()));
      assertThat(other.size(), is(4));
      assertThat(other.get(i), is(-1));
    }
  }

  @Test
  public void changingElementByIndexThroughFunction() {
    FourTuple<Object, Integer, Integer, Integer, Integer> tuple = Tuple.four(0, 1, 2, 3);
    for (int i = 0; i < 4; i++) {
      Tuple<?> other = tuple.change(i, t -> -1);
      assertThat(other, is(notNullValue()));
      assertThat(other.size(), is(4));
      assertThat(other.get(i), is(-1));
    }
  }

  @Test
  public void changingFirstElementByAccessor() {
    FourTuple<Object, Integer, Integer, Integer, Integer> tuple = Tuple.four(0, 1, 2, 3);

    // Changing by value.
    FourTuple<Object, Integer, Integer, Integer, Integer> secondTuple = tuple.first(-1);
    assertThat(secondTuple, is(notNullValue()));
    assertThat(secondTuple.size(), is(tuple.size()));
    assertThat(secondTuple.first(), is(-1));
    assertThat(secondTuple.second(), is(1));
    assertThat(secondTuple.third(), is(2));
    assertThat(secondTuple.fourth(), is(3));

    // Changing by supplier.
    FourTuple<Object, Integer, Integer, Integer, Integer> thirdTuple = tuple.first(() -> -1);
    assertThat(thirdTuple, is(notNullValue()));
    assertThat(thirdTuple.size(), is(tuple.size()));
    assertThat(thirdTuple.first(), is(-1));
    assertThat(thirdTuple.second(), is(1));
    assertThat(thirdTuple.third(), is(2));
    assertThat(thirdTuple.fourth(), is(3));

    // Changing by function.
    FourTuple<Object, Integer, Integer, Integer, Integer> fourthTuple = tuple.first(previous -> -1);
    assertThat(fourthTuple, is(notNullValue()));
    assertThat(fourthTuple.size(), is(tuple.size()));
    assertThat(fourthTuple.first(), is(-1));
    assertThat(fourthTuple.second(), is(1));
    assertThat(fourthTuple.third(), is(2));
    assertThat(fourthTuple.fourth(), is(3));
  }

  @Test
  public void changingSecondElementByAccessor() {
    FourTuple<Object, Integer, Integer, Integer, Integer> tuple = Tuple.four(0, 1, 2, 3);

    // Changing by value.
    FourTuple<Object, Integer, Integer, Integer, Integer> secondTuple = tuple.second(-1);
    assertThat(secondTuple, is(notNullValue()));
    assertThat(secondTuple.size(), is(tuple.size()));
    assertThat(secondTuple.first(), is(0));
    assertThat(secondTuple.second(), is(-1));
    assertThat(secondTuple.third(), is(2));
    assertThat(secondTuple.fourth(), is(3));

    // Changing by supplier.
    FourTuple<Object, Integer, Integer, Integer, Integer> thirdTuple = tuple.second(() -> -1);
    assertThat(thirdTuple, is(notNullValue()));
    assertThat(thirdTuple.size(), is(tuple.size()));
    assertThat(thirdTuple.first(), is(0));
    assertThat(thirdTuple.second(), is(-1));
    assertThat(thirdTuple.third(), is(2));
    assertThat(thirdTuple.fourth(), is(3));

    // Changing by function.
    FourTuple<Object, Integer, Integer, Integer, Integer> fourthTuple =
        tuple.second(previous -> -1);
    assertThat(fourthTuple, is(notNullValue()));
    assertThat(fourthTuple.size(), is(tuple.size()));
    assertThat(fourthTuple.first(), is(0));
    assertThat(fourthTuple.second(), is(-1));
    assertThat(fourthTuple.third(), is(2));
    assertThat(fourthTuple.fourth(), is(3));
  }

  @Test
  public void changingThirdElementByAccessor() {
    FourTuple<Object, Integer, Integer, Integer, Integer> tuple = Tuple.four(0, 1, 2, 3);

    // Changing by value.
    FourTuple<Object, Integer, Integer, Integer, Integer> secondTuple = tuple.third(-1);
    assertThat(secondTuple, is(notNullValue()));
    assertThat(secondTuple.size(), is(tuple.size()));
    assertThat(secondTuple.first(), is(0));
    assertThat(secondTuple.second(), is(1));
    assertThat(secondTuple.third(), is(-1));
    assertThat(secondTuple.fourth(), is(3));

    // Changing by supplier.
    FourTuple<Object, Integer, Integer, Integer, Integer> thirdTuple = tuple.third(() -> -1);
    assertThat(thirdTuple, is(notNullValue()));
    assertThat(thirdTuple.size(), is(tuple.size()));
    assertThat(thirdTuple.first(), is(0));
    assertThat(thirdTuple.second(), is(1));
    assertThat(thirdTuple.third(), is(-1));
    assertThat(thirdTuple.fourth(), is(3));

    // Changing by function.
    FourTuple<Object, Integer, Integer, Integer, Integer> fourthTuple = tuple.third(previous -> -1);
    assertThat(fourthTuple, is(notNullValue()));
    assertThat(fourthTuple.size(), is(tuple.size()));
    assertThat(fourthTuple.first(), is(0));
    assertThat(fourthTuple.second(), is(1));
    assertThat(fourthTuple.third(), is(-1));
    assertThat(fourthTuple.fourth(), is(3));
  }

  @Test
  public void changingFourthElementByAccessor() {
    FourTuple<Object, Integer, Integer, Integer, Integer> tuple = Tuple.four(0, 1, 2, 3);

    // Changing by value.
    FourTuple<Object, Integer, Integer, Integer, Integer> secondTuple = tuple.fourth(-1);
    assertThat(secondTuple, is(notNullValue()));
    assertThat(secondTuple.size(), is(tuple.size()));
    assertThat(secondTuple.first(), is(0));
    assertThat(secondTuple.second(), is(1));
    assertThat(secondTuple.third(), is(2));
    assertThat(secondTuple.fourth(), is(-1));

    // Changing by supplier.
    FourTuple<Object, Integer, Integer, Integer, Integer> thirdTuple = tuple.fourth(() -> -1);
    assertThat(thirdTuple, is(notNullValue()));
    assertThat(thirdTuple.size(), is(tuple.size()));
    assertThat(thirdTuple.first(), is(0));
    assertThat(thirdTuple.second(), is(1));
    assertThat(thirdTuple.third(), is(2));
    assertThat(thirdTuple.fourth(), is(-1));

    // Changing by function.
    FourTuple<Object, Integer, Integer, Integer, Integer> fourthTuple =
        tuple.fourth(previous -> -1);
    assertThat(fourthTuple, is(notNullValue()));
    assertThat(fourthTuple.size(), is(tuple.size()));
    assertThat(fourthTuple.first(), is(0));
    assertThat(fourthTuple.second(), is(1));
    assertThat(fourthTuple.third(), is(2));
    assertThat(fourthTuple.fourth(), is(-1));
  }

  @Test
  public void droppingByIndex() {
    FourTuple<Object, Integer, Integer, Integer, Integer> tuple = Tuple.four(0, 1, 2, 3);
    for (int i = 0; i < 4; i++) {
      Tuple<?> other = tuple.drop(i);
      assertThat(other, is(notNullValue()));
      assertThat(other.size(), is(3));
      for (int j = 0; j < 4; j++) {
        if (j == i) {
          continue;
        }
        assertThat(other.get(j < i ? j : j - 1), is(tuple.get(j)));
      }
    }
  }

  @Test
  public void droppingFirstElementByAccessor() {
    FourTuple<Object, Integer, Integer, Integer, Integer> tuple = Tuple.four(0, 1, 2, 3);
    ThreeTuple<Object, Integer, Integer, Integer> other = tuple.dropFirst();
    assertThat(other, is(notNullValue()));
    assertThat(other.size(), is(3));
    assertThat(other.first(), is(tuple.second()));
    assertThat(other.second(), is(tuple.third()));
    assertThat(other.third(), is(tuple.fourth()));
  }

  @Test
  public void droppingSecondElementByAccessor() {
    FourTuple<Object, Integer, Integer, Integer, Integer> tuple = Tuple.four(0, 1, 2, 3);
    ThreeTuple<Object, Integer, Integer, Integer> other = tuple.dropSecond();
    assertThat(other, is(notNullValue()));
    assertThat(other.size(), is(3));
    assertThat(other.first(), is(tuple.first()));
    assertThat(other.second(), is(tuple.third()));
    assertThat(other.third(), is(tuple.fourth()));
  }

  @Test
  public void droppingThirdElementByAccessor() {
    FourTuple<Object, Integer, Integer, Integer, Integer> tuple = Tuple.four(0, 1, 2, 3);
    ThreeTuple<Object, Integer, Integer, Integer> other = tuple.dropThird();
    assertThat(other, is(notNullValue()));
    assertThat(other.size(), is(3));
    assertThat(other.first(), is(tuple.first()));
    assertThat(other.second(), is(tuple.second()));
    assertThat(other.third(), is(tuple.fourth()));
  }

  @Test
  public void droppingFourthElementByAccessor() {
    FourTuple<Object, Integer, Integer, Integer, Integer> tuple = Tuple.four(0, 1, 2, 3);
    ThreeTuple<Object, Integer, Integer, Integer> other = tuple.dropFourth();
    assertThat(other, is(notNullValue()));
    assertThat(other.size(), is(3));
    assertThat(other.first(), is(tuple.first()));
    assertThat(other.second(), is(tuple.second()));
    assertThat(other.third(), is(tuple.third()));
  }

  @Test
  public void clearingTuple() {
    FourTuple<Object, Integer, Integer, Integer, Integer> tuple = Tuple.four(0, 1, 2, 3);
    Tuple<?> other = tuple.clear();
    assertThat(other, is(notNullValue()));
    assertThat(other.size(), is(0));
  }

  @Test
  public void streamingTuple() {
    FourTuple<Object, Integer, Integer, Integer, Integer> tuple = Tuple.four(0, 1, 2, 3);
    List<Object> items = tuple.stream().collect(toList());
    assertThat(items, is(hasSize(4)));
    assertThat(items, is(contains(0, 1, 2, 3)));
  }

  @Test
  public void gettingTupleAsList() {
    FourTuple<Object, Integer, Integer, Integer, Integer> tuple = Tuple.four(0, 1, 2, 3);
    List<Object> items = tuple.asList();
    assertThat(items, is(hasSize(4)));
    assertThat(items, is(contains(0, 1, 2, 3)));
  }

  @Test
  public void checkingPredicateByIndex() {
    FourTuple<Integer, Integer, Integer, Integer, Integer> tuple = FourTuple.of(0, 1, 2, 3);
    for (int i = 0; i < 4; i++) {
      assertThat(tuple.check(i, x -> x % 2 == 0), is(i % 2 == 0));
    }
  }

  @Test
  public void checkingPredicateByAccessor() {
    FourTuple<Integer, Integer, Integer, Integer, Integer> tuple = FourTuple.of(0, 1, 2, 3);
    assertThat(tuple.checkFirst(x -> x % 2 == 0), is(true));
    assertThat(tuple.checkSecond(x -> x % 2 == 0), is(false));
    assertThat(tuple.checkThird(x -> x % 2 == 0), is(true));
    assertThat(tuple.checkFourth(x -> x % 2 == 0), is(false));
  }

  @Test
  public void extendingByValue() {
    FourTuple<Integer, Integer, Integer, Integer, Integer> tuple = FourTuple.of(0, 1, 2, 3);
    FiveTuple<Integer, Integer, Integer, Integer, Integer, Integer> secondTuple =
        FourTuple.extendWith(-1).apply(tuple);
    assertThat(secondTuple, is(notNullValue()));
    assertThat(secondTuple.size(), is(5));
    assertThat(secondTuple.first(), is(tuple.first()));
    assertThat(secondTuple.second(), is(tuple.second()));
    assertThat(secondTuple.third(), is(tuple.third()));
    assertThat(secondTuple.fourth(), is(tuple.fourth()));
    assertThat(secondTuple.fifth(), is(-1));
    assertThat(secondTuple.drop(4), is(tuple));
  }

  @Test
  public void extendingBySupplier() {
    FourTuple<Integer, Integer, Integer, Integer, Integer> tuple = FourTuple.of(0, 1, 2, 3);
    FiveTuple<Integer, Integer, Integer, Integer, Integer, Integer> secondTuple =
        FourTuple.extendWith(() -> -1).apply(tuple);
    assertThat(secondTuple, is(notNullValue()));
    assertThat(secondTuple.size(), is(5));
    assertThat(secondTuple.first(), is(tuple.first()));
    assertThat(secondTuple.second(), is(tuple.second()));
    assertThat(secondTuple.third(), is(tuple.third()));
    assertThat(secondTuple.fourth(), is(tuple.fourth()));
    assertThat(secondTuple.fifth(), is(-1));
    assertThat(secondTuple.drop(4), is(tuple));
  }

  @Test
  public void extendingByFunction() {
    FourTuple<Integer, Integer, Integer, Integer, Integer> tuple = FourTuple.of(0, 1, 2, 3);
    FiveTuple<Integer, Integer, Integer, Integer, Integer, Integer> secondTuple =
        FourTuple.extendWith((FourTuple<Integer, Integer, Integer, Integer, Integer> t) -> -1)
            .apply(tuple);
    assertThat(secondTuple, is(notNullValue()));
    assertThat(secondTuple.size(), is(5));
    assertThat(secondTuple.first(), is(tuple.first()));
    assertThat(secondTuple.second(), is(tuple.second()));
    assertThat(secondTuple.third(), is(tuple.third()));
    assertThat(secondTuple.fourth(), is(tuple.fourth()));
    assertThat(secondTuple.fifth(), is(-1));
    assertThat(secondTuple.drop(4), is(tuple));
  }

  @Test
  public void labelingTuple() {
    FourTuple<Integer, Integer, Integer, Integer, Integer> tuple = FourTuple.of(0, 1, 2, 3);
    LabeledTuple<Integer> other = tuple.withLabels("e0", "e1", "e2", "e3");
    assertThat(other, is(notNullValue()));
    assertThat(other.size(), is(4));
    assertThat(other.labels(), is(contains("e0", "e1", "e2", "e3")));
    assertThat(other.get("e0"), is(tuple.get(0)));
    assertThat(other.get("e1"), is(tuple.get(1)));
    assertThat(other.get("e2"), is(tuple.get(2)));
    assertThat(other.get("e3"), is(tuple.get(3)));
    LabeledTuple<Integer> extended = other.extend(-1, "last");
    assertThat(extended, is(notNullValue()));
    assertThat(extended.size(), is(5));
    assertThat(extended.get("last"), is(-1));
  }

  @Test
  public void equality() {
    FourTuple<Object, Integer, Integer, Integer, Integer> tuple = Tuple.four(0, 1, 2, 3);
    FourTuple<Object, Integer, Integer, Integer, Integer> secondTuple = Tuple.four(0, 1, 2, 3);
    assertThat(tuple, is(secondTuple));
  }

  @Test
  public void hashCodeCalculation() {
    FourTuple<Object, Integer, Integer, Integer, Integer> tuple = Tuple.four(0, 1, 2, 3);
    FourTuple<Object, Integer, Integer, Integer, Integer> secondTuple = Tuple.four(0, 1, 2, 3);
    assertThat(tuple.hashCode(), is(secondTuple.hashCode()));
  }

  @Test
  public void toStringCalculation() {
    FourTuple<Object, Integer, Integer, Integer, Integer> tuple = Tuple.four(0, 1, 2, 3);
    FourTuple<Object, Integer, Integer, Integer, Integer> secondTuple = Tuple.four(0, 1, 2, 3);
    assertThat(tuple.toString(), is(secondTuple.toString()));
  }
}

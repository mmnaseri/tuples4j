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

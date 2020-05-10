package com.mmnaseri.utils.tuples.impl;

import com.mmnaseri.utils.tuples.LabeledTuple;
import com.mmnaseri.utils.tuples.Tuple;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.function.Supplier;

import static java.util.stream.Collectors.toList;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class DelegatingLabeledTupleTest {

  private LabeledTuple<Integer> tuple;
  private DelegatingLabeledTuple<Integer> delegatingTuple;

  @BeforeMethod
  public void setUp() {
    tuple = Tuple.of(1, 2, 3).tighten(Integer.class).withLabels("a", "b", "c");
    delegatingTuple = new DelegatingLabeledTuple<>(tuple);
  }

  @Test
  public void testLabels() {
    assertThat(delegatingTuple.labels(), is(tuple.labels()));
  }

  @Test
  public void testSize() {
    assertThat(delegatingTuple.size(), is(tuple.size()));
  }

  @Test
  public void testGet() {
    assertThat(delegatingTuple.get(1), is(tuple.get(1)));
  }

  @Test
  public void testChange() {
    assertThat(delegatingTuple.change(1, () -> 13), is(tuple.change(1, () -> 13)));
  }

  @Test
  public void testDrop() {
    assertThat(delegatingTuple.drop(0), is(tuple.drop(0)));
  }

  @Test
  public void testRelabel() {
    assertThat(delegatingTuple.relabel(0, "x"), is(tuple.relabel(0, "x")));
  }

  @Test
  public void testExtend() {
    assertThat(delegatingTuple.extend(13), is(tuple.extend(13)));
    assertThat(
        delegatingTuple.extend((Supplier<Integer>) () -> 13),
        is(tuple.extend((Supplier<Integer>) () -> 13)));
  }

  @Test
  public void testAsMap() {
    assertThat(delegatingTuple.asMap(), is(tuple.asMap()));
  }

  @Test
  public void testStream() {
    assertThat(delegatingTuple.stream().collect(toList()), is(tuple.stream().collect(toList())));
  }

  @Test
  public void testAsList() {
    assertThat(delegatingTuple.asList(), is(tuple.asList()));
  }

  @Test
  public void testClear() {
    assertThat(delegatingTuple.clear(), is(tuple.clear()));
  }
}

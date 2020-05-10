package com.mmnaseri.utils.tuples.impl;

import com.mmnaseri.utils.tuples.Tuple;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static java.util.stream.Collectors.toList;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class DelegatingTupleTest {

  private Tuple<Integer> tuple;
  private DelegatingTuple<Integer> delegatingTuple;

  @BeforeMethod
  public void setUp() {
    tuple = Tuple.of(1, 2, 3, 4).tighten(Integer.class);
    delegatingTuple = new DelegatingTuple<>(tuple);
  }

  @Test
  public void testSize() {
    assertThat(delegatingTuple.size(), is(tuple.size()));
  }

  @Test
  public void testGet() {
    assertThat(delegatingTuple.get(0), is(tuple.get(0)));
  }

  @Test
  public void testChange() {
    assertThat(delegatingTuple.change(0, () -> 13), is(tuple.change(0, () -> 13)));
  }

  @Test
  public void testDrop() {
    assertThat(delegatingTuple.drop(1), is(tuple.drop(1)));
  }

  @Test
  public void testExtend() {
    assertThat(delegatingTuple.extend(12), is(tuple.extend(12)));
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

package com.mmnaseri.utils.tuples.utils;

import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.isIn;
import static org.hamcrest.Matchers.notNullValue;

public class FluentMapTest {

  @Test
  public void testAddingSingleItem() {
    FluentMap<String, Integer> map = FluentMap.of(Collections.emptyMap());
    assertThat(map, is(notNullValue()));
    assertThat(map.size(), is(0));
    FluentMap<String, Integer> other = map.with("k1", 1);
    assertThat(map.size(), is(0));
    assertThat(other.size(), is(1));
    assertThat(other.keySet(), contains("k1"));
    assertThat(other.values(), contains(1));
  }

  @Test
  public void testAddingMultipleItems() {
    FluentMap<String, Integer> map = FluentMap.of(Collections.emptyMap());
    assertThat(map, is(notNullValue()));
    assertThat(map.size(), is(0));
    Map<String, Integer> interim = new HashMap<>();
    interim.put("a", 1);
    interim.put("b", 2);
    FluentMap<String, Integer> other = map.with(interim);
    assertThat(map.size(), is(0));
    assertThat(other.size(), is(2));
    assertThat(other.keySet(), contains("a", "b"));
    assertThat(other.values(), contains(1, 2));
    assertThat(other.get("a"), is(1));
    assertThat(other.get("b"), is(2));
  }

  @Test
  public void testRemovingItemByKey() {
    FluentMap<String, Integer> map = FluentMap.of("a", 1).with("b", 2).with("c", 3);
    assertThat(map.keySet(), contains("a", "b", "c"));
    assertThat(map.get("a"), is(1));
    assertThat(map.get("b"), is(2));
    assertThat(map.get("c"), is(3));
    FluentMap<String, Integer> other = map.without("b");
    assertThat(other.size(), is(2));
    assertThat(other.keySet(), contains("a", "c"));
    assertThat(other.get("a"), is(1));
    assertThat(other.get("c"), is(3));
    assertThat(other.containsKey("b"), is(false));
    FluentMap<String, Integer> unchanged = other.without("d");
    assertThat(unchanged, is(other));
  }

  @Test
  public void testRemovingItemByKeyAndValue() {
    FluentMap<String, Integer> map = FluentMap.of("a", 1).with("b", 2).with("c", 3);
    assertThat(map.keySet(), contains("a", "b", "c"));
    assertThat(map.get("a"), is(1));
    assertThat(map.get("b"), is(2));
    assertThat(map.get("c"), is(3));
    FluentMap<String, Integer> unchanged = map.without("b", 3);
    assertThat(unchanged, is(map));
    FluentMap<String, Integer> other = map.without("b", 2);
    assertThat(other.size(), is(2));
    assertThat(other.keySet(), contains("a", "c"));
    assertThat(other.get("a"), is(1));
    assertThat(other.get("c"), is(3));
    assertThat(other.containsKey("b"), is(false));
  }

  @Test
  public void testCreatingInverse() {
    FluentMap<String, Integer> map = FluentMap.of("a", 1).with("b", 2).with("c", 1).with("d", 2);
    FluentMap<Integer, Set<String>> inverse = map.inverse();
    assertThat(inverse.size(), is(2));
    assertThat(inverse.keySet(), contains(1, 2));
    assertThat(inverse.get(1), hasSize(2));
    assertThat(inverse.get(1), contains("a", "c"));
    assertThat(inverse.get(2), hasSize(2));
    assertThat(inverse.get(2), contains("b", "d"));
  }

  @Test
  public void testCreatingLossyInverse() {
    FluentMap<String, Integer> map = FluentMap.of("a", 1).with("b", 2).with("c", 1).with("d", 2);
    FluentMap<Integer, String> inverse = map.inverseLossy();
    assertThat(inverse.size(), is(2));
    assertThat(inverse.keySet(), contains(1, 2));
    assertThat(inverse.get(1), isIn(Arrays.asList("a", "c")));
    assertThat(inverse.get(2), isIn(Arrays.asList("b", "d")));
  }
}

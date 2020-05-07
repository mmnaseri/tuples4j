package com.mmnaseri.utils.tuples;

import com.mmnaseri.utils.tuples.impl.DefaultLabeledTuple;
import com.mmnaseri.utils.tuples.utils.FluentMap;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.is;

public class LabeledTupleTest {

    @Test
    public void testCreatingLabeledTuple() {
        LabeledTuple<Object> tuple = LabeledTuple.of("a", 1, "b", 2, "c", 3);
        LabeledTuple<Integer> tightened = tuple.tighten();
        assertThat(tightened.size(), is(3));
        assertThat(tightened.labels(), contains("a", "b", "c"));
        assertThat(tightened.get("a"), is(1));
        assertThat(tightened.get("b"), is(2));
        assertThat(tightened.get("c"), is(3));
    }

    @Test(expectedExceptions = IllegalArgumentException.class, expectedExceptionsMessageRegExp = "Expected 3 labels, but received 2")
    public void testCreatingTupleWithInsufficientLabels() {
        new DefaultLabeledTuple<>(Tuple.of(1, 2, 3), "a", "b");
    }

    @Test(expectedExceptions = IllegalArgumentException.class, expectedExceptionsMessageRegExp = "Provided set of labels contains duplicates: \\[a, a, b]")
    public void testCreatingTupleWithDuplicateLabels() {
        new DefaultLabeledTuple<>(Tuple.of(1, 2, 3), "a", "a", "b");
    }

    @Test(expectedExceptions = IllegalArgumentException.class, expectedExceptionsMessageRegExp = "Label a already exists on this tuple")
    public void testExtendingWithDuplicateLabel() {
        LabeledTuple.of("a", 1).extend(2, "a");
    }

    @Test(expectedExceptions = IndexOutOfBoundsException.class, expectedExceptionsMessageRegExp = "Index out of range: b")
    public void testAccessingFromIncorrectLabel() {
        LabeledTuple<Object> tuple = LabeledTuple.of("a", 1);
        tuple.get("b");
    }

    @Test
    public void testRelabeling() {
        LabeledTuple<Object> tuple = LabeledTuple.of("a", 1);
        assertThat(tuple.get("a"), is(1));
        LabeledTuple<Object> relabeled = tuple.relabel("a", "b");
        assertThat(tuple.get("a"), is(1));
        assertThat(relabeled.has("a"), is(false));
        assertThat(relabeled.get("b"), is(1));
    }

    @Test
    public void testExtendingTuple() {
        LabeledTuple<Object> tuple = LabeledTuple.of("a", 1, "b", 2).extend(() -> 3, "c");
        LabeledTuple<Integer> tightened = tuple.tighten();
        assertThat(tightened.size(), is(3));
        assertThat(tightened.labels(), contains("a", "b", "c"));
        assertThat(tightened.get("a"), is(1));
        assertThat(tightened.get("b"), is(2));
        assertThat(tightened.get("c"), is(3));
    }

    @Test
    public void testChangingValues() {
        LabeledTuple<Object> tuple = LabeledTuple.of("a", 1);
        LabeledTuple<Object> changed = tuple.change("a", 2);
        assertThat(tuple.get("a"), is(1));
        assertThat(changed.get("a"), is(2));
    }

    @Test
    public void testChangingValuesByIndex() {
        LabeledTuple<Object> tuple = LabeledTuple.of("a", 1);
        LabeledTuple<Object> changed = tuple.change(0, 2);
        assertThat(tuple.get("a"), is(1));
        assertThat(changed.get("a"), is(2));
    }

    @Test
    public void testDroppingByName() {
        LabeledTuple<Object> tuple = LabeledTuple.of("a", 1, "b", 2);
        assertThat(tuple.size(), is(2));
        LabeledTuple<Object> dropped = tuple.drop("b");
        assertThat(tuple.size(), is(2));
        assertThat(dropped.size(), is(1));
        assertThat(dropped.has("b"), is(false));
    }

    @Test
    public void testConvertingToMap() {
        LabeledTuple<Object> tuple = LabeledTuple.of("a", 1, "b", 2);
        LabeledTuple<Integer> tightened = tuple.tighten();
        FluentMap<String, Integer> map = tightened.asMap();
        assertThat(map.size(), is(2));
        assertThat(map.get("a"), is(1));
        assertThat(map.get("b"), is(2));
    }

    @Test
    public void testConvertingToList() {
        LabeledTuple<Object> tuple = LabeledTuple.of("a", 1, "b", 2);
        LabeledTuple<Integer> tightened = tuple.tighten();
        assertThat(tightened.asList(), contains(1, 2));
    }

    @Test
    public void testClearing() {
        LabeledTuple<Object> tuple = LabeledTuple.of("a", 1, "b", 2);
        assertThat(tuple.size(), is(2));
        LabeledTuple<Object> cleared = tuple.clear();
        assertThat(cleared.size(), is(0));
    }

    @Test
    public void testEquality() {
        LabeledTuple<Object> tuple = LabeledTuple.of("a", 1, "b", 2);
        LabeledTuple<Object> other = LabeledTuple.empty().extend(1, "a").extend(2, "b");
        assertThat(tuple, is(other));
        assertThat(tuple.hashCode(), is(other.hashCode()));
        assertThat(tuple.toString(), is(other.toString()));
    }
}
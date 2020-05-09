package com.mmnaseri.utils.tuples.impl;

import com.mmnaseri.utils.tuples.LabeledTuple;
import com.mmnaseri.utils.tuples.Tuple;
import org.testng.annotations.Test;

import java.util.List;

import static java.util.stream.Collectors.toList;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;

/**
 * Tests for {@link EmptyTuple}.
 *
 * @author Milad Naseri (m.m.naseri@gmail.com)
 */
public class EmptyTupleTest {

    @Test
    public void creatingTuple() {
        EmptyTuple<Object> tuple = Tuple.empty();
        assertThat(tuple, is(notNullValue()));
        assertThat(tuple.size(), is(0));
    }

    @Test
    public void clearingTuple() {
        EmptyTuple<Object> tuple = Tuple.empty();
        Tuple<?> other = tuple.clear();
        assertThat(other, is(notNullValue()));
        assertThat(other.size(), is(0));
    }

    @Test
    public void streamingTuple() {
        EmptyTuple<Object> tuple = Tuple.empty();
        List<Object> items = tuple.stream().collect(toList());
        assertThat(items, is(hasSize(0)));
    }

    @Test
    public void gettingTupleAsList() {
        EmptyTuple<Object> tuple = Tuple.empty();
        List<Object> items = tuple.asList();
        assertThat(items, is(hasSize(0)));
    }

    @Test
    public void extendingByValue() {
        EmptyTuple<Integer> tuple = EmptyTuple.of();
        OneTuple<Integer, Integer> secondTuple = EmptyTuple.extendWith(-1).apply(tuple);
        assertThat(secondTuple, is(notNullValue()));
        assertThat(secondTuple.size(), is(1));
        assertThat(secondTuple.first(), is(-1));
        assertThat(secondTuple.drop(0), is(tuple));
    }

    @Test
    public void extendingBySupplier() {
        EmptyTuple<Integer> tuple = EmptyTuple.of();
        OneTuple<Integer, Integer> secondTuple = EmptyTuple.extendWith(() -> -1).apply(tuple);
        assertThat(secondTuple, is(notNullValue()));
        assertThat(secondTuple.size(), is(1));
        assertThat(secondTuple.first(), is(-1));
        assertThat(secondTuple.drop(0), is(tuple));
    }

    @Test
    public void extendingByFunction() {
        EmptyTuple<Integer> tuple = EmptyTuple.of();
        OneTuple<Integer, Integer> secondTuple = EmptyTuple.extendWith((EmptyTuple<Integer> t) -> -1).apply(tuple);
        assertThat(secondTuple, is(notNullValue()));
        assertThat(secondTuple.size(), is(1));
        assertThat(secondTuple.first(), is(-1));
        assertThat(secondTuple.drop(0), is(tuple));
    }

    @Test
    public void labelingTuple() {
        EmptyTuple<Integer> tuple = EmptyTuple.of();
        LabeledTuple<Integer> other = tuple.withLabels();
        assertThat(other, is(notNullValue()));
        assertThat(other.size(), is(0));
        LabeledTuple<Integer> extended = other.extend(-1, "last");
        assertThat(extended, is(notNullValue()));
        assertThat(extended.size(), is(1));
        assertThat(extended.get("last"), is(-1));
    }

    @Test
    public void equality() {
        EmptyTuple<Object> tuple = Tuple.empty();
        EmptyTuple<Object> secondTuple = Tuple.empty();
        assertThat(tuple, is(secondTuple));
    }

    @Test
    public void hashCodeCalculation() {
        EmptyTuple<Object> tuple = Tuple.empty();
        EmptyTuple<Object> secondTuple = Tuple.empty();
        assertThat(tuple.hashCode(), is(secondTuple.hashCode()));
    }

    @Test
    public void toStringCalculation() {
        EmptyTuple<Object> tuple = Tuple.empty();
        EmptyTuple<Object> secondTuple = Tuple.empty();
        assertThat(tuple.toString(), is(secondTuple.toString()));
    }

    @Test(expectedExceptions = IndexOutOfBoundsException.class)
    public void testChangeBySupplier() {
        Tuple.empty().change(0, () -> 1);
    }

    @Test(expectedExceptions = IndexOutOfBoundsException.class)
    public void testChangeByValue() {
        Tuple.empty().change(0, 1);
    }

    @Test(expectedExceptions = IllegalStateException.class, expectedExceptionsMessageRegExp = "Expected a size of at least 1 but received 0")
    public void testResizing() {
        Tuple.empty().asOne();
    }

    @Test
    public void testResizingToEmpty() {
        EmptyTuple<Object> empty = Tuple.empty().asEmpty();
        assertThat(empty, is(notNullValue()));
        assertThat(empty.size(), is(0));
    }
}


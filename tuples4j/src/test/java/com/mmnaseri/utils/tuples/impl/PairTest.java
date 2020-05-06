package com.mmnaseri.utils.tuples.impl;

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
 * Tests for {@link Pair}.
 *
 * @author Milad Naseri (m.m.naseri@gmail.com)
 */
public class PairTest {

    @Test
    public void creatingTuple() {
        Pair<Integer, Integer> tuple = Pair.create(0, 1);
        assertThat(tuple, is(notNullValue()));
        assertThat(tuple.size(), is(2));
    }

    @Test
    public void accessingMembers() {
        Pair<Integer, Integer> tuple = Pair.create(0, 1);
        assertThat(tuple.get(0), is(0));
        assertThat(tuple.get(1), is(1));
    }

    @Test
    public void changingElementByIndex() {
        Pair<Integer, Integer> tuple = Pair.create(0, 1);
        for (int i = 0; i < 2; i++) {
            Tuple<?> other = tuple.change(i, -1);
            assertThat(other, is(notNullValue()));
            assertThat(other.size(), is(2));
            assertThat(other.get(i), is(-1));
        }
    }

    @Test
    public void changingElementByIndexThroughFunction() {
        Pair<Integer, Integer> tuple = Pair.create(0, 1);
        for (int i = 0; i < 2; i++) {
            Tuple<?> other = tuple.change(i, t -> -1);
            assertThat(other, is(notNullValue()));
            assertThat(other.size(), is(2));
            assertThat(other.get(i), is(-1));
        }
    }

    @Test
    public void changingFirstElementByAccessor() {
        Pair<Integer, Integer> tuple = Pair.create(0, 1);

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
        Pair<Integer, Integer> tuple = Pair.create(0, 1);

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
        Pair<Integer, Integer> tuple = Pair.create(0, 1);
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
        Pair<Integer, Integer> tuple = Pair.create(0, 1);
        OneTuple<Object, Integer> other = tuple.dropFirst();
        assertThat(other, is(notNullValue()));
        assertThat(other.size(), is(1));
        assertThat(other.first(), is(tuple.second()));
    }

    @Test
    public void droppingSecondElementByAccessor() {
        Pair<Integer, Integer> tuple = Pair.create(0, 1);
        OneTuple<Object, Integer> other = tuple.dropSecond();
        assertThat(other, is(notNullValue()));
        assertThat(other.size(), is(1));
        assertThat(other.first(), is(tuple.first()));
    }

    @Test
    public void clearingTuple() {
        Pair<Integer, Integer> tuple = Pair.create(0, 1);
        Tuple<?> other = tuple.clear();
        assertThat(other, is(notNullValue()));
        assertThat(other.size(), is(0));
    }

    @Test
    public void streamingTuple() {
        Pair<Integer, Integer> tuple = Pair.create(0, 1);
        List<Object> items = tuple.stream().collect(toList());
        assertThat(items, is(hasSize(2)));
        assertThat(items, is(contains(0, 1)));
    }

    @Test
    public void gettingTupleAsList() {
        Pair<Integer, Integer> tuple = Pair.create(0, 1);
        List<Object> items = tuple.asList();
        assertThat(items, is(hasSize(2)));
        assertThat(items, is(contains(0, 1)));
    }

    @Test
    public void equality() {
        Pair<Integer, Integer> tuple = Pair.create(0, 1);
        Pair<Integer, Integer> secondTuple = Pair.create(0, 1);
        assertThat(tuple, is(secondTuple));
    }

    @Test
    public void hashCodeCalculation() {
        Pair<Integer, Integer> tuple = Pair.create(0, 1);
        Pair<Integer, Integer> secondTuple = Pair.create(0, 1);
        assertThat(tuple.hashCode(), is(secondTuple.hashCode()));
    }

    @Test
    public void toStringCalculation() {
        Pair<Integer, Integer> tuple = Pair.create(0, 1);
        Pair<Integer, Integer> secondTuple = Pair.create(0, 1);
        assertThat(tuple.toString(), is(secondTuple.toString()));
    }

}


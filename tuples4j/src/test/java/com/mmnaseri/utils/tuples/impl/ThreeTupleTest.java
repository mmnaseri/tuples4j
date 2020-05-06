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
 * Tests for {@link ThreeTuple}.
 *
 * @author Milad Naseri (m.m.naseri@gmail.com)
 */
public class ThreeTupleTest {

    @Test
    public void creatingTuple() {
        ThreeTuple<Object, Integer, Integer, Integer> tuple = Tuple.three(0, 1, 2);
        assertThat(tuple, is(notNullValue()));
        assertThat(tuple.size(), is(3));
    }

    @Test
    public void accessingMembers() {
        ThreeTuple<Object, Integer, Integer, Integer> tuple = Tuple.three(0, 1, 2);
        assertThat(tuple.get(0), is(0));
        assertThat(tuple.get(1), is(1));
        assertThat(tuple.get(2), is(2));
    }

    @Test
    public void changingElementByIndex() {
        ThreeTuple<Object, Integer, Integer, Integer> tuple = Tuple.three(0, 1, 2);
        for (int i = 0; i < 3; i++) {
            Tuple<?> other = tuple.change(i, -1);
            assertThat(other, is(notNullValue()));
            assertThat(other.size(), is(3));
            assertThat(other.get(i), is(-1));
        }
    }

    @Test
    public void changingElementByIndexThroughFunction() {
        ThreeTuple<Object, Integer, Integer, Integer> tuple = Tuple.three(0, 1, 2);
        for (int i = 0; i < 3; i++) {
            Tuple<?> other = tuple.change(i, t -> -1);
            assertThat(other, is(notNullValue()));
            assertThat(other.size(), is(3));
            assertThat(other.get(i), is(-1));
        }
    }

    @Test
    public void changingFirstElementByAccessor() {
        ThreeTuple<Object, Integer, Integer, Integer> tuple = Tuple.three(0, 1, 2);

        // Changing by value.
        ThreeTuple<Object, Integer, Integer, Integer> secondTuple = tuple.first(-1);
        assertThat(secondTuple, is(notNullValue()));
        assertThat(secondTuple.size(), is(tuple.size()));
        assertThat(secondTuple.first(), is(-1));
        assertThat(secondTuple.second(), is(1));
        assertThat(secondTuple.third(), is(2));

        // Changing by supplier.
        ThreeTuple<Object, Integer, Integer, Integer> thirdTuple = tuple.first(() -> -1);
        assertThat(thirdTuple, is(notNullValue()));
        assertThat(thirdTuple.size(), is(tuple.size()));
        assertThat(thirdTuple.first(), is(-1));
        assertThat(thirdTuple.second(), is(1));
        assertThat(thirdTuple.third(), is(2));

        // Changing by function.
        ThreeTuple<Object, Integer, Integer, Integer> fourthTuple = tuple.first(previous -> -1);
        assertThat(fourthTuple, is(notNullValue()));
        assertThat(fourthTuple.size(), is(tuple.size()));
        assertThat(fourthTuple.first(), is(-1));
        assertThat(fourthTuple.second(), is(1));
        assertThat(fourthTuple.third(), is(2));
    }

    @Test
    public void changingSecondElementByAccessor() {
        ThreeTuple<Object, Integer, Integer, Integer> tuple = Tuple.three(0, 1, 2);

        // Changing by value.
        ThreeTuple<Object, Integer, Integer, Integer> secondTuple = tuple.second(-1);
        assertThat(secondTuple, is(notNullValue()));
        assertThat(secondTuple.size(), is(tuple.size()));
        assertThat(secondTuple.first(), is(0));
        assertThat(secondTuple.second(), is(-1));
        assertThat(secondTuple.third(), is(2));

        // Changing by supplier.
        ThreeTuple<Object, Integer, Integer, Integer> thirdTuple = tuple.second(() -> -1);
        assertThat(thirdTuple, is(notNullValue()));
        assertThat(thirdTuple.size(), is(tuple.size()));
        assertThat(thirdTuple.first(), is(0));
        assertThat(thirdTuple.second(), is(-1));
        assertThat(thirdTuple.third(), is(2));

        // Changing by function.
        ThreeTuple<Object, Integer, Integer, Integer> fourthTuple = tuple.second(previous -> -1);
        assertThat(fourthTuple, is(notNullValue()));
        assertThat(fourthTuple.size(), is(tuple.size()));
        assertThat(fourthTuple.first(), is(0));
        assertThat(fourthTuple.second(), is(-1));
        assertThat(fourthTuple.third(), is(2));
    }

    @Test
    public void changingThirdElementByAccessor() {
        ThreeTuple<Object, Integer, Integer, Integer> tuple = Tuple.three(0, 1, 2);

        // Changing by value.
        ThreeTuple<Object, Integer, Integer, Integer> secondTuple = tuple.third(-1);
        assertThat(secondTuple, is(notNullValue()));
        assertThat(secondTuple.size(), is(tuple.size()));
        assertThat(secondTuple.first(), is(0));
        assertThat(secondTuple.second(), is(1));
        assertThat(secondTuple.third(), is(-1));

        // Changing by supplier.
        ThreeTuple<Object, Integer, Integer, Integer> thirdTuple = tuple.third(() -> -1);
        assertThat(thirdTuple, is(notNullValue()));
        assertThat(thirdTuple.size(), is(tuple.size()));
        assertThat(thirdTuple.first(), is(0));
        assertThat(thirdTuple.second(), is(1));
        assertThat(thirdTuple.third(), is(-1));

        // Changing by function.
        ThreeTuple<Object, Integer, Integer, Integer> fourthTuple = tuple.third(previous -> -1);
        assertThat(fourthTuple, is(notNullValue()));
        assertThat(fourthTuple.size(), is(tuple.size()));
        assertThat(fourthTuple.first(), is(0));
        assertThat(fourthTuple.second(), is(1));
        assertThat(fourthTuple.third(), is(-1));
    }

    @Test
    public void droppingByIndex() {
        ThreeTuple<Object, Integer, Integer, Integer> tuple = Tuple.three(0, 1, 2);
        for (int i = 0; i < 3; i++) {
            Tuple<?> other = tuple.drop(i);
            assertThat(other, is(notNullValue()));
            assertThat(other.size(), is(2));
            for (int j = 0; j < 3; j++) {
                if (j == i) {
                    continue;
                }
                assertThat(other.get(j < i ? j : j - 1), is(tuple.get(j)));
            }
        }
    }

    @Test
    public void droppingFirstElementByAccessor() {
        ThreeTuple<Object, Integer, Integer, Integer> tuple = Tuple.three(0, 1, 2);
        TwoTuple<Object, Integer, Integer> other = tuple.dropFirst();
        assertThat(other, is(notNullValue()));
        assertThat(other.size(), is(2));
        assertThat(other.first(), is(tuple.second()));
        assertThat(other.second(), is(tuple.third()));
    }

    @Test
    public void droppingSecondElementByAccessor() {
        ThreeTuple<Object, Integer, Integer, Integer> tuple = Tuple.three(0, 1, 2);
        TwoTuple<Object, Integer, Integer> other = tuple.dropSecond();
        assertThat(other, is(notNullValue()));
        assertThat(other.size(), is(2));
        assertThat(other.first(), is(tuple.first()));
        assertThat(other.second(), is(tuple.third()));
    }

    @Test
    public void droppingThirdElementByAccessor() {
        ThreeTuple<Object, Integer, Integer, Integer> tuple = Tuple.three(0, 1, 2);
        TwoTuple<Object, Integer, Integer> other = tuple.dropThird();
        assertThat(other, is(notNullValue()));
        assertThat(other.size(), is(2));
        assertThat(other.first(), is(tuple.first()));
        assertThat(other.second(), is(tuple.second()));
    }

    @Test
    public void clearingTuple() {
        ThreeTuple<Object, Integer, Integer, Integer> tuple = Tuple.three(0, 1, 2);
        Tuple<?> other = tuple.clear();
        assertThat(other, is(notNullValue()));
        assertThat(other.size(), is(0));
    }

    @Test
    public void streamingTuple() {
        ThreeTuple<Object, Integer, Integer, Integer> tuple = Tuple.three(0, 1, 2);
        List<Object> items = tuple.stream().collect(toList());
        assertThat(items, is(hasSize(3)));
        assertThat(items, is(contains(0, 1, 2)));
    }

    @Test
    public void gettingTupleAsList() {
        ThreeTuple<Object, Integer, Integer, Integer> tuple = Tuple.three(0, 1, 2);
        List<Object> items = tuple.asList();
        assertThat(items, is(hasSize(3)));
        assertThat(items, is(contains(0, 1, 2)));
    }

    @Test
    public void checkingPredicateByIndex() {
        ThreeTuple<Integer, Integer, Integer, Integer> tuple = ThreeTuple.of(0, 1, 2);
        for (int i = 0; i < 3; i++) {
            assertThat(tuple.check(i, x -> x % 2 == 0), is(i % 2 == 0));
        }
    }

    @Test
    public void checkingPredicateByAccessor() {
        ThreeTuple<Integer, Integer, Integer, Integer> tuple = ThreeTuple.of(0, 1, 2);
        assertThat(tuple.checkFirst(x -> x % 2 == 0), is(true));
        assertThat(tuple.checkSecond(x -> x % 2 == 0), is(false));
        assertThat(tuple.checkThird(x -> x % 2 == 0), is(true));
    }

    @Test
    public void extendingByValue() {
        ThreeTuple<Integer, Integer, Integer, Integer> tuple = ThreeTuple.of(0, 1, 2);
        FourTuple<Integer, Integer, Integer, Integer, Integer> secondTuple = ThreeTuple.extendWith(-1).apply(tuple);
        assertThat(secondTuple, is(notNullValue()));
        assertThat(secondTuple.size(), is(4));
        assertThat(secondTuple.first(), is(tuple.first()));
        assertThat(secondTuple.second(), is(tuple.second()));
        assertThat(secondTuple.third(), is(tuple.third()));
        assertThat(secondTuple.fourth(), is(-1));
        assertThat(secondTuple.drop(3), is(tuple));
    }

    @Test
    public void extendingBySupplier() {
        ThreeTuple<Integer, Integer, Integer, Integer> tuple = ThreeTuple.of(0, 1, 2);
        FourTuple<Integer, Integer, Integer, Integer, Integer> secondTuple = ThreeTuple.extendWith(() -> -1).apply(tuple);
        assertThat(secondTuple, is(notNullValue()));
        assertThat(secondTuple.size(), is(4));
        assertThat(secondTuple.first(), is(tuple.first()));
        assertThat(secondTuple.second(), is(tuple.second()));
        assertThat(secondTuple.third(), is(tuple.third()));
        assertThat(secondTuple.fourth(), is(-1));
        assertThat(secondTuple.drop(3), is(tuple));
    }

    @Test
    public void extendingByFunction() {
        ThreeTuple<Integer, Integer, Integer, Integer> tuple = ThreeTuple.of(0, 1, 2);
        FourTuple<Integer, Integer, Integer, Integer, Integer> secondTuple = ThreeTuple.extendWith((ThreeTuple<Integer, Integer, Integer, Integer> t) -> -1).apply(tuple);
        assertThat(secondTuple, is(notNullValue()));
        assertThat(secondTuple.size(), is(4));
        assertThat(secondTuple.first(), is(tuple.first()));
        assertThat(secondTuple.second(), is(tuple.second()));
        assertThat(secondTuple.third(), is(tuple.third()));
        assertThat(secondTuple.fourth(), is(-1));
        assertThat(secondTuple.drop(3), is(tuple));
    }

    @Test
    public void labelingTuple() {
        ThreeTuple<Integer, Integer, Integer, Integer> tuple = ThreeTuple.of(0, 1, 2);
        LabeledTuple<Integer> other = tuple.withLabels("e0", "e1", "e2");
        assertThat(other, is(notNullValue()));
        assertThat(other.size(), is(3));
        assertThat(other.labels(), is(contains("e0", "e1", "e2")));
        assertThat(other.get("e0"), is(tuple.get(0)));
        assertThat(other.get("e1"), is(tuple.get(1)));
        assertThat(other.get("e2"), is(tuple.get(2)));
        LabeledTuple<Integer> extended = other.extend(-1, "last");
        assertThat(extended, is(notNullValue()));
        assertThat(extended.size(), is(4));
        assertThat(extended.get("last"), is(-1));
    }

    @Test
    public void equality() {
        ThreeTuple<Object, Integer, Integer, Integer> tuple = Tuple.three(0, 1, 2);
        ThreeTuple<Object, Integer, Integer, Integer> secondTuple = Tuple.three(0, 1, 2);
        assertThat(tuple, is(secondTuple));
    }

    @Test
    public void hashCodeCalculation() {
        ThreeTuple<Object, Integer, Integer, Integer> tuple = Tuple.three(0, 1, 2);
        ThreeTuple<Object, Integer, Integer, Integer> secondTuple = Tuple.three(0, 1, 2);
        assertThat(tuple.hashCode(), is(secondTuple.hashCode()));
    }

    @Test
    public void toStringCalculation() {
        ThreeTuple<Object, Integer, Integer, Integer> tuple = Tuple.three(0, 1, 2);
        ThreeTuple<Object, Integer, Integer, Integer> secondTuple = Tuple.three(0, 1, 2);
        assertThat(tuple.toString(), is(secondTuple.toString()));
    }

}


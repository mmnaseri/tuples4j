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
 * Tests for {@link ThirteenOrMoreTuple}.
 *
 * @author Milad Naseri (m.m.naseri@gmail.com)
 */
public class ThirteenOrMoreTupleTest {

    @Test
    public void creatingTuple() {
        ThirteenOrMoreTuple<Object, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> tuple = Tuple.large(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12);
        assertThat(tuple, is(notNullValue()));
        assertThat(tuple.size(), is(13));
    }

    @Test
    public void accessingMembers() {
        ThirteenOrMoreTuple<Object, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> tuple = Tuple.large(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12);
        assertThat(tuple.get(0), is(0));
        assertThat(tuple.get(1), is(1));
        assertThat(tuple.get(2), is(2));
        assertThat(tuple.get(3), is(3));
        assertThat(tuple.get(4), is(4));
        assertThat(tuple.get(5), is(5));
        assertThat(tuple.get(6), is(6));
        assertThat(tuple.get(7), is(7));
        assertThat(tuple.get(8), is(8));
        assertThat(tuple.get(9), is(9));
        assertThat(tuple.get(10), is(10));
        assertThat(tuple.get(11), is(11));
        assertThat(tuple.get(12), is(12));
    }

    @Test
    public void changingElementByIndex() {
        ThirteenOrMoreTuple<Object, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> tuple = Tuple.large(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12);
        for (int i = 0; i < 13; i++) {
            Tuple<?> other = tuple.change(i, -1);
            assertThat(other, is(notNullValue()));
            assertThat(other.size(), is(13));
            assertThat(other.get(i), is(-1));
        }
    }

    @Test
    public void changingElementByIndexThroughFunction() {
        ThirteenOrMoreTuple<Object, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> tuple = Tuple.large(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12);
        for (int i = 0; i < 13; i++) {
            Tuple<?> other = tuple.change(i, t -> -1);
            assertThat(other, is(notNullValue()));
            assertThat(other.size(), is(13));
            assertThat(other.get(i), is(-1));
        }
    }

    @Test
    public void droppingByIndex() {
        ThirteenOrMoreTuple<Object, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> tuple = Tuple.large(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12);
        for (int i = 0; i < 13; i++) {
            Tuple<?> other = tuple.drop(i);
            assertThat(other, is(notNullValue()));
            assertThat(other.size(), is(12));
            for (int j = 0; j < 13; j++) {
                if (j == i) {
                    continue;
                }
                assertThat(other.get(j < i ? j : j - 1), is(tuple.get(j)));
            }
        }
    }

    @Test
    public void clearingTuple() {
        ThirteenOrMoreTuple<Object, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> tuple = Tuple.large(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12);
        Tuple<?> other = tuple.clear();
        assertThat(other, is(notNullValue()));
        assertThat(other.size(), is(0));
    }

    @Test
    public void streamingTuple() {
        ThirteenOrMoreTuple<Object, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> tuple = Tuple.large(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12);
        List<Object> items = tuple.stream().collect(toList());
        assertThat(items, is(hasSize(13)));
        assertThat(items, is(contains(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12)));
    }

    @Test
    public void gettingTupleAsList() {
        ThirteenOrMoreTuple<Object, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> tuple = Tuple.large(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12);
        List<Object> items = tuple.asList();
        assertThat(items, is(hasSize(13)));
        assertThat(items, is(contains(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12)));
    }

    @Test
    public void checkingPredicateByIndex() {
        ThirteenOrMoreTuple<Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> tuple = ThirteenOrMoreTuple.of(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12);
        for (int i = 0; i < 13; i++) {
            assertThat(tuple.check(i, x -> x % 2 == 0), is(i % 2 == 0));
        }
    }

    @Test
    public void checkingPredicateByAccessor() {
        ThirteenOrMoreTuple<Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> tuple = ThirteenOrMoreTuple.of(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12);
        assertThat(tuple.checkFirst(x -> x % 2 == 0), is(true));
        assertThat(tuple.checkSecond(x -> x % 2 == 0), is(false));
        assertThat(tuple.checkThird(x -> x % 2 == 0), is(true));
        assertThat(tuple.checkFourth(x -> x % 2 == 0), is(false));
        assertThat(tuple.checkFifth(x -> x % 2 == 0), is(true));
        assertThat(tuple.checkSixth(x -> x % 2 == 0), is(false));
        assertThat(tuple.checkSeventh(x -> x % 2 == 0), is(true));
        assertThat(tuple.checkEighth(x -> x % 2 == 0), is(false));
        assertThat(tuple.checkNinth(x -> x % 2 == 0), is(true));
        assertThat(tuple.checkTenth(x -> x % 2 == 0), is(false));
        assertThat(tuple.checkEleventh(x -> x % 2 == 0), is(true));
        assertThat(tuple.checkTwelfth(x -> x % 2 == 0), is(false));
    }

    @Test
    public void extendingByValue() {
        ThirteenOrMoreTuple<Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> tuple = ThirteenOrMoreTuple.of(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12);
        ThirteenOrMoreTuple<Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> secondTuple = ThirteenOrMoreTuple.extendWith(-1).apply(tuple);
        assertThat(secondTuple, is(notNullValue()));
        assertThat(secondTuple.size(), is(14));
        assertThat(secondTuple.first(), is(tuple.first()));
        assertThat(secondTuple.second(), is(tuple.second()));
        assertThat(secondTuple.third(), is(tuple.third()));
        assertThat(secondTuple.fourth(), is(tuple.fourth()));
        assertThat(secondTuple.fifth(), is(tuple.fifth()));
        assertThat(secondTuple.sixth(), is(tuple.sixth()));
        assertThat(secondTuple.seventh(), is(tuple.seventh()));
        assertThat(secondTuple.eighth(), is(tuple.eighth()));
        assertThat(secondTuple.ninth(), is(tuple.ninth()));
        assertThat(secondTuple.tenth(), is(tuple.tenth()));
        assertThat(secondTuple.eleventh(), is(tuple.eleventh()));
        assertThat(secondTuple.twelfth(), is(tuple.twelfth()));
        assertThat(secondTuple.get(13), is(-1));
        assertThat(secondTuple.drop(13), is(tuple));
    }

    @Test
    public void extendingBySupplier() {
        ThirteenOrMoreTuple<Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> tuple = ThirteenOrMoreTuple.of(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12);
        ThirteenOrMoreTuple<Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> secondTuple = ThirteenOrMoreTuple.extendWith(() -> -1).apply(tuple);
        assertThat(secondTuple, is(notNullValue()));
        assertThat(secondTuple.size(), is(14));
        assertThat(secondTuple.first(), is(tuple.first()));
        assertThat(secondTuple.second(), is(tuple.second()));
        assertThat(secondTuple.third(), is(tuple.third()));
        assertThat(secondTuple.fourth(), is(tuple.fourth()));
        assertThat(secondTuple.fifth(), is(tuple.fifth()));
        assertThat(secondTuple.sixth(), is(tuple.sixth()));
        assertThat(secondTuple.seventh(), is(tuple.seventh()));
        assertThat(secondTuple.eighth(), is(tuple.eighth()));
        assertThat(secondTuple.ninth(), is(tuple.ninth()));
        assertThat(secondTuple.tenth(), is(tuple.tenth()));
        assertThat(secondTuple.eleventh(), is(tuple.eleventh()));
        assertThat(secondTuple.twelfth(), is(tuple.twelfth()));
        assertThat(secondTuple.get(13), is(-1));
        assertThat(secondTuple.drop(13), is(tuple));
    }

    @Test
    public void extendingByFunction() {
        ThirteenOrMoreTuple<Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> tuple = ThirteenOrMoreTuple.of(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12);
        ThirteenOrMoreTuple<Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> secondTuple = ThirteenOrMoreTuple.extendWith((ThirteenOrMoreTuple<Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> t) -> -1).apply(
                tuple);
        assertThat(secondTuple, is(notNullValue()));
        assertThat(secondTuple.size(), is(14));
        assertThat(secondTuple.first(), is(tuple.first()));
        assertThat(secondTuple.second(), is(tuple.second()));
        assertThat(secondTuple.third(), is(tuple.third()));
        assertThat(secondTuple.fourth(), is(tuple.fourth()));
        assertThat(secondTuple.fifth(), is(tuple.fifth()));
        assertThat(secondTuple.sixth(), is(tuple.sixth()));
        assertThat(secondTuple.seventh(), is(tuple.seventh()));
        assertThat(secondTuple.eighth(), is(tuple.eighth()));
        assertThat(secondTuple.ninth(), is(tuple.ninth()));
        assertThat(secondTuple.tenth(), is(tuple.tenth()));
        assertThat(secondTuple.eleventh(), is(tuple.eleventh()));
        assertThat(secondTuple.twelfth(), is(tuple.twelfth()));
        assertThat(secondTuple.get(13), is(-1));
        assertThat(secondTuple.drop(13), is(tuple));
    }

    @Test
    public void labelingTuple() {
        ThirteenOrMoreTuple<Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> tuple = ThirteenOrMoreTuple.of(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12);
        LabeledTuple<Integer> other = tuple.withLabels("e0", "e1", "e2", "e3", "e4", "e5", "e6", "e7", "e8", "e9", "e10", "e11", "e12");
        assertThat(other, is(notNullValue()));
        assertThat(other.size(), is(13));
        assertThat(other.labels(), is(contains("e0", "e1", "e2", "e3", "e4", "e5", "e6", "e7", "e8", "e9", "e10", "e11", "e12")));
        assertThat(other.get("e0"), is(tuple.get(0)));
        assertThat(other.get("e1"), is(tuple.get(1)));
        assertThat(other.get("e2"), is(tuple.get(2)));
        assertThat(other.get("e3"), is(tuple.get(3)));
        assertThat(other.get("e4"), is(tuple.get(4)));
        assertThat(other.get("e5"), is(tuple.get(5)));
        assertThat(other.get("e6"), is(tuple.get(6)));
        assertThat(other.get("e7"), is(tuple.get(7)));
        assertThat(other.get("e8"), is(tuple.get(8)));
        assertThat(other.get("e9"), is(tuple.get(9)));
        assertThat(other.get("e10"), is(tuple.get(10)));
        assertThat(other.get("e11"), is(tuple.get(11)));
        assertThat(other.get("e12"), is(tuple.get(12)));
        LabeledTuple<Integer> extended = other.extend(-1, "last");
        assertThat(extended, is(notNullValue()));
        assertThat(extended.size(), is(14));
        assertThat(extended.get("last"), is(-1));
    }

    @Test
    public void equality() {
        ThirteenOrMoreTuple<Object, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> tuple = Tuple.large(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12);
        ThirteenOrMoreTuple<Object, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> secondTuple = Tuple.large(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12);
        assertThat(tuple, is(secondTuple));
    }

    @Test
    public void hashCodeCalculation() {
        ThirteenOrMoreTuple<Object, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> tuple = Tuple.large(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12);
        ThirteenOrMoreTuple<Object, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> secondTuple = Tuple.large(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12);
        assertThat(tuple.hashCode(), is(secondTuple.hashCode()));
    }

    @Test
    public void toStringCalculation() {
        ThirteenOrMoreTuple<Object, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> tuple = Tuple.large(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12);
        ThirteenOrMoreTuple<Object, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> secondTuple = Tuple.large(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12);
        assertThat(tuple.toString(), is(secondTuple.toString()));
    }

}


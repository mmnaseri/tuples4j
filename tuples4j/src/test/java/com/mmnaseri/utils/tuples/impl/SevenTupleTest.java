package com.mmnaseri.utils.tuples.impl;

import com.mmnaseri.utils.tuples.LabeledTuple;
import com.mmnaseri.utils.tuples.Tuple;
import org.testng.annotations.Test;

import java.util.List;

import static java.util.stream.Collectors.toList;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

/**
 * Tests for {@link SevenTuple}.
 *
 * @author Milad Naseri (m.m.naseri@gmail.com)
 */
public class SevenTupleTest {

    @Test
    public void creatingTuple() {
        SevenTuple<Object, Integer, Integer, Integer, Integer, Integer, Integer, Integer> tuple = Tuple.seven(0, 1, 2, 3, 4, 5, 6);
        assertThat(tuple, is(notNullValue()));
        assertThat(tuple.size(), is(7));
    }

    @Test
    public void accessingMembers() {
        SevenTuple<Object, Integer, Integer, Integer, Integer, Integer, Integer, Integer> tuple = Tuple.seven(0, 1, 2, 3, 4, 5, 6);
        assertThat(tuple.get(0), is(0));
        assertThat(tuple.get(1), is(1));
        assertThat(tuple.get(2), is(2));
        assertThat(tuple.get(3), is(3));
        assertThat(tuple.get(4), is(4));
        assertThat(tuple.get(5), is(5));
        assertThat(tuple.get(6), is(6));
    }

    @Test
    public void changingElementByIndex() {
        SevenTuple<Object, Integer, Integer, Integer, Integer, Integer, Integer, Integer> tuple = Tuple.seven(0, 1, 2, 3, 4, 5, 6);
        for (int i = 0; i < 7; i++) {
            Tuple<?> other = tuple.change(i, -1);
            assertThat(other, is(notNullValue()));
            assertThat(other.size(), is(7));
            assertThat(other.get(i), is(-1));
        }
    }

    @Test
    public void changingElementByIndexThroughFunction() {
        SevenTuple<Object, Integer, Integer, Integer, Integer, Integer, Integer, Integer> tuple = Tuple.seven(0, 1, 2, 3, 4, 5, 6);
        for (int i = 0; i < 7; i++) {
            Tuple<?> other = tuple.change(i, t -> -1);
            assertThat(other, is(notNullValue()));
            assertThat(other.size(), is(7));
            assertThat(other.get(i), is(-1));
        }
    }

    @Test
    public void changingFirstElementByAccessor() {
        SevenTuple<Object, Integer, Integer, Integer, Integer, Integer, Integer, Integer> tuple = Tuple.seven(0, 1, 2, 3, 4, 5, 6);

        // Changing by value.
        SevenTuple<Object, Integer, Integer, Integer, Integer, Integer, Integer, Integer> secondTuple = tuple.first(-1);
        assertThat(secondTuple, is(notNullValue()));
        assertThat(secondTuple.size(), is(tuple.size()));
        assertThat(secondTuple.first(), is(-1));
        assertThat(secondTuple.second(), is(1));
        assertThat(secondTuple.third(), is(2));
        assertThat(secondTuple.fourth(), is(3));
        assertThat(secondTuple.fifth(), is(4));
        assertThat(secondTuple.sixth(), is(5));
        assertThat(secondTuple.seventh(), is(6));

        // Changing by supplier.
        SevenTuple<Object, Integer, Integer, Integer, Integer, Integer, Integer, Integer> thirdTuple = tuple.first(() -> -1);
        assertThat(thirdTuple, is(notNullValue()));
        assertThat(thirdTuple.size(), is(tuple.size()));
        assertThat(thirdTuple.first(), is(-1));
        assertThat(thirdTuple.second(), is(1));
        assertThat(thirdTuple.third(), is(2));
        assertThat(thirdTuple.fourth(), is(3));
        assertThat(thirdTuple.fifth(), is(4));
        assertThat(thirdTuple.sixth(), is(5));
        assertThat(thirdTuple.seventh(), is(6));

        // Changing by function.
        SevenTuple<Object, Integer, Integer, Integer, Integer, Integer, Integer, Integer> fourthTuple = tuple.first(previous -> -1);
        assertThat(fourthTuple, is(notNullValue()));
        assertThat(fourthTuple.size(), is(tuple.size()));
        assertThat(fourthTuple.first(), is(-1));
        assertThat(fourthTuple.second(), is(1));
        assertThat(fourthTuple.third(), is(2));
        assertThat(fourthTuple.fourth(), is(3));
        assertThat(fourthTuple.fifth(), is(4));
        assertThat(fourthTuple.sixth(), is(5));
        assertThat(fourthTuple.seventh(), is(6));
    }

    @Test
    public void changingSecondElementByAccessor() {
        SevenTuple<Object, Integer, Integer, Integer, Integer, Integer, Integer, Integer> tuple = Tuple.seven(0, 1, 2, 3, 4, 5, 6);

        // Changing by value.
        SevenTuple<Object, Integer, Integer, Integer, Integer, Integer, Integer, Integer> secondTuple = tuple.second(-1);
        assertThat(secondTuple, is(notNullValue()));
        assertThat(secondTuple.size(), is(tuple.size()));
        assertThat(secondTuple.first(), is(0));
        assertThat(secondTuple.second(), is(-1));
        assertThat(secondTuple.third(), is(2));
        assertThat(secondTuple.fourth(), is(3));
        assertThat(secondTuple.fifth(), is(4));
        assertThat(secondTuple.sixth(), is(5));
        assertThat(secondTuple.seventh(), is(6));

        // Changing by supplier.
        SevenTuple<Object, Integer, Integer, Integer, Integer, Integer, Integer, Integer> thirdTuple = tuple.second(() -> -1);
        assertThat(thirdTuple, is(notNullValue()));
        assertThat(thirdTuple.size(), is(tuple.size()));
        assertThat(thirdTuple.first(), is(0));
        assertThat(thirdTuple.second(), is(-1));
        assertThat(thirdTuple.third(), is(2));
        assertThat(thirdTuple.fourth(), is(3));
        assertThat(thirdTuple.fifth(), is(4));
        assertThat(thirdTuple.sixth(), is(5));
        assertThat(thirdTuple.seventh(), is(6));

        // Changing by function.
        SevenTuple<Object, Integer, Integer, Integer, Integer, Integer, Integer, Integer> fourthTuple = tuple.second(previous -> -1);
        assertThat(fourthTuple, is(notNullValue()));
        assertThat(fourthTuple.size(), is(tuple.size()));
        assertThat(fourthTuple.first(), is(0));
        assertThat(fourthTuple.second(), is(-1));
        assertThat(fourthTuple.third(), is(2));
        assertThat(fourthTuple.fourth(), is(3));
        assertThat(fourthTuple.fifth(), is(4));
        assertThat(fourthTuple.sixth(), is(5));
        assertThat(fourthTuple.seventh(), is(6));
    }

    @Test
    public void changingThirdElementByAccessor() {
        SevenTuple<Object, Integer, Integer, Integer, Integer, Integer, Integer, Integer> tuple = Tuple.seven(0, 1, 2, 3, 4, 5, 6);

        // Changing by value.
        SevenTuple<Object, Integer, Integer, Integer, Integer, Integer, Integer, Integer> secondTuple = tuple.third(-1);
        assertThat(secondTuple, is(notNullValue()));
        assertThat(secondTuple.size(), is(tuple.size()));
        assertThat(secondTuple.first(), is(0));
        assertThat(secondTuple.second(), is(1));
        assertThat(secondTuple.third(), is(-1));
        assertThat(secondTuple.fourth(), is(3));
        assertThat(secondTuple.fifth(), is(4));
        assertThat(secondTuple.sixth(), is(5));
        assertThat(secondTuple.seventh(), is(6));

        // Changing by supplier.
        SevenTuple<Object, Integer, Integer, Integer, Integer, Integer, Integer, Integer> thirdTuple = tuple.third(() -> -1);
        assertThat(thirdTuple, is(notNullValue()));
        assertThat(thirdTuple.size(), is(tuple.size()));
        assertThat(thirdTuple.first(), is(0));
        assertThat(thirdTuple.second(), is(1));
        assertThat(thirdTuple.third(), is(-1));
        assertThat(thirdTuple.fourth(), is(3));
        assertThat(thirdTuple.fifth(), is(4));
        assertThat(thirdTuple.sixth(), is(5));
        assertThat(thirdTuple.seventh(), is(6));

        // Changing by function.
        SevenTuple<Object, Integer, Integer, Integer, Integer, Integer, Integer, Integer> fourthTuple = tuple.third(previous -> -1);
        assertThat(fourthTuple, is(notNullValue()));
        assertThat(fourthTuple.size(), is(tuple.size()));
        assertThat(fourthTuple.first(), is(0));
        assertThat(fourthTuple.second(), is(1));
        assertThat(fourthTuple.third(), is(-1));
        assertThat(fourthTuple.fourth(), is(3));
        assertThat(fourthTuple.fifth(), is(4));
        assertThat(fourthTuple.sixth(), is(5));
        assertThat(fourthTuple.seventh(), is(6));
    }

    @Test
    public void changingFourthElementByAccessor() {
        SevenTuple<Object, Integer, Integer, Integer, Integer, Integer, Integer, Integer> tuple = Tuple.seven(0, 1, 2, 3, 4, 5, 6);

        // Changing by value.
        SevenTuple<Object, Integer, Integer, Integer, Integer, Integer, Integer, Integer> secondTuple = tuple.fourth(-1);
        assertThat(secondTuple, is(notNullValue()));
        assertThat(secondTuple.size(), is(tuple.size()));
        assertThat(secondTuple.first(), is(0));
        assertThat(secondTuple.second(), is(1));
        assertThat(secondTuple.third(), is(2));
        assertThat(secondTuple.fourth(), is(-1));
        assertThat(secondTuple.fifth(), is(4));
        assertThat(secondTuple.sixth(), is(5));
        assertThat(secondTuple.seventh(), is(6));

        // Changing by supplier.
        SevenTuple<Object, Integer, Integer, Integer, Integer, Integer, Integer, Integer> thirdTuple = tuple.fourth(() -> -1);
        assertThat(thirdTuple, is(notNullValue()));
        assertThat(thirdTuple.size(), is(tuple.size()));
        assertThat(thirdTuple.first(), is(0));
        assertThat(thirdTuple.second(), is(1));
        assertThat(thirdTuple.third(), is(2));
        assertThat(thirdTuple.fourth(), is(-1));
        assertThat(thirdTuple.fifth(), is(4));
        assertThat(thirdTuple.sixth(), is(5));
        assertThat(thirdTuple.seventh(), is(6));

        // Changing by function.
        SevenTuple<Object, Integer, Integer, Integer, Integer, Integer, Integer, Integer> fourthTuple = tuple.fourth(previous -> -1);
        assertThat(fourthTuple, is(notNullValue()));
        assertThat(fourthTuple.size(), is(tuple.size()));
        assertThat(fourthTuple.first(), is(0));
        assertThat(fourthTuple.second(), is(1));
        assertThat(fourthTuple.third(), is(2));
        assertThat(fourthTuple.fourth(), is(-1));
        assertThat(fourthTuple.fifth(), is(4));
        assertThat(fourthTuple.sixth(), is(5));
        assertThat(fourthTuple.seventh(), is(6));
    }

    @Test
    public void changingFifthElementByAccessor() {
        SevenTuple<Object, Integer, Integer, Integer, Integer, Integer, Integer, Integer> tuple = Tuple.seven(0, 1, 2, 3, 4, 5, 6);

        // Changing by value.
        SevenTuple<Object, Integer, Integer, Integer, Integer, Integer, Integer, Integer> secondTuple = tuple.fifth(-1);
        assertThat(secondTuple, is(notNullValue()));
        assertThat(secondTuple.size(), is(tuple.size()));
        assertThat(secondTuple.first(), is(0));
        assertThat(secondTuple.second(), is(1));
        assertThat(secondTuple.third(), is(2));
        assertThat(secondTuple.fourth(), is(3));
        assertThat(secondTuple.fifth(), is(-1));
        assertThat(secondTuple.sixth(), is(5));
        assertThat(secondTuple.seventh(), is(6));

        // Changing by supplier.
        SevenTuple<Object, Integer, Integer, Integer, Integer, Integer, Integer, Integer> thirdTuple = tuple.fifth(() -> -1);
        assertThat(thirdTuple, is(notNullValue()));
        assertThat(thirdTuple.size(), is(tuple.size()));
        assertThat(thirdTuple.first(), is(0));
        assertThat(thirdTuple.second(), is(1));
        assertThat(thirdTuple.third(), is(2));
        assertThat(thirdTuple.fourth(), is(3));
        assertThat(thirdTuple.fifth(), is(-1));
        assertThat(thirdTuple.sixth(), is(5));
        assertThat(thirdTuple.seventh(), is(6));

        // Changing by function.
        SevenTuple<Object, Integer, Integer, Integer, Integer, Integer, Integer, Integer> fourthTuple = tuple.fifth(previous -> -1);
        assertThat(fourthTuple, is(notNullValue()));
        assertThat(fourthTuple.size(), is(tuple.size()));
        assertThat(fourthTuple.first(), is(0));
        assertThat(fourthTuple.second(), is(1));
        assertThat(fourthTuple.third(), is(2));
        assertThat(fourthTuple.fourth(), is(3));
        assertThat(fourthTuple.fifth(), is(-1));
        assertThat(fourthTuple.sixth(), is(5));
        assertThat(fourthTuple.seventh(), is(6));
    }

    @Test
    public void changingSixthElementByAccessor() {
        SevenTuple<Object, Integer, Integer, Integer, Integer, Integer, Integer, Integer> tuple = Tuple.seven(0, 1, 2, 3, 4, 5, 6);

        // Changing by value.
        SevenTuple<Object, Integer, Integer, Integer, Integer, Integer, Integer, Integer> secondTuple = tuple.sixth(-1);
        assertThat(secondTuple, is(notNullValue()));
        assertThat(secondTuple.size(), is(tuple.size()));
        assertThat(secondTuple.first(), is(0));
        assertThat(secondTuple.second(), is(1));
        assertThat(secondTuple.third(), is(2));
        assertThat(secondTuple.fourth(), is(3));
        assertThat(secondTuple.fifth(), is(4));
        assertThat(secondTuple.sixth(), is(-1));
        assertThat(secondTuple.seventh(), is(6));

        // Changing by supplier.
        SevenTuple<Object, Integer, Integer, Integer, Integer, Integer, Integer, Integer> thirdTuple = tuple.sixth(() -> -1);
        assertThat(thirdTuple, is(notNullValue()));
        assertThat(thirdTuple.size(), is(tuple.size()));
        assertThat(thirdTuple.first(), is(0));
        assertThat(thirdTuple.second(), is(1));
        assertThat(thirdTuple.third(), is(2));
        assertThat(thirdTuple.fourth(), is(3));
        assertThat(thirdTuple.fifth(), is(4));
        assertThat(thirdTuple.sixth(), is(-1));
        assertThat(thirdTuple.seventh(), is(6));

        // Changing by function.
        SevenTuple<Object, Integer, Integer, Integer, Integer, Integer, Integer, Integer> fourthTuple = tuple.sixth(previous -> -1);
        assertThat(fourthTuple, is(notNullValue()));
        assertThat(fourthTuple.size(), is(tuple.size()));
        assertThat(fourthTuple.first(), is(0));
        assertThat(fourthTuple.second(), is(1));
        assertThat(fourthTuple.third(), is(2));
        assertThat(fourthTuple.fourth(), is(3));
        assertThat(fourthTuple.fifth(), is(4));
        assertThat(fourthTuple.sixth(), is(-1));
        assertThat(fourthTuple.seventh(), is(6));
    }

    @Test
    public void changingSeventhElementByAccessor() {
        SevenTuple<Object, Integer, Integer, Integer, Integer, Integer, Integer, Integer> tuple = Tuple.seven(0, 1, 2, 3, 4, 5, 6);

        // Changing by value.
        SevenTuple<Object, Integer, Integer, Integer, Integer, Integer, Integer, Integer> secondTuple = tuple.seventh(-1);
        assertThat(secondTuple, is(notNullValue()));
        assertThat(secondTuple.size(), is(tuple.size()));
        assertThat(secondTuple.first(), is(0));
        assertThat(secondTuple.second(), is(1));
        assertThat(secondTuple.third(), is(2));
        assertThat(secondTuple.fourth(), is(3));
        assertThat(secondTuple.fifth(), is(4));
        assertThat(secondTuple.sixth(), is(5));
        assertThat(secondTuple.seventh(), is(-1));

        // Changing by supplier.
        SevenTuple<Object, Integer, Integer, Integer, Integer, Integer, Integer, Integer> thirdTuple = tuple.seventh(() -> -1);
        assertThat(thirdTuple, is(notNullValue()));
        assertThat(thirdTuple.size(), is(tuple.size()));
        assertThat(thirdTuple.first(), is(0));
        assertThat(thirdTuple.second(), is(1));
        assertThat(thirdTuple.third(), is(2));
        assertThat(thirdTuple.fourth(), is(3));
        assertThat(thirdTuple.fifth(), is(4));
        assertThat(thirdTuple.sixth(), is(5));
        assertThat(thirdTuple.seventh(), is(-1));

        // Changing by function.
        SevenTuple<Object, Integer, Integer, Integer, Integer, Integer, Integer, Integer> fourthTuple = tuple.seventh(previous -> -1);
        assertThat(fourthTuple, is(notNullValue()));
        assertThat(fourthTuple.size(), is(tuple.size()));
        assertThat(fourthTuple.first(), is(0));
        assertThat(fourthTuple.second(), is(1));
        assertThat(fourthTuple.third(), is(2));
        assertThat(fourthTuple.fourth(), is(3));
        assertThat(fourthTuple.fifth(), is(4));
        assertThat(fourthTuple.sixth(), is(5));
        assertThat(fourthTuple.seventh(), is(-1));
    }

    @Test
    public void droppingByIndex() {
        SevenTuple<Object, Integer, Integer, Integer, Integer, Integer, Integer, Integer> tuple = Tuple.seven(0, 1, 2, 3, 4, 5, 6);
        for (int i = 0; i < 7; i++) {
            Tuple<?> other = tuple.drop(i);
            assertThat(other, is(notNullValue()));
            assertThat(other.size(), is(6));
            for (int j = 0; j < 7; j++) {
                if (j == i) {
                    continue;
                }
                assertThat(other.get(j < i ? j : j - 1), is(tuple.get(j)));
            }
        }
    }

    @Test
    public void droppingFirstElementByAccessor() {
        SevenTuple<Object, Integer, Integer, Integer, Integer, Integer, Integer, Integer> tuple = Tuple.seven(0, 1, 2, 3, 4, 5, 6);
        SixTuple<Object, Integer, Integer, Integer, Integer, Integer, Integer> other = tuple.dropFirst();
        assertThat(other, is(notNullValue()));
        assertThat(other.size(), is(6));
        assertThat(other.first(), is(tuple.second()));
        assertThat(other.second(), is(tuple.third()));
        assertThat(other.third(), is(tuple.fourth()));
        assertThat(other.fourth(), is(tuple.fifth()));
        assertThat(other.fifth(), is(tuple.sixth()));
        assertThat(other.sixth(), is(tuple.seventh()));
    }

    @Test
    public void droppingSecondElementByAccessor() {
        SevenTuple<Object, Integer, Integer, Integer, Integer, Integer, Integer, Integer> tuple = Tuple.seven(0, 1, 2, 3, 4, 5, 6);
        SixTuple<Object, Integer, Integer, Integer, Integer, Integer, Integer> other = tuple.dropSecond();
        assertThat(other, is(notNullValue()));
        assertThat(other.size(), is(6));
        assertThat(other.first(), is(tuple.first()));
        assertThat(other.second(), is(tuple.third()));
        assertThat(other.third(), is(tuple.fourth()));
        assertThat(other.fourth(), is(tuple.fifth()));
        assertThat(other.fifth(), is(tuple.sixth()));
        assertThat(other.sixth(), is(tuple.seventh()));
    }

    @Test
    public void droppingThirdElementByAccessor() {
        SevenTuple<Object, Integer, Integer, Integer, Integer, Integer, Integer, Integer> tuple = Tuple.seven(0, 1, 2, 3, 4, 5, 6);
        SixTuple<Object, Integer, Integer, Integer, Integer, Integer, Integer> other = tuple.dropThird();
        assertThat(other, is(notNullValue()));
        assertThat(other.size(), is(6));
        assertThat(other.first(), is(tuple.first()));
        assertThat(other.second(), is(tuple.second()));
        assertThat(other.third(), is(tuple.fourth()));
        assertThat(other.fourth(), is(tuple.fifth()));
        assertThat(other.fifth(), is(tuple.sixth()));
        assertThat(other.sixth(), is(tuple.seventh()));
    }

    @Test
    public void droppingFourthElementByAccessor() {
        SevenTuple<Object, Integer, Integer, Integer, Integer, Integer, Integer, Integer> tuple = Tuple.seven(0, 1, 2, 3, 4, 5, 6);
        SixTuple<Object, Integer, Integer, Integer, Integer, Integer, Integer> other = tuple.dropFourth();
        assertThat(other, is(notNullValue()));
        assertThat(other.size(), is(6));
        assertThat(other.first(), is(tuple.first()));
        assertThat(other.second(), is(tuple.second()));
        assertThat(other.third(), is(tuple.third()));
        assertThat(other.fourth(), is(tuple.fifth()));
        assertThat(other.fifth(), is(tuple.sixth()));
        assertThat(other.sixth(), is(tuple.seventh()));
    }

    @Test
    public void droppingFifthElementByAccessor() {
        SevenTuple<Object, Integer, Integer, Integer, Integer, Integer, Integer, Integer> tuple = Tuple.seven(0, 1, 2, 3, 4, 5, 6);
        SixTuple<Object, Integer, Integer, Integer, Integer, Integer, Integer> other = tuple.dropFifth();
        assertThat(other, is(notNullValue()));
        assertThat(other.size(), is(6));
        assertThat(other.first(), is(tuple.first()));
        assertThat(other.second(), is(tuple.second()));
        assertThat(other.third(), is(tuple.third()));
        assertThat(other.fourth(), is(tuple.fourth()));
        assertThat(other.fifth(), is(tuple.sixth()));
        assertThat(other.sixth(), is(tuple.seventh()));
    }

    @Test
    public void droppingSixthElementByAccessor() {
        SevenTuple<Object, Integer, Integer, Integer, Integer, Integer, Integer, Integer> tuple = Tuple.seven(0, 1, 2, 3, 4, 5, 6);
        SixTuple<Object, Integer, Integer, Integer, Integer, Integer, Integer> other = tuple.dropSixth();
        assertThat(other, is(notNullValue()));
        assertThat(other.size(), is(6));
        assertThat(other.first(), is(tuple.first()));
        assertThat(other.second(), is(tuple.second()));
        assertThat(other.third(), is(tuple.third()));
        assertThat(other.fourth(), is(tuple.fourth()));
        assertThat(other.fifth(), is(tuple.fifth()));
        assertThat(other.sixth(), is(tuple.seventh()));
    }

    @Test
    public void droppingSeventhElementByAccessor() {
        SevenTuple<Object, Integer, Integer, Integer, Integer, Integer, Integer, Integer> tuple = Tuple.seven(0, 1, 2, 3, 4, 5, 6);
        SixTuple<Object, Integer, Integer, Integer, Integer, Integer, Integer> other = tuple.dropSeventh();
        assertThat(other, is(notNullValue()));
        assertThat(other.size(), is(6));
        assertThat(other.first(), is(tuple.first()));
        assertThat(other.second(), is(tuple.second()));
        assertThat(other.third(), is(tuple.third()));
        assertThat(other.fourth(), is(tuple.fourth()));
        assertThat(other.fifth(), is(tuple.fifth()));
        assertThat(other.sixth(), is(tuple.sixth()));
    }

    @Test
    public void clearingTuple() {
        SevenTuple<Object, Integer, Integer, Integer, Integer, Integer, Integer, Integer> tuple = Tuple.seven(0, 1, 2, 3, 4, 5, 6);
        Tuple<?> other = tuple.clear();
        assertThat(other, is(notNullValue()));
        assertThat(other.size(), is(0));
    }

    @Test
    public void streamingTuple() {
        SevenTuple<Object, Integer, Integer, Integer, Integer, Integer, Integer, Integer> tuple = Tuple.seven(0, 1, 2, 3, 4, 5, 6);
        List<Object> items = tuple.stream().collect(toList());
        assertThat(items, is(hasSize(7)));
        assertThat(items, is(contains(0, 1, 2, 3, 4, 5, 6)));
    }

    @Test
    public void gettingTupleAsList() {
        SevenTuple<Object, Integer, Integer, Integer, Integer, Integer, Integer, Integer> tuple = Tuple.seven(0, 1, 2, 3, 4, 5, 6);
        List<Object> items = tuple.asList();
        assertThat(items, is(hasSize(7)));
        assertThat(items, is(contains(0, 1, 2, 3, 4, 5, 6)));
    }

    @Test
    public void checkingPredicateByIndex() {
        SevenTuple<Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> tuple = SevenTuple.of(0, 1, 2, 3, 4, 5, 6);
        for (int i = 0; i < 7; i++) {
            assertThat(tuple.check(i, x -> x % 2 == 0), is(i % 2 == 0));
        }
    }

    @Test
    public void checkingPredicateByAccessor() {
        SevenTuple<Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> tuple = SevenTuple.of(0, 1, 2, 3, 4, 5, 6);
        assertThat(tuple.checkFirst(x -> x % 2 == 0), is(true));
        assertThat(tuple.checkSecond(x -> x % 2 == 0), is(false));
        assertThat(tuple.checkThird(x -> x % 2 == 0), is(true));
        assertThat(tuple.checkFourth(x -> x % 2 == 0), is(false));
        assertThat(tuple.checkFifth(x -> x % 2 == 0), is(true));
        assertThat(tuple.checkSixth(x -> x % 2 == 0), is(false));
        assertThat(tuple.checkSeventh(x -> x % 2 == 0), is(true));
    }

    @Test
    public void extendingByValue() {
        SevenTuple<Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> tuple = SevenTuple.of(0, 1, 2, 3, 4, 5, 6);
        EightTuple<Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> secondTuple = SevenTuple.extendWith(-1).apply(tuple);
        assertThat(secondTuple, is(notNullValue()));
        assertThat(secondTuple.size(), is(8));
        assertThat(secondTuple.first(), is(tuple.first()));
        assertThat(secondTuple.second(), is(tuple.second()));
        assertThat(secondTuple.third(), is(tuple.third()));
        assertThat(secondTuple.fourth(), is(tuple.fourth()));
        assertThat(secondTuple.fifth(), is(tuple.fifth()));
        assertThat(secondTuple.sixth(), is(tuple.sixth()));
        assertThat(secondTuple.seventh(), is(tuple.seventh()));
        assertThat(secondTuple.eighth(), is(-1));
        assertThat(secondTuple.drop(7), is(tuple));
    }

    @Test
    public void extendingBySupplier() {
        SevenTuple<Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> tuple = SevenTuple.of(0, 1, 2, 3, 4, 5, 6);
        EightTuple<Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> secondTuple = SevenTuple.extendWith(() -> -1).apply(tuple);
        assertThat(secondTuple, is(notNullValue()));
        assertThat(secondTuple.size(), is(8));
        assertThat(secondTuple.first(), is(tuple.first()));
        assertThat(secondTuple.second(), is(tuple.second()));
        assertThat(secondTuple.third(), is(tuple.third()));
        assertThat(secondTuple.fourth(), is(tuple.fourth()));
        assertThat(secondTuple.fifth(), is(tuple.fifth()));
        assertThat(secondTuple.sixth(), is(tuple.sixth()));
        assertThat(secondTuple.seventh(), is(tuple.seventh()));
        assertThat(secondTuple.eighth(), is(-1));
        assertThat(secondTuple.drop(7), is(tuple));
    }

    @Test
    public void extendingByFunction() {
        SevenTuple<Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> tuple = SevenTuple.of(0, 1, 2, 3, 4, 5, 6);
        EightTuple<Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> secondTuple = SevenTuple.extendWith((SevenTuple<Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> t) -> -1).apply(tuple);
        assertThat(secondTuple, is(notNullValue()));
        assertThat(secondTuple.size(), is(8));
        assertThat(secondTuple.first(), is(tuple.first()));
        assertThat(secondTuple.second(), is(tuple.second()));
        assertThat(secondTuple.third(), is(tuple.third()));
        assertThat(secondTuple.fourth(), is(tuple.fourth()));
        assertThat(secondTuple.fifth(), is(tuple.fifth()));
        assertThat(secondTuple.sixth(), is(tuple.sixth()));
        assertThat(secondTuple.seventh(), is(tuple.seventh()));
        assertThat(secondTuple.eighth(), is(-1));
        assertThat(secondTuple.drop(7), is(tuple));
    }

    @Test
    public void labelingTuple() {
        SevenTuple<Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> tuple = SevenTuple.of(0, 1, 2, 3, 4, 5, 6);
        LabeledTuple<Integer> other = tuple.withLabels("e0", "e1", "e2", "e3", "e4", "e5", "e6");
        assertThat(other, is(notNullValue()));
        assertThat(other.size(), is(7));
        assertThat(other.labels(), is(contains("e0", "e1", "e2", "e3", "e4", "e5", "e6")));
        assertThat(other.get("e0"), is(tuple.get(0)));
        assertThat(other.get("e1"), is(tuple.get(1)));
        assertThat(other.get("e2"), is(tuple.get(2)));
        assertThat(other.get("e3"), is(tuple.get(3)));
        assertThat(other.get("e4"), is(tuple.get(4)));
        assertThat(other.get("e5"), is(tuple.get(5)));
        assertThat(other.get("e6"), is(tuple.get(6)));
        LabeledTuple<Integer> extended = other.extend(-1, "last");
        assertThat(extended, is(notNullValue()));
        assertThat(extended.size(), is(8));
        assertThat(extended.get("last"), is(-1));
    }

    @Test
    public void equality() {
        SevenTuple<Object, Integer, Integer, Integer, Integer, Integer, Integer, Integer> tuple = Tuple.seven(0, 1, 2, 3, 4, 5, 6);
        SevenTuple<Object, Integer, Integer, Integer, Integer, Integer, Integer, Integer> secondTuple = Tuple.seven(0, 1, 2, 3, 4, 5, 6);
        assertThat(tuple, is(secondTuple));
    }

    @Test
    public void hashCodeCalculation() {
        SevenTuple<Object, Integer, Integer, Integer, Integer, Integer, Integer, Integer> tuple = Tuple.seven(0, 1, 2, 3, 4, 5, 6);
        SevenTuple<Object, Integer, Integer, Integer, Integer, Integer, Integer, Integer> secondTuple = Tuple.seven(0, 1, 2, 3, 4, 5, 6);
        assertThat(tuple.hashCode(), is(secondTuple.hashCode()));
    }

    @Test
    public void toStringCalculation() {
        SevenTuple<Object, Integer, Integer, Integer, Integer, Integer, Integer, Integer> tuple = Tuple.seven(0, 1, 2, 3, 4, 5, 6);
        SevenTuple<Object, Integer, Integer, Integer, Integer, Integer, Integer, Integer> secondTuple = Tuple.seven(0, 1, 2, 3, 4, 5, 6);
        assertThat(tuple.toString(), is(secondTuple.toString()));
    }

}


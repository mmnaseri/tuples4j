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
 * Tests for {@link NineTuple}.
 *
 * @author Milad Naseri (m.m.naseri@gmail.com)
 */
public class NineTupleTest {

    @Test
    public void creatingTuple() {
        NineTuple<Object, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> tuple = Tuple.nine(0, 1, 2, 3, 4, 5, 6, 7, 8);
        assertThat(tuple, is(notNullValue()));
        assertThat(tuple.size(), is(9));
    }

    @Test
    public void accessingMembers() {
        NineTuple<Object, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> tuple = Tuple.nine(0, 1, 2, 3, 4, 5, 6, 7, 8);
        assertThat(tuple.get(0), is(0));
        assertThat(tuple.get(1), is(1));
        assertThat(tuple.get(2), is(2));
        assertThat(tuple.get(3), is(3));
        assertThat(tuple.get(4), is(4));
        assertThat(tuple.get(5), is(5));
        assertThat(tuple.get(6), is(6));
        assertThat(tuple.get(7), is(7));
        assertThat(tuple.get(8), is(8));
    }

    @Test
    public void changingElementByIndex() {
        NineTuple<Object, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> tuple = Tuple.nine(0, 1, 2, 3, 4, 5, 6, 7, 8);
        for (int i = 0; i < 9; i++) {
            Tuple<?> other = tuple.change(i, -1);
            assertThat(other, is(notNullValue()));
            assertThat(other.size(), is(9));
            assertThat(other.get(i), is(-1));
        }
    }

    @Test
    public void changingElementByIndexThroughFunction() {
        NineTuple<Object, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> tuple = Tuple.nine(0, 1, 2, 3, 4, 5, 6, 7, 8);
        for (int i = 0; i < 9; i++) {
            Tuple<?> other = tuple.change(i, t -> -1);
            assertThat(other, is(notNullValue()));
            assertThat(other.size(), is(9));
            assertThat(other.get(i), is(-1));
        }
    }

    @Test
    public void changingFirstElementByAccessor() {
        NineTuple<Object, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> tuple = Tuple.nine(0, 1, 2, 3, 4, 5, 6, 7, 8);

        // Changing by value.
        NineTuple<Object, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> secondTuple = tuple.first(-1);
        assertThat(secondTuple, is(notNullValue()));
        assertThat(secondTuple.size(), is(tuple.size()));
        assertThat(secondTuple.first(), is(-1));
        assertThat(secondTuple.second(), is(1));
        assertThat(secondTuple.third(), is(2));
        assertThat(secondTuple.fourth(), is(3));
        assertThat(secondTuple.fifth(), is(4));
        assertThat(secondTuple.sixth(), is(5));
        assertThat(secondTuple.seventh(), is(6));
        assertThat(secondTuple.eighth(), is(7));
        assertThat(secondTuple.ninth(), is(8));

        // Changing by supplier.
        NineTuple<Object, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> thirdTuple = tuple.first(() -> -1);
        assertThat(thirdTuple, is(notNullValue()));
        assertThat(thirdTuple.size(), is(tuple.size()));
        assertThat(thirdTuple.first(), is(-1));
        assertThat(thirdTuple.second(), is(1));
        assertThat(thirdTuple.third(), is(2));
        assertThat(thirdTuple.fourth(), is(3));
        assertThat(thirdTuple.fifth(), is(4));
        assertThat(thirdTuple.sixth(), is(5));
        assertThat(thirdTuple.seventh(), is(6));
        assertThat(thirdTuple.eighth(), is(7));
        assertThat(thirdTuple.ninth(), is(8));

        // Changing by function.
        NineTuple<Object, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> fourthTuple = tuple.first(previous -> -1);
        assertThat(fourthTuple, is(notNullValue()));
        assertThat(fourthTuple.size(), is(tuple.size()));
        assertThat(fourthTuple.first(), is(-1));
        assertThat(fourthTuple.second(), is(1));
        assertThat(fourthTuple.third(), is(2));
        assertThat(fourthTuple.fourth(), is(3));
        assertThat(fourthTuple.fifth(), is(4));
        assertThat(fourthTuple.sixth(), is(5));
        assertThat(fourthTuple.seventh(), is(6));
        assertThat(fourthTuple.eighth(), is(7));
        assertThat(fourthTuple.ninth(), is(8));
    }

    @Test
    public void changingSecondElementByAccessor() {
        NineTuple<Object, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> tuple = Tuple.nine(0, 1, 2, 3, 4, 5, 6, 7, 8);

        // Changing by value.
        NineTuple<Object, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> secondTuple = tuple.second(-1);
        assertThat(secondTuple, is(notNullValue()));
        assertThat(secondTuple.size(), is(tuple.size()));
        assertThat(secondTuple.first(), is(0));
        assertThat(secondTuple.second(), is(-1));
        assertThat(secondTuple.third(), is(2));
        assertThat(secondTuple.fourth(), is(3));
        assertThat(secondTuple.fifth(), is(4));
        assertThat(secondTuple.sixth(), is(5));
        assertThat(secondTuple.seventh(), is(6));
        assertThat(secondTuple.eighth(), is(7));
        assertThat(secondTuple.ninth(), is(8));

        // Changing by supplier.
        NineTuple<Object, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> thirdTuple = tuple.second(() -> -1);
        assertThat(thirdTuple, is(notNullValue()));
        assertThat(thirdTuple.size(), is(tuple.size()));
        assertThat(thirdTuple.first(), is(0));
        assertThat(thirdTuple.second(), is(-1));
        assertThat(thirdTuple.third(), is(2));
        assertThat(thirdTuple.fourth(), is(3));
        assertThat(thirdTuple.fifth(), is(4));
        assertThat(thirdTuple.sixth(), is(5));
        assertThat(thirdTuple.seventh(), is(6));
        assertThat(thirdTuple.eighth(), is(7));
        assertThat(thirdTuple.ninth(), is(8));

        // Changing by function.
        NineTuple<Object, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> fourthTuple = tuple.second(previous -> -1);
        assertThat(fourthTuple, is(notNullValue()));
        assertThat(fourthTuple.size(), is(tuple.size()));
        assertThat(fourthTuple.first(), is(0));
        assertThat(fourthTuple.second(), is(-1));
        assertThat(fourthTuple.third(), is(2));
        assertThat(fourthTuple.fourth(), is(3));
        assertThat(fourthTuple.fifth(), is(4));
        assertThat(fourthTuple.sixth(), is(5));
        assertThat(fourthTuple.seventh(), is(6));
        assertThat(fourthTuple.eighth(), is(7));
        assertThat(fourthTuple.ninth(), is(8));
    }

    @Test
    public void changingThirdElementByAccessor() {
        NineTuple<Object, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> tuple = Tuple.nine(0, 1, 2, 3, 4, 5, 6, 7, 8);

        // Changing by value.
        NineTuple<Object, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> secondTuple = tuple.third(-1);
        assertThat(secondTuple, is(notNullValue()));
        assertThat(secondTuple.size(), is(tuple.size()));
        assertThat(secondTuple.first(), is(0));
        assertThat(secondTuple.second(), is(1));
        assertThat(secondTuple.third(), is(-1));
        assertThat(secondTuple.fourth(), is(3));
        assertThat(secondTuple.fifth(), is(4));
        assertThat(secondTuple.sixth(), is(5));
        assertThat(secondTuple.seventh(), is(6));
        assertThat(secondTuple.eighth(), is(7));
        assertThat(secondTuple.ninth(), is(8));

        // Changing by supplier.
        NineTuple<Object, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> thirdTuple = tuple.third(() -> -1);
        assertThat(thirdTuple, is(notNullValue()));
        assertThat(thirdTuple.size(), is(tuple.size()));
        assertThat(thirdTuple.first(), is(0));
        assertThat(thirdTuple.second(), is(1));
        assertThat(thirdTuple.third(), is(-1));
        assertThat(thirdTuple.fourth(), is(3));
        assertThat(thirdTuple.fifth(), is(4));
        assertThat(thirdTuple.sixth(), is(5));
        assertThat(thirdTuple.seventh(), is(6));
        assertThat(thirdTuple.eighth(), is(7));
        assertThat(thirdTuple.ninth(), is(8));

        // Changing by function.
        NineTuple<Object, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> fourthTuple = tuple.third(previous -> -1);
        assertThat(fourthTuple, is(notNullValue()));
        assertThat(fourthTuple.size(), is(tuple.size()));
        assertThat(fourthTuple.first(), is(0));
        assertThat(fourthTuple.second(), is(1));
        assertThat(fourthTuple.third(), is(-1));
        assertThat(fourthTuple.fourth(), is(3));
        assertThat(fourthTuple.fifth(), is(4));
        assertThat(fourthTuple.sixth(), is(5));
        assertThat(fourthTuple.seventh(), is(6));
        assertThat(fourthTuple.eighth(), is(7));
        assertThat(fourthTuple.ninth(), is(8));
    }

    @Test
    public void changingFourthElementByAccessor() {
        NineTuple<Object, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> tuple = Tuple.nine(0, 1, 2, 3, 4, 5, 6, 7, 8);

        // Changing by value.
        NineTuple<Object, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> secondTuple = tuple.fourth(-1);
        assertThat(secondTuple, is(notNullValue()));
        assertThat(secondTuple.size(), is(tuple.size()));
        assertThat(secondTuple.first(), is(0));
        assertThat(secondTuple.second(), is(1));
        assertThat(secondTuple.third(), is(2));
        assertThat(secondTuple.fourth(), is(-1));
        assertThat(secondTuple.fifth(), is(4));
        assertThat(secondTuple.sixth(), is(5));
        assertThat(secondTuple.seventh(), is(6));
        assertThat(secondTuple.eighth(), is(7));
        assertThat(secondTuple.ninth(), is(8));

        // Changing by supplier.
        NineTuple<Object, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> thirdTuple = tuple.fourth(() -> -1);
        assertThat(thirdTuple, is(notNullValue()));
        assertThat(thirdTuple.size(), is(tuple.size()));
        assertThat(thirdTuple.first(), is(0));
        assertThat(thirdTuple.second(), is(1));
        assertThat(thirdTuple.third(), is(2));
        assertThat(thirdTuple.fourth(), is(-1));
        assertThat(thirdTuple.fifth(), is(4));
        assertThat(thirdTuple.sixth(), is(5));
        assertThat(thirdTuple.seventh(), is(6));
        assertThat(thirdTuple.eighth(), is(7));
        assertThat(thirdTuple.ninth(), is(8));

        // Changing by function.
        NineTuple<Object, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> fourthTuple = tuple.fourth(previous -> -1);
        assertThat(fourthTuple, is(notNullValue()));
        assertThat(fourthTuple.size(), is(tuple.size()));
        assertThat(fourthTuple.first(), is(0));
        assertThat(fourthTuple.second(), is(1));
        assertThat(fourthTuple.third(), is(2));
        assertThat(fourthTuple.fourth(), is(-1));
        assertThat(fourthTuple.fifth(), is(4));
        assertThat(fourthTuple.sixth(), is(5));
        assertThat(fourthTuple.seventh(), is(6));
        assertThat(fourthTuple.eighth(), is(7));
        assertThat(fourthTuple.ninth(), is(8));
    }

    @Test
    public void changingFifthElementByAccessor() {
        NineTuple<Object, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> tuple = Tuple.nine(0, 1, 2, 3, 4, 5, 6, 7, 8);

        // Changing by value.
        NineTuple<Object, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> secondTuple = tuple.fifth(-1);
        assertThat(secondTuple, is(notNullValue()));
        assertThat(secondTuple.size(), is(tuple.size()));
        assertThat(secondTuple.first(), is(0));
        assertThat(secondTuple.second(), is(1));
        assertThat(secondTuple.third(), is(2));
        assertThat(secondTuple.fourth(), is(3));
        assertThat(secondTuple.fifth(), is(-1));
        assertThat(secondTuple.sixth(), is(5));
        assertThat(secondTuple.seventh(), is(6));
        assertThat(secondTuple.eighth(), is(7));
        assertThat(secondTuple.ninth(), is(8));

        // Changing by supplier.
        NineTuple<Object, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> thirdTuple = tuple.fifth(() -> -1);
        assertThat(thirdTuple, is(notNullValue()));
        assertThat(thirdTuple.size(), is(tuple.size()));
        assertThat(thirdTuple.first(), is(0));
        assertThat(thirdTuple.second(), is(1));
        assertThat(thirdTuple.third(), is(2));
        assertThat(thirdTuple.fourth(), is(3));
        assertThat(thirdTuple.fifth(), is(-1));
        assertThat(thirdTuple.sixth(), is(5));
        assertThat(thirdTuple.seventh(), is(6));
        assertThat(thirdTuple.eighth(), is(7));
        assertThat(thirdTuple.ninth(), is(8));

        // Changing by function.
        NineTuple<Object, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> fourthTuple = tuple.fifth(previous -> -1);
        assertThat(fourthTuple, is(notNullValue()));
        assertThat(fourthTuple.size(), is(tuple.size()));
        assertThat(fourthTuple.first(), is(0));
        assertThat(fourthTuple.second(), is(1));
        assertThat(fourthTuple.third(), is(2));
        assertThat(fourthTuple.fourth(), is(3));
        assertThat(fourthTuple.fifth(), is(-1));
        assertThat(fourthTuple.sixth(), is(5));
        assertThat(fourthTuple.seventh(), is(6));
        assertThat(fourthTuple.eighth(), is(7));
        assertThat(fourthTuple.ninth(), is(8));
    }

    @Test
    public void changingSixthElementByAccessor() {
        NineTuple<Object, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> tuple = Tuple.nine(0, 1, 2, 3, 4, 5, 6, 7, 8);

        // Changing by value.
        NineTuple<Object, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> secondTuple = tuple.sixth(-1);
        assertThat(secondTuple, is(notNullValue()));
        assertThat(secondTuple.size(), is(tuple.size()));
        assertThat(secondTuple.first(), is(0));
        assertThat(secondTuple.second(), is(1));
        assertThat(secondTuple.third(), is(2));
        assertThat(secondTuple.fourth(), is(3));
        assertThat(secondTuple.fifth(), is(4));
        assertThat(secondTuple.sixth(), is(-1));
        assertThat(secondTuple.seventh(), is(6));
        assertThat(secondTuple.eighth(), is(7));
        assertThat(secondTuple.ninth(), is(8));

        // Changing by supplier.
        NineTuple<Object, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> thirdTuple = tuple.sixth(() -> -1);
        assertThat(thirdTuple, is(notNullValue()));
        assertThat(thirdTuple.size(), is(tuple.size()));
        assertThat(thirdTuple.first(), is(0));
        assertThat(thirdTuple.second(), is(1));
        assertThat(thirdTuple.third(), is(2));
        assertThat(thirdTuple.fourth(), is(3));
        assertThat(thirdTuple.fifth(), is(4));
        assertThat(thirdTuple.sixth(), is(-1));
        assertThat(thirdTuple.seventh(), is(6));
        assertThat(thirdTuple.eighth(), is(7));
        assertThat(thirdTuple.ninth(), is(8));

        // Changing by function.
        NineTuple<Object, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> fourthTuple = tuple.sixth(previous -> -1);
        assertThat(fourthTuple, is(notNullValue()));
        assertThat(fourthTuple.size(), is(tuple.size()));
        assertThat(fourthTuple.first(), is(0));
        assertThat(fourthTuple.second(), is(1));
        assertThat(fourthTuple.third(), is(2));
        assertThat(fourthTuple.fourth(), is(3));
        assertThat(fourthTuple.fifth(), is(4));
        assertThat(fourthTuple.sixth(), is(-1));
        assertThat(fourthTuple.seventh(), is(6));
        assertThat(fourthTuple.eighth(), is(7));
        assertThat(fourthTuple.ninth(), is(8));
    }

    @Test
    public void changingSeventhElementByAccessor() {
        NineTuple<Object, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> tuple = Tuple.nine(0, 1, 2, 3, 4, 5, 6, 7, 8);

        // Changing by value.
        NineTuple<Object, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> secondTuple = tuple.seventh(-1);
        assertThat(secondTuple, is(notNullValue()));
        assertThat(secondTuple.size(), is(tuple.size()));
        assertThat(secondTuple.first(), is(0));
        assertThat(secondTuple.second(), is(1));
        assertThat(secondTuple.third(), is(2));
        assertThat(secondTuple.fourth(), is(3));
        assertThat(secondTuple.fifth(), is(4));
        assertThat(secondTuple.sixth(), is(5));
        assertThat(secondTuple.seventh(), is(-1));
        assertThat(secondTuple.eighth(), is(7));
        assertThat(secondTuple.ninth(), is(8));

        // Changing by supplier.
        NineTuple<Object, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> thirdTuple = tuple.seventh(() -> -1);
        assertThat(thirdTuple, is(notNullValue()));
        assertThat(thirdTuple.size(), is(tuple.size()));
        assertThat(thirdTuple.first(), is(0));
        assertThat(thirdTuple.second(), is(1));
        assertThat(thirdTuple.third(), is(2));
        assertThat(thirdTuple.fourth(), is(3));
        assertThat(thirdTuple.fifth(), is(4));
        assertThat(thirdTuple.sixth(), is(5));
        assertThat(thirdTuple.seventh(), is(-1));
        assertThat(thirdTuple.eighth(), is(7));
        assertThat(thirdTuple.ninth(), is(8));

        // Changing by function.
        NineTuple<Object, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> fourthTuple = tuple.seventh(previous -> -1);
        assertThat(fourthTuple, is(notNullValue()));
        assertThat(fourthTuple.size(), is(tuple.size()));
        assertThat(fourthTuple.first(), is(0));
        assertThat(fourthTuple.second(), is(1));
        assertThat(fourthTuple.third(), is(2));
        assertThat(fourthTuple.fourth(), is(3));
        assertThat(fourthTuple.fifth(), is(4));
        assertThat(fourthTuple.sixth(), is(5));
        assertThat(fourthTuple.seventh(), is(-1));
        assertThat(fourthTuple.eighth(), is(7));
        assertThat(fourthTuple.ninth(), is(8));
    }

    @Test
    public void changingEighthElementByAccessor() {
        NineTuple<Object, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> tuple = Tuple.nine(0, 1, 2, 3, 4, 5, 6, 7, 8);

        // Changing by value.
        NineTuple<Object, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> secondTuple = tuple.eighth(-1);
        assertThat(secondTuple, is(notNullValue()));
        assertThat(secondTuple.size(), is(tuple.size()));
        assertThat(secondTuple.first(), is(0));
        assertThat(secondTuple.second(), is(1));
        assertThat(secondTuple.third(), is(2));
        assertThat(secondTuple.fourth(), is(3));
        assertThat(secondTuple.fifth(), is(4));
        assertThat(secondTuple.sixth(), is(5));
        assertThat(secondTuple.seventh(), is(6));
        assertThat(secondTuple.eighth(), is(-1));
        assertThat(secondTuple.ninth(), is(8));

        // Changing by supplier.
        NineTuple<Object, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> thirdTuple = tuple.eighth(() -> -1);
        assertThat(thirdTuple, is(notNullValue()));
        assertThat(thirdTuple.size(), is(tuple.size()));
        assertThat(thirdTuple.first(), is(0));
        assertThat(thirdTuple.second(), is(1));
        assertThat(thirdTuple.third(), is(2));
        assertThat(thirdTuple.fourth(), is(3));
        assertThat(thirdTuple.fifth(), is(4));
        assertThat(thirdTuple.sixth(), is(5));
        assertThat(thirdTuple.seventh(), is(6));
        assertThat(thirdTuple.eighth(), is(-1));
        assertThat(thirdTuple.ninth(), is(8));

        // Changing by function.
        NineTuple<Object, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> fourthTuple = tuple.eighth(previous -> -1);
        assertThat(fourthTuple, is(notNullValue()));
        assertThat(fourthTuple.size(), is(tuple.size()));
        assertThat(fourthTuple.first(), is(0));
        assertThat(fourthTuple.second(), is(1));
        assertThat(fourthTuple.third(), is(2));
        assertThat(fourthTuple.fourth(), is(3));
        assertThat(fourthTuple.fifth(), is(4));
        assertThat(fourthTuple.sixth(), is(5));
        assertThat(fourthTuple.seventh(), is(6));
        assertThat(fourthTuple.eighth(), is(-1));
        assertThat(fourthTuple.ninth(), is(8));
    }

    @Test
    public void changingNinthElementByAccessor() {
        NineTuple<Object, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> tuple = Tuple.nine(0, 1, 2, 3, 4, 5, 6, 7, 8);

        // Changing by value.
        NineTuple<Object, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> secondTuple = tuple.ninth(-1);
        assertThat(secondTuple, is(notNullValue()));
        assertThat(secondTuple.size(), is(tuple.size()));
        assertThat(secondTuple.first(), is(0));
        assertThat(secondTuple.second(), is(1));
        assertThat(secondTuple.third(), is(2));
        assertThat(secondTuple.fourth(), is(3));
        assertThat(secondTuple.fifth(), is(4));
        assertThat(secondTuple.sixth(), is(5));
        assertThat(secondTuple.seventh(), is(6));
        assertThat(secondTuple.eighth(), is(7));
        assertThat(secondTuple.ninth(), is(-1));

        // Changing by supplier.
        NineTuple<Object, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> thirdTuple = tuple.ninth(() -> -1);
        assertThat(thirdTuple, is(notNullValue()));
        assertThat(thirdTuple.size(), is(tuple.size()));
        assertThat(thirdTuple.first(), is(0));
        assertThat(thirdTuple.second(), is(1));
        assertThat(thirdTuple.third(), is(2));
        assertThat(thirdTuple.fourth(), is(3));
        assertThat(thirdTuple.fifth(), is(4));
        assertThat(thirdTuple.sixth(), is(5));
        assertThat(thirdTuple.seventh(), is(6));
        assertThat(thirdTuple.eighth(), is(7));
        assertThat(thirdTuple.ninth(), is(-1));

        // Changing by function.
        NineTuple<Object, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> fourthTuple = tuple.ninth(previous -> -1);
        assertThat(fourthTuple, is(notNullValue()));
        assertThat(fourthTuple.size(), is(tuple.size()));
        assertThat(fourthTuple.first(), is(0));
        assertThat(fourthTuple.second(), is(1));
        assertThat(fourthTuple.third(), is(2));
        assertThat(fourthTuple.fourth(), is(3));
        assertThat(fourthTuple.fifth(), is(4));
        assertThat(fourthTuple.sixth(), is(5));
        assertThat(fourthTuple.seventh(), is(6));
        assertThat(fourthTuple.eighth(), is(7));
        assertThat(fourthTuple.ninth(), is(-1));
    }

    @Test
    public void droppingByIndex() {
        NineTuple<Object, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> tuple = Tuple.nine(0, 1, 2, 3, 4, 5, 6, 7, 8);
        for (int i = 0; i < 9; i++) {
            Tuple<?> other = tuple.drop(i);
            assertThat(other, is(notNullValue()));
            assertThat(other.size(), is(8));
            for (int j = 0; j < 9; j++) {
                if (j == i) {
                    continue;
                }
                assertThat(other.get(j < i ? j : j - 1), is(tuple.get(j)));
            }
        }
    }

    @Test
    public void droppingFirstElementByAccessor() {
        NineTuple<Object, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> tuple = Tuple.nine(0, 1, 2, 3, 4, 5, 6, 7, 8);
        EightTuple<Object, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> other = tuple.dropFirst();
        assertThat(other, is(notNullValue()));
        assertThat(other.size(), is(8));
        assertThat(other.first(), is(tuple.second()));
        assertThat(other.second(), is(tuple.third()));
        assertThat(other.third(), is(tuple.fourth()));
        assertThat(other.fourth(), is(tuple.fifth()));
        assertThat(other.fifth(), is(tuple.sixth()));
        assertThat(other.sixth(), is(tuple.seventh()));
        assertThat(other.seventh(), is(tuple.eighth()));
        assertThat(other.eighth(), is(tuple.ninth()));
    }

    @Test
    public void droppingSecondElementByAccessor() {
        NineTuple<Object, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> tuple = Tuple.nine(0, 1, 2, 3, 4, 5, 6, 7, 8);
        EightTuple<Object, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> other = tuple.dropSecond();
        assertThat(other, is(notNullValue()));
        assertThat(other.size(), is(8));
        assertThat(other.first(), is(tuple.first()));
        assertThat(other.second(), is(tuple.third()));
        assertThat(other.third(), is(tuple.fourth()));
        assertThat(other.fourth(), is(tuple.fifth()));
        assertThat(other.fifth(), is(tuple.sixth()));
        assertThat(other.sixth(), is(tuple.seventh()));
        assertThat(other.seventh(), is(tuple.eighth()));
        assertThat(other.eighth(), is(tuple.ninth()));
    }

    @Test
    public void droppingThirdElementByAccessor() {
        NineTuple<Object, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> tuple = Tuple.nine(0, 1, 2, 3, 4, 5, 6, 7, 8);
        EightTuple<Object, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> other = tuple.dropThird();
        assertThat(other, is(notNullValue()));
        assertThat(other.size(), is(8));
        assertThat(other.first(), is(tuple.first()));
        assertThat(other.second(), is(tuple.second()));
        assertThat(other.third(), is(tuple.fourth()));
        assertThat(other.fourth(), is(tuple.fifth()));
        assertThat(other.fifth(), is(tuple.sixth()));
        assertThat(other.sixth(), is(tuple.seventh()));
        assertThat(other.seventh(), is(tuple.eighth()));
        assertThat(other.eighth(), is(tuple.ninth()));
    }

    @Test
    public void droppingFourthElementByAccessor() {
        NineTuple<Object, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> tuple = Tuple.nine(0, 1, 2, 3, 4, 5, 6, 7, 8);
        EightTuple<Object, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> other = tuple.dropFourth();
        assertThat(other, is(notNullValue()));
        assertThat(other.size(), is(8));
        assertThat(other.first(), is(tuple.first()));
        assertThat(other.second(), is(tuple.second()));
        assertThat(other.third(), is(tuple.third()));
        assertThat(other.fourth(), is(tuple.fifth()));
        assertThat(other.fifth(), is(tuple.sixth()));
        assertThat(other.sixth(), is(tuple.seventh()));
        assertThat(other.seventh(), is(tuple.eighth()));
        assertThat(other.eighth(), is(tuple.ninth()));
    }

    @Test
    public void droppingFifthElementByAccessor() {
        NineTuple<Object, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> tuple = Tuple.nine(0, 1, 2, 3, 4, 5, 6, 7, 8);
        EightTuple<Object, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> other = tuple.dropFifth();
        assertThat(other, is(notNullValue()));
        assertThat(other.size(), is(8));
        assertThat(other.first(), is(tuple.first()));
        assertThat(other.second(), is(tuple.second()));
        assertThat(other.third(), is(tuple.third()));
        assertThat(other.fourth(), is(tuple.fourth()));
        assertThat(other.fifth(), is(tuple.sixth()));
        assertThat(other.sixth(), is(tuple.seventh()));
        assertThat(other.seventh(), is(tuple.eighth()));
        assertThat(other.eighth(), is(tuple.ninth()));
    }

    @Test
    public void droppingSixthElementByAccessor() {
        NineTuple<Object, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> tuple = Tuple.nine(0, 1, 2, 3, 4, 5, 6, 7, 8);
        EightTuple<Object, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> other = tuple.dropSixth();
        assertThat(other, is(notNullValue()));
        assertThat(other.size(), is(8));
        assertThat(other.first(), is(tuple.first()));
        assertThat(other.second(), is(tuple.second()));
        assertThat(other.third(), is(tuple.third()));
        assertThat(other.fourth(), is(tuple.fourth()));
        assertThat(other.fifth(), is(tuple.fifth()));
        assertThat(other.sixth(), is(tuple.seventh()));
        assertThat(other.seventh(), is(tuple.eighth()));
        assertThat(other.eighth(), is(tuple.ninth()));
    }

    @Test
    public void droppingSeventhElementByAccessor() {
        NineTuple<Object, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> tuple = Tuple.nine(0, 1, 2, 3, 4, 5, 6, 7, 8);
        EightTuple<Object, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> other = tuple.dropSeventh();
        assertThat(other, is(notNullValue()));
        assertThat(other.size(), is(8));
        assertThat(other.first(), is(tuple.first()));
        assertThat(other.second(), is(tuple.second()));
        assertThat(other.third(), is(tuple.third()));
        assertThat(other.fourth(), is(tuple.fourth()));
        assertThat(other.fifth(), is(tuple.fifth()));
        assertThat(other.sixth(), is(tuple.sixth()));
        assertThat(other.seventh(), is(tuple.eighth()));
        assertThat(other.eighth(), is(tuple.ninth()));
    }

    @Test
    public void droppingEighthElementByAccessor() {
        NineTuple<Object, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> tuple = Tuple.nine(0, 1, 2, 3, 4, 5, 6, 7, 8);
        EightTuple<Object, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> other = tuple.dropEighth();
        assertThat(other, is(notNullValue()));
        assertThat(other.size(), is(8));
        assertThat(other.first(), is(tuple.first()));
        assertThat(other.second(), is(tuple.second()));
        assertThat(other.third(), is(tuple.third()));
        assertThat(other.fourth(), is(tuple.fourth()));
        assertThat(other.fifth(), is(tuple.fifth()));
        assertThat(other.sixth(), is(tuple.sixth()));
        assertThat(other.seventh(), is(tuple.seventh()));
        assertThat(other.eighth(), is(tuple.ninth()));
    }

    @Test
    public void droppingNinthElementByAccessor() {
        NineTuple<Object, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> tuple = Tuple.nine(0, 1, 2, 3, 4, 5, 6, 7, 8);
        EightTuple<Object, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> other = tuple.dropNinth();
        assertThat(other, is(notNullValue()));
        assertThat(other.size(), is(8));
        assertThat(other.first(), is(tuple.first()));
        assertThat(other.second(), is(tuple.second()));
        assertThat(other.third(), is(tuple.third()));
        assertThat(other.fourth(), is(tuple.fourth()));
        assertThat(other.fifth(), is(tuple.fifth()));
        assertThat(other.sixth(), is(tuple.sixth()));
        assertThat(other.seventh(), is(tuple.seventh()));
        assertThat(other.eighth(), is(tuple.eighth()));
    }

    @Test
    public void clearingTuple() {
        NineTuple<Object, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> tuple = Tuple.nine(0, 1, 2, 3, 4, 5, 6, 7, 8);
        Tuple<?> other = tuple.clear();
        assertThat(other, is(notNullValue()));
        assertThat(other.size(), is(0));
    }

    @Test
    public void streamingTuple() {
        NineTuple<Object, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> tuple = Tuple.nine(0, 1, 2, 3, 4, 5, 6, 7, 8);
        List<Object> items = tuple.stream().collect(toList());
        assertThat(items, is(hasSize(9)));
        assertThat(items, is(contains(0, 1, 2, 3, 4, 5, 6, 7, 8)));
    }

    @Test
    public void gettingTupleAsList() {
        NineTuple<Object, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> tuple = Tuple.nine(0, 1, 2, 3, 4, 5, 6, 7, 8);
        List<Object> items = tuple.asList();
        assertThat(items, is(hasSize(9)));
        assertThat(items, is(contains(0, 1, 2, 3, 4, 5, 6, 7, 8)));
    }

    @Test
    public void checkingPredicateByIndex() {
        NineTuple<Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> tuple = NineTuple.of(0, 1, 2, 3, 4, 5, 6, 7, 8);
        for (int i = 0; i < 9; i++) {
            assertThat(tuple.check(i, x -> x % 2 == 0), is(i % 2 == 0));
        }
    }

    @Test
    public void checkingPredicateByAccessor() {
        NineTuple<Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> tuple = NineTuple.of(0, 1, 2, 3, 4, 5, 6, 7, 8);
        assertThat(tuple.checkFirst(x -> x % 2 == 0), is(true));
        assertThat(tuple.checkSecond(x -> x % 2 == 0), is(false));
        assertThat(tuple.checkThird(x -> x % 2 == 0), is(true));
        assertThat(tuple.checkFourth(x -> x % 2 == 0), is(false));
        assertThat(tuple.checkFifth(x -> x % 2 == 0), is(true));
        assertThat(tuple.checkSixth(x -> x % 2 == 0), is(false));
        assertThat(tuple.checkSeventh(x -> x % 2 == 0), is(true));
        assertThat(tuple.checkEighth(x -> x % 2 == 0), is(false));
        assertThat(tuple.checkNinth(x -> x % 2 == 0), is(true));
    }

    @Test
    public void extendingByValue() {
        NineTuple<Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> tuple = NineTuple.of(0, 1, 2, 3, 4, 5, 6, 7, 8);
        TenTuple<Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> secondTuple = NineTuple.extendWith(-1).apply(tuple);
        assertThat(secondTuple, is(notNullValue()));
        assertThat(secondTuple.size(), is(10));
        assertThat(secondTuple.first(), is(tuple.first()));
        assertThat(secondTuple.second(), is(tuple.second()));
        assertThat(secondTuple.third(), is(tuple.third()));
        assertThat(secondTuple.fourth(), is(tuple.fourth()));
        assertThat(secondTuple.fifth(), is(tuple.fifth()));
        assertThat(secondTuple.sixth(), is(tuple.sixth()));
        assertThat(secondTuple.seventh(), is(tuple.seventh()));
        assertThat(secondTuple.eighth(), is(tuple.eighth()));
        assertThat(secondTuple.ninth(), is(tuple.ninth()));
        assertThat(secondTuple.tenth(), is(-1));
        assertThat(secondTuple.drop(9), is(tuple));
    }

    @Test
    public void extendingBySupplier() {
        NineTuple<Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> tuple = NineTuple.of(0, 1, 2, 3, 4, 5, 6, 7, 8);
        TenTuple<Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> secondTuple = NineTuple.extendWith(() -> -1).apply(tuple);
        assertThat(secondTuple, is(notNullValue()));
        assertThat(secondTuple.size(), is(10));
        assertThat(secondTuple.first(), is(tuple.first()));
        assertThat(secondTuple.second(), is(tuple.second()));
        assertThat(secondTuple.third(), is(tuple.third()));
        assertThat(secondTuple.fourth(), is(tuple.fourth()));
        assertThat(secondTuple.fifth(), is(tuple.fifth()));
        assertThat(secondTuple.sixth(), is(tuple.sixth()));
        assertThat(secondTuple.seventh(), is(tuple.seventh()));
        assertThat(secondTuple.eighth(), is(tuple.eighth()));
        assertThat(secondTuple.ninth(), is(tuple.ninth()));
        assertThat(secondTuple.tenth(), is(-1));
        assertThat(secondTuple.drop(9), is(tuple));
    }

    @Test
    public void extendingByFunction() {
        NineTuple<Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> tuple = NineTuple.of(0, 1, 2, 3, 4, 5, 6, 7, 8);
        TenTuple<Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> secondTuple = NineTuple.extendWith((NineTuple<Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> t) -> -1).apply(tuple);
        assertThat(secondTuple, is(notNullValue()));
        assertThat(secondTuple.size(), is(10));
        assertThat(secondTuple.first(), is(tuple.first()));
        assertThat(secondTuple.second(), is(tuple.second()));
        assertThat(secondTuple.third(), is(tuple.third()));
        assertThat(secondTuple.fourth(), is(tuple.fourth()));
        assertThat(secondTuple.fifth(), is(tuple.fifth()));
        assertThat(secondTuple.sixth(), is(tuple.sixth()));
        assertThat(secondTuple.seventh(), is(tuple.seventh()));
        assertThat(secondTuple.eighth(), is(tuple.eighth()));
        assertThat(secondTuple.ninth(), is(tuple.ninth()));
        assertThat(secondTuple.tenth(), is(-1));
        assertThat(secondTuple.drop(9), is(tuple));
    }

    @Test
    public void labelingTuple() {
        NineTuple<Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> tuple = NineTuple.of(0, 1, 2, 3, 4, 5, 6, 7, 8);
        LabeledTuple<Integer> other = tuple.withLabels("e0", "e1", "e2", "e3", "e4", "e5", "e6", "e7", "e8");
        assertThat(other, is(notNullValue()));
        assertThat(other.size(), is(9));
        assertThat(other.labels(), is(contains("e0", "e1", "e2", "e3", "e4", "e5", "e6", "e7", "e8")));
        assertThat(other.get("e0"), is(tuple.get(0)));
        assertThat(other.get("e1"), is(tuple.get(1)));
        assertThat(other.get("e2"), is(tuple.get(2)));
        assertThat(other.get("e3"), is(tuple.get(3)));
        assertThat(other.get("e4"), is(tuple.get(4)));
        assertThat(other.get("e5"), is(tuple.get(5)));
        assertThat(other.get("e6"), is(tuple.get(6)));
        assertThat(other.get("e7"), is(tuple.get(7)));
        assertThat(other.get("e8"), is(tuple.get(8)));
        LabeledTuple<Integer> extended = other.extend(-1, "last");
        assertThat(extended, is(notNullValue()));
        assertThat(extended.size(), is(10));
        assertThat(extended.get("last"), is(-1));
    }

    @Test
    public void equality() {
        NineTuple<Object, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> tuple = Tuple.nine(0, 1, 2, 3, 4, 5, 6, 7, 8);
        NineTuple<Object, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> secondTuple = Tuple.nine(0, 1, 2, 3, 4, 5, 6, 7, 8);
        assertThat(tuple, is(secondTuple));
    }

    @Test
    public void hashCodeCalculation() {
        NineTuple<Object, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> tuple = Tuple.nine(0, 1, 2, 3, 4, 5, 6, 7, 8);
        NineTuple<Object, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> secondTuple = Tuple.nine(0, 1, 2, 3, 4, 5, 6, 7, 8);
        assertThat(tuple.hashCode(), is(secondTuple.hashCode()));
    }

    @Test
    public void toStringCalculation() {
        NineTuple<Object, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> tuple = Tuple.nine(0, 1, 2, 3, 4, 5, 6, 7, 8);
        NineTuple<Object, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> secondTuple = Tuple.nine(0, 1, 2, 3, 4, 5, 6, 7, 8);
        assertThat(tuple.toString(), is(secondTuple.toString()));
    }

}


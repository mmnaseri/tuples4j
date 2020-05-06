package com.mmnaseri.utils.tuples.impl;

import com.mmnaseri.utils.tuples.LabeledTuple;
import com.mmnaseri.utils.tuples.Tuple;
import org.testng.annotations.Test;

import java.util.List;

import static java.util.stream.Collectors.toList;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

/**
 * Tests for {@link ElevenTuple}.
 *
 * @author Milad Naseri (m.m.naseri@gmail.com)
 */
public class ElevenTupleTest {

    @Test
    public void creatingTuple() {
        ElevenTuple<Object, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> tuple = Tuple.eleven(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        assertThat(tuple, is(notNullValue()));
        assertThat(tuple.size(), is(11));
    }

    @Test
    public void accessingMembers() {
        ElevenTuple<Object, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> tuple = Tuple.eleven(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
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
    }

    @Test
    public void changingElementByIndex() {
        ElevenTuple<Object, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> tuple = Tuple.eleven(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        for (int i = 0; i < 11; i++) {
            Tuple<?> other = tuple.change(i, -1);
            assertThat(other, is(notNullValue()));
            assertThat(other.size(), is(11));
            assertThat(other.get(i), is(-1));
        }
    }

    @Test
    public void changingElementByIndexThroughFunction() {
        ElevenTuple<Object, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> tuple = Tuple.eleven(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        for (int i = 0; i < 11; i++) {
            Tuple<?> other = tuple.change(i, t -> -1);
            assertThat(other, is(notNullValue()));
            assertThat(other.size(), is(11));
            assertThat(other.get(i), is(-1));
        }
    }

    @Test
    public void changingFirstElementByAccessor() {
        ElevenTuple<Object, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> tuple = Tuple.eleven(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        // Changing by value.
        ElevenTuple<Object, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> secondTuple = tuple.first(-1);
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
        assertThat(secondTuple.tenth(), is(9));
        assertThat(secondTuple.eleventh(), is(10));

        // Changing by supplier.
        ElevenTuple<Object, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> thirdTuple = tuple.first(() -> -1);
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
        assertThat(thirdTuple.tenth(), is(9));
        assertThat(thirdTuple.eleventh(), is(10));

        // Changing by function.
        ElevenTuple<Object, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> fourthTuple = tuple.first(previous -> -1);
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
        assertThat(fourthTuple.tenth(), is(9));
        assertThat(fourthTuple.eleventh(), is(10));
    }

    @Test
    public void changingSecondElementByAccessor() {
        ElevenTuple<Object, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> tuple = Tuple.eleven(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        // Changing by value.
        ElevenTuple<Object, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> secondTuple = tuple.second(-1);
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
        assertThat(secondTuple.tenth(), is(9));
        assertThat(secondTuple.eleventh(), is(10));

        // Changing by supplier.
        ElevenTuple<Object, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> thirdTuple = tuple.second(() -> -1);
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
        assertThat(thirdTuple.tenth(), is(9));
        assertThat(thirdTuple.eleventh(), is(10));

        // Changing by function.
        ElevenTuple<Object, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> fourthTuple = tuple.second(previous -> -1);
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
        assertThat(fourthTuple.tenth(), is(9));
        assertThat(fourthTuple.eleventh(), is(10));
    }

    @Test
    public void changingThirdElementByAccessor() {
        ElevenTuple<Object, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> tuple = Tuple.eleven(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        // Changing by value.
        ElevenTuple<Object, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> secondTuple = tuple.third(-1);
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
        assertThat(secondTuple.tenth(), is(9));
        assertThat(secondTuple.eleventh(), is(10));

        // Changing by supplier.
        ElevenTuple<Object, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> thirdTuple = tuple.third(() -> -1);
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
        assertThat(thirdTuple.tenth(), is(9));
        assertThat(thirdTuple.eleventh(), is(10));

        // Changing by function.
        ElevenTuple<Object, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> fourthTuple = tuple.third(previous -> -1);
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
        assertThat(fourthTuple.tenth(), is(9));
        assertThat(fourthTuple.eleventh(), is(10));
    }

    @Test
    public void changingFourthElementByAccessor() {
        ElevenTuple<Object, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> tuple = Tuple.eleven(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        // Changing by value.
        ElevenTuple<Object, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> secondTuple = tuple.fourth(-1);
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
        assertThat(secondTuple.tenth(), is(9));
        assertThat(secondTuple.eleventh(), is(10));

        // Changing by supplier.
        ElevenTuple<Object, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> thirdTuple = tuple.fourth(() -> -1);
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
        assertThat(thirdTuple.tenth(), is(9));
        assertThat(thirdTuple.eleventh(), is(10));

        // Changing by function.
        ElevenTuple<Object, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> fourthTuple = tuple.fourth(previous -> -1);
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
        assertThat(fourthTuple.tenth(), is(9));
        assertThat(fourthTuple.eleventh(), is(10));
    }

    @Test
    public void changingFifthElementByAccessor() {
        ElevenTuple<Object, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> tuple = Tuple.eleven(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        // Changing by value.
        ElevenTuple<Object, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> secondTuple = tuple.fifth(-1);
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
        assertThat(secondTuple.tenth(), is(9));
        assertThat(secondTuple.eleventh(), is(10));

        // Changing by supplier.
        ElevenTuple<Object, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> thirdTuple = tuple.fifth(() -> -1);
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
        assertThat(thirdTuple.tenth(), is(9));
        assertThat(thirdTuple.eleventh(), is(10));

        // Changing by function.
        ElevenTuple<Object, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> fourthTuple = tuple.fifth(previous -> -1);
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
        assertThat(fourthTuple.tenth(), is(9));
        assertThat(fourthTuple.eleventh(), is(10));
    }

    @Test
    public void changingSixthElementByAccessor() {
        ElevenTuple<Object, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> tuple = Tuple.eleven(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        // Changing by value.
        ElevenTuple<Object, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> secondTuple = tuple.sixth(-1);
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
        assertThat(secondTuple.tenth(), is(9));
        assertThat(secondTuple.eleventh(), is(10));

        // Changing by supplier.
        ElevenTuple<Object, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> thirdTuple = tuple.sixth(() -> -1);
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
        assertThat(thirdTuple.tenth(), is(9));
        assertThat(thirdTuple.eleventh(), is(10));

        // Changing by function.
        ElevenTuple<Object, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> fourthTuple = tuple.sixth(previous -> -1);
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
        assertThat(fourthTuple.tenth(), is(9));
        assertThat(fourthTuple.eleventh(), is(10));
    }

    @Test
    public void changingSeventhElementByAccessor() {
        ElevenTuple<Object, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> tuple = Tuple.eleven(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        // Changing by value.
        ElevenTuple<Object, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> secondTuple = tuple.seventh(-1);
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
        assertThat(secondTuple.tenth(), is(9));
        assertThat(secondTuple.eleventh(), is(10));

        // Changing by supplier.
        ElevenTuple<Object, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> thirdTuple = tuple.seventh(() -> -1);
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
        assertThat(thirdTuple.tenth(), is(9));
        assertThat(thirdTuple.eleventh(), is(10));

        // Changing by function.
        ElevenTuple<Object, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> fourthTuple = tuple.seventh(previous -> -1);
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
        assertThat(fourthTuple.tenth(), is(9));
        assertThat(fourthTuple.eleventh(), is(10));
    }

    @Test
    public void changingEighthElementByAccessor() {
        ElevenTuple<Object, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> tuple = Tuple.eleven(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        // Changing by value.
        ElevenTuple<Object, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> secondTuple = tuple.eighth(-1);
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
        assertThat(secondTuple.tenth(), is(9));
        assertThat(secondTuple.eleventh(), is(10));

        // Changing by supplier.
        ElevenTuple<Object, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> thirdTuple = tuple.eighth(() -> -1);
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
        assertThat(thirdTuple.tenth(), is(9));
        assertThat(thirdTuple.eleventh(), is(10));

        // Changing by function.
        ElevenTuple<Object, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> fourthTuple = tuple.eighth(previous -> -1);
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
        assertThat(fourthTuple.tenth(), is(9));
        assertThat(fourthTuple.eleventh(), is(10));
    }

    @Test
    public void changingNinthElementByAccessor() {
        ElevenTuple<Object, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> tuple = Tuple.eleven(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        // Changing by value.
        ElevenTuple<Object, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> secondTuple = tuple.ninth(-1);
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
        assertThat(secondTuple.tenth(), is(9));
        assertThat(secondTuple.eleventh(), is(10));

        // Changing by supplier.
        ElevenTuple<Object, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> thirdTuple = tuple.ninth(() -> -1);
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
        assertThat(thirdTuple.tenth(), is(9));
        assertThat(thirdTuple.eleventh(), is(10));

        // Changing by function.
        ElevenTuple<Object, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> fourthTuple = tuple.ninth(previous -> -1);
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
        assertThat(fourthTuple.tenth(), is(9));
        assertThat(fourthTuple.eleventh(), is(10));
    }

    @Test
    public void changingTenthElementByAccessor() {
        ElevenTuple<Object, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> tuple = Tuple.eleven(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        // Changing by value.
        ElevenTuple<Object, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> secondTuple = tuple.tenth(-1);
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
        assertThat(secondTuple.ninth(), is(8));
        assertThat(secondTuple.tenth(), is(-1));
        assertThat(secondTuple.eleventh(), is(10));

        // Changing by supplier.
        ElevenTuple<Object, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> thirdTuple = tuple.tenth(() -> -1);
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
        assertThat(thirdTuple.ninth(), is(8));
        assertThat(thirdTuple.tenth(), is(-1));
        assertThat(thirdTuple.eleventh(), is(10));

        // Changing by function.
        ElevenTuple<Object, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> fourthTuple = tuple.tenth(previous -> -1);
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
        assertThat(fourthTuple.ninth(), is(8));
        assertThat(fourthTuple.tenth(), is(-1));
        assertThat(fourthTuple.eleventh(), is(10));
    }

    @Test
    public void changingEleventhElementByAccessor() {
        ElevenTuple<Object, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> tuple = Tuple.eleven(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        // Changing by value.
        ElevenTuple<Object, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> secondTuple = tuple.eleventh(-1);
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
        assertThat(secondTuple.ninth(), is(8));
        assertThat(secondTuple.tenth(), is(9));
        assertThat(secondTuple.eleventh(), is(-1));

        // Changing by supplier.
        ElevenTuple<Object, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> thirdTuple = tuple.eleventh(() -> -1);
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
        assertThat(thirdTuple.ninth(), is(8));
        assertThat(thirdTuple.tenth(), is(9));
        assertThat(thirdTuple.eleventh(), is(-1));

        // Changing by function.
        ElevenTuple<Object, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> fourthTuple = tuple.eleventh(previous -> -1);
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
        assertThat(fourthTuple.ninth(), is(8));
        assertThat(fourthTuple.tenth(), is(9));
        assertThat(fourthTuple.eleventh(), is(-1));
    }

    @Test
    public void droppingByIndex() {
        ElevenTuple<Object, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> tuple = Tuple.eleven(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        for (int i = 0; i < 11; i++) {
            Tuple<?> other = tuple.drop(i);
            assertThat(other, is(notNullValue()));
            assertThat(other.size(), is(10));
            for (int j = 0; j < 11; j++) {
                if (j == i) {
                    continue;
                }
                assertThat(other.get(j < i ? j : j - 1), is(tuple.get(j)));
            }
        }
    }

    @Test
    public void droppingFirstElementByAccessor() {
        ElevenTuple<Object, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> tuple = Tuple.eleven(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        TenTuple<Object, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> other = tuple.dropFirst();
        assertThat(other, is(notNullValue()));
        assertThat(other.size(), is(10));
        assertThat(other.first(), is(tuple.second()));
        assertThat(other.second(), is(tuple.third()));
        assertThat(other.third(), is(tuple.fourth()));
        assertThat(other.fourth(), is(tuple.fifth()));
        assertThat(other.fifth(), is(tuple.sixth()));
        assertThat(other.sixth(), is(tuple.seventh()));
        assertThat(other.seventh(), is(tuple.eighth()));
        assertThat(other.eighth(), is(tuple.ninth()));
        assertThat(other.ninth(), is(tuple.tenth()));
        assertThat(other.tenth(), is(tuple.eleventh()));
    }

    @Test
    public void droppingSecondElementByAccessor() {
        ElevenTuple<Object, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> tuple = Tuple.eleven(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        TenTuple<Object, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> other = tuple.dropSecond();
        assertThat(other, is(notNullValue()));
        assertThat(other.size(), is(10));
        assertThat(other.first(), is(tuple.first()));
        assertThat(other.second(), is(tuple.third()));
        assertThat(other.third(), is(tuple.fourth()));
        assertThat(other.fourth(), is(tuple.fifth()));
        assertThat(other.fifth(), is(tuple.sixth()));
        assertThat(other.sixth(), is(tuple.seventh()));
        assertThat(other.seventh(), is(tuple.eighth()));
        assertThat(other.eighth(), is(tuple.ninth()));
        assertThat(other.ninth(), is(tuple.tenth()));
        assertThat(other.tenth(), is(tuple.eleventh()));
    }

    @Test
    public void droppingThirdElementByAccessor() {
        ElevenTuple<Object, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> tuple = Tuple.eleven(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        TenTuple<Object, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> other = tuple.dropThird();
        assertThat(other, is(notNullValue()));
        assertThat(other.size(), is(10));
        assertThat(other.first(), is(tuple.first()));
        assertThat(other.second(), is(tuple.second()));
        assertThat(other.third(), is(tuple.fourth()));
        assertThat(other.fourth(), is(tuple.fifth()));
        assertThat(other.fifth(), is(tuple.sixth()));
        assertThat(other.sixth(), is(tuple.seventh()));
        assertThat(other.seventh(), is(tuple.eighth()));
        assertThat(other.eighth(), is(tuple.ninth()));
        assertThat(other.ninth(), is(tuple.tenth()));
        assertThat(other.tenth(), is(tuple.eleventh()));
    }

    @Test
    public void droppingFourthElementByAccessor() {
        ElevenTuple<Object, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> tuple = Tuple.eleven(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        TenTuple<Object, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> other = tuple.dropFourth();
        assertThat(other, is(notNullValue()));
        assertThat(other.size(), is(10));
        assertThat(other.first(), is(tuple.first()));
        assertThat(other.second(), is(tuple.second()));
        assertThat(other.third(), is(tuple.third()));
        assertThat(other.fourth(), is(tuple.fifth()));
        assertThat(other.fifth(), is(tuple.sixth()));
        assertThat(other.sixth(), is(tuple.seventh()));
        assertThat(other.seventh(), is(tuple.eighth()));
        assertThat(other.eighth(), is(tuple.ninth()));
        assertThat(other.ninth(), is(tuple.tenth()));
        assertThat(other.tenth(), is(tuple.eleventh()));
    }

    @Test
    public void droppingFifthElementByAccessor() {
        ElevenTuple<Object, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> tuple = Tuple.eleven(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        TenTuple<Object, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> other = tuple.dropFifth();
        assertThat(other, is(notNullValue()));
        assertThat(other.size(), is(10));
        assertThat(other.first(), is(tuple.first()));
        assertThat(other.second(), is(tuple.second()));
        assertThat(other.third(), is(tuple.third()));
        assertThat(other.fourth(), is(tuple.fourth()));
        assertThat(other.fifth(), is(tuple.sixth()));
        assertThat(other.sixth(), is(tuple.seventh()));
        assertThat(other.seventh(), is(tuple.eighth()));
        assertThat(other.eighth(), is(tuple.ninth()));
        assertThat(other.ninth(), is(tuple.tenth()));
        assertThat(other.tenth(), is(tuple.eleventh()));
    }

    @Test
    public void droppingSixthElementByAccessor() {
        ElevenTuple<Object, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> tuple = Tuple.eleven(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        TenTuple<Object, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> other = tuple.dropSixth();
        assertThat(other, is(notNullValue()));
        assertThat(other.size(), is(10));
        assertThat(other.first(), is(tuple.first()));
        assertThat(other.second(), is(tuple.second()));
        assertThat(other.third(), is(tuple.third()));
        assertThat(other.fourth(), is(tuple.fourth()));
        assertThat(other.fifth(), is(tuple.fifth()));
        assertThat(other.sixth(), is(tuple.seventh()));
        assertThat(other.seventh(), is(tuple.eighth()));
        assertThat(other.eighth(), is(tuple.ninth()));
        assertThat(other.ninth(), is(tuple.tenth()));
        assertThat(other.tenth(), is(tuple.eleventh()));
    }

    @Test
    public void droppingSeventhElementByAccessor() {
        ElevenTuple<Object, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> tuple = Tuple.eleven(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        TenTuple<Object, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> other = tuple.dropSeventh();
        assertThat(other, is(notNullValue()));
        assertThat(other.size(), is(10));
        assertThat(other.first(), is(tuple.first()));
        assertThat(other.second(), is(tuple.second()));
        assertThat(other.third(), is(tuple.third()));
        assertThat(other.fourth(), is(tuple.fourth()));
        assertThat(other.fifth(), is(tuple.fifth()));
        assertThat(other.sixth(), is(tuple.sixth()));
        assertThat(other.seventh(), is(tuple.eighth()));
        assertThat(other.eighth(), is(tuple.ninth()));
        assertThat(other.ninth(), is(tuple.tenth()));
        assertThat(other.tenth(), is(tuple.eleventh()));
    }

    @Test
    public void droppingEighthElementByAccessor() {
        ElevenTuple<Object, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> tuple = Tuple.eleven(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        TenTuple<Object, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> other = tuple.dropEighth();
        assertThat(other, is(notNullValue()));
        assertThat(other.size(), is(10));
        assertThat(other.first(), is(tuple.first()));
        assertThat(other.second(), is(tuple.second()));
        assertThat(other.third(), is(tuple.third()));
        assertThat(other.fourth(), is(tuple.fourth()));
        assertThat(other.fifth(), is(tuple.fifth()));
        assertThat(other.sixth(), is(tuple.sixth()));
        assertThat(other.seventh(), is(tuple.seventh()));
        assertThat(other.eighth(), is(tuple.ninth()));
        assertThat(other.ninth(), is(tuple.tenth()));
        assertThat(other.tenth(), is(tuple.eleventh()));
    }

    @Test
    public void droppingNinthElementByAccessor() {
        ElevenTuple<Object, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> tuple = Tuple.eleven(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        TenTuple<Object, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> other = tuple.dropNinth();
        assertThat(other, is(notNullValue()));
        assertThat(other.size(), is(10));
        assertThat(other.first(), is(tuple.first()));
        assertThat(other.second(), is(tuple.second()));
        assertThat(other.third(), is(tuple.third()));
        assertThat(other.fourth(), is(tuple.fourth()));
        assertThat(other.fifth(), is(tuple.fifth()));
        assertThat(other.sixth(), is(tuple.sixth()));
        assertThat(other.seventh(), is(tuple.seventh()));
        assertThat(other.eighth(), is(tuple.eighth()));
        assertThat(other.ninth(), is(tuple.tenth()));
        assertThat(other.tenth(), is(tuple.eleventh()));
    }

    @Test
    public void droppingTenthElementByAccessor() {
        ElevenTuple<Object, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> tuple = Tuple.eleven(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        TenTuple<Object, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> other = tuple.dropTenth();
        assertThat(other, is(notNullValue()));
        assertThat(other.size(), is(10));
        assertThat(other.first(), is(tuple.first()));
        assertThat(other.second(), is(tuple.second()));
        assertThat(other.third(), is(tuple.third()));
        assertThat(other.fourth(), is(tuple.fourth()));
        assertThat(other.fifth(), is(tuple.fifth()));
        assertThat(other.sixth(), is(tuple.sixth()));
        assertThat(other.seventh(), is(tuple.seventh()));
        assertThat(other.eighth(), is(tuple.eighth()));
        assertThat(other.ninth(), is(tuple.ninth()));
        assertThat(other.tenth(), is(tuple.eleventh()));
    }

    @Test
    public void droppingEleventhElementByAccessor() {
        ElevenTuple<Object, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> tuple = Tuple.eleven(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        TenTuple<Object, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> other = tuple.dropEleventh();
        assertThat(other, is(notNullValue()));
        assertThat(other.size(), is(10));
        assertThat(other.first(), is(tuple.first()));
        assertThat(other.second(), is(tuple.second()));
        assertThat(other.third(), is(tuple.third()));
        assertThat(other.fourth(), is(tuple.fourth()));
        assertThat(other.fifth(), is(tuple.fifth()));
        assertThat(other.sixth(), is(tuple.sixth()));
        assertThat(other.seventh(), is(tuple.seventh()));
        assertThat(other.eighth(), is(tuple.eighth()));
        assertThat(other.ninth(), is(tuple.ninth()));
        assertThat(other.tenth(), is(tuple.tenth()));
    }

    @Test
    public void clearingTuple() {
        ElevenTuple<Object, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> tuple = Tuple.eleven(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Tuple<?> other = tuple.clear();
        assertThat(other, is(notNullValue()));
        assertThat(other.size(), is(0));
    }

    @Test
    public void streamingTuple() {
        ElevenTuple<Object, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> tuple = Tuple.eleven(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<Object> items = tuple.stream().collect(toList());
        assertThat(items, is(hasSize(11)));
        assertThat(items, is(contains(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10)));
    }

    @Test
    public void gettingTupleAsList() {
        ElevenTuple<Object, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> tuple = Tuple.eleven(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<Object> items = tuple.asList();
        assertThat(items, is(hasSize(11)));
        assertThat(items, is(contains(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10)));
    }

    @Test
    public void checkingPredicateByIndex() {
        ElevenTuple<Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> tuple = ElevenTuple.of(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        for (int i = 0; i < 11; i++) {
            assertThat(tuple.check(i, x -> x % 2 == 0), is(i % 2 == 0));
        }
    }

    @Test
    public void checkingPredicateByAccessor() {
        ElevenTuple<Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> tuple = ElevenTuple.of(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
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
    }

    @Test
    public void extendingByValue() {
        ElevenTuple<Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> tuple = ElevenTuple.of(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        TwelveTuple<Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> secondTuple = ElevenTuple.extendWith(-1).apply(tuple);
        assertThat(secondTuple, is(notNullValue()));
        assertThat(secondTuple.size(), is(12));
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
        assertThat(secondTuple.twelfth(), is(-1));
        assertThat(secondTuple.drop(11), is(tuple));
    }

    @Test
    public void extendingBySupplier() {
        ElevenTuple<Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> tuple = ElevenTuple.of(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        TwelveTuple<Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> secondTuple = ElevenTuple.extendWith(() -> -1).apply(tuple);
        assertThat(secondTuple, is(notNullValue()));
        assertThat(secondTuple.size(), is(12));
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
        assertThat(secondTuple.twelfth(), is(-1));
        assertThat(secondTuple.drop(11), is(tuple));
    }

    @Test
    public void extendingByFunction() {
        ElevenTuple<Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> tuple = ElevenTuple.of(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        TwelveTuple<Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> secondTuple = ElevenTuple.extendWith((ElevenTuple<Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> t) -> -1).apply(tuple);
        assertThat(secondTuple, is(notNullValue()));
        assertThat(secondTuple.size(), is(12));
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
        assertThat(secondTuple.twelfth(), is(-1));
        assertThat(secondTuple.drop(11), is(tuple));
    }

    @Test
    public void labelingTuple() {
        ElevenTuple<Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> tuple = ElevenTuple.of(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        LabeledTuple<Integer> other = tuple.withLabels("e0", "e1", "e2", "e3", "e4", "e5", "e6", "e7", "e8", "e9", "e10");
        assertThat(other, is(notNullValue()));
        assertThat(other.size(), is(11));
        assertThat(other.labels(), is(contains("e0", "e1", "e2", "e3", "e4", "e5", "e6", "e7", "e8", "e9", "e10")));
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
        LabeledTuple<Integer> extended = other.extend(-1, "last");
        assertThat(extended, is(notNullValue()));
        assertThat(extended.size(), is(12));
        assertThat(extended.get("last"), is(-1));
    }

    @Test
    public void equality() {
        ElevenTuple<Object, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> tuple = Tuple.eleven(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        ElevenTuple<Object, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> secondTuple = Tuple.eleven(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        assertThat(tuple, is(secondTuple));
    }

    @Test
    public void hashCodeCalculation() {
        ElevenTuple<Object, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> tuple = Tuple.eleven(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        ElevenTuple<Object, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> secondTuple = Tuple.eleven(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        assertThat(tuple.hashCode(), is(secondTuple.hashCode()));
    }

    @Test
    public void toStringCalculation() {
        ElevenTuple<Object, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> tuple = Tuple.eleven(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        ElevenTuple<Object, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> secondTuple = Tuple.eleven(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        assertThat(tuple.toString(), is(secondTuple.toString()));
    }

}


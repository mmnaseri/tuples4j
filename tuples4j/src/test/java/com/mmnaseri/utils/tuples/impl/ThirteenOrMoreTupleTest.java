package com.mmnaseri.utils.tuples.impl;

import com.mmnaseri.utils.tuples.LabeledTuple;
import com.mmnaseri.utils.tuples.Tuple;
import org.testng.annotations.Test;

import java.util.List;

import static java.util.stream.Collectors.toList;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.arrayWithSize;
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
    ThirteenOrMoreTuple<
            Object,
            Integer,
            Integer,
            Integer,
            Integer,
            Integer,
            Integer,
            Integer,
            Integer,
            Integer,
            Integer,
            Integer,
            Integer>
        tuple = Tuple.large(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12);
    assertThat(tuple, is(notNullValue()));
    assertThat(tuple.size(), is(13));
  }

  @Test
  public void testToArray() {
    Tuple<Object> tuple = Tuple.of(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12);
    Object[] first = tuple.asArray();
    Object[] second = tuple.asArray(Object[]::new);
    assertThat(first, is(notNullValue()));
    assertThat(second, is(notNullValue()));
    assertThat(first, is(arrayWithSize(tuple.size())));
    assertThat(second, is(arrayWithSize(tuple.size())));
    for (int i = 0; i < tuple.size(); i++) {
      assertThat(first[i], is(tuple.get(i)));
      assertThat(second[i], is(tuple.get(i)));
    }
  }

  @Test
  public void testResizeAsEmpty() {
    Tuple<Object> tuple = Tuple.large(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12);
    EmptyTuple<Object> other = tuple.asEmpty();
    assertThat(other.size(), is(0));
  }

  @Test
  public void testResizeAsOne() {
    Tuple<Object> tuple = Tuple.large(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12);
    OneTuple<Object, Object> other = tuple.asOne();
    assertThat(other.size(), is(1));
    assertThat(other.first(), is(tuple.get(0)));
  }

  @Test
  public void testResizeAsTwo() {
    Tuple<Object> tuple = Tuple.large(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12);
    TwoTuple<Object, Object, Object> other = tuple.asTwo();
    assertThat(other.size(), is(2));
    assertThat(other.first(), is(tuple.get(0)));
    assertThat(other.second(), is(tuple.get(1)));
  }

  @Test
  public void testResizeAsThree() {
    Tuple<Object> tuple = Tuple.large(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12);
    ThreeTuple<Object, Object, Object, Object> other = tuple.asThree();
    assertThat(other.size(), is(3));
    assertThat(other.first(), is(tuple.get(0)));
    assertThat(other.second(), is(tuple.get(1)));
    assertThat(other.third(), is(tuple.get(2)));
  }

  @Test
  public void testResizeAsFour() {
    Tuple<Object> tuple = Tuple.large(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12);
    FourTuple<Object, Object, Object, Object, Object> other = tuple.asFour();
    assertThat(other.size(), is(4));
    assertThat(other.first(), is(tuple.get(0)));
    assertThat(other.second(), is(tuple.get(1)));
    assertThat(other.third(), is(tuple.get(2)));
    assertThat(other.fourth(), is(tuple.get(3)));
  }

  @Test
  public void testResizeAsFive() {
    Tuple<Object> tuple = Tuple.large(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12);
    FiveTuple<Object, Object, Object, Object, Object, Object> other = tuple.asFive();
    assertThat(other.size(), is(5));
    assertThat(other.first(), is(tuple.get(0)));
    assertThat(other.second(), is(tuple.get(1)));
    assertThat(other.third(), is(tuple.get(2)));
    assertThat(other.fourth(), is(tuple.get(3)));
    assertThat(other.fifth(), is(tuple.get(4)));
  }

  @Test
  public void testResizeAsSix() {
    Tuple<Object> tuple = Tuple.large(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12);
    SixTuple<Object, Object, Object, Object, Object, Object, Object> other = tuple.asSix();
    assertThat(other.size(), is(6));
    assertThat(other.first(), is(tuple.get(0)));
    assertThat(other.second(), is(tuple.get(1)));
    assertThat(other.third(), is(tuple.get(2)));
    assertThat(other.fourth(), is(tuple.get(3)));
    assertThat(other.fifth(), is(tuple.get(4)));
    assertThat(other.sixth(), is(tuple.get(5)));
  }

  @Test
  public void testResizeAsSeven() {
    Tuple<Object> tuple = Tuple.large(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12);
    SevenTuple<Object, Object, Object, Object, Object, Object, Object, Object> other =
        tuple.asSeven();
    assertThat(other.size(), is(7));
    assertThat(other.first(), is(tuple.get(0)));
    assertThat(other.second(), is(tuple.get(1)));
    assertThat(other.third(), is(tuple.get(2)));
    assertThat(other.fourth(), is(tuple.get(3)));
    assertThat(other.fifth(), is(tuple.get(4)));
    assertThat(other.sixth(), is(tuple.get(5)));
    assertThat(other.seventh(), is(tuple.get(6)));
  }

  @Test
  public void testResizeAsEight() {
    Tuple<Object> tuple = Tuple.large(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12);
    EightTuple<Object, Object, Object, Object, Object, Object, Object, Object, Object> other =
        tuple.asEight();
    assertThat(other.size(), is(8));
    assertThat(other.first(), is(tuple.get(0)));
    assertThat(other.second(), is(tuple.get(1)));
    assertThat(other.third(), is(tuple.get(2)));
    assertThat(other.fourth(), is(tuple.get(3)));
    assertThat(other.fifth(), is(tuple.get(4)));
    assertThat(other.sixth(), is(tuple.get(5)));
    assertThat(other.seventh(), is(tuple.get(6)));
    assertThat(other.eighth(), is(tuple.get(7)));
  }

  @Test
  public void testResizeAsNine() {
    Tuple<Object> tuple = Tuple.large(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12);
    NineTuple<Object, Object, Object, Object, Object, Object, Object, Object, Object, Object>
        other = tuple.asNine();
    assertThat(other.size(), is(9));
    assertThat(other.first(), is(tuple.get(0)));
    assertThat(other.second(), is(tuple.get(1)));
    assertThat(other.third(), is(tuple.get(2)));
    assertThat(other.fourth(), is(tuple.get(3)));
    assertThat(other.fifth(), is(tuple.get(4)));
    assertThat(other.sixth(), is(tuple.get(5)));
    assertThat(other.seventh(), is(tuple.get(6)));
    assertThat(other.eighth(), is(tuple.get(7)));
    assertThat(other.ninth(), is(tuple.get(8)));
  }

  @Test
  public void testResizeAsTen() {
    Tuple<Object> tuple = Tuple.large(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12);
    TenTuple<Object, Object, Object, Object, Object, Object, Object, Object, Object, Object, Object>
        other = tuple.asTen();
    assertThat(other.size(), is(10));
    assertThat(other.first(), is(tuple.get(0)));
    assertThat(other.second(), is(tuple.get(1)));
    assertThat(other.third(), is(tuple.get(2)));
    assertThat(other.fourth(), is(tuple.get(3)));
    assertThat(other.fifth(), is(tuple.get(4)));
    assertThat(other.sixth(), is(tuple.get(5)));
    assertThat(other.seventh(), is(tuple.get(6)));
    assertThat(other.eighth(), is(tuple.get(7)));
    assertThat(other.ninth(), is(tuple.get(8)));
    assertThat(other.tenth(), is(tuple.get(9)));
  }

  @Test
  public void testResizeAsEleven() {
    Tuple<Object> tuple = Tuple.large(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12);
    ElevenTuple<
            Object,
            Object,
            Object,
            Object,
            Object,
            Object,
            Object,
            Object,
            Object,
            Object,
            Object,
            Object>
        other = tuple.asEleven();
    assertThat(other.size(), is(11));
    assertThat(other.first(), is(tuple.get(0)));
    assertThat(other.second(), is(tuple.get(1)));
    assertThat(other.third(), is(tuple.get(2)));
    assertThat(other.fourth(), is(tuple.get(3)));
    assertThat(other.fifth(), is(tuple.get(4)));
    assertThat(other.sixth(), is(tuple.get(5)));
    assertThat(other.seventh(), is(tuple.get(6)));
    assertThat(other.eighth(), is(tuple.get(7)));
    assertThat(other.ninth(), is(tuple.get(8)));
    assertThat(other.tenth(), is(tuple.get(9)));
    assertThat(other.eleventh(), is(tuple.get(10)));
  }

  @Test
  public void testResizeAsTwelve() {
    Tuple<Object> tuple = Tuple.large(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12);
    TwelveTuple<
            Object,
            Object,
            Object,
            Object,
            Object,
            Object,
            Object,
            Object,
            Object,
            Object,
            Object,
            Object,
            Object>
        other = tuple.asTwelve();
    assertThat(other.size(), is(12));
    assertThat(other.first(), is(tuple.get(0)));
    assertThat(other.second(), is(tuple.get(1)));
    assertThat(other.third(), is(tuple.get(2)));
    assertThat(other.fourth(), is(tuple.get(3)));
    assertThat(other.fifth(), is(tuple.get(4)));
    assertThat(other.sixth(), is(tuple.get(5)));
    assertThat(other.seventh(), is(tuple.get(6)));
    assertThat(other.eighth(), is(tuple.get(7)));
    assertThat(other.ninth(), is(tuple.get(8)));
    assertThat(other.tenth(), is(tuple.get(9)));
    assertThat(other.eleventh(), is(tuple.get(10)));
    assertThat(other.twelfth(), is(tuple.get(11)));
  }

  @Test
  public void accessingMembers() {
    ThirteenOrMoreTuple<
            Object,
            Integer,
            Integer,
            Integer,
            Integer,
            Integer,
            Integer,
            Integer,
            Integer,
            Integer,
            Integer,
            Integer,
            Integer>
        tuple = Tuple.large(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12);
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
    ThirteenOrMoreTuple<
            Object,
            Integer,
            Integer,
            Integer,
            Integer,
            Integer,
            Integer,
            Integer,
            Integer,
            Integer,
            Integer,
            Integer,
            Integer>
        tuple = Tuple.large(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12);
    for (int i = 0; i < 13; i++) {
      Tuple<?> other = tuple.change(i, -1);
      assertThat(other, is(notNullValue()));
      assertThat(other.size(), is(13));
      assertThat(other.get(i), is(-1));
    }
  }

  @Test
  public void changingElementByIndexThroughFunction() {
    ThirteenOrMoreTuple<
            Object,
            Integer,
            Integer,
            Integer,
            Integer,
            Integer,
            Integer,
            Integer,
            Integer,
            Integer,
            Integer,
            Integer,
            Integer>
        tuple = Tuple.large(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12);
    for (int i = 0; i < 13; i++) {
      Tuple<?> other = tuple.change(i, t -> -1);
      assertThat(other, is(notNullValue()));
      assertThat(other.size(), is(13));
      assertThat(other.get(i), is(-1));
    }
  }

  @Test
  public void changingElementByIndexThroughSupplier() {
    ThirteenOrMoreTuple<
            Object,
            Integer,
            Integer,
            Integer,
            Integer,
            Integer,
            Integer,
            Integer,
            Integer,
            Integer,
            Integer,
            Integer,
            Integer>
        tuple = Tuple.large(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12);
    for (int i = 0; i < 13; i++) {
      Tuple<?> other = tuple.change(i, () -> -1);
      assertThat(other, is(notNullValue()));
      assertThat(other.size(), is(13));
      assertThat(other.get(i), is(-1));
    }
  }

  @Test
  public void changingFirstElementByAccessor() {
    ThirteenOrMoreTuple<
            Object,
            Integer,
            Integer,
            Integer,
            Integer,
            Integer,
            Integer,
            Integer,
            Integer,
            Integer,
            Integer,
            Integer,
            Integer>
        tuple = Tuple.large(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12);
    Tuple<Object> secondTuple = tuple.first(-1);
    Tuple<Object> thirdTuple = tuple.first(() -> -1);
    Tuple<Object> fourthTuple = tuple.first(previous -> -1);
    assertThat(secondTuple, is(notNullValue()));
    assertThat(secondTuple.size(), is(tuple.size()));
    assertThat(thirdTuple, is(notNullValue()));
    assertThat(thirdTuple.size(), is(tuple.size()));
    assertThat(fourthTuple, is(notNullValue()));
    assertThat(fourthTuple.size(), is(tuple.size()));
    for (int i = 0; i < tuple.size(); i++) {
      if (i == 0) {
        assertThat(secondTuple.get(i), is(-1));
        assertThat(thirdTuple.get(i), is(-1));
        assertThat(fourthTuple.get(i), is(-1));
        continue;
      }
      assertThat(secondTuple.get(i), is(tuple.get(i)));
      assertThat(thirdTuple.get(i), is(tuple.get(i)));
      assertThat(fourthTuple.get(i), is(tuple.get(i)));
    }
  }

  @Test
  public void changingSecondElementByAccessor() {
    ThirteenOrMoreTuple<
            Object,
            Integer,
            Integer,
            Integer,
            Integer,
            Integer,
            Integer,
            Integer,
            Integer,
            Integer,
            Integer,
            Integer,
            Integer>
        tuple = Tuple.large(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12);
    Tuple<Object> secondTuple = tuple.second(-1);
    Tuple<Object> thirdTuple = tuple.second(() -> -1);
    Tuple<Object> fourthTuple = tuple.second(previous -> -1);
    assertThat(secondTuple, is(notNullValue()));
    assertThat(secondTuple.size(), is(tuple.size()));
    assertThat(thirdTuple, is(notNullValue()));
    assertThat(thirdTuple.size(), is(tuple.size()));
    assertThat(fourthTuple, is(notNullValue()));
    assertThat(fourthTuple.size(), is(tuple.size()));
    for (int i = 0; i < tuple.size(); i++) {
      if (i == 1) {
        assertThat(secondTuple.get(i), is(-1));
        assertThat(thirdTuple.get(i), is(-1));
        assertThat(fourthTuple.get(i), is(-1));
        continue;
      }
      assertThat(secondTuple.get(i), is(tuple.get(i)));
      assertThat(thirdTuple.get(i), is(tuple.get(i)));
      assertThat(fourthTuple.get(i), is(tuple.get(i)));
    }
  }

  @Test
  public void changingThirdElementByAccessor() {
    ThirteenOrMoreTuple<
            Object,
            Integer,
            Integer,
            Integer,
            Integer,
            Integer,
            Integer,
            Integer,
            Integer,
            Integer,
            Integer,
            Integer,
            Integer>
        tuple = Tuple.large(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12);
    Tuple<Object> secondTuple = tuple.third(-1);
    Tuple<Object> thirdTuple = tuple.third(() -> -1);
    Tuple<Object> fourthTuple = tuple.third(previous -> -1);
    assertThat(secondTuple, is(notNullValue()));
    assertThat(secondTuple.size(), is(tuple.size()));
    assertThat(thirdTuple, is(notNullValue()));
    assertThat(thirdTuple.size(), is(tuple.size()));
    assertThat(fourthTuple, is(notNullValue()));
    assertThat(fourthTuple.size(), is(tuple.size()));
    for (int i = 0; i < tuple.size(); i++) {
      if (i == 2) {
        assertThat(secondTuple.get(i), is(-1));
        assertThat(thirdTuple.get(i), is(-1));
        assertThat(fourthTuple.get(i), is(-1));
        continue;
      }
      assertThat(secondTuple.get(i), is(tuple.get(i)));
      assertThat(thirdTuple.get(i), is(tuple.get(i)));
      assertThat(fourthTuple.get(i), is(tuple.get(i)));
    }
  }

  @Test
  public void changingFourthElementByAccessor() {
    ThirteenOrMoreTuple<
            Object,
            Integer,
            Integer,
            Integer,
            Integer,
            Integer,
            Integer,
            Integer,
            Integer,
            Integer,
            Integer,
            Integer,
            Integer>
        tuple = Tuple.large(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12);
    Tuple<Object> secondTuple = tuple.fourth(-1);
    Tuple<Object> thirdTuple = tuple.fourth(() -> -1);
    Tuple<Object> fourthTuple = tuple.fourth(previous -> -1);
    assertThat(secondTuple, is(notNullValue()));
    assertThat(secondTuple.size(), is(tuple.size()));
    assertThat(thirdTuple, is(notNullValue()));
    assertThat(thirdTuple.size(), is(tuple.size()));
    assertThat(fourthTuple, is(notNullValue()));
    assertThat(fourthTuple.size(), is(tuple.size()));
    for (int i = 0; i < tuple.size(); i++) {
      if (i == 3) {
        assertThat(secondTuple.get(i), is(-1));
        assertThat(thirdTuple.get(i), is(-1));
        assertThat(fourthTuple.get(i), is(-1));
        continue;
      }
      assertThat(secondTuple.get(i), is(tuple.get(i)));
      assertThat(thirdTuple.get(i), is(tuple.get(i)));
      assertThat(fourthTuple.get(i), is(tuple.get(i)));
    }
  }

  @Test
  public void changingFifthElementByAccessor() {
    ThirteenOrMoreTuple<
            Object,
            Integer,
            Integer,
            Integer,
            Integer,
            Integer,
            Integer,
            Integer,
            Integer,
            Integer,
            Integer,
            Integer,
            Integer>
        tuple = Tuple.large(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12);
    Tuple<Object> secondTuple = tuple.fifth(-1);
    Tuple<Object> thirdTuple = tuple.fifth(() -> -1);
    Tuple<Object> fourthTuple = tuple.fifth(previous -> -1);
    assertThat(secondTuple, is(notNullValue()));
    assertThat(secondTuple.size(), is(tuple.size()));
    assertThat(thirdTuple, is(notNullValue()));
    assertThat(thirdTuple.size(), is(tuple.size()));
    assertThat(fourthTuple, is(notNullValue()));
    assertThat(fourthTuple.size(), is(tuple.size()));
    for (int i = 0; i < tuple.size(); i++) {
      if (i == 4) {
        assertThat(secondTuple.get(i), is(-1));
        assertThat(thirdTuple.get(i), is(-1));
        assertThat(fourthTuple.get(i), is(-1));
        continue;
      }
      assertThat(secondTuple.get(i), is(tuple.get(i)));
      assertThat(thirdTuple.get(i), is(tuple.get(i)));
      assertThat(fourthTuple.get(i), is(tuple.get(i)));
    }
  }

  @Test
  public void changingSixthElementByAccessor() {
    ThirteenOrMoreTuple<
            Object,
            Integer,
            Integer,
            Integer,
            Integer,
            Integer,
            Integer,
            Integer,
            Integer,
            Integer,
            Integer,
            Integer,
            Integer>
        tuple = Tuple.large(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12);
    Tuple<Object> secondTuple = tuple.sixth(-1);
    Tuple<Object> thirdTuple = tuple.sixth(() -> -1);
    Tuple<Object> fourthTuple = tuple.sixth(previous -> -1);
    assertThat(secondTuple, is(notNullValue()));
    assertThat(secondTuple.size(), is(tuple.size()));
    assertThat(thirdTuple, is(notNullValue()));
    assertThat(thirdTuple.size(), is(tuple.size()));
    assertThat(fourthTuple, is(notNullValue()));
    assertThat(fourthTuple.size(), is(tuple.size()));
    for (int i = 0; i < tuple.size(); i++) {
      if (i == 5) {
        assertThat(secondTuple.get(i), is(-1));
        assertThat(thirdTuple.get(i), is(-1));
        assertThat(fourthTuple.get(i), is(-1));
        continue;
      }
      assertThat(secondTuple.get(i), is(tuple.get(i)));
      assertThat(thirdTuple.get(i), is(tuple.get(i)));
      assertThat(fourthTuple.get(i), is(tuple.get(i)));
    }
  }

  @Test
  public void changingSeventhElementByAccessor() {
    ThirteenOrMoreTuple<
            Object,
            Integer,
            Integer,
            Integer,
            Integer,
            Integer,
            Integer,
            Integer,
            Integer,
            Integer,
            Integer,
            Integer,
            Integer>
        tuple = Tuple.large(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12);
    Tuple<Object> secondTuple = tuple.seventh(-1);
    Tuple<Object> thirdTuple = tuple.seventh(() -> -1);
    Tuple<Object> fourthTuple = tuple.seventh(previous -> -1);
    assertThat(secondTuple, is(notNullValue()));
    assertThat(secondTuple.size(), is(tuple.size()));
    assertThat(thirdTuple, is(notNullValue()));
    assertThat(thirdTuple.size(), is(tuple.size()));
    assertThat(fourthTuple, is(notNullValue()));
    assertThat(fourthTuple.size(), is(tuple.size()));
    for (int i = 0; i < tuple.size(); i++) {
      if (i == 6) {
        assertThat(secondTuple.get(i), is(-1));
        assertThat(thirdTuple.get(i), is(-1));
        assertThat(fourthTuple.get(i), is(-1));
        continue;
      }
      assertThat(secondTuple.get(i), is(tuple.get(i)));
      assertThat(thirdTuple.get(i), is(tuple.get(i)));
      assertThat(fourthTuple.get(i), is(tuple.get(i)));
    }
  }

  @Test
  public void changingEighthElementByAccessor() {
    ThirteenOrMoreTuple<
            Object,
            Integer,
            Integer,
            Integer,
            Integer,
            Integer,
            Integer,
            Integer,
            Integer,
            Integer,
            Integer,
            Integer,
            Integer>
        tuple = Tuple.large(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12);
    Tuple<Object> secondTuple = tuple.eighth(-1);
    Tuple<Object> thirdTuple = tuple.eighth(() -> -1);
    Tuple<Object> fourthTuple = tuple.eighth(previous -> -1);
    assertThat(secondTuple, is(notNullValue()));
    assertThat(secondTuple.size(), is(tuple.size()));
    assertThat(thirdTuple, is(notNullValue()));
    assertThat(thirdTuple.size(), is(tuple.size()));
    assertThat(fourthTuple, is(notNullValue()));
    assertThat(fourthTuple.size(), is(tuple.size()));
    for (int i = 0; i < tuple.size(); i++) {
      if (i == 7) {
        assertThat(secondTuple.get(i), is(-1));
        assertThat(thirdTuple.get(i), is(-1));
        assertThat(fourthTuple.get(i), is(-1));
        continue;
      }
      assertThat(secondTuple.get(i), is(tuple.get(i)));
      assertThat(thirdTuple.get(i), is(tuple.get(i)));
      assertThat(fourthTuple.get(i), is(tuple.get(i)));
    }
  }

  @Test
  public void changingNinthElementByAccessor() {
    ThirteenOrMoreTuple<
            Object,
            Integer,
            Integer,
            Integer,
            Integer,
            Integer,
            Integer,
            Integer,
            Integer,
            Integer,
            Integer,
            Integer,
            Integer>
        tuple = Tuple.large(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12);
    Tuple<Object> secondTuple = tuple.ninth(-1);
    Tuple<Object> thirdTuple = tuple.ninth(() -> -1);
    Tuple<Object> fourthTuple = tuple.ninth(previous -> -1);
    assertThat(secondTuple, is(notNullValue()));
    assertThat(secondTuple.size(), is(tuple.size()));
    assertThat(thirdTuple, is(notNullValue()));
    assertThat(thirdTuple.size(), is(tuple.size()));
    assertThat(fourthTuple, is(notNullValue()));
    assertThat(fourthTuple.size(), is(tuple.size()));
    for (int i = 0; i < tuple.size(); i++) {
      if (i == 8) {
        assertThat(secondTuple.get(i), is(-1));
        assertThat(thirdTuple.get(i), is(-1));
        assertThat(fourthTuple.get(i), is(-1));
        continue;
      }
      assertThat(secondTuple.get(i), is(tuple.get(i)));
      assertThat(thirdTuple.get(i), is(tuple.get(i)));
      assertThat(fourthTuple.get(i), is(tuple.get(i)));
    }
  }

  @Test
  public void changingTenthElementByAccessor() {
    ThirteenOrMoreTuple<
            Object,
            Integer,
            Integer,
            Integer,
            Integer,
            Integer,
            Integer,
            Integer,
            Integer,
            Integer,
            Integer,
            Integer,
            Integer>
        tuple = Tuple.large(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12);
    Tuple<Object> secondTuple = tuple.tenth(-1);
    Tuple<Object> thirdTuple = tuple.tenth(() -> -1);
    Tuple<Object> fourthTuple = tuple.tenth(previous -> -1);
    assertThat(secondTuple, is(notNullValue()));
    assertThat(secondTuple.size(), is(tuple.size()));
    assertThat(thirdTuple, is(notNullValue()));
    assertThat(thirdTuple.size(), is(tuple.size()));
    assertThat(fourthTuple, is(notNullValue()));
    assertThat(fourthTuple.size(), is(tuple.size()));
    for (int i = 0; i < tuple.size(); i++) {
      if (i == 9) {
        assertThat(secondTuple.get(i), is(-1));
        assertThat(thirdTuple.get(i), is(-1));
        assertThat(fourthTuple.get(i), is(-1));
        continue;
      }
      assertThat(secondTuple.get(i), is(tuple.get(i)));
      assertThat(thirdTuple.get(i), is(tuple.get(i)));
      assertThat(fourthTuple.get(i), is(tuple.get(i)));
    }
  }

  @Test
  public void changingEleventhElementByAccessor() {
    ThirteenOrMoreTuple<
            Object,
            Integer,
            Integer,
            Integer,
            Integer,
            Integer,
            Integer,
            Integer,
            Integer,
            Integer,
            Integer,
            Integer,
            Integer>
        tuple = Tuple.large(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12);
    Tuple<Object> secondTuple = tuple.eleventh(-1);
    Tuple<Object> thirdTuple = tuple.eleventh(() -> -1);
    Tuple<Object> fourthTuple = tuple.eleventh(previous -> -1);
    assertThat(secondTuple, is(notNullValue()));
    assertThat(secondTuple.size(), is(tuple.size()));
    assertThat(thirdTuple, is(notNullValue()));
    assertThat(thirdTuple.size(), is(tuple.size()));
    assertThat(fourthTuple, is(notNullValue()));
    assertThat(fourthTuple.size(), is(tuple.size()));
    for (int i = 0; i < tuple.size(); i++) {
      if (i == 10) {
        assertThat(secondTuple.get(i), is(-1));
        assertThat(thirdTuple.get(i), is(-1));
        assertThat(fourthTuple.get(i), is(-1));
        continue;
      }
      assertThat(secondTuple.get(i), is(tuple.get(i)));
      assertThat(thirdTuple.get(i), is(tuple.get(i)));
      assertThat(fourthTuple.get(i), is(tuple.get(i)));
    }
  }

  @Test
  public void changingTwelfthElementByAccessor() {
    ThirteenOrMoreTuple<
            Object,
            Integer,
            Integer,
            Integer,
            Integer,
            Integer,
            Integer,
            Integer,
            Integer,
            Integer,
            Integer,
            Integer,
            Integer>
        tuple = Tuple.large(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12);
    Tuple<Object> secondTuple = tuple.twelfth(-1);
    Tuple<Object> thirdTuple = tuple.twelfth(() -> -1);
    Tuple<Object> fourthTuple = tuple.twelfth(previous -> -1);
    assertThat(secondTuple, is(notNullValue()));
    assertThat(secondTuple.size(), is(tuple.size()));
    assertThat(thirdTuple, is(notNullValue()));
    assertThat(thirdTuple.size(), is(tuple.size()));
    assertThat(fourthTuple, is(notNullValue()));
    assertThat(fourthTuple.size(), is(tuple.size()));
    for (int i = 0; i < tuple.size(); i++) {
      if (i == 11) {
        assertThat(secondTuple.get(i), is(-1));
        assertThat(thirdTuple.get(i), is(-1));
        assertThat(fourthTuple.get(i), is(-1));
        continue;
      }
      assertThat(secondTuple.get(i), is(tuple.get(i)));
      assertThat(thirdTuple.get(i), is(tuple.get(i)));
      assertThat(fourthTuple.get(i), is(tuple.get(i)));
    }
  }

  @Test
  public void droppingByIndex() {
    ThirteenOrMoreTuple<
            Object,
            Integer,
            Integer,
            Integer,
            Integer,
            Integer,
            Integer,
            Integer,
            Integer,
            Integer,
            Integer,
            Integer,
            Integer>
        tuple = Tuple.large(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12);
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
  public void testDroppingFirst() {
    ThirteenOrMoreTuple<
            Object,
            Integer,
            Integer,
            Integer,
            Integer,
            Integer,
            Integer,
            Integer,
            Integer,
            Integer,
            Integer,
            Integer,
            Integer>
        tuple = Tuple.large(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12);
    Tuple<Object> other = tuple.dropFirst();
    assertThat(other.size(), is(12));
    for (int i = 0; i < other.size(); i++) {
      assertThat(other.get(i), is(tuple.get(i + 1)));
    }
  }

  @Test
  public void testDroppingSecond() {
    ThirteenOrMoreTuple<
            Object,
            Integer,
            Integer,
            Integer,
            Integer,
            Integer,
            Integer,
            Integer,
            Integer,
            Integer,
            Integer,
            Integer,
            Integer>
        tuple = Tuple.large(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12);
    Tuple<Object> other = tuple.dropSecond();
    assertThat(other.size(), is(12));
    for (int i = 0; i < other.size(); i++) {
      if (i < 1) {
        assertThat(other.get(i), is(tuple.get(i)));
      } else {
        assertThat(other.get(i), is(tuple.get(i + 1)));
      }
    }
  }

  @Test
  public void testDroppingThird() {
    ThirteenOrMoreTuple<
            Object,
            Integer,
            Integer,
            Integer,
            Integer,
            Integer,
            Integer,
            Integer,
            Integer,
            Integer,
            Integer,
            Integer,
            Integer>
        tuple = Tuple.large(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12);
    Tuple<Object> other = tuple.dropThird();
    assertThat(other.size(), is(12));
    for (int i = 0; i < other.size(); i++) {
      if (i < 2) {
        assertThat(other.get(i), is(tuple.get(i)));
      } else {
        assertThat(other.get(i), is(tuple.get(i + 1)));
      }
    }
  }

  @Test
  public void testDroppingFourth() {
    ThirteenOrMoreTuple<
            Object,
            Integer,
            Integer,
            Integer,
            Integer,
            Integer,
            Integer,
            Integer,
            Integer,
            Integer,
            Integer,
            Integer,
            Integer>
        tuple = Tuple.large(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12);
    Tuple<Object> other = tuple.dropFourth();
    assertThat(other.size(), is(12));
    for (int i = 0; i < other.size(); i++) {
      if (i < 3) {
        assertThat(other.get(i), is(tuple.get(i)));
      } else {
        assertThat(other.get(i), is(tuple.get(i + 1)));
      }
    }
  }

  @Test
  public void testDroppingFifth() {
    ThirteenOrMoreTuple<
            Object,
            Integer,
            Integer,
            Integer,
            Integer,
            Integer,
            Integer,
            Integer,
            Integer,
            Integer,
            Integer,
            Integer,
            Integer>
        tuple = Tuple.large(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12);
    Tuple<Object> other = tuple.dropFifth();
    assertThat(other.size(), is(12));
    for (int i = 0; i < other.size(); i++) {
      if (i < 4) {
        assertThat(other.get(i), is(tuple.get(i)));
      } else {
        assertThat(other.get(i), is(tuple.get(i + 1)));
      }
    }
  }

  @Test
  public void testDroppingSixth() {
    ThirteenOrMoreTuple<
            Object,
            Integer,
            Integer,
            Integer,
            Integer,
            Integer,
            Integer,
            Integer,
            Integer,
            Integer,
            Integer,
            Integer,
            Integer>
        tuple = Tuple.large(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12);
    Tuple<Object> other = tuple.dropSixth();
    assertThat(other.size(), is(12));
    for (int i = 0; i < other.size(); i++) {
      if (i < 5) {
        assertThat(other.get(i), is(tuple.get(i)));
      } else {
        assertThat(other.get(i), is(tuple.get(i + 1)));
      }
    }
  }

  @Test
  public void testDroppingSeventh() {
    ThirteenOrMoreTuple<
            Object,
            Integer,
            Integer,
            Integer,
            Integer,
            Integer,
            Integer,
            Integer,
            Integer,
            Integer,
            Integer,
            Integer,
            Integer>
        tuple = Tuple.large(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12);
    Tuple<Object> other = tuple.dropSeventh();
    assertThat(other.size(), is(12));
    for (int i = 0; i < other.size(); i++) {
      if (i < 6) {
        assertThat(other.get(i), is(tuple.get(i)));
      } else {
        assertThat(other.get(i), is(tuple.get(i + 1)));
      }
    }
  }

  @Test
  public void testDroppingEighth() {
    ThirteenOrMoreTuple<
            Object,
            Integer,
            Integer,
            Integer,
            Integer,
            Integer,
            Integer,
            Integer,
            Integer,
            Integer,
            Integer,
            Integer,
            Integer>
        tuple = Tuple.large(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12);
    Tuple<Object> other = tuple.dropEighth();
    assertThat(other.size(), is(12));
    for (int i = 0; i < other.size(); i++) {
      if (i < 7) {
        assertThat(other.get(i), is(tuple.get(i)));
      } else {
        assertThat(other.get(i), is(tuple.get(i + 1)));
      }
    }
  }

  @Test
  public void testDroppingNinth() {
    ThirteenOrMoreTuple<
            Object,
            Integer,
            Integer,
            Integer,
            Integer,
            Integer,
            Integer,
            Integer,
            Integer,
            Integer,
            Integer,
            Integer,
            Integer>
        tuple = Tuple.large(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12);
    Tuple<Object> other = tuple.dropNinth();
    assertThat(other.size(), is(12));
    for (int i = 0; i < other.size(); i++) {
      if (i < 8) {
        assertThat(other.get(i), is(tuple.get(i)));
      } else {
        assertThat(other.get(i), is(tuple.get(i + 1)));
      }
    }
  }

  @Test
  public void testDroppingTenth() {
    ThirteenOrMoreTuple<
            Object,
            Integer,
            Integer,
            Integer,
            Integer,
            Integer,
            Integer,
            Integer,
            Integer,
            Integer,
            Integer,
            Integer,
            Integer>
        tuple = Tuple.large(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12);
    Tuple<Object> other = tuple.dropTenth();
    assertThat(other.size(), is(12));
    for (int i = 0; i < other.size(); i++) {
      if (i < 9) {
        assertThat(other.get(i), is(tuple.get(i)));
      } else {
        assertThat(other.get(i), is(tuple.get(i + 1)));
      }
    }
  }

  @Test
  public void testDroppingEleventh() {
    ThirteenOrMoreTuple<
            Object,
            Integer,
            Integer,
            Integer,
            Integer,
            Integer,
            Integer,
            Integer,
            Integer,
            Integer,
            Integer,
            Integer,
            Integer>
        tuple = Tuple.large(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12);
    Tuple<Object> other = tuple.dropEleventh();
    assertThat(other.size(), is(12));
    for (int i = 0; i < other.size(); i++) {
      if (i < 10) {
        assertThat(other.get(i), is(tuple.get(i)));
      } else {
        assertThat(other.get(i), is(tuple.get(i + 1)));
      }
    }
  }

  @Test
  public void testDroppingTwelfth() {
    ThirteenOrMoreTuple<
            Object,
            Integer,
            Integer,
            Integer,
            Integer,
            Integer,
            Integer,
            Integer,
            Integer,
            Integer,
            Integer,
            Integer,
            Integer>
        tuple = Tuple.large(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12);
    Tuple<Object> other = tuple.dropTwelfth();
    assertThat(other.size(), is(12));
    for (int i = 0; i < other.size(); i++) {
      if (i < 11) {
        assertThat(other.get(i), is(tuple.get(i)));
      } else {
        assertThat(other.get(i), is(tuple.get(i + 1)));
      }
    }
  }

  @Test
  public void clearingTuple() {
    ThirteenOrMoreTuple<
            Object,
            Integer,
            Integer,
            Integer,
            Integer,
            Integer,
            Integer,
            Integer,
            Integer,
            Integer,
            Integer,
            Integer,
            Integer>
        tuple = Tuple.large(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12);
    Tuple<?> other = tuple.clear();
    assertThat(other, is(notNullValue()));
    assertThat(other.size(), is(0));
  }

  @Test
  public void streamingTuple() {
    ThirteenOrMoreTuple<
            Object,
            Integer,
            Integer,
            Integer,
            Integer,
            Integer,
            Integer,
            Integer,
            Integer,
            Integer,
            Integer,
            Integer,
            Integer>
        tuple = Tuple.large(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12);
    List<Object> items = tuple.stream().collect(toList());
    assertThat(items, is(hasSize(13)));
    assertThat(items, is(contains(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12)));
  }

  @Test
  public void gettingTupleAsList() {
    ThirteenOrMoreTuple<
            Object,
            Integer,
            Integer,
            Integer,
            Integer,
            Integer,
            Integer,
            Integer,
            Integer,
            Integer,
            Integer,
            Integer,
            Integer>
        tuple = Tuple.large(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12);
    List<Object> items = tuple.asList();
    assertThat(items, is(hasSize(13)));
    assertThat(items, is(contains(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12)));
  }

  @Test
  public void checkingPredicateByIndex() {
    ThirteenOrMoreTuple<
            Integer,
            Integer,
            Integer,
            Integer,
            Integer,
            Integer,
            Integer,
            Integer,
            Integer,
            Integer,
            Integer,
            Integer,
            Integer>
        tuple = ThirteenOrMoreTuple.of(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12);
    for (int i = 0; i < 13; i++) {
      assertThat(tuple.check(i, x -> x % 2 == 0), is(i % 2 == 0));
    }
  }

  @Test
  public void checkingPredicateByAccessor() {
    ThirteenOrMoreTuple<
            Integer,
            Integer,
            Integer,
            Integer,
            Integer,
            Integer,
            Integer,
            Integer,
            Integer,
            Integer,
            Integer,
            Integer,
            Integer>
        tuple = ThirteenOrMoreTuple.of(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12);
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
    ThirteenOrMoreTuple<
            Integer,
            Integer,
            Integer,
            Integer,
            Integer,
            Integer,
            Integer,
            Integer,
            Integer,
            Integer,
            Integer,
            Integer,
            Integer>
        tuple = ThirteenOrMoreTuple.of(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12);
    ThirteenOrMoreTuple<
            Integer,
            Integer,
            Integer,
            Integer,
            Integer,
            Integer,
            Integer,
            Integer,
            Integer,
            Integer,
            Integer,
            Integer,
            Integer>
        secondTuple = ThirteenOrMoreTuple.extendWith(-1).apply(tuple);
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
    ThirteenOrMoreTuple<
            Integer,
            Integer,
            Integer,
            Integer,
            Integer,
            Integer,
            Integer,
            Integer,
            Integer,
            Integer,
            Integer,
            Integer,
            Integer>
        tuple = ThirteenOrMoreTuple.of(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12);
    ThirteenOrMoreTuple<
            Integer,
            Integer,
            Integer,
            Integer,
            Integer,
            Integer,
            Integer,
            Integer,
            Integer,
            Integer,
            Integer,
            Integer,
            Integer>
        secondTuple = ThirteenOrMoreTuple.extendWith(() -> -1).apply(tuple);
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
    ThirteenOrMoreTuple<
            Integer,
            Integer,
            Integer,
            Integer,
            Integer,
            Integer,
            Integer,
            Integer,
            Integer,
            Integer,
            Integer,
            Integer,
            Integer>
        tuple = ThirteenOrMoreTuple.of(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12);
    ThirteenOrMoreTuple<
            Integer,
            Integer,
            Integer,
            Integer,
            Integer,
            Integer,
            Integer,
            Integer,
            Integer,
            Integer,
            Integer,
            Integer,
            Integer>
        secondTuple =
            ThirteenOrMoreTuple.extendWith(
                    (ThirteenOrMoreTuple<
                                Integer,
                                Integer,
                                Integer,
                                Integer,
                                Integer,
                                Integer,
                                Integer,
                                Integer,
                                Integer,
                                Integer,
                                Integer,
                                Integer,
                                Integer>
                            t) -> -1)
                .apply(tuple);
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
    ThirteenOrMoreTuple<
            Integer,
            Integer,
            Integer,
            Integer,
            Integer,
            Integer,
            Integer,
            Integer,
            Integer,
            Integer,
            Integer,
            Integer,
            Integer>
        tuple = ThirteenOrMoreTuple.of(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12);
    LabeledTuple<Integer> other =
        tuple.withLabels(
            "e0", "e1", "e2", "e3", "e4", "e5", "e6", "e7", "e8", "e9", "e10", "e11", "e12");
    assertThat(other, is(notNullValue()));
    assertThat(other.size(), is(13));
    assertThat(
        other.labels(),
        is(
            contains(
                "e0", "e1", "e2", "e3", "e4", "e5", "e6", "e7", "e8", "e9", "e10", "e11", "e12")));
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
    ThirteenOrMoreTuple<
            Object,
            Integer,
            Integer,
            Integer,
            Integer,
            Integer,
            Integer,
            Integer,
            Integer,
            Integer,
            Integer,
            Integer,
            Integer>
        tuple = Tuple.large(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12);
    ThirteenOrMoreTuple<
            Object,
            Integer,
            Integer,
            Integer,
            Integer,
            Integer,
            Integer,
            Integer,
            Integer,
            Integer,
            Integer,
            Integer,
            Integer>
        secondTuple = Tuple.large(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12);
    assertThat(tuple, is(secondTuple));
  }

  @Test
  public void hashCodeCalculation() {
    ThirteenOrMoreTuple<
            Object,
            Integer,
            Integer,
            Integer,
            Integer,
            Integer,
            Integer,
            Integer,
            Integer,
            Integer,
            Integer,
            Integer,
            Integer>
        tuple = Tuple.large(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12);
    ThirteenOrMoreTuple<
            Object,
            Integer,
            Integer,
            Integer,
            Integer,
            Integer,
            Integer,
            Integer,
            Integer,
            Integer,
            Integer,
            Integer,
            Integer>
        secondTuple = Tuple.large(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12);
    assertThat(tuple.hashCode(), is(secondTuple.hashCode()));
  }

  @Test
  public void toStringCalculation() {
    ThirteenOrMoreTuple<
            Object,
            Integer,
            Integer,
            Integer,
            Integer,
            Integer,
            Integer,
            Integer,
            Integer,
            Integer,
            Integer,
            Integer,
            Integer>
        tuple = Tuple.large(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12);
    ThirteenOrMoreTuple<
            Object,
            Integer,
            Integer,
            Integer,
            Integer,
            Integer,
            Integer,
            Integer,
            Integer,
            Integer,
            Integer,
            Integer,
            Integer>
        secondTuple = Tuple.large(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12);
    assertThat(tuple.toString(), is(secondTuple.toString()));
  }
}

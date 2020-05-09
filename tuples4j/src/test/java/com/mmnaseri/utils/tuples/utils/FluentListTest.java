package com.mmnaseri.utils.tuples.utils;

import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.empty;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;

public class FluentListTest {

    @Test
    public void testCreatingEmptyList() {
        assertThat(FluentList.empty(), is(empty()));
    }

    @Test
    public void testAddOneItemToTheList() {
        FluentList<Integer> first = FluentList.of(1, 2, 3);
        assertThat(first, is(notNullValue()));
        assertThat(first, contains(1, 2, 3));
        FluentList<Integer> second = first.with(4);
        assertThat(first, hasSize(3));
        assertThat(second, hasSize(4));
        assertThat(second, contains(1, 2, 3, 4));
    }

    @Test
    public void testAddMultipleItemsToTheList() {
        FluentList<Integer> first = FluentList.of(1, 2, 3);
        assertThat(first, is(notNullValue()));
        assertThat(first, contains(1, 2, 3));
        FluentList<Integer> second = first.with(4, 5, 6);
        assertThat(first, hasSize(3));
        assertThat(second, hasSize(6));
        assertThat(second, contains(1, 2, 3, 4, 5, 6));
    }

    @Test
    public void testRemovingItemByValueFromList() {
        FluentList<Integer> list = FluentList.of(1, 2, 3, 4);
        FluentList<Integer> other = list.without((Integer) 3);
        assertThat(list, contains(1, 2, 3, 4));
        assertThat(other, contains(1, 2, 4));
    }

    @Test
    public void testRemovingItemByIndexFromList() {
        FluentList<Integer> list = FluentList.of(1, 2, 3, 4);
        FluentList<Integer> other = list.without(3);
        assertThat(list, contains(1, 2, 3, 4));
        assertThat(other, contains(1, 2, 3));
    }

    @Test
    public void testChangingItem() {
        FluentList<Integer> list = FluentList.of(1, 2, 3, 4);
        FluentList<Integer> other = list.change(0, 5);
        assertThat(list, contains(1, 2, 3, 4));
        assertThat(other, contains(5, 2, 3, 4));
    }
}
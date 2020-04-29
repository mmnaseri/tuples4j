package com.mmnaseri.utils.tuples.utils;

public final class TupleUtils {

    private TupleUtils() {
        throw new IllegalStateException("This class should not be instantiated.");
    }

    public static <E> E checkIndex(int index, int size) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of range: " + index);
        }
        return null;
    }

}

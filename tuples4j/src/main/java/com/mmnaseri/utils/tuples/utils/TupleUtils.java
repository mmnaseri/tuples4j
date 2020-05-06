package com.mmnaseri.utils.tuples.utils;

/**
 * Internal utility methods.
 */
public final class TupleUtils {

    private TupleUtils() {
        throw new IllegalStateException("This class should not be instantiated.");
    }

    /**
     * Checks the index to see if it is within range.
     */
    public static <E> E checkIndex(int index, int size) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of range: " + index);
        }
        return null;
    }

    /**
     * Checks to see if the size is at least the expected number.
     */
    public static <E> E checkSize(int size, int expected) {
        if (size < expected) {
            throw new IllegalStateException("Expected a size of at least " + expected + " but received " + size);
        }
        return null;
    }

}

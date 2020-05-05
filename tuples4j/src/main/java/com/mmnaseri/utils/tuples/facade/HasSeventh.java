package com.mmnaseri.utils.tuples.facade;

import com.mmnaseri.utils.tuples.FixedTuple;
import com.mmnaseri.utils.tuples.Tuple;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * Defines methods that work with the seventh element of a {@link FixedTuple}.
 * 
 * @param <Z> the super-type of the tuple's main data type.
 * @param <A> the type of the object at the seventh position.
 * @param <T> the concrete type of the fixed-size tuple.
 * 
 * @author Milad Naseri (m.m.naseri@gmail.com)
 */
public interface HasSeventh<Z, A extends Z, T extends HasSeventh<Z, A, T>>
	extends 
	FixedTuple<Z, T> {
	
	/**
	 * Returns the seventh element in the current tuple.
	 */
	@SuppressWarnings("unchecked")
	default A seventh() {
		return (A) get(6);
	}
	
	/**
	 * Sets the seventh element of the tuple to the indicated value.
	 */
	<X extends Z> Tuple<Z> seventh(X value);
	
	/**
	 * Sets the seventh element of the tuple to the supplied value.
	 */
	<X extends Z> Tuple<Z> seventh(Supplier<X> supplier);
	
	/**
	 * Sets the seventh element of the tuple to the value returned from the function.
	 */
	<X extends Z> Tuple<Z> seventh(Function<A, X> function);
	
	/**
	 * Drops the seventh element of the tuple, to return a tuple of one size smaller.
	 */
	Tuple <Z> dropSeventh();
	
	/**
	 * Checks to see if the seventh element of this tuple matches the given predicate.
	 */
	default boolean checkSeventh(Predicate<A> predicate) {
		return predicate.test(seventh());
	}
	
	
}


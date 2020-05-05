package com.mmnaseri.utils.tuples.facade;

import com.mmnaseri.utils.tuples.FixedTuple;
import com.mmnaseri.utils.tuples.Tuple;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * Defines methods that work with the fifth element of a {@link FixedTuple}.
 * 
 * @param <Z> the super-type of the tuple's main data type.
 * @param <A> the type of the object at the fifth position.
 * @param <T> the concrete type of the fixed-size tuple.
 * 
 * @author Milad Naseri (m.m.naseri@gmail.com)
 */
public interface HasFifth<Z, A extends Z, T extends HasFifth<Z, A, T>>
	extends 
	FixedTuple<Z, T> {
	
	/**
	 * Returns the fifth element in the current tuple.
	 */
	@SuppressWarnings("unchecked")
	default A fifth() {
		return (A) get(4);
	}
	
	/**
	 * Sets the fifth element of the tuple to the indicated value.
	 */
	<X extends Z> Tuple<Z> fifth(X value);
	
	/**
	 * Sets the fifth element of the tuple to the supplied value.
	 */
	<X extends Z> Tuple<Z> fifth(Supplier<X> supplier);
	
	/**
	 * Sets the fifth element of the tuple to the value returned from the function.
	 */
	<X extends Z> Tuple<Z> fifth(Function<A, X> function);
	
	/**
	 * Drops the fifth element of the tuple, to return a tuple of one size smaller.
	 */
	Tuple <Z> dropFifth();
	
	/**
	 * Checks to see if the fifth element of this tuple matches the given predicate.
	 */
	default boolean checkFifth(Predicate<A> predicate) {
		return predicate.test(fifth());
	}
	
	
}


package com.mmnaseri.utils.tuples.facade;

import com.mmnaseri.utils.tuples.FixedTuple;
import com.mmnaseri.utils.tuples.Tuple;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * Defines methods that work with the twelfth element of a {@link FixedTuple}.
 * 
 * @param <Z> the super-type of the tuple's main data type.
 * @param <A> the type of the object at the twelfth position.
 * @param <T> the concrete type of the fixed-size tuple.
 * 
 * @author Milad Naseri (m.m.naseri@gmail.com)
 */
public interface HasTwelfth<Z, A extends Z, T extends HasTwelfth<Z, A, T>>
	extends 
	FixedTuple<Z, T> {
	
	/**
	 * Returns the twelfth element in the current tuple.
	 */
	@SuppressWarnings("unchecked")
	default A twelfth() {
		return (A) get(11);
	}
	
	/**
	 * Sets the twelfth element of the tuple to the indicated value.
	 */
	<X extends Z> Tuple<Z> twelfth(X value);
	
	/**
	 * Sets the twelfth element of the tuple to the supplied value.
	 */
	<X extends Z> Tuple<Z> twelfth(Supplier<X> supplier);
	
	/**
	 * Sets the twelfth element of the tuple to the value returned from the function.
	 */
	<X extends Z> Tuple<Z> twelfth(Function<A, X> function);
	
	/**
	 * Drops the twelfth element of the tuple, to return a tuple of one size smaller.
	 */
	Tuple <Z> dropTwelfth();
	
	/**
	 * Checks to see if the twelfth element of this tuple matches the given predicate.
	 */
	default boolean checkTwelfth(Predicate<A> predicate) {
		return predicate.test(twelfth());
	}
	
	
}


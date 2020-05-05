package com.mmnaseri.utils.tuples.impl;

import com.mmnaseri.utils.tuples.facade.*;
import java.util.function.Function;
import java.util.function.Supplier;
import static com.mmnaseri.utils.tuples.utils.TupleUtils.checkIndex;

public class OneTuple<Z, A extends Z> extends AbstractFixedTuple<Z, OneTuple<Z, A>>
	implements 
	HasFirst<Z, A, OneTuple<Z, A>> {
	
	public OneTuple(A first) {
		super(first);
	}
	
	@Override
	public OneTuple<Z, Z> change(int index, Supplier<? extends Z> supplier) {
		checkIndex(index, size());
		return new OneTuple<>(index == 0 ? supplier.get() : first());
	}
	
	@Override
	public OneTuple<Z, Z> change(int index, Function<OneTuple<Z, A>, ? extends Z> function) {
		checkIndex(index, size());
		return new OneTuple<>(index == 0 ? function.apply(this) : first());
	}
	
	@Override
	public <X extends Z> TwoTuple<Z, A, X> extend(X value) {
		return new TwoTuple<>(first(), value);
	}
	
	@Override
	public <X extends Z> TwoTuple<Z, A, X> extend(Supplier<X> supplier) {
		return new TwoTuple<>(first(), supplier.get());
	}
	
	@Override
	public <X extends Z> TwoTuple<Z, A, X> extend(Function<OneTuple<Z, A>, X> function) {
		return new TwoTuple<>(first(), function.apply(this));
	}
	
	@Override
	public <X extends Z> OneTuple<Z, X> first(X value) {
		return new OneTuple<>(value);
	}
	
	@Override
	public <X extends Z> OneTuple<Z, X> first(Supplier<X> supplier) {
		return new OneTuple<>(supplier.get());
	}
	
	@Override
	public <X extends Z> OneTuple<Z, X> first(Function<A, X> function) {
		return new OneTuple<>(function.apply(first()));
	}
	
	@Override
	public EmptyTuple<Z> dropFirst() {
		return new EmptyTuple<>();
	}
	
	public static <Z, A extends Z, X extends Z> Function<OneTuple<Z, A>, TwoTuple<Z, A, X>> extendWith(X value) {
		return tuple -> tuple.extend(value);
	}
	
	public static <Z, A extends Z, X extends Z> Function<OneTuple<Z, A>, TwoTuple<Z, A, X>> extendWith(Supplier<X> supplier) {
		return tuple -> tuple.extend(supplier);
	}
	
	public static <Z, A extends Z, X extends Z> Function<OneTuple<Z, A>, TwoTuple<Z, A, X>> extendWith(Function<OneTuple<Z, A>, X> function) {
		return tuple -> tuple.extend(function);
	}
	
	public static <Z, A extends Z>OneTuple<Z, A> of(A first) {
		return new OneTuple<>(first);
	}
	
	
}


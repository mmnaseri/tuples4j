package com.mmnaseri.utils.tuples.impl;

import com.mmnaseri.utils.tuples.facade.*;
import java.util.function.Function;
import java.util.function.Supplier;
import static com.mmnaseri.utils.tuples.utils.TupleUtils.checkIndex;

public class TwoTuple<Z, A extends Z, B extends Z> extends AbstractFixedTuple<Z, TwoTuple<Z, A, B>>
	implements 
	HasFirst<Z, A, TwoTuple<Z, A, B>>,
	HasSecond<Z, B, TwoTuple<Z, A, B>> {
	
	public TwoTuple(A first, B second) {
		super(first, second);
	}
	
	@Override
	public TwoTuple<Z, Z, Z> change(int index, Supplier<? extends Z> supplier) {
		checkIndex(index, size());
		return new TwoTuple<>(index == 0 ? supplier.get() : first(),
			index == 1 ? supplier.get() : second());
	}
	
	@Override
	public TwoTuple<Z, Z, Z> change(int index, Function<TwoTuple<Z, A, B>, ? extends Z> function) {
		checkIndex(index, size());
		return new TwoTuple<>(index == 0 ? function.apply(this) : first(),
			index == 1 ? function.apply(this) : second());
	}
	
	@Override
	public <X extends Z> ThreeTuple<Z, A, B, X> extend(X value) {
		return new ThreeTuple<>(first(), second(), value);
	}
	
	@Override
	public <X extends Z> ThreeTuple<Z, A, B, X> extend(Supplier<X> supplier) {
		return new ThreeTuple<>(first(), second(), supplier.get());
	}
	
	@Override
	public <X extends Z> ThreeTuple<Z, A, B, X> extend(Function<TwoTuple<Z, A, B>, X> function) {
		return new ThreeTuple<>(first(), second(), function.apply(this));
	}
	
	@Override
	public <X extends Z> TwoTuple<Z, X, B> first(X value) {
		return new TwoTuple<>(value, second());
	}
	
	@Override
	public <X extends Z> TwoTuple<Z, X, B> first(Supplier<X> supplier) {
		return new TwoTuple<>(supplier.get(), second());
	}
	
	@Override
	public <X extends Z> TwoTuple<Z, X, B> first(Function<A, X> function) {
		return new TwoTuple<>(function.apply(first()), second());
	}
	
	@Override
	public OneTuple<Z, B> dropFirst() {
		return new OneTuple<>(second());
	}
	
	@Override
	public <X extends Z> TwoTuple<Z, A, X> second(X value) {
		return new TwoTuple<>(first(), value);
	}
	
	@Override
	public <X extends Z> TwoTuple<Z, A, X> second(Supplier<X> supplier) {
		return new TwoTuple<>(first(), supplier.get());
	}
	
	@Override
	public <X extends Z> TwoTuple<Z, A, X> second(Function<B, X> function) {
		return new TwoTuple<>(first(), function.apply(second()));
	}
	
	@Override
	public OneTuple<Z, A> dropSecond() {
		return new OneTuple<>(first());
	}
	
	public static <Z, A extends Z, B extends Z, X extends Z> Function<TwoTuple<Z, A, B>, ThreeTuple<Z, A, B, X>> extendWith(X value) {
		return tuple -> tuple.extend(value);
	}
	
	public static <Z, A extends Z, B extends Z, X extends Z> Function<TwoTuple<Z, A, B>, ThreeTuple<Z, A, B, X>> extendWith(Supplier<X> supplier) {
		return tuple -> tuple.extend(supplier);
	}
	
	public static <Z, A extends Z, B extends Z, X extends Z> Function<TwoTuple<Z, A, B>, ThreeTuple<Z, A, B, X>> extendWith(Function<TwoTuple<Z, A, B>, X> function) {
		return tuple -> tuple.extend(function);
	}
	
	public static <Z, A extends Z, B extends Z>TwoTuple<Z, A, B> of(A first, B second) {
		return new TwoTuple<>(first, second);
	}
	
	
}


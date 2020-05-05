package com.mmnaseri.utils.tuples.impl;

import com.mmnaseri.utils.tuples.facade.*;
import java.util.function.Function;
import java.util.function.Supplier;
import static com.mmnaseri.utils.tuples.utils.TupleUtils.checkIndex;

public class EmptyTuple<Z> extends AbstractFixedTuple<Z, EmptyTuple<Z>> {
	
	public EmptyTuple() {
		super();
	}
	
	@Override
	public EmptyTuple<Z> change(int index, Supplier<? extends Z> supplier) {
		checkIndex(index, size());
		return new EmptyTuple<>();
	}
	
	@Override
	public EmptyTuple<Z> change(int index, Function<EmptyTuple<Z>, ? extends Z> function) {
		checkIndex(index, size());
		return new EmptyTuple<>();
	}
	
	@Override
	public <X extends Z> OneTuple<Z, X> extend(X value) {
		return new OneTuple<>(value);
	}
	
	@Override
	public <X extends Z> OneTuple<Z, X> extend(Supplier<X> supplier) {
		return new OneTuple<>(supplier.get());
	}
	
	@Override
	public <X extends Z> OneTuple<Z, X> extend(Function<EmptyTuple<Z>, X> function) {
		return new OneTuple<>(function.apply(this));
	}
	
	public static <Z, X extends Z> Function<EmptyTuple<Z>, OneTuple<Z, X>> extendWith(X value) {
		return tuple -> tuple.extend(value);
	}
	
	public static <Z, X extends Z> Function<EmptyTuple<Z>, OneTuple<Z, X>> extendWith(Supplier<X> supplier) {
		return tuple -> tuple.extend(supplier);
	}
	
	public static <Z, X extends Z> Function<EmptyTuple<Z>, OneTuple<Z, X>> extendWith(Function<EmptyTuple<Z>, X> function) {
		return tuple -> tuple.extend(function);
	}
	
	public static <Z>EmptyTuple<Z> of() {
		return new EmptyTuple<>();
	}
	
	
}


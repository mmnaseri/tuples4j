package com.mmnaseri.utils.tuples.impl;

import com.mmnaseri.utils.tuples.facade.*;
import java.util.function.Function;
import java.util.function.Supplier;
import static com.mmnaseri.utils.tuples.utils.TupleUtils.checkIndex;

public class ThreeTuple<Z, A extends Z, B extends Z, C extends Z> extends AbstractFixedTuple<Z, ThreeTuple<Z, A, B, C>>
	implements 
	HasFirst<Z, A, ThreeTuple<Z, A, B, C>>,
	HasSecond<Z, B, ThreeTuple<Z, A, B, C>>,
	HasThird<Z, C, ThreeTuple<Z, A, B, C>> {
	
	public ThreeTuple(A first, B second, C third) {
		super(first, second, third);
	}
	
	@Override
	public ThreeTuple<Z, Z, Z, Z> change(int index, Supplier<? extends Z> supplier) {
		checkIndex(index, size());
		return new ThreeTuple<>(index == 0 ? supplier.get() : first(),
			index == 1 ? supplier.get() : second(),
			index == 2 ? supplier.get() : third());
	}
	
	@Override
	public ThreeTuple<Z, Z, Z, Z> change(int index, Function<ThreeTuple<Z, A, B, C>, ? extends Z> function) {
		checkIndex(index, size());
		return new ThreeTuple<>(index == 0 ? function.apply(this) : first(),
			index == 1 ? function.apply(this) : second(),
			index == 2 ? function.apply(this) : third());
	}
	
	@Override
	public <X extends Z> FourTuple<Z, A, B, C, X> extend(X value) {
		return new FourTuple<>(first(), second(), third(), value);
	}
	
	@Override
	public <X extends Z> FourTuple<Z, A, B, C, X> extend(Supplier<X> supplier) {
		return new FourTuple<>(first(), second(), third(), supplier.get());
	}
	
	@Override
	public <X extends Z> FourTuple<Z, A, B, C, X> extend(Function<ThreeTuple<Z, A, B, C>, X> function) {
		return new FourTuple<>(first(), second(), third(), function.apply(this));
	}
	
	@Override
	public <X extends Z> ThreeTuple<Z, X, B, C> first(X value) {
		return new ThreeTuple<>(value, second(), third());
	}
	
	@Override
	public <X extends Z> ThreeTuple<Z, X, B, C> first(Supplier<X> supplier) {
		return new ThreeTuple<>(supplier.get(), second(), third());
	}
	
	@Override
	public <X extends Z> ThreeTuple<Z, X, B, C> first(Function<A, X> function) {
		return new ThreeTuple<>(function.apply(first()), second(), third());
	}
	
	@Override
	public TwoTuple<Z, B, C> dropFirst() {
		return new TwoTuple<>(second(), third());
	}
	
	@Override
	public <X extends Z> ThreeTuple<Z, A, X, C> second(X value) {
		return new ThreeTuple<>(first(), value, third());
	}
	
	@Override
	public <X extends Z> ThreeTuple<Z, A, X, C> second(Supplier<X> supplier) {
		return new ThreeTuple<>(first(), supplier.get(), third());
	}
	
	@Override
	public <X extends Z> ThreeTuple<Z, A, X, C> second(Function<B, X> function) {
		return new ThreeTuple<>(first(), function.apply(second()), third());
	}
	
	@Override
	public TwoTuple<Z, A, C> dropSecond() {
		return new TwoTuple<>(first(), third());
	}
	
	@Override
	public <X extends Z> ThreeTuple<Z, A, B, X> third(X value) {
		return new ThreeTuple<>(first(), second(), value);
	}
	
	@Override
	public <X extends Z> ThreeTuple<Z, A, B, X> third(Supplier<X> supplier) {
		return new ThreeTuple<>(first(), second(), supplier.get());
	}
	
	@Override
	public <X extends Z> ThreeTuple<Z, A, B, X> third(Function<C, X> function) {
		return new ThreeTuple<>(first(), second(), function.apply(third()));
	}
	
	@Override
	public TwoTuple<Z, A, B> dropThird() {
		return new TwoTuple<>(first(), second());
	}
	
	public static <Z, A extends Z, B extends Z, C extends Z, X extends Z> Function<ThreeTuple<Z, A, B, C>, FourTuple<Z, A, B, C, X>> extendWith(X value) {
		return tuple -> tuple.extend(value);
	}
	
	public static <Z, A extends Z, B extends Z, C extends Z, X extends Z> Function<ThreeTuple<Z, A, B, C>, FourTuple<Z, A, B, C, X>> extendWith(Supplier<X> supplier) {
		return tuple -> tuple.extend(supplier);
	}
	
	public static <Z, A extends Z, B extends Z, C extends Z, X extends Z> Function<ThreeTuple<Z, A, B, C>, FourTuple<Z, A, B, C, X>> extendWith(Function<ThreeTuple<Z, A, B, C>, X> function) {
		return tuple -> tuple.extend(function);
	}
	
	public static <Z, A extends Z, B extends Z, C extends Z>ThreeTuple<Z, A, B, C> of(A first, B second, C third) {
		return new ThreeTuple<>(first, second, third);
	}
	
	
}


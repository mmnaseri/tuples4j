package com.mmnaseri.utils.tuples.impl;

import com.mmnaseri.utils.tuples.facade.*;
import java.util.function.Function;
import java.util.function.Supplier;
import static com.mmnaseri.utils.tuples.utils.TupleUtils.checkIndex;

public class FourTuple<Z, A extends Z, B extends Z, C extends Z, D extends Z> extends AbstractFixedTuple<Z, FourTuple<Z, A, B, C, D>>
	implements 
	HasFirst<Z, A, FourTuple<Z, A, B, C, D>>,
	HasSecond<Z, B, FourTuple<Z, A, B, C, D>>,
	HasThird<Z, C, FourTuple<Z, A, B, C, D>>,
	HasFourth<Z, D, FourTuple<Z, A, B, C, D>> {
	
	public FourTuple(A first, B second, C third, D fourth) {
		super(first, second, third, fourth);
	}
	
	@Override
	public FourTuple<Z, Z, Z, Z, Z> change(int index, Supplier<? extends Z> supplier) {
		checkIndex(index, size());
		return new FourTuple<>(index == 0 ? supplier.get() : first(),
			index == 1 ? supplier.get() : second(),
			index == 2 ? supplier.get() : third(),
			index == 3 ? supplier.get() : fourth());
	}
	
	@Override
	public FourTuple<Z, Z, Z, Z, Z> change(int index, Function<FourTuple<Z, A, B, C, D>, ? extends Z> function) {
		checkIndex(index, size());
		return new FourTuple<>(index == 0 ? function.apply(this) : first(),
			index == 1 ? function.apply(this) : second(),
			index == 2 ? function.apply(this) : third(),
			index == 3 ? function.apply(this) : fourth());
	}
	
	@Override
	public <X extends Z> FiveTuple<Z, A, B, C, D, X> extend(X value) {
		return new FiveTuple<>(first(), second(), third(), fourth(), value);
	}
	
	@Override
	public <X extends Z> FiveTuple<Z, A, B, C, D, X> extend(Supplier<X> supplier) {
		return new FiveTuple<>(first(), second(), third(), fourth(), supplier.get());
	}
	
	@Override
	public <X extends Z> FiveTuple<Z, A, B, C, D, X> extend(Function<FourTuple<Z, A, B, C, D>, X> function) {
		return new FiveTuple<>(first(), second(), third(), fourth(), function.apply(this));
	}
	
	@Override
	public <X extends Z> FourTuple<Z, X, B, C, D> first(X value) {
		return new FourTuple<>(value, second(), third(), fourth());
	}
	
	@Override
	public <X extends Z> FourTuple<Z, X, B, C, D> first(Supplier<X> supplier) {
		return new FourTuple<>(supplier.get(), second(), third(), fourth());
	}
	
	@Override
	public <X extends Z> FourTuple<Z, X, B, C, D> first(Function<A, X> function) {
		return new FourTuple<>(function.apply(first()), second(), third(), fourth());
	}
	
	@Override
	public ThreeTuple<Z, B, C, D> dropFirst() {
		return new ThreeTuple<>(second(), third(), fourth());
	}
	
	@Override
	public <X extends Z> FourTuple<Z, A, X, C, D> second(X value) {
		return new FourTuple<>(first(), value, third(), fourth());
	}
	
	@Override
	public <X extends Z> FourTuple<Z, A, X, C, D> second(Supplier<X> supplier) {
		return new FourTuple<>(first(), supplier.get(), third(), fourth());
	}
	
	@Override
	public <X extends Z> FourTuple<Z, A, X, C, D> second(Function<B, X> function) {
		return new FourTuple<>(first(), function.apply(second()), third(), fourth());
	}
	
	@Override
	public ThreeTuple<Z, A, C, D> dropSecond() {
		return new ThreeTuple<>(first(), third(), fourth());
	}
	
	@Override
	public <X extends Z> FourTuple<Z, A, B, X, D> third(X value) {
		return new FourTuple<>(first(), second(), value, fourth());
	}
	
	@Override
	public <X extends Z> FourTuple<Z, A, B, X, D> third(Supplier<X> supplier) {
		return new FourTuple<>(first(), second(), supplier.get(), fourth());
	}
	
	@Override
	public <X extends Z> FourTuple<Z, A, B, X, D> third(Function<C, X> function) {
		return new FourTuple<>(first(), second(), function.apply(third()), fourth());
	}
	
	@Override
	public ThreeTuple<Z, A, B, D> dropThird() {
		return new ThreeTuple<>(first(), second(), fourth());
	}
	
	@Override
	public <X extends Z> FourTuple<Z, A, B, C, X> fourth(X value) {
		return new FourTuple<>(first(), second(), third(), value);
	}
	
	@Override
	public <X extends Z> FourTuple<Z, A, B, C, X> fourth(Supplier<X> supplier) {
		return new FourTuple<>(first(), second(), third(), supplier.get());
	}
	
	@Override
	public <X extends Z> FourTuple<Z, A, B, C, X> fourth(Function<D, X> function) {
		return new FourTuple<>(first(), second(), third(), function.apply(fourth()));
	}
	
	@Override
	public ThreeTuple<Z, A, B, C> dropFourth() {
		return new ThreeTuple<>(first(), second(), third());
	}
	
	public static <Z, A extends Z, B extends Z, C extends Z, D extends Z, X extends Z> Function<FourTuple<Z, A, B, C, D>, FiveTuple<Z, A, B, C, D, X>> extendWith(X value) {
		return tuple -> tuple.extend(value);
	}
	
	public static <Z, A extends Z, B extends Z, C extends Z, D extends Z, X extends Z> Function<FourTuple<Z, A, B, C, D>, FiveTuple<Z, A, B, C, D, X>> extendWith(Supplier<X> supplier) {
		return tuple -> tuple.extend(supplier);
	}
	
	public static <Z, A extends Z, B extends Z, C extends Z, D extends Z, X extends Z> Function<FourTuple<Z, A, B, C, D>, FiveTuple<Z, A, B, C, D, X>> extendWith(Function<FourTuple<Z, A, B, C, D>, X> function) {
		return tuple -> tuple.extend(function);
	}
	
	public static <Z, A extends Z, B extends Z, C extends Z, D extends Z>FourTuple<Z, A, B, C, D> of(A first, B second, C third, D fourth) {
		return new FourTuple<>(first, second, third, fourth);
	}
	
	
}


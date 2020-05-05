package com.mmnaseri.utils.tuples.impl;

import com.mmnaseri.utils.tuples.facade.*;
import java.util.function.Function;
import java.util.function.Supplier;
import static com.mmnaseri.utils.tuples.utils.TupleUtils.checkIndex;

public class FiveTuple<Z, A extends Z, B extends Z, C extends Z, D extends Z, E extends Z> extends AbstractFixedTuple<Z, FiveTuple<Z, A, B, C, D, E>>
	implements 
	HasFirst<Z, A, FiveTuple<Z, A, B, C, D, E>>,
	HasSecond<Z, B, FiveTuple<Z, A, B, C, D, E>>,
	HasThird<Z, C, FiveTuple<Z, A, B, C, D, E>>,
	HasFourth<Z, D, FiveTuple<Z, A, B, C, D, E>>,
	HasFifth<Z, E, FiveTuple<Z, A, B, C, D, E>> {
	
	public FiveTuple(A first, B second, C third, D fourth, E fifth) {
		super(first, second, third, fourth, fifth);
	}
	
	@Override
	public FiveTuple<Z, Z, Z, Z, Z, Z> change(int index, Supplier<? extends Z> supplier) {
		checkIndex(index, size());
		return new FiveTuple<>(index == 0 ? supplier.get() : first(),
			index == 1 ? supplier.get() : second(),
			index == 2 ? supplier.get() : third(),
			index == 3 ? supplier.get() : fourth(),
			index == 4 ? supplier.get() : fifth());
	}
	
	@Override
	public FiveTuple<Z, Z, Z, Z, Z, Z> change(int index, Function<FiveTuple<Z, A, B, C, D, E>, ? extends Z> function) {
		checkIndex(index, size());
		return new FiveTuple<>(index == 0 ? function.apply(this) : first(),
			index == 1 ? function.apply(this) : second(),
			index == 2 ? function.apply(this) : third(),
			index == 3 ? function.apply(this) : fourth(),
			index == 4 ? function.apply(this) : fifth());
	}
	
	@Override
	public <X extends Z> SixTuple<Z, A, B, C, D, E, X> extend(X value) {
		return new SixTuple<>(first(), second(), third(), fourth(), fifth(), value);
	}
	
	@Override
	public <X extends Z> SixTuple<Z, A, B, C, D, E, X> extend(Supplier<X> supplier) {
		return new SixTuple<>(first(), second(), third(), fourth(), fifth(), supplier.get());
	}
	
	@Override
	public <X extends Z> SixTuple<Z, A, B, C, D, E, X> extend(Function<FiveTuple<Z, A, B, C, D, E>, X> function) {
		return new SixTuple<>(first(), second(), third(), fourth(), fifth(), function.apply(this));
	}
	
	@Override
	public <X extends Z> FiveTuple<Z, X, B, C, D, E> first(X value) {
		return new FiveTuple<>(value, second(), third(), fourth(), fifth());
	}
	
	@Override
	public <X extends Z> FiveTuple<Z, X, B, C, D, E> first(Supplier<X> supplier) {
		return new FiveTuple<>(supplier.get(), second(), third(), fourth(), fifth());
	}
	
	@Override
	public <X extends Z> FiveTuple<Z, X, B, C, D, E> first(Function<A, X> function) {
		return new FiveTuple<>(function.apply(first()), second(), third(), fourth(), fifth());
	}
	
	@Override
	public FourTuple<Z, B, C, D, E> dropFirst() {
		return new FourTuple<>(second(), third(), fourth(), fifth());
	}
	
	@Override
	public <X extends Z> FiveTuple<Z, A, X, C, D, E> second(X value) {
		return new FiveTuple<>(first(), value, third(), fourth(), fifth());
	}
	
	@Override
	public <X extends Z> FiveTuple<Z, A, X, C, D, E> second(Supplier<X> supplier) {
		return new FiveTuple<>(first(), supplier.get(), third(), fourth(), fifth());
	}
	
	@Override
	public <X extends Z> FiveTuple<Z, A, X, C, D, E> second(Function<B, X> function) {
		return new FiveTuple<>(first(), function.apply(second()), third(), fourth(), fifth());
	}
	
	@Override
	public FourTuple<Z, A, C, D, E> dropSecond() {
		return new FourTuple<>(first(), third(), fourth(), fifth());
	}
	
	@Override
	public <X extends Z> FiveTuple<Z, A, B, X, D, E> third(X value) {
		return new FiveTuple<>(first(), second(), value, fourth(), fifth());
	}
	
	@Override
	public <X extends Z> FiveTuple<Z, A, B, X, D, E> third(Supplier<X> supplier) {
		return new FiveTuple<>(first(), second(), supplier.get(), fourth(), fifth());
	}
	
	@Override
	public <X extends Z> FiveTuple<Z, A, B, X, D, E> third(Function<C, X> function) {
		return new FiveTuple<>(first(), second(), function.apply(third()), fourth(), fifth());
	}
	
	@Override
	public FourTuple<Z, A, B, D, E> dropThird() {
		return new FourTuple<>(first(), second(), fourth(), fifth());
	}
	
	@Override
	public <X extends Z> FiveTuple<Z, A, B, C, X, E> fourth(X value) {
		return new FiveTuple<>(first(), second(), third(), value, fifth());
	}
	
	@Override
	public <X extends Z> FiveTuple<Z, A, B, C, X, E> fourth(Supplier<X> supplier) {
		return new FiveTuple<>(first(), second(), third(), supplier.get(), fifth());
	}
	
	@Override
	public <X extends Z> FiveTuple<Z, A, B, C, X, E> fourth(Function<D, X> function) {
		return new FiveTuple<>(first(), second(), third(), function.apply(fourth()), fifth());
	}
	
	@Override
	public FourTuple<Z, A, B, C, E> dropFourth() {
		return new FourTuple<>(first(), second(), third(), fifth());
	}
	
	@Override
	public <X extends Z> FiveTuple<Z, A, B, C, D, X> fifth(X value) {
		return new FiveTuple<>(first(), second(), third(), fourth(), value);
	}
	
	@Override
	public <X extends Z> FiveTuple<Z, A, B, C, D, X> fifth(Supplier<X> supplier) {
		return new FiveTuple<>(first(), second(), third(), fourth(), supplier.get());
	}
	
	@Override
	public <X extends Z> FiveTuple<Z, A, B, C, D, X> fifth(Function<E, X> function) {
		return new FiveTuple<>(first(), second(), third(), fourth(), function.apply(fifth()));
	}
	
	@Override
	public FourTuple<Z, A, B, C, D> dropFifth() {
		return new FourTuple<>(first(), second(), third(), fourth());
	}
	
	public static <Z, A extends Z, B extends Z, C extends Z, D extends Z, E extends Z, X extends Z> Function<FiveTuple<Z, A, B, C, D, E>, SixTuple<Z, A, B, C, D, E, X>> extendWith(X value) {
		return tuple -> tuple.extend(value);
	}
	
	public static <Z, A extends Z, B extends Z, C extends Z, D extends Z, E extends Z, X extends Z> Function<FiveTuple<Z, A, B, C, D, E>, SixTuple<Z, A, B, C, D, E, X>> extendWith(Supplier<X> supplier) {
		return tuple -> tuple.extend(supplier);
	}
	
	public static <Z, A extends Z, B extends Z, C extends Z, D extends Z, E extends Z, X extends Z> Function<FiveTuple<Z, A, B, C, D, E>, SixTuple<Z, A, B, C, D, E, X>> extendWith(Function<FiveTuple<Z, A, B, C, D, E>, X> function) {
		return tuple -> tuple.extend(function);
	}
	
	public static <Z, A extends Z, B extends Z, C extends Z, D extends Z, E extends Z>FiveTuple<Z, A, B, C, D, E> of(A first, B second, C third, D fourth, E fifth) {
		return new FiveTuple<>(first, second, third, fourth, fifth);
	}
	
	
}


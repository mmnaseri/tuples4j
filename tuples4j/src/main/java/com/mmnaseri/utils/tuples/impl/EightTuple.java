package com.mmnaseri.utils.tuples.impl;

import com.mmnaseri.utils.tuples.facade.*;
import java.util.function.Function;
import java.util.function.Supplier;
import static com.mmnaseri.utils.tuples.utils.TupleUtils.checkIndex;

public class EightTuple<Z, A extends Z, B extends Z, C extends Z, D extends Z, E extends Z, F extends Z, G extends Z, H extends Z> extends AbstractFixedTuple<Z, EightTuple<Z, A, B, C, D, E, F, G, H>>
	implements 
	HasFirst<Z, A, EightTuple<Z, A, B, C, D, E, F, G, H>>,
	HasSecond<Z, B, EightTuple<Z, A, B, C, D, E, F, G, H>>,
	HasThird<Z, C, EightTuple<Z, A, B, C, D, E, F, G, H>>,
	HasFourth<Z, D, EightTuple<Z, A, B, C, D, E, F, G, H>>,
	HasFifth<Z, E, EightTuple<Z, A, B, C, D, E, F, G, H>>,
	HasSixth<Z, F, EightTuple<Z, A, B, C, D, E, F, G, H>>,
	HasSeventh<Z, G, EightTuple<Z, A, B, C, D, E, F, G, H>>,
	HasEighth<Z, H, EightTuple<Z, A, B, C, D, E, F, G, H>> {
	
	public EightTuple(A first, B second, C third, D fourth, E fifth, F sixth, G seventh, H eighth) {
		super(first, second, third, fourth, fifth, sixth, seventh, eighth);
	}
	
	@Override
	public EightTuple<Z, Z, Z, Z, Z, Z, Z, Z, Z> change(int index, Supplier<? extends Z> supplier) {
		checkIndex(index, size());
		return new EightTuple<>(index == 0 ? supplier.get() : first(),
			index == 1 ? supplier.get() : second(),
			index == 2 ? supplier.get() : third(),
			index == 3 ? supplier.get() : fourth(),
			index == 4 ? supplier.get() : fifth(),
			index == 5 ? supplier.get() : sixth(),
			index == 6 ? supplier.get() : seventh(),
			index == 7 ? supplier.get() : eighth());
	}
	
	@Override
	public EightTuple<Z, Z, Z, Z, Z, Z, Z, Z, Z> change(int index, Function<EightTuple<Z, A, B, C, D, E, F, G, H>, ? extends Z> function) {
		checkIndex(index, size());
		return new EightTuple<>(index == 0 ? function.apply(this) : first(),
			index == 1 ? function.apply(this) : second(),
			index == 2 ? function.apply(this) : third(),
			index == 3 ? function.apply(this) : fourth(),
			index == 4 ? function.apply(this) : fifth(),
			index == 5 ? function.apply(this) : sixth(),
			index == 6 ? function.apply(this) : seventh(),
			index == 7 ? function.apply(this) : eighth());
	}
	
	@Override
	public <X extends Z> NineTuple<Z, A, B, C, D, E, F, G, H, X> extend(X value) {
		return new NineTuple<>(first(), second(), third(), fourth(), fifth(), sixth(), seventh(), eighth(), value);
	}
	
	@Override
	public <X extends Z> NineTuple<Z, A, B, C, D, E, F, G, H, X> extend(Supplier<X> supplier) {
		return new NineTuple<>(first(), second(), third(), fourth(), fifth(), sixth(), seventh(), eighth(), supplier.get());
	}
	
	@Override
	public <X extends Z> NineTuple<Z, A, B, C, D, E, F, G, H, X> extend(Function<EightTuple<Z, A, B, C, D, E, F, G, H>, X> function) {
		return new NineTuple<>(first(), second(), third(), fourth(), fifth(), sixth(), seventh(), eighth(), function.apply(this));
	}
	
	@Override
	public <X extends Z> EightTuple<Z, X, B, C, D, E, F, G, H> first(X value) {
		return new EightTuple<>(value, second(), third(), fourth(), fifth(), sixth(), seventh(), eighth());
	}
	
	@Override
	public <X extends Z> EightTuple<Z, X, B, C, D, E, F, G, H> first(Supplier<X> supplier) {
		return new EightTuple<>(supplier.get(), second(), third(), fourth(), fifth(), sixth(), seventh(), eighth());
	}
	
	@Override
	public <X extends Z> EightTuple<Z, X, B, C, D, E, F, G, H> first(Function<A, X> function) {
		return new EightTuple<>(function.apply(first()), second(), third(), fourth(), fifth(), sixth(), seventh(), eighth());
	}
	
	@Override
	public SevenTuple<Z, B, C, D, E, F, G, H> dropFirst() {
		return new SevenTuple<>(second(), third(), fourth(), fifth(), sixth(), seventh(), eighth());
	}
	
	@Override
	public <X extends Z> EightTuple<Z, A, X, C, D, E, F, G, H> second(X value) {
		return new EightTuple<>(first(), value, third(), fourth(), fifth(), sixth(), seventh(), eighth());
	}
	
	@Override
	public <X extends Z> EightTuple<Z, A, X, C, D, E, F, G, H> second(Supplier<X> supplier) {
		return new EightTuple<>(first(), supplier.get(), third(), fourth(), fifth(), sixth(), seventh(), eighth());
	}
	
	@Override
	public <X extends Z> EightTuple<Z, A, X, C, D, E, F, G, H> second(Function<B, X> function) {
		return new EightTuple<>(first(), function.apply(second()), third(), fourth(), fifth(), sixth(), seventh(), eighth());
	}
	
	@Override
	public SevenTuple<Z, A, C, D, E, F, G, H> dropSecond() {
		return new SevenTuple<>(first(), third(), fourth(), fifth(), sixth(), seventh(), eighth());
	}
	
	@Override
	public <X extends Z> EightTuple<Z, A, B, X, D, E, F, G, H> third(X value) {
		return new EightTuple<>(first(), second(), value, fourth(), fifth(), sixth(), seventh(), eighth());
	}
	
	@Override
	public <X extends Z> EightTuple<Z, A, B, X, D, E, F, G, H> third(Supplier<X> supplier) {
		return new EightTuple<>(first(), second(), supplier.get(), fourth(), fifth(), sixth(), seventh(), eighth());
	}
	
	@Override
	public <X extends Z> EightTuple<Z, A, B, X, D, E, F, G, H> third(Function<C, X> function) {
		return new EightTuple<>(first(), second(), function.apply(third()), fourth(), fifth(), sixth(), seventh(), eighth());
	}
	
	@Override
	public SevenTuple<Z, A, B, D, E, F, G, H> dropThird() {
		return new SevenTuple<>(first(), second(), fourth(), fifth(), sixth(), seventh(), eighth());
	}
	
	@Override
	public <X extends Z> EightTuple<Z, A, B, C, X, E, F, G, H> fourth(X value) {
		return new EightTuple<>(first(), second(), third(), value, fifth(), sixth(), seventh(), eighth());
	}
	
	@Override
	public <X extends Z> EightTuple<Z, A, B, C, X, E, F, G, H> fourth(Supplier<X> supplier) {
		return new EightTuple<>(first(), second(), third(), supplier.get(), fifth(), sixth(), seventh(), eighth());
	}
	
	@Override
	public <X extends Z> EightTuple<Z, A, B, C, X, E, F, G, H> fourth(Function<D, X> function) {
		return new EightTuple<>(first(), second(), third(), function.apply(fourth()), fifth(), sixth(), seventh(), eighth());
	}
	
	@Override
	public SevenTuple<Z, A, B, C, E, F, G, H> dropFourth() {
		return new SevenTuple<>(first(), second(), third(), fifth(), sixth(), seventh(), eighth());
	}
	
	@Override
	public <X extends Z> EightTuple<Z, A, B, C, D, X, F, G, H> fifth(X value) {
		return new EightTuple<>(first(), second(), third(), fourth(), value, sixth(), seventh(), eighth());
	}
	
	@Override
	public <X extends Z> EightTuple<Z, A, B, C, D, X, F, G, H> fifth(Supplier<X> supplier) {
		return new EightTuple<>(first(), second(), third(), fourth(), supplier.get(), sixth(), seventh(), eighth());
	}
	
	@Override
	public <X extends Z> EightTuple<Z, A, B, C, D, X, F, G, H> fifth(Function<E, X> function) {
		return new EightTuple<>(first(), second(), third(), fourth(), function.apply(fifth()), sixth(), seventh(), eighth());
	}
	
	@Override
	public SevenTuple<Z, A, B, C, D, F, G, H> dropFifth() {
		return new SevenTuple<>(first(), second(), third(), fourth(), sixth(), seventh(), eighth());
	}
	
	@Override
	public <X extends Z> EightTuple<Z, A, B, C, D, E, X, G, H> sixth(X value) {
		return new EightTuple<>(first(), second(), third(), fourth(), fifth(), value, seventh(), eighth());
	}
	
	@Override
	public <X extends Z> EightTuple<Z, A, B, C, D, E, X, G, H> sixth(Supplier<X> supplier) {
		return new EightTuple<>(first(), second(), third(), fourth(), fifth(), supplier.get(), seventh(), eighth());
	}
	
	@Override
	public <X extends Z> EightTuple<Z, A, B, C, D, E, X, G, H> sixth(Function<F, X> function) {
		return new EightTuple<>(first(), second(), third(), fourth(), fifth(), function.apply(sixth()), seventh(), eighth());
	}
	
	@Override
	public SevenTuple<Z, A, B, C, D, E, G, H> dropSixth() {
		return new SevenTuple<>(first(), second(), third(), fourth(), fifth(), seventh(), eighth());
	}
	
	@Override
	public <X extends Z> EightTuple<Z, A, B, C, D, E, F, X, H> seventh(X value) {
		return new EightTuple<>(first(), second(), third(), fourth(), fifth(), sixth(), value, eighth());
	}
	
	@Override
	public <X extends Z> EightTuple<Z, A, B, C, D, E, F, X, H> seventh(Supplier<X> supplier) {
		return new EightTuple<>(first(), second(), third(), fourth(), fifth(), sixth(), supplier.get(), eighth());
	}
	
	@Override
	public <X extends Z> EightTuple<Z, A, B, C, D, E, F, X, H> seventh(Function<G, X> function) {
		return new EightTuple<>(first(), second(), third(), fourth(), fifth(), sixth(), function.apply(seventh()), eighth());
	}
	
	@Override
	public SevenTuple<Z, A, B, C, D, E, F, H> dropSeventh() {
		return new SevenTuple<>(first(), second(), third(), fourth(), fifth(), sixth(), eighth());
	}
	
	@Override
	public <X extends Z> EightTuple<Z, A, B, C, D, E, F, G, X> eighth(X value) {
		return new EightTuple<>(first(), second(), third(), fourth(), fifth(), sixth(), seventh(), value);
	}
	
	@Override
	public <X extends Z> EightTuple<Z, A, B, C, D, E, F, G, X> eighth(Supplier<X> supplier) {
		return new EightTuple<>(first(), second(), third(), fourth(), fifth(), sixth(), seventh(), supplier.get());
	}
	
	@Override
	public <X extends Z> EightTuple<Z, A, B, C, D, E, F, G, X> eighth(Function<H, X> function) {
		return new EightTuple<>(first(), second(), third(), fourth(), fifth(), sixth(), seventh(), function.apply(eighth()));
	}
	
	@Override
	public SevenTuple<Z, A, B, C, D, E, F, G> dropEighth() {
		return new SevenTuple<>(first(), second(), third(), fourth(), fifth(), sixth(), seventh());
	}
	
	public static <Z, A extends Z, B extends Z, C extends Z, D extends Z, E extends Z, F extends Z, G extends Z, H extends Z, X extends Z> Function<EightTuple<Z, A, B, C, D, E, F, G, H>, NineTuple<Z, A, B, C, D, E, F, G, H, X>> extendWith(X value) {
		return tuple -> tuple.extend(value);
	}
	
	public static <Z, A extends Z, B extends Z, C extends Z, D extends Z, E extends Z, F extends Z, G extends Z, H extends Z, X extends Z> Function<EightTuple<Z, A, B, C, D, E, F, G, H>, NineTuple<Z, A, B, C, D, E, F, G, H, X>> extendWith(Supplier<X> supplier) {
		return tuple -> tuple.extend(supplier);
	}
	
	public static <Z, A extends Z, B extends Z, C extends Z, D extends Z, E extends Z, F extends Z, G extends Z, H extends Z, X extends Z> Function<EightTuple<Z, A, B, C, D, E, F, G, H>, NineTuple<Z, A, B, C, D, E, F, G, H, X>> extendWith(Function<EightTuple<Z, A, B, C, D, E, F, G, H>, X> function) {
		return tuple -> tuple.extend(function);
	}
	
	public static <Z, A extends Z, B extends Z, C extends Z, D extends Z, E extends Z, F extends Z, G extends Z, H extends Z>EightTuple<Z, A, B, C, D, E, F, G, H> of(A first, B second, C third, D fourth, E fifth, F sixth, G seventh, H eighth) {
		return new EightTuple<>(first, second, third, fourth, fifth, sixth, seventh, eighth);
	}
	
	
}


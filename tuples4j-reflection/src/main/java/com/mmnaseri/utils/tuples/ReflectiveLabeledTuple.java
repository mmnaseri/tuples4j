package com.mmnaseri.utils.tuples;

/**
 * A {@link LabeledTuple} that can be used to reflectively instantiate objects with this tuple
 * acting as the backing data.
 *
 * @author Milad Naseri (m.m.naseri@gmail.com)
 * @see ReflectiveTuple
 */
public interface ReflectiveLabeledTuple<Z> extends ReflectiveTuple<Z>, LabeledTuple<Z> {}

package com.mmnaseri.utils.tuples.impl;

import com.mmnaseri.utils.tuples.FixedTuple;
import com.mmnaseri.utils.tuples.Tuple;
import com.mmnaseri.utils.tuples.facade.HasEighth;
import com.mmnaseri.utils.tuples.facade.HasEleventh;
import com.mmnaseri.utils.tuples.facade.HasFifth;
import com.mmnaseri.utils.tuples.facade.HasFirst;
import com.mmnaseri.utils.tuples.facade.HasFourth;
import com.mmnaseri.utils.tuples.facade.HasNinth;
import com.mmnaseri.utils.tuples.facade.HasSecond;
import com.mmnaseri.utils.tuples.facade.HasSeventh;
import com.mmnaseri.utils.tuples.facade.HasSixth;
import com.mmnaseri.utils.tuples.facade.HasTenth;
import com.mmnaseri.utils.tuples.facade.HasThird;
import com.mmnaseri.utils.tuples.facade.HasTwelfth;

import java.util.Arrays;
import java.util.List;

import static com.mmnaseri.utils.tuples.utils.TupleUtils.checkIndex;

/**
 * Base class for all the {@link FixedTuple} classes in the library.
 *
 * @author Milad Naseri (m.m.naseri@gmail.com)
 */
public abstract class AbstractFixedTuple<Z, T extends AbstractFixedTuple<Z, T>>
    extends AbstractTuple<Z> implements FixedTuple<Z, T> {

  @SafeVarargs
  protected AbstractFixedTuple(Z... values) {
    this(Arrays.asList(values));
  }

  protected AbstractFixedTuple(List<Z> values) {
    super(values);
  }

  /**
   * Returns a new tuple by keeping all the elements from this tuple except the element at the
   * indicated index.
   */
  @SuppressWarnings("unchecked")
  @Override
  public Tuple<Z> drop(int index) {
    checkIndex(index, size());
    switch (index) {
      case 0:
        return ((HasFirst<Z, ?, ?>) this).dropFirst();
      case 1:
        return ((HasSecond<Z, ?, ?>) this).dropSecond();
      case 2:
        return ((HasThird<Z, ?, ?>) this).dropThird();
      case 3:
        return ((HasFourth<Z, ?, ?>) this).dropFourth();
      case 4:
        return ((HasFifth<Z, ?, ?>) this).dropFifth();
      case 5:
        return ((HasSixth<Z, ?, ?>) this).dropSixth();
      case 6:
        return ((HasSeventh<Z, ?, ?>) this).dropSeventh();
      case 7:
        return ((HasEighth<Z, ?, ?>) this).dropEighth();
      case 8:
        return ((HasNinth<Z, ?, ?>) this).dropNinth();
      case 9:
        return ((HasTenth<Z, ?, ?>) this).dropTenth();
      case 10:
        return ((HasEleventh<Z, ?, ?>) this).dropEleventh();
      default:
        return ((HasTwelfth<Z, ?, ?>) this).dropTwelfth();
    }
  }
}

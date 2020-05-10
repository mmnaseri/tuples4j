package com.mmnaseri.utils.tuples.model;

import com.mmnaseri.utils.tuples.Tuple;
import com.mmnaseri.utils.tuples.reflection.MethodInvocation;
import com.mmnaseri.utils.tuples.reflection.TupleInvocationHandler;

import java.math.BigDecimal;

public class FinancialEntityHandler implements TupleInvocationHandler {

  @Override
  public boolean handles(final Tuple<?> tuple, final MethodInvocation invocation) {
    return invocation.method().getDeclaringClass().equals(FinancialEntity.class)
        && invocation.instance() instanceof Country;
  }

  @Override
  public Object handle(final Tuple<?> tuple, final MethodInvocation invocation) {
    Country country = (Country) invocation.instance();
    return country.gdp().multiply(new BigDecimal(country.population()));
  }
}

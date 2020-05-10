package com.mmnaseri.utils.tuples.model;

import com.mmnaseri.utils.tuples.Tuple;
import com.mmnaseri.utils.tuples.reflection.MethodInvocation;
import com.mmnaseri.utils.tuples.reflection.type.ElementValueProvider;
import com.mmnaseri.utils.tuples.utils.FluentMap;

import java.util.Map;

/** Provides population data for specific country codes. */
public class PopulationDataSource implements ElementValueProvider {

  private static final Map<String, Long> POPULATIONS =
      FluentMap.of("CN", 1_433_783_686L)
          .with("MX", 127_575_529L)
          .with("EG", 100_388_073L)
          .with("DE", 83_517_045L)
          .with("IR", 82_913_906L)
          .with("US", 329_064_917L)
          .with("BR", 211_049_527L);

  @Override
  public Object handle(final Tuple<?> tuple, final MethodInvocation invocation) {
    return POPULATIONS.get(((HasCountryCode) invocation.instance()).countryCode());
  }
}

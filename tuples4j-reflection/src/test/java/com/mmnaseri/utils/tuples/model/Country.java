package com.mmnaseri.utils.tuples.model;

import com.mmnaseri.utils.tuples.annotations.AtIndex;
import com.mmnaseri.utils.tuples.annotations.Converted;
import com.mmnaseri.utils.tuples.annotations.Provided;
import com.mmnaseri.utils.tuples.annotations.WithLabel;

import java.math.BigDecimal;

/**
 * A model that maps to tuples with the following contract:
 *
 * <ol>
 *   <li>They have elements with labels {@code name}, {@code country_code}, and {@code continent},
 *   <li>They have a fourth element.
 *   <li>The types of those elements are convertible to the types of the declared methods.
 * </ol>
 */
public interface Country extends Comparable<Country>, FinancialEntity, HasCountryCode {

  String name();

  @AtIndex(3)
  BigDecimal gdp();

  @WithLabel("country_code")
  String countryCode();

  @Override
  default String countryCodeLowerCase() {
    return countryCode().toLowerCase();
  }

  @Provided(by = PopulationDataSource.class)
  long population();

  @Converted(ContinentValueConverter.class)
  Continent continent();

  @Override
  default int compareTo(Country o) {
    int contentComparison = continent().name().compareTo(o.continent().name());
    if (contentComparison != 0) {
      return contentComparison;
    }
    return name().compareTo(o.name());
  }
}

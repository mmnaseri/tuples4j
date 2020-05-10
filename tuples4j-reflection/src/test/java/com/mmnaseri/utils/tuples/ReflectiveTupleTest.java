package com.mmnaseri.utils.tuples;

import com.mmnaseri.utils.tuples.impl.FourTuple;
import com.mmnaseri.utils.tuples.model.Continent;
import com.mmnaseri.utils.tuples.model.Country;
import org.testng.annotations.Test;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;

public class ReflectiveTupleTest {

  private static final List<FourTuple<Object, String, String, String, String>> DATA =
      Arrays.asList(
          Tuple.of("Mexico", "MX", "North America", "1274175"),
          Tuple.of("Brazil", "BR", "South America", "1847020"),
          Tuple.of("United States", "US", "North America", "21439453"),
          Tuple.of("Egypt", "EG", "Africa", "302256"),
          Tuple.of("Iran", "IR", "Asia", "458500"),
          Tuple.of("Germany", "DE", "Europe", "3863344"),
          Tuple.of("China", "CN", "Asia", "14140163"));

  private static final List<LabeledTuple<Object>> LABELED_DATA =
      DATA.stream()
          .map(Tuple.labelWith("name", "country_code", "continent", "income"))
          .collect(toList());

  private static final List<ReflectiveLabeledTuple<?>> REFLECTIVE_DATA =
      LABELED_DATA.stream().map(ReflectiveTuple::of).collect(toList());

  @Test
  public void testProxyCreation() {
    List<Country> list =
        REFLECTIVE_DATA.stream().map(tuple -> tuple.as(Country.class)).collect(toList());
    assertThat(list, hasSize(DATA.size()));
    for (Country country : list) {
      assertThat(country, is(notNullValue()));
    }
  }

  @Test
  public void testSimpleMappedMethods() {
    List<String> names =
        REFLECTIVE_DATA.stream()
            .map(tuple -> tuple.as(Country.class))
            .map(Country::name)
            .collect(toList());
    assertThat(
        names, contains("Mexico", "Brazil", "United States", "Egypt", "Iran", "Germany", "China"));
  }

  @Test
  public void testIndexedMethod() {
    List<BigDecimal> gdps =
        REFLECTIVE_DATA.stream()
            .map(tuple -> tuple.as(Country.class))
            .map(Country::gdp)
            .collect(toList());
    assertThat(
        gdps,
        contains(
            new BigDecimal("1274175"),
            new BigDecimal("1847020"),
            new BigDecimal("21439453"),
            new BigDecimal("302256"),
            new BigDecimal("458500"),
            new BigDecimal("3863344"),
            new BigDecimal("14140163")));
  }

  @Test
  public void testMethodWithProvider() {
    List<Long> populations =
        REFLECTIVE_DATA.stream()
            .map(tuple -> tuple.as(Country.class))
            .map(Country::population)
            .collect(toList());
    assertThat(
        populations,
        contains(
            127_575_529L,
            211_049_527L,
            329_064_917L,
            100_388_073L,
            82_913_906L,
            83_517_045L,
            1_433_783_686L));
  }

  @Test
  public void testMethodWithCustomConversion() {
    List<Continent> continents =
        REFLECTIVE_DATA.stream()
            .map(tuple -> tuple.as(Country.class))
            .map(Country::continent)
            .collect(toList());
    assertThat(
        continents,
        contains(
            Continent.NORTH_AMERICA,
            Continent.SOUTH_AMERICA,
            Continent.NORTH_AMERICA,
            Continent.AFRICA,
            Continent.ASIA,
            Continent.EUROPE,
            Continent.ASIA));
  }

  @Test
  public void testMethodWithDefaultOverride() {
    List<String> countryCodes =
        REFLECTIVE_DATA.stream()
            .map(tuple -> tuple.as(Country.class))
            .map(Country::countryCode)
            .collect(toList());
    List<String> countryCodesLowerCase =
        REFLECTIVE_DATA.stream()
            .map(tuple -> tuple.as(Country.class))
            .map(Country::countryCodeLowerCase)
            .collect(toList());
    for (int i = 0; i < countryCodes.size(); i++) {
      String countryCode = countryCodes.get(i);
      String countryCodeLowerCase = countryCodesLowerCase.get(i);
      assertThat(countryCodeLowerCase, is(countryCode.toLowerCase()));
    }
  }

  @Test
  public void testMethodWithCustomHandler() {
    List<Country> countries =
        REFLECTIVE_DATA.stream().map(tuple -> tuple.as(Country.class)).collect(toList());
    for (Country country : countries) {
      BigDecimal gdp = country.gdp();
      long population = country.population();
      assertThat(country.income(), is(gdp.multiply(new BigDecimal(population))));
    }
  }

  @Test
  public void testSortingViaDefaultMethod() {
    List<String> names =
        REFLECTIVE_DATA.stream()
            .map(tuple -> tuple.as(Country.class))
            .sorted()
            .map(Country::name)
            .collect(toList());
    assertThat(
        names, contains("Egypt", "China", "Iran", "Germany", "Mexico", "United States", "Brazil"));
  }
}

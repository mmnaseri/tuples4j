# tuples4j

[![Donae](https://img.shields.io/badge/paypal-donate-yellow.svg)](https://paypal.me/mmnaseri)
[![MIT license](http://img.shields.io/badge/license-MIT-brightgreen.svg)](http://opensource.org/licenses/MIT)
[![Maven Central](https://maven-badges.herokuapp.com/maven-central/com.mmnaseri.utils/tuples4j/badge.svg)](https://maven-badges.herokuapp.com/maven-central/com.mmnaseri.utils/tuples4j)
[![Build Status](https://travis-ci.org/mmnaseri/tuples4j.svg?branch=master)](https://travis-ci.org/mmnaseri/tuples4j)
[![Codacy Badge](https://api.codacy.com/project/badge/Grade/1d667baee2084c42bf3c4b1db9c8a30e)](https://www.codacy.com/manual/mmnaseri/tuples4j?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=mmnaseri/tuples4j&amp;utm_campaign=Badge_Grade)[![CodeFactor](https://www.codefactor.io/repository/github/mmnaseri/tuples4j/badge)](https://www.codefactor.io/repository/github/mmnaseri/tuples4j)
[![Coverage Status](https://coveralls.io/repos/github/mmnaseri/tuples4j/badge.svg)](https://coveralls.io/github/mmnaseri/tuples4j)
[![Coverage Status (coverity)](https://img.shields.io/coverity/scan/21090.svg)](https://scan.coverity.com/projects/mmnaseri-tuples4j)

---

A tiny library for working with [tuples](https://en.wikipedia.org/wiki/Tuple) as first-class citizens, in Java.

This library has been designed to play well with Java 8+'s collections and streams APIs and fits nicely into the
functional programming paradigm familiar to Java 8 developers.

This code is well tested, and is easy to parse.

## Getting Starting

To download the code and use it in your project, you can either clone this project and start using it:

    $ git clone https://github.com/mmnaseri/tuples4j.git

or you can add a maven dependency since it is now available in Maven central:

    <dependency>
        <groupId>com.mmnaseri.utils</groupId>
        <artifactId>tuples4j</artifactId>
        <version>${tuples4j.version}</version>
    </dependency>

To get started, use one of the many utility methods under the `Tuple` interface as the entrypoint:

```java
ThreeTuple<Object, Integer, String, Boolean> t = Tuple.three(1, "x", true);

// Or, if you prefer to get rid of the type-safety mechanism:
Tuple<?> t = Tuple.three(1, "x", true);
```

Tuples are immutable, so, feel free to pass them around:

```java
// Create a bunch of one-tuples.
Set<Tuple<?>> tuples = Stream.of(Tuple.of(1), Tuple.of(2))
    // Extend them each to two-tuples.
    .map(Tuple.extendOne("Hello")) // this is the same as: .map(t -> t.extend("Hello"))
    // Change the first element.
    .map(t -> t.first(Objects::toString))
    // Sort by the second element. 
    .sorted(Comparator.comparing(HasSecond::second))
    // Collect them all as a set.
    .collect(toSet());
```

## Features

### JDK 8-14 Compatible

This project is regular built against and tested with OpenJDK 8 - 14. Click on the build badge above to find out more.

### Tuple Sizes

This library offers a wide set of tuples, from size 0 (the *empty* tuple), to size 12 and beyond.

The build-in tuple sizes are:

  * `EmptyTuple`,
  * `OneTuple`,
  * `TwoTuple`, also available as `Pair` and `KeyValue`,
  * `ThreeTuple`,
  * `FourTuple`,
  * `FiveTuple`,
  * `SixTuple`,
  * `SevenTuple`,
  * `EightTuple`,
  * `NineTuple`,
  * `TenTuple`,
  * `ElevenTuple`,
  * `TwelveTuple`.

Beyond these, there is the `ThirteenOrMoreTuple` class which holds data for thirteen or more elements.

### Type-safe Elements

All elements are bound to an individual type argument, meaning that you can carry that type information
and will not need to cast the items to the actual types.

Moreover, each tuple type has a tightly bound, generically defined constructor and factory method, that
can be used if you want to enforce an upperbound on the datatypes. For instance, to create a number-only
three-tuple, you can write:

```java
ThreeTuple<Number, Integer, Double, Long> tuple = ThreeTuple.of(1, 1.2D, 3L);
```

### `equals`, `hashCode()`, and `toString()`

All tuples have their own implementation of these three basic methods. These are also well-tested
and you can consult the tests for examples.

For instance:

```java
Tuple.of(1, 2, 3).equals(Tuple.of(1, 2, 3, "a").dropFourth()) // => true
```

### Labeled Tuples

Some applications might require access to datum by labels. In this case, you can easily label your
tuples like so:

```java
LabeledTuple<?> t = Tuple.of("USA", 3.2).withLabels("country", "population");
System.out.println(t.get("population")); // => 3.2
```

### Named Accessors

All tuples which have a fixed dimension, have facades that allow named interactions. For instance,
a four-tuple, would implement all the facades for `HasFirst`, `HasSecond`, `HasThird`, and `HasFourth`.

This means that to get the second element in the tuple, instead of writing `tuple.get(1)`, you can
write `tuple.second()`. This also applies to changing values on the tuples. Instead of calling
`tuple.change(2, "a")`, you can write `tuple.third("a")`. Not only is this syntax semantically
stronger, but also it can help preserve type arguments on the tuple itself.

## Reflective Access

The companion module `tuples4j-reflection` can be used to get tuples represented as classes:

```java
ReflectiveTuple<?> reflectiveTuple = ReflectiveTuple.of(tuple);
Customer customer = reflectiveTuple.as(Customer.class);
String name = customer.name();
BigDecimal income = customer.income();
```

You can do all sorts of customizations in how a value is read from the tuple and conveyed as a method's return value:

```java
public interface Customer {

  String name();
  
  BigDecimal income();
  
  State state();

  @Provided(by = IncomeBracketProvider.class)
  IncomeBracket incomeBracket();
  
  double raise();
  
  default nextYearIncome() {
    return income().multiply(raise());
  }
  
  enum State {
    TX, WA, CA, OR
  }

}
```

Look at [tuples4j-reflection/~/test/~/model/Country.java](https://github.com/mmnaseri/tuples4j/blob/master/tuples4j-reflection/src/test/java/com/mmnaseri/utils/tuples/model/Country.java) for a better example of the sort of things you can do with the reflective code.

### Using the Reflection Module

To use the reflection module, get yourself a copy by either cloning this project or using Maven:

    <dependency>
        <groupId>com.mmnaseri.utils</groupId>
        <artifactId>tuples4j-reflection</artifactId>
        <version>${tuples4j.version}</version>
    </dependency>

## Building and Contributing

Contributions are more than welcome :)

To build the code and/or to contribute, you can use the provided `Dockerfile` image. This image sets up an Ubuntu Bionic (18.04 LTS) with OpenJDK 8. This is the minimum required environment for the project to work.

You can get a working Docker image by running:

```bash
docker build -t tuples4j:jdk8 .
docker run -it tuples4j:jdk8
```

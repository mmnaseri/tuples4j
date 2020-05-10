package com.mmnaseri.utils.tuples.reflection.impl;

import com.mmnaseri.utils.tuples.Tuple;
import com.mmnaseri.utils.tuples.annotations.AtIndex;
import com.mmnaseri.utils.tuples.annotations.WithLabel;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class AnnotationInvocationElementResolverTest {

  private AnnotationInvocationElementResolver resolver;

  @BeforeMethod
  public void setUp() {
    resolver = new AnnotationInvocationElementResolver();
  }

  @Test
  public void testResolvingToNonAnnotatedMethodWhenTupleIsNotLabeled() throws Exception {
    int index = resolver.resolve(Tuple.of("notAnnotated"), invocation("notAnnotated"));
    assertThat(index, is(-1));
  }

  @Test
  public void testResolvingToNonAnnotatedMethodWhenTupleIsNtLabeled() throws Exception {
    int index =
        resolver.resolve(Tuple.of("abc").withLabels("notAnnotated"), invocation("notAnnotated"));
    assertThat(index, is(0));
  }

  @Test(
      expectedExceptions = IllegalStateException.class,
      expectedExceptionsMessageRegExp =
          ".*@WithLabel, however, the reference tuple does not have labels.")
  public void testResolvingAnnotatedWithLabelWhenTupleIsNotLabeled() throws Exception {
    resolver.resolve(Tuple.of(1, 2, 3), invocation("annotatedWithLabel"));
  }

  @Test
  public void testResolvingAnnotatedWithLabelWhenTupleIsLabeled() throws Exception {
    int index =
        resolver.resolve(
            Tuple.of(1, 2, 3).withLabels("x", "my_label", "z"), invocation("annotatedWithLabel"));
    assertThat(index, is(1));
  }

  @Test
  public void testResolvingAnnotatedWithIndex() throws Exception {
    int index = resolver.resolve(Tuple.of(), invocation("annotatedWithIndex"));

    // The resolver will not do range checking. It will just return whatever the annotation
    // indicates.
    assertThat(index, is(0));
  }

  private ImmutableMethodInvocation invocation(final String name) throws NoSuchMethodException {
    return new ImmutableMethodInvocation(
            new Object(), new Object[0], Sample.class.getDeclaredMethod(name), Object.class);
  }

  private interface Sample {

    Object notAnnotated();

    @WithLabel("my_label")
    Object annotatedWithLabel();

    @AtIndex(0)
    Object annotatedWithIndex();
  }
}

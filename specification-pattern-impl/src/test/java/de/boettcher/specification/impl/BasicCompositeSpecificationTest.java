package de.boettcher.specification.impl;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

import de.boettcher.specification.api.CompositeSpecification;

public class BasicCompositeSpecificationTest {

    @Test
    public void testIsSatisfiedBy_True() throws Exception {
        final BasicCompositeSpecification<Object> basicCompositeSpecification = new BasicCompositeSpecification<>(t -> true);
        final boolean satisfiedBy = basicCompositeSpecification.isSatisfiedBy("");

        assertThat(satisfiedBy).isTrue();
    }

    @Test
    public void testIsSatisfiedBy_TrueBecauseInitialAndAndClauseIsTrueToo() throws Exception {
        final BasicCompositeSpecification<Object> basicCompositeSpecification = new BasicCompositeSpecification<>(t -> true);
        basicCompositeSpecification.and(t -> true);
        final boolean satisfiedBy = basicCompositeSpecification.isSatisfiedBy("");

        assertThat(satisfiedBy).isTrue();
    }

    @Test
    public void testIsSatisfiedBy_TrueBecauseInitialAndOrClauseIsTrueToo() throws Exception {
        final BasicCompositeSpecification<Object> basicCompositeSpecification = new BasicCompositeSpecification<>(t -> true);
        basicCompositeSpecification.or(t -> true);
        final boolean satisfiedBy = basicCompositeSpecification.isSatisfiedBy("");

        assertThat(satisfiedBy).isTrue();
    }

    @Test
    public void testIsSatisfiedBy_TrueBecauseInitialIsTrueAndOrClauseIsFalse() throws Exception {
        final BasicCompositeSpecification<Object> basicCompositeSpecification = new BasicCompositeSpecification<>(t -> true);
        basicCompositeSpecification.or(t -> false);
        final boolean satisfiedBy = basicCompositeSpecification.isSatisfiedBy("");

        assertThat(satisfiedBy).isTrue();
    }

    @Test
    public void testIsSatisfiedBy_False() throws Exception {
        final BasicCompositeSpecification<Object> basicCompositeSpecification = new BasicCompositeSpecification<>(t -> false);
        final boolean satisfiedBy = basicCompositeSpecification.isSatisfiedBy("");

        assertThat(satisfiedBy).isFalse();
    }

    @Test
    public void testIsSatisfiedBy_FalseBecauseInitialAndAndClauseIsFalseToo() throws Exception {
        final BasicCompositeSpecification<Object> basicCompositeSpecification = new BasicCompositeSpecification<>(t -> false);
        final CompositeSpecification<Object> andSpecification = basicCompositeSpecification.and(t -> false);
        final boolean satisfiedBy = andSpecification.isSatisfiedBy("");

        assertThat(satisfiedBy).isFalse();
    }

    @Test
    public void testAnd_CompositeSpecification() throws Exception {
        final BasicCompositeSpecification<String> specification1 = new BasicCompositeSpecification<>(t -> true);
        final BasicCompositeSpecification<String> specification2 = new BasicCompositeSpecification<>(t -> true);

        final CompositeSpecification<String> compositeSpecification = specification1.and(specification2);

        assertThat(compositeSpecification).isInstanceOf(BasicCompositeSpecification.class);
    }

    @SuppressWarnings("unchecked")
    @Test
    public void testAnd_2SpecifcationsInAnd() throws Exception {
        final BasicCompositeSpecification<String> specification1 = new BasicCompositeSpecification<>(t -> true);
        final BasicCompositeSpecification<String> specification2 = new BasicCompositeSpecification<>(t -> true);

        final BasicCompositeSpecification<String> compositeSpecification = (BasicCompositeSpecification<String>) specification1.and(specification2);

        assertThat(compositeSpecification.getAndSpecifications()).contains(specification1);
        assertThat(compositeSpecification.getAndSpecifications()).contains(specification2);
    }

    @Test
    public void testOr_CompositeSpecification() throws Exception {
        final BasicCompositeSpecification<String> specification1 = new BasicCompositeSpecification<>(t -> true);
        final BasicCompositeSpecification<String> specification2 = new BasicCompositeSpecification<>(t -> true);

        final CompositeSpecification<String> compositeSpecification = specification1.or(specification2);

        assertThat(compositeSpecification).isInstanceOf(BasicCompositeSpecification.class);
    }

    @SuppressWarnings("unchecked")
    @Test
    public void testOr_2SpecifcationsInOr() throws Exception {
        final BasicCompositeSpecification<String> specification1 = new BasicCompositeSpecification<>(t -> true);
        final BasicCompositeSpecification<String> specification2 = new BasicCompositeSpecification<>(t -> true);

        final BasicCompositeSpecification<String> compositeSpecification = (BasicCompositeSpecification<String>) specification1.or(specification2);

        assertThat(compositeSpecification.getOrSpecifications()).contains(specification1);
        assertThat(compositeSpecification.getOrSpecifications()).contains(specification2);
    }

}

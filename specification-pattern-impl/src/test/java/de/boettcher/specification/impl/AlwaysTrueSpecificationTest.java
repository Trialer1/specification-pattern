package de.boettcher.specification.impl;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class AlwaysTrueSpecificationTest {

    @Test
    public void testIsSatisfiedBy_True() throws Exception {
        final AlwaysTrueSpecification<Object> alwaysTrueSpecification = new AlwaysTrueSpecification<>();
        final boolean satisfiedBy = alwaysTrueSpecification.isSatisfiedBy("");

        assertThat(satisfiedBy).isTrue();
    }

}

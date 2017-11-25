package de.boettcher.specification.impl;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class AlwaysFalseSpecificationTest {

    @Test
    public void testIsSatisfiedBy_False() {
        final AlwaysFalseSpecification<Object> alwaysFalseSpecification = new AlwaysFalseSpecification<>();
        final boolean satisfiedBy = alwaysFalseSpecification.isSatisfiedBy("");

        assertThat(satisfiedBy).isFalse();
    }

}

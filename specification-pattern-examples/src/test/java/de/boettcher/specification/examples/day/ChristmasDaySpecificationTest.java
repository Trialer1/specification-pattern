package de.boettcher.specification.examples.day;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class ChristmasDaySpecificationTest {

    @Test
    public void testIsSatisfiedBy_TrueForDecember24th() throws Exception {
        final Day december24th = new Day("Friday", 24, 12, 0);

        final ChristmasDaySpecification christmasDaySpecification = new ChristmasDaySpecification();
        final boolean satisfiedBy = christmasDaySpecification.isSatisfiedBy(december24th);

        assertThat(satisfiedBy).isTrue();
    }

    @Test
    public void testIsSatisfiedBy_FalseForDecember1st() throws Exception {
        final Day december24th = new Day("Friday", 1, 12, 0);

        final ChristmasDaySpecification christmasDaySpecification = new ChristmasDaySpecification();
        final boolean satisfiedBy = christmasDaySpecification.isSatisfiedBy(december24th);

        assertThat(satisfiedBy).isFalse();
    }

}

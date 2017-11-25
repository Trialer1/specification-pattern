package de.boettcher.specification.examples.day;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class SaturdayDaySpecificationTest {

    @Test
    public void testIsSatisfiedBy_TrueBecauseNameIsSaturday() throws Exception {
        final Day day = new Day("Saturday", 0, 0, 0);

        final SaturdayDaySpecification saturdayDaySpecification = new SaturdayDaySpecification();
        final boolean satisfiedBy = saturdayDaySpecification.isSatisfiedBy(day);

        assertThat(satisfiedBy).isTrue();
    }

    @Test
    public void testIsSatisfiedBy_FalseBecauseNameIsMonday() throws Exception {
        final Day day = new Day("Monday", 0, 0, 0);

        final SaturdayDaySpecification saturdayDaySpecification = new SaturdayDaySpecification();
        final boolean satisfiedBy = saturdayDaySpecification.isSatisfiedBy(day);

        assertThat(satisfiedBy).isFalse();
    }

}

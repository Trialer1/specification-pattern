package de.boettcher.specification.examples.day;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class SundayDaySpecificationTest {

    @Test
    public void testIsSatisfiedBy_TrueBecauseNameIsSaturday() throws Exception {
        final Day day = new Day("Sunday", 0, 0, 0);

        final SundayDaySpecification sundayDaySpecification = new SundayDaySpecification();
        final boolean satisfiedBy = sundayDaySpecification.isSatisfiedBy(day);

        assertThat(satisfiedBy).isTrue();
    }

    @Test
    public void testIsSatisfiedBy_FalseBecauseNameIsMonday() throws Exception {
        final Day day = new Day("Monday", 0, 0, 0);

        final SundayDaySpecification sundayDaySpecification = new SundayDaySpecification();
        final boolean satisfiedBy = sundayDaySpecification.isSatisfiedBy(day);

        assertThat(satisfiedBy).isFalse();
    }

}

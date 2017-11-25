package de.boettcher.specification.examples.day;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class BusinessDayDaySpecificationTest {

    @Test
    public void testIsSatisfiedBy_TrueForMonday() throws Exception {
        final Day saturday = new Day("Monday", 1, 1, 1);

        final BusinessDayDaySpecification businessDayDaySpecification = new BusinessDayDaySpecification();
        final boolean satisfiedBy = businessDayDaySpecification.isSatisfiedBy(saturday);

        assertThat(satisfiedBy).isTrue();
    }

    @Test
    public void testIsSatisfiedBy_TrueForTuesday() throws Exception {
        final Day saturday = new Day("Tuesday", 1, 1, 1);

        final BusinessDayDaySpecification businessDayDaySpecification = new BusinessDayDaySpecification();
        final boolean satisfiedBy = businessDayDaySpecification.isSatisfiedBy(saturday);

        assertThat(satisfiedBy).isTrue();
    }

    @Test
    public void testIsSatisfiedBy_TrueForWednesday() throws Exception {
        final Day saturday = new Day("Wednesday", 1, 1, 1);

        final BusinessDayDaySpecification businessDayDaySpecification = new BusinessDayDaySpecification();
        final boolean satisfiedBy = businessDayDaySpecification.isSatisfiedBy(saturday);

        assertThat(satisfiedBy).isTrue();
    }

    @Test
    public void testIsSatisfiedBy_TrueForThursday() throws Exception {
        final Day saturday = new Day("Thursday", 1, 1, 1);

        final BusinessDayDaySpecification businessDayDaySpecification = new BusinessDayDaySpecification();
        final boolean satisfiedBy = businessDayDaySpecification.isSatisfiedBy(saturday);

        assertThat(satisfiedBy).isTrue();
    }

    @Test
    public void testIsSatisfiedBy_TrueForFriday() throws Exception {
        final Day saturday = new Day("Friday", 1, 1, 1);

        final BusinessDayDaySpecification businessDayDaySpecification = new BusinessDayDaySpecification();
        final boolean satisfiedBy = businessDayDaySpecification.isSatisfiedBy(saturday);

        assertThat(satisfiedBy).isTrue();
    }

    @Test
    public void testIsSatisfiedBy_FalseForSaturday() throws Exception {
        final Day saturday = new Day("Saturday", 1, 1, 1);

        final BusinessDayDaySpecification businessDayDaySpecification = new BusinessDayDaySpecification();
        final boolean satisfiedBy = businessDayDaySpecification.isSatisfiedBy(saturday);

        assertThat(satisfiedBy).isFalse();
    }

    @Test
    public void testIsSatisfiedBy_FalseForSunday() throws Exception {
        final Day saturday = new Day("Sunday", 1, 1, 1);

        final BusinessDayDaySpecification businessDayDaySpecification = new BusinessDayDaySpecification();
        final boolean satisfiedBy = businessDayDaySpecification.isSatisfiedBy(saturday);

        assertThat(satisfiedBy).isFalse();
    }

}

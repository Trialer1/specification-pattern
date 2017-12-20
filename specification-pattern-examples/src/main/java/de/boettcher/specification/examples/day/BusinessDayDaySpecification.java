package de.boettcher.specification.examples.day;

/**
 * {@link DaySpecification} for business days. All days except Saturday and Sunday are business days.
 */
public class BusinessDayDaySpecification extends DaySpecification {

    protected BusinessDayDaySpecification() {
        super(new SaturdayDaySpecification().not().and(new SundayDaySpecification().not()));
    }

}

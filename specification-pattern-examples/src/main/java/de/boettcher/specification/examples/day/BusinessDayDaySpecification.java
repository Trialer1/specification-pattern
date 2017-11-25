package de.boettcher.specification.examples.day;

import de.boettcher.specification.impl.NotSpecification;

/**
 * {@link DaySpecification} for business days. All days except Saturday and Sunday are business days.
 */
public class BusinessDayDaySpecification extends DaySpecification {

    protected BusinessDayDaySpecification() {
        super(new NotSpecification<>(new SaturdayDaySpecification()).and(new NotSpecification<>(new SundayDaySpecification())));
    }

}

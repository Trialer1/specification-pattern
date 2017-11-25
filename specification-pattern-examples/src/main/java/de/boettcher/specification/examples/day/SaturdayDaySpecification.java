package de.boettcher.specification.examples.day;

/**
 * {@link DaySpecification} for Saturdays.
 */
public class SaturdayDaySpecification extends DaySpecification {

    protected SaturdayDaySpecification() {
        super(day -> {
            final String name = day.getName();

            final boolean saturday = name.equals("Saturday");

            return saturday;
        });
    }

}

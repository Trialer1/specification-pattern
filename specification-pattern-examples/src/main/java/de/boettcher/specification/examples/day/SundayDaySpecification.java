package de.boettcher.specification.examples.day;

/**
 * {@link DaySpecification} for Sundays.
 */
public class SundayDaySpecification extends DaySpecification {

    protected SundayDaySpecification() {
        super(day -> {
            final String name = day.getName();

            final boolean saturday = name.equals("Sunday");

            return saturday;
        });
    }

}

package de.boettcher.specification.examples.day;

/**
 * A day from a calendar.
 */
public class Day {

    private final String name;

    private final int day;

    private final int month;

    private final int year;

    public Day(final String name, final int day, final int month, final int year) {
        this.name = name;
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public String getName() {
        return this.name;
    }

    public int getDay() {
        return this.day;
    }

    public int getMonth() {
        return this.month;
    }

    public int getYear() {
        return this.year;
    }

}

package de.boettcher.specification.examples.day;

/**
 * {@link DaySpecification} for Christmas. Christmas is only on day {@value #CHRISTMAS_DAY} in month {@value #CHRISTMAS_MONTH}.
 */
public class ChristmasDaySpecification extends DaySpecification {

    private static final int CHRISTMAS_DAY = 24;

    private static final int CHRISTMAS_MONTH = 12;

    protected ChristmasDaySpecification() {
        super(day -> {
            final int dayNum = day.getDay();
            final int month = day.getMonth();

            final boolean christmas = dayNum == CHRISTMAS_DAY && month == CHRISTMAS_MONTH;

            return christmas;
        });
    }

}

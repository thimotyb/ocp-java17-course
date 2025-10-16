package ch04.examples;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.Period;

public final class DateTimePeriodExamples {

    private DateTimePeriodExamples() {
    }

    public static Period[] createPeriods() {
        var annual = Period.ofYears(1);
        var quarterly = Period.ofMonths(3);
        var everyThreeDays = Period.ofDays(3);
        var everyYearAndAWeek = Period.of(1, 0, 7);
        var wrong = Period.ofYears(1).ofWeeks(1);
        return new Period[] {annual, quarterly, everyThreeDays, everyYearAndAWeek, wrong};
    }

    public static Object[] addPeriodExamples() {
        var date = LocalDate.of(2022, Month.JANUARY, 20);
        var time = LocalTime.of(6, 15);
        var dateTime = LocalDateTime.of(date, time);
        var period = Period.ofMonths(1);
        return new Object[] {
                date.plus(period),
                dateTime.plus(period),
                catchException(() -> time.plus(period))
        };
    }

    private static Exception catchException(Runnable runnable) {
        try {
            runnable.run();
        } catch (Exception e) {
            return e;
        }
        return null;
    }
}

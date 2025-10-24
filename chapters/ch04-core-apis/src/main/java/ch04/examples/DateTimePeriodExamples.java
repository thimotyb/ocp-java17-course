package ch04.examples;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.Period;

/**
 * Demonstrates Period class for date-based amounts of time in Chapter 4: Core APIs.
 *
 * <p>From Chapter 4: Working with Periods</p>
 *
 * <p>Key concepts demonstrated:</p>
 * <ul>
 *   <li>Period represents date-based amount: years, months, days</li>
 *   <li>Factory methods: ofYears(), ofMonths(), ofWeeks(), ofDays(), of()</li>
 *   <li>Period is immutable - factory methods return new instances</li>
 *   <li>Chaining Period factory methods replaces rather than adds (common mistake!)</li>
 *   <li>ofWeeks() converts to days (1 week = 7 days)</li>
 *   <li>Period works with LocalDate and LocalDateTime, NOT LocalTime</li>
 *   <li>Adding Period to LocalTime throws UnsupportedTemporalTypeException</li>
 *   <li>Period is for date-based units; use Duration for time-based units</li>
 * </ul>
 *
 * @see java.time.Period
 * @see java.time.Duration
 */
public final class DateTimePeriodExamples {

    private DateTimePeriodExamples() {
    }

    /**
     * Demonstrates creating Period objects with various factory methods.
     *
     * <p>WARNING: Period is immutable. Chaining factory methods like
     * Period.ofYears(1).ofWeeks(1) does NOT combine them - the last call wins!</p>
     *
     * @return array of Period objects:
     *         [0] P1Y (1 year)
     *         [1] P3M (3 months)
     *         [2] P3D (3 days)
     *         [3] P1Y7D (1 year and 7 days)
     *         [4] P7D (only 1 week = 7 days, NOT 1 year + 1 week - common mistake!)
     */
    public static Period[] createPeriods() {
        var annual = Period.ofYears(1);              // P1Y
        var quarterly = Period.ofMonths(3);          // P3M
        var everyThreeDays = Period.ofDays(3);       // P3D
        var everyYearAndAWeek = Period.of(1, 0, 7);  // P1Y7D (years, months, days)
        // WRONG: This creates P7D (7 days), NOT P1Y7D!
        // Period is immutable - ofWeeks(1) returns new Period, discarding ofYears(1)
        var wrong = Period.ofYears(1).ofWeeks(1);    // P7D (only the last call matters!)
        return new Period[] {annual, quarterly, everyThreeDays, everyYearAndAWeek, wrong};
    }

    /**
     * Demonstrates adding Period to different date-time types.
     *
     * <p>Period represents date-based amounts (years, months, days).
     * It can be added to LocalDate and LocalDateTime, but NOT LocalTime.</p>
     *
     * @return array:
     *         [0] LocalDate - February 20, 2022 (January 20 + 1 month)
     *         [1] LocalDateTime - February 20, 2022 at 06:15
     *         [2] UnsupportedTemporalTypeException - cannot add Period to LocalTime
     */
    public static Object[] addPeriodExamples() {
        var date = LocalDate.of(2022, Month.JANUARY, 20);
        var time = LocalTime.of(6, 15);
        var dateTime = LocalDateTime.of(date, time);
        var period = Period.ofMonths(1);  // 1 month
        return new Object[] {
                date.plus(period),         // Works: LocalDate has date components
                dateTime.plus(period),     // Works: LocalDateTime has date components
                catchException(() -> time.plus(period))  // Exception: LocalTime has no date
        };
    }

    /**
     * Helper method to catch and return exceptions for demonstration purposes.
     *
     * @param runnable the code to execute
     * @return the exception thrown, or null if no exception
     */
    private static Exception catchException(Runnable runnable) {
        try {
            runnable.run();
        } catch (Exception e) {
            return e;  // Returns UnsupportedTemporalTypeException for time.plus(period)
        }
        return null;
    }
}

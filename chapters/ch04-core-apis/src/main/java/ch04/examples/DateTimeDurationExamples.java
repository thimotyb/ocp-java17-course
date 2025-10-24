package ch04.examples;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.temporal.ChronoUnit;

/**
 * Demonstrates Duration class for time-based amounts in Chapter 4: Core APIs.
 *
 * <p>From Chapter 4: Working with Durations</p>
 *
 * <p>Key concepts demonstrated:</p>
 * <ul>
 *   <li>Duration represents time-based amount: hours, minutes, seconds, nanoseconds</li>
 *   <li>Factory methods: ofDays(), ofHours(), ofMinutes(), ofSeconds(), ofMillis(), ofNanos()</li>
 *   <li>Duration works with LocalTime and LocalDateTime, NOT LocalDate</li>
 *   <li>Adding Duration to LocalDate throws UnsupportedTemporalTypeException</li>
 *   <li>ChronoUnit.between() calculates difference between temporal objects</li>
 *   <li>ChronoUnit provides time units: HOURS, MINUTES, SECONDS, etc.</li>
 *   <li>Duration is for time-based units; use Period for date-based units</li>
 *   <li>Duration can include days, but always represents a precise time amount (24h = 1 day)</li>
 * </ul>
 *
 * @see java.time.Duration
 * @see java.time.temporal.ChronoUnit
 * @see java.time.Period
 */
public final class DateTimeDurationExamples {

    private DateTimeDurationExamples() {
    }

    /**
     * Demonstrates creating Duration objects with various time units.
     *
     * <p>Duration represents precise time amounts suitable for LocalTime and LocalDateTime.
     * Can specify in days (24h), hours, minutes, seconds, milliseconds, or nanoseconds.</p>
     *
     * @return array of Duration objects:
     *         [0] PT24H (1 day = 24 hours)
     *         [1] PT1H (1 hour)
     *         [2] PT1M (1 minute)
     *         [3] PT10S (10 seconds)
     *         [4] PT0.001S (1 millisecond)
     *         [5] PT0.000000001S (1 nanosecond)
     */
    public static Duration[] createDurations() {
        var daily = Duration.ofDays(1);            // PT24H (24 hours)
        var hourly = Duration.ofHours(1);          // PT1H
        var everyMinute = Duration.ofMinutes(1);   // PT1M
        var everyTenSeconds = Duration.ofSeconds(10);  // PT10S
        var everyMilli = Duration.ofMillis(1);     // PT0.001S
        var everyNano = Duration.ofNanos(1);       // PT0.000000001S
        return new Duration[] {daily, hourly, everyMinute, everyTenSeconds, everyMilli, everyNano};
    }

    /**
     * Demonstrates ChronoUnit.between() to calculate time differences.
     *
     * <p>ChronoUnit provides temporal units (HOURS, MINUTES, SECONDS, etc.)
     * and can calculate the difference between two temporal objects.</p>
     *
     * @return [1, 75] - difference between 06:15 and 07:30
     *         1 hour or 75 minutes (1 hour 15 minutes)
     */
    public static long[] chronoUnitBetweenExample() {
        var one = LocalTime.of(6, 15);   // 06:15
        var two = LocalTime.of(7, 30);   // 07:30
        return new long[] {
                ChronoUnit.HOURS.between(one, two),    // 1 hour (truncates minutes)
                ChronoUnit.MINUTES.between(one, two)   // 75 minutes
        };
    }

    /**
     * Demonstrates adding Duration to different date-time types.
     *
     * <p>Duration represents time-based amounts (hours, minutes, seconds).
     * It can be added to LocalTime and LocalDateTime, but NOT LocalDate.</p>
     *
     * @return array:
     *         [0] LocalDateTime - January 20, 2022 at 12:15 (06:15 + 6 hours)
     *         [1] LocalTime - 12:15 (06:15 + 6 hours)
     *         [2] UnsupportedTemporalTypeException - cannot add Duration to LocalDate
     */
    public static Object[] addDurationExamples() {
        var date = LocalDate.of(2022, 1, 20);
        var time = LocalTime.of(6, 15);
        var dateTime = LocalDateTime.of(date, time);
        var duration = Duration.ofHours(6);  // 6 hours
        return new Object[] {
                dateTime.plus(duration),  // Works: LocalDateTime has time components
                time.plus(duration),      // Works: LocalTime is time-based
                catchException(() -> date.plus(duration))  // Exception: LocalDate has no time
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
            return e;  // Returns UnsupportedTemporalTypeException for date.plus(duration)
        }
        return null;
    }
}

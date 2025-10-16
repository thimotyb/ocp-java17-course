package ch04.examples;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.temporal.ChronoUnit;

public final class DateTimeDurationExamples {

    private DateTimeDurationExamples() {
    }

    public static Duration[] createDurations() {
        var daily = Duration.ofDays(1);
        var hourly = Duration.ofHours(1);
        var everyMinute = Duration.ofMinutes(1);
        var everyTenSeconds = Duration.ofSeconds(10);
        var everyMilli = Duration.ofMillis(1);
        var everyNano = Duration.ofNanos(1);
        return new Duration[] {daily, hourly, everyMinute, everyTenSeconds, everyMilli, everyNano};
    }

    public static long[] chronoUnitBetweenExample() {
        var one = LocalTime.of(6, 15);
        var two = LocalTime.of(7, 30);
        return new long[] {
                ChronoUnit.HOURS.between(one, two),
                ChronoUnit.MINUTES.between(one, two)
        };
    }

    public static Object[] addDurationExamples() {
        var date = LocalDate.of(2022, 1, 20);
        var time = LocalTime.of(6, 15);
        var dateTime = LocalDateTime.of(date, time);
        var duration = Duration.ofHours(6);
        return new Object[] {
                dateTime.plus(duration),
                time.plus(duration),
                catchException(() -> date.plus(duration))
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

package ch04.examples;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public final class DateTimeCreationExamples {

    private DateTimeCreationExamples() {
    }

    public static LocalDate[] createDates() {
        var date1 = LocalDate.of(2022, Month.JANUARY, 20);
        var date2 = LocalDate.of(2022, 1, 20);
        return new LocalDate[] {date1, date2};
    }

    public static LocalTime[] createTimes() {
        var time1 = LocalTime.of(6, 15);
        var time2 = LocalTime.of(6, 15, 30);
        var time3 = LocalTime.of(6, 15, 30, 200);
        return new LocalTime[] {time1, time2, time3};
    }

    public static LocalDateTime[] createDateTimes() {
        var date1 = LocalDate.of(2022, Month.JANUARY, 20);
        var time1 = LocalTime.of(6, 15);
        var dateTimeSeconds = LocalDateTime.of(2022, Month.JANUARY, 20, 6, 15, 30);
        var dateTimeBase = LocalDateTime.of(date1, time1);
        return new LocalDateTime[] {dateTimeSeconds, dateTimeBase};
    }

    public static ZonedDateTime[] createZonedDateTimes() {
        var zone = ZoneId.of("US/Eastern");
        var date1 = LocalDate.of(2022, Month.JANUARY, 20);
        var time1 = LocalTime.of(6, 15);
        var dateTimeSeconds = LocalDateTime.of(2022, Month.JANUARY, 20, 6, 15, 30);
        var zoned1 = ZonedDateTime.of(2022, 1, 20, 6, 15, 30, 200, zone);
        var zoned2 = ZonedDateTime.of(date1, time1, zone);
        var zoned3 = ZonedDateTime.of(dateTimeSeconds, zone);
        return new ZonedDateTime[] {zoned1, zoned2, zoned3};
    }
}

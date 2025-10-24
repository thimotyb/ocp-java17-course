package ch04.examples;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.ZoneId;
import java.time.ZonedDateTime;

/**
 * Demonstrates Date-Time API object creation covered in Chapter 4: Core APIs.
 *
 * <p>From Chapter 4: Working with Dates and Times</p>
 *
 * <p>Key concepts demonstrated:</p>
 * <ul>
 *   <li>LocalDate - date without time or time zone (year, month, day)</li>
 *   <li>LocalTime - time without date or time zone (hour, minute, second, nanosecond)</li>
 *   <li>LocalDateTime - date and time without time zone</li>
 *   <li>ZonedDateTime - date, time, and time zone</li>
 *   <li>Month enum vs. int for months (Month.JANUARY == 1)</li>
 *   <li>Factory methods: of() creates instances (no public constructors)</li>
 *   <li>Combining date and time objects to create LocalDateTime and ZonedDateTime</li>
 *   <li>All date-time classes are immutable</li>
 * </ul>
 *
 * @see java.time.LocalDate
 * @see java.time.LocalTime
 * @see java.time.LocalDateTime
 * @see java.time.ZonedDateTime
 */
public final class DateTimeCreationExamples {

    private DateTimeCreationExamples() {
    }

    /**
     * Demonstrates creating LocalDate objects.
     *
     * <p>LocalDate represents a date without time or time zone.
     * Two ways to specify month: Month enum or int (1-12).</p>
     *
     * @return two identical LocalDate objects for January 20, 2022
     */
    public static LocalDate[] createDates() {
        var date1 = LocalDate.of(2022, Month.JANUARY, 20);  // Using Month enum
        var date2 = LocalDate.of(2022, 1, 20);               // Using int (1 = January)
        return new LocalDate[] {date1, date2};
    }

    /**
     * Demonstrates creating LocalTime objects with different precisions.
     *
     * <p>LocalTime represents time without date or time zone.
     * Can specify: hour+minute, hour+minute+second, or hour+minute+second+nanosecond.</p>
     *
     * @return three LocalTime objects with increasing precision
     */
    public static LocalTime[] createTimes() {
        var time1 = LocalTime.of(6, 15);              // 06:15 (hour, minute)
        var time2 = LocalTime.of(6, 15, 30);          // 06:15:30 (hour, minute, second)
        var time3 = LocalTime.of(6, 15, 30, 200);     // 06:15:30.000000200 (+ nanoseconds)
        return new LocalTime[] {time1, time2, time3};
    }

    /**
     * Demonstrates creating LocalDateTime objects.
     *
     * <p>LocalDateTime combines date and time without time zone.
     * Can be created from individual components or by combining LocalDate and LocalTime.</p>
     *
     * @return two LocalDateTime objects created different ways
     */
    public static LocalDateTime[] createDateTimes() {
        var date1 = LocalDate.of(2022, Month.JANUARY, 20);
        var time1 = LocalTime.of(6, 15);
        // Method 1: Specify all components at once
        var dateTimeSeconds = LocalDateTime.of(2022, Month.JANUARY, 20, 6, 15, 30);
        // Method 2: Combine existing LocalDate and LocalTime
        var dateTimeBase = LocalDateTime.of(date1, time1);
        return new LocalDateTime[] {dateTimeSeconds, dateTimeBase};
    }

    /**
     * Demonstrates creating ZonedDateTime objects.
     *
     * <p>ZonedDateTime includes date, time, and time zone.
     * Can be created from components or by adding zone to existing LocalDate/LocalDateTime.</p>
     *
     * @return three ZonedDateTime objects in US/Eastern time zone
     */
    public static ZonedDateTime[] createZonedDateTimes() {
        var zone = ZoneId.of("US/Eastern");  // Time zone identifier
        var date1 = LocalDate.of(2022, Month.JANUARY, 20);
        var time1 = LocalTime.of(6, 15);
        var dateTimeSeconds = LocalDateTime.of(2022, Month.JANUARY, 20, 6, 15, 30);

        // Method 1: Specify all components including nanoseconds and zone
        var zoned1 = ZonedDateTime.of(2022, 1, 20, 6, 15, 30, 200, zone);
        // Method 2: Combine LocalDate, LocalTime, and ZoneId
        var zoned2 = ZonedDateTime.of(date1, time1, zone);
        // Method 3: Add zone to existing LocalDateTime
        var zoned3 = ZonedDateTime.of(dateTimeSeconds, zone);

        return new ZonedDateTime[] {zoned1, zoned2, zoned3};
    }
}

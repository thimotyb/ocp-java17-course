package ch04.examples;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;

import org.junit.jupiter.api.Test;

class DateTimeExamplesTest {

    @Test
    void createDatesTimesAndZones() {
        var dates = DateTimeCreationExamples.createDates();
        assertEquals(LocalDate.of(2022, Month.JANUARY, 20), dates[0]);
        assertEquals(LocalDate.of(2022, Month.JANUARY, 20), dates[1]);

        var times = DateTimeCreationExamples.createTimes();
        assertEquals(LocalTime.of(6, 15), times[0]);
        assertEquals(LocalTime.of(6, 15, 30), times[1]);
        assertEquals(LocalTime.of(6, 15, 30, 200), times[2]);

        var dateTimes = DateTimeCreationExamples.createDateTimes();
        assertEquals(LocalDateTime.of(2022, Month.JANUARY, 20, 6, 15, 30), dateTimes[0]);
        assertEquals(LocalDateTime.of(2022, Month.JANUARY, 20, 6, 15), dateTimes[1]);

        var zone = ZoneId.of("US/Eastern");
        ZonedDateTime[] zoned = DateTimeCreationExamples.createZonedDateTimes();
        for (ZonedDateTime z : zoned) {
            assertEquals(zone, z.getZone());
        }
    }

    @Test
    void periodExamplesMatchDescriptions() {
        Period[] periods = DateTimePeriodExamples.createPeriods();
        assertEquals(Period.ofYears(1), periods[0]);
        assertEquals(Period.ofMonths(3), periods[1]);
        assertEquals(Period.ofDays(3), periods[2]);
        assertEquals(Period.of(1, 0, 7), periods[3]);
        assertEquals(Period.ofWeeks(1), periods[4]);

        Object[] results = DateTimePeriodExamples.addPeriodExamples();
        assertEquals(LocalDate.of(2022, Month.FEBRUARY, 20), results[0]);
        assertEquals(LocalDateTime.of(2022, Month.FEBRUARY, 20, 6, 15), results[1]);
        assertTrue(results[2] instanceof Exception);
    }

    @Test
    void durationExamplesMatchDescriptions() {
        Duration[] durations = DateTimeDurationExamples.createDurations();
        assertEquals(Duration.ofDays(1), durations[0]);
        assertEquals(Duration.ofHours(1), durations[1]);
        assertEquals(Duration.ofMinutes(1), durations[2]);
        assertEquals(Duration.ofSeconds(10), durations[3]);
        assertEquals(Duration.ofMillis(1), durations[4]);
        assertEquals(Duration.ofNanos(1), durations[5]);

        long[] between = DateTimeDurationExamples.chronoUnitBetweenExample();
        assertEquals(1, between[0]);
        assertEquals(75, between[1]);

        Object[] additions = DateTimeDurationExamples.addDurationExamples();
        assertEquals(LocalDateTime.of(2022, Month.JANUARY, 20, 12, 15), additions[0]);
        assertEquals(LocalTime.of(12, 15), additions[1]);
        assertTrue(additions[2] instanceof Exception);
    }
}

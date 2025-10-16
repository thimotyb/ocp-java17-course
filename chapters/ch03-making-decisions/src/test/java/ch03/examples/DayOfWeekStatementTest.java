package ch03.examples;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.Test;

class DayOfWeekStatementTest {

    @Test
    void printsValidDay() {
        assertPrinted("Sunday", () -> DayOfWeekStatement.printDayOfWeek(0));
    }

    @Test
    void printsInvalidForUnknownValue() {
        assertPrinted("Invalid value", () -> DayOfWeekStatement.printDayOfWeek(10));
    }

    private static void assertPrinted(String expected, Runnable action) {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream original = System.out;
        System.setOut(new PrintStream(out));
        try {
            action.run();
        } finally {
            System.setOut(original);
        }
        assertEquals(expected, out.toString());
    }
}

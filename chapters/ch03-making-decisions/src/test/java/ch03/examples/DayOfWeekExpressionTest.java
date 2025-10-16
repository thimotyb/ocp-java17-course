package ch03.examples;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.Test;

class DayOfWeekExpressionTest {

    @Test
    void evaluatesSwitchExpression() {
        assertPrintedAndReturned(1, "Monday");
    }

    @Test
    void handlesDefaultBranch() {
        assertPrintedAndReturned(9, "Invalid value");
    }

    private static void assertPrintedAndReturned(int day, String expected) {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream original = System.out;
        System.setOut(new PrintStream(out));
        String result;
        try {
            result = DayOfWeekExpression.printDayOfWeek(day);
        } finally {
            System.setOut(original);
        }
        assertEquals(expected, result);
        assertEquals(expected, out.toString());
    }
}

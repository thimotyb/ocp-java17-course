package ch03.examples;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.Test;

class CleaningScheduleTest {

    @Test
    void continueWithLabelSkipsStableBAndLeopardTwo() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream original = System.out;
        System.setOut(new PrintStream(out));
        try {
            CleaningSchedule.main(new String[0]);
        } finally {
            System.setOut(original);
        }
        String expected = String.join(System.lineSeparator(),
                "Cleaning: a,1",
                "Cleaning: c,1",
                "Cleaning: d,1") + System.lineSeparator();
        assertEquals(expected, out.toString());
    }
}

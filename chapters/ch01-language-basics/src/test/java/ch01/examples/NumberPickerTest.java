package ch01.examples;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.Test;

class NumberPickerTest {

    @Test
    void printsRandomDigitBetweenZeroAndNine() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream original = System.out;
        System.setOut(new PrintStream(out));
        try {
            NumberPicker.main(new String[0]);
        } finally {
            System.setOut(original);
        }
        String output = out.toString().trim();
        int value = Integer.parseInt(output);
        assertTrue(value >= 0 && value < 10, "value should be between 0 and 9");
    }
}

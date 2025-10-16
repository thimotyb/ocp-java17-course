package ch03.examples;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.Test;

class FindInMatrixTest {

    @Test
    void breakWithLabelStopsAfterFirstMatch() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream original = System.out;
        System.setOut(new PrintStream(out));
        try {
            FindInMatrix.main(new String[0]);
        } finally {
            System.setOut(original);
        }
        assertEquals("Value 2 found at: (1,1)" + System.lineSeparator(), out.toString());
    }
}

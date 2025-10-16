package ch03.examples;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.Test;

class PrintIntegersTest {

    @Test
    void doWhileLoopsUntilConditionFails() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream original = System.out;
        System.setOut(new PrintStream(out));
        try {
            PrintIntegers.main(new String[0]);
        } finally {
            System.setOut(original);
        }
        assertEquals("-1 0 1 2 3 4 5 6 ", out.toString());
    }
}

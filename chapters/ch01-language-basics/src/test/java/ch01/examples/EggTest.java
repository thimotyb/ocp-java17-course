package ch01.examples;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.Test;

class EggTest {

    @Test
    void constructorAndInitializersRunInOrder() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream original = System.out;
        System.setOut(new PrintStream(out));
        try {
            Egg.main(new String[0]);
        } finally {
            System.setOut(original);
        }
        assertEquals("5" + System.lineSeparator(), out.toString());
    }
}

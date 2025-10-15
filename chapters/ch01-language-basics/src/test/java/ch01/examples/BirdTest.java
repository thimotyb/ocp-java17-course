package ch01.examples;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.Test;

class BirdTest {

    @Test
    void mainPrintsFeathers() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream original = System.out;
        System.setOut(new PrintStream(out));
        try {
            Bird.main(new String[0]);
        } finally {
            System.setOut(original);
        }
        assertEquals("Feathers" + System.lineSeparator(), out.toString());
    }

    @Test
    void instanceInitializerPrintsSnowyWhenObjectCreated() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream original = System.out;
        System.setOut(new PrintStream(out));
        try {
            new Bird();
        } finally {
            System.setOut(original);
        }
        assertEquals("Snowy" + System.lineSeparator(), out.toString());
    }
}

package ch01.examples;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.Test;

class ZooTest {

    @Test
    void printsHelloWorld() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream original = System.out;
        System.setOut(new PrintStream(out));
        try {
            Zoo.main(new String[0]);
        } finally {
            System.setOut(original);
        }
        assertEquals("Hello World" + System.lineSeparator(), out.toString());
    }

    @Test
    void printsArgumentsInOrder() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream original = System.out;
        System.setOut(new PrintStream(out));
        try {
            ZooArguments.main(new String[] {"Bronx", "Zoo"});
        } finally {
            System.setOut(original);
        }
        assertEquals("Bronx" + System.lineSeparator() + "Zoo" + System.lineSeparator(), out.toString());
    }
}

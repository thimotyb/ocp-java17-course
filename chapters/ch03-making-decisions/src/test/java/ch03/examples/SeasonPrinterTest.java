package ch03.examples;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.Test;

class SeasonPrinterTest {

    @Test
    void printsSeasonUsingSwitchExpression() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream original = System.out;
        System.setOut(new PrintStream(out));
        try {
            SeasonPrinter.printSeason(2);
        } finally {
            System.setOut(original);
        }
        assertEquals("Winter", out.toString());
    }
}

package ch01.examples;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.Test;

class ZooVarTest {

    @Test
    void printsValuesInferredWithVar() {
        ZooVar zooVar = new ZooVar();
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream original = System.out;
        System.setOut(new PrintStream(out));
        try {
            zooVar.whatTypeAmI();
        } finally {
            System.setOut(original);
        }
        assertEquals("Hello 7" + System.lineSeparator(), out.toString());
    }
}

package it.tb.ocp.ch01;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class TextBlocksTest {
    @Test
    void tripleQuotesKeepNewlines() {
        String tb = """
                line1
                line2
                """;
        assertTrue(tb.contains("\n"));
        assertTrue(tb.startsWith("line1"));
    }
}

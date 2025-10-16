package ch04.examples;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class StringStripExamplesTest {

    @Test
    void stripMethodsMatchBookOutputs() {
        assertEquals("abc", StringStripExamples.strip("abc"));
        assertEquals("a b c", StringStripExamples.strip("\t   a b c\n"));
        String text = " abc\t ";
        assertEquals(3, StringStripExamples.trimmedLength(text));
        assertEquals(3, StringStripExamples.strippedLength(text));
        assertEquals(5, StringStripExamples.stripLeadingLength(text));
        assertEquals(4, StringStripExamples.stripTrailingLength(text));
    }
}

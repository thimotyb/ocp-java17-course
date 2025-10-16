package ch04.examples;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class StringIndentExamplesTest {

    @Test
    void indentAndStripIndentLengthsMatchBook() {
        assertEquals(6, StringIndentExamples.blockLength());
        assertEquals(9, StringIndentExamples.concatLength());
        assertEquals(10, StringIndentExamples.blockIndentLength(1));
        assertEquals(7, StringIndentExamples.concatIndentLength(-1));
        assertEquals(6, StringIndentExamples.concatIndentLength(-4));
        assertEquals(6, StringIndentExamples.concatStripIndentLength());
    }
}

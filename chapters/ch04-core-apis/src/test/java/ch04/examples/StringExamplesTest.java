package ch04.examples;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class StringExamplesTest {

    @Test
    void concatenationOutputsMatchBook() {
        assertArrayEquals(new String[] {"3", "ab", "ab3", "3c", "c12", "cnull"},
                StringExamples.concatenationOutputs());
        assertEquals("64", StringExamples.concatenationWithVariables());
        assertEquals("123", StringExamples.compoundAssignment());
    }

    @Test
    void stringMethodsBehaveAsDocumented() {
        assertEquals(7, StringExamples.lengthAnimals());
        assertEquals('a', StringExamples.charAt(0));
        assertEquals('s', StringExamples.charAt(6));
        assertEquals(0, StringExamples.indexOfExample('a'));
        assertEquals(4, StringExamples.indexOfExample("al"));
        assertEquals(4, StringExamples.indexOfExample('a', 4));
        assertEquals(-1, StringExamples.indexOfExample("al", 5));
        assertEquals("mals", StringExamples.substringFrom(3));
        assertEquals("mals", StringExamples.substringFrom(StringExamples.indexOfExample('m')));
        assertEquals("m", StringExamples.substringRange(3, 4));
        assertEquals("mals", StringExamples.substringRange(3, 7));
        assertEquals("ANIMALS", StringExamples.animalsToUpper());
        assertEquals("abc123", StringExamples.mixedToLower());
    }

    @Test
    void equalityAndContainment() {
        assertTrue(StringExamples.equalsExample("abc"));
        assertTrue(StringExamples.equalsIgnoreCaseExample("ABC"));
        assertTrue(StringExamples.startsWithExample("a"));
        assertTrue(StringExamples.endsWithExample("c"));
        assertTrue(StringExamples.containsExample("b"));
        assertEquals("AbcAbc", StringExamples.replaceExample('a', 'A'));
        assertEquals("AbcAbc", StringExamples.replaceExample("a", "A"));
    }

    @Test
    void blankAndTranslationMethods() {
        assertEquals(false, StringExamples.isEmptyExample(" "));
        assertEquals(true, StringExamples.isEmptyExample(""));
        assertEquals(true, StringExamples.isBlankExample(" "));
        assertEquals(true, StringExamples.isBlankExample(""));
        assertEquals("1\t2", StringExamples.translateEscapesExample("1\\t2"));
        assertEquals("Hello Kate, order 5 is ready", StringExamples.formattedExample("Kate", 5));
    }
}

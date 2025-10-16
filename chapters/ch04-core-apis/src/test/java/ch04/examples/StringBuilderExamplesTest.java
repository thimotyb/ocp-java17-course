package ch04.examples;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class StringBuilderExamplesTest {

    @Test
    void appendAndMutationExamples() {
        assertEquals("1c-true", StringBuilderExamples.appendExample());
        assertEquals("abcdef", StringBuilderExamples.sharedReferenceExample());
    }

    @Test
    void insertDeleteReplaceOperations() {
        assertEquals("-ani-mals-", StringBuilderExamples.insertExample());
        assertEquals("adef", StringBuilderExamples.deleteExample());
        assertTrue(StringBuilderExamples.deleteCharAtException() instanceof Exception);
        assertEquals("a", StringBuilderExamples.deletePastEnd());
        assertEquals("pigsty dirty", StringBuilderExamples.replaceExample());
        assertEquals("pig", StringBuilderExamples.replaceWithEmpty());
        assertEquals("CBA", StringBuilderExamples.reverseExample());
    }

    @Test
    void referenceComparison() {
        assertFalse(StringBuilderExamples.sameReference());
    }
}

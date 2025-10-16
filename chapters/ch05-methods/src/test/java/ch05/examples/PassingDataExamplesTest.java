package ch05.examples;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class PassingDataExamplesTest {

    @Test
    void primitiveReassignmentDoesNotImpactCaller() {
        assertEquals(4, PassingDataExamples.reassignPrimitive(4));
    }

    @Test
    void stringReassignmentDoesNotImpactCaller() {
        assertEquals("Webby", PassingDataExamples.reassignString("Webby"));
    }

    @Test
    void builderMutationDoesImpactCaller() {
        var builder = new StringBuilder("Webby");
        assertEquals("WebbyGeorgette", PassingDataExamples.mutateBuilder(builder).toString());
    }

    @Test
    void returnedValuesMustBeCaptured() {
        assertEquals(2, PassingDataExamples.ticketsAfterCall(2));
        assertEquals("abcd", PassingDataExamples.guestsAfterCall("abc"));
    }
}

package ch10.examples;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;

class OptionalExamplesTest {

    @Test
    void averageReturnsOptional() {
        assertEquals(95.0, OptionalExamples.average(List.of(90, 100)).orElseThrow());
        assertTrue(OptionalExamples.average(List.of()).isEmpty());
    }

    @Test
    void describeUsesDefault() {
        assertEquals("Unknown", OptionalExamples.describe(java.util.Optional.empty()));
        assertEquals("Koala", OptionalExamples.describe(java.util.Optional.of("Koala")));
    }
}

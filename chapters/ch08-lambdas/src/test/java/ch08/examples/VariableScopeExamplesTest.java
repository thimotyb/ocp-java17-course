package ch08.examples;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

class VariableScopeExamplesTest {

    @Test
    void lambdasCaptureEffectivelyFinalVariables() {
        assertEquals("onetwo", VariableScopeExamples.concatenate(List.of("one", "two")));
        assertEquals(6, VariableScopeExamples.sumWithEffectivelyFinal(List.of(1, 2, 3)));
        assertEquals("hello!", VariableScopeExamples.shadowingExample().apply("hello"));
    }
}

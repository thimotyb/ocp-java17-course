package ch02.examples;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class OperatorCanineTest {

    @Test
    void evaluatesExclusiveOrAssignment() {
        OperatorCanine.Result result = OperatorCanine.evaluate();
        assertTrue(result.canine());
        assertEquals(20, result.teeth());
        assertFalse(result.wolf());
    }
}

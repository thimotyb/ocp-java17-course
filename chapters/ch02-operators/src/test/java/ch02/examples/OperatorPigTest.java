package ch02.examples;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class OperatorPigTest {

    @Test
    void compoundAssignmentCastsAutomatically() {
        OperatorPig.Result result = OperatorPig.evaluate();
        assertEquals(4, result.pig());
        assertEquals(1, result.goat());
    }
}

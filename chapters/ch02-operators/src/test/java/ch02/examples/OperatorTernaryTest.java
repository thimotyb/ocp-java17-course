package ch02.examples;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class OperatorTernaryTest {

    @Test
    void evaluatesNestedTernaries() {
        OperatorTernary.Result result = OperatorTernary.evaluate();
        assertEquals(4, result.first());
        assertEquals(5, result.second());
        assertEquals(1, result.third());
        assertEquals(2, result.a());
        assertEquals(5, result.b());
        assertEquals(2, result.c());
    }
}

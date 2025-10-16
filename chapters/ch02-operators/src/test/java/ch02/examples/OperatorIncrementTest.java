package ch02.examples;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.Test;

class OperatorIncrementTest {

    @Test
    void demonstratesPreAndPostOperators() {
        int[] values = OperatorIncrement.demo();
        assertArrayEquals(new int[] {0, 1, 1, 1, 0}, values);
    }
}

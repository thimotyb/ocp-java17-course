package ch02.examples;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.Test;

class OperatorSamplesTest {

    @Test
    void calculatesSampleValues() {
        int[] values = OperatorSamples.evaluate();
        assertArrayEquals(new int[] {2, 0, 5}, values);
    }
}

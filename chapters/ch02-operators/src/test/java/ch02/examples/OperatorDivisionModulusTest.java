package ch02.examples;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.Test;

class OperatorDivisionModulusTest {

    @Test
    void demonstratesDivisionAndModulus() {
        int[][] values = OperatorDivisionModulus.demo();
        assertArrayEquals(new int[] {3, 0}, values[0]);
        assertArrayEquals(new int[] {3, 1}, values[1]);
        assertArrayEquals(new int[] {3, 2}, values[2]);
        assertArrayEquals(new int[] {4, 0}, values[3]);
    }
}

package ch13.examples;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;

class ParallelStreamExamplesTest {

    @Test
    void parallelSquaresProducesExpectedValues() {
        assertEquals(List.of(1, 4, 9, 16, 25), ParallelStreamExamples.parallelSquares(5));
    }

    @Test
    void countWithFilterCountsEven() {
        assertEquals(2, ParallelStreamExamples.countWithFilter(List.of(1, 2, 3, 4)));
    }

    @Test
    void parallelAverageWithinRange() {
        double average = ParallelStreamExamples.parallelAverage(10);
        assertTrue(average >= 0.0 && average <= 1.0);
    }
}

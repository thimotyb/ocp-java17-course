package ch10.examples;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class PrimitiveStreamExamplesTest {

    @Test
    void averageOfRange() {
        assertEquals(3.0, PrimitiveStreamExamples.averageFirstN(5).orElseThrow(), 0.0001);
    }

    @Test
    void summaryStatisticsComputesValues() {
        var stats = PrimitiveStreamExamples.summaryStats(1, 5);
        assertEquals(4, stats.getCount());
        assertEquals(1, stats.getMin());
        assertEquals(4, stats.getMax());
        assertEquals(10, stats.getSum());
    }

    @Test
    void productUsingLongStream() {
        assertEquals(120, PrimitiveStreamExamples.productUsingLongStream(1, 5));
    }

    @Test
    void sumRandomDoublesWithinRange() {
        double sum = PrimitiveStreamExamples.sumRandomDoubles(3);
        assertTrue(sum >= 0.0);
        assertTrue(sum <= 3.0);
    }
}

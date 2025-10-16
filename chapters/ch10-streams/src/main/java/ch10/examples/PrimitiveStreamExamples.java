package ch10.examples;

import java.util.IntSummaryStatistics;
import java.util.OptionalDouble;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

/**
 * Showcases primitive stream helpers.
 */
public final class PrimitiveStreamExamples {

    private PrimitiveStreamExamples() {
    }

    public static OptionalDouble averageFirstN(int n) {
        return IntStream.rangeClosed(1, n).average();
    }

    public static IntSummaryStatistics summaryStats(int startInclusive, int endExclusive) {
        return IntStream.range(startInclusive, endExclusive).summaryStatistics();
    }

    public static long productUsingLongStream(long start, long count) {
        return LongStream.range(start, start + count).reduce(1L, (a, b) -> a * b);
    }

    public static double sumRandomDoubles(int size) {
        return DoubleStream.generate(Math::random).limit(size).sum();
    }
}

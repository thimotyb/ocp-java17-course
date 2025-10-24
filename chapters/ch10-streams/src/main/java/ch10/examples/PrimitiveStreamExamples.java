package ch10.examples;

import java.util.IntSummaryStatistics;
import java.util.OptionalDouble;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

/**
 * Presents the primitive-stream utilities from Chapter 10 "Working with Primitive Streams". Methods
 * exercise {@link IntStream}, {@link LongStream}, and {@link DoubleStream} pipelines including
 * statistics and reductions.
 *
 * @see <a href="https://learning.oreilly.com/library/view/ocp-oracle-certified/9781119864585/c10.xhtml">OCP Java SE 17 Study Guide – Chapter 10: Working with Primitive Streams</a>
 */
public final class PrimitiveStreamExamples {

    private PrimitiveStreamExamples() {
    }

    /**
     * @return average of numbers {@code 1..n} computed by {@link IntStream#rangeClosed(int, int)} and
     *     {@link IntStream#average()}
     */
    public static OptionalDouble averageFirstN(int n) {
        return IntStream.rangeClosed(1, n).average();
    }

    /**
     * @return {@link IntSummaryStatistics} for the requested range, demonstrating statistics
     *     aggregation
     */
    public static IntSummaryStatistics summaryStats(int startInclusive, int endExclusive) {
        return IntStream.range(startInclusive, endExclusive).summaryStatistics();
    }

    /**
     * Shows {@link LongStream#range(long, long)} combined with {@link LongStream#reduce(long, java.util.function.LongBinaryOperator)}
     * to compute a product.
     */
    public static long productUsingLongStream(long start, long count) {
        return LongStream.range(start, start + count).reduce(1L, (a, b) -> a * b);
    }

    /**
     * Uses {@link DoubleStream#generate(java.util.function.DoubleSupplier)} and {@link DoubleStream#limit(long)}
     * to produce a finite stream of random values and sum them.
     */
    public static double sumRandomDoubles(int size) {
        return DoubleStream.generate(Math::random).limit(size).sum();
    }
}

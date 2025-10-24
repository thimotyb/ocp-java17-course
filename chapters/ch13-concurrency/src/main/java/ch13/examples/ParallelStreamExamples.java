package ch13.examples;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Illustrates parallel stream behaviours described in Chapter 13 "Parallel Streams" including
 * parallel execution, counting, and average computations.
 *
 * @see <a href="https://learning.oreilly.com/library/view/ocp-oracle-certified/9781119864585/c13.xhtml">OCP Java SE 17 Study Guide – Chapter 13: Parallel Streams</a>
 */
public final class ParallelStreamExamples {

    private ParallelStreamExamples() {
    }

    /**
     * @return list of squared numbers computed in parallel.
     */
    public static List<Integer> parallelSquares(int size) {
        return IntStream.rangeClosed(1, size)
            .parallel()
            .map(n -> n * n)
            .boxed()
            .collect(Collectors.toList());
    }

    /** Counts even values using a parallel pipeline. */
    public static long countWithFilter(List<Integer> values) {
        return values.parallelStream().filter(v -> v % 2 == 0).count();
    }

    /**
     * Generates random doubles concurrently and computes the average.
     */
    public static double parallelAverage(int size) {
        return ThreadLocalRandom.current().doubles(size).parallel().average().orElse(0);
    }
}

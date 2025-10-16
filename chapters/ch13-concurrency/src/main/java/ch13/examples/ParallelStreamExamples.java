package ch13.examples;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Illustrates parallel stream usage.
 */
public final class ParallelStreamExamples {

    private ParallelStreamExamples() {
    }

    public static List<Integer> parallelSquares(int size) {
        return IntStream.rangeClosed(1, size)
            .parallel()
            .map(n -> n * n)
            .boxed()
            .collect(Collectors.toList());
    }

    public static long countWithFilter(List<Integer> values) {
        return values.parallelStream().filter(v -> v % 2 == 0).count();
    }

    public static double parallelAverage(int size) {
        return ThreadLocalRandom.current().doubles(size).parallel().average().orElse(0);
    }
}

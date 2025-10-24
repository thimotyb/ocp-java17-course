package ch10.examples;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Aggregates the stream pipeline demonstrations from Chapter 10 "Working with Streams". Each
 * method corresponds to a pipeline pattern explored in the book—mapping/filtering, infinite streams,
 * primitive streams, grouping, partitioning, collecting, reducing, and sorting/limiting combinations.
 *
 * @see <a href="https://learning.oreilly.com/library/view/ocp-oracle-certified/9781119864585/c10.xhtml">OCP Java SE 17 Study Guide – Chapter 10: Working with Streams</a>
 */
public final class StreamPipelineExamples {

    private StreamPipelineExamples() {
    }

    /**
     * Trims, filters, sorts, and collects, mirroring the chapter's introductory pipeline example.
     */
    public static List<String> mapAndFilter(List<String> values) {
        return values.stream()
            .map(String::trim)
            .filter(s -> s.length() > 3)
            .sorted()
            .toList();
    }

    /**
     * @return first value matching the prefix via short-circuiting terminal operation
     */
    public static Optional<String> findFirstStartingWith(List<String> values, String prefix) {
        return values.stream()
            .filter(v -> v.startsWith(prefix))
            .findFirst();
    }

    /**
     * Demonstrates creating an infinite stream with {@link Stream#iterate(Object, java.util.function.UnaryOperator)}
     * and capping it with {@link Stream#limit(long)}.
     */
    public static List<Integer> createInfiniteEvenNumbers(int limit) {
        return Stream.iterate(0, n -> n + 2)
            .limit(limit)
            .toList();
    }

    /**
     * Squares integers with an {@link IntStream} before boxing back to {@link Integer} values.
     */
    public static List<Integer> primitiveStreamBoxed() {
        return IntStream.rangeClosed(1, 5)
            .map(n -> n * n)
            .boxed()
            .toList();
    }

    /**
     * Applies {@link Collectors#groupingBy} to bucket words by length, echoing the grouping examples.
     */
    public static Map<Integer, List<String>> groupingByLength(List<String> words) {
        return words.stream().collect(Collectors.groupingBy(String::length));
    }

    /**
     * Uses {@link Collectors#partitioningBy} to produce {@code true/false} lists based on parity.
     */
    public static Map<Boolean, List<String>> partitionByLength(List<String> words) {
        return words.stream().collect(Collectors.partitioningBy(word -> word.length() % 2 == 0));
    }

    /**
     * @return delimited string produced via {@link Collectors#joining} with prefix/suffix
     */
    public static String joiningNames(List<String> names) {
        return names.stream().collect(Collectors.joining(", ", "[", "]"));
    }

    /**
     * Shows {@link Collectors#toMap} with a merge function to resolve duplicate keys.
     */
    public static Map<Integer, String> toMapWithMerge(List<String> names) {
        return names.stream().collect(Collectors.toMap(String::length, Function.identity(), (existing, replacement) -> existing + "/" + replacement));
    }

    /**
     * Demonstrates reduction without an identity value, yielding an {@link Optional}.
     */
    public static Optional<String> reduceConcatenate(List<String> values) {
        return values.stream().reduce((a, b) -> a + "-" + b);
    }

    /**
     * Combines {@link Stream#distinct()}, {@link Stream#sorted()}, and {@link Stream#limit(long)} before
     * collecting into a {@link Set}.
     */
    public static Set<String> sortedDistinctCapped(List<String> values, long limit) {
        return values.stream().distinct().sorted(Comparator.naturalOrder()).limit(limit).collect(Collectors.toSet());
    }
}

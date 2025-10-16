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
 * Collection of stream pipeline examples.
 */
public final class StreamPipelineExamples {

    private StreamPipelineExamples() {
    }

    public static List<String> mapAndFilter(List<String> values) {
        return values.stream()
            .map(String::trim)
            .filter(s -> s.length() > 3)
            .sorted()
            .toList();
    }

    public static Optional<String> findFirstStartingWith(List<String> values, String prefix) {
        return values.stream()
            .filter(v -> v.startsWith(prefix))
            .findFirst();
    }

    public static List<Integer> createInfiniteEvenNumbers(int limit) {
        return Stream.iterate(0, n -> n + 2)
            .limit(limit)
            .toList();
    }

    public static List<Integer> primitiveStreamBoxed() {
        return IntStream.rangeClosed(1, 5)
            .map(n -> n * n)
            .boxed()
            .toList();
    }

    public static Map<Integer, List<String>> groupingByLength(List<String> words) {
        return words.stream().collect(Collectors.groupingBy(String::length));
    }

    public static Map<Boolean, List<String>> partitionByLength(List<String> words) {
        return words.stream().collect(Collectors.partitioningBy(word -> word.length() % 2 == 0));
    }

    public static String joiningNames(List<String> names) {
        return names.stream().collect(Collectors.joining(", ", "[", "]"));
    }

    public static Map<Integer, String> toMapWithMerge(List<String> names) {
        return names.stream().collect(Collectors.toMap(String::length, Function.identity(), (existing, replacement) -> existing + "/" + replacement));
    }

    public static Optional<String> reduceConcatenate(List<String> values) {
        return values.stream().reduce((a, b) -> a + "-" + b);
    }

    public static Set<String> sortedDistinctCapped(List<String> values, long limit) {
        return values.stream().distinct().sorted(Comparator.naturalOrder()).limit(limit).collect(Collectors.toSet());
    }
}

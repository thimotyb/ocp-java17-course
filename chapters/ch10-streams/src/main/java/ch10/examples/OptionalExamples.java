package ch10.examples;

import java.util.List;
import java.util.Optional;

/**
 * Demonstrates Optional creation and usage from Chapter 10.
 */
public final class OptionalExamples {

    private OptionalExamples() {
    }

    public static Optional<Double> average(List<Integer> scores) {
        if (scores == null || scores.isEmpty()) {
            return Optional.empty();
        }
        double total = scores.stream().mapToInt(Integer::intValue).sum();
        return Optional.of(total / scores.size());
    }

    public static String describe(Optional<String> value) {
        return value.orElse("Unknown");
    }
}

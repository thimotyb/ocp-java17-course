package ch10.examples;

import java.util.List;
import java.util.Optional;

/**
 * Demonstrates Optional creation and consumption patterns from Chapter 10 "Working with Advanced
 * Streams" (Optional section). Examples cover safe average calculations and retrieval via
 * {@link Optional#orElse(Object)}.
 *
 * @see <a href="https://learning.oreilly.com/library/view/ocp-oracle-certified/9781119864585/c10.xhtml">OCP Java SE 17 Study Guide – Chapter 10: Using Optional</a>
 */
public final class OptionalExamples {

    private OptionalExamples() {
    }

    /**
     * Calculates the average score using stream reduction and returns an {@link Optional} that may be
     * empty when provided with {@code null} or empty input, mirroring the defensive patterns from the
     * text.
     */
    public static Optional<Double> average(List<Integer> scores) {
        if (scores == null || scores.isEmpty()) {
            return Optional.empty();
        }
        double total = scores.stream().mapToInt(Integer::intValue).sum();
        return Optional.of(total / scores.size());
    }

    /**
     * @return human-readable description using {@link Optional#orElse(Object)}
     */
    public static String describe(Optional<String> value) {
        return value.orElse("Unknown");
    }
}

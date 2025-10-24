package ch11.examples;

import java.io.Closeable;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Collects the exception-handling snippets from Chapter 11 "Handling Exceptions". Examples cover
 * unchecked vs. checked exceptions, multi-catch, {@code finally} behaviour, try-with-resources, and
 * custom checked exception declarations.
 *
 * @see <a href="https://learning.oreilly.com/library/view/ocp-oracle-certified/9781119864585/c11.xhtml">OCP Java SE 17 Study Guide – Chapter 11: Handling Exceptions</a>
 */
public final class ExceptionExamples {

    private ExceptionExamples() {
    }

    /** Throws an unchecked exception, mirroring the exam-style snippet. */
    public static void uncheckedException() {
        throw new IllegalArgumentException("Invalid input");
    }

    /**
     * Provides manual validation before division to show guard clauses and exception throwing.
     */
    public static int safeDivide(int numerator, int denominator) {
        if (denominator == 0) {
            throw new ArithmeticException("Division by zero");
        }
        return numerator / denominator;
    }

    /**
     * Demonstrates multi-catch syntax combining {@link NullPointerException} and
     * {@link IndexOutOfBoundsException} before wrapping in an {@link IllegalStateException}.
     */
    public static void multiCatchExample(List<String> values) {
        try {
            System.out.println(values.get(1).length());
        } catch (NullPointerException | IndexOutOfBoundsException e) {
            throw new IllegalStateException("Invalid list", e);
        }
    }

    /**
     * Returns 20 to emphasise that a {@code finally} block can override values returned from `try`.
     */
    public static int finallyOverridesReturn() {
        try {
            return 10;
        } finally {
            return 20;
        }
    }

    /** AutoCloseable implementation used to demonstrate suppressed exceptions in try-with-resources. */
    public static class Auto implements Closeable {

        private final List<String> closed = new ArrayList<>();

        @Override
        public void close() throws IOException {
            closed.add("closed");
            throw new IOException("Auto close failure");
        }

        /** @return sequence of close events for verification in tests */
        public List<String> events() {
            return closed;
        }
    }

    /**
     * Executes a try-with-resources block that triggers both primary and suppressed exceptions,
     * mirroring the chapter's illustration of resource closing order.
     *
     * @return ordered list of lifecycle events
     */
    public static List<String> tryWithResources() throws Exception {
        List<String> events = new ArrayList<>();
        try (Auto auto1 = new Auto(); Auto auto2 = new Auto()) {
            events.add("in try");
            throw new RuntimeException("boom");
        } catch (Exception e) {
            events.add("caught " + e.getClass().getSimpleName());
            for (Throwable suppressed : e.getSuppressed()) {
                events.add("suppressed " + suppressed.getClass().getSimpleName());
            }
        }
        return events;
    }

    /** Checked exception used to illustrate declaring and throwing custom checked types. */
    public static class CustomCheckedException extends Exception {

        public CustomCheckedException(String message) {
            super(message);
        }
    }

    /** Throws the custom checked exception when {@code trigger} is {@code true}. */
    public static void throwCustomChecked(boolean trigger) throws CustomCheckedException {
        if (trigger) {
            throw new CustomCheckedException("Triggered");
        }
    }
}

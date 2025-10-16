package ch11.examples;

import java.io.Closeable;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Collects exception-handling examples from Chapter 11.
 */
public final class ExceptionExamples {

    private ExceptionExamples() {
    }

    public static void uncheckedException() {
        throw new IllegalArgumentException("Invalid input");
    }

    public static int safeDivide(int numerator, int denominator) {
        if (denominator == 0) {
            throw new ArithmeticException("Division by zero");
        }
        return numerator / denominator;
    }

    public static void multiCatchExample(List<String> values) {
        try {
            System.out.println(values.get(1).length());
        } catch (NullPointerException | IndexOutOfBoundsException e) {
            throw new IllegalStateException("Invalid list", e);
        }
    }

    public static int finallyOverridesReturn() {
        try {
            return 10;
        } finally {
            return 20;
        }
    }

    public static class Auto implements Closeable {

        private final List<String> closed = new ArrayList<>();

        @Override
        public void close() throws IOException {
            closed.add("closed");
            throw new IOException("Auto close failure");
        }

        public List<String> events() {
            return closed;
        }
    }

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

    public static class CustomCheckedException extends Exception {

        public CustomCheckedException(String message) {
            super(message);
        }
    }

    public static void throwCustomChecked(boolean trigger) throws CustomCheckedException {
        if (trigger) {
            throw new CustomCheckedException("Triggered");
        }
    }
}

package ch08.examples;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.UnaryOperator;

/**
 * Highlights scope and effectively final rules inside lambdas.
 */
public final class VariableScopeExamples {

    private VariableScopeExamples() {
    }

    public static String concatenate(List<String> values) {
        StringBuilder builder = new StringBuilder();
        values.forEach(builder::append);
        return builder.toString();
    }

    public static int sumWithEffectivelyFinal(List<Integer> values) {
        final AtomicInteger total = new AtomicInteger();
        values.forEach(total::addAndGet);
        return total.get();
    }

    public static UnaryOperator<String> shadowingExample() {
        String suffix = "!";
        return text -> text + suffix;
    }
}

package ch08.examples;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.UnaryOperator;

/**
 * Highlights the lambda scoping rules from Chapter 8 "Checking Variable Scope". The helpers cover
 * effectively final variables, shared mutable state via wrappers, and the prohibition against
 * shadowing parameters with local variables.
 *
 * @see <a href="https://learning.oreilly.com/library/view/ocp-oracle-certified/9781119864585/c08.xhtml">OCP Java SE 17 Study Guide – Chapter 8: Checking Variable Scope</a>
 */
public final class VariableScopeExamples {

    private VariableScopeExamples() {
    }

    /**
     * Demonstrates capturing an effectively final object reference ({@link StringBuilder}) while the
     * object itself remains mutable.
     *
     * @param values pieces to join
     * @return concatenated text
     */
    public static String concatenate(List<String> values) {
        StringBuilder builder = new StringBuilder();
        values.forEach(builder::append);
        return builder.toString();
    }

    /**
     * Shows how to work around effectively final constraints by placing mutable state inside a
     * holder object such as {@link AtomicInteger}.
     *
     * @param values numbers to add
     * @return total sum
     */
    public static int sumWithEffectivelyFinal(List<Integer> values) {
        final AtomicInteger total = new AtomicInteger();
        values.forEach(total::addAndGet);
        return total.get();
    }

    /**
     * Returns a lambda that closes over a local variable, reinforcing that the captured variable must
     * be effectively final and cannot be re-declared inside the lambda body.
     */
    public static UnaryOperator<String> shadowingExample() {
        String suffix = "!";
        return text -> text + suffix;
    }
}

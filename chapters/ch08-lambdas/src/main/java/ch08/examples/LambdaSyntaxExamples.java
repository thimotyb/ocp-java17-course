package ch08.examples;

import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 * Captures the lambda syntax permutations from Chapter 8 "Writing Lambda Expressions". Each method
 * returns a lambda in a different form, reinforcing the compiler rules about parameter types,
 * parentheses, and statement bodies.
 *
 * @see <a href="https://learning.oreilly.com/library/view/ocp-oracle-certified/9781119864585/c08.xhtml">OCP Java SE 17 Study Guide – Chapter 8: Writing Lambda Expressions</a>
 */
public final class LambdaSyntaxExamples {

    private LambdaSyntaxExamples() {
    }

    /**
     * Demonstrates the most verbose syntax: explicit parameter type and block with {@code return}.
     */
    public static Predicate<String> fullSyntax() {
        return (String s) -> {
            return s.isEmpty();
        };
    }

    /**
     * Shows type inference when the parameter type can be deduced from the target SAM.
     */
    public static Predicate<String> inferredType() {
        return s -> s.length() > 3;
    }

    /**
     * Returns a single-statement lambda, underlining that braces and {@code return} are optional for
     * one-liners.
     */
    public static Consumer<String> singleStatement() {
        return value -> System.out.println(value);
    }

    /**
     * Demonstrates multiple parameters with inferred types and required parentheses.
     */
    public static BiPredicate<String, String> multiParameter() {
        return (a, b) -> a.startsWith(b);
    }

    /**
     * Highlights usage of {@code var} in lambda parameter lists, as introduced in Java 11/14.
     */
    public static Predicate<String> varKeyword() {
        return (var text) -> text.endsWith("!");
    }
}

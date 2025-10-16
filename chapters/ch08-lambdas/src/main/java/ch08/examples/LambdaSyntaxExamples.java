package ch08.examples;

import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 * Demonstrates lambda syntactic variations.
 */
public final class LambdaSyntaxExamples {

    private LambdaSyntaxExamples() {
    }

    public static Predicate<String> fullSyntax() {
        return (String s) -> {
            return s.isEmpty();
        };
    }

    public static Predicate<String> inferredType() {
        return s -> s.length() > 3;
    }

    public static Consumer<String> singleStatement() {
        return value -> System.out.println(value);
    }

    public static BiPredicate<String, String> multiParameter() {
        return (a, b) -> a.startsWith(b);
    }

    public static Predicate<String> varKeyword() {
        return (var text) -> text.endsWith("!");
    }
}

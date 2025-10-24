package ch08.examples;

import java.time.LocalDate;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

/**
 * Collects the sample lambdas built around the {@code java.util.function} package in Chapter 8
 * "Using Built-in Functional Interfaces". Each factory method returns a lambda that matches one of
 * the core SAM types emphasised for the exam.
 *
 * <p>The chapter stresses remembering the signatures for {@code Supplier}, {@code Consumer},
 * {@code Predicate}, {@code Function}, and their bi-/operator variations. These helpers surface the
 * exact method references or lambda bodies the book introduces.</p>
 *
 * @see <a href="https://learning.oreilly.com/library/view/ocp-oracle-certified/9781119864585/c08.xhtml">OCP Java SE 17 Study Guide – Chapter 8: Using Built-in Functional Interfaces</a>
 */
public final class BuiltInFunctionalExamples {

    private BuiltInFunctionalExamples() {
    }

    /**
     * @return predicate matching the "is blank" example from the chapter (negated to show testing)
     */
    public static Predicate<String> nonEmptyPredicate() {
        return s -> !s.isBlank();
    }

    /**
     * @return supplier that yields {@link LocalDate#now()}, mirroring the chapter's temporal
     *     supplier snippet
     */
    public static Supplier<LocalDate> todaySupplier() {
        return LocalDate::now;
    }

    /**
     * @param target collection to receive appended values
     * @return consumer that delegates to {@link List#add(Object)}, aligning with the chapter's
     *     side-effect examples
     */
    public static Consumer<String> listAppender(List<String> target) {
        return target::add;
    }

    /**
     * @return function converting {@link String} input to its length, echoing the canonical example
     */
    public static Function<String, Integer> lengthFunction() {
        return String::length;
    }

    /**
     * @return unary operator referencing {@link String#toUpperCase()} as shown in the text
     */
    public static UnaryOperator<String> upperOperator() {
        return String::toUpperCase;
    }

    /**
     * @return bi-predicate checking containment, demonstrating how method references satisfy the
     *     two-argument predicate contract
     */
    public static BiPredicate<String, String> containsPredicate() {
        return String::contains;
    }

    /**
     * @return bi-function that extracts a substring, mirroring the "triaging String arguments"
     *     example
     */
    public static BiFunction<String, Integer, String> substringFunction() {
        return (text, count) -> text.substring(0, count);
    }

    /**
     * @return binary operator summing integers, matching the chapter's coverage of arithmetic
     */
    public static BinaryOperator<Integer> sumOperator() {
        return Integer::sum;
    }

    /**
     * @return bi-consumer that appends text to a {@link StringBuilder}, illustrating consumers with
     *     mutable targets
     */
    public static BiConsumer<String, StringBuilder> appendConsumer() {
        return (value, builder) -> builder.append(value);
    }
}

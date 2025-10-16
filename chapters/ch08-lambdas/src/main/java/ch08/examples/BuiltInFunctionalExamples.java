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
 * Exercises the java.util.function interfaces highlighted in Chapter 8.
 */
public final class BuiltInFunctionalExamples {

    private BuiltInFunctionalExamples() {
    }

    public static Predicate<String> nonEmptyPredicate() {
        return s -> !s.isBlank();
    }

    public static Supplier<LocalDate> todaySupplier() {
        return LocalDate::now;
    }

    public static Consumer<String> listAppender(List<String> target) {
        return target::add;
    }

    public static Function<String, Integer> lengthFunction() {
        return String::length;
    }

    public static UnaryOperator<String> upperOperator() {
        return String::toUpperCase;
    }

    public static BiPredicate<String, String> containsPredicate() {
        return String::contains;
    }

    public static BiFunction<String, Integer, String> substringFunction() {
        return (text, count) -> text.substring(0, count);
    }

    public static BinaryOperator<Integer> sumOperator() {
        return Integer::sum;
    }

    public static BiConsumer<String, StringBuilder> appendConsumer() {
        return (value, builder) -> builder.append(value);
    }
}

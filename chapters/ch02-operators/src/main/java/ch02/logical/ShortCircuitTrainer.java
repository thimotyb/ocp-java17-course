package ch02.logical;

import java.util.function.BooleanSupplier;

/**
 * Compares short-circuiting logical operators with their eager counterparts.
 */
public final class ShortCircuitTrainer {

    private ShortCircuitTrainer() {
    }

    public static boolean conditionalAnd(boolean left, BooleanSupplier right) {
        return left && right.getAsBoolean();
    }

    public static boolean nonShortCircuitAnd(boolean left, BooleanSupplier right) {
        return left & right.getAsBoolean();
    }

    public static boolean conditionalOr(boolean left, BooleanSupplier right) {
        return left || right.getAsBoolean();
    }

    public static boolean nonShortCircuitOr(boolean left, BooleanSupplier right) {
        return left | right.getAsBoolean();
    }
}

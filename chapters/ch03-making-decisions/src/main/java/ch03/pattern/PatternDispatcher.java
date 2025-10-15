package ch03.pattern;

/**
 * Uses instanceof pattern matching and switch expressions to select outcomes.
 */
public final class PatternDispatcher {

    private PatternDispatcher() {
    }

    public static String describe(Object value) {
        if (value == null) {
            return "No value";
        }
        if (value instanceof String s && s.isBlank()) {
            return "Blank string";
        } else if (value instanceof String s) {
            return "String length=" + s.length();
        }
        if (value instanceof Integer i && i > 100) {
            return "Large integer";
        }
        if (value instanceof Number number) {
            return "Number type=" + number.getClass().getSimpleName();
        }
        return "Unknown type";
    }

    public static String switchDescribe(Object value) {
        if (value == null) {
            return "No value";
        }
        if (value instanceof String s) {
            return switch (s.isBlank() ? 0 : 1) {
                case 0 -> "Blank string";
                default -> "String length=" + s.length();
            };
        }
        if (value instanceof Integer i) {
            return switch (Integer.signum(i)) {
                case -1 -> "Negative integer";
                case 0 -> "Integer=0";
                default -> "Integer=" + i;
            };
        }
        if (value instanceof Number number) {
            return "Number type=" + number.getClass().getSimpleName();
        }
        return "Unknown type";
    }
}

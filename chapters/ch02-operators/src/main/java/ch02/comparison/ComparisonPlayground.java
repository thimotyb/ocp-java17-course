package ch02.comparison;

import java.util.Objects;

/**
 * Explores equality operators, object equality, and instanceof patterns.
 */
public final class ComparisonPlayground {

    private ComparisonPlayground() {
    }

    public static boolean smallIntegerCacheHit() {
        return Integer.valueOf(10) == Integer.valueOf(10);
    }

    public static boolean largeIntegerCacheMiss() {
        return Integer.valueOf(1000) == Integer.valueOf(1000);
    }

    public static boolean internedStringEquals() {
        return "java" == "java";
    }

    public static boolean trimmedStringSameReference(String value) {
        return value.trim() == value;
    }

    public static boolean objectsEquals(Object left, Object right) {
        return Objects.equals(left, right);
    }

    public static boolean patternMatch(Object candidate) {
        return candidate instanceof String s && s.length() >= 4;
    }
}

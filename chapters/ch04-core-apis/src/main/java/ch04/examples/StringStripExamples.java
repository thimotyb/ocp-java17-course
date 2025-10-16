package ch04.examples;

public final class StringStripExamples {

    private StringStripExamples() {
    }

    public static String strip(String value) {
        return value.strip();
    }

    public static int trimmedLength(String text) {
        return text.trim().length();
    }

    public static int strippedLength(String text) {
        return text.strip().length();
    }

    public static int stripLeadingLength(String text) {
        return text.stripLeading().length();
    }

    public static int stripTrailingLength(String text) {
        return text.stripTrailing().length();
    }
}

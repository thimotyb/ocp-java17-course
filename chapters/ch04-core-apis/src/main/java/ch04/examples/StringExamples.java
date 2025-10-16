package ch04.examples;

public final class StringExamples {

    private StringExamples() {
    }

    public static String[] concatenationOutputs() {
        return new String[] {
            String.valueOf(1 + 2),
            "a" + "b",
            "a" + "b" + 3,
            1 + 2 + "c",
            "c" + 1 + 2,
            "c" + (String) null
        };
    }

    public static String concatenationWithVariables() {
        int three = 3;
        String four = "4";
        return 1 + 2 + three + four;
    }

    public static String compoundAssignment() {
        var s = "1";
        s += "2";
        s += 3;
        return s;
    }

    public static int lengthAnimals() {
        var name = "animals";
        return name.length();
    }

    public static char charAt(int index) {
        var name = "animals";
        return name.charAt(index);
    }

    public static int indexOfExample(char ch) {
        var name = "animals";
        return name.indexOf(ch);
    }

    public static int indexOfExample(String search) {
        var name = "animals";
        return name.indexOf(search);
    }

    public static int indexOfExample(char ch, int fromIndex) {
        var name = "animals";
        return name.indexOf(ch, fromIndex);
    }

    public static int indexOfExample(String search, int fromIndex) {
        var name = "animals";
        return name.indexOf(search, fromIndex);
    }

    public static String substringFrom(int beginIndex) {
        var name = "animals";
        return name.substring(beginIndex);
    }

    public static String substringRange(int beginIndex, int endIndex) {
        var name = "animals";
        return name.substring(beginIndex, endIndex);
    }

    public static String animalsToUpper() {
        var name = "animals";
        return name.toUpperCase();
    }

    public static String mixedToLower() {
        return "Abc123".toLowerCase();
    }

    public static boolean equalsExample(String input) {
        return "abc".equals(input);
    }

    public static boolean equalsIgnoreCaseExample(String input) {
        return "abc".equalsIgnoreCase(input);
    }

    public static boolean startsWithExample(String prefix) {
        return "abc".startsWith(prefix);
    }

    public static boolean endsWithExample(String suffix) {
        return "abc".endsWith(suffix);
    }

    public static boolean containsExample(String text) {
        return "abc".contains(text);
    }

    public static String replaceExample(char oldChar, char newChar) {
        return "abcabc".replace(oldChar, newChar);
    }

    public static String replaceExample(String target, String replacement) {
        return "abcabc".replace(target, replacement);
    }

    public static boolean isEmptyExample(String input) {
        return input.isEmpty();
    }

    public static boolean isBlankExample(String input) {
        return input.isBlank();
    }

    public static String translateEscapesExample(String value) {
        return value.translateEscapes();
    }

    public static String formattedExample(String name, int orderId) {
        return String.format("Hello %s, order %d is ready", name, orderId);
    }
}

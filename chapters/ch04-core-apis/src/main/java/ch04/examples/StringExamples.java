package ch04.examples;

/**
 * Demonstrates core String API methods and operations covered in Chapter 4: Core APIs.
 *
 * <p>From Chapter 4: Creating and Manipulating Strings</p>
 *
 * <p>Key concepts demonstrated:</p>
 * <ul>
 *   <li>String concatenation rules: numeric addition vs. string concatenation</li>
 *   <li>Evaluation order: left-to-right with type-dependent operations</li>
 *   <li>String immutability: methods return new String objects</li>
 *   <li>Common String methods: length(), charAt(), indexOf(), substring()</li>
 *   <li>Case conversion: toUpperCase(), toLowerCase()</li>
 *   <li>Equality checking: equals(), equalsIgnoreCase()</li>
 *   <li>Substring searching: startsWith(), endsWith(), contains()</li>
 *   <li>String replacement: replace()</li>
 *   <li>Empty/blank checking: isEmpty(), isBlank()</li>
 *   <li>String formatting: formatted()</li>
 * </ul>
 *
 * @see java.lang.String
 */
public final class StringExamples {

    private StringExamples() {
    }

    /**
     * Demonstrates the three rules of String concatenation.
     *
     * <p>Concatenation Rules (evaluated left-to-right):</p>
     * <ol>
     *   <li>If both operands are numeric, + means numeric addition</li>
     *   <li>If either operand is a String, + means concatenation</li>
     *   <li>Expression is evaluated left to right</li>
     * </ol>
     *
     * @return array of concatenation examples:
     *         [0] "3" - both numeric (1+2)
     *         [1] "ab" - both strings
     *         [2] "ab3" - string + string + number
     *         [3] "3c" - numbers first (1+2=3), then concatenate with "c"
     *         [4] "c12" - "c" + 1 = "c1", then + 2 = "c12"
     *         [5] "cnull" - null is converted to string "null"
     */
    public static String[] concatenationOutputs() {
        return new String[] {
            String.valueOf(1 + 2),        // Rule 1: numeric addition
            "a" + "b",                     // Rule 2: string concatenation
            "a" + "b" + 3,                 // Rule 2: all concatenated left-to-right
            1 + 2 + "c",                   // Rules 1 & 2: 3 + "c" = "3c"
            "c" + 1 + 2,                   // Rule 2: "c1" + 2 = "c12"
            "c" + (String) null            // null becomes "null" in concatenation
        };
    }

    /**
     * Demonstrates concatenation with variables.
     *
     * <p>Shows how variable types affect concatenation order.
     * Evaluation: 1 + 2 = 3, then 3 + three = 6, then 6 + "4" = "64"</p>
     *
     * @return "64" (not "634" - numeric addition happens first)
     */
    public static String concatenationWithVariables() {
        int three = 3;
        String four = "4";
        return 1 + 2 + three + four;  // 3 + 3 = 6, then "6" + "4" = "64"
    }

    /**
     * Demonstrates compound assignment operator with String concatenation.
     *
     * <p>The += operator with strings works as: s = s + value</p>
     *
     * @return "123" - compound assignment concatenates each value
     */
    public static String compoundAssignment() {
        var s = "1";          // s = "1"
        s += "2";             // s = "1" + "2" = "12"
        s += 3;               // s = "12" + 3 = "123"
        return s;
    }

    /**
     * Demonstrates the length() method.
     *
     * <p>Returns the number of characters in the String.
     * Note: Java uses zero-based indexing for positions, but normal counting for length.</p>
     *
     * @return 7 - the number of characters in "animals"
     */
    public static int lengthAnimals() {
        var name = "animals";  // 7 characters: a-n-i-m-a-l-s
        return name.length();
    }

    /**
     * Demonstrates the charAt() method for retrieving a character at a specific index.
     *
     * <p>Indexes are zero-based: charAt(0) is first character, charAt(6) is seventh.
     * Throws StringIndexOutOfBoundsException if index is invalid.</p>
     *
     * @param index the zero-based position
     * @return the character at the specified index in "animals"
     */
    public static char charAt(int index) {
        var name = "animals";
        return name.charAt(index);  // charAt(0)='a', charAt(6)='s', charAt(7)=exception
    }

    /**
     * Demonstrates indexOf(char) - finds first occurrence of a character.
     *
     * @param ch the character to search for
     * @return zero-based index of first occurrence, or -1 if not found
     */
    public static int indexOfExample(char ch) {
        var name = "animals";
        return name.indexOf(ch);  // indexOf('a')=0, indexOf('x')=-1
    }

    /**
     * Demonstrates indexOf(String) - finds first occurrence of a substring.
     *
     * @param search the substring to search for
     * @return zero-based index of first occurrence, or -1 if not found
     */
    public static int indexOfExample(String search) {
        var name = "animals";
        return name.indexOf(search);  // indexOf("al")=4
    }

    /**
     * Demonstrates indexOf(char, fromIndex) - finds character starting from a position.
     *
     * @param ch the character to search for
     * @param fromIndex the index to start searching from (inclusive)
     * @return zero-based index of first occurrence from fromIndex, or -1 if not found
     */
    public static int indexOfExample(char ch, int fromIndex) {
        var name = "animals";
        return name.indexOf(ch, fromIndex);  // indexOf('a', 4)=4 (second 'a')
    }

    /**
     * Demonstrates indexOf(String, fromIndex) - finds substring starting from a position.
     *
     * @param search the substring to search for
     * @param fromIndex the index to start searching from (inclusive)
     * @return zero-based index of first occurrence from fromIndex, or -1 if not found
     */
    public static int indexOfExample(String search, int fromIndex) {
        var name = "animals";
        return name.indexOf(search, fromIndex);  // indexOf("al", 5)=-1 (starts after "al")
    }

    /**
     * Demonstrates substring(beginIndex) - extracts from beginIndex to end.
     *
     * <p>Think of indexes as pointing between characters, not at them.
     * beginIndex is inclusive (starts at that position).</p>
     *
     * @param beginIndex the starting index (inclusive)
     * @return substring from beginIndex to end of string
     */
    public static String substringFrom(int beginIndex) {
        var name = "animals";  // indexes: 0a1n2i3m4a5l6s7
        return name.substring(beginIndex);  // substring(3)="mals"
    }

    /**
     * Demonstrates substring(beginIndex, endIndex) - extracts a range.
     *
     * <p>beginIndex is inclusive, endIndex is exclusive (stops before endIndex).
     * endIndex can be one past the last character without exception.</p>
     *
     * @param beginIndex the starting index (inclusive)
     * @param endIndex the ending index (exclusive)
     * @return substring from beginIndex up to (but not including) endIndex
     */
    public static String substringRange(int beginIndex, int endIndex) {
        var name = "animals";
        return name.substring(beginIndex, endIndex);  // substring(3,4)="m", substring(3,7)="mals"
    }

    /**
     * Demonstrates toUpperCase() - converts to uppercase.
     *
     * <p>Returns a new String with all letters in uppercase.
     * Non-letter characters remain unchanged. Strings are immutable.</p>
     *
     * @return "ANIMALS"
     */
    public static String animalsToUpper() {
        var name = "animals";
        return name.toUpperCase();  // Returns new String, 'name' unchanged
    }

    /**
     * Demonstrates toLowerCase() - converts to lowercase.
     *
     * <p>Returns a new String with all letters in lowercase.
     * Non-letter characters (like digits) remain unchanged.</p>
     *
     * @return "abc123"
     */
    public static String mixedToLower() {
        return "Abc123".toLowerCase();  // Only letters affected
    }

    /**
     * Demonstrates equals() - case-sensitive equality check.
     *
     * <p>Checks if two Strings contain exactly the same characters in same order.
     * Case-sensitive: "abc" != "ABC"</p>
     *
     * @param input the string to compare
     * @return true if strings are equal (case-sensitive)
     */
    public static boolean equalsExample(String input) {
        return "abc".equals(input);  // equals("abc")=true, equals("ABC")=false
    }

    /**
     * Demonstrates equalsIgnoreCase() - case-insensitive equality check.
     *
     * @param input the string to compare
     * @return true if strings are equal ignoring case
     */
    public static boolean equalsIgnoreCaseExample(String input) {
        return "abc".equalsIgnoreCase(input);  // equalsIgnoreCase("ABC")=true
    }

    /**
     * Demonstrates startsWith() - checks if string starts with prefix.
     *
     * <p>Case-sensitive check of the beginning of the string.</p>
     *
     * @param prefix the prefix to check for
     * @return true if string starts with the given prefix
     */
    public static boolean startsWithExample(String prefix) {
        return "abc".startsWith(prefix);  // startsWith("a")=true, startsWith("A")=false
    }

    /**
     * Demonstrates endsWith() - checks if string ends with suffix.
     *
     * <p>Case-sensitive check of the end of the string.</p>
     *
     * @param suffix the suffix to check for
     * @return true if string ends with the given suffix
     */
    public static boolean endsWithExample(String suffix) {
        return "abc".endsWith(suffix);  // endsWith("c")=true, endsWith("a")=false
    }

    /**
     * Demonstrates contains() - checks if string contains substring.
     *
     * <p>Case-sensitive check anywhere in the string.
     * Convenience method for: indexOf(str) != -1</p>
     *
     * @param text the substring to search for
     * @return true if string contains the given text
     */
    public static boolean containsExample(String text) {
        return "abc".contains(text);  // contains("b")=true, contains("B")=false
    }

    /**
     * Demonstrates replace(char, char) - replaces all occurrences of a character.
     *
     * <p>Returns a new String with all occurrences of oldChar replaced with newChar.</p>
     *
     * @param oldChar the character to replace
     * @param newChar the replacement character
     * @return new String with replacements made
     */
    public static String replaceExample(char oldChar, char newChar) {
        return "abcabc".replace(oldChar, newChar);  // replace('a','A')="AbcAbc"
    }

    /**
     * Demonstrates replace(CharSequence, CharSequence) - replaces all occurrences of substring.
     *
     * @param target the substring to replace
     * @param replacement the replacement substring
     * @return new String with replacements made
     */
    public static String replaceExample(String target, String replacement) {
        return "abcabc".replace(target, replacement);  // replace("a","A")="AbcAbc"
    }

    /**
     * Demonstrates isEmpty() - checks if string has zero length.
     *
     * <p>Returns true only if length() == 0.
     * Note: " " (space) is NOT empty.</p>
     *
     * @param input the string to check
     * @return true if string is empty ("")
     */
    public static boolean isEmptyExample(String input) {
        return input.isEmpty();  // "".isEmpty()=true, " ".isEmpty()=false
    }

    /**
     * Demonstrates isBlank() - checks if string is empty or contains only whitespace.
     *
     * <p>Returns true if string is empty OR contains only whitespace characters.
     * More permissive than isEmpty().</p>
     *
     * @param input the string to check
     * @return true if string is blank (empty or only whitespace)
     */
    public static boolean isBlankExample(String input) {
        return input.isBlank();  // "".isBlank()=true, " ".isBlank()=true, "a".isBlank()=false
    }

    /**
     * Demonstrates translateEscapes() - processes escape sequences.
     *
     * <p>Converts escape sequences like \\t, \\n, \\r to actual characters.</p>
     *
     * @param value the string containing escape sequences
     * @return string with escape sequences translated
     */
    public static String translateEscapesExample(String value) {
        return value.translateEscapes();  // "\\t" becomes actual tab character
    }

    /**
     * Demonstrates String.format() - creates formatted string with placeholders.
     *
     * <p>Format specifiers: %s for String, %d for decimal integer.
     * Similar to printf-style formatting.</p>
     *
     * @param name the name to insert
     * @param orderId the order ID to insert
     * @return formatted string
     */
    public static String formattedExample(String name, int orderId) {
        return String.format("Hello %s, order %d is ready", name, orderId);
    }
}

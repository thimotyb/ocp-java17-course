package ch04.examples;

/**
 * Demonstrates String methods for removing whitespace covered in Chapter 4: Core APIs.
 *
 * <p>From Chapter 4: Removing Whitespace</p>
 *
 * <p>Key concepts demonstrated:</p>
 * <ul>
 *   <li>strip() - removes whitespace from beginning and end (Unicode-aware)</li>
 *   <li>trim() - removes whitespace from beginning and end (legacy method)</li>
 *   <li>stripLeading() - removes whitespace from beginning only</li>
 *   <li>stripTrailing() - removes whitespace from end only</li>
 *   <li>Whitespace includes: spaces, tabs (\t), newlines (\n), carriage returns (\r)</li>
 *   <li>strip() supports Unicode whitespace; trim() does not</li>
 * </ul>
 *
 * @see java.lang.String#strip()
 * @see java.lang.String#trim()
 * @see java.lang.String#stripLeading()
 * @see java.lang.String#stripTrailing()
 */
public final class StringStripExamples {

    private StringStripExamples() {
    }

    /**
     * Demonstrates strip() method to remove leading and trailing whitespace.
     *
     * <p>strip() is Unicode-aware and removes all leading and trailing whitespace,
     * including Unicode whitespace characters like \u2000.</p>
     *
     * @param value the string to strip
     * @return string with leading and trailing whitespace removed
     */
    public static String strip(String value) {
        return value.strip();  // "\t abc \n".strip() = "abc"
    }

    /**
     * Demonstrates trim() method length after removing whitespace.
     *
     * <p>trim() removes leading and trailing whitespace (spaces, tabs, newlines).
     * Legacy method; strip() is preferred for Unicode support.</p>
     *
     * @param text the string to trim
     * @return length of trimmed string
     */
    public static int trimmedLength(String text) {
        return text.trim().length();  // " abc\t ".trim().length() = 3
    }

    /**
     * Demonstrates strip() method length after removing whitespace.
     *
     * <p>For ASCII whitespace, strip() and trim() produce the same result.
     * strip() additionally handles Unicode whitespace characters.</p>
     *
     * @param text the string to strip
     * @return length of stripped string
     */
    public static int strippedLength(String text) {
        return text.strip().length();  // " abc\t ".strip().length() = 3
    }

    /**
     * Demonstrates stripLeading() - removes only leading whitespace.
     *
     * <p>Removes whitespace from the beginning but preserves trailing whitespace.</p>
     *
     * @param text the string to process
     * @return length after removing leading whitespace
     */
    public static int stripLeadingLength(String text) {
        return text.stripLeading().length();  // " abc\t ".stripLeading().length() = 5 (keeps "\t ")
    }

    /**
     * Demonstrates stripTrailing() - removes only trailing whitespace.
     *
     * <p>Removes whitespace from the end but preserves leading whitespace.</p>
     *
     * @param text the string to process
     * @return length after removing trailing whitespace
     */
    public static int stripTrailingLength(String text) {
        return text.stripTrailing().length();  // " abc\t ".stripTrailing().length() = 4 (keeps " ")
    }
}

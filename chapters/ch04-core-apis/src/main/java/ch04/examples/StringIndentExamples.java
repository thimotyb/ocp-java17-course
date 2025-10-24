package ch04.examples;

/**
 * Demonstrates String indentation methods covered in Chapter 4: Core APIs.
 *
 * <p>From Chapter 4: Working with Indentation</p>
 *
 * <p>Key concepts demonstrated:</p>
 * <ul>
 *   <li>Text blocks vs. concatenated strings - different incidental whitespace handling</li>
 *   <li>indent(n) - adds/removes spaces and normalizes line breaks</li>
 *   <li>stripIndent() - removes incidental whitespace from concatenated strings</li>
 *   <li>Normalization: converts \r\n to \n, adds trailing newline if missing (indent only)</li>
 *   <li>indent(n > 0) - adds n spaces to each line</li>
 *   <li>indent(n < 0) - removes up to n spaces from each line</li>
 *   <li>indent(0) - normalizes only, no indentation change</li>
 * </ul>
 *
 * @see java.lang.String#indent(int)
 * @see java.lang.String#stripIndent()
 */
public final class StringIndentExamples {

    private StringIndentExamples() {
    }

    /**
     * Returns a text block with incidental whitespace already removed.
     *
     * <p>Text blocks automatically strip incidental indentation.
     * This block has 1 space before 'a' and 'c', 2 spaces before 'b'.</p>
     *
     * @return text block: " a\n  b\n c" (6 characters: spaces, letters, newlines)
     */
    public static String block() {
        return """
                a
                 b
                c""";  // Compiler removes common leading whitespace
    }

    /**
     * Returns a concatenated string with explicit whitespace.
     *
     * <p>Unlike text blocks, concatenation preserves all specified whitespace.
     * This has 1 space before 'a', 2 before 'b', 1 before 'c'.</p>
     *
     * @return concatenated string: " a\n  b\n c" (9 characters including all spaces and newlines)
     */
    public static String concat() {
        return " a\n" +    // 1 space + 'a' + newline
                "  b\n" +  // 2 spaces + 'b' + newline
                " c";      // 1 space + 'c' (no trailing newline)
    }

    /**
     * Returns the length of the text block.
     *
     * <p>Text block has already had incidental whitespace stripped by compiler.</p>
     *
     * @return 6 - the character count of block()
     */
    public static int blockLength() {
        return block().length();  // " a\n  b\n c" = 6 chars
    }

    /**
     * Returns the length of the concatenated string.
     *
     * <p>Concatenation preserves all explicit whitespace.</p>
     *
     * @return 9 - the character count of concat()
     */
    public static int concatLength() {
        return concat().length();  // " a\n  b\n c" = 9 chars (more whitespace preserved)
    }

    /**
     * Demonstrates indent() method on a text block.
     *
     * <p>indent() behavior:</p>
     * <ul>
     *   <li>If n > 0: adds n spaces to beginning of each line</li>
     *   <li>If n < 0: removes up to n spaces from each line</li>
     *   <li>If n = 0: no indentation change</li>
     *   <li>Always normalizes line breaks to \n</li>
     *   <li>Always adds trailing newline if missing</li>
     * </ul>
     *
     * @param indent number of spaces to add (positive) or remove (negative)
     * @return length after indentation and normalization
     */
    public static int blockIndentLength(int indent) {
        // block() has 3 lines, no trailing newline
        // indent(1) adds 1 space per line + 1 trailing newline = 6 + 3 + 1 = 10
        return block().indent(indent).length();
    }

    /**
     * Demonstrates indent() method on a concatenated string.
     *
     * <p>indent() normalizes line breaks and adds trailing newline.
     * For concat with 3 lines and explicit whitespace.</p>
     *
     * @param indent number of spaces to add (positive) or remove (negative)
     * @return length after indentation and normalization
     */
    public static int concatIndentLength(int indent) {
        // concat() is " a\n  b\n c" (9 chars)
        // indent(1) adds 1 space to each of 3 lines, adds trailing newline
        // indent(-1) removes 1 space from each line, adds trailing newline
        return concat().indent(indent).length();
    }

    /**
     * Demonstrates stripIndent() method on concatenated string.
     *
     * <p>stripIndent() removes all incidental (common leading) whitespace.
     * Unlike indent(), it does NOT add a trailing newline if missing.
     * Normalizes line breaks to \n.</p>
     *
     * @return length after stripping incidental whitespace
     */
    public static int concatStripIndentLength() {
        // concat() has min 1 space on lines, so removes 1 space from each
        // Does not add trailing newline: " a\n  b\n c" -> "a\n b\nc" = 6 chars
        return concat().stripIndent().length();
    }
}

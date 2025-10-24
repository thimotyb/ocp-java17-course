package ch04.examples;

/**
 * Demonstrates StringBuilder API methods covered in Chapter 4: Core APIs.
 *
 * <p>From Chapter 4: Using the StringBuilder Class</p>
 *
 * <p>Key concepts demonstrated:</p>
 * <ul>
 *   <li>StringBuilder is mutable - methods modify the object in place</li>
 *   <li>Constructors: default (capacity 16), with String, with capacity</li>
 *   <li>append() - adds to end, returns same StringBuilder for chaining</li>
 *   <li>insert() - adds at specific index</li>
 *   <li>delete() - removes range [beginIndex, endIndex)</li>
 *   <li>deleteCharAt() - removes single character</li>
 *   <li>replace() - replaces range with new string</li>
 *   <li>reverse() - reverses character order</li>
 *   <li>Shared references - multiple variables can point to same mutable object</li>
 *   <li>Unlike String, StringBuilder does not override equals()</li>
 * </ul>
 *
 * @see java.lang.StringBuilder
 */
public final class StringBuilderExamples {

    private StringBuilderExamples() {
    }

    /**
     * Demonstrates append() method and method chaining.
     *
     * <p>append() adds to the end and returns the StringBuilder itself,
     * enabling method chaining. Can append various types: int, char, String, boolean.</p>
     *
     * @return "1c-true" - result of chained appends
     */
    public static String appendExample() {
        var sb = new StringBuilder().append(1).append('c');  // Chaining: sb contains "1c"
        sb.append("-").append(true);                          // sb now contains "1c-true"
        return sb.toString();
    }

    /**
     * Demonstrates that StringBuilder is mutable with shared references.
     *
     * <p>Unlike String, StringBuilder is mutable. When multiple variables
     * reference the same StringBuilder, changes through one affect all.
     * append() returns the same StringBuilder object (not a copy).</p>
     *
     * @return "abcdef" - shows both a and b reference same mutable object
     */
    public static String sharedReferenceExample() {
        var a = new StringBuilder("abc");  // a points to StringBuilder("abc")
        var b = a.append("de");            // b points to same object as a, now "abcde"
        b.append("f");                     // Modifies shared object to "abcdef"
        return a.toString();               // a sees the change: "abcdef"
    }

    /**
     * Demonstrates StringBuilder constructors.
     *
     * <p>Three constructors:</p>
     * <ul>
     *   <li>new StringBuilder() - empty, initial capacity 16</li>
     *   <li>new StringBuilder(String) - initialized with string content</li>
     *   <li>new StringBuilder(int) - empty, specified initial capacity</li>
     * </ul>
     *
     * @return ",animal,10" - empty string, "animal", and capacity 10
     */
    public static String createWithCapacity() {
        var sb1 = new StringBuilder();           // Empty, capacity 16
        var sb2 = new StringBuilder("animal");   // Contains "animal"
        var sb3 = new StringBuilder(10);         // Empty, capacity 10
        return sb1.toString() + "," + sb2 + "," + sb3.capacity();
    }

    /**
     * Demonstrates insert() method to add characters at specific positions.
     *
     * <p>insert(index, value) adds value at the specified index, shifting existing
     * characters to the right. Index must be within [0, length()].</p>
     *
     * @return "-ani-mal-s" - result after inserting dashes at various positions
     */
    public static String insertExample() {
        var sb = new StringBuilder("animals");  // "animals"
        sb.insert(7, "-");   // "animals-" (insert at end)
        sb.insert(0, "-");   // "-animals-" (insert at beginning)
        sb.insert(4, "-");   // "-ani-mals-" (insert in middle, shifts right)
        return sb.toString();
    }

    /**
     * Demonstrates delete() method to remove a range of characters.
     *
     * <p>delete(beginIndex, endIndex) removes characters from beginIndex (inclusive)
     * to endIndex (exclusive). Same index semantics as substring().</p>
     *
     * @return "adef" - "bc" removed from positions 1-3
     */
    public static String deleteExample() {
        var sb = new StringBuilder("abcdef");  // "abcdef"
        sb.delete(1, 3);                       // Remove indices 1,2: "adef"
        return sb.toString();
    }

    /**
     * Demonstrates deleteCharAt() with an invalid index.
     *
     * <p>deleteCharAt(index) removes the character at the specified index.
     * Throws StringIndexOutOfBoundsException if index is invalid.</p>
     *
     * @return StringIndexOutOfBoundsException - index 5 is out of bounds for "adef"
     */
    public static Exception deleteCharAtException() {
        var sb = new StringBuilder("abcdef");  // "abcdef"
        sb.delete(1, 3);                       // Now "adef" (length 4, valid indices 0-3)
        try {
            sb.deleteCharAt(5);                // Index 5 is out of bounds
            return null;
        } catch (Exception e) {
            return e;                          // Returns StringIndexOutOfBoundsException
        }
    }

    /**
     * Demonstrates delete() with endIndex past the end.
     *
     * <p>If endIndex exceeds string length, delete() removes to the end.
     * This is lenient behavior - no exception thrown.</p>
     *
     * @return "a" - everything from index 1 to end is deleted
     */
    public static String deletePastEnd() {
        var sb = new StringBuilder("abcdef");  // "abcdef"
        sb.delete(1, 100);                     // Deletes from index 1 to end: "a"
        return sb.toString();
    }

    /**
     * Demonstrates replace() method.
     *
     * <p>replace(beginIndex, endIndex, String) removes characters in the range
     * and inserts the replacement string. Replacement length need not match range.</p>
     *
     * @return "pigsty dirty" - "eon" (indices 3-6) replaced with "sty"
     */
    public static String replaceExample() {
        var builder = new StringBuilder("pigeon dirty");  // "pigeon dirty"
        builder.replace(3, 6, "sty");  // Replace "eon" with "sty": "pigsty dirty"
        return builder.toString();
    }

    /**
     * Demonstrates replace() with empty string and endIndex past end.
     *
     * <p>Replacing with empty string deletes the range.
     * endIndex past end is allowed (deletes to end).</p>
     *
     * @return "pig" - everything from index 3 onward is removed
     */
    public static String replaceWithEmpty() {
        var builder = new StringBuilder("pigeon dirty");  // "pigeon dirty"
        builder.replace(3, 100, "");  // Delete from index 3 to end: "pig"
        return builder.toString();
    }

    /**
     * Demonstrates reverse() method.
     *
     * <p>reverse() reverses the character sequence in place.</p>
     *
     * @return "CBA" - reversed from "ABC"
     */
    public static String reverseExample() {
        var sb = new StringBuilder("ABC");  // "ABC"
        sb.reverse();                       // "CBA"
        return sb.toString();
    }

    /**
     * Demonstrates that StringBuilder does not override equals().
     *
     * <p>Unlike String, StringBuilder uses Object's equals() which compares references.
     * Even with same content, different StringBuilder objects are not equal.
     * Use == to compare references, not content.</p>
     *
     * @return false - different objects, different references
     */
    public static boolean sameReference() {
        var one = new StringBuilder();  // First object
        var two = new StringBuilder();  // Second object (different reference)
        return one == two;              // false - different objects
    }
}

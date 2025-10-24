package ch02.examples;

/**
 * Demonstrates operator precedence and the use of optional parentheses in arithmetic expressions.
 * From Chapter 2: Operators - Operator Precedence
 *
 * <p>This example illustrates key concepts about operator evaluation:</p>
 * <ul>
 *   <li>Multiplication (*) has higher precedence than addition (+)</li>
 *   <li>Operators of the same precedence level are evaluated left-to-right</li>
 *   <li>Parentheses can be used to make precedence explicit (improving readability)</li>
 *   <li>Optional parentheses don't change the result but can clarify intent</li>
 * </ul>
 *
 * <p>The expression {@code 2 * height + 2 * length} is evaluated as:</p>
 * <ol>
 *   <li>First: {@code 2 * height} (multiplication has higher precedence)</li>
 *   <li>Second: {@code 2 * length} (next multiplication)</li>
 *   <li>Finally: Add the two products together</li>
 * </ol>
 *
 * <p>Both methods produce the same result, demonstrating that parentheses can improve
 * code readability without affecting the computed value.</p>
 *
 * @see <a href="https://docs.oracle.com/javase/tutorial/java/nutsandbolts/operators.html">Oracle Java Operators Tutorial</a>
 */
public final class OperatorPerimeter {

    /**
     * Private constructor to prevent instantiation of this utility class.
     */
    private OperatorPerimeter() {
    }

    /**
     * Calculates the perimeter of a rectangle using natural operator precedence.
     *
     * <p>The expression {@code 2 * height + 2 * length} relies on the compiler's
     * understanding that multiplication has higher precedence than addition.
     * The multiplication operations are performed first, then the results are added.</p>
     *
     * @param height the height of the rectangle
     * @param length the length of the rectangle
     * @return the perimeter calculated as 2 * height + 2 * length
     */
    public static int perimeter(int height, int length) {
        // Multiplication (*) has higher precedence than addition (+)
        // Evaluated as: (2 * height) + (2 * length)
        var perimeter = 2 * height + 2 * length;
        return perimeter;
    }

    /**
     * Calculates the perimeter of a rectangle with explicit parentheses for clarity.
     *
     * <p>This method produces the exact same result as {@link #perimeter(int, int)},
     * but uses parentheses to make the order of operations explicit. While not required,
     * this can improve code readability, especially for developers less familiar with
     * operator precedence rules.</p>
     *
     * @param height the height of the rectangle
     * @param length the length of the rectangle
     * @return the perimeter calculated as ((2 * height) + (2 * length))
     */
    public static int perimeterWithParentheses(int height, int length) {
        // Optional parentheses make the order of operations explicit
        // Same result as perimeter(), but potentially more readable
        var perimeter = ((2 * height) + (2 * length));
        return perimeter;
    }
}

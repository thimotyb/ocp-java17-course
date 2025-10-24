package ch02.examples;

/**
 * Demonstrates the division and modulus (remainder) operators in Java.
 * From Chapter 2: Operators - Division and Modulus Operators
 *
 * <p>This example illustrates the critical differences between division and modulus:</p>
 * <ul>
 *   <li><strong>Division (/):</strong> Returns the quotient (integer division for int types)</li>
 *   <li><strong>Modulus (%):</strong> Returns the remainder after division</li>
 *   <li>For integer division, the result is the floor value (no decimal part)</li>
 *   <li>For a given divisor y, modulus results range from 0 to (y-1) for positive dividends</li>
 * </ul>
 *
 * <p>Examples from the book (dividing by 3):</p>
 * <ul>
 *   <li>{@code 9 / 3 = 3}, {@code 9 % 3 = 0} (divides evenly, no remainder)</li>
 *   <li>{@code 10 / 3 = 3}, {@code 10 % 3 = 1} (10 = 3*3 + 1)</li>
 *   <li>{@code 11 / 3 = 3}, {@code 11 % 3 = 2} (11 = 3*3 + 2)</li>
 *   <li>{@code 12 / 3 = 4}, {@code 12 % 3 = 0} (divides evenly, quotient increases)</li>
 * </ul>
 *
 * <p><strong>Key concept:</strong> The division results increase only when the dividend
 * reaches the next multiple of the divisor, while the modulus remainder cycles from
 * 0 to (divisor-1).</p>
 *
 * <p><strong>For the exam:</strong> Understand that integer division truncates (floors)
 * the result, and modulus gives the remainder. Also note that modulus can be applied
 * to negative integers and floating-point numbers, though exam questions typically
 * focus on positive integers.</p>
 *
 * @see <a href="https://docs.oracle.com/javase/tutorial/java/nutsandbolts/operators.html">Oracle Java Operators Tutorial</a>
 */
public final class OperatorDivisionModulus {

    /**
     * Private constructor to prevent instantiation of this utility class.
     */
    private OperatorDivisionModulus() {
    }

    /**
     * Performs both division and modulus operations on the given values.
     *
     * <p>This method demonstrates both operators in a single calculation,
     * returning an array where:</p>
     * <ul>
     *   <li>Index 0: quotient (value / divisor)</li>
     *   <li>Index 1: remainder (value % divisor)</li>
     * </ul>
     *
     * @param value the dividend (number being divided)
     * @param divisor the divisor (number to divide by)
     * @return an array containing [quotient, remainder]
     */
    public static int[] divisions(int value, int divisor) {
        // Division gives quotient, modulus gives remainder
        return new int[] {value / divisor, value % divisor};
    }

    /**
     * Demonstrates division and modulus with a series of examples from the book.
     *
     * <p>Returns a 2D array showing the progression of division and modulus results
     * as the dividend increases from 9 to 12, all divided by 3:</p>
     * <ul>
     *   <li>Row 0: [3, 0] - 9/3 = 3, 9%3 = 0</li>
     *   <li>Row 1: [3, 1] - 10/3 = 3, 10%3 = 1</li>
     *   <li>Row 2: [3, 2] - 11/3 = 3, 11%3 = 2</li>
     *   <li>Row 3: [4, 0] - 12/3 = 4, 12%3 = 0</li>
     * </ul>
     *
     * <p>Notice how the quotient stays at 3 until reaching 12 (the next multiple of 3),
     * while the remainder cycles through 0, 1, 2, then back to 0.</p>
     *
     * @return a 2D array where each row contains [quotient, remainder] for sequential divisions
     */
    public static int[][] demo() {
        return new int[][] {
            {9 / 3, 9 % 3},   // 3, 0 - divides evenly
            {10 / 3, 10 % 3}, // 3, 1 - remainder starts increasing
            {11 / 3, 11 % 3}, // 3, 2 - remainder continues to increase
            {12 / 3, 12 % 3}  // 4, 0 - quotient increases, remainder wraps to 0
        };
    }
}

package ch03.examples;

/**
 * Demonstrates do/while loops and pre-increment operators.
 * From Chapter 3: Making Decisions - Writing while Loops.
 *
 * <p>Key Concepts:
 * <ul>
 *   <li>A do/while loop guarantees the loop body executes at least once</li>
 *   <li>The boolean condition is evaluated AFTER each iteration (not before)</li>
 *   <li>Even if the condition is initially false, the body executes once</li>
 *   <li>Pre-increment (++y) increments before using the value</li>
 *   <li>The loop continues as long as the condition evaluates to true</li>
 * </ul>
 *
 * <p>do/while vs while:
 * <ul>
 *   <li>while: condition checked before first iteration (may execute 0 times)</li>
 *   <li>do/while: condition checked after first iteration (always executes at least once)</li>
 *   <li>do/while guarantees at least one execution regardless of condition</li>
 * </ul>
 *
 * <p>Example Comparison:
 * <pre>
 * // while loop (may not execute at all)
 * int x = 10;
 * while(x < 5) {
 *     System.out.print(x);  // Never executes (condition is false from start)
 * }
 *
 * // do/while loop (always executes once)
 * int x = 10;
 * do {
 *     System.out.print(x);  // Executes once, then checks condition
 * } while(x < 5);           // Condition false, loop exits
 * </pre>
 *
 * <p>Pre-increment vs Post-increment:
 * <ul>
 *   <li>Pre-increment (++y): increment first, then use the value</li>
 *   <li>Post-increment (y++): use the value first, then increment</li>
 *   <li>Example: {@code y=-2; print(++y)} outputs -1 (increments to -1, then prints)</li>
 *   <li>Example: {@code y=-2; print(y++)} outputs -2 (prints -2, then increments to -1)</li>
 * </ul>
 *
 * @see <a href="https://learning.oreilly.com/library/view/ocp-oracle-certified/9781119864585/c03.xhtml">Chapter 3: Making Decisions</a>
 */
public class PrintIntegers {

    /**
     * Prints integers using a do/while loop with pre-increment operator.
     *
     * <p>This method demonstrates the key characteristic of do/while loops:
     * the loop body is guaranteed to execute at least once, even if the
     * condition would initially be false.
     *
     * <p>Execution Flow:
     * <ol>
     *   <li>Initialize y = -2</li>
     *   <li>Enter do block (no condition check yet)</li>
     *   <li>++y increments y to -1, then prints "-1 "</li>
     *   <li>Check condition: y <= 5? (-1 <= 5 is true)</li>
     *   <li>++y increments y to 0, then prints "0 "</li>
     *   <li>Check condition: y <= 5? (0 <= 5 is true)</li>
     *   <li>Continue this pattern...</li>
     *   <li>++y increments y to 5, then prints "5 "</li>
     *   <li>Check condition: y <= 5? (5 <= 5 is true)</li>
     *   <li>++y increments y to 6, then prints "6 "</li>
     *   <li>Check condition: y <= 5? (6 <= 5 is false)</li>
     *   <li>Loop exits</li>
     * </ol>
     *
     * <p>Output: {@code -1 0 1 2 3 4 5 6 }
     *
     * <p>Key Points:
     * <ul>
     *   <li>Loop executes with values: -1, 0, 1, 2, 3, 4, 5, 6</li>
     *   <li>Starts at -1 (not -2) because ++y increments before printing</li>
     *   <li>Ends at 6 (not 5) because condition is checked AFTER increment and print</li>
     *   <li>Total of 8 iterations (from -1 to 6 inclusive)</li>
     * </ul>
     *
     * <p>Why 6 is printed even though condition is y <= 5:
     * <ul>
     *   <li>When y=5, condition (5 <= 5) is true, so loop continues</li>
     *   <li>++y increments to 6 and prints "6 "</li>
     *   <li>THEN condition (6 <= 5) is checked and found false</li>
     *   <li>Loop exits after printing 6</li>
     * </ul>
     *
     * <p>Contrast with while loop:
     * <pre>
     * int y = -2;
     * while(y <= 5) {           // Checks condition BEFORE body
     *     System.out.print(++y + " ");
     * }
     * // Output would be the same: -1 0 1 2 3 4 5 6
     * </pre>
     *
     * @param args command line arguments (not used)
     */
    public static void main(String[] args) {
        int y = -2;

        // do/while guarantees at least one execution
        do {
            // Pre-increment: increments y first, then uses the new value
            // First iteration: y becomes -1, prints "-1 "
            // Second iteration: y becomes 0, prints "0 "
            // ... continues until y becomes 6
            System.out.print(++y + " ");

        } while (y <= 5);  // Condition checked AFTER each iteration
        // When y=6, condition (6 <= 5) is false, loop exits
    }
}

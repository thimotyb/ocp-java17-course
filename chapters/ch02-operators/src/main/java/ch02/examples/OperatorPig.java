package ch02.examples;

/**
 * Demonstrates post-increment operator behavior and compound assignment operators with casting.
 * From Chapter 2: Operators - Increment/Decrement Operators and Compound Assignment Operators
 *
 * <p>This example illustrates several subtle and important concepts:</p>
 * <ul>
 *   <li><strong>Post-increment trap:</strong> {@code pig = pig++} assigns the ORIGINAL value back to pig</li>
 *   <li><strong>Casting in assignments:</strong> Explicit casts from larger to smaller types</li>
 *   <li><strong>Compound assignment operators:</strong> {@code -=} performs implicit casting</li>
 *   <li><strong>Numeric promotion:</strong> Automatic type conversion in compound operators</li>
 * </ul>
 *
 * <p><strong>Critical exam trap - Post-increment self-assignment:</strong></p>
 * <p>The expression {@code pig = pig++} behaves as follows:</p>
 * <ol>
 *   <li>Post-increment returns the ORIGINAL value (4) before incrementing</li>
 *   <li>pig is temporarily incremented to 5</li>
 *   <li>Assignment operator stores the original value (4) back into pig</li>
 *   <li>Result: pig remains 4 (the increment is effectively lost!)</li>
 * </ol>
 *
 * <p><strong>Compound assignment with casting:</strong></p>
 * <p>The expression {@code goat -= 1.0} is equivalent to {@code goat = (long)(goat - 1.0)}:</p>
 * <ol>
 *   <li>goat (long 2) is promoted to double for subtraction with 1.0</li>
 *   <li>Result is double 1.0</li>
 *   <li>Compound operator automatically casts back to long (1)</li>
 * </ol>
 *
 * <p><strong>For the exam:</strong> Post-increment in self-assignment is a common trap.
 * Remember that {@code x = x++} leaves x unchanged!</p>
 *
 * @see <a href="https://docs.oracle.com/javase/tutorial/java/nutsandbolts/operators.html">Oracle Java Operators Tutorial</a>
 */
public final class OperatorPig {

    /**
     * Private constructor to prevent instantiation of this utility class.
     */
    private OperatorPig() {
    }

    /**
     * Evaluates expressions demonstrating post-increment trap and compound assignment.
     *
     * <p>Detailed execution flow:</p>
     * <ol>
     *   <li>{@code pig = (short) 4} - Casting (short) to int, pig = 4</li>
     *   <li>{@code pig = pig++} - Post-increment returns 4, increments to 5, then assigns 4 back. pig = 4!</li>
     *   <li>{@code goat = (int) 2} - Casting int to long, goat = 2</li>
     *   <li>{@code goat -= 1.0} - Equivalent to goat = (long)(goat - 1.0). goat = 1</li>
     * </ol>
     *
     * <p><strong>Why pig remains 4:</strong> The post-increment operator returns the original
     * value before incrementing. So {@code pig++} returns 4, then increments pig to 5, but
     * the assignment {@code pig =} stores 4 back, overwriting the incremented value.</p>
     *
     * @return a Result record containing pig=4, goat=1
     */
    public static Result evaluate() {
        // Cast short to int (widening, automatic)
        int pig = (short) 4;

        // TRAP: Post-increment in self-assignment
        // pig++ returns 4 (original), increments pig to 5, then assignment stores 4 back
        // Result: pig = 4 (increment is lost!)
        pig = pig++;

        // Cast int to long (widening, automatic)
        long goat = (int) 2;

        // Compound assignment with implicit casting
        // Equivalent to: goat = (long)(goat - 1.0)
        // goat (2L) promoted to double, subtracted, result 1.0 cast back to long
        goat -= 1.0;

        return new Result(pig, goat);
    }

    /**
     * Main method to demonstrate post-increment trap and compound assignment.
     * Outputs: 4 - 1
     *
     * @param args command line arguments (not used)
     */
    public static void main(String[] args) {
        Result result = evaluate();
        System.out.print(result.pig() + " - " + result.goat());
    }

    /**
     * Record to hold the evaluation results.
     *
     * @param pig the value after post-increment self-assignment (4, not 5!)
     * @param goat the value after compound subtraction assignment (1)
     */
    public record Result(int pig, long goat) {
    }
}

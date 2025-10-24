package ch02.examples;

/**
 * Demonstrates the logical exclusive OR (XOR) operator and assignment as a side effect.
 * From Chapter 2: Operators - Logical Operators
 *
 * <p>This example illustrates several critical concepts:</p>
 * <ul>
 *   <li><strong>Logical XOR (^):</strong> Returns true only if operands are different (one true, one false)</li>
 *   <li><strong>Assignment side effects:</strong> {@code (wolf = false)} assigns false to wolf AND returns false</li>
 *   <li><strong>Operator evaluation:</strong> Both sides of XOR are always evaluated (no short-circuiting)</li>
 *   <li><strong>Inequality operator (!=):</strong> Compares numeric values for inequality</li>
 * </ul>
 *
 * <p>Truth table for XOR (^):</p>
 * <ul>
 *   <li>true ^ true = false</li>
 *   <li>true ^ false = true</li>
 *   <li>false ^ true = true</li>
 *   <li>false ^ false = false</li>
 * </ul>
 *
 * <p>Evaluation of {@code (teeth != 10) ^ (wolf = false)}:</p>
 * <ol>
 *   <li>Left side: {@code (teeth != 10)} evaluates to {@code (20 != 10)} = true</li>
 *   <li>Right side: {@code (wolf = false)} assigns false to wolf AND returns false</li>
 *   <li>XOR: {@code true ^ false} = true</li>
 *   <li>Result: canine = true, teeth = 20, wolf = false</li>
 * </ol>
 *
 * <p><strong>For the exam:</strong> Watch for assignment operators embedded in expressions.
 * They both modify the variable AND return the assigned value.</p>
 *
 * @see <a href="https://docs.oracle.com/javase/tutorial/java/nutsandbolts/operators.html">Oracle Java Operators Tutorial</a>
 */
public final class OperatorCanine {

    /**
     * Private constructor to prevent instantiation of this utility class.
     */
    private OperatorCanine() {
    }

    /**
     * Evaluates an expression demonstrating XOR and assignment side effects.
     *
     * <p>Step-by-step execution:</p>
     * <ol>
     *   <li>Initialize: canine = true, wolf = true, teeth = 20</li>
     *   <li>Evaluate left side: (20 != 10) = true</li>
     *   <li>Evaluate right side: (wolf = false) assigns false to wolf, returns false</li>
     *   <li>Apply XOR: true ^ false = true</li>
     *   <li>Assign result: canine = true</li>
     * </ol>
     *
     * <p>Note: The XOR operator (^) evaluates both sides, unlike conditional operators
     * (&& and ||) which may short-circuit. This ensures the assignment {@code wolf = false}
     * always executes.</p>
     *
     * @return a Result record containing canine=true, teeth=20, wolf=false
     */
    public static Result evaluate() {
        boolean canine = true, wolf = true;
        int teeth = 20;

        // XOR (^) evaluates both sides (no short-circuit)
        // Left: (teeth != 10) = (20 != 10) = true
        // Right: (wolf = false) assigns false to wolf and returns false
        // Result: true ^ false = true
        canine = (teeth != 10) ^ (wolf = false);

        return new Result(canine, teeth, wolf);
    }

    /**
     * Main method to demonstrate the logical XOR operator.
     * Outputs: true, 20, false
     *
     * @param args command line arguments (not used)
     */
    public static void main(String[] args) {
        Result result = evaluate();
        System.out.println(result.canine() + ", " + result.teeth() + ", " + result.wolf());
    }

    /**
     * Record to hold the evaluation results.
     *
     * @param canine the result of the XOR operation (true)
     * @param teeth the unchanged teeth value (20)
     * @param wolf the modified wolf value after assignment (false)
     */
    public record Result(boolean canine, int teeth, boolean wolf) {
    }
}

package ch02.examples;

/**
 * Demonstrates logical operators, conditional operators, and short-circuit evaluation.
 * From Chapter 2: Operators - Logical Operators and Conditional Operators
 *
 * <p>This example illustrates the critical differences between logical and conditional operators:</p>
 * <ul>
 *   <li><strong>Logical AND (&):</strong> Evaluates BOTH sides, no short-circuiting</li>
 *   <li><strong>Conditional AND (&&):</strong> Short-circuits if left side is false</li>
 *   <li><strong>Logical OR (|):</strong> Evaluates BOTH sides, no short-circuiting</li>
 *   <li><strong>Conditional OR (||):</strong> Short-circuits if left side is true</li>
 *   <li><strong>Pre-decrement (--variable):</strong> Decrements before using the value</li>
 * </ul>
 *
 * <p><strong>Key concept - Short-circuit evaluation:</strong></p>
 * <p>Conditional operators (&& and ||) can skip evaluating the right side, preventing
 * side effects like variable modifications from occurring. This is crucial for the exam!</p>
 *
 * <p>Step-by-step evaluation with initial values ph=7, vis=2:</p>
 * <ol>
 *   <li><strong>clear = vis > 1 & (vis < 9 || ph < 2)</strong>
 *       <ul>
 *         <li>vis > 1: 2 > 1 = true</li>
 *         <li>(vis < 9 || ph < 2): (2 < 9 || 7 < 2) = (true || false) = true</li>
 *         <li>true & true = true</li>
 *       </ul>
 *   </li>
 *   <li><strong>safe = (vis > 2) && (ph++ > 1)</strong>
 *       <ul>
 *         <li>vis > 2: 2 > 2 = false</li>
 *         <li>Short-circuit! Right side NOT evaluated, ph remains 7</li>
 *         <li>Result: false (ph is still 7)</li>
 *       </ul>
 *   </li>
 *   <li><strong>tasty = 7 <= --ph</strong>
 *       <ul>
 *         <li>--ph: decrements ph from 7 to 6, returns 6</li>
 *         <li>7 <= 6 = false</li>
 *       </ul>
 *   </li>
 * </ol>
 *
 * <p>Final values: clear=true, safe=false, tasty=false, ph=6, vis=2</p>
 *
 * <p><strong>For the exam:</strong> Watch for unperformed side effects. If the right side
 * of a conditional operator contains an increment/decrement, it might not execute!</p>
 *
 * @see <a href="https://docs.oracle.com/javase/tutorial/java/nutsandbolts/operators.html">Oracle Java Operators Tutorial</a>
 */
public final class OperatorWaterQuality {

    /**
     * Private constructor to prevent instantiation of this utility class.
     */
    private OperatorWaterQuality() {
    }

    /**
     * Evaluates expressions demonstrating short-circuit behavior and side effects.
     *
     * <p>Detailed execution with initial values ph=7, vis=2:</p>
     * <ol>
     *   <li>clear: Uses logical AND (&) which evaluates both sides = true</li>
     *   <li>safe: Uses conditional AND (&&) which short-circuits, ph++ NOT executed, ph=7</li>
     *   <li>tasty: Uses pre-decrement, ph becomes 6, then compares 7 <= 6 = false</li>
     * </ol>
     *
     * <p><strong>Important:</strong> The conditional AND in the 'safe' expression prevents
     * {@code ph++} from executing because {@code (vis > 2)} is false. This demonstrates
     * the power (and potential pitfalls) of short-circuit evaluation.</p>
     *
     * @return a Result record containing clear=true, safe=false, tasty=false, ph=6, vis=2
     */
    public static Result evaluate() {
        int ph = 7, vis = 2;

        // Logical AND (&) - evaluates BOTH sides (no short-circuit)
        // Left: vis > 1 = 2 > 1 = true
        // Right: (vis < 9 || ph < 2) = (true || false) = true
        // Result: true & true = true
        boolean clear = vis > 1 & (vis < 9 || ph < 2);

        // Conditional AND (&&) - SHORT-CIRCUITS if left is false
        // Left: (vis > 2) = (2 > 2) = false
        // Right side NOT evaluated! ph++ does NOT execute, ph remains 7
        // Result: false
        boolean safe = (vis > 2) && (ph++ > 1);

        // Pre-decrement: decrements ph from 7 to 6, then uses 6 in comparison
        // --ph decrements ph to 6 and returns 6
        // 7 <= 6 = false
        boolean tasty = 7 <= --ph;

        // Final state: clear=true, safe=false, tasty=false, ph=6 (not 8!), vis=2
        return new Result(clear, safe, tasty, ph, vis);
    }

    /**
     * Record to hold the evaluation results.
     *
     * @param clear result of logical AND expression (true)
     * @param safe result of conditional AND with unperformed side effect (false)
     * @param tasty result of pre-decrement comparison (false)
     * @param ph the final ph value after pre-decrement (6, not 8 due to short-circuit)
     * @param vis the unchanged vis value (2)
     */
    public record Result(boolean clear, boolean safe, boolean tasty, int ph, int vis) {
    }
}

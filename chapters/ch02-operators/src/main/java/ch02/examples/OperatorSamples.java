package ch02.examples;

/**
 * Demonstrates modulus operator and operator precedence with multiple operators.
 * From Chapter 2: Operators - Division and Modulus Operators
 *
 * <p>This example illustrates how operator precedence affects evaluation order:</p>
 * <ul>
 *   <li><strong>Multiplication and modulus:</strong> Both have the same precedence level</li>
 *   <li><strong>Left-to-right evaluation:</strong> Operators of equal precedence are evaluated left-to-right</li>
 *   <li><strong>Parentheses:</strong> Override default precedence and force specific evaluation order</li>
 *   <li><strong>Modulus (%):</strong> Returns the remainder after division</li>
 * </ul>
 *
 * <p>Detailed evaluation of each sample:</p>
 * <ol>
 *   <li><strong>sample1 = (2 * 4) % 3</strong>
 *       <ul>
 *         <li>Parentheses force multiplication first: 2 * 4 = 8</li>
 *         <li>Then modulus: 8 % 3 = 2 (8 = 3*2 + 2)</li>
 *         <li>Result: 2</li>
 *       </ul>
 *   </li>
 *   <li><strong>sample2 = 3 * 2 % 3</strong>
 *       <ul>
 *         <li>No parentheses, but * and % have same precedence</li>
 *         <li>Left-to-right evaluation: 3 * 2 = 6 first</li>
 *         <li>Then: 6 % 3 = 0 (6 divides evenly by 3)</li>
 *         <li>Result: 0</li>
 *       </ul>
 *   </li>
 *   <li><strong>sample3 = 5 * (1 % 2)</strong>
 *       <ul>
 *         <li>Parentheses force modulus first: 1 % 2 = 1 (1 = 2*0 + 1)</li>
 *         <li>Then multiplication: 5 * 1 = 5</li>
 *         <li>Result: 5</li>
 *       </ul>
 *   </li>
 * </ol>
 *
 * <p>Final results: [2, 0, 5]</p>
 *
 * <p><strong>Key insight:</strong> Even though * and % have the same precedence,
 * parentheses can change the evaluation order and produce different results.</p>
 *
 * <p><strong>For the exam:</strong> Remember that multiplicative operators (*, /, %)
 * all have the same precedence and are evaluated left-to-right unless parentheses
 * change the order.</p>
 *
 * @see <a href="https://docs.oracle.com/javase/tutorial/java/nutsandbolts/operators.html">Oracle Java Operators Tutorial</a>
 */
public final class OperatorSamples {

    /**
     * Private constructor to prevent instantiation of this utility class.
     */
    private OperatorSamples() {
    }

    /**
     * Evaluates three expressions demonstrating operator precedence and modulus.
     *
     * <p>Each sample shows a different aspect of precedence:</p>
     * <ul>
     *   <li>sample1: Parentheses force multiplication before modulus</li>
     *   <li>sample2: Left-to-right evaluation of equal-precedence operators</li>
     *   <li>sample3: Parentheses force modulus before multiplication</li>
     * </ul>
     *
     * @return an array containing [2, 0, 5] demonstrating the evaluation results
     */
    public static int[] evaluate() {
        // Sample 1: Parentheses force multiplication first
        // (2 * 4) = 8, then 8 % 3 = 2
        int sample1 = (2 * 4) % 3;

        // Sample 2: Equal precedence, left-to-right evaluation
        // 3 * 2 = 6, then 6 % 3 = 0
        int sample2 = 3 * 2 % 3;

        // Sample 3: Parentheses force modulus first
        // (1 % 2) = 1, then 5 * 1 = 5
        int sample3 = 5 * (1 % 2);

        return new int[] {sample1, sample2, sample3};
    }
}

package ch02.examples;

/**
 * Demonstrates how parentheses can override operator precedence to change evaluation order.
 * From Chapter 2: Operators - Adding Parentheses and Changing the Order of Operation
 *
 * <p>This example illustrates critical concepts about operator precedence:</p>
 * <ul>
 *   <li>Multiplicative operators (*, /, %) have higher precedence than additive operators (+, -)</li>
 *   <li>Without parentheses, multiplications are performed before additions/subtractions</li>
 *   <li>Parentheses override default precedence and force specific evaluation order</li>
 *   <li>Same values and operators can produce different results based on parentheses placement</li>
 * </ul>
 *
 * <p>Comparison of the two main expressions:</p>
 * <ul>
 *   <li><strong>Without parentheses:</strong> {@code 2 * 5 + 3 * 4 - 8 = 14}
 *       <br>Evaluated as: (2*5) + (3*4) - 8 = 10 + 12 - 8 = 14</li>
 *   <li><strong>With parentheses:</strong> {@code 2 * ((5 + 3) * 4 - 8) = 48}
 *       <br>Evaluated as: 2 * ((8 * 4) - 8) = 2 * (32 - 8) = 2 * 24 = 48</li>
 * </ul>
 *
 * <p><strong>For the exam:</strong> Be prepared to trace through complex expressions
 * with multiple operators and parentheses, applying precedence rules carefully.</p>
 *
 * @see <a href="https://docs.oracle.com/javase/tutorial/java/nutsandbolts/operators.html">Oracle Java Operators Tutorial</a>
 */
public final class OperatorPrice {

    /**
     * Private constructor to prevent instantiation of this utility class.
     */
    private OperatorPrice() {
    }

    /**
     * Calculates price using natural operator precedence without parentheses.
     *
     * <p>Step-by-step evaluation:</p>
     * <ol>
     *   <li>{@code 2 * 5 = 10} (first multiplication)</li>
     *   <li>{@code 3 * 4 = 12} (second multiplication)</li>
     *   <li>{@code 10 + 12 = 22} (addition, left-to-right)</li>
     *   <li>{@code 22 - 8 = 14} (subtraction)</li>
     * </ol>
     *
     * @return 14 (the result of evaluating 2 * 5 + 3 * 4 - 8)
     */
    public static int simpleExpression() {
        // Multiplicative operators have higher precedence than additive
        // Evaluated as: (2*5) + (3*4) - 8 = 10 + 12 - 8 = 14
        int price = 2 * 5 + 3 * 4 - 8;
        return price;
    }

    /**
     * Calculates price using parentheses to override default operator precedence.
     *
     * <p>Step-by-step evaluation (innermost parentheses first):</p>
     * <ol>
     *   <li>{@code 5 + 3 = 8} (parentheses force addition before multiplication)</li>
     *   <li>{@code 8 * 4 = 32} (next level of parentheses)</li>
     *   <li>{@code 32 - 8 = 24} (subtraction within outer parentheses)</li>
     *   <li>{@code 2 * 24 = 48} (final multiplication)</li>
     * </ol>
     *
     * <p>Note: Same values and operators as {@link #simpleExpression()}, but different result!</p>
     *
     * @return 48 (the result of evaluating 2 * ((5 + 3) * 4 - 8))
     */
    public static int expressionWithParentheses() {
        // Parentheses override precedence: work from innermost to outermost
        // Step 1: (5 + 3) = 8
        // Step 2: (8 * 4) = 32
        // Step 3: (32 - 8) = 24
        // Step 4: 2 * 24 = 48
        int price = 2 * ((5 + 3) * 4 - 8);
        return price;
    }

    /**
     * Shows the final multiplication step from {@link #expressionWithParentheses()}.
     *
     * <p>This represents the last step after all parentheses have been evaluated
     * in the expression {@code 2 * ((5 + 3) * 4 - 8)}.</p>
     *
     * @return 48 (the result of evaluating 2 * 24)
     */
    public static int expressionAfterPromotion() {
        // This is the final step of expressionWithParentheses()
        // after reducing ((5 + 3) * 4 - 8) to 24
        int price = 2 * 24;
        return price;
    }
}

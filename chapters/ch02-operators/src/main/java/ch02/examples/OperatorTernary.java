package ch02.examples;

/**
 * Demonstrates the ternary operator (conditional operator) and unperformed side effects.
 * From Chapter 2: Operators - Making Decisions with the Ternary Operator
 *
 * <p>This example illustrates critical concepts about the ternary operator:</p>
 * <ul>
 *   <li><strong>Syntax:</strong> {@code booleanExpression ? expression1 : expression2}</li>
 *   <li><strong>Evaluation:</strong> Only ONE of the two expressions is evaluated</li>
 *   <li><strong>Unperformed side effects:</strong> The non-selected expression never executes</li>
 *   <li><strong>Nested ternaries:</strong> Can be nested but require careful reading</li>
 *   <li><strong>Assignment in ternary:</strong> Can combine with assignment operators</li>
 * </ul>
 *
 * <p><strong>Key concept - Unperformed side effects:</strong></p>
 * <p>Just like conditional operators (&& and ||), ternary operators only evaluate
 * the expression that will be used. If an expression contains an increment/decrement
 * but is not selected, that side effect never occurs!</p>
 *
 * <p>Detailed evaluation with initial values a=2, b=4, c=2:</p>
 * <ol>
 *   <li><strong>first = (a > 2 ? --c : b++)</strong>
 *       <ul>
 *         <li>Condition: a > 2 = 2 > 2 = false</li>
 *         <li>False branch: b++ returns 4, then b becomes 5</li>
 *         <li>first = 4, b = 5, c = 2 (--c not executed)</li>
 *       </ul>
 *   </li>
 *   <li><strong>second = (b = (a != c ? a : b++))</strong>
 *       <ul>
 *         <li>Condition: a != c = 2 != 2 = false</li>
 *         <li>False branch: b++ returns 5, then b becomes 6</li>
 *         <li>Inner result assigned to b: b = 5</li>
 *         <li>second = 5 (the assignment expression returns its value)</li>
 *       </ul>
 *   </li>
 *   <li><strong>third = (a > b ? (b < c ? b : 2) : 1)</strong>
 *       <ul>
 *         <li>Condition: a > b = 2 > 5 = false</li>
 *         <li>False branch: 1</li>
 *         <li>third = 1 (nested ternary not evaluated)</li>
 *       </ul>
 *   </li>
 * </ol>
 *
 * <p>Final values: first=4, second=5, third=1, a=2, b=5, c=2</p>
 *
 * <p><strong>For the exam:</strong> Trace ternary expressions carefully, noting which
 * branch is taken and which side effects are skipped. Nested ternaries require reading
 * from innermost parentheses outward.</p>
 *
 * @see <a href="https://docs.oracle.com/javase/tutorial/java/nutsandbolts/operators.html">Oracle Java Operators Tutorial</a>
 */
public final class OperatorTernary {

    /**
     * Private constructor to prevent instantiation of this utility class.
     */
    private OperatorTernary() {
    }

    /**
     * Evaluates multiple ternary expressions with side effects and nested conditions.
     *
     * <p>Detailed execution with initial values a=2, b=4, c=2:</p>
     * <ol>
     *   <li>first: a > 2 is false, so b++ executes (returns 4, b becomes 5). first=4</li>
     *   <li>second: a != c is false, so b++ executes (returns 5, b becomes 6), but then
     *       assignment makes b=5. second=5</li>
     *   <li>third: a > b is false (2 > 5), so returns 1. third=1</li>
     * </ol>
     *
     * <p><strong>Important:</strong> Each ternary only evaluates one branch, so some
     * increments/decrements never execute. Track which variables change!</p>
     *
     * @return a Result record containing first=4, second=5, third=1, a=2, b=5, c=2
     */
    public static Result evaluate() {
        int a = 2, b = 4, c = 2;

        // Ternary 1: (a > 2 ? --c : b++)
        // Condition: 2 > 2 = false
        // FALSE branch: b++ returns 4 (original), then b becomes 5
        // first = 4, b = 5, c unchanged (--c not executed)
        int first = (a > 2 ? --c : b++);

        // Ternary 2: (b = (a != c ? a : b++))
        // Condition: 2 != 2 = false
        // FALSE branch: b++ returns 5 (current value), then b becomes 6
        // BUT assignment b = 5 happens, so b ends up as 5
        // second = 5 (assignment returns the assigned value)
        int second = (b = (a != c ? a : b++));

        // Ternary 3 (nested): (a > b ? (b < c ? b : 2) : 1)
        // Outer condition: 2 > 5 = false
        // FALSE branch: 1
        // Inner ternary never evaluated
        // third = 1
        int third = (a > b ? (b < c ? b : 2) : 1);

        // Final state: first=4, second=5, third=1, a=2, b=5, c=2
        return new Result(first, second, third, a, b, c);
    }

    /**
     * Main method to demonstrate ternary operator behavior.
     * Outputs: 4, 5, 1 (each on a separate line)
     *
     * @param args command line arguments (not used)
     */
    public static void main(String[] args) {
        Result result = evaluate();
        System.out.println(result.first());
        System.out.println(result.second());
        System.out.println(result.third());
    }

    /**
     * Record to hold the evaluation results.
     *
     * @param first result of first ternary with post-increment (4)
     * @param second result of second ternary with assignment side effect (5)
     * @param third result of nested ternary (1)
     * @param a the unchanged a value (2)
     * @param b the modified b value after ternary evaluations (5)
     * @param c the unchanged c value (2, decrement never executed)
     */
    public record Result(int first, int second, int third, int a, int b, int c) {
    }
}

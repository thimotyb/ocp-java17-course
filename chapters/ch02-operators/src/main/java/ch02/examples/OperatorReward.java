package ch02.examples;

/**
 * Demonstrates operator precedence and evaluation order in Java expressions.
 * From Chapter 2: Operators - Understanding Java Operators
 *
 * <p>This example illustrates several key concepts:</p>
 * <ul>
 *   <li>Operator precedence: multiplication (*) has higher precedence than addition (+)</li>
 *   <li>Pre-decrement operator (--) is evaluated before the multiplication</li>
 *   <li>Right-to-left evaluation for certain operators in complex expressions</li>
 *   <li>Automatic promotion from int to double in assignment</li>
 * </ul>
 *
 * <p>The expression {@code 3 + 2 * --cookies} is evaluated as follows:</p>
 * <ol>
 *   <li>First, {@code --cookies} decrements cookies from 4 to 3</li>
 *   <li>Then, {@code 2 * 3} is calculated, resulting in 6</li>
 *   <li>Finally, {@code 3 + 6} produces 9</li>
 *   <li>The int value 9 is automatically promoted to double 9.0</li>
 * </ol>
 *
 * @see <a href="https://docs.oracle.com/javase/tutorial/java/nutsandbolts/operators.html">Oracle Java Operators Tutorial</a>
 */
public final class OperatorReward {

    /**
     * Private constructor to prevent instantiation of this utility class.
     */
    private OperatorReward() {
    }

    /**
     * Calculates reward points demonstrating operator precedence.
     *
     * <p>This method demonstrates the order of operations in Java:</p>
     * <ul>
     *   <li>Pre-unary operators (--) are evaluated first</li>
     *   <li>Multiplication (*) has higher precedence than addition (+)</li>
     *   <li>Assignment (=) has the lowest precedence</li>
     * </ul>
     *
     * @return a Result record containing the final cookies count (3) and reward value (9.0)
     */
    public static Result calculate() {
        int cookies = 4;
        // Expression evaluates right-to-left for pre-decrement, then applies precedence rules
        // Step 1: --cookies changes cookies from 4 to 3 and returns 3
        // Step 2: 2 * 3 = 6 (multiplication has higher precedence than addition)
        // Step 3: 3 + 6 = 9
        // Step 4: int 9 is promoted to double 9.0
        double reward = 3 + 2 * --cookies;
        return new Result(cookies, reward);
    }

    /**
     * Main method to demonstrate the operator precedence example.
     *
     * @param args command line arguments (not used)
     */
    public static void main(String[] args) {
        Result result = calculate();
        System.out.print("Zoo animal receives: " + result.reward() + " reward points");
    }

    /**
     * Record to hold the calculation results.
     *
     * @param cookies the final value of cookies after decrement (3)
     * @param reward the calculated reward value (9.0)
     */
    public record Result(int cookies, double reward) {
    }
}

package ch03.examples;

/**
 * Demonstrates if/else statements and conditional control flow.
 * From Chapter 3: Making Decisions - Creating Decision-Making Statements.
 *
 * <p>Key Concepts:
 * <ul>
 *   <li>The {@code if} statement executes a block only when a boolean expression evaluates to {@code true}</li>
 *   <li>The {@code else} statement provides an alternative path when the if condition is {@code false}</li>
 *   <li>The {@code else if} statement allows chaining multiple conditions for refined branching</li>
 *   <li>Blocks with braces ({}) are preferred even for single statements to improve maintainability</li>
 *   <li>Boolean expressions in if statements must evaluate to a boolean value (not 0 or 1)</li>
 * </ul>
 *
 * <p>Important Rules:
 * <ul>
 *   <li>Indentation does not affect execution - only braces matter for block scope</li>
 *   <li>Without braces, only the first statement after if/else is part of the conditional</li>
 *   <li>Each condition is evaluated only once per execution path</li>
 * </ul>
 *
 * @see <a href="https://learning.oreilly.com/library/view/ocp-oracle-certified/9781119864585/c03.xhtml">Chapter 3: Making Decisions</a>
 */
public final class IfExamples {

    private IfExamples() {
    }

    /**
     * Demonstrates if/else if/else chain for time-based greeting selection.
     *
     * <p>This method shows how multiple conditions can be chained using {@code else if}
     * to provide refined branching logic. The Java process continues execution until
     * it encounters an if statement that evaluates to true, or reaches the final else block.
     *
     * <p>Execution flow:
     * <ol>
     *   <li>First evaluates if hourOfDay < 11 (morning)</li>
     *   <li>If false, evaluates if hourOfDay < 15 (afternoon)</li>
     *   <li>If false, executes the else block (evening)</li>
     * </ol>
     *
     * <p>Each condition is evaluated at most once, and only one branch executes.
     *
     * @param hourOfDay the hour in 24-hour format (0-23)
     * @return the appropriate greeting string: "Good Morning", "Good Afternoon", or "Good Evening"
     */
    public static String greet(int hourOfDay) {
        // First condition: morning greeting (hours 0-10)
        if (hourOfDay < 11) {
            System.out.println("Good Morning");
            return "Good Morning";
        } else if (hourOfDay < 15) {
            // Second condition: afternoon greeting (hours 11-14)
            System.out.println("Good Afternoon");
            return "Good Afternoon";
        } else {
            // Default: evening greeting (hours 15-23)
            System.out.println("Good Evening");
            return "Good Evening";
        }
    }

    /**
     * Demonstrates using a block with braces to group multiple statements in an if block.
     *
     * <p>This method illustrates the advantage of using blocks even for small pieces of code.
     * The block allows multiple statements (print and increment) to execute together when
     * the condition is true. Without braces, only the first statement would be conditional.
     *
     * <p>Example of potential pitfall without braces:
     * <pre>
     * if (hourOfDay < 11)
     *     System.out.println("Good Morning");
     *     morningGreetingCount++;  // This ALWAYS executes regardless of condition!
     * </pre>
     *
     * <p>With braces (as shown in the implementation), both statements execute
     * only when the condition is true.
     *
     * @param hourOfDay the hour in 24-hour format (0-23)
     * @return 1 if it's morning (hourOfDay < 11), otherwise 0
     */
    public static int morningGreetingCount(int hourOfDay) {
        int morningGreetingCount = 0;
        // Both statements in the block execute only when hourOfDay < 11
        if (hourOfDay < 11) {
            System.out.println("Good Morning");
            morningGreetingCount++;  // Incremented only when condition is true
        }
        return morningGreetingCount;
    }
}

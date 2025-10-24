package ch03.examples;

/**
 * Demonstrates switch expressions with arrow syntax (Java 14+).
 * From Chapter 3: Making Decisions - The switch Expression.
 *
 * <p>Key Concepts:
 * <ul>
 *   <li>Switch expressions (Java 14+) are a compact form of switch statements that return values</li>
 *   <li>Uses the arrow operator (->) instead of colon (:) for case branches</li>
 *   <li>No break statements needed - only one branch executes (no fall-through)</li>
 *   <li>Can assign the result directly to a variable</li>
 *   <li>Reduces boilerplate code compared to traditional switch statements</li>
 * </ul>
 *
 * <p>Switch Expression Rules:
 * <ul>
 *   <li>All branches must return a consistent data type (if returning a value)</li>
 *   <li>Requires a semicolon after the closing brace when assigning to a variable</li>
 *   <li>Case expressions require a semicolon; case blocks do not</li>
 *   <li>Default branch is required unless all possible values are covered (e.g., with enums)</li>
 *   <li>Each case branch is terminated implicitly - no fall-through behavior</li>
 * </ul>
 *
 * <p>Arrow Operator vs Traditional Syntax:
 * <ul>
 *   <li>Arrow (->) syntax: no fall-through, no break needed, cleaner code</li>
 *   <li>Traditional colon (:) syntax: requires break, allows fall-through</li>
 *   <li>The arrow operator is NOT a lambda - it's switch expression syntax</li>
 * </ul>
 *
 * <p>Comparison with Traditional Switch:
 * <pre>
 * // Traditional (requires break, verbose)
 * String result;
 * switch(day) {
 *     case 0: result = "Sunday"; break;
 *     case 1: result = "Monday"; break;
 *     default: result = "Invalid"; break;
 * }
 *
 * // Expression (no break, concise)
 * var result = switch(day) {
 *     case 0 -> "Sunday";
 *     case 1 -> "Monday";
 *     default -> "Invalid";
 * };
 * </pre>
 *
 * @see <a href="https://learning.oreilly.com/library/view/ocp-oracle-certified/9781119864585/c03.xhtml">Chapter 3: Making Decisions</a>
 */
public final class DayOfWeekExpression {

    private DayOfWeekExpression() {
    }

    /**
     * Prints and returns the day of the week using a switch expression with arrow syntax.
     *
     * <p>This method demonstrates the modern switch expression form introduced in Java 14.
     * The switch expression evaluates to a value that is assigned to the result variable.
     * Each case uses the arrow operator (->) to specify the return value.
     *
     * <p>Key Switch Expression Features:
     * <ul>
     *   <li>The entire switch expression evaluates to a single value</li>
     *   <li>Each case branch implicitly returns its value (no break needed)</li>
     *   <li>Only the matching case executes - no fall-through to subsequent cases</li>
     *   <li>All case values must return compatible types</li>
     *   <li>The semicolon after the closing brace is required for assignment</li>
     * </ul>
     *
     * <p>Execution Flow:
     * <ol>
     *   <li>The day parameter is evaluated once</li>
     *   <li>The matching case branch is identified</li>
     *   <li>The case expression on the right of -> is evaluated</li>
     *   <li>The result is assigned to the variable</li>
     *   <li>No other cases execute (implicit termination)</li>
     * </ol>
     *
     * @param day the day as an integer (0=Sunday, 1=Monday, ..., 6=Saturday)
     * @return the name of the day, or "Invalid value" if day is not in range 0-6
     */
    public static String printDayOfWeek(int day) {
        // Switch expression evaluates and assigns result in a single statement
        // Note: semicolon required after closing brace for the assignment
        var result = switch (day) {
            case 0 -> "Sunday";     // Arrow syntax: returns value, no break needed
            case 1 -> "Monday";
            case 2 -> "Tuesday";
            case 3 -> "Wednesday";
            case 4 -> "Thursday";
            case 5 -> "Friday";
            case 6 -> "Saturday";
            default -> "Invalid value";  // Required: covers all other int values
        };  // Semicolon required here
        System.out.print(result);
        return result;
    }
}

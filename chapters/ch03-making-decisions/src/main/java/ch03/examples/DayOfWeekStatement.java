package ch03.examples;

/**
 * Demonstrates traditional switch statements with break/return control flow.
 * From Chapter 3: Making Decisions - Applying switch Statements.
 *
 * <p>Key Concepts:
 * <ul>
 *   <li>A switch statement is a complex decision-making structure that evaluates a single value</li>
 *   <li>Flow is redirected to the first matching case statement</li>
 *   <li>If no matching case is found, an optional default statement is executed</li>
 *   <li>Without break or return, execution falls through to subsequent cases (fall-through behavior)</li>
 *   <li>The switch value must be of a supported type: int, byte, short, char, String, enum, or var</li>
 * </ul>
 *
 * <p>Supported Data Types for switch:
 * <ul>
 *   <li>Primitive: int, byte, short, char</li>
 *   <li>Wrapper: Integer, Byte, Short, Character</li>
 *   <li>Reference: String, enum values</li>
 *   <li>NOT supported: boolean, long, float, double (and their wrapper classes)</li>
 * </ul>
 *
 * <p>Switch Statement Rules:
 * <ul>
 *   <li>Requires parentheses around the switch variable</li>
 *   <li>Requires braces around the switch body</li>
 *   <li>Case values must be compile-time constants of the same type</li>
 *   <li>Case values must be unique within the switch</li>
 *   <li>Default branch is optional</li>
 * </ul>
 *
 * @see <a href="https://learning.oreilly.com/library/view/ocp-oracle-certified/9781119864585/c03.xhtml">Chapter 3: Making Decisions</a>
 */
public final class DayOfWeekStatement {

    private DayOfWeekStatement() {
    }

    /**
     * Prints and returns the day of the week based on a numeric value using a switch statement.
     *
     * <p>This method demonstrates the traditional switch statement form that was available
     * before Java 14. Each case branch ends with a return statement, which terminates the
     * switch immediately. Alternatively, break statements could be used with a single return
     * at the end.
     *
     * <p>Important Switch Statement Behaviors:
     * <ul>
     *   <li>The switch value is evaluated at runtime</li>
     *   <li>Each case is checked in order until a match is found</li>
     *   <li>Return/break prevents fall-through to subsequent cases</li>
     *   <li>Without return/break, all following cases would execute (fall-through)</li>
     *   <li>The default case handles all unmatched values</li>
     * </ul>
     *
     * <p>Example of fall-through without break:
     * <pre>
     * switch(day) {
     *     case 0: System.out.print("Sunday");
     *     case 1: System.out.print("Monday");  // Would also execute if day==0!
     *     ...
     * }
     * </pre>
     *
     * @param day the day as an integer (0=Sunday, 1=Monday, ..., 6=Saturday)
     * @return the name of the day, or "Invalid value" if day is not in range 0-6
     */
    public static String printDayOfWeek(int day) {
        // Switch evaluates the day parameter and jumps to the matching case
        switch (day) {
            case 0:
                System.out.print("Sunday");
                return "Sunday";  // Return immediately, preventing fall-through
            case 1:
                System.out.print("Monday");
                return "Monday";
            case 2:
                System.out.print("Tuesday");
                return "Tuesday";
            case 3:
                System.out.print("Wednesday");
                return "Wednesday";
            case 4:
                System.out.print("Thursday");
                return "Thursday";
            case 5:
                System.out.print("Friday");
                return "Friday";
            case 6:
                System.out.print("Saturday");
                return "Saturday";
            default:
                // Default handles all values not matched by cases (e.g., -1, 7, 100)
                System.out.print("Invalid value");
                return "Invalid value";
        }
    }
}

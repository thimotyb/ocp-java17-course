package ch03.examples;

/**
 * Demonstrates combining multiple case values in switch expressions.
 * From Chapter 3: Making Decisions - The switch Expression.
 *
 * <p>Key Concepts:
 * <ul>
 *   <li>Starting with Java 14, multiple case values can be combined using commas</li>
 *   <li>Switch expressions with void return type don't require assignment</li>
 *   <li>Arrow syntax (->) prevents fall-through - only the matching case executes</li>
 *   <li>Default branch is optional when the switch expression doesn't return a value</li>
 *   <li>Combining case values reduces code duplication and improves readability</li>
 * </ul>
 *
 * <p>Combining Case Values:
 * <pre>
 * // Java 14+ (concise with comma separator)
 * case 1, 2, 3 -> System.out.print("Winter");
 *
 * // Pre-Java 14 (verbose with fall-through)
 * case 1: case 2: case 3:
 *     System.out.print("Winter");
 *     break;
 * </pre>
 *
 * <p>Switch Expression vs Statement for void:
 * <ul>
 *   <li>This example uses a switch expression that doesn't return a value (void)</li>
 *   <li>No assignment is needed, so no semicolon after the closing brace</li>
 *   <li>Default branch is optional since no value needs to be returned</li>
 *   <li>Most switch expressions return values, but void form is permitted</li>
 * </ul>
 *
 * <p>Fall-Through Behavior:
 * <ul>
 *   <li>Without break in traditional switch: all following cases execute</li>
 *   <li>With arrow syntax: only the matching case executes (no fall-through)</li>
 *   <li>Example: if month=2, only "Winter" prints (not "Winter Spring Unknown...")</li>
 * </ul>
 *
 * @see <a href="https://learning.oreilly.com/library/view/ocp-oracle-certified/9781119864585/c03.xhtml">Chapter 3: Making Decisions</a>
 */
public final class SeasonPrinter {

    private SeasonPrinter() {
    }

    /**
     * Prints the season name based on the month number using combined case values.
     *
     * <p>This method demonstrates two important switch expression features:
     * <ol>
     *   <li>Combining multiple case values with commas (Java 14+)</li>
     *   <li>Using switch expressions without assigning the result (void return)</li>
     * </ol>
     *
     * <p>Execution Flow:
     * <ul>
     *   <li>The month value is evaluated once</li>
     *   <li>The first matching case (if any) executes</li>
     *   <li>Only that single case branch executes - no fall-through</li>
     *   <li>If no case matches, the default branch executes</li>
     * </ul>
     *
     * <p>Contrast with Traditional Switch (without break statements):
     * <pre>
     * switch(month) {
     *     case 1, 2, 3:    System.out.print("Winter");
     *     case 4, 5, 6:    System.out.print("Spring");
     *     default:         System.out.print("Unknown");
     *     case 7, 8, 9:    System.out.print("Summer");
     *     case 10, 11, 12: System.out.print("Fall");
     * }
     * // If month=2, prints: WinterSpringUnknownSummerFall (all remaining cases!)
     * </pre>
     *
     * <p>With arrow syntax (as in this method), if month=2, prints only: Winter
     *
     * @param month the month number (1=January, 2=February, ..., 12=December)
     */
    public static void printSeason(int month) {
        // Switch expression with arrow syntax - no fall-through, no break needed
        switch (month) {
            case 1, 2, 3 -> System.out.print("Winter");      // Jan, Feb, Mar
            case 4, 5, 6 -> System.out.print("Spring");      // Apr, May, Jun
            case 7, 8, 9 -> System.out.print("Summer");      // Jul, Aug, Sep
            case 10, 11, 12 -> System.out.print("Fall");     // Oct, Nov, Dec
            default -> System.out.print("Unknown");          // Any other value
        }
        // No semicolon after closing brace - not assigned to a variable
    }
}

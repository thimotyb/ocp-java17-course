package ch03.examples;

/**
 * Demonstrates labeled continue statements in nested loops.
 * From Chapter 3: Making Decisions - The continue Statement.
 *
 * <p>Key Concepts:
 * <ul>
 *   <li>The continue statement ends the current loop iteration and moves to the next one</li>
 *   <li>Without a label, continue affects only the innermost loop</li>
 *   <li>With a label, continue can skip to the next iteration of an outer loop</li>
 *   <li>Continue transfers control to the boolean expression that determines if the loop continues</li>
 *   <li>Unlike break (which exits the loop), continue stays in the loop but skips remaining statements</li>
 * </ul>
 *
 * <p>Continue vs Break:
 * <ul>
 *   <li>break: exits the loop entirely, transfers control to statement after loop</li>
 *   <li>continue: stays in the loop, skips to next iteration's boolean evaluation</li>
 *   <li>Both can use labels to affect outer loops in nested structures</li>
 * </ul>
 *
 * <p>Labeled Continue Behavior:
 * <pre>
 * // Without label (affects inner loop only)
 * for(outer) {
 *     for(inner) {
 *         if(condition) continue;  // Skips to next inner iteration
 *         statement;               // Skipped when continue executes
 *     }
 * }
 *
 * // With label (affects outer loop)
 * OUTER: for(outer) {
 *     for(inner) {
 *         if(condition) continue OUTER;  // Skips to next outer iteration
 *         statement;                      // Skipped when continue executes
 *     }
 * }
 * </pre>
 *
 * <p>Real-World Use Case:
 * <ul>
 *   <li>Zookeeper cleaning schedule: clean first leopard in each stable</li>
 *   <li>Skip stable 'b' entirely</li>
 *   <li>Skip when leopard number is 2 in any stable</li>
 *   <li>Labeled continue allows skipping to the next stable (outer iteration)</li>
 * </ul>
 *
 * @see <a href="https://learning.oreilly.com/library/view/ocp-oracle-certified/9781119864585/c03.xhtml">Chapter 3: Making Decisions</a>
 */
public class CleaningSchedule {

    /**
     * Demonstrates labeled continue to skip iterations in nested loops.
     *
     * <p>This example models a zookeeper cleaning schedule where:
     * <ul>
     *   <li>Outer loop: iterates through stables 'a' through 'd'</li>
     *   <li>Inner loop: iterates through leopards 1 through 3 in each stable</li>
     *   <li>Skip stable 'b' entirely (no cleaning there)</li>
     *   <li>Skip when leopard number is 2 (in any stable)</li>
     *   <li>Use labeled continue to jump to next stable when condition is met</li>
     * </ul>
     *
     * <p>Execution Flow and Output:
     * <pre>
     * Stable 'a':
     *   - leopard=1: condition false (a!=b && 1!=2), prints "Cleaning: a,1"
     *   - leopard=2: condition true (2==2), continue CLEANING (skip to stable 'b')
     *   - leopard=3: never reached
     *
     * Stable 'b':
     *   - leopard=1: condition true (b==b), continue CLEANING (skip to stable 'c')
     *   - leopards 2,3: never reached
     *
     * Stable 'c':
     *   - leopard=1: condition false (c!=b && 1!=2), prints "Cleaning: c,1"
     *   - leopard=2: condition true (2==2), continue CLEANING (skip to stable 'd')
     *   - leopard=3: never reached
     *
     * Stable 'd':
     *   - leopard=1: condition false (d!=b && 1!=2), prints "Cleaning: d,1"
     *   - leopard=2: condition true (2==2), continue CLEANING (outer loop ends)
     *   - leopard=3: never reached
     *
     * Output:
     * Cleaning: a,1
     * Cleaning: c,1
     * Cleaning: d,1
     * </pre>
     *
     * <p>Impact of Labeled Continue:
     * <ul>
     *   <li>With {@code continue CLEANING}: skips to next stable (outer loop iteration)</li>
     *   <li>Without label (just {@code continue}): would only skip to next leopard (inner loop)</li>
     *   <li>The label allows control over which loop's iteration to skip</li>
     * </ul>
     *
     * <p>Alternative without labeled continue:
     * <pre>
     * for (char stables = 'a'; stables <= 'd'; stables++) {
     *     for (int leopard = 1; leopard < 4; leopard++) {
     *         if (stables == 'b' || leopard == 2) {
     *             continue;  // Only skips inner loop iteration
     *         }
     *         System.out.println("Cleaning: " + stables + "," + leopard);
     *     }
     * }
     * // Same output in this case, but inner loop would complete more iterations
     * </pre>
     *
     * @param args command line arguments (not used)
     */
    public static void main(String[] args) {
        // Label for the outer loop - allows continuing from nested inner loop
        CLEANING:
        for (char stables = 'a'; stables <= 'd'; stables++) {      // Outer: stables a-d
            for (int leopard = 1; leopard < 4; leopard++) {         // Inner: leopards 1-3
                // Skip stable 'b' OR when leopard number is 2
                if (stables == 'b' || leopard == 2) {
                    // Continue CLEANING: skip remaining code and jump to next outer iteration
                    // This means: increment stables and start inner loop again
                    continue CLEANING;
                }
                // This line only executes when condition is false
                System.out.println("Cleaning: " + stables + "," + leopard);
            }
        }
    }
}

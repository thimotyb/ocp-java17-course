package ch03.examples;

/**
 * Demonstrates labeled break statements in nested loops.
 * From Chapter 3: Making Decisions - Controlling Flow with Branching.
 *
 * <p>Key Concepts:
 * <ul>
 *   <li>A labeled break statement can exit from an outer loop in a nested structure</li>
 *   <li>Labels are optional identifiers followed by a colon (:) placed before loops</li>
 *   <li>Without a label, break exits only the innermost loop</li>
 *   <li>With a label, break can exit any labeled enclosing loop</li>
 *   <li>Labels follow identifier rules and are commonly written in UPPER_SNAKE_CASE</li>
 * </ul>
 *
 * <p>Break Statement Behavior:
 * <ul>
 *   <li>{@code break;} - exits the nearest inner loop</li>
 *   <li>{@code break LABEL;} - exits the loop marked with LABEL</li>
 *   <li>Transfers flow control to the statement immediately after the labeled loop</li>
 *   <li>Used to exit nested loops early when a condition is met</li>
 * </ul>
 *
 * <p>Use Case - Searching in Multi-Dimensional Arrays:
 * <ul>
 *   <li>Find the first occurrence of a value in a 2D array</li>
 *   <li>Without labeled break: would only exit inner loop, continuing to search</li>
 *   <li>With labeled break: exits both loops immediately when value is found</li>
 *   <li>More efficient than setting flags or using other control mechanisms</li>
 * </ul>
 *
 * <p>Example Comparison:
 * <pre>
 * // Without label (only exits inner loop)
 * for(int i=0; i<list.length; i++) {
 *     for(int j=0; j<list[i].length; j++) {
 *         if(found) break;  // Only exits inner loop, outer continues
 *     }
 * }
 *
 * // With label (exits both loops)
 * OUTER: for(int i=0; i<list.length; i++) {
 *     for(int j=0; j<list[i].length; j++) {
 *         if(found) break OUTER;  // Exits both loops immediately
 *     }
 * }
 * </pre>
 *
 * @see <a href="https://learning.oreilly.com/library/view/ocp-oracle-certified/9781119864585/c03.xhtml">Chapter 3: Making Decisions</a>
 */
public class FindInMatrix {

    /**
     * Searches for the first occurrence of a value in a 2D array using labeled break.
     *
     * <p>This example demonstrates searching through a two-dimensional array (an array
     * of arrays) using nested loops. The outer loop iterates over the rows, and the
     * inner loop iterates over the columns of each row.
     *
     * <p>Key Implementation Details:
     * <ul>
     *   <li>Uses -1 as a sentinel value to indicate "not found"</li>
     *   <li>PARENT_LOOP label marks the outer loop for breaking</li>
     *   <li>When value is found, both position coordinates are saved</li>
     *   <li>{@code break PARENT_LOOP} immediately exits both loops</li>
     *   <li>Finds only the FIRST occurrence (not the last)</li>
     * </ul>
     *
     * <p>Execution Flow:
     * <ol>
     *   <li>Initialize position variables to -1 (not found state)</li>
     *   <li>Outer loop iterates through each row (i)</li>
     *   <li>Inner loop iterates through each column (j) of current row</li>
     *   <li>When match is found: save coordinates and break PARENT_LOOP</li>
     *   <li>Control jumps to the statement after the outer loop</li>
     *   <li>Check if found (positions != -1) and print result</li>
     * </ol>
     *
     * <p>Impact of Labeled Break:
     * <ul>
     *   <li>With {@code break PARENT_LOOP}: finds value at (1,1) - first occurrence</li>
     *   <li>With {@code break}: would find value at (2,0) - first in last row containing it</li>
     *   <li>Without break: would find value at (2,1) - last occurrence overall</li>
     * </ul>
     *
     * <p>Example Output:
     * <pre>
     * Value 2 found at: (1,1)
     * </pre>
     *
     * @param args command line arguments (not used)
     */
    public static void main(String[] args) {
        // Two-dimensional array: 3 rows, each with 2 elements
        int[][] list = {{1, 13}, {5, 2}, {2, 2}};
        int searchValue = 2;

        // Initialize position to -1 (sentinel value meaning "not found")
        int positionX = -1;
        int positionY = -1;

        // Label for the outer loop - allows breaking out of both loops
        PARENT_LOOP:
        for (int i = 0; i < list.length; i++) {              // Outer loop: iterate rows
            for (int j = 0; j < list[i].length; j++) {       // Inner loop: iterate columns
                if (list[i][j] == searchValue) {
                    // Value found! Save the position coordinates
                    positionX = i;
                    positionY = j;
                    // Break out of BOTH loops immediately (exits to line after PARENT_LOOP)
                    break PARENT_LOOP;
                }
            }
        }

        // Check if value was found (positions would still be -1 if not found)
        if (positionX == -1 || positionY == -1) {
            System.out.println("Value " + searchValue + " not found");
        } else {
            System.out.println("Value " + searchValue + " found at: "
                    + "(" + positionX + "," + positionY + ")");
        }
    }
}

package ch03.examples;

/**
 * Demonstrates using return statements to exit nested loops.
 * From Chapter 3: Making Decisions - Controlling Flow with Branching.
 *
 * <p>Key Concepts:
 * <ul>
 *   <li>The return statement immediately exits the current method</li>
 *   <li>Return provides an alternative to labeled break statements</li>
 *   <li>Extracting search logic into a method improves code organization</li>
 *   <li>Return from nested loops exits all loops and the entire method</li>
 *   <li>Can return values or null to indicate search results</li>
 * </ul>
 *
 * <p>Return vs Labeled Break:
 * <ul>
 *   <li>Return: exits the entire method, can return a value</li>
 *   <li>Labeled break: exits to a specific point in the same method</li>
 *   <li>Return is cleaner when extracting logic into a separate method</li>
 *   <li>Both achieve the goal of exiting nested loops early</li>
 * </ul>
 *
 * <p>Comparison with FindInMatrix:
 * <pre>
 * // FindInMatrix approach (labeled break)
 * PARENT_LOOP: for(...) {
 *     for(...) {
 *         if(found) break PARENT_LOOP;  // Exits to specific label
 *     }
 * }
 * // code continues here...
 *
 * // This approach (return)
 * for(...) {
 *     for(...) {
 *         if(found) return result;  // Exits method immediately
 *     }
 * }
 * // never reached if found
 * </pre>
 *
 * <p>Benefits of Return Approach:
 * <ul>
 *   <li>Separates search logic from result display</li>
 *   <li>Makes the search method reusable</li>
 *   <li>No labels needed - cleaner syntax</li>
 *   <li>Natural way to handle "not found" case (return null)</li>
 * </ul>
 *
 * @see <a href="https://learning.oreilly.com/library/view/ocp-oracle-certified/9781119864585/c03.xhtml">Chapter 3: Making Decisions</a>
 */
public class FindInMatrixUsingReturn {

    /**
     * Searches for a value in a 2D array and returns its position.
     *
     * <p>This method demonstrates using return statements to exit nested loops.
     * When a match is found, the method immediately returns an array containing
     * the row and column indices. This exits both loops and the method in one step.
     *
     * <p>Key Implementation Details:
     * <ul>
     *   <li>Returns an int array with two elements: [row, column]</li>
     *   <li>Returns null if the value is not found (common pattern)</li>
     *   <li>Return statement exits both loops and the method immediately</li>
     *   <li>No labels needed unlike the labeled break approach</li>
     *   <li>Finds only the FIRST occurrence</li>
     * </ul>
     *
     * <p>Execution Flow:
     * <ol>
     *   <li>Outer loop iterates through rows (i)</li>
     *   <li>Inner loop iterates through columns (j) of current row</li>
     *   <li>When match found: create array with coordinates and return immediately</li>
     *   <li>If loops complete without match: return null</li>
     * </ol>
     *
     * <p>Return Statement Behavior:
     * <ul>
     *   <li>Immediately transfers control out of the method</li>
     *   <li>No code after return in the same scope will execute</li>
     *   <li>Exits all enclosing loops automatically</li>
     *   <li>Returns control and value to the caller</li>
     * </ul>
     *
     * @param list the 2D array to search in
     * @param v the value to search for
     * @return an array containing [row, column] if found, or null if not found
     */
    private static int[] searchForValue(int[][] list, int v) {
        // Nested loops to search through the 2D array
        for (int i = 0; i < list.length; i++) {              // Outer: iterate rows
            for (int j = 0; j < list[i].length; j++) {       // Inner: iterate columns
                if (list[i][j] == v) {
                    // Value found! Return position immediately
                    // This exits both loops AND the method in one statement
                    return new int[] {i, j};
                }
            }
        }
        // If we reach here, value was not found in entire array
        return null;
    }

    /**
     * Main method demonstrating the search functionality.
     *
     * <p>This method shows how to use the searchForValue method and handle its results.
     * The separation of search logic from display logic makes the code more modular
     * and the search method reusable.
     *
     * <p>Execution Flow:
     * <ol>
     *   <li>Initialize the 2D array and search value</li>
     *   <li>Call searchForValue which returns results or null</li>
     *   <li>Check if null (not found) or array (found)</li>
     *   <li>Display appropriate message</li>
     * </ol>
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

        // Call the search method - returns null if not found, or int[] if found
        int[] results = searchForValue(list, searchValue);

        // Check the results and display appropriate message
        if (results == null) {
            // Null indicates the value was not found
            System.out.println("Value " + searchValue + " not found");
        } else {
            // results[0] = row index, results[1] = column index
            System.out.println("Value " + searchValue + " found at: "
                    + "(" + results[0] + "," + results[1] + ")");
        }
    }
}

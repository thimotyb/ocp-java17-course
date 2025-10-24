package ch02.examples;

/**
 * Demonstrates the critical difference between pre-increment/decrement and post-increment/decrement operators.
 * From Chapter 2: Operators - Increment and Decrement Operators
 *
 * <p>This example illustrates the fundamental distinction between:</p>
 * <ul>
 *   <li><strong>Pre-increment (++variable):</strong> Increments the value by 1 and returns the NEW value</li>
 *   <li><strong>Pre-decrement (--variable):</strong> Decrements the value by 1 and returns the NEW value</li>
 *   <li><strong>Post-increment (variable++):</strong> Increments the value by 1 but returns the ORIGINAL value</li>
 *   <li><strong>Post-decrement (variable--):</strong> Decrements the value by 1 but returns the ORIGINAL value</li>
 * </ul>
 *
 * <p><strong>Important for the exam:</strong> Understanding when the value is returned (before or after
 * the increment/decrement) is critical, as this distinction appears in multiple exam questions.</p>
 *
 * <p>Expected output sequence: 0, 1, 1, 1, 0</p>
 *
 * @see <a href="https://docs.oracle.com/javase/tutorial/java/nutsandbolts/operators.html">Oracle Java Operators Tutorial</a>
 */
public final class OperatorIncrement {

    /**
     * Private constructor to prevent instantiation of this utility class.
     */
    private OperatorIncrement() {
    }

    /**
     * Demonstrates pre-increment and post-decrement operators with detailed step-by-step behavior.
     *
     * <p>Execution flow:</p>
     * <ol>
     *   <li>firstPrint = 0 (initial value of parkAttendance)</li>
     *   <li>++parkAttendance increments to 1, returns 1, secondPrint = 1</li>
     *   <li>thirdPrint = 1 (current value of parkAttendance)</li>
     *   <li>parkAttendance-- returns 1 (original), then decrements to 0, fourthPrint = 1</li>
     *   <li>fifthPrint = 0 (current value of parkAttendance after decrement)</li>
     * </ol>
     *
     * @return an array containing the sequence [0, 1, 1, 1, 0] demonstrating the operators
     */
    public static int[] demo() {
        int parkAttendance = 0;

        // Value is 0, returns 0
        int firstPrint = parkAttendance;

        // Pre-increment: increases parkAttendance to 1, returns NEW value (1)
        int secondPrint = ++parkAttendance;

        // Value is now 1, returns 1
        int thirdPrint = parkAttendance;

        // Post-decrement: returns ORIGINAL value (1), then decreases parkAttendance to 0
        int fourthPrint = parkAttendance--;

        // Value is now 0 after the post-decrement, returns 0
        int fifthPrint = parkAttendance;

        return new int[] {firstPrint, secondPrint, thirdPrint, fourthPrint, fifthPrint};
    }

    /**
     * Main method to demonstrate increment and decrement operators.
     * Outputs: 0, 1, 1, 1, 0 (each on a separate line)
     *
     * @param args command line arguments (not used)
     */
    public static void main(String[] args) {
        int[] values = demo();
        for (int value : values) {
            System.out.println(value);
        }
    }
}

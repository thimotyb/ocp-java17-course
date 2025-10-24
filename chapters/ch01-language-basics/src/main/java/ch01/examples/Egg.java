package ch01.examples;

/**
 * Demonstrates that initialization order is based on declaration order in the source file,
 * not textual position in the code.
 *
 * This example shows:
 * - Fields and initializers execute in the order they appear in the file
 * - The constructor can appear anywhere (even before field declarations)
 * - Declaration order: constructor, main, field, instance initializer
 * - Execution order: field initialization (number = 3), instance initializer (number = 4),
 *   then constructor (number = 5)
 *
 * Output: 5
 *
 * This proves that fields and initializers execute in declaration order,
 * then the constructor executes last, regardless of where the constructor
 * appears in the source file.
 *
 * From Chapter 1: Understanding Initialization - Order of Initialization
 */
public class Egg {

    /**
     * Constructor executes AFTER all field initializations and instance initializers.
     * Position in the file doesn't matter - constructor always runs last.
     */
    public Egg() {
        number = 5;  // Step 3: Constructor sets final value to 5
    }

    public static void main(String[] args) {
        Egg egg = new Egg();
        System.out.println(egg.number);  // Prints: 5
    }

    private int number = 3;  // Step 1: Field initialized to 3

    // Step 2: Instance initializer changes value to 4
    {
        number = 4;
    }

    /**
     * Demonstrates variable declaration vs. initialization.
     * Shows that:
     * - Variables can be declared without initialization
     * - Variables must be initialized before use
     * - Unused variables (like z) are allowed but generate warnings
     */
    public int valid() {
        int y = 10;         // Declaration and initialization together
        int x;              // Declaration only
        x = 3;              // Initialization (definite assignment)
        int z;              // Declared but never initialized or used
        int reply = x + y;  // x and y are both initialized, so this is valid
        return reply;
    }
}

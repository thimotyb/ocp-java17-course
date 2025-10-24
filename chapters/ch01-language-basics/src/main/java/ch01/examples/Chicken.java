package ch01.examples;

/**
 * Demonstrates different ways to initialize fields in a class.
 * This example shows:
 * - Initializing a field directly on the line where it's declared
 * - Initializing a field in the constructor
 * - Constructor definition: name matches class, no return type
 * - The purpose of constructors is to initialize fields
 *
 * In this example:
 * - numEggs is initialized to 12 on the declaration line
 * - name is initialized to "Duke" in the constructor
 *
 * From Chapter 1: Understanding Initialization - Initializing Fields
 */
public class Chicken {

    int numEggs = 12;   // Initialized on the line
    String name;        // Initialized in constructor

    /**
     * Constructor that initializes the name field.
     * Constructors have the same name as the class and no return type.
     */
    public Chicken() {
        name = "Duke";  // Initialize in constructor
    }
}

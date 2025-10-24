package ch01.examples;

import java.util.Random;

/**
 * Demonstrates the use of import statements to access classes from other packages.
 * This example shows:
 * - How to import a specific class (java.util.Random)
 * - Using imported classes without fully qualified names
 * - The compiler error "cannot find symbol" when imports are missing
 * - Instance initializer blocks (which only run when the class is instantiated)
 *
 * The import statement tells Java where to find the Random class.
 * Without it, you would need to write: java.util.Random r = new java.util.Random();
 *
 * From Chapter 1: Understanding Package Declarations and Imports
 */
public class NumberPicker {

    public static void main(String[] args) {
        Random r = new Random();
        System.out.println(r.nextInt(10));  // Prints a random number 0-9
    }

    // Instance initializer - does NOT execute because NumberPicker is never instantiated
    { System.out.println("Snowy"); }
}

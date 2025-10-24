package ch01.examples;

/**
 * Demonstrates instance initializer blocks and their execution.
 * This example shows:
 * - Instance initializer blocks are defined with curly braces {}
 * - They run when an instance is created, before the constructor
 * - Code blocks can appear anywhere in the class
 * - Local code blocks in methods vs. instance initializers at class level
 *
 * In this example:
 * - Line 6-8: Local code block inside main() - executes when main runs
 * - Line 11-13: Instance initializer - only executes when Bird is instantiated
 *
 * From Chapter 1: Understanding Initialization - Instance Initializer Blocks
 */
public class Bird {

    public static void main(String[] args) {
        // Local code block - executes immediately as part of main()
        {
            System.out.println("Feathers");
        }
    }

    // Instance initializer - only executes when a Bird object is created
    {
        System.out.println("Snowy");
    }
}

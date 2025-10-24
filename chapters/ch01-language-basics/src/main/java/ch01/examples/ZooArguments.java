package ch01.examples;

/**
 * Demonstrates how to handle command-line arguments passed to main().
 * Shows:
 * - Arguments are passed as a String array (String[] args)
 * - Array indexes begin with 0 in Java
 * - Spaces separate arguments unless quotes are used
 * - Accessing missing indexes throws ArrayIndexOutOfBoundsException
 *
 * Example usage: java Zoo Bronx Zoo
 * Output: Bronx
 *         Zoo
 *
 * From Chapter 1: Writing a main() Method - Passing Parameters to a Java Program
 */
public class ZooArguments {

    public static void main(String[] args) {
        System.out.println(args[0]);
        System.out.println(args[1]);
    }
}

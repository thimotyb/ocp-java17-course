package ch01.examples;

/**
 * Demonstrates instance variables and object instantiation.
 * This example shows:
 * - Instance variables (fields) belong to each object
 * - Objects are created using the 'new' keyword
 * - Accessing and modifying instance variables via object references
 * - Default values for fields (int defaults to 0)
 *
 * The numberEggs variable is an instance variable that stores state
 * for each Swan object. It's accessible from anywhere in the class.
 *
 * From Chapter 1: Understanding Initialization - Instance Variables
 */
public class Swan {

    int numberEggs;  // Instance variable - each Swan has its own value

    public static void main(String[] args) {
        Swan mother = new Swan();      // Create new Swan instance
        mother.numberEggs = 1;         // Set the instance variable
        System.out.println(mother.numberEggs);  // Prints: 1
    }
}

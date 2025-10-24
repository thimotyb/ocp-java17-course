package ch01.examples;

/**
 * Demonstrates the basic structure of a Java class with fields and methods.
 * This example shows:
 * - Fields (instance variables) store the object's state
 * - Methods operate on the object's state
 * - Getter and setter methods for accessing private data
 * - Method signatures: name + parameter list
 * - Return types and parameters
 *
 * From Chapter 1: Understanding Classes - Fields and Methods
 */
public class Animal {

    String name;

    /**
     * Getter method to retrieve the animal's name.
     * @return the name of the animal
     */
    public String getName() {
        return name;
    }

    /**
     * Setter method to update the animal's name.
     * @param newName the new name for the animal
     */
    public void setName(String newName) {
        name = newName;
    }

    /**
     * Example method that takes a parameter and returns a value.
     * @param month the month to check (currently unused)
     * @return the number of visitors (hardcoded to 10 for demo)
     */
    public int numberVisitors(int month) {
        return 10;
    }
}

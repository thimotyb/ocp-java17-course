package ch01.examples;

/**
 * Demonstrates variable scope and the different types of variables.
 * This example shows:
 * - Static variables (class-level, shared across all instances)
 * - Instance variables (belong to each object)
 * - Local variables (declared within methods)
 * - Method parameters (scoped to the method)
 * - Block-scoped variables (within if/while/for blocks)
 *
 * Variable scope rules:
 * - MAX_LENGTH: static variable, lives for the program lifetime
 * - length: instance variable, lives with the object
 * - inches: method parameter, lives for the method duration
 * - newSize: local variable, lives until the if block closes
 *
 * From Chapter 1: Understanding Data Types - Managing Variable Scope
 */
public class Mouse {

    static final int MAX_LENGTH = 5;  // Static variable - class level, final = constant
    int length;                        // Instance variable - object level

    /**
     * Demonstrates variable scope with method parameters and local variables.
     * @param inches method parameter - scoped to this method
     */
    public void grow(int inches) {
        if (length < MAX_LENGTH) {
            int newSize = length + inches;  // Local variable - scoped to this block
            length = newSize;
        }
        // newSize is out of scope here - cannot be accessed outside the if block
    }

/*     public void eatMore(boolean hungry, int amountOfFood) {
    int roomInBelly = 5;
    if (hungry) {
       var timeToEat = true;
       while (amountOfFood> 0) {
          int amountEaten = 2;
         roomInBelly = roomInBelly - amountEaten;
          amountOfFood = amountOfFood - amountEaten;
      }
    }
    System.out.println(amountOfFood);
 } */
}

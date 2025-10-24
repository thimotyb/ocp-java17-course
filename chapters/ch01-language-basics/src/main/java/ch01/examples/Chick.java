package ch01.examples;

/**
 * Demonstrates the order of initialization in Java.
 * This example shows the execution order when creating an object:
 * 1. Fields are initialized to their default values
 * 2. Field initializations (name = "Fluffy") execute in declaration order
 * 3. Instance initializer blocks execute in declaration order
 * 4. Constructor body executes
 *
 * Output when running main():
 *   setting field
 *   setting constructor
 *   Tiny
 *
 * This proves that instance initializers run before the constructor,
 * and the constructor can override field values set during initialization.
 *
 * From Chapter 1: Understanding Initialization - Order of Initialization
 */
public class Chick {
     private String name = "Fluffy";  // Step 1: Field initialized to "Fluffy"

     // Step 2: Instance initializer executes
     { System.out.println("setting field"); }

     /**
      * Constructor executes after field initializers and instance initializers.
      * This constructor changes name from "Fluffy" to "Tiny".
      */
     public Chick() {
        name = "Tiny";  // Step 3: Constructor overrides field value
       System.out.println("setting constructor");
    }

    public static void main(String[] args) {
        Chick chick = new Chick();
       System.out.println(chick.name);  // Prints: Tiny
    }
}


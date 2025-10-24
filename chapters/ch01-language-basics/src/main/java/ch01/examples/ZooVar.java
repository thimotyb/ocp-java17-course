package ch01.examples;

/**
 * Demonstrates local variable type inference using the 'var' keyword (Java 10+).
 * This example shows:
 * - var allows the compiler to infer the type from the initializer
 * - var can only be used for local variables with an initializer
 * - The inferred type is determined at compile time and cannot change
 * - var has several restrictions (shown in commented-out methods)
 *
 * Valid var usage (in whatTypeAmI method):
 * - var name = "Hello";  // Inferred as String
 * - var size = 7;        // Inferred as int
 *
 * Invalid var usage (in commented methods):
 * - var without initializer
 * - var with null (cannot infer type)
 * - var in compound declarations
 * - var as method parameters
 *
 * From Chapter 1: Understanding Data Types - Local Variable Type Inference
 */
public class ZooVar {

    /**
     * Demonstrates valid var usage - declaration and initialization together.
     * The compiler infers: name is String, size is int.
     */
    public void whatTypeAmI() {
        var name = "Hello";  // Compiler infers type String
        var size = 7;        // Compiler infers type int
        System.out.println(name + " " + size);
    }

    /**
     * DOES NOT COMPILE - var requires initialization on the same statement.
     * You cannot declare var without an initializer, even if you initialize it later.
     */
    /* public void doesThisCompile(boolean check) {
        var question;      // DOES NOT COMPILE - var needs an initializer
        question = 1;
        var answer;        // DOES NOT COMPILE - var needs an initializer
        if (check) {
            answer = 2;
        } else {
            answer = 3;
        }
        System.out.println(answer);
    } */

    /**
     * DOES NOT COMPILE - demonstrates two var restrictions:
     * 1. Cannot use var in compound declarations (multiple variables)
     * 2. Cannot initialize var with null (type cannot be inferred)
     */
    /* public void twoTypes() {
       int a, var b = 3;  // DOES NOT COMPILE - cannot mix types in compound declaration
        var n = null;      // DOES NOT COMPILE - cannot infer type from null
         } */

    /**
     * DOES NOT COMPILE - var cannot be used for method parameters.
     * var is only for local variables within methods.
     */
    /* public int addition(var a, var b) { // DOES NOT COMPILE
        return a + b;
    } */


}

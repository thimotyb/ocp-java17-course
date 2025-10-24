package ch01.examples;

/**
 * Demonstrates field initialization and the ability to reference other fields.
 * This example shows:
 * - Multiple fields can be initialized on declaration
 * - Fields can reference other fields during initialization
 * - Fields are initialized in declaration order
 * - String concatenation during field initialization
 *
 * The full field is initialized using the values of first and last,
 * which works because first and last are declared before full.
 *
 * From Chapter 1: Understanding Initialization - Initializing Fields
 */
public class NameTag {

    String first = "Theodore";      // First field initialized
    String last = "Moose";          // Second field initialized
    String full = first + last;     // Third field uses values from first two
}

package ch05.examples;

import java.util.Arrays;

/**
 * Demonstrates varargs (variable arguments) method parameters from Chapter 5.
 *
 * <p>From Chapter 5: Working with Varargs - Key concepts:
 * <ul>
 *   <li>Varargs parameter uses ellipsis notation (type...)</li>
 *   <li>At most ONE varargs parameter per method</li>
 *   <li>Varargs parameter must be LAST in parameter list</li>
 *   <li>Treated as an array within the method</li>
 *   <li>Can be called with array or comma-separated values</li>
 *   <li>Creates empty array if no values passed</li>
 * </ul>
 *
 * <p>Rules for Varargs:
 * <ul>
 *   <li>A method can have at most one varargs parameter</li>
 *   <li>If a method contains a varargs parameter, it must be the last parameter</li>
 * </ul>
 *
 * @see <a href="https://learning.oreilly.com/library/view/ocp-oracle-certified/9781119864585/c05.xhtml">
 *      OCP Java SE 17 Study Guide - Chapter 5: Working with Varargs</a>
 */
public final class VarargsExamples {

    /**
     * Private constructor to prevent instantiation of this utility class.
     */
    private VarargsExamples() {
    }

    /**
     * Demonstrates valid and invalid varargs method declarations.
     *
     * <p>From Chapter 5: Creating Methods with Varargs - Shows the syntax rules
     * for declaring varargs parameters.
     */
    public static final class VisitAttractions {

        /**
         * Valid varargs method with only varargs parameter.
         * The ellipsis (...) indicates a varargs parameter.
         *
         * @param steps variable number of int values representing steps
         */
        public void walk1(int... steps) {
        }

        /**
         * Valid varargs method with regular parameter first.
         * Varargs must be the last parameter.
         *
         * @param start the starting position
         * @param steps variable number of steps (must be last)
         */
        public void walk2(int start, int... steps) {
        }

        // public void walk3(int... steps, int start) {}
        // DOES NOT COMPILE - varargs must be last parameter

        // public void walk4(int... start, int... steps) {}
        // DOES NOT COMPILE - can have at most one varargs parameter
    }

    /**
     * Demonstrates accessing varargs parameters as arrays.
     *
     * <p>From Chapter 5: Accessing Elements of a Vararg - Within the method,
     * a varargs parameter is treated just like an array.
     */
    public static final class VarargUtilities {

        /**
         * Returns the length of the varargs array.
         * Varargs parameters are accessed like arrays.
         *
         * @param steps the varargs parameter (treated as int[])
         * @return the number of elements passed
         */
        public static int lengthOf(int... steps) {
            return steps.length; // accessing as array
        }

        /**
         * Returns the second element using array indexing.
         * Demonstrates that varargs can be accessed with array syntax.
         *
         * @param steps the varargs parameter (at least 2 elements required)
         * @return the element at index 1
         * @throws ArrayIndexOutOfBoundsException if fewer than 2 elements passed
         */
        public static int secondElement(int... steps) {
            return steps[1]; // array indexing works
        }
    }

    /**
     * Demonstrates calling methods with varargs.
     *
     * <p>From Chapter 5: Calling Methods with Varargs - Shows different ways
     * to pass values to varargs parameters:
     * <ul>
     *   <li>Pass individual values (Java creates array)</li>
     *   <li>Pass an array directly</li>
     *   <li>Pass no values (creates empty array)</li>
     *   <li>Pass null explicitly (passes null array reference)</li>
     * </ul>
     */
    public static final class DogWalker {

        /**
         * Demonstrates varargs parameter with regular parameter.
         * Can be called as: walkDog(1), walkDog(1, 2), walkDog(1, 2, 3), etc.
         *
         * @param start the starting position (required)
         * @param steps variable number of steps (creates empty array if omitted)
         * @return the number of steps provided
         */
        public static int walkDog(int start, int... steps) {
            return steps.length; // steps is an int[] array
        }

        /**
         * Demonstrates passing array to varargs method.
         * Shows that you can pass an array where varargs expected.
         *
         * @param start the starting position
         * @param steps an array that will be passed as varargs
         * @return the number of steps
         */
        public static int walkDogWithArray(int start, int[] steps) {
            return walkDog(start, steps); // passing array to varargs parameter
        }

        /**
         * Demonstrates potential NullPointerException with varargs.
         * If null is passed explicitly, the array reference is null.
         *
         * @param start the starting position
         * @param steps the steps (can be null if explicitly passed)
         * @return the number of steps
         * @throws NullPointerException if null is explicitly passed for steps
         */
        public static int explodeOnNull(int start, int... steps) {
            return steps.length; // throws NPE if steps is null
        }
    }

    /**
     * Utility method demonstrating that varargs is an array.
     * The varargs parameter can be used wherever an array is expected.
     *
     * @param steps variable number of int values
     * @return a copy of the steps array
     */
    public static int[] copySteps(int... steps) {
        int[] copy = Arrays.copyOf(steps, steps.length); // steps is int[]
        return copy;
    }
}

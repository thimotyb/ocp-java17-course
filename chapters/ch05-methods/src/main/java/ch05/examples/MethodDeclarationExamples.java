package ch05.examples;

import java.util.Objects;

/**
 * Demonstrates method declaration syntax and local variable rules from Chapter 5.
 *
 * <p>From Chapter 5: Designing Methods - This class contains examples illustrating:
 * <ul>
 *   <li>Access modifiers (private, package, protected, public)</li>
 *   <li>Optional specifiers (final, static, etc.)</li>
 *   <li>Return types and return statements</li>
 *   <li>Method names and parameter lists</li>
 *   <li>Method signatures</li>
 *   <li>Exception lists</li>
 *   <li>Method bodies</li>
 *   <li>Local and instance variable declarations</li>
 *   <li>Final and effectively final variables</li>
 * </ul>
 *
 * <p>Key Concepts:
 * <ul>
 *   <li>Method signature = method name + parameter list (not return type or modifiers)</li>
 *   <li>Access modifiers control who can call the method</li>
 *   <li>Optional specifiers must appear before the return type</li>
 *   <li>void methods may have optional return statement</li>
 *   <li>Non-void methods must return a value on all code paths</li>
 *   <li>Local variables exist only within their code block</li>
 *   <li>final variables can be assigned only once</li>
 * </ul>
 *
 * @see <a href="https://learning.oreilly.com/library/view/ocp-oracle-certified/9781119864585/c05.xhtml">
 *      OCP Java SE 17 Study Guide - Chapter 5</a>
 */
public final class MethodDeclarationExamples {

    /**
     * Private constructor to prevent instantiation of this utility class.
     */
    private MethodDeclarationExamples() {
    }

    /**
     * Demonstrates access modifier syntax for methods.
     *
     * <p>From Chapter 5: Access Modifiers - Shows the four access levels:
     * <ul>
     *   <li>public - accessible from anywhere</li>
     *   <li>protected - accessible from same package and subclasses</li>
     *   <li>package (default) - accessible only from same package</li>
     *   <li>private - accessible only within same class</li>
     * </ul>
     *
     * <p>Important: The keyword 'default' is NOT a valid access modifier.
     * It is used in switch statements and interfaces, but never for access control.
     */
    public static final class ParkTrip {

        /**
         * Valid method with public access modifier.
         * Can be called from any class.
         */
        public void skip1() {
            // valid public method declaration
        }

        // default void skip2() {} // DOES NOT COMPILE - 'default' is not an access modifier
        // void public skip3() {} // DOES NOT COMPILE - access modifier must come before return type

        /**
         * Valid method with package access (no modifier).
         * Can be called only from classes in the same package.
         * Also known as package-private or default access.
         */
        void skip4() {
            // package-private access is allowed
        }
    }

    /**
     * Demonstrates optional specifiers (static, final, abstract, etc.) for methods.
     *
     * <p>From Chapter 5: Optional Specifiers - Key rules:
     * <ul>
     *   <li>Optional specifiers can appear in any order relative to each other</li>
     *   <li>All specifiers must appear BEFORE the return type</li>
     *   <li>You can have zero or more specifiers</li>
     *   <li>Not all combinations are legal (e.g., final and abstract conflict)</li>
     * </ul>
     *
     * <p>Common optional specifiers: static, abstract, final, default, synchronized, native, strictfp
     */
    public static final class Exercise {

        /**
         * Valid method with no optional specifiers.
         * Optional specifiers are truly optional.
         */
        public void bike1() {
        }

        /**
         * Valid method with final specifier.
         * final methods cannot be overridden in subclasses.
         */
        public final void bike2() {
        }

        /**
         * Valid method with both static and final specifiers.
         * Order of static and final doesn't matter.
         */
        public static final void bike3() {
        }

        /**
         * Valid method with final and static in different order.
         * Demonstrates that specifier order is flexible.
         */
        public final static void bike4() {
        }

        // public modifier void bike5() {} // DOES NOT COMPILE - 'modifier' is not a valid specifier
        // public void final bike6() {} // DOES NOT COMPILE - specifiers must come before return type

        /**
         * Valid but unusual: access modifier after optional specifier.
         * While legal, conventionally the access modifier comes first.
         */
        final public void bike7() {
        }
    }

    /**
     * Demonstrates return type rules and return statements.
     *
     * <p>From Chapter 5: Return Type - Key rules:
     * <ul>
     *   <li>Every method must have a return type (use void if nothing returned)</li>
     *   <li>Return type must appear after modifiers and before method name</li>
     *   <li>void methods may optionally have a return statement (with no value)</li>
     *   <li>Non-void methods must have a return statement on ALL possible code paths</li>
     *   <li>Returned value must be assignable to the declared return type</li>
     *   <li>You can only have ONE return type per method</li>
     * </ul>
     */
    public static final class Hike {

        /**
         * Valid void method without return statement.
         * Return statements are optional for void methods.
         */
        public void hike1() {
        }

        /**
         * Valid void method with optional return statement.
         * The return statement allows early exit from the method.
         */
        public void hike2() {
            return; // optional early exit in void method
        }

        /**
         * Valid method returning a String.
         * The returned value matches the declared return type.
         *
         * @return an empty String
         */
        public String hike3() {
            return ""; // returning String matches signature
        }

        // public String hike4() {} // DOES NOT COMPILE - missing return statement
        // public hike5() {} // DOES NOT COMPILE - missing return type
        // public String int hike6() {} // DOES NOT COMPILE - cannot have two return types
        // String hike7(int a) { if (1 < 2) return "orange"; } // DOES NOT COMPILE - not all paths return

        /**
         * Valid method with return on all code paths.
         * Even though the if condition is always true, the compiler requires
         * a return statement for the else case.
         *
         * @param a parameter used in conditional logic
         * @return "orange" if a is positive, otherwise "apple"
         */
        public String hike8(int a) {
            if (a > 0) {
                return "orange";
            }
            return "apple"; // required even though a > 0 branch always executes for positive a
        }
    }

    /**
     * Shows assignment compatibility when returning data.
     *
     * <p>From Chapter 5: Return Type - The returned value must be assignable to the return type.
     * You cannot assign a long to an int without an explicit cast.
     */
    public static final class Measurement {

        /**
         * Valid method returning an int.
         * The temp variable is an int, which matches the return type.
         *
         * @return the height value as an int
         */
        public int getHeight1() {
            int temp = 9;
            return temp;
        }

        // int getHeight2() { int temp = 9L; return temp; } // DOES NOT COMPILE - cannot assign long literal to int
        // int getHeight3() { long temp = 9L; return temp; } // DOES NOT COMPILE - cannot return long as int
    }

    /**
     * Highlights identifier rules for method names.
     *
     * <p>From Chapter 5: Method Name - Identifier rules:
     * <ul>
     *   <li>May contain letters, numbers, currency symbols ($), or underscore (_)</li>
     *   <li>First character cannot be a number</li>
     *   <li>Cannot use reserved keywords</li>
     *   <li>Single underscore (_) alone is not allowed</li>
     *   <li>By convention, method names start with lowercase letter (camelCase)</li>
     * </ul>
     */
    public static final class BeachTrip {

        /**
         * Valid method with traditional naming convention.
         * Method names conventionally start with lowercase letter.
         */
        public void jog1() {
        }

        // public void 2jog() {} // DOES NOT COMPILE - identifiers cannot start with a number
        // public jog3 void() {} // DOES NOT COMPILE - method name must come after return type

        /**
         * Valid but unusual method name.
         * While legal to use uppercase, $, and _, it's not conventional.
         */
        public void Jog_$() {
        }

        // public _() {} // DOES NOT COMPILE - single underscore is not allowed as identifier
        // public void() {} // DOES NOT COMPILE - missing method name
    }

    /**
     * Shows parameter list syntax variations.
     *
     * <p>From Chapter 5: Parameter List - Key rules:
     * <ul>
     *   <li>Parentheses are required, even for zero parameters</li>
     *   <li>Multiple parameters are separated by commas (not semicolons)</li>
     *   <li>Each parameter needs a type and name</li>
     * </ul>
     */
    public static final class PhysicalEducation {

        /**
         * Valid method with no parameters.
         * Empty parentheses are required even when there are no parameters.
         */
        public void run1() {
        }

        // public void run2 {} // DOES NOT COMPILE - missing parentheses

        /**
         * Valid method with one parameter.
         *
         * @param a the parameter value
         */
        public void run3(int a) {
        }

        // public void run4(int a; int b) {} // DOES NOT COMPILE - parameters separated by semicolon, not comma

        /**
         * Valid method with two parameters.
         * Parameters are separated by commas.
         *
         * @param a first parameter
         * @param b second parameter
         */
        public void run5(int a, int b) {
        }
    }

    /**
     * Demonstrates method signature uniqueness based on parameter types.
     *
     * <p>From Chapter 5: Method Signature - The method signature consists of:
     * <ul>
     *   <li>Method name</li>
     *   <li>Parameter types (in order)</li>
     * </ul>
     *
     * <p>NOT part of the signature:
     * <ul>
     *   <li>Parameter names</li>
     *   <li>Return type</li>
     *   <li>Access modifiers</li>
     *   <li>Exception list</li>
     * </ul>
     *
     * <p>Two methods in the same class cannot have the same signature.
     */
    public static final class TripExamples {

        /**
         * Method with signature: visitZoo(String, int).
         *
         * @param name the name parameter
         * @param waitTime the wait time parameter
         */
        public void visitZoo(String name, int waitTime) {
        }

        // public void visitZoo(String attraction, int rainFall) {}
        // DOES NOT COMPILE - same signature as above (parameter names don't matter)

        /**
         * Method with signature: visitZoo(int, String).
         * This is a different signature because parameter types are in different order.
         *
         * @param rainFall the rainfall parameter
         * @param attraction the attraction parameter
         */
        public void visitZoo(int rainFall, String attraction) {
        }
    }

    /**
     * Examples of optional exception lists.
     *
     * <p>From Chapter 5: Exception List - Key points:
     * <ul>
     *   <li>Exception list is optional (can be omitted)</li>
     *   <li>Uses the 'throws' keyword followed by exception types</li>
     *   <li>Multiple exceptions are separated by commas</li>
     *   <li>May be required by compiler depending on method body</li>
     * </ul>
     */
    public static final class ZooMonorail {

        /**
         * Valid method with no exception list.
         * Exception lists are optional.
         */
        public void zeroExceptions() {
        }

        /**
         * Valid method declaring one exception.
         *
         * @throws IllegalArgumentException if the monorail line is closed
         */
        public void oneException() throws IllegalArgumentException {
            throw new IllegalArgumentException("line closed");
        }

        /**
         * Valid method declaring two exceptions.
         * Multiple exceptions are separated by commas.
         *
         * @throws IllegalArgumentException if the monorail is unavailable
         * @throws InterruptedException if the thread is interrupted
         */
        public void twoExceptions() throws IllegalArgumentException, InterruptedException {
            if (Thread.currentThread().isInterrupted()) {
                throw new InterruptedException("monorail interrupted");
            }
            throw new IllegalArgumentException("monorail unavailable");
        }
    }

    /**
     * Demonstrates method body structure.
     *
     * <p>From Chapter 5: Method Body - Requirements:
     * <ul>
     *   <li>Method body is a code block with braces {}</li>
     *   <li>Contains zero or more Java statements</li>
     *   <li>Required unless method is declared abstract</li>
     * </ul>
     */
    public static final class BirdDeclaration {

        /**
         * Valid method with empty body.
         * An empty method body is allowed.
         */
        public void fly1() {
        }

        // public void fly2() // DOES NOT COMPILE - missing method body braces

        /**
         * Valid method with statements in body.
         * The method body can contain any valid Java statements.
         *
         * @param repeats number of iterations
         */
        public void fly3(int repeats) {
            int name = 5; // local variable
            for (int i = 0; i < repeats; i++) {
                name += i;
            }
        }
    }

    /**
     * Distinguishes local and instance variables.
     *
     * <p>From Chapter 5: Declaring Local and Instance Variables - Key differences:
     * <ul>
     *   <li>Local variables: defined within a method or block, destroyed after block executes</li>
     *   <li>Instance variables: defined as class members, exist as long as object exists</li>
     *   <li>Local variables must be initialized before use</li>
     *   <li>Instance variables get default values if not initialized</li>
     * </ul>
     */
    public static final class Lion {

        /**
         * Instance variable - created with each Lion object.
         * Gets default value of 0 if not initialized.
         */
        private int hunger = 4;

        /**
         * Demonstrates local and instance variable usage.
         * Local variables (snack, dinnerTime) are destroyed after method returns,
         * but the instance variable (hunger) persists.
         *
         * @return the value of snack at method end
         */
        public int feedZooAnimals() {
            int snack = 10; // local variable - only exists within this method
            if (snack > 4) {
                long dinnerTime = snack++; // local variable - only exists within this block
                hunger -= dinnerTime > 0 ? 1 : 0; // modifies instance variable
            }
            return snack; // returning local variable value
        }

        /**
         * Returns the current hunger level.
         *
         * @return the instance variable hunger
         */
        public int getHunger() {
            return hunger;
        }
    }

    /**
     * Demonstrates final local variables and effectively final variables.
     *
     * <p>From Chapter 5: Local Variable Modifiers - Only 'final' can modify local variables.
     * Key rules:
     * <ul>
     *   <li>final variables can be assigned only once</li>
     *   <li>final variables don't need to be assigned at declaration</li>
     *   <li>final variables must be assigned before use</li>
     *   <li>final only prevents reassignment, not mutation of object contents</li>
     *   <li>Effectively final = not modified after assignment (even without final keyword)</li>
     * </ul>
     */
    public static final class Veterinarian {

        /**
         * Demonstrates final variable assigned in conditional branches.
         * The final variable 'rest' is assigned exactly once in each code path.
         *
         * @param isWeekend determines which rest value to use
         * @return the rest hours based on weekend status
         */
        public int determineRest(boolean isWeekend) {
            final int rest; // declared but not yet assigned
            if (isWeekend) {
                rest = 5; // first assignment
            } else {
                rest = 20; // first assignment in this path
            }
            return rest; // all paths assign before use
        }

        /**
         * Demonstrates that final prevents reassignment but allows mutation.
         * final variables can't be reassigned, but object contents can change.
         */
        public void prepareCheckup() {
            final int rest = 5; // primitive final variable
            final Animal giraffe = new Animal("George"); // object reference final
            final int[] friends = new int[5]; // array reference final
            giraffe.setName("George the Giraffe"); // mutating object is OK
            friends[2] = 2; // mutating array contents is OK
            Objects.requireNonNull(rest);
            Objects.requireNonNull(giraffe.getName());
            Objects.requireNonNull(friends);
            // rest = 10; // WOULD NOT COMPILE - cannot reassign final variable
            // giraffe = new Animal("Fred"); // WOULD NOT COMPILE - cannot reassign reference
        }

        /**
         * Demonstrates effectively final variables.
         * A variable is effectively final if it's not modified after assignment.
         * 'name' and 'wet' are effectively final; 'size' is not.
         *
         * @return true if wet and name matches
         */
        public boolean effectivelyFinalExample() {
            String name = "Harry the Hippo"; // effectively final
            var size = 10; // NOT effectively final
            boolean wet; // effectively final
            if (size > 100) {
                size++; // reassignment makes size NOT effectively final
            }
            name.substring(0); // returns new String, doesn't modify name
            wet = true; // first and only assignment
            return wet && name.equals("Harry the Hippo");
        }
    }

    /**
     * Simple domain object used by the Veterinarian example.
     * Demonstrates that objects referenced by final variables can still be mutated.
     */
    public static final class Animal {

        private String name;

        /**
         * Creates an Animal with the given name.
         *
         * @param initialName the initial name for this animal
         */
        public Animal(String initialName) {
            this.name = initialName;
        }

        /**
         * Returns the animal's name.
         *
         * @return the current name
         */
        public String getName() {
            return name;
        }

        /**
         * Sets the animal's name.
         *
         * @param name the new name
         */
        public void setName(String name) {
            this.name = name;
        }
    }

    /**
     * Demonstrates final instance variables and their initialization.
     *
     * <p>From Chapter 5: Instance Variable Modifiers - final instance variables:
     * <ul>
     *   <li>Must be assigned exactly once</li>
     *   <li>Can be assigned at declaration, in instance initializer, or in constructor</li>
     *   <li>Cannot be assigned more than once</li>
     *   <li>Do NOT receive default values (compiler error if not initialized)</li>
     * </ul>
     */
    public static final class PolarBear {

        /**
         * final instance variable assigned at declaration.
         */
        private final int age = 10;

        /**
         * final instance variable assigned in instance initializer.
         */
        private final int fishEaten;

        /**
         * final instance variable assigned in constructor.
         */
        private final String name;

        /**
         * Instance initializer block.
         * Executes when instance is created, before constructor.
         */
        {
            fishEaten = 10; // assigning final instance variable
        }

        /**
         * Constructor that assigns final instance variable.
         */
        public PolarBear() {
            name = "Robert"; // must assign before constructor completes
        }

        /**
         * Returns the bear's age.
         *
         * @return the age value
         */
        public int getAge() {
            return age;
        }

        /**
         * Returns the number of fish eaten.
         *
         * @return the fish count
         */
        public int getFishEaten() {
            return fishEaten;
        }

        /**
         * Returns the bear's name.
         *
         * @return the name value
         */
        public String getName() {
            return name;
        }
    }
}

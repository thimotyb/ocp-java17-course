package ch07.examples;

/**
 * Demonstrates advanced interface features from Chapter 7: Beyond Classes.
 *
 * <p>This class illustrates the six types of interface members:
 * <ul>
 *   <li>Constant variables (public static final)</li>
 *   <li>Abstract methods (public abstract)</li>
 *   <li>Default methods (default public with body)</li>
 *   <li>Static methods (static public with body)</li>
 *   <li>Private instance methods (private with body)</li>
 *   <li>Private static methods (private static with body)</li>
 * </ul>
 *
 * <p><strong>From Chapter 7: Declaring Concrete Interface Methods</strong><br>
 * While interfaces started with abstract methods and constants, they've grown to
 * include concrete methods. This enables backward compatibility and code reuse
 * across implementations.
 *
 * <p><strong>Key Concepts:</strong>
 * <ul>
 *   <li>Implicit modifiers: interfaces automatically add public, static, final where appropriate</li>
 *   <li>Default methods provide optional implementations that classes can override</li>
 *   <li>Static methods are utility methods associated with the interface, not instances</li>
 *   <li>Private methods enable code reuse within the interface without exposing implementation</li>
 *   <li>Inheriting duplicate default methods requires explicit override in the implementing class</li>
 * </ul>
 *
 * @see InterfaceBasicsExamples
 * @see FunctionalInterfaceExamples
 */
public final class InterfaceFeatureExamples {

    private InterfaceFeatureExamples() {
    }

    /**
     * Demonstrates all six interface member types.
     *
     * <p><strong>From Chapter 7: Inserting Implicit Modifiers</strong><br>
     * An implicit modifier is one that the compiler automatically inserts.
     * This interface showcases:
     * <ul>
     *   <li>Constants (implicitly public static final)</li>
     *   <li>Abstract methods (implicitly public abstract)</li>
     *   <li>Default methods (implicitly public, requires default keyword and body)</li>
     *   <li>Static methods (implicitly public, requires static keyword and body)</li>
     *   <li>Private methods (explicit private, enables code reuse within interface)</li>
     * </ul>
     */
    public interface Soar {

        // Constant variables - implicitly public static final
        /**
         * Maximum height for soaring operations.
         * Implicitly public, static, and final.
         */
        int MAX_HEIGHT = 10;

        /**
         * Indicates if underwater operations are supported.
         * Implicitly public, static, and final.
         */
        boolean UNDERWATER = true;

        /**
         * Abstract method for flying at a specified speed.
         * Implicitly public and abstract.
         *
         * @param speed the flying speed
         */
        void fly(int speed);

        /**
         * Default method demonstrating optional implementation.
         *
         * <p><strong>From Chapter 7: Writing a default Interface Method</strong><br>
         * A default method is defined with the default keyword and includes a method body.
         * It may be optionally overridden by a class implementing the interface.
         * Default methods enable backward compatibility - you can add new methods to
         * interfaces without breaking existing implementations.
         *
         * <p>This method uses the private helper method prepare() to build its result.
         *
         * @return a message describing the takeoff action
         */
        default String takeoff() {
            return prepare("Taking off");
        }

        /**
         * Static method demonstrating utility functionality.
         *
         * <p><strong>From Chapter 7: Declaring static Interface Methods</strong><br>
         * Static methods are defined with the static keyword and include a method body.
         * They are implicitly public if no access modifier is specified.
         * Static methods are not inherited and must be called using the interface name.
         *
         * @return a random dive value
         */
        static double dive() {
            return Math.random();
        }

        /**
         * Private helper method for code reuse within the interface.
         *
         * <p><strong>From Chapter 7: Declaring Concrete Interface Methods</strong><br>
         * Private methods enable code reuse within an interface without exposing
         * implementation details. They can be called by default methods and other
         * private methods in the same interface.
         *
         * @param action the action being prepared
         * @return formatted message including the action and max height
         */
        private String prepare(String action) {
            return action + " at max height " + MAX_HEIGHT;
        }
    }

    /**
     * Demonstrates implementing an interface with default and abstract methods.
     *
     * <p>This class must implement the abstract fly() method but can optionally
     * override the default takeoff() method. Static methods like dive() are called
     * via the interface name (Soar.dive()), not through instances.
     */
    public static final class Eagle implements Soar {

        private int lastSpeed;

        /**
         * Implements the required fly() method.
         *
         * <p>Stores the speed for later retrieval.
         *
         * @param speed the flying speed to record
         */
        @Override
        public void fly(int speed) {
            lastSpeed = speed;
        }

        /**
         * Returns the last recorded speed.
         *
         * @return the most recent flying speed
         */
        public int getLastSpeed() {
            return lastSpeed;
        }
    }

    /**
     * First interface with a default temperature method.
     *
     * <p>Part of a demonstration of inheriting duplicate default methods.
     */
    public interface IsColdBlooded {

        /**
         * Returns the default temperature for cold-blooded animals.
         *
         * @return temperature value of 10.0
         */
        default double getTemperature() {
            return 10.0;
        }
    }

    /**
     * Second interface with a default temperature method.
     *
     * <p>Part of a demonstration of inheriting duplicate default methods.
     */
    public interface LivesInOcean {

        /**
         * Returns the default temperature for ocean-dwelling animals.
         *
         * @return temperature value of 12.0
         */
        default double getTemperature() {
            return 12.0;
        }
    }

    /**
     * Demonstrates resolving duplicate default methods.
     *
     * <p><strong>From Chapter 7: Inheriting Duplicate default Methods</strong><br>
     * When a class inherits two or more default methods with the same signature,
     * the class must override the method to resolve the ambiguity. This class
     * implements both IsColdBlooded and LivesInOcean, which both define
     * getTemperature() default methods.
     *
     * <p>The implementation uses the syntax {@code InterfaceName.super.methodName()}
     * to explicitly call a specific interface's default method implementation.
     * This is a special syntax combining interface name with super keyword.
     */
    public static final class Shark implements IsColdBlooded, LivesInOcean {

        /**
         * Resolves the duplicate getTemperature() methods.
         *
         * <p><strong>From Chapter 7: Calling a Hidden default Method</strong><br>
         * Uses the special syntax {@code LivesInOcean.super.getTemperature()} to
         * explicitly call the default method from LivesInOcean interface.
         * This is the only way to access a hidden default method.
         *
         * @return the temperature from LivesInOcean interface (12.0)
         */
        @Override
        public double getTemperature() {
            return LivesInOcean.super.getTemperature();
        }
    }
}

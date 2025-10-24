package ch06.examples;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Mirrors the Chapter 6 listings covering "Overriding Methods", "Declaring Final Methods",
 * "Hiding Static Members", and "Understanding Polymorphism". Each nested class isolates a rule so
 * you can see where the compiler reports errors and how overriding alters behaviour.
 *
 * <p>Topics reinforced:</p>
 * <ul>
 *   <li>Method overriding must respect return-type covariance and checked-exception narrowing.</li>
 *   <li>Static methods participate in hiding, not overriding, and retain compile-time binding.</li>
 *   <li>{@code final} instance methods and {@code final} static methods cannot be overridden or
 *       hidden.</li>
 *   <li>Variable shadowing stores separate copies of a field in parent and child classes.</li>
 * </ul>
 *
 * @see <a href="https://learning.oreilly.com/library/view/ocp-oracle-certified/9781119864585/c06.xhtml">OCP Java SE 17 Study Guide – Chapter 6: Working with Inheritance</a>
 */
public final class MethodInheritanceExamples {

    private MethodInheritanceExamples() {
    }

    /** Base class for "Overriding Methods" example; returns a default weight. */
    public static class Marsupial {

        /**
         * @return default average weight noted in the chapter listing (50 pounds)
         */
        public double getAverageWeight() {
            return 50;
        }
    }

    /**
     * Demonstrates overriding with a call to {@code super} to reuse parent behaviour and then adjust
     * the result.
     */
    public static class Kangaroo extends Marsupial {

        @Override
        public double getAverageWeight() {
            return super.getAverageWeight() + 20;
        }
    }

    /** Parent listing from "Declaring Final Methods" providing a concrete return value. */
    public static class Camel {

        public int getNumberOfHumps() {
            return 1;
        }
    }

    /** Child class that overrides the method to return a different value. */
    public static class BactrianCamel extends Camel {

        @Override
        public int getNumberOfHumps() {
            return 2;
        }
    }

    /**
     * Provides the base signatures for "Declaring Checked Exceptions"; demonstrates that overrides
     * must declare the same or narrower checked exceptions.
     */
    public static class Reptile {

        protected void sleep() throws IOException {
        }

        protected void hide() {
        }

        protected void exitShell() throws FileNotFoundException {
        }
    }

    /**
     * Narrows the checked exception on {@link #sleep()} and shows the compiler errors when widening
     * checked exceptions on other overrides.
     */
    public static class GalapagosTortoise extends Reptile {

        @Override
        public void sleep() throws FileNotFoundException {
        }

        // public void hide() throws FileNotFoundException {} // DOES NOT COMPILE
        // public void exitShell() throws IOException {} // DOES NOT COMPILE
    }

    /** Parent class for the covariant return-type example. */
    public static class Rhino {

        protected CharSequence getName() {
            return "rhino";
        }

        protected String getColor() {
            return "grey, black, or white";
        }
    }

    /**
     * Overrides {@link #getName()} with a covariant, more specific return type.
     * Demonstrates that attempting to widen {@link #getColor()} would fail.
     */
    public static class JavanRhino extends Rhino {

        @Override
        public String getName() {
            return "javan rhino";
        }

        // public CharSequence getColor() { return "grey"; } // DOES NOT COMPILE
    }

    /**
     * Shows that private methods are not inherited and therefore cannot be overridden, only hidden.
     */
    public static class Beetle {

        private String getSize() {
            return "Undefined";
        }
    }

    /**
     * Declares a new private method with the same name; the methods are distinct and the child does
     * not override the parent version.
     */
    public static class RhinocerosBeetle extends Beetle {

        private int getSize() {
            return 5;
        }
    }

    /**
     * Supplies static and instance methods for the hiding examples. Some are intentionally static so
     * the child can hide them.
     */
    public static class Bear {

        public static void eat() {
            System.out.println("Bear is eating");
        }

        public static void sneeze() {
            System.out.println("Bear is sneezing");
        }

        public void hibernate() {
            System.out.println("Bear is hibernating");
        }

        public static void laugh() {
            System.out.println("Bear is laughing");
        }
    }

    /**
     * Hides the static {@code eat()} method to show compile-time binding of static members.
     */
    public static class Panda extends Bear {

        public static void eat() {
            System.out.println("Panda is chewing");
        }
    }

    /** Contains commented-out attempts to override/hide in invalid ways, mirroring the book. */
    public static class SunBear extends Bear {

        // public void sneeze() {} // DOES NOT COMPILE
        // public static void hibernate() {} // DOES NOT COMPILE
        // protected static void laugh() {} // DOES NOT COMPILE
    }

    /** Base class for variable shadowing example. */
    public static class Carnivore {

        protected boolean hasFur = false;
    }

    /**
     * Shadows {@link Carnivore#hasFur} to show each level keeps its own copy of the field.
     */
    public static class Meerkat extends Carnivore {

        protected boolean hasFur = true;
    }

    /** Supplies {@code final} instance and static methods for the override prohibition example. */
    public static class Bird {

        public final boolean hasFeathers() {
            return true;
        }

        public static final void flyAway() {
        }
    }

    /** Shows that attempting to override {@code final} members results in compiler errors. */
    public static class Penguin extends Bird {

        // public boolean hasFeathers() { return false; } // DOES NOT COMPILE
        // public static void flyAway() {} // DOES NOT COMPILE
    }

    /** Provides a baseline method for the polymorphism example. */
    public static class Fish {

        public void swim() {
        }
    }

    /**
     * Overrides {@link #swim()} and hints that overloading with {@code @Override} is illegal.
     */
    public static class Shark extends Fish {

        @Override
        public void swim() {
        }

        // public void swim(int speed) {} // with @Override would not compile
    }
}

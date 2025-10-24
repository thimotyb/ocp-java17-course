package ch07.examples;

/**
 * Demonstrates foundational interface concepts from Chapter 7: Beyond Classes.
 *
 * <p>This class illustrates key interface principles including:
 * <ul>
 *   <li>Basic interface declaration and implementation</li>
 *   <li>Implementing multiple interfaces with compatible method signatures</li>
 *   <li>Interface inheritance using the {@code extends} keyword</li>
 *   <li>Abstract classes implementing interfaces</li>
 *   <li>Inheriting duplicate abstract methods with compatible signatures</li>
 * </ul>
 *
 * <p><strong>From Chapter 7: Declaring and Using an Interface</strong><br>
 * An interface is an abstract data type that declares a list of abstract methods
 * that any class implementing the interface must provide. Unlike classes, which
 * can extend only one class, a class may implement any number of interfaces.
 *
 * <p><strong>Key Concepts:</strong>
 * <ul>
 *   <li>Interfaces are defined with the {@code interface} keyword</li>
 *   <li>Interface methods are implicitly public and abstract</li>
 *   <li>Interface variables are implicitly public, static, and final (constants)</li>
 *   <li>Classes implement interfaces using the {@code implements} keyword</li>
 *   <li>Interfaces can extend multiple other interfaces</li>
 *   <li>Abstract classes can implement interfaces without providing method implementations</li>
 * </ul>
 *
 * @see InterfaceFeatureExamples
 * @see FunctionalInterfaceExamples
 */
public final class InterfaceBasicsExamples {

    private InterfaceBasicsExamples() {
    }

    /**
     * Interface demonstrating a simple abstract method.
     *
     * <p><strong>From Chapter 7: Declaring and Using an Interface</strong><br>
     * This interface defines a single abstract method that returns a Number
     * representing speed based on age.
     */
    public interface Climb {

        /**
         * Returns the climbing speed for a given age.
         *
         * @param age the age of the climber
         * @return the speed as a Number
         */
        Number getSpeed(int age);
    }

    /**
     * Interface with a method signature compatible with {@link Climb}.
     *
     * <p>Uses a more specific return type (Float) which is covariant with Number.
     */
    public interface CanBurrow {

        /**
         * Returns the burrowing speed for a given age.
         *
         * @param age the age of the burrower
         * @return the speed as a Float (covariant with Number)
         */
        Float getSpeed(int age);
    }

    /**
     * Demonstrates implementing multiple interfaces with compatible methods.
     *
     * <p><strong>From Chapter 7: Implementing an Interface</strong><br>
     * This class implements both {@link Climb} and {@link CanBurrow} interfaces.
     * A single method implementation satisfies both interfaces because:
     * <ul>
     *   <li>The method signatures match exactly</li>
     *   <li>Float is covariant with Number (can be implicitly cast)</li>
     *   <li>Access modifier must be explicitly public in the implementing class</li>
     * </ul>
     */
    public static final class FieldMouse implements Climb, CanBurrow {

        /**
         * Implements getSpeed for both Climb and CanBurrow interfaces.
         *
         * <p>Returns different speeds based on age, demonstrating covariant return types.
         *
         * @param age the age of the field mouse
         * @return 5.5f for mice younger than 3, otherwise 8.0f
         */
        @Override
        public Float getSpeed(int age) {
            return age < 3 ? 5.5f : 8.0f;
        }
    }

    /**
     * Interface for nocturnal animals.
     *
     * <p>Part of an interface hierarchy demonstrating multiple interface inheritance.
     */
    public interface Nocturnal {

        /**
         * Returns hunting efficiency.
         *
         * @return the hunting efficiency value
         */
        int hunt();
    }

    /**
     * Interface for flying animals.
     *
     * <p>Part of an interface hierarchy demonstrating multiple interface inheritance.
     */
    public interface CanFly {

        /**
         * Performs a flapping action.
         */
        void flap();
    }

    /**
     * Demonstrates an interface extending multiple interfaces.
     *
     * <p><strong>From Chapter 7: Extending an Interface</strong><br>
     * Unlike a class, which can extend only one class, an interface can extend
     * multiple interfaces. This is permitted because interfaces are not initialized
     * as part of a class hierarchy. They do not contain constructors and are not
     * part of instance initialization.
     */
    public interface HasBigEyes extends Nocturnal, CanFly {
    }

    /**
     * Demonstrates implementing an interface that extends multiple interfaces.
     *
     * <p><strong>From Chapter 7: Inheriting an Interface</strong><br>
     * This class must implement all abstract methods inherited through the
     * interface hierarchy: both hunt() from Nocturnal and flap() from CanFly.
     */
    public static final class Owl implements HasBigEyes {

        /**
         * Implements the hunt method from Nocturnal interface.
         *
         * @return hunting efficiency value of 5
         */
        @Override
        public int hunt() {
            return 5;
        }

        /**
         * Implements the flap method from CanFly interface.
         *
         * <p>No output to keep tests deterministic.
         */
        @Override
        public void flap() {
            // print avoided to keep tests deterministic
        }
    }

    /**
     * Interface defining tail characteristics.
     */
    public interface HasTail {

        /**
         * Returns the length of the tail.
         *
         * @return tail length in centimeters
         */
        int getTailLength();
    }

    /**
     * Interface defining whisker characteristics.
     */
    public interface HasWhiskers {

        /**
         * Returns the number of whiskers.
         *
         * @return whisker count
         */
        int getNumberOfWhiskers();
    }

    /**
     * Demonstrates an abstract class implementing interfaces.
     *
     * <p><strong>From Chapter 7: Inheriting an Interface</strong><br>
     * An abstract class that implements an interface is not required to provide
     * implementations for the inherited abstract methods. The concrete subclass,
     * however, must override all inherited abstract methods.
     */
    public abstract static class HarborSeal implements HasTail, HasWhiskers {
    }

    /**
     * Concrete class extending an abstract class that implements interfaces.
     *
     * <p><strong>From Chapter 7: Inheriting an Interface</strong><br>
     * This concrete class must implement all abstract methods inherited from
     * the HarborSeal class, which in turn implements HasTail and HasWhiskers.
     */
    public static final class CommonSeal extends HarborSeal {

        /**
         * Implements getTailLength from HasTail interface.
         *
         * @return tail length of 15 centimeters
         */
        @Override
        public int getTailLength() {
            return 15;
        }

        /**
         * Implements getNumberOfWhiskers from HasWhiskers interface.
         *
         * @return whisker count of 24
         */
        @Override
        public int getNumberOfWhiskers() {
            return 24;
        }
    }

    /**
     * Interface for herbivorous animals.
     *
     * <p>Demonstrates inheriting duplicate abstract methods with compatible signatures.
     */
    public interface Herbivore {

        /**
         * Consumes plant matter.
         */
        void eatPlants();
    }

    /**
     * Interface for omnivorous animals.
     *
     * <p>Contains the same method signature as Herbivore.eatPlants().
     */
    public interface Omnivore {

        /**
         * Consumes plant matter.
         */
        void eatPlants();
    }

    /**
     * Demonstrates inheriting duplicate abstract methods.
     *
     * <p><strong>From Chapter 7: Inheriting Duplicate Abstract Methods</strong><br>
     * Java supports inheriting two abstract methods that have compatible method
     * declarations. By compatible, we mean a method can be written that properly
     * overrides both inherited methods. In this case, a single implementation of
     * eatPlants() satisfies both the Herbivore and Omnivore interfaces.
     */
    public static final class Bear implements Herbivore, Omnivore {

        /**
         * Implements eatPlants for both Herbivore and Omnivore interfaces.
         *
         * <p>A single method implementation satisfies both interfaces because
         * the method signatures are identical.
         */
        @Override
        public void eatPlants() {
            // shared implementation satisfies both interfaces
        }
    }
}

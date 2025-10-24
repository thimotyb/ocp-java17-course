package ch07.examples;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Demonstrates functional interfaces from Chapter 7: Beyond Classes.
 *
 * <p><strong>From Chapter 7: Coding Functional Interfaces</strong><br>
 * A functional interface is an interface that contains exactly one abstract method.
 * Functional interfaces are the foundation of lambda expressions and method references
 * in Java. They are marked with the {@code @FunctionalInterface} annotation to
 * indicate this special purpose and enable compile-time checking.
 *
 * <p><strong>Key Concepts:</strong>
 * <ul>
 *   <li>Must contain exactly one abstract method (Single Abstract Method - SAM)</li>
 *   <li>Can contain any number of default methods</li>
 *   <li>Can contain any number of static methods</li>
 *   <li>Can contain any number of private methods</li>
 *   <li>The {@code @FunctionalInterface} annotation is optional but recommended</li>
 *   <li>Enables use with lambda expressions and method references</li>
 * </ul>
 *
 * <p>This interface demonstrates that a functional interface can have:
 * <ul>
 *   <li>One abstract method: {@link #sprint(int)}</li>
 *   <li>Default methods: {@link #description()}</li>
 *   <li>Static methods: {@link #fromList(List)} and {@link #captureRuns(FunctionalInterfaceExamples, int...)}</li>
 * </ul>
 *
 * <p><strong>Usage Example:</strong>
 * <pre>{@code
 * // Using a lambda expression
 * FunctionalInterfaceExamples runner = speed -> System.out.println("Running at " + speed);
 * runner.sprint(10);
 *
 * // Using a method reference
 * List<Integer> speeds = new ArrayList<>();
 * FunctionalInterfaceExamples recorder = speeds::add;
 * recorder.sprint(15);
 * }</pre>
 *
 * @see InterfaceBasicsExamples
 * @see InterfaceFeatureExamples
 */
@FunctionalInterface
public interface FunctionalInterfaceExamples {

    /**
     * The single abstract method (SAM) of this functional interface.
     *
     * <p><strong>From Chapter 7: Coding Functional Interfaces</strong><br>
     * This is the only abstract method in the interface, making it a valid
     * functional interface. This method can be implemented using lambda
     * expressions or method references.
     *
     * <p>Executes a sprint action at the specified speed.
     *
     * @param speed the speed at which to sprint
     */
    void sprint(int speed);

    /**
     * Default method providing a description.
     *
     * <p>Functional interfaces can contain default methods in addition to
     * their single abstract method. Default methods do not count toward
     * the "single abstract method" requirement.
     *
     * @return a generic description of the sprint functionality
     */
    default String description() {
        return "Generic sprint";
    }

    /**
     * Factory method creating a functional interface instance from a list.
     *
     * <p><strong>From Chapter 7: Coding Functional Interfaces</strong><br>
     * Static methods in functional interfaces can serve as factory methods
     * to create instances. This method returns a lambda expression that
     * adds speeds to the provided list.
     *
     * <p>Static methods do not count toward the "single abstract method"
     * requirement of functional interfaces.
     *
     * @param speeds the list to which sprint speeds will be added
     * @return a FunctionalInterfaceExamples instance that adds speeds to the list
     */
    static FunctionalInterfaceExamples fromList(List<Integer> speeds) {
        return speed -> speeds.add(speed);
    }

    /**
     * Utility method demonstrating functional interface usage.
     *
     * <p>This static method shows how functional interfaces can be used
     * as parameters and combined with lambda expressions. It:
     * <ol>
     *   <li>Creates a list from the provided values</li>
     *   <li>Creates a new functional interface instance using {@link #fromList(List)}</li>
     *   <li>Executes both the provided runner and the combined instance for each value</li>
     *   <li>Returns the recorded list of values</li>
     * </ol>
     *
     * @param runner the functional interface instance to execute
     * @param values variable number of speed values to process
     * @return list containing all processed speed values
     */
    static List<Integer> captureRuns(FunctionalInterfaceExamples runner, int... values) {
        // Convert array to list for collection
        List<Integer> recorded = java.util.Arrays.stream(values).boxed().collect(Collectors.toList());

        // Create a functional interface instance using factory method
        FunctionalInterfaceExamples combined = FunctionalInterfaceExamples.fromList(recorded);

        // Execute both the provided runner and our recorder for each value
        for (int value : values) {
            runner.sprint(value);      // Execute the provided implementation
            combined.sprint(value);     // Record the value in our list
        }

        return recorded;
    }
}

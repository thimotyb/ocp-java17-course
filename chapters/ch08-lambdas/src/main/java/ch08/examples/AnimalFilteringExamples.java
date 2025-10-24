package ch08.examples;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

/**
 * Replays the animal-filtering walkthrough from Chapter 8 "Working with Traditional Functional
 * Interfaces". The examples show how a custom functional interface evolves into the built-in
 * {@link java.util.function.Predicate} while reinforcing the lambda selection rules discussed in
 * the chapter.
 *
 * <p>Concepts reinforced:</p>
 * <ul>
 *   <li>Declaring single abstract method (SAM) interfaces for lambda consumption.</li>
 *   <li>Passing lambdas to methods that iterate over collections and apply behavioural logic.</li>
 *   <li>Transitioning from custom interfaces to the standard {@link Predicate} API.</li>
 * </ul>
 *
 * @see <a href="https://learning.oreilly.com/library/view/ocp-oracle-certified/9781119864585/c08.xhtml">OCP Java SE 17 Study Guide – Chapter 8: Working with Traditional Functional Interfaces</a>
 */
public final class AnimalFilteringExamples {

    private AnimalFilteringExamples() {
    }

    /**
     * Compact record mirroring the chapter's immutable animal data transfer object.
     */
    public record Animal(String name, boolean canHop, boolean canSwim) {
    }

    @FunctionalInterface
    public interface CheckTrait {

        /**
         * Evaluates the passed in {@link Animal} for a particular trait, matching the book's custom
         * SAM definition.
         */
        boolean test(Animal animal);
    }

    /**
     * Filters animals with a custom SAM, copying the first listing from the chapter before the
     * switch to built-in interfaces.
     *
     * @param animals source animals to inspect
     * @param trait behaviour supplied via lambda expression
     * @return names of animals that satisfy the provided trait
     */
    public static List<String> filterAnimals(List<Animal> animals, CheckTrait trait) {
        List<String> results = new ArrayList<>();
        for (Animal animal : animals) {
            if (trait.test(animal)) {
                results.add(animal.name());
            }
        }
        return results;
    }

    /**
     * Updated version that accepts a {@link Predicate}, echoing the "moving to built-in functional
     * interfaces" section of the chapter.
     *
     * @param animals source animals to inspect
     * @param predicate standard predicate describing the trait check
     * @return names of the matching animals
     */
    public static List<String> filterWithPredicate(List<Animal> animals, Predicate<Animal> predicate) {
        List<String> results = new ArrayList<>();
        animals.stream().filter(predicate).map(Animal::name).forEach(results::add);
        return results;
    }

    /**
     * @return sample data set used throughout the chapter's filtering scenarios
     */
    public static List<Animal> sampleAnimals() {
        return List.of(
            new Animal("fish", false, true),
            new Animal("kangaroo", true, false),
            new Animal("rabbit", true, false),
            new Animal("turtle", false, true)
        );
    }
}

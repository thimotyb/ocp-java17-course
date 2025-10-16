package ch08.examples;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

/**
 * Mirrors the animal filtering listings using lambdas from Chapter 8.
 */
public final class AnimalFilteringExamples {

    private AnimalFilteringExamples() {
    }

    public record Animal(String name, boolean canHop, boolean canSwim) {
    }

    @FunctionalInterface
    public interface CheckTrait {

        boolean test(Animal animal);
    }

    public static List<String> filterAnimals(List<Animal> animals, CheckTrait trait) {
        List<String> results = new ArrayList<>();
        for (Animal animal : animals) {
            if (trait.test(animal)) {
                results.add(animal.name());
            }
        }
        return results;
    }

    public static List<String> filterWithPredicate(List<Animal> animals, Predicate<Animal> predicate) {
        List<String> results = new ArrayList<>();
        animals.stream().filter(predicate).map(Animal::name).forEach(results::add);
        return results;
    }

    public static List<Animal> sampleAnimals() {
        return List.of(
            new Animal("fish", false, true),
            new Animal("kangaroo", true, false),
            new Animal("rabbit", true, false),
            new Animal("turtle", false, true)
        );
    }
}

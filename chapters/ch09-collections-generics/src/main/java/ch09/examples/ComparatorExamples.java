package ch09.examples;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Illustrates Comparable and Comparator usage.
 */
public final class ComparatorExamples {

    private ComparatorExamples() {
    }

    public record Animal(String name, int weight) implements Comparable<Animal> {

        @Override
        public int compareTo(Animal other) {
            return name.compareTo(other.name);
        }
    }

    public static List<Animal> sortNatural(List<Animal> animals) {
        List<Animal> copy = new ArrayList<>(animals);
        Collections.sort(copy);
        return copy;
    }

    public static List<Animal> sortByWeight(List<Animal> animals) {
        List<Animal> copy = new ArrayList<>(animals);
        copy.sort(Comparator.comparingInt(Animal::weight));
        return copy;
    }

    public static Comparator<Animal> reversedNameThenWeight() {
        return Comparator.comparing(Animal::name).reversed().thenComparingInt(Animal::weight);
    }
}

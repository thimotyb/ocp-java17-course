package ch09.examples;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Implements the comparison examples from Chapter 9 "Using Common Collection Types" and "Working
 * with Comparable and Comparator". The utilities demonstrate natural ordering, custom comparators,
 * and chained comparators as presented in the study guide.
 *
 * @see <a href="https://learning.oreilly.com/library/view/ocp-oracle-certified/9781119864585/c09.xhtml">OCP Java SE 17 Study Guide – Chapter 9: Working with Comparable and Comparator</a>
 */
public final class ComparatorExamples {

    private ComparatorExamples() {
    }

    /**
     * Record mirroring the chapter's data model. Implements {@link Comparable} to show natural
     * ordering by name.
     */
    public record Animal(String name, int weight) implements Comparable<Animal> {

        @Override
        public int compareTo(Animal other) {
            return name.compareTo(other.name);
        }
    }

    /**
     * @param animals source list
     * @return copy sorted using the natural ({@link Comparable}) order
     */
    public static List<Animal> sortNatural(List<Animal> animals) {
        List<Animal> copy = new ArrayList<>(animals);
        Collections.sort(copy);
        return copy;
    }

    /**
     * @param animals source list
     * @return copy sorted by weight via {@link Comparator#comparingInt}
     */
    public static List<Animal> sortByWeight(List<Animal> animals) {
        List<Animal> copy = new ArrayList<>(animals);
        copy.sort(Comparator.comparingInt(Animal::weight));
        return copy;
    }

    /**
     * @return comparator that reverses the name order and then compares by weight, echoing the
     *     "thenComparing" example in the book
     */
    public static Comparator<Animal> reversedNameThenWeight() {
        return Comparator.comparing(Animal::name).reversed().thenComparingInt(Animal::weight);
    }
}

package ch09.examples;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Demonstrates the list behaviours catalogued in Chapter 9 "Using Lists" including mutability
 * characteristics of {@link ArrayList}, {@link java.util.Arrays#asList(Object...)}, and
 * {@link List#of(Object...)} as well as binary search requirements.
 *
 * @see <a href="https://learning.oreilly.com/library/view/ocp-oracle-certified/9781119864585/c09.xhtml">OCP Java SE 17 Study Guide – Chapter 9: Using Lists</a>
 */
public final class ListExamples {

    private ListExamples() {
    }

    /**
     * @return new {@link ArrayList} that goes through the add/remove/sort operations highlighted in
     *     the chapter
     */
    public static List<String> mutableAnimals() {
        List<String> animals = new ArrayList<>(List.of("lion", "penguin", "bear"));
        animals.add("tiger");
        animals.remove("penguin");
        animals.add(1, "lemur");
        Collections.sort(animals);
        return animals;
    }

    /**
     * @return fixed-size list produced by {@link Arrays#asList(Object...)}, demonstrating that size
     *     cannot change even though elements may be reassigned
     */
    public static List<String> fixedSizeList() {
        return Arrays.asList("hawk", "falcon");
    }

    /**
     * @return truly immutable list produced by {@link List#of(Object...)}
     */
    public static List<String> immutableList() {
        return List.of("zebra", "giraffe");
    }

    /**
     * Demonstrates {@link Collections#binarySearch(List, Object)} on a sorted list.
     *
     * @param sorted ascending list of strings
     * @param target item to locate
     * @return index or insertion point as described in the chapter
     */
    public static int binarySearch(List<String> sorted, String target) {
        return Collections.binarySearch(sorted, target);
    }
}

package ch09.examples;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Demonstrates List operations from Chapter 9.
 */
public final class ListExamples {

    private ListExamples() {
    }

    public static List<String> mutableAnimals() {
        List<String> animals = new ArrayList<>(List.of("lion", "penguin", "bear"));
        animals.add("tiger");
        animals.remove("penguin");
        animals.add(1, "lemur");
        Collections.sort(animals);
        return animals;
    }

    public static List<String> fixedSizeList() {
        return Arrays.asList("hawk", "falcon");
    }

    public static List<String> immutableList() {
        return List.of("zebra", "giraffe");
    }

    public static int binarySearch(List<String> sorted, String target) {
        return Collections.binarySearch(sorted, target);
    }
}

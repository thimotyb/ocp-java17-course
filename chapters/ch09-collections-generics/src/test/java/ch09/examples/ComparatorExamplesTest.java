package ch09.examples;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

class ComparatorExamplesTest {

    private static final List<ComparatorExamples.Animal> ANIMALS = List.of(
        new ComparatorExamples.Animal("seal", 220),
        new ComparatorExamples.Animal("aardvark", 65),
        new ComparatorExamples.Animal("bear", 300)
    );

    @Test
    void naturalOrderSortsByName() {
        assertEquals(List.of(
            new ComparatorExamples.Animal("aardvark", 65),
            new ComparatorExamples.Animal("bear", 300),
            new ComparatorExamples.Animal("seal", 220)
        ), ComparatorExamples.sortNatural(ANIMALS));
    }

    @Test
    void comparatorSortsByWeight() {
        assertEquals(List.of(
            new ComparatorExamples.Animal("aardvark", 65),
            new ComparatorExamples.Animal("seal", 220),
            new ComparatorExamples.Animal("bear", 300)
        ), ComparatorExamples.sortByWeight(ANIMALS));
    }

    @Test
    void reversedComparatorAppliesSecondaryOrder() {
        var comparator = ComparatorExamples.reversedNameThenWeight();
        var sorted = ANIMALS.stream().sorted(comparator).toList();
        assertEquals("seal", sorted.get(0).name());
        assertEquals("aardvark", sorted.get(sorted.size() - 1).name());
    }
}

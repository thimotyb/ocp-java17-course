package ch08.examples;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

class AnimalFilteringExamplesTest {

    @Test
    void filterAnimalsWithCustomFunctionalInterface() {
        var animals = AnimalFilteringExamples.sampleAnimals();
        List<String> hoppers = AnimalFilteringExamples.filterAnimals(animals, AnimalFilteringExamples.Animal::canHop);
        assertEquals(List.of("kangaroo", "rabbit"), hoppers);
    }

    @Test
    void filterAnimalsWithPredicate() {
        var animals = AnimalFilteringExamples.sampleAnimals();
        List<String> swimmers = AnimalFilteringExamples.filterWithPredicate(animals, AnimalFilteringExamples.Animal::canSwim);
        assertEquals(List.of("fish", "turtle"), swimmers);
    }
}

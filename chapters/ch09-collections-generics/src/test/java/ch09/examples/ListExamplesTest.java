package ch09.examples;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;

class ListExamplesTest {

    @Test
    void mutableListSortedAndModified() {
        List<String> animals = ListExamples.mutableAnimals();
        assertEquals(List.of("bear", "lemur", "lion", "tiger"), animals);
    }

    @Test
    void fixedSizeListDisallowsStructuralChanges() {
        List<String> birds = ListExamples.fixedSizeList();
        assertThrows(UnsupportedOperationException.class, () -> birds.add("owl"));
    }

    @Test
    void immutableListThrowsOnSet() {
        List<String> mammals = ListExamples.immutableList();
        assertThrows(UnsupportedOperationException.class, () -> mammals.set(0, "lion"));
    }

    @Test
    void binarySearchFindsElement() {
        List<String> sorted = List.of("ant", "bat", "cat", "dog");
        assertEquals(2, ListExamples.binarySearch(sorted, "cat"));
        assertTrue(ListExamples.binarySearch(sorted, "emu") < 0);
    }
}

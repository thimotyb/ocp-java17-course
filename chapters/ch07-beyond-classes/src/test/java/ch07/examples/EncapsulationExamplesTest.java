package ch07.examples;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;

import org.junit.jupiter.api.Test;

class EncapsulationExamplesTest {

    @Test
    void inventoryReturnsUnmodifiableView() {
        var inventory = new EncapsulationExamples.ZooInventory();
        inventory.addAnimal("Lion");
        List<String> animals = inventory.getAnimals();
        assertEquals(List.of("Lion"), animals);
        assertThrows(UnsupportedOperationException.class, () -> animals.add("Tiger"));
    }
}

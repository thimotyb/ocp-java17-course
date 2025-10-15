package ch01.examples;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class AnimalTest {

    @Test
    void managesNameAndVisitorCount() {
        Animal animal = new Animal();
        animal.setName("Panda");
        assertEquals("Panda", animal.getName());
        assertEquals(10, animal.numberVisitors(1));
    }
}

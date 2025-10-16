package ch06.examples;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

class ConstructorExamplesTest {

    @Test
    void turtleConstructorsAssignNames() {
        var defaultTurtle = new ConstructorExamples.Turtle();
        var ageTurtle = new ConstructorExamples.Turtle(5);
        var nameTurtle = new ConstructorExamples.Turtle("Leo", "lettuce", "berries");
        assertEquals("John Doe", defaultTurtle.getName());
        assertEquals("Age:5", ageTurtle.getName());
        assertEquals("Leo:2", nameTurtle.getName());
    }

    @Test
    void rabbitsMultiplyShowsAvailableConstructors() {
        assertArrayEquals(new boolean[] {true, true, true}, ConstructorExamples.RabbitsMultiply.create());
    }

    @Test
    void hamsterChainingSetsDefaults() {
        var hamster = new ConstructorExamples.Hamster(3);
        assertEquals(3, hamster.getWeight());
        assertEquals("brown", hamster.getColor());
    }

    @Test
    void zebraAndGorillaCallParentConstructors() {
        var zebra = new ConstructorExamples.Zebra();
        assertEquals(4, zebra.getAge());
        var gorilla = new ConstructorExamples.Gorilla();
        assertEquals(5, gorilla.getAge());
        assertEquals("Gorilla", gorilla.getName());
    }

    @Test
    void sealAndElephantInvokeMammalSuperConstructors() {
        assertNotNull(new ConstructorExamples.Seal());
        assertNotNull(new ConstructorExamples.Elephant());
        assertNotNull(new ConstructorExamples.Elephant(12));
    }
}

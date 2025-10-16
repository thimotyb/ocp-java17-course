package ch06.examples;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

class AbstractExamplesTest {

    @Test
    void canineSubclassesProvideSounds() {
        assertEquals("Wooooooof!", new AbstractExamples.Wolf().getSound());
        assertEquals("Squeak!", new AbstractExamples.Fox().getSound());
        assertEquals("Yip!", new AbstractExamples.Coyote().getSound());
    }

    @Test
    void lionImplementsAbstractMethods() {
        var lion = new AbstractExamples.Lion();
        assertEquals("Lion", lion.getName());
    }

    @Test
    void blackRhinoImplementsRemainingAbstractMethod() {
        assertNotNull(new AbstractExamples.BlackRhino());
    }

    @Test
    void platypusInitialisesAbstractConstructor() {
        assertNotNull(new AbstractExamples.Platypus());
    }
}

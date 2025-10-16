package ch07.examples;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class SealedExamplesTest {

    @Test
    void describeSealedAnimals() {
        assertEquals("Lion roars", SealedExamples.describe(new SealedExamples.Lion()));
        assertEquals("Penguin waddles", SealedExamples.describe(new SealedExamples.Penguin()));
    }
}

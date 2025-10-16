package ch03.examples;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class IfExamplesTest {

    @Test
    void greetingFollowsElseIfChain() {
        assertEquals("Good Morning", IfExamples.greet(9));
        assertEquals("Good Afternoon", IfExamples.greet(14));
        assertEquals("Good Evening", IfExamples.greet(20));
    }

    @Test
    void morningCounterIncrementsOnlyBefore11() {
        assertEquals(1, IfExamples.morningGreetingCount(8));
        assertEquals(0, IfExamples.morningGreetingCount(12));
    }
}

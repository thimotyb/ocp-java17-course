package ch07.examples;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class InterfaceFeatureExamplesTest {

    @Test
    void soarProvidesDefaultAndStaticMethods() {
        var eagle = new InterfaceFeatureExamples.Eagle();
        assertEquals("Taking off at max height 10", eagle.takeoff());
        eagle.fly(30);
        assertEquals(30, eagle.getLastSpeed());
        double result = InterfaceFeatureExamples.Soar.dive();
        assertTrue(result >= 0.0 && result <= 1.0);
    }

    @Test
    void sharkResolvesDefaultConflictExplicitly() {
        var shark = new InterfaceFeatureExamples.Shark();
        assertEquals(12.0, shark.getTemperature(), 0.0001);
    }
}

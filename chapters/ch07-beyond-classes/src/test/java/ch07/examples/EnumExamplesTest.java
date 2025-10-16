package ch07.examples;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class EnumExamplesTest {

    @Test
    void seasonOverridesActivity() {
        assertEquals("Swim", EnumExamples.Season.SUMMER.activity());
        assertEquals("Hibernate", EnumExamples.Season.WINTER.activity());
        assertEquals(25, EnumExamples.Season.SUMMER.getAverageTemperature());
    }

    @Test
    void zooTrainTourHighlights() {
        assertEquals("Penguins", EnumExamples.ZooTrainTour.NORTH.getHighlight());
    }
}

package ch03.switching;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class LegacySwitchPlannerTest {

    @Test
    void scheduleRecognisesWeekend() {
        assertEquals("Weekend events", LegacySwitchPlanner.scheduleForDay("sat"));
        assertEquals("Standard schedule", LegacySwitchPlanner.scheduleForDay("wed"));
        assertEquals("Closed", LegacySwitchPlanner.scheduleForDay(null));
    }

    @Test
    void fallThroughCombinesMeals() {
        assertEquals("Breakfast", LegacySwitchPlanner.mealForHour(9));
        assertEquals("Brunch/Lunch", LegacySwitchPlanner.mealForHour(11));
        assertEquals("Snacks only", LegacySwitchPlanner.mealForHour(15));
    }
}

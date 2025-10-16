package ch07.examples;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class RecordExamplesTest {

    @Test
    void keeperTrimsAndValidates() {
        var keeper = new RecordExamples.Keeper("  Sam  ", 3);
        assertEquals("Sam", keeper.name());
        assertEquals(3, keeper.experienceYears());
    }

    @Test
    void exhibitRequiresPositiveCapacity() {
        assertThrows(IllegalArgumentException.class, () -> new RecordExamples.Exhibit("Reptiles", 0));
    }
}

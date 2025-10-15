package ch01.randomizer;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Random;
import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;

class NumberPickerTest {

    @Test
    void usesInjectedRandomForDeterministicResult() {
        int expected = new Random(42).nextInt(10);
        NumberPicker picker = new NumberPicker(new Random(42));
        int actual = picker.pickWithImport(10);
        assertEquals(expected, actual);
    }

    @Test
    void fullyQualifiedPickerRespectsBounds() {
        NumberPicker picker = new NumberPicker();
        IntStream.range(0, 100).forEach(i -> {
            int value = picker.pickWithFullyQualified(5);
            assertTrue(value >= 0 && value < 5);
        });
    }

    @Test
    void inclusiveRangeCoversOrigin() {
        NumberPicker picker = new NumberPicker();
        boolean originHit = IntStream.range(0, 200)
                .map(i -> picker.pickInclusiveRange(3, 4))
                .anyMatch(value -> value == 3);
        assertTrue(originHit);
    }

    @Test
    void validatesBounds() {
        NumberPicker picker = new NumberPicker();
        assertThrows(IllegalArgumentException.class, () -> picker.pickWithImport(0));
        assertThrows(IllegalArgumentException.class, () -> picker.pickInclusiveRange(5, 5));
    }
}

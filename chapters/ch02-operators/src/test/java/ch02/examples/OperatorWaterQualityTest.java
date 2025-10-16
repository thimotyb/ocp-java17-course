package ch02.examples;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class OperatorWaterQualityTest {

    @Test
    void evaluatesWaterQualityConditions() {
        OperatorWaterQuality.Result result = OperatorWaterQuality.evaluate();
        assertTrue(result.clear());
        assertFalse(result.safe());
        assertFalse(result.tasty());
        assertEquals(6, result.ph());
        assertEquals(2, result.vis());
    }
}

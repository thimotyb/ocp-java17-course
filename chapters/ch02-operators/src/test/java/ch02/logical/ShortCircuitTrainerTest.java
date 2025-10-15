package ch02.logical;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.concurrent.atomic.AtomicInteger;

import org.junit.jupiter.api.Test;

class ShortCircuitTrainerTest {

    @Test
    void conditionalAndSkipsSupplierWhenLeftFalse() {
        AtomicInteger counter = new AtomicInteger();
        boolean result = ShortCircuitTrainer.conditionalAnd(false, () -> {
            counter.incrementAndGet();
            return true;
        });
        assertFalse(result);
        assertEquals(0, counter.get());
    }

    @Test
    void nonShortCircuitAndInvokesSupplierRegardless() {
        AtomicInteger counter = new AtomicInteger();
        boolean result = ShortCircuitTrainer.nonShortCircuitAnd(false, () -> {
            counter.incrementAndGet();
            return true;
        });
        assertFalse(result);
        assertEquals(1, counter.get());
    }

    @Test
    void conditionalOrShortCircuitsWhenLeftTrue() {
        AtomicInteger counter = new AtomicInteger();
        boolean result = ShortCircuitTrainer.conditionalOr(true, () -> {
            counter.incrementAndGet();
            return false;
        });
        assertTrue(result);
        assertEquals(0, counter.get());
    }

    @Test
    void nonShortCircuitOrEvaluatesBothSides() {
        AtomicInteger counter = new AtomicInteger();
        boolean result = ShortCircuitTrainer.nonShortCircuitOr(true, () -> {
            counter.incrementAndGet();
            return false;
        });
        assertTrue(result);
        assertEquals(1, counter.get());
    }
}

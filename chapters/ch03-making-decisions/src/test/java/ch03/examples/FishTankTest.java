package ch03.examples;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class FishTankTest {

    @Test
    void goldieSwims() {
        assertEquals("Swim!", FishTank.getFish("goldie"));
    }

    @Test
    void unknownFishIsEatenAndSwims() {
        assertEquals("Eat!Swim!", FishTank.getFish(1));
    }
}

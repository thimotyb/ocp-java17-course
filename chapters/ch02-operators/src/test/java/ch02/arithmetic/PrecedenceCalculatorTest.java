package ch02.arithmetic;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class PrecedenceCalculatorTest {

    @Test
    void calculatesRewardWithPreDecrement() {
        PrecedenceCalculator.RewardResult result = PrecedenceCalculator.calculateReward(4);
        assertEquals(4, result.initialCookies());
        assertEquals(3, result.remainingCookies());
        assertEquals(9.0, result.rewardPoints());
    }

    @Test
    void computesPerimeterUsingMultiplicativePrecedence() {
        int perimeter = PrecedenceCalculator.perimeter(3, 5);
        assertEquals(16, perimeter);
    }
}

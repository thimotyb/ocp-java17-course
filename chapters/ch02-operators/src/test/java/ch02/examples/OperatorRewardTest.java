package ch02.examples;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class OperatorRewardTest {

    @Test
    void calculatesRewardAndCookies() {
        OperatorReward.Result result = OperatorReward.calculate();
        assertEquals(3, result.cookies());
        assertEquals(9.0, result.reward(), 0.0001);
    }
}

package ch02.arithmetic;

/**
 * Highlights how operator precedence and pre-decrement impact evaluation.
 */
public final class PrecedenceCalculator {

    private PrecedenceCalculator() {
    }

    public static RewardResult calculateReward(int startingCookies) {
        int working = startingCookies;
        double reward = 3 + 2 * --working;
        return new RewardResult(startingCookies, working, reward);
    }

    public static int perimeter(int height, int length) {
        return 2 * height + 2 * length;
    }

    public record RewardResult(int initialCookies, int remainingCookies, double rewardPoints) {
    }
}

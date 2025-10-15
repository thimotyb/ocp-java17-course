package ch02;

import ch02.arithmetic.PrecedenceCalculator;
import ch02.assignment.CompoundOperations;
import ch02.comparison.ComparisonPlayground;
import ch02.logical.ShortCircuitTrainer;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Console entry point summarising the operator examples in this chapter.
 */
public final class OperatorsShowcase {

    private OperatorsShowcase() {
    }

    public static void main(String[] args) {
        var reward = PrecedenceCalculator.calculateReward(4);
        System.out.printf("Reward: %.1f (remaining cookies: %d)%n",
                reward.rewardPoints(), reward.remainingCookies());

        int multiplied = CompoundOperations.multiply(7, 3L);
        short adjusted = CompoundOperations.addToShort((short) 5, 3);
        System.out.printf("Compound ops -> multiply: %d, addToShort: %d%n", multiplied, adjusted);

        System.out.printf("Integer cache hit? %s, miss? %s%n",
                ComparisonPlayground.smallIntegerCacheHit(),
                ComparisonPlayground.largeIntegerCacheMiss());

        var counter = new AtomicInteger();
        ShortCircuitTrainer.conditionalAnd(false, () -> { counter.incrementAndGet(); return true; });
        ShortCircuitTrainer.nonShortCircuitAnd(false, () -> { counter.incrementAndGet(); return true; });
        System.out.printf("Short-circuit evaluations triggered: %d%n", counter.get());
    }
}

package ch01.randomizer;

import java.util.Objects;
import java.util.Random;

/**
 * Example that contrasts specific imports and fully qualified class names.
 */
public final class NumberPicker {

    private final Random random;

    public NumberPicker() {
        this(new Random());
    }

    public NumberPicker(Random random) {
        this.random = Objects.requireNonNull(random, "random");
    }

    public int pickWithImport(int bound) {
        if (bound <= 0) {
            throw new IllegalArgumentException("bound must be greater than zero");
        }
        return random.nextInt(bound);
    }

    public int pickWithFullyQualified(int bound) {
        if (bound <= 0) {
            throw new IllegalArgumentException("bound must be greater than zero");
        }
        return java.util.concurrent.ThreadLocalRandom.current().nextInt(bound);
    }

    public int pickInclusiveRange(int originInclusive, int boundExclusive) {
        if (originInclusive >= boundExclusive) {
            throw new IllegalArgumentException("origin must be lower than bound");
        }
        return java.util.concurrent.ThreadLocalRandom.current().nextInt(originInclusive, boundExclusive);
    }
}

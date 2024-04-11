package org.perk.diceroll;

import java.util.Random;

import static java.util.Objects.requireNonNull;

public class Die {

    private final int min;
    private final int max;

    public static Die withMaxDots(final int maxDots) {
        return new Die(maxDots);
    }

    public Die() {
        this(6);
    }

    public Die(final int max) {
        this(1, max);
    }

    public Die(final int min, final int max) {
        if (max < min) {
            throw new IllegalArgumentException("The maximum amount of dots on the die cannot be less than the minimum");
        }
        this.min = min;
        this.max = max;
    }

    public int roll() {
        return (int)(Math.random() * (max - min + 1) + min);
    }

    public int roll(final Random random) {
        requireNonNull(random);
        return random.nextInt(max) + 1;
    }

    public int getMin() {
        return min;
    }

    public int getMax() {
        return max;
    }

}


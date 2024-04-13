package org.perk.diceroll;

import java.util.Random;

import static java.util.Objects.requireNonNull;

public class Die {

    private final int max;

    public static Die withMaxDots(final int maxDots) {
        return new Die(maxDots);
    }

    public Die() {
        this(6);
    }

    public Die(final int max) {
        if (max < 1) {
            throw new IllegalArgumentException("The maximum amount of dots on the die cannot be less than 1");
        }
        this.max = max;
    }

    public int roll() {
        return (int) (Math.random() * max + 1);
    }

    public int roll(final Random random) {
        requireNonNull(random);
        return random.nextInt(max) + 1;
    }

    public int getMax() {
        return max;
    }

}


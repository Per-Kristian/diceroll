package org.perk.diceroll;

import java.util.Random;

import static java.util.Objects.requireNonNull;

public class Die {

    public static final int MIN = 1;

    private final int max;

    public Die() {
        this(6);
    }

    public Die(final int max) {
        if (max < MIN) {
            throw new IllegalArgumentException(STR."The max amount of dots on the die cannot be less than \{MIN}");
        }
        this.max = max;
    }

    public int roll() {
        return (int)(Math.random() * (max - MIN + 1) + MIN);
    }

    public int roll(final Random random) {
        requireNonNull(random);
        return random.nextInt(max) + 1;
    }

    public int getMax() {
        return max;
    }

}


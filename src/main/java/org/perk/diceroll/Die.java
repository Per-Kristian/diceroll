package org.perk.diceroll;

import java.util.Random;

import static java.util.Objects.requireNonNull;

public class Die {

    private final Integer lowestValue;
    private final Integer highestValue;
    private final Random random;

    public Die(final Integer lowestValue, final Integer highestValue, final Random random) {
        requireNonNull(lowestValue);
        requireNonNull(highestValue);
        requireNonNull(random);

        this.lowestValue = lowestValue;
        this.highestValue = highestValue;
        this.random = random;
    }

    public static Builder builder() {
        return new Builder();
    }

    public Integer roll() {
        return random.nextInt(highestValue) + 1;
    }

    public Integer getLowestValue() {
        return lowestValue;
    }

    public Integer getHighestValue() {
        return highestValue;
    }

    public static class Builder {
        private Integer lowestValue = 1;
        private Integer highestValue = 6;
        private Random random = new Random();

        public Builder setLowestValue(final Integer lowestValue) {
            this.lowestValue = requireNonNull(lowestValue);
            return this;
        }

        public Builder setHighestValue(final Integer dots) {
            this.highestValue = requireNonNull(dots);
            return this;
        }

        public Builder setRandom(final Random random) {
            this.random = requireNonNull(random);
            return this;
        }

        public Die build() {
            return new Die(lowestValue, highestValue, random);
        }
    }

}


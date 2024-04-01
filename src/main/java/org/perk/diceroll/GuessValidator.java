package org.perk.diceroll;

import static java.util.Objects.requireNonNull;

public class GuessValidator {

    public static void validate(final String guess, Die die) {
        requireNonNull(guess);
        requireNonNull(die);

        validate(Integer.parseInt(guess), die);
    }

    public static void validate(final Integer guess, final Die die) {
        requireNonNull(guess);
        requireNonNull(die);

        final var min = die.getLowestValue();
        final var max = die.getHighestValue();
        if (guess < die.getLowestValue() || guess > die.getHighestValue()) {
            throw new IllegalArgumentException(STR."Invalid value (\{guess}) should be between \{min} and \{max}.");
        }
    }
}

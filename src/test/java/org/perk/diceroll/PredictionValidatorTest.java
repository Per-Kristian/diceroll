package org.perk.diceroll;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

class PredictionValidatorTest {

    private static Die die;

    @BeforeAll
    public static void setup() {
        die = Die.builder()
                .setLowestValue(1)
                .setHighestValue(6)
                .build();
    }

    @Test
    void throwsExceptionWhenPredictionBelowMinimum() {
        assertThrows(IllegalArgumentException.class, () -> GuessValidator.validate(0, Die.builder().build())
        );
    }

    @Test
    void throwsExceptionWhenPredictionAboveMaximum() {
        assertThrows(IllegalArgumentException.class, () -> GuessValidator.validate(die.getHighestValue() + 1, die));
    }

    @Test
    void validatesPredictionBetweenMinAndMax() {
        GuessValidator.validate("3", die);
    }
}
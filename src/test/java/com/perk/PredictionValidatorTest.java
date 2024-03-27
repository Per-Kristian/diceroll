package com.perk;

import org.junit.jupiter.api.Test;

import static com.perk.PredictionValidator.MAX;
import static com.perk.PredictionValidator.MIN;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class PredictionValidatorTest {

    @Test
    void throwsExceptionWhenPredictionBelowMinimum() {
        assertThrows(UnsupportedOperationException.class, () -> PredictionValidator.validate(MIN - 1)
        );
    }

    @Test
    void throwsExceptionWhenPredictionAboveMaximum() {
        assertThrows(UnsupportedOperationException.class, () -> PredictionValidator.validate(MAX + 1));
    }

    @Test
    void validatesPredictionBetweenMinAndMax() {
        assertEquals(3, PredictionValidator.validate("3"));
    }
}
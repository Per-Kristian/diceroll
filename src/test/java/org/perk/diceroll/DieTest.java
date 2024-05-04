package org.perk.diceroll;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class DieTest {

    @Test
    void validatesMaxAmount() {
        assertThrows(IllegalArgumentException.class, () -> new Die(0));
    }

    @Test
    void rollsBetweenMinAndMax() {
        final var die = new Die(2);
        int result = die.roll();
        assertTrue(result == 1 || result == 2);
    }
}
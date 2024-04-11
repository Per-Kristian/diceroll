package org.perk.diceroll;

import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class DieTest {

    @Test
    void validatesMinAndMax() {
        assertThrows(IllegalArgumentException.class, () -> new Die(7,6));
    }

    @Test
    void rollsBetweenMinAndMax() {
        final var die = new Die(1,1); // reduces the chance of false positives
        assertEquals(1, die.roll());
    }
}
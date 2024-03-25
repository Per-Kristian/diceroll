package com.perk;

import java.util.Objects;

import static java.util.Objects.*;

public class PredictionValidator {

    private static final Integer MIN = 1;
    private static final Integer MAX = 6;

    public static void validate(final String prediction) {
        requireNonNull(prediction);
        final var predictionInteger = Integer.parseInt(prediction);

        if (predictionInteger < MIN || predictionInteger > MAX) {
            //todo throw an exception
        }
    }
}

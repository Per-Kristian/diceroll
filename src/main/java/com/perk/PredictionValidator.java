package com.perk;

import static java.util.Objects.requireNonNull;

public class PredictionValidator {

    private static final Integer MIN = 1;
    private static final Integer MAX = 6;

    public static void validate(final String prediction) {
        requireNonNull(prediction);
        final var predictionInteger = Integer.parseInt(prediction);

        if (predictionInteger < MIN || predictionInteger > MAX) {
            //todo handle exceptions and prevent crash
            throw new UnsupportedOperationException("Prediction out of bounds. Valid inputs are %d through %d.".formatted(MIN, MAX));
        }
    }
}

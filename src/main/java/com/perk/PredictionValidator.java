package com.perk;

import static java.util.Objects.requireNonNull;

public class PredictionValidator {

    public static final Integer MIN = 1;
    public static final Integer MAX = 6;

    public static Integer validate(final String prediction) {
        requireNonNull(prediction);
        return validate(Integer.parseInt(prediction));
    }

    public static Integer validate(final Integer prediction) {
        requireNonNull(prediction);
        if (prediction < MIN || prediction > MAX) {
            throw new UnsupportedOperationException(STR."Invalid prediction. Your guess should be \{MIN} through \{MAX}.");
        }
        return prediction;
    }
}

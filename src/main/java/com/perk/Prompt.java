package com.perk;

import java.util.Objects;
import java.util.function.Function;

import static com.perk.PredictionValidator.*;
import static java.util.Objects.*;

public class Prompt {

    public Prompt(final String message) {
        requireNonNull(message);

        System.out.printf("%s: ", message);
        final var prediction = System.console().readLine();
        validate(prediction);
        // todo roll the die
    }
}

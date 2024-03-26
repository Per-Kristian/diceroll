package com.perk;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.perk.PredictionValidator.validate;

public class PredictionReader {

    private static final Logger LOGGER = LoggerFactory.getLogger(PredictionReader.class);

    public static void read() {
        var predictionValidated = false;

        do {
            System.out.print("Guess the die: ");
            final var prediction = System.console().readLine();
            try {
                validate(prediction);
                predictionValidated = true;
            } catch (UnsupportedOperationException e) {
                System.out.println(e.getMessage() + " Please try again.");
            }
        } while (!predictionValidated);

        LOGGER.info("Prediction read");
        // todo roll the die
    }
}

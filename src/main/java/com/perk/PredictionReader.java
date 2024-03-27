package com.perk;

import java.time.Duration;

import static com.perk.PredictionValidator.validate;
import static java.lang.System.console;
import static java.lang.System.out;
import static java.lang.Thread.sleep;

public class PredictionReader {

    public Integer read() throws InterruptedException {
        while (true) {
            out.print("Guess the die: ");
            final var prediction = console().readLine();
            try {
                return validate(prediction);
            } catch (UnsupportedOperationException | NumberFormatException e) {
                printError(e);
            }
        }
    }

    private static void printError(final RuntimeException e) throws InterruptedException {
        out.println(e.getMessage());
        sleep(Duration.ofSeconds(2));
        out.println("Please try again.");
        sleep(Duration.ofSeconds(1));
    }
}

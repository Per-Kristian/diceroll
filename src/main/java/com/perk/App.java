package com.perk;

import java.time.Duration;

import static java.lang.System.out;
import static java.lang.Thread.sleep;

public class App {

    public static void main(String[] args) throws InterruptedException {
        final var prediction = new PredictionReader().read();
        final var result = roll(new Die());
        printResult(prediction, result);
    }

    private static Integer roll(final Die die) throws InterruptedException {
        out.println("Rolling the die...");
        sleep(Duration.ofSeconds(2));
        return die.roll();
    }

    private static void printResult(final Integer prediction, final Integer result) throws InterruptedException {
        if (prediction.equals(result)) {
            out.println(STR."You rolled \{result}, congrats! Thanks for playing :)");
        } else {
            out.println(STR."You rolled \{result}, unlucky. Better luck next time.");
        }
        sleep(Duration.ofSeconds(2));
    }
}

package org.perk.diceroll;

import java.time.Duration;

import static java.lang.Thread.sleep;
import static java.util.Objects.requireNonNull;

public class DiceRoll {

    final Die die;
    final PlayerInteraction io;

    public DiceRoll(final Die die) {
        this(requireNonNull(die), new PlayerInteraction());
    }

    public DiceRoll(final Die die, final PlayerInteraction io) {
        this.die = requireNonNull(die);
        this.io = requireNonNull(io);
    }

    public static void main(String[] args) {
        final var die = Die.builder().build();
        final var game = new DiceRoll(die);
        game.start();
    }

    public void start() {
        final var prediction = getPrediction();
        final var result = roll();
        showResult(prediction, result);
    }

    private Integer getPrediction() {
        final var io = new PlayerInteraction();
        while (true) {
            try {
                final var prediction = io.requireInteger("Guess the die: ");
                GuessValidator.validate(prediction, die);
                return prediction;
            } catch (final IllegalArgumentException e) {
                io.writeLine(STR."Invalid guess. It should be a number between \{die.getLowestValue()} and \{die.getHighestValue()}.");
                wait(Duration.ofSeconds(1));
            }
        }
    }

    private Integer roll() {
        final var io = new PlayerInteraction();
        io.writeLine("Rolling the die...");
        wait(Duration.ofSeconds(2));
        return die.roll();
    }

    private void showResult(final Integer prediction, final Integer result) {
        if (prediction.equals(result)) {
            new PlayerInteraction().writeLine(STR."You rolled \{result}, congrats! Thanks for playing :)");
        } else {
            new PlayerInteraction().writeLine(STR."You rolled \{result}, unlucky. Better luck next time.");
        }

        try {
            sleep(Duration.ofSeconds(2));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private void wait(final Duration duration) {
        try {
            sleep(duration);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}

package org.perk.diceroll;

import java.time.Duration;

import static java.util.Objects.requireNonNull;

public class DiceRoll {

    private final Die die;
    private final UserInterface ui;

    public static void main(final String[] args) {
        final var die = Die.withMaxDots(6);
        final var game = new DiceRoll(die);
        game.start();
    }

    public DiceRoll(final Die die) {
        this(requireNonNull(die), new UserInterface());
    }

    public DiceRoll(final Die die, final UserInterface ui) {
        this.die = requireNonNull(die);
        this.ui = requireNonNull(ui);
    }

    public void start() {
        do {
            final var prediction = ui.requireInteger("Guess the die: ", die.getMin(), die.getMax());

            ui.writeLine("Rolling the die...");
            ui.sleep(Duration.ofSeconds(2));
            final var result = die.roll();

            if (prediction != result) {
                ui.writeLine(STR."You rolled \{result}, unlucky. Better luck next time.");
            } else {
                ui.writeLine(STR."You rolled \{result}, congrats!");
            }
            ui.sleep(Duration.ofSeconds(2));
        } while (ui.requireString("Play again? Y/N: ").equalsIgnoreCase("Y"));
    }

}

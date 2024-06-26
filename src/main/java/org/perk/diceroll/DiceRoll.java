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
            ui.write("Guess the die: ");
            final var prediction = ui.requireInteger(1, die.getMax());

            ui.writeLine("Rolling the die...");
            ui.sleep(Duration.ofSeconds(2));
            final var result = die.roll();

            if (prediction != result) {
                ui.writeLine("The die shows %d, unlucky. Better luck next time.".formatted(result));
            } else {
                ui.writeLine("The die shows %d, congrats!".formatted(result));
            }
            ui.sleep(Duration.ofSeconds(2));
        } while (ui.requireString("Play again? Y/N: ").equalsIgnoreCase("Y"));
    }

}

package org.perk.diceroll;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.function.BiFunction;
import java.util.function.Function;

import static java.util.Objects.requireNonNull;

public class PlayerInteraction {

    private final Scanner reader;
    private final PrintWriter writer;

    public PlayerInteraction() {
        this(System.in, System.out);
    }

    public PlayerInteraction(final InputStream inputStream, final OutputStream outputStream) {
        this.reader = new Scanner(requireNonNull(inputStream));
        this.writer = new PrintWriter(requireNonNull(outputStream), true);
    }

    public void write(final String message) {
        writer.print(message);
        writer.flush();
    }

    public void writeLine(final String message) {
        writer.println(requireNonNull(message));
    }

    public Integer requireInteger(final String prompt) {
        write(requireNonNull(prompt));
        while (true) {
            final var input = reader.nextLine();
            try {
                return Integer.parseInt(input);
            } catch (final NumberFormatException e) {
                writer.println("The number must be be a whole number. Please try again.");
            }
        }
    }

    public <T> T requireInput(final String prompt, final Function<String, T> parser, final BiFunction<Exception, String, String> exceptionHandler) {
        requireNonNull(prompt);
        requireNonNull(parser);
        requireNonNull(exceptionHandler);

        writeLine(prompt);
        while (true) {
            final var input = reader.nextLine();
            try {
                return parser.apply(input);
            } catch (final Exception e) {
                final var retryMessage = exceptionHandler.apply(e, input);
                writer.println(retryMessage);
            }
        }
    }

}

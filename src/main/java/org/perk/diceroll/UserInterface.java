package org.perk.diceroll;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.time.Duration;
import java.util.Scanner;

import static java.util.Objects.requireNonNull;

public class UserInterface {

    private final Scanner reader;
    private final PrintWriter writer;

    public UserInterface() {
        this(System.in, System.out);
    }

    public UserInterface(final InputStream inputStream, final OutputStream outputStream) {
        this.reader = new Scanner(requireNonNull(inputStream));
        this.writer = new PrintWriter(requireNonNull(outputStream), true);
    }

    public int requireInteger(final String prompt, final int min, final int max) {
        requireNonNull(prompt);
        while (true) {
            write(prompt);
            try {
                final var input = Integer.parseInt(reader.nextLine());
                if (input >= min && input <= max) {
                    return input;
                }
                writer.println(STR."The number must be between \{min} and \{max}");
            } catch (final NumberFormatException e) {
                writer.println("The number must be be a whole number. Please try again.");
            }
        }
    }

    public void write(final String message) {
        requireNonNull(message);
        writer.print(message);
        writer.flush();
    }

    public void writeLine(final String message) {
        requireNonNull(message);
        writer.println(message);
    }

    public String requireString(final String prompt) {
        requireNonNull(prompt);
        write(prompt);
        return reader.nextLine();
    }

    /**
     * Causes the UI thread to sleep for the given {@param duration}.
     * If the sleep is interrupted, this method throws a {@link UserInterfaceException}.
     * @param duration The sleep duration
     */
    public void sleep(final Duration duration) {
        requireNonNull(duration);
        try {
            Thread.sleep(duration);
        } catch (final InterruptedException e) {
            throw new UserInterfaceException("sleep was interrupted", e);
        }
    }

}

package org.perk.diceroll;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.time.Duration;
import java.util.Scanner;

import static java.util.Objects.requireNonNull;

public class UserInterface {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserInterface.class);

    private final Scanner reader;
    private final PrintWriter writer;

    public UserInterface() {
        this(System.in, System.out);
    }

    public UserInterface(final InputStream inputStream, final OutputStream outputStream) {
        this.reader = new Scanner(requireNonNull(inputStream));
        this.writer = new PrintWriter(requireNonNull(outputStream), true);
    }

    public int requireInteger(final int min, final int max) {
        while (true) {
            try {
                final var input = Integer.parseInt(reader.nextLine());
                if (input >= min && input <= max) {
                    return input;
                }
                writer.println("The number must be between %d and %d.".formatted(min, max));
            } catch (final NumberFormatException e) {
                writer.println("The number must be be a whole number.");
            }
            sleep(Duration.ofSeconds(1));
            writer.print("Please try again: ");
            writer.flush();
        }
    }

    public String requireString(final String prompt) {
        requireNonNull(prompt);
        write(prompt);
        return reader.nextLine();
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

    public void sleep(final Duration duration) {
        requireNonNull(duration);
        try {
            Thread.sleep(duration);
        } catch (final InterruptedException e) {
            LOGGER.error("Sleep was interrupted", e);
        }
    }

}

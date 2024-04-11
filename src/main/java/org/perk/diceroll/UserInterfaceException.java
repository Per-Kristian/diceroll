package org.perk.diceroll;

import static java.util.Objects.requireNonNull;

public class UserInterfaceException extends RuntimeException {

    public UserInterfaceException(final String message, final Throwable e) {
        super(requireNonNull(message), requireNonNull(e));
    }

}

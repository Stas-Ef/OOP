package org.skypro.skyshop.Exception;

import java.io.IOException;

public class NameIsBlankException extends IOException {

    public NameIsBlankException() {
        super();
    }

    public NameIsBlankException(String message) {
        super(message);
    }

    public NameIsBlankException(String message, Throwable t) {
        super(message, t);
    }

    public NameIsBlankException(Throwable t) {
        super(t);
    }
}


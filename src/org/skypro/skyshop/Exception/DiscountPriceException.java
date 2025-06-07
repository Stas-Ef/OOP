package org.skypro.skyshop.Exception;

import java.io.IOException;

public class DiscountPriceException extends IOException {
    public DiscountPriceException() {
        super();
    }

    public DiscountPriceException(String message) {
        super(message);
    }

    public DiscountPriceException(String message, Throwable t) {
        super(message, t);
    }

    public DiscountPriceException(Throwable t) {
        super(t);
    }
}

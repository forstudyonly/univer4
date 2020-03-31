package com.training.martynenka.staticHelp;

import java.math.BigDecimal;

public final class ValidationService {

    private ValidationService() {

    }

    public static void checkStringNull(String someString) {
        if (someString == null) {
            throw new IllegalArgumentException("The string cannot be null");
        }
    }

    public static void checkNegative(BigDecimal number) {
        if (number.compareTo(BigDecimal.ZERO) < 1) {
            throw new IllegalArgumentException("Amount can’t be null, negative or zero");
        }
    }

    public static void checkNull(BigDecimal number) {
        if (number == null) {
            throw new IllegalArgumentException("Amount can’t be null, negative or zero");
        }
    }
}

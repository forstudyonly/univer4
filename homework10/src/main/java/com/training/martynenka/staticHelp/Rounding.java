package com.training.martynenka.staticHelp;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Rounding {
    private Rounding() {

    }

    public static BigDecimal roundTheNumber(BigDecimal number) {
        return roundTheNumber(number, 2);
    }

    public static BigDecimal roundTheNumber(BigDecimal number, int rounding) {
        return number.setScale(rounding, RoundingMode.HALF_UP);
    }
}

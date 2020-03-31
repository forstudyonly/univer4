package com.training.martynenka;

import java.math.BigDecimal;
import java.math.RoundingMode;

public final class ValidationService {

    private ValidationService() {

    }

    public static void checkStringNull(String someString)  {
        if (someString == null) {
            throw new IllegalArgumentException("The string cannot be null");
        }
    }

    public static void checkNegative(BigDecimal number)  {
        if (number.compareTo(BigDecimal.ZERO) < 1) {
            throw new IllegalArgumentException("Amount can’t be null, negative or zero");
        }
    }

    public static void checkNull(BigDecimal number)  {
        if (number == null) {
            throw new IllegalArgumentException("Amount can’t be null, negative or zero");
        }
    }

    public static void checkBalanceLessThenWithdrawal(BigDecimal cardBalance, BigDecimal amount) {
        if (cardBalance.compareTo(amount) < 0) {
            throw new IllegalArgumentException("Insufficient funds");
        }
    }

    public static BigDecimal roundTheNumber(BigDecimal number) {
        return roundTheNumber(number, 2);
    }

    public static BigDecimal roundTheNumber(BigDecimal number, int rounding) {
        return number.setScale(rounding, RoundingMode.HALF_UP);
    }
}

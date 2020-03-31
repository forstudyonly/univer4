package com.training.martynenka.currencyConverter;

import java.math.BigDecimal;
import java.math.RoundingMode;

public final class CurrencyConverter {
    private static final BigDecimal DOLLAR_RATE = new BigDecimal(2.051);
    private static final BigDecimal EURO_RATE = new BigDecimal(2.26);
    private static final BigDecimal RUSSIAN_RUBLE_RATE = new BigDecimal(3.186 / 100);

    public BigDecimal getBalanceInDollars(BigDecimal cardBalance) {
        return getCardBalanceInAnotherCurrency(cardBalance, DOLLAR_RATE);
    }

    public BigDecimal getBalanceInEuro(BigDecimal cardBalance) {
        return getCardBalanceInAnotherCurrency(cardBalance, EURO_RATE);
    }

    public BigDecimal getBalanceInRussianRuble(BigDecimal cardBalance) {
        return getCardBalanceInAnotherCurrency(cardBalance, RUSSIAN_RUBLE_RATE);
    }

    public BigDecimal getCardBalanceInAnotherCurrency(BigDecimal cardBalance, BigDecimal rate) {
        return cardBalance.divide(rate, RoundingMode.HALF_UP);
    }
}

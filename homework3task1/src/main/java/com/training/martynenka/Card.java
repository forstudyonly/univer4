package com.training.martynenka;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Card {
    private String nameOfCardHolder;
    private BigDecimal cardBalance;

    public Card(String nameOfCardHolder) {
        if (isStringEmpty(nameOfCardHolder)) {
            throw new IllegalArgumentException("The name cannot be an empty string");
        }
        this.nameOfCardHolder = nameOfCardHolder;
    }

    public Card(String nameOfCardHolder, BigDecimal cardBalance) {
        this(nameOfCardHolder);
        if (isNegativeOrNull(cardBalance)) {
            throw new IllegalArgumentException("Account Balance can’t be null, negative or zero");
        } else {
            this.cardBalance = roundTheNumber(cardBalance);
        }
    }

    public BigDecimal getBalance() {
        return cardBalance;
    }

    public void addToBalance(BigDecimal adding) {
        if (isNegativeOrNull(adding)) {
            throw new IllegalArgumentException("You can not deposit null, negative or zero");
        } else {
            adding = roundTheNumber(adding);
            cardBalance = cardBalance.add(adding);
        }
    }

    public void withdrawalFromBalance(BigDecimal withdrawal) {
        if (isNegativeOrNull(withdrawal) || isBalanceLessThenWithdrawal(withdrawal)) {
            throw new IllegalArgumentException("Enter the correct data");
        } else {
            withdrawal = roundTheNumber(withdrawal);
            cardBalance = cardBalance.subtract(withdrawal);
        }
    }

    public BigDecimal getBalanceInAnotherCurrency(BigDecimal rates, int rounding) {
        if (isNegativeOrNull(rates)) {
            throw new IllegalArgumentException("Cannot be converted to another currency");
        } else {
            return roundTheNumber(cardBalance.multiply(rates), rounding);
        }
    }

    private BigDecimal roundTheNumber(BigDecimal number) {
        return roundTheNumber(number, 2);
    }

    private BigDecimal roundTheNumber(BigDecimal number, int rounding) {
        return number.setScale(rounding, RoundingMode.HALF_UP);
    }

    private boolean isStringEmpty(String someString) {
        return someString == null;
    }

    private boolean isNegativeOrNull(BigDecimal number) {
        return (number == null || number.compareTo(BigDecimal.ZERO) < 1);
    }

    private boolean isBalanceLessThenWithdrawal(BigDecimal withdrawal) {
        return cardBalance.compareTo(withdrawal) < 0;
    }
}

package com.training.martynenka;

import java.math.BigDecimal;


public abstract class Card {
    private String nameOfCardHolder;
    private BigDecimal cardBalance;
    CurrencyConverter currencyConverter;

    public Card(String nameOfCardHolder, CurrencyConverter currencyConverter) {
        ValidationService.checkStringNull(nameOfCardHolder);
        this.nameOfCardHolder = nameOfCardHolder;
        cardBalance = new BigDecimal(0);
        this.currencyConverter = currencyConverter;
    }

    public Card(String nameOfCardHolder, BigDecimal cardBalance, CurrencyConverter currencyConverter) {
        this(nameOfCardHolder, currencyConverter);
        ValidationService.checkNegative(cardBalance);
        ValidationService.checkNull(cardBalance);
        this.cardBalance = ValidationService.roundTheNumber(cardBalance);
    }

    public BigDecimal getBalance() {
        return cardBalance;
    }

    public void setBalance(BigDecimal balance) {
        cardBalance = ValidationService.roundTheNumber(balance);
    }

    public boolean addToBalance(BigDecimal amount) {
        ValidationService.checkNull(amount);
        ValidationService.checkNegative(amount);
        amount = ValidationService.roundTheNumber(amount);
        cardBalance = cardBalance.add(amount);
        return true;
    }

    public abstract void withdrawFromBalance(BigDecimal amount);

    public BigDecimal getCardBalanceInDollars() {
        return currencyConverter.getBalanceInDollars(cardBalance);
    }

    public BigDecimal getCardBalanceInEuro() {
        return currencyConverter.getBalanceInEuro(cardBalance);
    }

    public BigDecimal getCardBalanceInRussianRuble() {
        return currencyConverter.getBalanceInRussianRuble(cardBalance);
    }
}

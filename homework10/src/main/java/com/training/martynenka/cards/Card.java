package com.training.martynenka.cards;

import com.training.antonov.currencyConverter.CurrencyConverter;
import com.training.antonov.staticHelp.Rounding;
import com.training.antonov.staticHelp.ValidationService;

import java.math.BigDecimal;


public abstract class Card {
    private String nameOfCardHolder;
    private BigDecimal cardBalance;
    private CurrencyConverter currencyConverter;

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
        this.cardBalance = Rounding.roundTheNumber(cardBalance);
    }

    public BigDecimal getBalance() {
        return cardBalance;
    }

    public void setBalance(BigDecimal balance) {
        cardBalance = Rounding.roundTheNumber(balance);
    }

    public void addToBalance(BigDecimal amount) {
        ValidationService.checkNull(amount);
        ValidationService.checkNegative(amount);
        amount = Rounding.roundTheNumber(amount);
        cardBalance = cardBalance.add(amount);
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

    @Override
    public String toString() {
        return nameOfCardHolder + " current balance " + String.format("|%7s|", cardBalance);
    }
}

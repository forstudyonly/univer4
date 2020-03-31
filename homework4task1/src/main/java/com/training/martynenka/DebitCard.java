package com.training.martynenka;

import java.math.BigDecimal;


public class DebitCard extends Card {
    public DebitCard(String nameOfCardHolder, CurrencyConverter currencyConverter) {
        super(nameOfCardHolder, currencyConverter);
    }

    public DebitCard(String nameOfCardHolder, BigDecimal cardBalance, CurrencyConverter currencyConverter) {
        super(nameOfCardHolder, cardBalance, currencyConverter);
    }

    @Override
    public void withdrawFromBalance(BigDecimal amount) {
        ValidationService.checkNull(amount);
        ValidationService.checkNegative(amount);
        ValidationService.checkBalanceLessThenWithdrawal(this.getBalance(), amount);
        setBalance(getBalance().subtract(amount));
    }
}

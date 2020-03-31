package com.training.martynenka;

import java.awt.geom.Area;
import java.math.BigDecimal;

public class CreditCard extends Card {
    public CreditCard(String nameOfCardHolder, CurrencyConverter currencyConverter) {
        super(nameOfCardHolder, currencyConverter);
    }

    public CreditCard(String nameOfCardHolder, BigDecimal cardBalance, CurrencyConverter currencyConverter) {
        super(nameOfCardHolder, cardBalance, currencyConverter);
    }

    @Override
    public void withdrawFromBalance(BigDecimal amount) {
        ValidationService.checkNull(amount);
        ValidationService.checkNegative(amount);
        setBalance(getBalance().subtract(amount));
    }

}

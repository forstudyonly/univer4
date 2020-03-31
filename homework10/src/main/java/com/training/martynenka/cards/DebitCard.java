package com.training.martynenka.cards;

import com.training.antonov.currencyConverter.CurrencyConverter;
import com.training.antonov.staticHelp.Rounding;
import com.training.antonov.staticHelp.ValidationService;

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
        setBalance(getBalance().subtract(amount));
        amount = Rounding.roundTheNumber(amount);
    }
}

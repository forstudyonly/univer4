package com.training.martynenka;

import java.math.BigDecimal;


public class Atm {
    private BigDecimal money;

    public Atm(BigDecimal money) {
        ValidationService.checkNull(money);
        ValidationService.checkNegative(money);
        this.money = ValidationService.roundTheNumber(money);
    }

    public void withdrawFromCard(Card card, BigDecimal amount) {
        ValidationService.checkNull(amount);
        ValidationService.checkBalanceLessThenWithdrawal(money, amount);
        card.withdrawFromBalance(amount);
        money = money.subtract(ValidationService.roundTheNumber(amount));
    }

    public boolean addToCardBalance(Card card, BigDecimal amount) {
        card.addToBalance(amount);
        money = money.add(ValidationService.roundTheNumber(amount));
        return true;
    }

    public BigDecimal getCardBalance(Card card) {
        return card.getBalance();
    }

    public BigDecimal getCardBalanceInDollars(Card card) {
        return card.getCardBalanceInDollars();
    }

    public BigDecimal getCardBalanceInEuro(Card card) {
        return card.getCardBalanceInEuro();
    }

    public BigDecimal getCardBalanceInRussianRuble(Card card) {
        return card.getCardBalanceInRussianRuble();
    }

    public void bringMoney(BigDecimal amount) {
        ValidationService.checkNull(amount);
        ValidationService.checkNegative(amount);
        money = money.add(ValidationService.roundTheNumber(amount));
    }

    public BigDecimal getCountOfMoney() {
        return money;
    }
}

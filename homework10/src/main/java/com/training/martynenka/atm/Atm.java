package com.training.martynenka.atm;

import java.math.BigDecimal;

import com.training.antonov.cards.Card;
import com.training.antonov.staticHelp.BalanceCheck;
import com.training.antonov.staticHelp.Rounding;
import com.training.antonov.staticHelp.ValidationService;


public class Atm {
    private BigDecimal money;

    public Atm(BigDecimal money) {
        ValidationService.checkNull(money);
        ValidationService.checkNegative(money);
        this.money = Rounding.roundTheNumber(money);
    }

    public boolean withdrawFromCard(Card card, BigDecimal amount) {
        ValidationService.checkNull(amount);
        if (BalanceCheck.checkBalanceLessThenWithdrawal(card.getBalance(), amount)
                && BalanceCheck.checkBalanceLessThenWithdrawal(money, amount)) {
            card.withdrawFromBalance(amount);
            money = money.subtract(Rounding.roundTheNumber(amount));
            return !BalanceCheck.isBalanceLessOrEqual0(card.getBalance());
        }
        return false;
    }

    public boolean addToCard(Card card, BigDecimal amount) {
        if (BalanceCheck.isBalanceWillLessOrEqual1000(card.getBalance(), amount)) {
            card.addToBalance(amount);
            money = money.add(Rounding.roundTheNumber(amount));
            return true;
        }
        return false;
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
        money = money.add(Rounding.roundTheNumber(amount));
    }

    public BigDecimal getCountOfMoney() {
        return money;
    }
}

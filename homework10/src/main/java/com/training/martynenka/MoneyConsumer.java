package com.training.martynenka;

import java.math.BigDecimal;

import com.training.antonov.atm.Atm;
import com.training.antonov.cards.Card;
import com.training.antonov.staticHelp.BalanceCheck;

public class MoneyConsumer extends Atm implements Runnable {
    private final int PAUSE_MS = 100;
    private final BigDecimal TWENTY = new BigDecimal(20);
    private Card card;

    public MoneyConsumer(BigDecimal money, Card card) {
        super(money);
        this.card = card;
    }

    @Override
    public void run() {
        while (Main.isAtmThreadsWork) {
            makePause();
            synchronized (card) {
                if (BalanceCheck.checkBalanceLessThenWithdrawal(getCountOfMoney(), TWENTY)) {
                    Main.isAtmThreadsWork = withdraw();
                }
            }
        }
    }

    private void makePause() {
        try {
            Thread.sleep(PAUSE_MS);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }

    private boolean withdraw() {
        if (withdrawFromCard(card, TWENTY)) {
            System.out.println("Withdrawal " + TWENTY + " " + card + " " + Thread.currentThread().getName());
            return true;
        }
        return false;
    }
}

package com.training.martynenka;

import java.math.BigDecimal;

import com.training.antonov.atm.Atm;
import com.training.antonov.cards.Card;

public class MoneyProducer extends Atm implements Runnable {
    private final int PAUSE_MS = 100;
    private final BigDecimal TWENTY = new BigDecimal(20);
    private Card card;

    public MoneyProducer(BigDecimal money, Card card) {
        super(money);
        this.card = card;
    }

    @Override
    public void run() {
        while (Main.isAtmThreadsWork) {
            makePause();
            synchronized (card) {
                if (addToCard(card, TWENTY)) {
                    System.out.println("    Adding " + TWENTY + " " + card + " " + Thread.currentThread().getName());
                } else {
                    Main.isAtmThreadsWork = false;
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
}


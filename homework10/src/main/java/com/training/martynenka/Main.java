package com.training.martynenka;

import java.math.BigDecimal;
import java.util.ArrayList;

import com.training.antonov.cards.DebitCard;
import com.training.antonov.currencyConverter.CurrencyConverter;

public class Main {
    public static boolean isAtmThreadsWork = true;

    private static final BigDecimal MILLION = new BigDecimal(1000000);
    private static final int THREE = 3;

    public static void main(String[] args) {
        DebitCard card = new DebitCard("Карта", new BigDecimal(500), new CurrencyConverter());
        ArrayList<MoneyConsumer> moneyConsumer = new ArrayList<MoneyConsumer>();
        ArrayList<MoneyProducer> moneyProducer = new ArrayList<MoneyProducer>();
        ArrayList<Thread> withdrawal = new ArrayList<Thread>();
        ArrayList<Thread> additions = new ArrayList<Thread>();
        for (int i = 0; i < THREE; i++) {
            moneyConsumer.add(new MoneyConsumer(MILLION, card));
            moneyProducer.add(new MoneyProducer(MILLION, card));
        }
        for (int i = 0; i < THREE; i++) {
            withdrawal.add(new Thread(moneyConsumer.get(i)));
            additions.add(new Thread(moneyProducer.get(i)));
        }
        for (int i = 0; i < THREE; i++) {
            withdrawal.get(i).start();
            additions.get(i).start();
        }
    }
}

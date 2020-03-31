package com.training.martynenka;

import org.junit.Test;
import org.junit.Assert;

import java.math.BigDecimal;

public class CardTest {
    private final String NAME = "Леша";
    private final BigDecimal BALANCE = new BigDecimal(150);

    @Test
    public void testCreateCard() {
        Card card1 = new Card(NAME, BALANCE);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testWrongNameCreateCard() {
        Card card1 = new Card(null, BALANCE);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testWrongBalanceCreateCard() {
        Card card1 = new Card(NAME, new BigDecimal(-3));
    }

    @Test
    public void testGetBalance() {
        Card card1 = new Card(NAME, BALANCE);
        Assert.assertEquals(0, card1.getBalance().compareTo(new BigDecimal(150)));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddNegativeToBalance() {
        Card card1 = new Card(NAME, BALANCE);
        card1.addToBalance(new BigDecimal(-5));
    }

    @Test
    public void testAddPositiveToBalance() {
        Card card1 = new Card(NAME, BALANCE);
        card1.addToBalance(new BigDecimal(5));
        Assert.assertEquals(155, card1.getBalance().doubleValue(), 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testWithdrawalNegativeFromBalance() {
        Card card1 = new Card(NAME, BALANCE);
        card1.withdrawalFromBalance(new BigDecimal(-5));
    }

    @Test
    public void testWithdrawalPositiveFromBalance() {
        Card card1 = new Card(NAME, BALANCE);
        card1.withdrawalFromBalance(new BigDecimal(5.454));
        Assert.assertEquals(144.55, card1.getBalance().doubleValue(), 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testWithdrawalNullFromBalance() {
        Card card1 = new Card(NAME, BALANCE);
        card1.withdrawalFromBalance(null);
        Assert.assertEquals(145, card1.getBalance().doubleValue(), 0);
    }

    @Test
    public void testGetBalanceInAnotherCurrency() {
        Card card1 = new Card(NAME, BALANCE);
        BigDecimal currency = card1.getBalanceInAnotherCurrency(new BigDecimal(0.48), 2);
        Assert.assertEquals(72, currency.doubleValue(), 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetBalanceInAnotherNegativeCurrency() {
        Card card1 = new Card(NAME, BALANCE);
        BigDecimal currency = card1.getBalanceInAnotherCurrency(new BigDecimal(-2), 2);
        Assert.assertEquals(0, currency.doubleValue(), 0);
    }
}
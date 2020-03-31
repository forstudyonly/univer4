package com.training.martynenka;

import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;

import java.math.BigDecimal;

public class AtmTest {
    private CreditCard creditCard;
    private DebitCard debitCard;
    private Atm ATM;
    private final String NAME = "Vova";;
    private final BigDecimal PLUS_FIVE = new BigDecimal(5);;
    private final BigDecimal PLUS_TEN = new BigDecimal(10);;
    private final BigDecimal PLUS_FIFTEEN = new BigDecimal(15);;
    private final BigDecimal PLUS_TWENTY = new BigDecimal(20);;
    private final BigDecimal MINUS_FIVE = new BigDecimal(-5);;
    private final BigDecimal MINUS_TEN = new BigDecimal(-10);;

    @Before
    public void init() {
        creditCard = new CreditCard(NAME, PLUS_FIFTEEN, new CurrencyConverter());
        debitCard = new DebitCard(NAME, PLUS_FIFTEEN, new CurrencyConverter());
        ATM = new Atm(PLUS_TEN);
    }

    @Test
    public void testWithdrawalNormFromAtm() {
        ATM.withdrawFromCard(debitCard, PLUS_FIVE);
        Assert.assertEquals(0, debitCard.getBalance().compareTo(PLUS_TEN));
        Assert.assertEquals(0, ATM.getCountOfMoney().compareTo(PLUS_FIVE));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testWithdrawalMoreFromAtm() {
        ATM.withdrawFromCard(debitCard, PLUS_TWENTY);
    }

    @Test
    public void testWithdrawalMoreFromAtmCreditCard() {
        ATM.bringMoney(new BigDecimal(20));
        ATM.withdrawFromCard(creditCard, new BigDecimal(20));
        Assert.assertEquals(0, creditCard.getBalance().compareTo(MINUS_FIVE));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testWithdrawalNullFromAtm() {
        ATM.withdrawFromCard(creditCard, null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testWithdrawalNegativeFromAtm() {
        ATM.withdrawFromCard(debitCard, MINUS_TEN);
    }

    @Test
    public void testAddNormToCardBalance() {
        Assert.assertEquals(true, ATM.addToCardBalance(debitCard, PLUS_FIVE));
        Assert.assertEquals(0, debitCard.getBalance().compareTo(PLUS_TWENTY));
        Assert.assertEquals(0, ATM.getCountOfMoney().compareTo(PLUS_FIFTEEN));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddNegativeToCardBalance() {
        ATM.addToCardBalance(creditCard, MINUS_TEN);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddNullToCardBalance() {
        ATM.addToCardBalance(debitCard, null);
    }

    @Test
    public void testGetCardBalance() {
        Assert.assertEquals(0, ATM.getCardBalance(creditCard).compareTo(PLUS_FIFTEEN));
    }

    @Test
    public void testGetCardBalanceInDollars() {
        Assert.assertEquals(0, ATM.getCardBalanceInDollars(debitCard).compareTo(new BigDecimal("7.31")));
    }

    @Test
    public void testGetCardBalanceInEuros() {
        Assert.assertEquals(0, ATM.getCardBalanceInEuro(debitCard).compareTo(new BigDecimal("6.64")));
    }

    @Test
    public void testGetCardBalanceInRussianRubles() {
        Assert.assertEquals(0, ATM.getCardBalanceInRussianRuble(debitCard).compareTo(new BigDecimal("470.81")));
    }

    @Test
    public void testBringMoney() {
        ATM.bringMoney(PLUS_TEN);
        Assert.assertEquals(0, ATM.getCountOfMoney().compareTo(PLUS_TWENTY));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testBringNegativeMoney() {
        ATM.bringMoney(MINUS_TEN);
    }
}
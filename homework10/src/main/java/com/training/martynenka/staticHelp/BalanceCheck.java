package com.training.martynenka.staticHelp;

import java.math.BigDecimal;

public class BalanceCheck {
    private BalanceCheck() {

    }

    public static boolean checkBalanceLessThenWithdrawal(BigDecimal balance, BigDecimal amount) {
        return balance.compareTo(amount) >= 0;
    }

    public static boolean isBalanceWillLessOrEqual1000(BigDecimal balance, BigDecimal replenishmentAmount) {
        return balance.add(replenishmentAmount).compareTo(new BigDecimal("1000")) <= 0;
    }

    public static boolean isBalanceLessOrEqual0(BigDecimal balance) {
        return balance.compareTo(new BigDecimal("0")) <= 0;
    }

    public static boolean isBalanceMoreOrEqual1000(BigDecimal balance) {
        return balance.compareTo(new BigDecimal("1000")) >= 0;
    }
}

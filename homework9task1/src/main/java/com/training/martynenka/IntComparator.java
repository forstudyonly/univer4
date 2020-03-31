package com.training.martynenka;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class IntComparator<I extends Integer> implements Comparator<Integer> {
    @Override
    public int compare(Integer first, Integer second) {
        return calcSumOfDigits(first) - calcSumOfDigits(second);
    }

    private int calcSumOfDigits(int number) {
        int[] digits = divideByDigits(number);
        return calcSumOfDigits(digits);
    }

    private int calcSumOfDigits(int[] digits) {
        int sumOfDigits = 0;
        for (int digit : digits) {
            sumOfDigits += digit;
        }
        return sumOfDigits;
    }

    private int[] divideByDigits(Integer number) {
        List<String> stringDigits = divideByStringDigits(number >= 0 ? number : -number);
        int[] digits = new int[stringDigits.size()];
        for (int i = 0; i < stringDigits.size(); i++) {
            digits[i] = Integer.parseInt(stringDigits.get(i));
        }
        return digits;
    }

    private List<String> divideByStringDigits(Integer number) {
        return new LinkedList<String>(Arrays.asList(number.toString().split("")));
    }
}

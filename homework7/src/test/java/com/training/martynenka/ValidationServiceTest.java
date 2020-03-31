package com.training.martynenka;

import org.junit.Test;
import org.junit.Assert;

public class ValidationServiceTest {
    private final int INT_0 = 0;
    private final int INT_1 = 1;
    private final int INT_5 = 5;
    private final int INT_10 = 10;
    private final int INT_11 = 11;
    private final String STRING_WITH_FIRST_CAPITAL = "Text. text";
    private final String STRING_WITH_FIRST_CAPITAL_2 = "Text";
    private final String STRING_WITHOUT_FIRST_CAPITAL = "text. Text";
    private final String STRING_EMPTY = "";

    @Test
    public void validateTestIntNorm() throws ValidationFailedException {
        ValidationService.validate(INT_1);
        ValidationService.validate(INT_10);
        ValidationService.validate(INT_5);
    }

    @Test(expected = ValidationFailedException.class)
    public void validateTestIntBad() throws ValidationFailedException {
        ValidationService.validate(INT_11);
    }

    @Test(expected = ValidationFailedException.class)
    public void validateTestIntBad2() throws ValidationFailedException {
        ValidationService.validate(INT_0);
    }

    @Test
    public void validateTestStringNorm() throws ValidationFailedException {
        ValidationService.validate(STRING_WITH_FIRST_CAPITAL);
        ValidationService.validate(STRING_WITH_FIRST_CAPITAL_2);
    }

    @Test(expected = ValidationFailedException.class)
    public void validateTestStringBad() throws ValidationFailedException {
        ValidationService.validate(STRING_WITHOUT_FIRST_CAPITAL);
    }

    @Test(expected = ValidationFailedException.class)
    public void validateTestStringBad2() throws ValidationFailedException {
        ValidationService.validate(STRING_EMPTY);
    }
}
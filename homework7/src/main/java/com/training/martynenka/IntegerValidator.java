package com.training.martynenka;

public class IntegerValidator extends Validator<Integer> {
    private final int MIN = 1;
    private final int MAX = 10;
    private final String EXCEPTION_MESSAGE = "Value out of range [1-10]";

    public void validate(Integer value) throws ValidationFailedException {
        if (value > MAX || value < MIN) {
            throw new ValidationFailedException(EXCEPTION_MESSAGE);
        }
    }
}

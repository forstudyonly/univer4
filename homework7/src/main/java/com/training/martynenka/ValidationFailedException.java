package com.training.martynenka;

public class ValidationFailedException extends Throwable {
    public ValidationFailedException(final String message) {
        super(message);
    }
}

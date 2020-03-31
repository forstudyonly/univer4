package com.training.martynenka;

public abstract class Validator<T> {
    public abstract void validate(T value) throws ValidationFailedException;
}

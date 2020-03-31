package com.training.martynenka;

public class ValidatorFactory {
    public Validator getValidator(ValidationTypes type) {
        return type.getValidator();
    }
}

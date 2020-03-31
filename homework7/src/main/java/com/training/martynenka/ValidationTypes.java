package com.training.martynenka;

public enum ValidationTypes {
    INTEGER {
        Validator getValidator() {
            return new IntegerValidator();
        }
    },
    STRING {
        Validator getValidator() {
            return new StringValidator();
        }
    };

    abstract Validator getValidator();
}

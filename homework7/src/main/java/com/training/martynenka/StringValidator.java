package com.training.martynenka;

public class StringValidator extends Validator<String> {
    private String regexStartWithCapital = "[A-ZА-Я].*";

    public void validate(String value) throws ValidationFailedException {
        if (!value.matches(regexStartWithCapital)) {
            throw new ValidationFailedException("The string does not start with a capital letter");
        }
    }
}

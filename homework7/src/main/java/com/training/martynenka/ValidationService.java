package com.training.martynenka;

public class ValidationService {

    public static void validate(Object forValidate) throws ValidationFailedException {
        getValidator(forValidate).validate(forValidate);
    }

    private static Validator getValidator(Object forValidate) {
        ValidatorFactory validatorFactory = new ValidatorFactory();
        for (ValidationTypes validatorType : ValidationTypes.values()) {
            if (forValidate.getClass().getSimpleName().toUpperCase()
                    .equals(validatorType.name())) {
                return validatorFactory.getValidator(validatorType);
            }
        }
        throw new IllegalArgumentException("This type of variable is not processed.");
    }
}

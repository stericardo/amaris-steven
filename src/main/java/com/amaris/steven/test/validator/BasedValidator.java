package com.amaris.steven.test.validator;

public abstract class BasedValidator {

    public boolean validateInteger(Integer validateNumber){
        return validateNumber != null && validateNumber > 0;
    }
}

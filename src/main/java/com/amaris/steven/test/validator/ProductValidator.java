package com.amaris.steven.test.validator;

import com.amaris.steven.test.exception.ProductConstraint;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ProductValidator extends BasedValidator implements ConstraintValidator<ProductConstraint, Integer> {

    @Override
    public void initialize(ProductConstraint contactNumber) {
    }

    @Override
    public boolean isValid(Integer productId,
                           ConstraintValidatorContext cxt) {
        return validateInteger(productId);
    }

}

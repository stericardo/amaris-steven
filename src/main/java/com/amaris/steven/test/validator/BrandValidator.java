package com.amaris.steven.test.validator;

import com.amaris.steven.test.exception.BrandConstraint;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class BrandValidator extends BasedValidator implements ConstraintValidator<BrandConstraint, Integer> {

    @Override
    public void initialize(BrandConstraint contactNumber) {
    }

    @Override
    public boolean isValid(Integer brandId,
                           ConstraintValidatorContext cxt) {
        return validateInteger(brandId);
    }

}

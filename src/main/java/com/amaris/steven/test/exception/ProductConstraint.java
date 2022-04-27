package com.amaris.steven.test.exception;

import com.amaris.steven.test.validator.BrandValidator;
import com.amaris.steven.test.validator.ProductValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Documented
@Constraint(validatedBy = ProductValidator.class)
@Target( { ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface ProductConstraint {
    String message() default "Invalid product number";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}

package com.example.demo.validator;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.example.demo.validator.impl.DuplicateCheckImpl;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Documented
@Target({ ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = DuplicateCheckImpl.class)

public @interface DuplicateCheck {
	
	String message() default "";
	
	Class<?>[] groups() default {};
	Class<? extends Payload>[] payload() default {};
}

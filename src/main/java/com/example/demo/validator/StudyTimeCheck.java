package com.example.demo.validator;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import com.example.demo.validator.impl.StudyTimeCheckImpl;

@Documented
@Target({ ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = StudyTimeCheckImpl.class)

public @interface StudyTimeCheck {
	
	String message() default "学習した時間を0.5時間単位で入力してください";

	Class<?>[] groups() default {};
	Class<? extends Payload>[] payload() default {};
	
}

package com.example.demo.validator.impl;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import com.example.demo.validator.StudyTimeCheck;

public class StudyTimeCheckImpl implements ConstraintValidator<StudyTimeCheck, Double> {

	//初期化処理
	@Override
	public void initialize (StudyTimeCheck annotation) {
	}

	@Override
	public boolean isValid (Double value, ConstraintValidatorContext context) {
		if(value != null) {
			if(value % 0.5 == 0.0) {
				return true;
			}
		}
		return false;

	}
	
}

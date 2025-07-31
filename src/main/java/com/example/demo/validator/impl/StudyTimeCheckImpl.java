package com.example.demo.validator.impl;

import com.example.demo.validator.StudyTimeCheck;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class StudyTimeCheckImpl implements ConstraintValidator<StudyTimeCheck, Double> {

	//初期化処理
	@Override
	public void initialize (StudyTimeCheck annotation) {
	}

	@Override
	public boolean isValid (Double value, ConstraintValidatorContext context) {
		
		double valueMax = 24.0;
		double valueMin = 0.0;
		
		if(value == null) {
			return true;
			
		} else if(value <= valueMax && value >= valueMin && value % 0.5 == 0.0) {
				return true;
				
			}
		
		return false;

	}
	
}

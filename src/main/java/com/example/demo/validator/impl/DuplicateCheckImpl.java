package com.example.demo.validator.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.service.TraService;
import com.example.demo.validator.DuplicateCheck;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class DuplicateCheckImpl implements ConstraintValidator<DuplicateCheck, String> {

	@Autowired
	TraService traService;
	
	@Override
    public void initialize(DuplicateCheck constraintAnnotation) {
    }
	
	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		
		boolean existsCheck = traService.existsByIdTra(value);
		if(existsCheck != false) {
			return true;
		}
		
		return false;
	}
}

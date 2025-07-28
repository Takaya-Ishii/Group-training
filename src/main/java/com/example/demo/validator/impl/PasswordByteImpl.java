package com.example.demo.validator.impl;

import java.nio.charset.Charset;

import com.example.demo.validator.PasswordByte;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PasswordByteImpl implements ConstraintValidator<PasswordByte,String>{
	/**文字エンコーディング*/
	private String encording;
	
	/**許容する最大バイト数*/
	private int max;
	
	@Override
	public void initialize(PasswordByte constraintAnnotation) {
		this.max = constraintAnnotation.max();
	}
	

	@Override
	public boolean isValid(String value,ConstraintValidatorContext context) {
		if(value == null) {
			return true;
		}
		return value.getBytes(Charset.forName("UTF-8")).length <= max;
	}
	
}

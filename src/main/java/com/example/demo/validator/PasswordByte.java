package com.example.demo.validator;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.example.demo.validator.impl.PasswordByteImpl;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
//パスワードをハッシュ化する際に、バイト数で文字数制限するためのアノテーション
@Documented
@Constraint(validatedBy = PasswordByteImpl.class)
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Repeatable(PasswordByte.List.class)
public @interface PasswordByte {
	String message() default "{validation.ByteSize.message}";
	Class<?> []groups()default {};
	Class<? extends Payload>[]payload() default{};
	
	/**
	 * 文字サイズを計測する文字エンコーディング
	 * 
	 * @return
	 */
	
	String encording() default "UTF-8";
	
	/**
	 * 許容するバイトサイズの最大値
	 * @return
	 */
	int max();
	
	@Target({ElementType.FIELD})
	@Retention(RetentionPolicy.RUNTIME)
	@Documented
	public @interface List{
		PasswordByte[] value();
	}
	
}

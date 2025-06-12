package com.example.demo.utility;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordGenerator {

	 public static void main(String[] args) {
	        // 「BCrypt」のインスタンス化
	        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
	        // 入力値
	        String rawPassword = "egohegoh";
	        // パスワードをハッシュ化
	        String encodedPassword = encoder.encode(rawPassword);
	        // 表示
	        System.out.println("ハッシュ化されたパスワード: " + encodedPassword);
	        
	        BCryptPasswordEncoder enCoder = new BCryptPasswordEncoder();
	        // 入力値
	        String rawpassword = "agufaguf";
	        // パスワードをハッシュ化
	        String encodedpassword = enCoder.encode(rawpassword);
	        // 表示
	        System.out.println("ハッシュ化されたパスワード: " + encodedpassword);
	    }
}

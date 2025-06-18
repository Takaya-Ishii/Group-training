package com.example.demo.entity;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Component
@NoArgsConstructor
@AllArgsConstructor
public class User {
	//ユーザーのID
	private String username;
	//ユーザーの名前
	private String account_name;
	//ユーザーのパスワード
	private String password;
	//ユーザーの電話番号
	private String TEL;
	//ユーザーの住所
	private String address;
	//ユーザーの性別
	private String gender;
	//ユーザーの所属
	private String affriation;
	//ユーザーのグループ
	private Integer group_ID; 
	//ユーザーの出身学部
	private String departOfOrigin;
	//ユーザーのロール名
	private Integer role_ID;
	
}
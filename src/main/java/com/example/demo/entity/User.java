package com.example.demo.entity;

import java.util.List;

import org.springframework.stereotype.Component;

import com.example.demo.entity.Group.Group;
import com.example.demo.entity.Role.Role;

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
	private String affiriation;
	//ロールID
	private Integer role_ID;
	//ユーザーとグループの一対多の関係
	private List<Group> group; 
	//ユーザーの出身学部
	private String departOfOrigin;
	//ユーザーとロールIDの一対一の関係
	private Role role;
	//ユーザーのグループ名
	private String group_name;
	//ユーザー名のロール名
	private String role_name;
	
}
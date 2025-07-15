package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Member {
	/* グループと所属メンバーを判別するID */
	private int group_user_ID;
	/* グループID */
	private int group_ID;
	/* ユーザID */
	private int username;
	/* メイン講師かどうか */
	private Boolean isTeacher;
}

package com.example.demo.entity.Group;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Group {
	//グループID
	private Integer group_ID;
	//ユーザID(メイン講師)
	private String username;
	//グループの名前
	private String group_name;
	//概要
	private String summary;
}


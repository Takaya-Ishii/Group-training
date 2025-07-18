package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Group {
	/*グループID*/
	private int group_ID;
	/*グループ名*/
	private String group_name;
	/*概要*/
	private String summary;
}

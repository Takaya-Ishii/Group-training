package com.example.demo.entity;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 学習履歴：エンティティ
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Stack {
	//履歴No
	private Integer stack_No;
	//受講研修ID
	private Integer traCourse_ID;
	//研修名
	private String tra_name;
	//学習した日付
	private Date study_day;
	//メモ
	private String memo;
	//学習時間
	private Double study_time;
	//進捗
	private Integer progress;
	//ステータスID
	private Integer status_ID;
}

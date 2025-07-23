package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Trainfo {
	
	/*研修ID*/
	private String tra_id;
	/*研修名*/
	private String tra_name;
	/*想定時間*/
	private Integer est_time;
	/*使用教材*/
	private String text_book;
	/*課題*/
	private String assignment;
	/*説明*/
	private String description;
}

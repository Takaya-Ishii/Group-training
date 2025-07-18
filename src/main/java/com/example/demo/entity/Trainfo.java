package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Trainfo {
	private String tra_id;
	private String tra_name;
	private Integer est_time;
	private String text_book;
	private String assignment;
	private String description;
}

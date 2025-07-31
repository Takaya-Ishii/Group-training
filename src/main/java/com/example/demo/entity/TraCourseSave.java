package com.example.demo.entity;

import java.time.LocalDate;

import lombok.Data;

@Data
public class TraCourseSave {
	private Integer tracourse_id;
	private String tra_id;
	private String username;
	private boolean istakecourse;
	private LocalDate target_date;
	//研修情報
	private Trainfo trainfo;
}

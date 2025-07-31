package com.example.demo.entity;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TraCourse {
	private Integer tracourse_id;
	private String tra_id;
	private String username;
	private boolean istakecourse;
	private Integer latestprogress;
	private Integer status_id;
	private LocalDate target_date;
	//研修情報
	private Trainfo trainfo;

	//ステータス情報
	private Status status;
	
	
}

package com.example.demo.form;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import com.example.demo.entity.Trainfo;

import lombok.Data;
@Data
public class TraCourseSaveForm {
	private Integer tracourse_id;
	private String tra_id;
	private String username;
	private boolean istakecourse;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate target_date;
	//研修情報
	private Trainfo trainfo;
}

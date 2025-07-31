package com.example.demo.form;

import java.util.Date;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;

import org.hibernate.validator.constraints.Range;
import org.springframework.format.annotation.DateTimeFormat;

import com.example.demo.validator.StudyTimeCheck;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 学習履歴：Form
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StackForm {
	//履歴No
	private Integer stackNo;

	//受講研修ID
	private Integer traCourseID;
	
	//研修名
	private String traName;
	
	//学習した日付
	@NotNull (message = "学習した日付を入力してください")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@PastOrPresent (message = "日付が不正です")
	private Date studyDay;
	
	//学習時間
	@StudyTimeCheck
	private Double studyTime;
	
	//進捗
	@NotNull (message = "進捗率を入力してください")
	@Range(min = 0, max = 100, message = "0～100までの数値を入力してください")
	private Integer progress;
	
	//メモ
	@Size(max = 200, message = "200文字以内で入力してください")
	private String memo;
	
	//ステータスID
	private Integer statusID;
}

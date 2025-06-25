package com.example.demo.form;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TraForm {

	@NotBlank(message = "研修IDは、必須項目です")
	private String tra_id;
	
	@NotBlank(message = "研修名は、必須項目です")
	private String tra_name;
	
	private Integer est_time;
	private String text_book;
	private String assignment;
	private String description;

	/*バリデーションの判定*/
	private Boolean isNew;
}

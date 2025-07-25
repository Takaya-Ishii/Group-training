package com.example.demo.form;

import com.example.demo.validator.DuplicateCheck;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TraForm {

	@NotBlank(message = "研修IDは、必須項目です")
	@Pattern(regexp = "^(?!.*[%]).*$", message = "")
	@Pattern(regexp = "^(?!.*[\\s|　]).*$", message = "研修IDは、必須項目です")
	@Size(min=0, max=5, message = "5文字以内で入力してください")
	@DuplicateCheck
	private String tra_id;
	
	@NotBlank(message = "研修名は、必須項目です")
	@Pattern(regexp = "^(?!.*[\\s|　]).*$", message = "研修名は、必須項目です")
	@Size(max=20, message = "20文字以内で入力してください")
	private String tra_name;
	
	@Max(value=300, message = "300時間以内で入力してください")
	@Min(0)
	private Integer est_time;
	
	@Size(max=50, message = "50文字以内で入力してください")
	private String text_book;
	
	@Size(max=100, message = "100文字以内で入力してください")
	private String assignment;
	
	@Size(max=100, message = "100文字以内で入力してください")
	private String description;

	/*バリデーションの判定*/
	private Boolean isNew;
}

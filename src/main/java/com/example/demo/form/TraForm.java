package com.example.demo.form;

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
	@Size(max=5, message = "")
	private String tra_id;
	
	@NotBlank(message = "研修名は、必須項目です")
	@Pattern(regexp = "^(?!.*[\\s|　]).*$", message = "研修名は、必須項目です")
	@Size(max=20, message = "")
	private String tra_name;
	
	@Max(300)
	@Min(0)
	private Integer est_time;
	
	@Size(max=50)
	private String text_book;
	
	@Size(max=100)
	private String assignment;
	
	@Size(max=100)
	private String description;

	/*バリデーションの判定*/
	private Boolean isNew;
}

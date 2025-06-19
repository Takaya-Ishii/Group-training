package com.example.demo.form;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**ユーザーから送られてくるデータを定義する*/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserForm {
	//ユーザーのID
	@NotBlank(message = "ユーザーIDが未入力です。")
		private String username;
		//ユーザーの名前
	@NotBlank(message = "ユーザー名が未入力です。")
		private String account_name;
		//ユーザーのパスワード
	@NotBlank(message = "性別が選択されていません。")
		private String password;
		//ユーザーの電話番号
	@NotBlank(message = "電話番号が未入力です。")
		private String TEL;
		//ユーザーの住所
		private String address;
		//ユーザーの性別
		private String gender;
		//ユーザーの所属
	@NotBlank(message = "所属が未入力です。")
		private String affriation;
		//ユーザーのグループ
		private Integer group_ID; 
		//ユーザーの出身学部
		private String depart0f0rigin;
		//ユーザーのロール名
	@NotBlank(message = "ロールが未入力です。")
		private Integer role_ID;
		//新規判定
		private Boolean isNew;
}


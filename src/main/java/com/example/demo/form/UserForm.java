package com.example.demo.form;

import java.util.List;
import java.util.Objects;

import com.example.demo.entity.Group;
import com.example.demo.entity.Role;
import com.example.demo.validation.EditValidation;
import com.example.demo.validation.InsertValidation;
import com.example.demo.validator.PasswordByte;

import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**ユーザーから送られてくるデータを定義する*/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserForm {
	//ユーザーのID
	@NotBlank(message = "ユーザーIDは必須項目です。",groups = {InsertValidation.class})
	@Email(message="メールアドレスの形式が無効です。",groups = {InsertValidation.class})
	@Size(min=0,max = 30,message = "最大文字数を超過しています。",groups = {InsertValidation.class})
		private String username;
	
		//ユーザーの名前
	@NotBlank(message = "ユーザー名は必須項目です。",groups = {InsertValidation.class})
	@Size(min=0,max = 20,message = "最大文字数を超過しています。",groups = {InsertValidation.class})
	@NotBlank(message = "ユーザー名は必須項目です。",groups = {EditValidation.class})
	@Size(min=0,max = 20,message = "最大文字数を超過しています。",groups = {EditValidation.class})
		private String account_name;
	
		//ユーザーのパスワード
	@NotBlank(message ="パスワードは必須項目です",groups = {InsertValidation.class})
	@NotBlank(message ="パスワードは必須項目です",groups = {EditValidation.class})
	@PasswordByte( max = 72,message="最大文字数を超過しています",groups = {InsertValidation.class})
	@PasswordByte( max = 72,message="最大文字数を超過しています",groups = {EditValidation.class})
		private String password;
	
	//ユーザーのパスワード確認用
	
	    private String confirmPassword;
	
		//ユーザーの電話番号
	@NotBlank(message = "電話番号は必須項目です。",groups = {InsertValidation.class})
	@NotBlank(message = "電話番号は必須項目です。",groups = {EditValidation.class})
	@Pattern(regexp = "^\\d{3}\\d{4}\\d{4}", message = "入力に誤りがあります。半角数字のみ適応されます",groups = {InsertValidation.class})
	@Pattern(regexp = "^\\d{3}\\d{4}\\d{4}", message = "入力に誤りがあります。半角数字のみ適応されます",groups = {EditValidation.class})
		private String TEL;
	
		//ユーザーの住所
	@Size(min = 0, max = 50,message = "最大文字数を超過しています。",groups = {InsertValidation.class})
	@Size(min = 0, max = 50,message = "最大文字数を超過しています。",groups = {EditValidation.class})
		private String address;
		
		//ユーザーの性別
	@NotBlank(message = "性別は必須項目です。",groups = {InsertValidation.class})
	@NotBlank(message = "性別は必須項目です。",groups ={EditValidation.class})
		private String gender;
		
		//ユーザーの所属
	@NotBlank(message = "所属は必須項目です。",groups = {InsertValidation.class})
	@NotBlank(message = "所属は必須項目です。",groups ={EditValidation.class})
		private String affiriation;
	
		//ユーザーのグループ
	@NotNull(message = "グループ選択は必須です。",groups ={InsertValidation.class})
	@NotNull(message = "グループ選択は必須です。",groups ={EditValidation.class})
		private Integer group_ID; 
		
		//ユーザーの出身学部
	@Size(min=0,max = 10,message = "最大文字数を超過しています。",groups = {InsertValidation.class})
	@Size(min = 0,max = 10,message = "最大文字数を超過しています。",groups = {EditValidation.class})
		private String departOfOrigin;
		
		//ユーザーのロールID
	@NotNull(message = "ロールは必須項目です。",groups = {InsertValidation.class})
	@NotNull(message = "ロールは必須項目です。",groups ={EditValidation.class})
		private Integer role_ID;
	
		//新規判定
		private Boolean isNew;
		
		//グループの名前
		private String group_name;
		
		//概要
		private String summary;
		
		//パスワードと確認用パスワードが一致するかチェック
	@AssertTrue(message = "パスワードが異なります",groups = {InsertValidation.class})
	@AssertTrue(message = "パスワードが異なります",groups ={EditValidation.class})
		public boolean isSamePassword() {
			return Objects.equals(password, confirmPassword);
		}
		//ユーザーとグループの一対多の関係
		private List<Group> group; 
		
		//ユーザーとロールの一対一の関係
		private Role role;
}


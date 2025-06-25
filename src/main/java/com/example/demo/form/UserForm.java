package com.example.demo.form;

import java.util.List;
import java.util.Objects;

import com.example.demo.entity.Group.Group;
import com.example.demo.entity.Role.Role;
import com.example.demo.validation.EditValidation;
import com.example.demo.validation.InsertValidation;

import jakarta.validation.constraints.AssertTrue;
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
	@NotBlank(message = "ユーザーIDが未入力です。",groups = {InsertValidation.class})
	@NotBlank(message = "ユーザーIDが未入力です。",groups = {EditValidation.class})
		private String username;
	
		//ユーザーの名前
	@NotBlank(message = "ユーザー名が未入力です。",groups = {InsertValidation.class})
	@NotBlank(message = "ユーザー名が未入力です。",groups = {EditValidation.class})
	@Size(min = 1, max = 30,message = "入力されていないもしくは、文字数が多すぎます",groups = {EditValidation.class})
		private String account_name;
	
		//ユーザーのパスワード
	@NotBlank(message ="パスワードが設定されていません",groups = {EditValidation.class})
	@NotBlank(message ="パスワードが設定されていません",groups = {EditValidation.class})
	@Size(min = 1, max = 20,message = "入力されていないもしくは、文字数が多すぎます",groups = {EditValidation.class})
		private String password;
	
	//ユーザーのパスワード確認用
	
	    private String ConfirmPassword;
	
		//ユーザーの電話番号
	@NotBlank(message = "電話番号が未入力です。",groups = {InsertValidation.class})
	@NotBlank(message = "電話番号が未入力です",groups = {EditValidation.class})
	@Pattern(regexp = "^\\d{3}\\d{4}\\d{4}", message = "ハイフンがあるもしくは入力に誤りがあります。",groups = {EditValidation.class})
		private String TEL;
	
		//ユーザーの住所
	@NotBlank(message = "住所が未入力です" ,groups = {InsertValidation.class})
	@NotBlank(message = "住所が未入力です",groups = {EditValidation.class} )
	@Size(min = 1, max = 50,message = "入力されていないもしくは文字数が多すぎます",groups = {EditValidation.class})
		private String address;
		
		//ユーザーの性別
		@NotBlank(message = "性別が選択されていません。",groups = {InsertValidation.class})
		@NotBlank(message = "性別が選択されていません。",groups ={EditValidation.class})
		private String gender;
		
		//ユーザーの所属
	@NotBlank(message = "所属が未入力です。",groups = {InsertValidation.class})
	@NotBlank(message = "所属が未入力です",groups ={EditValidation.class})
		private String affiriation;
	
		//ユーザーのグループ
	@NotBlank(message = "グループが登録されていません",groups ={EditValidation.class})
		private Integer group_ID; 
		
		//ユーザーの出身学部
	@NotBlank(message = "出身学部が登録されていません",groups ={EditValidation.class})
		private String depart0f0rigin;
		
		//ユーザーのロールID
	@NotNull(message = "ロールIDが未入力です。",groups = {InsertValidation.class})
	@NotNull(message= "ロールIDが未入力です。",groups ={EditValidation.class})
		private Integer role_ID;
	
		//新規判定
		private Boolean isNew;
		
		//パスワードと確認用パスワードが一致するかチェック
		@AssertTrue(message = "パスワードが一致しません")
		public boolean isSamePassword() {
			return Objects.equals(password, ConfirmPassword);
		}
		//ユーザーとグループの一対多の関係
		private List<Group> group; 
		
		//ユーザーとロールの一対一の関係
		private Role role;
}


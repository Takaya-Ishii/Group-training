package com.example.demo.helper;

import org.springframework.stereotype.Component;

import com.example.demo.entity.User;
import com.example.demo.form.UserForm;

/**ここで、受け取ったデータをDB用のデータに、
 * 元々あるデータを入力されたデータとして変換します。
 */
@Component
public class Userhelper {
	/**エンティティ化します。
	 * つまりDB用のデータにします。
	 */
	public static User convertUser(UserForm form) {
		User user = new User();
		user.setUsername(form.getUsername());
		user.setAccount_name(form.getAccount_name());
		user.setPassword(form.getPassword());
		user.setTEL(form.getTEL());
		user.setAddress(form.getAddress());
		user.setGender(form.getGender());
		user.setAffiriation(form.getAffiriation());
		user.setDepartOfOrigin(form.getDepart0f0rigin());
		user.setGroup(form.getGroup());
		user.setRole(form.getRole());
		user.setRole_ID(form.getRole_ID());
		return user;
	}
	
	/**上とは逆に、DBのデータを編集されたものとして扱います。
	 * これは、編集機能がありそれを再度登録するためのものです。maybe
	 */
	
	public static UserForm convertUserForm(User user) {
		UserForm form = new UserForm();
		form.setUsername(user.getUsername());
		form.setAccount_name(user.getAccount_name());
		form.setPassword(user.getPassword());
		form.setTEL(user.getTEL());
		form.setAddress(user.getAddress());
		form.setGender(user.getGender());
		form.setAffiriation(user.getAffiriation());
		form.setDepart0f0rigin(user.getDepartOfOrigin());
		form.setGroup(user.getGroup());
		form.setRole(user.getRole());
		form.setRole_ID(user.getRole_ID());
		return form;
	}
}


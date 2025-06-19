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
		user.setAffriation(form.getAffriation());
		user.setGroup_ID(form.getGroup_ID());
		user.setDepartOfOrigin(form.getDepart0f0rigin());
		user.setRole_ID(form.getRole_ID());
		return user;
	}
	
	/**上とは逆に、DBのデータを編集されたものとして扱います。
	 * これは、編集機能がありそれを再度登録するためのものです。maybe
	 */
	
	public static UserForm convertUserForm(User user) {
		UserForm form = new UserForm();
		form.setUsername(form.getUsername());
		form.setAccount_name(form.getAccount_name());
		form.setPassword(form.getPassword());
		form.setTEL(form.getTEL());
		form.setAddress(form.getAddress());
		form.setGender(form.getGender());
		form.setAffriation(form.getAffriation());
		form.setGroup_ID(form.getGroup_ID());
		form.setDepart0f0rigin(form.getDepart0f0rigin());
		form.setRole_ID(form.getRole_ID());
		return form;
	}
}


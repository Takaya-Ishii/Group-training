package com.example.demo.helper;

import org.springframework.stereotype.Component;

import com.example.demo.entity.Authentication;
import com.example.demo.entity.Group.Group;
import com.example.demo.form.UserForm;

/**ここで、受け取ったデータをDB用のデータに、
 * 元々あるデータを入力されたデータとして変換します。
 */
@Component
public class Userhelper {
	/**エンティティ化します。
	 * つまりDB用のデータにします。
	 */
	public static Authentication convertUser(UserForm form) {
		Authentication user = new Authentication();
		user.setUsername(form.getUsername());
		user.setAccount_name(form.getAccount_name());
		user.setPassword(form.getPassword());
		user.setTEL(form.getTEL());
		user.setAddress(form.getAddress());
		user.setGender(form.getGender());
		user.setAffiriation(form.getAffiriation());
		user.setDepartOfOrigin(form.getDepartOfOrigin());
		user.setGroup_ID(form.getGroup_ID());
		user.setRole(form.getRole());
		user.setGroup_ID(form.getGroup_ID());
		user.setRole_ID(form.getRole_ID());
		return user;
	}
	
	/**上とは逆に、DBのデータを編集されたものとして扱います。
	 * これは、編集機能がありそれを再度登録するためのものです。maybe
	 */
	
	public static UserForm convertUserForm(Authentication user) {
		UserForm form = new UserForm();
		form.setUsername(user.getUsername());
		form.setAccount_name(user.getAccount_name());
		form.setPassword(user.getPassword());
		form.setTEL(user.getTEL());
		form.setAddress(user.getAddress());
		form.setGender(user.getGender());
		form.setAffiriation(user.getAffiriation());
		form.setDepartOfOrigin(user.getDepartOfOrigin());
		form.setGroup(user.getGroup());
		form.setGroup_ID(user.getGroup_ID());
		form.setRole(user.getRole());
		form.setRole_ID(user.getRole_ID());
		return form;
	}
	
	public static Group convert_User(UserForm form) {
		Group group = new Group();
		group.setGroup_ID(form.getGroup_ID());
		group.setGroup_name(form.getGroup_name());
		group.setSummary(form.getSummary());
		return group;
	}
	
	public static UserForm  convert_UserForm(Group group) {
		UserForm target = new UserForm();
		target.setGroup_ID(group.getGroup_ID());
		target.setGroup_name(group.getGroup_name());
		target.setSummary(group.getSummary());
		return target;
	}
}


package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Authentication;
import com.example.demo.entity.Group.Group;


/**サービス実際にJava上での動き*/
public interface UserService {
	/**全てのIDを検索します*/
	List<Authentication> displayAllUser();
	
	/**検索結果を表示する*/
	List<Authentication>  displaySearchedUser(String username,String account_name);
	
	/**指定されたidの詳細情報を表示する
	 * @return */
	Authentication displayUserDetail(String username);
	
	/**全グループ名を取得する*/
	List<Group> selectAllGroup();
	
	
	/**IDを新規登録する*/
	void registrationUser(Authentication user);
	
	/**指定されたIDの情報を編集する*/
	void updateUser(Authentication user);
	
	/**指定されたIDの情報を削除する*/
	void deleteUser(String username);

	/**すでにパスワードが使われているのかをチェックする*/
	List<Authentication> IsPasswordTaken(String password);
	
	/**全電話番号を取得*/
	List<Authentication> IsTELTaken(String TEL);
}

package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.User;


/**サービス実際にJava上での動き*/
public interface UserService {
	/**全てのIDを検索します(リポジトリで取得と書いたのは、SQL上の話だから)*/
	List<User> displayAllUser();
	
	/**検索結果を表示する*/
	List<User>  displaySearchedUser(String username,String account_name);
	
	/**指定されたidの詳細情報を表示する
	 * @return */
	User displayUserDetail(String username);
	
	/**IDを新規登録する*/
	void registrationUser(User user);
	
	/**指定されたIDの情報を編集する*/
	void updateUser(User user);
	
	/**指定されたIDの情報を削除する*/
	void deleteUser(String username);
}

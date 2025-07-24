package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Authentication;
import com.example.demo.entity.Group;
import com.example.demo.entity.Member;
import com.example.demo.entity.Role;


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
	
	/**全ロール名を取得する*/
	List<Role> selectAllRole();
	
	/**IDを新規登録する*/
	void registrationUser(Authentication user);
	
	/**ユーザーをメンバーテーブルに登録する*/
	void registrationMember(Member member,Authentication user);
	
	/**指定されたIDの情報を編集する*/
	void updateUser(Authentication user);
	
	/**指定されたユーザーのメンバーテーブルを編集する*/
	void updateMember(Member member,Authentication user);
	
	/**指定されたIDの情報を削除する*/
	void deleteUser(String username);

	/**すでにパスワードが使われているのかをチェックする*/
	List<Authentication> IsPasswordTaken(String password);
	
	/**すでに電話番号が使われているかをチェックする*/
	List<Authentication> IsTELTaken(String TEL);
}

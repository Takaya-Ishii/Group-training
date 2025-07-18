package com.example.demo.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.demo.entity.Authentication;
import com.example.demo.entity.Group.Group;


/**User リポジトリ*/

@Mapper
public interface UserMapper {
	/**全ての「Id」を取得する*/
	List<Authentication> selectAll();
		
	/**検索ボックスで検索したid ユーザー名 ロールを取得
	 * @param account_name */
	List<Authentication> selectByBox(@Param("username")String username,@Param("account_name")String account_name);
	
	/**詳細表示
	 * @return */
	Authentication selectdetailById(@Param("username") String username);
	
	/**「ユーザーデータ」を登録する*/
	void insert(Authentication user);
	
	//「ユーザーデータ」をメンバーテーブルに登録する
	void insertPlus(Authentication user);
	
	//パスワードで一致するものがあるか
	List<Authentication> selectPassWord(String password);
	
	//TELで一致するものがあるか
	List<Authentication> selectTEL(String TEL);
	
	/**プロフィールテーブルの「ユーザーデータ」を更新する*/
	void update(Authentication user);
	
	/**メンバーテーブルの「ユーザーデータ」を更新する*/
	void updateMember(Authentication user);
	
	/**id指定された情報を削除*/
	void delete(@Param("username") String username);
	
	//グループ情報を取得
	public List<Group> findAllGroup();
	
}


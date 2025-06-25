package com.example.demo.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.demo.entity.User;
import com.example.demo.entity.Group.Group;


/**User リポジトリ*/

@Mapper
public interface UserMapper {
	/**全ての「Id」を取得する*/
	List<User> selectAll();
		
	/**検索ボックスで検索したid ユーザー名 ロールを取得
	 * @param account_name */
	List<User> selectByBox(@Param("username")String username,@Param("account_name")String account_name);
	
	/**詳細表示
	 * @return */
	User selectdetailById(@Param("username") String username);
	
	/**「ユーザーデータ」を登録する*/
	void insert(User user);
	
	/**「ユーザーデータ」を更新する*/
	void update(User user);
	
	/**id指定された情報を削除*/
	void delete(@Param("username") String username);
	
	//グループ情報を取得
	public List<Group> findAllGroup();
	
	
}


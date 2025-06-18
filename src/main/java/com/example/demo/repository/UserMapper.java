package com.example.demo.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.demo.entity.User;


/**User リポジトリ*/

@Mapper
public interface UserMapper {
	/**全ての「Id」を取得する*/
	List<User> selectAll();
	
	/**idで指定された情報を取得*/
	User selectById(@Param("username") String username);
	
	/**「ユーザーデータ」を登録する*/
	void insert(User user);
	
	/**「ユーザーデータ」を更新する*/
	void update(User user);
	
	/**id指定された情報を削除*/
	void delete(@Param("username") String username);
}


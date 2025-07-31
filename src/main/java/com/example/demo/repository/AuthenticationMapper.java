package com.example.demo.repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.demo.entity.Authentication;
import com.example.demo.entity.Group;
import com.example.demo.entity.Role;

@Mapper
public interface AuthenticationMapper {
	
	  // ユーザー名でログイン情報を取得
	  Authentication selectByUsername(String username);
	  // ロールIDからロール名とロールIDを含んだRole型を取得
	  Role selectByRoleId(int role_ID);
	  // ユーザー名からグループ名を取得
	  Group selectGroupByUsername(String username);
	// ユーザーIDで特定して対象のパスワードを変更
		  void updatePassword(@Param("username") String username, @Param("password") String encodedPassword);
}

package com.example.demo.repository;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.entity.Authentication;
import com.example.demo.entity.Role;

@Mapper
public interface AuthenticationMapper {
	/**
	 * ユーザー名でログイン情報を取得
	 */
	  Authentication selectByUsername(String username);
	  
	  Role selectByRoleId(int role_ID);
}

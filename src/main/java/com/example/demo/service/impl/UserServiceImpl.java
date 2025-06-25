package com.example.demo.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.User;
import com.example.demo.repository.UserMapper;
import com.example.demo.service.UserService;

import lombok.RequiredArgsConstructor;

/**ユーザー機能実装サービス*/

@Service
@Transactional
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
	/**DI*/
	private final UserMapper userMapper;
	/**ユーザーを一覧表示*/
	@Override
	public List<User> displayAllUser() {
		 
		return userMapper.selectAll();
	}
	/**指定されたidの情報を検索する*/
	@Override
	public List<User> displaySearchedUser(String username,String account_name) {
		 //TODO 自動生成されたメソッド・スタブ
		return userMapper.selectByBox(username,account_name);
	}
	/**ユーザーの詳細表示
	 * @return */
	@Override
	public User displayUserDetail(String username) {
		return userMapper.selectdetailById(username);
	}
	/**IDを新規登録する*/
	@Override
	public void registrationUser(User user) {
		 //TODO 自動生成されたメソッド・スタブ
		userMapper.insert(user);
	}
	/**指定されたIDの情報を編集する*/
	@Override
	public void updateUser(User user) {
		 //TODO 自動生成されたメソッド・スタブ
		userMapper.update(user);
	}
	
	/**指定されたIDの情報を削除する*/
	@Override
	public void deleteUser(String username) {
		 //TODO 自動生成されたメソッド・スタブ
		userMapper.delete(username);
	}

}

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
	@Override
	public List<User> displayAllUser() {
		 //TODO 自動生成されたメソッド・スタブ
		return userMapper.selectAll();
	}

	@Override
	public User displaySearchedUser(String username) {
		 //TODO 自動生成されたメソッド・スタブ
		return userMapper.selectById(username);
	}

	@Override
	public void registrationUser(User user) {
		 //TODO 自動生成されたメソッド・スタブ
		userMapper.insert(user);
	}

	@Override
	public void updateUser(User user) {
		 //TODO 自動生成されたメソッド・スタブ
		userMapper.update(user);
	}

	@Override
	public void deleteUser(String username) {
		 //TODO 自動生成されたメソッド・スタブ
		userMapper.delete(username);
	}

}

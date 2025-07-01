package com.example.demo.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.Authentication;
import com.example.demo.entity.Group.Group;
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
	public List<Authentication> displayAllUser() {
		 
		return userMapper.selectAll();
	}
	/**指定されたidの情報を検索する*/
	@Override
	public List<Authentication> displaySearchedUser(String username,String account_name) {
		 //TODO 自動生成されたメソッド・スタブ
		return userMapper.selectByBox(username,account_name);
	}
	
	/**全グループ名を取得する*/
	public List<Group> selectAllGroup(){
		return userMapper.findAllGroup();
	}
	/**ユーザーの詳細表示
	 * @return */
	@Override
	public Authentication displayUserDetail(String username) {
		return userMapper.selectdetailById(username);
	}
	/**IDを新規登録する*/
	@Override
	public void registrationUser(Authentication user) {
		 //TODO 自動生成されたメソッド・スタブ
		userMapper.insert(user);
		userMapper.insertPlus(user);
	}
	/**指定されたIDの情報を編集する*/
	@Override
	public void updateUser(Authentication user) {
		 //TODO 自動生成されたメソッド・スタブ
		userMapper.update(user);
		userMapper.updateMember(user);
	}
	
	/**指定されたIDの情報を削除する*/
	@Override
	public void deleteUser(String username) {
		 //TODO 自動生成されたメソッド・スタブ
		userMapper.delete(username);
	}

}

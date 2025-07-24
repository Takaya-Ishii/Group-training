package com.example.demo.service.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsPasswordService;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Authentication;
import com.example.demo.entity.LoginUser;
import com.example.demo.entity.Role;
import com.example.demo.repository.AuthenticationMapper;

import lombok.RequiredArgsConstructor;
 /**
 * カスタム認証サービス
 */
 
  @Service
 @RequiredArgsConstructor
 public class LoginUserDatailsServiceImpl implements UserDetailsService, UserDetailsPasswordService {
	 
	 /** DI */
	 private final AuthenticationMapper authenticationMapper;
	 
   @Override
   public UserDetails loadUserByUsername(String username) 
      throws UsernameNotFoundException {
    	
    	// username(ユーザID)からパスワードとロールIDを取得
    	 Authentication authentication = authenticationMapper.selectByUsername(username);
    	 
    	 // 対象データがあれば、UserDetailsの実装クラスを返す
         if (authentication != null) {
             // UserDetailsの実装クラスを返す
        	 return new LoginUser(authentication.getUsername(), 
                     authentication.getPassword(), 
                     getAuthorityList(authenticationMapper.selectByRoleId(authentication.getRole_ID())),
                     authentication.getAccount_name(),
                     authentication.getAddress(),
                     authentication.getGender(),
                     authentication.getTEL(),
                     authentication.getAffiriation(),
                     authentication.getDepartOfOrigin(),
                     authentication.getRole_ID()
                     );
         } else {
             // 対象データが存在しない
             throw new UsernameNotFoundException(
                     username + " => 指定しているユーザーIDは存在しません");
         }
    }

	private Collection<GrantedAuthority> getAuthorityList(Role role) {
		// 権限リスト
        List<GrantedAuthority> authorities = new ArrayList<>();
        // ロール名に対応したロールを付与
        authorities.add(new SimpleGrantedAuthority("ROLE_" + role.getRole_name().trim()));
        // role_IDが2(講師)の場合、受講者の権限も付与
        if (role.getRole_ID() == 2) {
        	authorities.add(new SimpleGrantedAuthority("ROLE_受講者"));
        }
        return authorities;
    }
	
	@Override
    public UserDetails updatePassword(UserDetails user, String newPassword) {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String encodedPassword = passwordEncoder.encode(newPassword);
		authenticationMapper.updatePassword(user.getUsername(), encodedPassword);
		
	    LoginUser loginUser = (LoginUser) user;

	    return new LoginUser(
	        loginUser.getUsername(),
	        encodedPassword,
	        loginUser.getAuthorities(),
	        loginUser.getAccount_name(),
	        loginUser.getAddress(),
	        loginUser.getGender(),
	        loginUser.getTEL(),
	        loginUser.getAffiriation(),
	        loginUser.getDepartOfOrigin(),
	        loginUser.getRole_ID()
	    );
    }
}
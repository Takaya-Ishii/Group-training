package com.example.demo.entity;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
/**
* ユーザーの認証情報を表すUser実装クラス*/

public class LoginUser extends User {
   private String account_name;
   private String address;
   private String gender;
   private String TEL;
   private String affiriation;
   private String departOfOrigin;
   private int role_ID;
   private int group_ID;

/** ユーザーの情報を保持したUser
    *  実装クラスUserを作成する */
   public LoginUser(String username,
     String password,
     Collection<? extends GrantedAuthority> authorities,
     String account_name,
     String address,
     String gender,
     String TEL,
     String affiriation,
     String departOfOrigin,
     int role_ID,
     int group_ID) {
       super(username, password, authorities);
       this.account_name = account_name;
       this.address = address;
       this.gender = gender;
       this.TEL = TEL;
       this.affiriation = affiriation;
       this.departOfOrigin = departOfOrigin;
       this.role_ID = role_ID;
       this.group_ID = group_ID;
   }
	
    public String getAccount_name() {
        return this.account_name;
    }

    public String getTEL() {
        return this.TEL;
    }

    public String getAddress() {
        return this.address;
    }

    public String getGender() {
        return this.gender;
    }
    
    public String getAffiriation() {
    	return this.affiriation;
    }
    
    public String getDepartOfOrigin() {
    	return this.departOfOrigin;
    }
    
    public int getRole_ID() {
    	return this.role_ID;
    }
    
    public int getGroup_ID() {
    	return this.group_ID;
    }
}
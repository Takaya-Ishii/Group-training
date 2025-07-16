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
     int role_ID) {
       super(username, password, authorities);
       this.account_name = account_name;
       this.address = address;
       this.gender = gender;
       this.TEL = TEL;
       this.affiriation = affiriation;
       this.departOfOrigin = departOfOrigin;
       this.role_ID = role_ID;
   }
	
    public String getAccount_name() {return this.account_name;}
    public void setAccount_name(String account_name) {this.account_name = account_name;}

    public String getTEL() {return this.TEL;}
    public void setTEL(String TEL) {this.TEL = TEL;}

    public String getAddress() {return this.address;}
    public void setAddress(String address) {this.address = address;}

    public String getGender() {return this.gender;}
    public void setGender(String gender) {this.gender = gender;}
    
    public String getAffiriation() {return this.affiriation;}
    public void setAffiriation(String affiriation) {this.affiriation = affiriation;}
    
    public String getDepartOfOrigin() {return this.departOfOrigin;}
    public void setDepartOfOrigin(String departOfOrigin) {this.departOfOrigin = departOfOrigin;}
    
    public int getRole_ID() {return this.role_ID;}
    public void setRole_ID(int role_ID) {this.role_ID = role_ID;}
}
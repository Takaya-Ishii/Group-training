package com.example.demo.entity;

import java.util.List;

import com.example.demo.entity.Group.Group;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Authentication {
   /** ユーザーID */
   private String username;
   /** ユーザー名 */
   private String account_name;
   /** パスワード */
   private String password;
   /** 電話番号 */
   private String TEL;
   /** 住所 */
   private String address;
   /** 性別 */
   private String gender;
   /** 所属 */
   private String affiriation;
   /** 出身学部 */
   private String departOfOrigin;
   /**グループのID*/
   private int group_ID;
   /** ロールID */
   private int role_ID;
   //ユーザーのグループ名
   private String group_name;
   //ユーザー名のロール名
   private String role_name;
   //ユーザーとグループの一対多の関係
 	private List<Group> group; 
   //ユーザーとロールIDの一対一の関係
 	private Role role;
}
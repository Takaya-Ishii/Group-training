package com.example.demo.entity;

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
   /** ロールID */
   private int role_ID;
   /** グループID */
   private int group_ID;
}
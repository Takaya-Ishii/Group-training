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
   /** パスワード */
   private String password;
   /** ロールID*/
   private int role_ID;
}
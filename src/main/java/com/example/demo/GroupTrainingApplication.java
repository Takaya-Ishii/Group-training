package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.entity.Authentication;
import com.example.demo.repository.UserMapper;

import lombok.RequiredArgsConstructor;

@SpringBootApplication
@RequiredArgsConstructor

public class GroupTrainingApplication {

	public static void main(String[] args) {
		SpringApplication.run(GroupTrainingApplication.class, args)
		.getBean(GroupTrainingApplication.class).exe();
	}
	
	/**DI*/
	private final UserMapper mapper;
	
	public void exe() {
		//全件検索
		System.out.println("===全件検索===");
		for(Authentication row : mapper.selectAll()) {
			System.out.println(row);
		}
		
		//一件検索
		/**System.out.println("===一件検索===");
		System.out.println(mapper.selectdetailById("hogehoge@example.jp"));**/
		
		//登録データ作成
		System.out.println("====データ作成====");
		Authentication user = new Authentication();
		user.setUsername("リポジトリのテスト");
		user.setAccount_name("テスト");
		user.setPassword("あいうえお");
		user.setTEL("08093733364");
		user.setAddress(null);
		user.setGender("男性");
		user.setAffiriation("アプリ");
		user.setDepartOfOrigin(null);
		user.setRole_ID(26);
		
		//登録データ更新
		/**System.out.println("===更新確認===");
		Authentication target = mapper.selectdetailById("hogehoge@example.jp");
		target.setUsername("リポジトリのテスト");
		target.setAccount_name("テスト");
		target.setPassword("あいうえお");
		target.setTEL("08093733364");
		target.setAddress(null);
		target.setGender("男性");
		target.setAffiriation("アプリ");
		target.setDepartOfOrigin(null);
		target.setRole_ID(1);*/
		
		//データ削除
		/**mapper.delete("fugafuga@example.jp");
		System.out.println("===削除確認===");
		for(Authentication row : mapper.selectAll()) {
			System.out.println(row);
		}*/
	}

}

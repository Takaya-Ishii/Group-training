package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.entity.Tra_Manegement;
import com.example.demo.repository.TraMapper;

import lombok.RequiredArgsConstructor;

@SpringBootApplication
@RequiredArgsConstructor
public class GroupTrainingApplication {

	public static void main(String[] args) {
		SpringApplication.run(GroupTrainingApplication.class, args)
		.getBean(GroupTrainingApplication.class).exe();
	}
	
	//DI
	private final TraMapper mapper;
	
	public void exe() {
		
		//全件検索
		System.out.println("====全件検索====");
		for (Tra_Manegement row : mapper.selectAll()) {
			System.out.println(row);
		}
		//1件検索
		System.out.println("====１件検索===");
		System.out.println(mapper.selectById("H0001"));
		
		//１件検索 名前
		System.out.println("=====１件検索 名前====");
		System.out.println(mapper.selectByName("Java研修"));
		
		//新規登録
		Tra_Manegement tra_Manegement = new Tra_Manegement();
		tra_Manegement.setTra_id("J0009");
		tra_Manegement.setTra_name("開発プロセス研修");
		tra_Manegement.setEst_time(600);
		tra_Manegement.setText_book("全てわかる開発プロセス");
		tra_Manegement.setAssignment("課題はなし");
		tra_Manegement.setDescription("説明なし");
		mapper.insert(tra_Manegement);
		System.out.println("=====新規登録確認=====");
		System.out.println(mapper.selectById("J0009"));
		
		//更新
		Tra_Manegement target = mapper.selectById("J0009");
		target.setTra_name("テスト");
		target.setEst_time(999);
		target.setText_book("テスト教科書");
		target.setAssignment("テスト課題");
		target.setDescription("テスト説明");
		mapper.update(target);
		System.out.println("======更新処理確認=======");
		System.out.println(mapper.selectById("J0009"));
		
		//削除
		System.out.println("=====削除処理確認=====");
		for (Tra_Manegement row : mapper.selectAll()) {
			System.out.println(row);
		}
	}
}

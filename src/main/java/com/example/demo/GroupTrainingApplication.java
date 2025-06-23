package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import lombok.RequiredArgsConstructor;

@SpringBootApplication
@RequiredArgsConstructor
public class GroupTrainingApplication {

	public static void main(String[] args) {
		SpringApplication.run(GroupTrainingApplication.class, args);
		//.getBean(GroupTrainingApplication.class).exe();
		
	}
	/*
	private final TraService service;
	
	public void exe() {
		System.out.println("=======1件検索======");
		System.out.println(service.selectByIdTra("H0001"));
	}*/
}
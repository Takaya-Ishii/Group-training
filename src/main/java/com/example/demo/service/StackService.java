package com.example.demo.service;

import com.example.demo.entity.Stack;

/**
 * 学習履歴：サービス
 */

public interface StackService {
	
	//指定された受講研修IDに紐づく研修名を検索
	Stack findTra_name(Integer traCourse_ID);
	
	//指定された受講研修IDを検索
	Stack findTraCourse_ID(Integer traCourse_ID);
	
	//指定された受講研修ID、履歴Noに対応する学習履歴を検索
	Stack findStack(Integer traCourse_ID, Integer stack_No);
	
	//学習履歴を新規登録
	void insertStack(Stack stack);
	
	//学習履歴を更新
	void updateStack(Stack stack);
	
	//学習履歴を削除
	void deleteStack(Integer traCourse_ID, Integer stack_No);
}

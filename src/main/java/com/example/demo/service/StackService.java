package com.example.demo.service;

import com.example.demo.entity.TraTpm;
import com.example.demo.entity.Trainfo;

/**
 * 学習履歴：サービス
 */

public interface StackService {
	
	//指定された受講研修IDに紐づく研修名を検索
	Trainfo findTra_name(Integer traCourse_ID);
	
	//指定された受講研修IDを検索
	TraTpm findTraCourse_ID(Integer traCourse_ID);
	
	//指定された受講研修ID、履歴Noに対応する学習履歴を検索
	TraTpm findStack(Integer traCourse_ID, Integer stack_No);
	
	//学習履歴を新規登録
	void insertStack(TraTpm stack);
	
	//学習履歴を更新
	void updateStack(TraTpm stack);
	
	//学習履歴を削除
	void deleteStack(Integer traCourse_ID, Integer stack_No);
}

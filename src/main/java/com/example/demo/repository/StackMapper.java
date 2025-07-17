package com.example.demo.repository;


import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.demo.entity.TraTpm;
import com.example.demo.entity.Trainfo;

/**
 * 学習履歴：リポジトリ
 */

@Mapper
public interface StackMapper {	
	//指定された研修名を取得
	Trainfo selectTra_name(@Param("traCourse_ID") Integer traCourse_ID);
	
	//指定された受講研修IDを取得
	TraTpm selectTraCourse_ID(@Param("traCourse_ID") Integer traCourse_ID);
	
	//指定された受講研修ID、履歴Noに対応する学習履歴を取得
	TraTpm selectStack(@Param("traCourse_ID") Integer traCourse_ID, @Param("stack_No") Integer stack_No);
	
	//学習履歴を登録
	void insert(TraTpm stack);
	
	//学習履歴を修正
	void update(TraTpm stack);
	
	//学習履歴を削除
	void delete(@Param("traCourse_ID") Integer traCourse_ID, @Param("stack_No") Integer stack_No);
}

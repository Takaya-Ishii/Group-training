package com.example.demo.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.demo.entity.Trainfo;

@Mapper
public interface TraMapper {

	//全ての研修を取得する。
	List<Trainfo> selectAll();
	
	//指定された研修IDに対応する研修を取得
	Trainfo selectById(@Param("tra_id") String tra_id);
	
	//指定された研修名に対応する研修を取得
	List<Trainfo> selectByName(@Param("tra_name") String tra_name);
	
	//研修を登録する
	void insert(Trainfo tra_Manegement);
	
	//研修を更新する
	void update(Trainfo tra_Manegement);
	
	//指定された研修IDに対応する研修を削除
	void delete(@Param("tra_id") String tra_id);
	
	//指定された研修IDに対応する研修名を取得
	List<Trainfo> selectTraName(@Param("tra_id") String tra_id);
	
	boolean existsById(@Param("tra_id") String tra_id);
}

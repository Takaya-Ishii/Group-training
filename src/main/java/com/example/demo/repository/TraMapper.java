package com.example.demo.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.demo.entity.Tra_Manegement;

@Mapper
public interface TraMapper {

	/*全ての研修を取得する。*/
	List<Tra_Manegement> selectAll();
	
	/*指定された研修IDに対応する研修を取得*/
	Tra_Manegement selectById(@Param("tra_id") String tra_id);
	
	/*指定された研修名に対応する研修を取得*/
	List<Tra_Manegement> selectByName(@Param("tra_name") String tra_name);
	
	/*研修を登録する*/
	void insert(Tra_Manegement tra_Manegement);
	
	/*研修を更新する*/
	void update(Tra_Manegement tra_Manegement);
	
	/*指定された研修IDに対応する研修を削除*/
	void delete(@Param("tra_id") String tra_id);
}

package com.example.webapp.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.webapp.entity.TrainingManegement;

@Mapper
public interface TraMapper {

	/*全ての研修を取得する。*/
	List<TrainingManegement> selectAll();
	
	/*指定された研修IDに対応する研修を取得*/
	TrainingManegement selectById(@Param("tra_ID") String tra_ID);
	/*指定された研修名に対応する研修を取得*/
	TrainingManegement selectById(@Param("tra_name") String tra_name);
	
	/*研修を登録する*/
	void insert(TrainingManegement trainingManegement);
	
	/*研修を更新する*/
	void update(TrainingManegement trainingManegement);
	
	/*指定された研修IDに対応する研修を削除*/
	void delete(@Param("tra_id") String tra_id);
}

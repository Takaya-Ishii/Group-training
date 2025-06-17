package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Tra_Manegement;

/**
 * 研修管理サービス
 * */
public interface TraService {

	List<Tra_Manegement> selectAllTra();
	
	Tra_Manegement selectByIdTra(String tra_id);
	
	Tra_Manegement selectByNameTra(String tra_name);
	
	void insertTra(Tra_Manegement tra_Manegement);
	
	void updateTra(Tra_Manegement tra_Manegement);
	
	void deleteTra(String tra_id);
}

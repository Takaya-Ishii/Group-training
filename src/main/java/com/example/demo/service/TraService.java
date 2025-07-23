package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Trainfo;

/**
 * 研修管理サービス
 * */
public interface TraService {

	List<Trainfo> selectAllTra();
	
	Trainfo selectByIdTra(String tra_id);
	
	List<Trainfo> selectByNameTra(String tra_name);
	
	void insertTra(Trainfo tra_Manegement);
	
	void updateTra(Trainfo tra_Manegement);
	
	void deleteTra(String tra_id);
	
	List<Trainfo> selectTraName(String tra_id);
	
	boolean existsByIdTra(String tra_id);
}

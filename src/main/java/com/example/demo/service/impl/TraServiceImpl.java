package com.example.demo.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.Trainfo;
import com.example.demo.repository.TraMapper;
import com.example.demo.service.TraService;

import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class TraServiceImpl implements TraService{

	
	private final TraMapper traMapper;
	
	@Override
	public List<Trainfo> selectAllTra(){
		return traMapper.selectAll();
	}

	@Override
	public Trainfo selectByIdTra(String tra_id) {
		// TODO 自動生成されたメソッド・スタブ
		return traMapper.selectById(tra_id);
	}

	@Override
	public List<Trainfo> selectByNameTra(String tra_name) {
		// TODO 自動生成されたメソッド・スタブ
		return traMapper.selectByName(tra_name);
	}

	@Override
	public void insertTra(Trainfo tra_Manegement) {
		// TODO 自動生成されたメソッド・スタブ
		traMapper.insert(tra_Manegement);
	}

	@Override
	public void updateTra(Trainfo tra_Manegement) {
		// TODO 自動生成されたメソッド・スタブ
		traMapper.update(tra_Manegement);
	}

	@Override
	public void deleteTra(String tra_id) {
		// TODO 自動生成されたメソッド・スタブ
		traMapper.delete(tra_id);
	}
	
	@Override
	public List<Trainfo> selectTraName(String tra_id) {
		return traMapper.selectTraName(tra_id);
	}
	
	@Override
	public boolean existsByIdTra(String tra_id) {
		return false;
	}
}

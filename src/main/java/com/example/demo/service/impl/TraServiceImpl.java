package com.example.demo.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.Tra_Manegement;
import com.example.demo.repository.TraMapper;
import com.example.demo.service.TraService;

import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class TraServiceImpl implements TraService{

	
	private final TraMapper traMapper;
	
	@Override
	public List<Tra_Manegement> selectAllTra(){
		return traMapper.selectAll();
	}

	@Override
	public Tra_Manegement selectByIdTra(String tra_id) {
		// TODO 自動生成されたメソッド・スタブ
		return traMapper.selectById(tra_id);
	}

	@Override
	public List<Tra_Manegement> selectByNameTra(String tra_name) {
		// TODO 自動生成されたメソッド・スタブ
		return traMapper.selectByName(tra_name);
	}

	@Override
	public void insertTra(Tra_Manegement tra_Manegement) {
		// TODO 自動生成されたメソッド・スタブ
		traMapper.insert(tra_Manegement);
	}

	@Override
	public void updateTra(Tra_Manegement tra_Manegement) {
		// TODO 自動生成されたメソッド・スタブ
		traMapper.update(tra_Manegement);
	}

	@Override
	public void deleteTra(String tra_id) {
		// TODO 自動生成されたメソッド・スタブ
		traMapper.delete(tra_id);
	}
}

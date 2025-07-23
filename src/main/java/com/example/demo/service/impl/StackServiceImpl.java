package com.example.demo.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.TraTpm;
import com.example.demo.entity.Trainfo;
import com.example.demo.repository.StackMapper;
import com.example.demo.service.StackService;

import lombok.RequiredArgsConstructor;

/**
 * 学習履歴:サービス実装クラス
 */

@Service
@Transactional
@RequiredArgsConstructor
public class StackServiceImpl implements StackService {
	
	/**DI*/
	private final StackMapper stackMapper;
	
	@Override
	public Trainfo findTra_name(Integer traCourse_ID) {
		return stackMapper.selectTra_name(traCourse_ID);
	}
	
	@Override
	public TraTpm findTraCourse_ID(Integer traCourse_ID) {
		return stackMapper.selectTraCourse_ID(traCourse_ID);
	}
	
	@Override
	public TraTpm findStack(Integer traCourse_ID, Integer stack_No) {
		return stackMapper.selectStack(traCourse_ID, stack_No);
	}
	
	@Override
	public void insertStack(TraTpm stack) {
		stackMapper.insert(stack);
	}
	
	@Override
	public void updateStack(TraTpm stack) {
		stackMapper.update(stack);
	}
	
	@Override
	public void deleteStack(Integer traCourse_ID, Integer stack_No) {
		stackMapper.delete(traCourse_ID, stack_No);
	}

}

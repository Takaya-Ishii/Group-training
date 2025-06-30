package com.example.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.repository.AuthenticationMapper;
import com.example.demo.service.GroupService;

public class GroupServiceImpl implements GroupService{
	
	@Autowired
	AuthenticationMapper authenticationMapper;
	
	@Override
	public String selectGroupByUsername(String username) {
		return authenticationMapper.selectGroupByUsername(username);
	}
}

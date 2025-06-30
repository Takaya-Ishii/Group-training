package com.example.demo.service;

import com.example.demo.entity.Group;

public interface GroupService {
	Group selectGroupByUsername(String username);
}

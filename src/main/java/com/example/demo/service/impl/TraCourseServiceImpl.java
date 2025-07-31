package com.example.demo.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.Status;
import com.example.demo.entity.TraCourse;
import com.example.demo.entity.TraCourseSave;
import com.example.demo.entity.TraTpm;
import com.example.demo.entity.User;
import com.example.demo.repository.TraCourseMapper;
import com.example.demo.service.TraCourseService;

import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class TraCourseServiceImpl implements TraCourseService {
	/**DI*/
	private final TraCourseMapper traCourseMapper;
	@Override
	public List<TraCourse> findTraCourses(String userName) {
		
		return traCourseMapper.selectTCourses(userName);
	}
	@Override
	public User findTraCoUser(String userName) {
		
		return traCourseMapper.selectTraCoUser(userName);
	}
	@Override
	public List<TraCourse> findTraCouForSave(String userName) {
	
		return traCourseMapper.selectTraCouForSave(userName);
	}
	@Override
	public void registNewTraCourse(TraCourseSave traCourse) {
		traCourseMapper.insertNewTracourse(traCourse);
		
	}
	@Override
	public void reSaveTraCourse(TraCourseSave traCourse) {
		traCourseMapper.updateTraCourse(traCourse);
	}
	@Override
	public TraCourse findTraCourse(Integer tracourse_id) {
		// TODO 自動生成されたメソッド・スタブ
		return traCourseMapper.selectCourseDetail(tracourse_id);
	}
	@Override
	public List<TraTpm> findTraCourseTpm(Integer tracourse_id) {
		// TODO 自動生成されたメソッド・スタブ
		return traCourseMapper.selectCourseLog(tracourse_id);
	}
	@Override
	public ArrayList<Status> findStatusAll() {
		return traCourseMapper.selectStatusAll();
	}
	@Override
	public void saveTraCoStatus(TraCourse traCourse) {
		traCourseMapper.updateTraCoStatus(traCourse);
	}
	@Override
	public void saveTpmStatus(TraCourse traCourse) {
		traCourseMapper.insertTpmStatus(traCourse);
	}

	
}

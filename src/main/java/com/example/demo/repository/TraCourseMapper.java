package com.example.demo.repository;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.entity.Status;
import com.example.demo.entity.TraCourse;
import com.example.demo.entity.TraCourseSave;
import com.example.demo.entity.TraTpm;
import com.example.demo.entity.User;

@Mapper
public interface TraCourseMapper {
	List<TraCourse> selectTCourses(String userName);
	
	User selectTraCoUser(String userName);
	
	List<TraCourse> selectTraCouForSave(String userName);
	
	void insertNewTracourse(TraCourseSave traCourse);
		
	void updateTraCourse(TraCourseSave traCourse);
	
	TraCourse selectCourseDetail(Integer tracourse_id);
	
	List<TraTpm> selectCourseLog(Integer tracourse_id);
	
	ArrayList<Status> selectStatusAll();
	
	void updateTraCoStatus(TraCourse traCourse);
	
	void insertTpmStatus(TraCourse traCourse);
}

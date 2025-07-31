package com.example.demo.service;


import java.util.ArrayList;
import java.util.List;

import com.example.demo.entity.Status;
import com.example.demo.entity.TraCourse;
import com.example.demo.entity.TraCourseSave;
import com.example.demo.entity.TraTpm;
import com.example.demo.entity.User;

public interface TraCourseService {
	//ユーザー（受講生）の受講研修一覧を取得
	List<TraCourse> findTraCourses(String userName);
	//表示する受講研修のユーザー情報を取得
	User findTraCoUser(String userName);
	
	//受講研修登録用の一覧を取得
	List<TraCourse> findTraCouForSave(String userName);
	
	//受講研修新規登録処理
	void registNewTraCourse(TraCourseSave traCourse);
	
	//受講研修更新処理
	void reSaveTraCourse(TraCourseSave traCourse);
	
	TraCourse findTraCourse(Integer tracourse_id);
	
	 List<TraTpm>  findTraCourseTpm(Integer tracourse_id);
	
	//受講研修詳細画面のステータス変更機能表示用
	ArrayList<Status> findStatusAll();
	
	//受講研修ステータス更新処理
	void saveTraCoStatus(TraCourse traCourse);
	
	//受講ステータス変更履歴登録処理
	void saveTpmStatus(TraCourse traCourse);
}

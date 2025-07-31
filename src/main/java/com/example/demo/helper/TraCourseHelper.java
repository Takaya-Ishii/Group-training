package com.example.demo.helper;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.example.demo.entity.TraCourse;
import com.example.demo.entity.TraCourseSave;
import com.example.demo.form.TraCourseSaveForm;
import com.example.demo.form.TraCourseSaveListForm;

import lombok.RequiredArgsConstructor;
@RequiredArgsConstructor
public class TraCourseHelper {
	
	/*
	 * TraCourseからTraCourseSaveFormへ変換
	 */
	public static ArrayList<TraCourseSaveForm> convertTraCourseSaveForm(List<TraCourse> traCourses) {

		ArrayList<TraCourseSaveForm> traCourseSaveForms = new ArrayList<TraCourseSaveForm>();
		for(TraCourse tCourse:traCourses) {
			TraCourseSaveForm form = new TraCourseSaveForm();
			form.setTra_id(tCourse.getTra_id());
			form.setTarget_date(tCourse.getTarget_date());
			form.setTracourse_id(tCourse.getTracourse_id());
			form.setTrainfo(tCourse.getTrainfo());
			form.setUsername(tCourse.getUsername());
			form.setIstakecourse(tCourse.isIstakecourse());
			traCourseSaveForms.add(form);
		}
		return traCourseSaveForms;
	}
	
	/*
	 * TraCourseSaveListFormからArrayList<TraCourseSave>へ変換
	 */
	public static ArrayList<TraCourseSave> convertTraCourseSaveList(TraCourseSaveListForm form){
		
		ArrayList<TraCourseSave> traCourseSaveList = new ArrayList<TraCourseSave>();
		for(TraCourseSaveForm sForm :form.getSaveList()) {
			TraCourseSave save = new TraCourseSave();
			//Target_dateがNullなら7日後をset
			if(sForm.getTarget_date()==null) { 
				save.setTarget_date(LocalDate.now().plusDays(7));
			}else {
				save.setTarget_date(sForm.getTarget_date());
			}
			save.setTracourse_id(sForm.getTracourse_id());
			save.setTra_id(sForm.getTra_id());
			save.setTrainfo(sForm.getTrainfo());
			save.setUsername(sForm.getUsername());
			save.setIstakecourse(sForm.isIstakecourse());
				
			traCourseSaveList.add(save);
		}
		return traCourseSaveList;
	
	}
	
	//登録情報を比較して、変更のメッセージを用意する
	public static ArrayList<String> traChangeCheck(ArrayList<TraCourseSave> saves,List<TraCourse> traCoSaveBefores){
		ArrayList<String> resultChange = new ArrayList<>();
		ArrayList<String> resultSet = new ArrayList<>();
		ArrayList<String> resultDel = new ArrayList<>();
		ArrayList<String> resultTim = new ArrayList<>();
		int checkNew = 0;
		//受講状況に変化ありかなしかの確認
		for(TraCourseSave save : saves) {
			for(TraCourse traCoSaveBefore:traCoSaveBefores) {
				//idが一致
				if(save.getTra_id().equals(traCoSaveBefore.getTra_id() )) {
					checkNew ++;
					//チェックなし→チェックになった研修
					if(save.isIstakecourse()  && !traCoSaveBefore.isIstakecourse()) {
						resultSet.add(traCoSaveBefore.getTrainfo().getTra_name()+"を受講研修登録しました。");
					//チェックあり→チェックになし研修
					}else if(!save.isIstakecourse()  && traCoSaveBefore.isIstakecourse()) {
						resultDel.add(traCoSaveBefore.getTrainfo().getTra_name()+"を受講研修解除しました。");
					//チェックあり→かつ目標期日変更している研修
					}else if(save.isIstakecourse()&&save.getTarget_date().compareTo(traCoSaveBefore.getTarget_date())!=0 ) {
						resultTim.add(traCoSaveBefore.getTrainfo().getTra_name()+"の目標期日を変更しました。");
					}					
				}
			}
			//新たに登録された研修でチェックされた場合
			if(checkNew == 0 && save.isIstakecourse()) {
				resultSet.add(save.getTrainfo().getTra_name()+"を受講研修登録しました。");
				checkNew = 0;
			} 
		}
		//リターン用のListのまとめる
		resultChange.addAll(resultSet);
		resultChange.addAll(resultDel);
		resultChange.addAll(resultTim);
		return resultChange;
	}
	
}

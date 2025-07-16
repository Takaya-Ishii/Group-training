package com.example.demo.helper;

import com.example.demo.entity.Stack;
import com.example.demo.form.StackForm;

/**
 * 学習履歴：ヘルパー
 */

public class StackHelper {
	
	/**
	 * Stackへの変換
	 */
	public static Stack convertStack(StackForm stackForm) {
		Stack stack = new Stack();
		stack.setStack_No(stackForm.getStackNo());
		stack.setTraCourse_ID(stackForm.getTraCourseID());
		stack.setTra_name(stackForm.getTraName());
		stack.setStudy_day(stackForm.getStudyDay());
		stack.setStudy_time(stackForm.getStudyTime());
		stack.setProgress(stackForm.getProgress());
		stack.setMemo(stackForm.getMemo());
		stack.setStatus_ID(stackForm.getStatusID());
		return stack;
	}
	
	/**
	 * StackFormへの変換
	 */
	public static StackForm converStackForm(Stack stack) {
		StackForm stackForm = new StackForm();
		stackForm.setStackNo(stack.getStack_No());
		stackForm.setTraCourseID(stack.getTraCourse_ID());
		stackForm.setTraName(stack.getTra_name());
		stackForm.setStudyDay(stack.getStudy_day());
		stackForm.setStudyTime(stack.getStudy_time());
		stackForm.setProgress(stack.getProgress());
		stackForm.setMemo(stack.getMemo());
		stackForm.setStatusID(stack.getStatus_ID());
		return stackForm;
	}
}
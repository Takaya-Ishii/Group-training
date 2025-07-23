package com.example.demo.helper;

import com.example.demo.entity.Trainfo;
import com.example.demo.form.TraForm;

public class TraHelper {

	public static Trainfo convertTra(TraForm form) {
		
		Trainfo tra_mane = new Trainfo();
		tra_mane.setTra_id(form.getTra_id());
		tra_mane.setTra_name(form.getTra_name());
		tra_mane.setEst_time(form.getEst_time());
		tra_mane.setText_book(form.getText_book());
		tra_mane.setDescription(form.getDescription());
		tra_mane.setAssignment(form.getAssignment());
		
		form.setIsNew(false);
		return tra_mane;
	}
	
	public static TraForm convertTraForm(Trainfo tra_mane) {
		
		TraForm form = new TraForm();
		form.setTra_id(tra_mane.getTra_id());
		form.setTra_name(tra_mane.getTra_name());
		form.setEst_time(tra_mane.getEst_time());
		form.setDescription(tra_mane.getDescription());
		form.setAssignment(tra_mane.getAssignment());
		
		form.setIsNew(false);
		return form;
	}
}

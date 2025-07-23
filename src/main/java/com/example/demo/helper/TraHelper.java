package com.example.demo.helper;

import com.example.demo.entity.Trainfo;
import com.example.demo.form.TraForm;

public class TraHelper {

	public static Trainfo convertTra(TraForm form) {
		
		Trainfo tra_mana = new Trainfo();
		tra_mana.setTra_id(form.getTra_id());
		tra_mana.setTra_name(form.getTra_name());
		tra_mana.setEst_time(form.getEst_time());
		tra_mana.setText_book(form.getText_book());
		tra_mana.setDescription(form.getDescription());
		tra_mana.setAssignment(form.getAssignment());
		
		form.setIsNew(false);
		return tra_mana;
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

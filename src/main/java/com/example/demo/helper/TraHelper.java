package com.example.demo.helper;

import com.example.demo.entity.Tra_Manegement;
import com.example.demo.form.TraForm;

public class TraHelper {

	public static Tra_Manegement convertTra(TraForm form) {
		
		Tra_Manegement tra_mane = new Tra_Manegement();
		tra_mane.setTra_id(form.getTra_id());
		tra_mane.setTra_name(form.getTra_name());
		tra_mane.setEst_time(form.getEst_time());
		tra_mane.setText_book(form.getText_book());
		tra_mane.setDescription(form.getDescription());
		tra_mane.setAssignment(form.getAssignment());
		
		form.setIsNew(false);
		return tra_mane;
	}
}

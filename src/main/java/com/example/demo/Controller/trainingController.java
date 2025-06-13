package com.example.demo.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.RequiredArgsConstructor;

/**
 * コントローラー
 * */
@Controller
@RequestMapping("/Training")
@RequiredArgsConstructor

public class trainingController {

	/**
	 * 一覧を表示させる
	 */
	@GetMapping
	public String list(Model model) {
		return null;
		
	}
}

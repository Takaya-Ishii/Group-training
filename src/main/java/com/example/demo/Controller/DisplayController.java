package com.example.demo.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 適宜、追加・編集をお願いいたします。
 */

@Controller
public class DisplayController {

	/**
	 * 受講研修一覧画面を表示します
	 */
	@GetMapping("traCourse")
    public String showTraCourse() {
        return "traCourse";
 }
}

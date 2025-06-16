package com.example.demo.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DisplayController {

	/**
	 * 受講一覧画面を表示します
	 */
	@GetMapping("traCourse")
    public String showTraCourse() {
        return "traCourse";
 }
}

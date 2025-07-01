package com.example.demo.Controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.entity.LoginUser;
import com.example.demo.form.LoginForm;

@Controller
@RequestMapping("")
public class LoginController {
	
	// ログイン画面の表示
	 @GetMapping("/login")
	    public String displayLogin(@ModelAttribute LoginForm form) {
	        return "login";
	 }
	 
	 // 所持ロールによって遷移先を判別
	 @GetMapping("/default")
	    public String defaultAfterLogin(Model model,@AuthenticationPrincipal LoginUser loginUser) {
		 //model.addAttribute("LoginUser", loginUser);   
		 if (loginUser.getAuthorities().stream()
	                .anyMatch(auth -> auth.getAuthority().equals("ROLE_講師"))) {
	            return "redirect:admin/User";
	        } else if (loginUser.getAuthorities().stream()
	                .anyMatch(auth -> auth.getAuthority().equals("ROLE_受講者"))) {
	            return "redirect:participant/traCourse";
	        }
	        return "redirect:/";
	    }
	 
	 /** 以下テスト用(受講者が講師専用画面に遷移できるか、講師が受講者の画面も表示できるか)
	 @GetMapping("/admin/User")
	 public String displayAllUser() {
		 return "admin/User";
	 }
	 
	 @GetMapping("/participant/traCourse")
	 public String displaytraCourse() {
		 return "participant/traCourse";
	 }*/
}

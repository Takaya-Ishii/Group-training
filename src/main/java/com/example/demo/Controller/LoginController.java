package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.entity.LoginUser;
import com.example.demo.form.LoginForm;
import com.example.demo.repository.AuthenticationMapper;

@Controller
@RequestMapping("")
public class LoginController {
	
	@Autowired
	AuthenticationMapper authenticationMapper;
	
	// ログイン画面の表示
	 @GetMapping("/login")
	    public String displayLogin(@ModelAttribute LoginForm form) {
	        return "login";
	 }
	 
	 // 所持ロールによって遷移先を判別
	 @GetMapping("/default")
	    public String defaultAfterLogin(Model model,  @AuthenticationPrincipal LoginUser loginUser) {   
		 if (loginUser.getAuthorities().stream()
	                .anyMatch(auth -> auth.getAuthority().equals("ROLE_講師"))) {
	            return "redirect:admin/User";
	        } else if (loginUser.getAuthorities().stream()
	                .anyMatch(auth -> auth.getAuthority().equals("ROLE_受講者"))) {
	            return "redirect:participant/traCourse/" + loginUser.getUsername();
	            }
	        return "redirect:/";
	    }
	 
	 // 以下テスト用(受講者が講師専用画面に遷移できるか、講師が受講者の画面も表示できるか)
	 @GetMapping("/admin/User")
	 public String displayAllUser(Model model, @AuthenticationPrincipal LoginUser loginUser) {
		 model.addAttribute("group", authenticationMapper.selectGroupByUsername(loginUser.getUsername()));
		 return "admin/User";
	 }
	 
	 // それぞれコントローラーと機能が競合したら削除する
	 @GetMapping("/participant/traCourse/{username}")
	 public String displaytraCourse(Model model, @AuthenticationPrincipal LoginUser loginUser) {
		 model.addAttribute("username", loginUser.getUsername());
		 model.addAttribute("group", authenticationMapper.selectGroupByUsername(loginUser.getUsername()));
		 return "participant/traCourse";
	 }
}

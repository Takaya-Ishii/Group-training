package com.example.demo.Controller;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.form.LoginForm;

@Controller
@RequestMapping("")
public class LoginController {
	
	 @GetMapping("/login")
	    public String displayLogin(@ModelAttribute LoginForm form) {
	        return "login";
	 }
	 
	 @GetMapping("/default")
	    public String defaultAfterLogin(Authentication authentication) {
	        if (authentication.getAuthorities().stream()
	                .anyMatch(auth -> auth.getAuthority().equals("ROLE_講師"))) {
	            return "redirect:/admin/User";
	        } else if (authentication.getAuthorities().stream()
	                .anyMatch(auth -> auth.getAuthority().equals("ROLE_受講者"))) {
	            return "redirect:/participant/traCourse";
	        }
	        return "redirect:/";
	    }
	 
	 @GetMapping("/admin/User")
	 public String displayAllUser() {
		 return "/admin/User";
	 }
	 
	 @GetMapping("/participant/traCourse")
	 public String displaytraCourse() {
		 return "/participant/traCourse";
	 }
}

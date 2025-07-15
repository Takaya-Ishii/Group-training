package com.example.demo.Controller;

import jakarta.servlet.http.HttpServletResponse;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.entity.LoginUser;

/**
 * エラー発生時用のコントローラ
 */

@Controller
@RequestMapping("/error")
public class CustomErrorController implements ErrorController{

	@GetMapping("")
    public String handleError(HttpServletResponse response, Model model, @AuthenticationPrincipal LoginUser loginUser)
    {
		//受講者がエラー画面に飛んだ際に、受講研修一覧に戻れるように
		model.addAttribute("errorUser", loginUser.getUsername());
		
		if (response.getStatus() == HttpStatus.NOT_FOUND.value()) {
            return "/error/404";
        }
        else if (response.getStatus() == HttpStatus.FORBIDDEN.value()) {
        	return "/error/403";
        }
        else if (response.getStatus() == HttpStatus.INTERNAL_SERVER_ERROR.value()) {
        	return "/error/500";
        }
        
        return "";
    }
 
    public String getErrorPath() {
        return "/error";
    }
}


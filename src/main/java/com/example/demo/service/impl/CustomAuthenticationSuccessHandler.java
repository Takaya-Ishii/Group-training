package com.example.demo.service.impl;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;


@Component
public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler{

	@Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                        Authentication authentication) throws IOException, ServletException {
        String redirectUrl = "/default";

        // ユーザーの権限に基づいて遷移先を設定
        if (authentication.getAuthorities().stream()
                .anyMatch(auth -> auth.getAuthority().equals("ROLE_講師"))) {
            redirectUrl = "/admin/User";
        } else if (authentication.getAuthorities().stream()
                .anyMatch(auth -> auth.getAuthority().equals("ROLE_受講者"))) {
            redirectUrl = "/participant/traCourse";
        }

        response.sendRedirect(redirectUrl);
    }
}


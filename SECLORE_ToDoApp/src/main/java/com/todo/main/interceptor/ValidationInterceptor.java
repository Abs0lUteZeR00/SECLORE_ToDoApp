package com.todo.main.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class ValidationInterceptor implements HandlerInterceptor {
	public ValidationInterceptor() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		HttpSession httpSession = request.getSession();
		String uri = request.getRequestURI();

		if (uri.equals("/") || uri.equals("/login") || uri.equals("/authenticate") || uri.equals("/register") || uri.equals("/signup")) {
			return true;
		}

		if (httpSession.getAttribute("user") == null) {
			httpSession.setAttribute("message", "Please Login First");
			response.sendRedirect("/");
			return false;
		}
		return true;
	}
}

package com.todo.main.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

// Interceptor to check session before every request 
public class ValidationInterceptor implements HandlerInterceptor {
	public ValidationInterceptor() {
		
	}

	// Is user Object is not present in session, then will be redirected to login page
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		HttpSession httpSession = request.getSession();
		String uri = request.getRequestURI();

		// Cannot access URI except these if not authenticated
		if (uri.equals("/") || uri.equals("/login") || uri.equals("/authenticate") || uri.equals("/register") || uri.equals("/signup") || uri.equals("/css/style1.css")) {
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

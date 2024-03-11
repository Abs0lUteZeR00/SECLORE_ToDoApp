package com.todo.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.todo.main.domain.UserDetails;
import com.todo.main.service.UserDetailsServiceInterface;

import jakarta.servlet.http.HttpSession;

@Controller
public class UserController {

	@Autowired
	private UserDetailsServiceInterface userDetailsService;

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String addUser(@ModelAttribute UserDetails userDetails, HttpSession httpSession) {
		if (userDetailsService.addUser(userDetails) != null)
			httpSession.setAttribute("message", "USER ADDED SUCCESSFULLY");
		else
			httpSession.setAttribute("message", "EMAIL ID ALREADY EXISTS");

		return "login";
	}

	@RequestMapping(value = "/authenticate", method = RequestMethod.POST)
	public String authenticateUser(@RequestParam String email, @RequestParam String password, HttpSession httpSession) {
		UserDetails userDetails = userDetailsService.validateUser(email, password);
		if (userDetails != null) {
			httpSession.setAttribute("message", ("Welcome " + userDetails.getName()));
			httpSession.setAttribute("user", userDetails);
			return "alltasks";
		}
		httpSession.setAttribute("message", "INVALID CREDENTIALS");
		return "login";
	}

}

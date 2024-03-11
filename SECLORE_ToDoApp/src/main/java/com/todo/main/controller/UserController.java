package com.todo.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.todo.main.domain.UserDetails;
import com.todo.main.service.UserDetailsServiceInterface;

@Controller
public class UserController {
	
	@Autowired
	private UserDetailsServiceInterface userDetailsService;
	
	@RequestMapping(value = "/register" , method = RequestMethod.POST)
	public String addUser(@ModelAttribute UserDetails userDetails) {
		return "login";
	}
}

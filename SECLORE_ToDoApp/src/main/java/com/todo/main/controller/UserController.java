package com.todo.main.controller;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.todo.main.domain.UserDetails;
import com.todo.main.service.UserDetailsServiceInterface;

import jakarta.servlet.http.HttpSession;

@Controller
public class UserController {
	public static final String salt = "$2a$10$GlxyI6KSW12HiqRulvE67u";

	@Autowired
	private UserDetailsServiceInterface userDetailsService;

	@RequestMapping(value = "/")
	public String loginPage() {
		return "login";
	}

	@RequestMapping(value = "/logout")
	public String logout(HttpSession httpSession) {
		httpSession.invalidate();
		return "login";
	}

	@RequestMapping(value = "/signup")
	public ModelAndView signUpPage() {
		ModelAndView modelAndView = new ModelAndView();
		UserDetails userDetails = new UserDetails();
		modelAndView.addObject("userDetails", userDetails);
		modelAndView.setViewName("signup");
		return modelAndView;
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String addUser(@ModelAttribute UserDetails userDetails, HttpSession httpSession) {
		String hashedPassword = BCrypt.hashpw(userDetails.getPassword(), salt);
		userDetails.setPassword(hashedPassword);
		if (userDetailsService.addUser(userDetails) != null)
			httpSession.setAttribute("message", "USER ADDED SUCCESSFULLY");
		else
			httpSession.setAttribute("message", "EMAIL ID ALREADY EXISTS");

		return "login";
	}

	@RequestMapping(value = "/authenticate", method = RequestMethod.POST)
	public String authenticateUser(@RequestParam String email, @RequestParam String password, HttpSession httpSession) {
		System.out.println(BCrypt.gensalt());
		String hashedPassword = BCrypt.hashpw(password, salt);
		System.out.println(hashedPassword +" "+ hashedPassword.length());
		UserDetails userDetails = userDetailsService.validateUser(email, hashedPassword);
		if (userDetails != null) {
			httpSession.setAttribute("message", ("Welcome " + userDetails.getName()));
			httpSession.setAttribute("user", userDetails);
			return "redirect:/todo/alltasks";
		}
		httpSession.setAttribute("message", "INVALID CREDENTIALS");
		return "login";
	}

}

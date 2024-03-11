package com.todo.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.todo.main.domain.TodoDetails;
import com.todo.main.domain.UserDetails;
import com.todo.main.service.TodoDetailsServiceInterface;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/todo")
public class TodoController {

	@Autowired
	private TodoDetailsServiceInterface todoDetailsService;

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String addTask(@ModelAttribute TodoDetails todoDetails, HttpSession httpSession) {
		UserDetails userDetails = (UserDetails) httpSession.getAttribute("user");
		todoDetails.setUserDetails(userDetails);
		if (todoDetailsService.addTodo(todoDetails) != null)
			httpSession.setAttribute("message", "TASK ADDED SUCCESSFULLY");
		else
			httpSession.setAttribute("message", "TASK NOT ADDED! \n TRY AGAIN");
		return "redirect:/todo/alltasks";
	}

	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public String deleteTask(@ModelAttribute TodoDetails todoDetails, HttpSession httpSession) {
		UserDetails userDetails = (UserDetails) httpSession.getAttribute("user");
		todoDetails.setUserDetails(userDetails);
		if (todoDetailsService.deleteTodo(todoDetails))
			httpSession.setAttribute("message", "TASK DELETED SUCCESSFULLY");
		else
			httpSession.setAttribute("message", "TASK NOT DELETED! \n TRY AGAIN");
		return "redirect:/todo/alltasks";
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String updateTask(@ModelAttribute TodoDetails todoDetails, HttpSession httpSession) {
		UserDetails userDetails = (UserDetails) httpSession.getAttribute("user");
		todoDetails.setUserDetails(userDetails);
		if (todoDetailsService.updateTodo(todoDetails) != null)
			httpSession.setAttribute("message", "TASK UPDATED SUCCESSFULLY");
		else
			httpSession.setAttribute("message", "TASK NOT UPDATED! \n TRY AGAIN");
		return "redirect:/todo/alltasks";
	}

	@RequestMapping(value = "/alltasks", method = RequestMethod.POST)
	public ModelAndView viewTodoList(HttpSession httpSession) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("todolist");
		UserDetails userDetails = (UserDetails) httpSession.getAttribute("user");
		List<TodoDetails> todoList = todoDetailsService.getTodoListByUserId(userDetails);

		if (todoList == null)
			httpSession.setAttribute("message", "You Don't Have Any Tasks in your Todo List");

		modelAndView.addObject("todoList", todoList);
		return modelAndView;

	}

}
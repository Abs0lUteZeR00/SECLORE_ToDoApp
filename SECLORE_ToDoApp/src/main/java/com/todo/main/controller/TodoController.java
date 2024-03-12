package com.todo.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.todo.main.domain.TodoDetails;
import com.todo.main.domain.UserDetails;
import com.todo.main.service.TodoDetailsServiceInterface;

import jakarta.servlet.http.HttpSession;

//Controller for Task Related Activities
@Controller
@RequestMapping("/todo")
public class TodoController implements ErrorController {

	@Autowired
	private TodoDetailsServiceInterface todoDetailsService;

	// If an authenticated user faces error, will be redirected /alltasks in same
	// controller
	@RequestMapping("/error")
	public String handleError() {
		return "redirect:/todo/alltasks";
	}

	// Redirects to addtask.jsp after adding a model attribute for mapping
	@RequestMapping("/addtask")
	public ModelAndView redirectAddTask() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("addtask");
		modelAndView.addObject("todoDetails", new TodoDetails());
		return modelAndView;
	}

	// Attempts to add a task in user's todo list and redirects to /alltasks in same
	// controller
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String addTask(@ModelAttribute TodoDetails todoDetails, HttpSession httpSession) {
		UserDetails userDetails = (UserDetails) httpSession.getAttribute("user");
		todoDetails.setUserDetails(userDetails);
		if (todoDetailsService.addTodo(todoDetails) != null)
			httpSession.setAttribute("notification", "TASK ADDED SUCCESSFULLY");
		else
			httpSession.setAttribute("notification", "TASK NOT ADDED! \n TRY AGAIN");
		return "redirect:/todo/alltasks";
	}

	// Delete's a task from user's todo list and redirects to /alltasks in same
	// controller
	@RequestMapping(value = "/delete")
	public String deleteTask(@ModelAttribute TodoDetails todoDetails, HttpSession httpSession) {
		UserDetails userDetails = (UserDetails) httpSession.getAttribute("user");
		todoDetails.setUserDetails(userDetails);
		if (todoDetailsService.deleteTodo(todoDetails))
			httpSession.setAttribute("notification", "TASK DELETED SUCCESSFULLY");
		else
			httpSession.setAttribute("notification", "TASK NOT DELETED! \n TRY AGAIN");
		return "redirect:/todo/alltasks";
	}

	// Attempts to update a task in user's todo list and redirects to /alltasks in
	// same controller
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String updateTask(@ModelAttribute TodoDetails todoDetails, HttpSession httpSession) {
		UserDetails userDetails = (UserDetails) httpSession.getAttribute("user");
		todoDetails.setUserDetails(userDetails);
		if (todoDetailsService.updateTodo(todoDetails) != null)
			httpSession.setAttribute("notification", "TASK UPDATED SUCCESSFULLY");
		else
			httpSession.setAttribute("notification", "TASK NOT UPDATED! \n TRY AGAIN");
		return "redirect:/todo/alltasks";
	}

	// Fetches the todo list of user from database, adds it in a model to display
	// and redirects to alltasks.jsp
	@RequestMapping(value = "/alltasks")
	public ModelAndView viewTodoList(HttpSession httpSession) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("alltasks");
		UserDetails userDetails = (UserDetails) httpSession.getAttribute("user");
		List<TodoDetails> todoList = todoDetailsService.getTodoListByUserId(userDetails);
		if (todoList == null || todoList.size() == 0)
			httpSession.setAttribute("message", "You Don't Have Any Tasks in your Todo List");
		else
			httpSession.setAttribute("message", null);
		modelAndView.addObject("todoList", todoList);
		modelAndView.addObject("todoDetails", new TodoDetails());
		return modelAndView;
	}

	// Adds Model attribute in a model of new ModelAndView Object
	// Forwards to /delete in same controller if user has selected delete in alltasks.jsp
	// Redirects to edittask.jsp if user has selected edit
	@RequestMapping(value = "/updatedelete", method = RequestMethod.POST)
	public ModelAndView redirectUpdateDelete(@ModelAttribute TodoDetails todoDetails, @RequestParam String submit) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("todoDetails", todoDetails);

		if (submit.equals("Delete"))
			modelAndView.setViewName("forward:/todo/delete");
		else
			modelAndView.setViewName("edittask");
		return modelAndView;
	}

}

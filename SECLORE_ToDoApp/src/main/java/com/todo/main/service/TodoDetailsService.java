package com.todo.main.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.todo.main.domain.TodoDetails;
import com.todo.main.domain.UserDetails;
import com.todo.main.repository.TodoDetailsRepositoryInterface;

@Service
public class TodoDetailsService implements TodoDetailsServiceInterface {

	@Autowired
	private TodoDetailsRepositoryInterface todoDetailsRepository;

	// Add a task to table todo_list for Logged In User
	@Override
	public TodoDetails addTodo(TodoDetails todoDetails) {
		return todoDetailsRepository.addTodo(todoDetails);
	}

	// Update the task selected by Logged In User in table todo_list 
	@Override
	public TodoDetails updateTodo(TodoDetails todoDetails) {
		return todoDetailsRepository.updateTodo(todoDetails);
	}

	// Delete the task selected by Logged In User from table todo_list 
	@Override
	public boolean deleteTodo(TodoDetails todoDetails) {
		return todoDetailsRepository.deleteTodo(todoDetails);
	}

	// Returns a list of all tasks from table todo_list mapped to Logged In User
	@Override
	public List<TodoDetails> getTodoListByUserId(UserDetails userDetails) {
		return todoDetailsRepository.getTodoListByUserId(userDetails);
	}

}

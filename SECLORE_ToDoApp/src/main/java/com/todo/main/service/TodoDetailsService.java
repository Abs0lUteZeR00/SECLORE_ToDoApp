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
	TodoDetailsRepositoryInterface todoDetailsRepository;

	@Override
	public TodoDetails addTodo(TodoDetails todoDetails) {
		return todoDetailsRepository.addTodo(todoDetails);
	}

	@Override
	public TodoDetails updateTodo(TodoDetails todoDetails) {
		return todoDetailsRepository.updateTodo(todoDetails);
	}

	@Override
	public boolean deleteTodo(TodoDetails todoDetails) {
		return todoDetailsRepository.deleteTodo(todoDetails);
	}

	@Override
	public List<TodoDetails> getTodoListByUserId(UserDetails userDetails) {
		return todoDetailsRepository.getTodoListByUserId(userDetails);
	}

}

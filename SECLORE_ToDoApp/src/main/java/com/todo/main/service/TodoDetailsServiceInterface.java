package com.todo.main.service;

import java.util.List;

import com.todo.main.domain.TodoDetails;
import com.todo.main.domain.UserDetails;

public interface TodoDetailsServiceInterface {
	public TodoDetails addTodo(TodoDetails todoDetails);
	public TodoDetails updateTodo(TodoDetails todoDetails);
	public boolean deleteTodo(TodoDetails todoDetails);
	public List<TodoDetails> getTodoListByUserId(UserDetails userDetails);
}

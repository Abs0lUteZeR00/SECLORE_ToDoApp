package com.todo.main.repository;

import java.util.List;

import com.todo.main.domain.TodoDetails;
import com.todo.main.domain.UserDetails;

public interface TodoDetailsRepositoryInterface {
	public TodoDetails addTodo(TodoDetails todoDetails);
	public TodoDetails updateTodo(TodoDetails todoDetails);
	public boolean deleteTodo(TodoDetails todoDetails);
	public List<TodoDetails> getTodoListByUserId(UserDetails userDetails);
}

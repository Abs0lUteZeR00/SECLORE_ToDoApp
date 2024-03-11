package com.todo.main.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.todo.main.domain.TodoDetails;
import com.todo.main.domain.UserDetails;

@Repository
public class TodoDetailsRepository implements TodoDetailsRepositoryInterface {
	private static final String ADD_TASK = "declare @task_id int\r\n"
			+ "set @task_id = (select MAX(task_id) from todo_list where user_id = 2)+1\r\n"
			+ "if @task_id is null set @task_id = 1\r\n" + "insert into todo_list values (@task_id, ?, ?, ?, ?)";
	private static final String UPDATE_TASK = "update todo_list set title = ?, description = ?,status =? where user_id = ? and task_id = ?";
	private static final String DELETE_TASK = "delete from todo_list where user_id = ? and task_id = ?";
	private static final String GET_TODO_LIST_BY_USER = "select * from todo_list where user_id = ?";

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public TodoDetails addTodo(TodoDetails todoDetails) {
		try {
			Object args[] = { todoDetails.getUserDetails().getUserId(), todoDetails.getTitle(),
					todoDetails.getDescription(), todoDetails.getStatus() };
			if (jdbcTemplate.update(ADD_TASK, args) > 0)
				return todoDetails;
			else
				return null;
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public TodoDetails updateTodo(TodoDetails todoDetails) {
		try {
			Object args[] = { todoDetails.getTitle(), todoDetails.getDescription(), todoDetails.getStatus(),
					todoDetails.getUserDetails().getUserId(), todoDetails.getTaskId() };
			if (jdbcTemplate.update(UPDATE_TASK, args) > 0)
				return todoDetails;
			return null;
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public boolean deleteTodo(TodoDetails todoDetails) {
		try {
			Object args[] = { todoDetails.getUserDetails().getUserId(), todoDetails.getTaskId() };
			if (jdbcTemplate.update(DELETE_TASK, args) > 0)
				return true;
			return false;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public List<TodoDetails> getTodoListByUserId(UserDetails userDetails) {
		try {
			List<TodoDetails> todoList = jdbcTemplate.query(GET_TODO_LIST_BY_USER, new TodoDetailsRowMapper(),
					userDetails.getUserId());
			return todoList;
		} catch (Exception e) {
			return null;
		}
	}

}

package com.todo.main.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.todo.main.domain.TodoDetails;
import com.todo.main.domain.UserDetails;

public class TodoDetailsRowMapper implements RowMapper<TodoDetails> {

	@Override
	public TodoDetails mapRow(ResultSet rs, int rowNum) throws SQLException {
		try {
			TodoDetails todoDetails = new TodoDetails();
			UserDetails userDetails = new UserDetails();
			todoDetails.setUserDetails(userDetails);
			todoDetails.setTaskId(rs.getInt("task_id"));
			todoDetails.getUserDetails().setUserId(rs.getInt("user_id"));
			todoDetails.setTitle(rs.getString("title"));
			todoDetails.setDescription(rs.getString("description"));
			todoDetails.setStatus(rs.getString("status"));
			return todoDetails;
		} catch (Exception e) {
			return null;
		}
	}

}

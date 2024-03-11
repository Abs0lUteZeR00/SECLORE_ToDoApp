package com.todo.main.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.todo.main.domain.UserDetails;

public class UserDetailsRowMapper implements RowMapper<UserDetails>{

	@Override
	public UserDetails mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		UserDetails userDetails=new UserDetails();
		userDetails.setUserId(rs.getInt("user_id"));
		userDetails.setEmail(rs.getString("email"));
		userDetails.setPassword(rs.getString("password"));
		userDetails.setName(rs.getString("name"));
		userDetails.setCountryCode(rs.getString("country_code"));
		userDetails.setPhoneNo(rs.getString("phone_no"));
		return userDetails;
	}
	
}

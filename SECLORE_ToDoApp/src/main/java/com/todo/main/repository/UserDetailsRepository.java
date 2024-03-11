package com.todo.main.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.todo.main.domain.UserDetails;

@Repository
public class UserDetailsRepository implements UserDetailsRepositoryInterface{
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	private static final String ADD_USER="INSERT INTO user_details (name, country_code, phone_no, email, password) VALUES (?,?,?,?,?)";
	
	public UserDetails addUser(UserDetails userDetails) {
		String name=userDetails.getName();
		String countryCode=userDetails.getCountryCode();
		String phoneNo=userDetails.getPhoneNo();
		String email=userDetails.getEmail();
		String password=userDetails.getPassword();
		try {
		KeyHolder keyHolder=new GeneratedKeyHolder();
		PreparedStatementCreator preparedStatementCreator=new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
				PreparedStatement ps=connection.prepareStatement(ADD_USER,new String[] {"user_id"});
				ps.setString(1, name);
				ps.setString(2, countryCode);
				ps.setString(3, phoneNo);
				ps.setString(4, email);
				ps.setString(5, password);
				return ps;
			}
		};
		int result=jdbcTemplate.update(preparedStatementCreator,keyHolder);
		if(result>0) {
			userDetails.setUserId(keyHolder.getKey().intValue());
			return userDetails;
		}
		
		}catch(Exception e) {
			return null;
		}
		return null; 
	}
		
}

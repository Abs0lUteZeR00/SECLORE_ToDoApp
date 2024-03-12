package com.todo.main.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.todo.main.domain.UserDetails;
import com.todo.main.repository.UserDetailsRepositoryInterface;

@Service
public class UserDetailsService implements UserDetailsServiceInterface{
	@Autowired
	UserDetailsRepositoryInterface userDetailsRepository;

	// Add user in user_details table
	@Override
	public UserDetails addUser(UserDetails userDetails) {
		return userDetailsRepository.addUser(userDetails);
	}

	// Check if a user with provided email and password exist
	@Override
	public UserDetails validateUser(String email, String password) {
		return userDetailsRepository.validateUser(email, password);
	}
	
}
 
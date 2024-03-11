package com.todo.main.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.todo.main.domain.UserDetails;
import com.todo.main.repository.UserDetailsRepositoryInterface;

@Service
public class UserDetailsService implements UserDetailsServiceInterface{
	@Autowired
	UserDetailsRepositoryInterface userDetailsRepository;

	@Override
	public UserDetails addUser(UserDetails userDetails) {
		// TODO Auto-generated method stub
		return userDetailsRepository.addUser(userDetails);
	}
	
}

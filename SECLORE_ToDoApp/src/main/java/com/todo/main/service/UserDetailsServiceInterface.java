package com.todo.main.service;

import com.todo.main.domain.UserDetails;

public interface UserDetailsServiceInterface {
	public UserDetails addUser(UserDetails userDetails);
	public UserDetails validateUser(String email, String password);
}

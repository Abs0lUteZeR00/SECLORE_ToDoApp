package com.todo.main.repository;

import com.todo.main.domain.UserDetails;

public interface UserDetailsRepositoryInterface {
	public UserDetails addUser(UserDetails userDetails);
	public UserDetails validateUser(String email, String password);
}
 
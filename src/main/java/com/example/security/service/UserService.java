package com.example.security.service;

import com.example.security.domain.User;

public interface UserService {

	public User findByEmail(String email);
		
	
}

package com.example.security.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.security.domain.User;

public interface UserRepository extends CrudRepository<User, Long> {
	
	User findByEmail(String email);	
}

package com.jwt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jwt.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	
	
	public User findByUsername(String username);

}

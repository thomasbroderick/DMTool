package com.skilldistillery.dmtool.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skilldistillery.dmtool.entities.User;

public interface UserRepository extends JpaRepository<User, Integer>{
	
	public User findOneByUsername(String username);
		

}
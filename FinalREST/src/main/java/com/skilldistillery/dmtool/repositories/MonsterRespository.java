package com.skilldistillery.dmtool.repositories;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skilldistillery.dmtool.entities.Monster;

public interface MonsterRespository extends JpaRepository<Monster, Integer>{
	public Set<Monster> findByUser_Email(String email);
	

}
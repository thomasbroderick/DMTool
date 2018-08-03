package com.skilldistillery.dmtool.repositories;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skilldistillery.dmtool.entities.Item;

public interface ItemRepository extends JpaRepository<Item, Integer>{
	public Set<Item> findByUser_Username(String username);
	

}
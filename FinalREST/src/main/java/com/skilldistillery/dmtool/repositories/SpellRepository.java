package com.skilldistillery.dmtool.repositories;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skilldistillery.dmtool.entities.Spell;

public interface SpellRepository extends JpaRepository<Spell, Integer>{
	public Set<Spell> findByUser_Username(String username);
	public Spell findByName(String name);
	

}
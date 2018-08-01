package com.skilldistillery.dmtool.repositories;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skilldistillery.dmtool.entities.PlayerNote;

public interface PlayerNoteRepository extends JpaRepository<PlayerNote, Integer>{
	public Set<PlayerNote> findByPlayer_Id(int id);
	

}
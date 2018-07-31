package com.skilldistillery.dmtool.repositories;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skilldistillery.dmtool.entities.Player;

public interface PlayerRepository extends JpaRepository<Player, Integer>{
	public Set<Player> findByCampaign_Id(int id);
	

}
package com.skilldistillery.dmtool.repositories;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skilldistillery.dmtool.entities.Npc;

public interface NpcRepository extends JpaRepository<Npc, Integer>{
	public Set<Npc> findByCampaign_Id(int id);
	

}
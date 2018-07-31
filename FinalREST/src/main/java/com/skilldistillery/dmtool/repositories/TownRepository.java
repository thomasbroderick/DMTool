package com.skilldistillery.dmtool.repositories;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skilldistillery.dmtool.entities.Town;

public interface TownRepository extends JpaRepository<Town, Integer>{
	public Set<Town> findByCampaign_Id(int id);
	

}
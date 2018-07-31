package com.skilldistillery.dmtool.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skilldistillery.dmtool.entities.Campaign;

public interface CampaignRepository extends JpaRepository<Campaign, Integer>{
	
	

}

package com.skilldistillery.dmtool.repositories;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skilldistillery.dmtool.entities.Campaign;

public interface CampaignRepository extends JpaRepository<Campaign, Integer>{
	
	public Set<Campaign> findByUser_Username(String username);
	public Campaign findOneById(int cid);

}

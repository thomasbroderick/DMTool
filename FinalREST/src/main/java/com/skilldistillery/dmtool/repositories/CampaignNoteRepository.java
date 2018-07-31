package com.skilldistillery.dmtool.repositories;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skilldistillery.dmtool.entities.CampaignNote;

public interface CampaignNoteRepository extends JpaRepository<CampaignNote, Integer>{
	
	public Set<CampaignNote> findByCampaign_Id(int id);

}
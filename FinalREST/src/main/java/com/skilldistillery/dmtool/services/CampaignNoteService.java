package com.skilldistillery.dmtool.services;

import java.util.Set;

import com.skilldistillery.dmtool.entities.CampaignNote;

public interface CampaignNoteService {
	
	  public Set<CampaignNote> index(String username);

	  public CampaignNote show(String username, int cid);

	  public CampaignNote create(String username, CampaignNote campaignNote);

	  public CampaignNote update(String username, int cid, CampaignNote campaignNote);

	  public void destroy(String username, int cid);

}

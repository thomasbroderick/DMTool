package com.skilldistillery.dmtool.services;

import java.util.Set;

import com.skilldistillery.dmtool.entities.CampaignNote;

public interface CampaignNoteService {
	
	  public Set<CampaignNote> index(int id);

	  public CampaignNote show(int nid);

	  public CampaignNote create(int campId, CampaignNote campaignNote);

	  public CampaignNote update(int campId, int noteId, CampaignNote campaignNote);

	  public void destroy(int cid);

}

package com.skilldistillery.dmtool.services;

import java.util.Set;

import com.skilldistillery.dmtool.entities.Campaign;

public interface CampaignService {
	  public Set<Campaign> index(String username);

	  public Campaign show(String username, int cid);

	  public Campaign create(String username, Campaign campaign);

	  public Campaign update(String username, int cid, Campaign campaign);

	  public void destroy(String username, int cid);

}

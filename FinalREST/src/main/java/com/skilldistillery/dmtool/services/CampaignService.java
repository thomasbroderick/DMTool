package com.skilldistillery.dmtool.services;

import java.util.Set;

import com.skilldistillery.dmtool.entities.Campaign;

public interface CampaignService {
	  public Set<Campaign> index(String email);

	  public Campaign show(int cid);

	  public Campaign create(String email, Campaign campaign);

	  public Campaign update(int cid, Campaign campaign);

	  public void destroy(int cid);

}

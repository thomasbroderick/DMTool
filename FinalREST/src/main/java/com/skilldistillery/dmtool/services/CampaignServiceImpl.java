package com.skilldistillery.dmtool.services;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.dmtool.entities.Campaign;
import com.skilldistillery.dmtool.repositories.CampaignRepository;
import com.skilldistillery.dmtool.repositories.UserRepository;
@Service
public class CampaignServiceImpl implements CampaignService {

	@Autowired
	private UserRepository userRepo;
	@Autowired
	private CampaignRepository campRepo;

	@Override
	public Set<Campaign> index(String email) {
		return (Set<Campaign>) campRepo.findByUser_Email(email);
	}

	@Override
	public Campaign show(int cid) {
		return campRepo.findById(cid).get();
	}

	@Override
	public Campaign create(String email, Campaign campaign) {
		campaign.setUser(userRepo.findOneByEmail(email));
		return campRepo.saveAndFlush(campaign);
	}

	@Override
	public Campaign update(String email, int cid, Campaign campaign) {
		campaign.setUser(userRepo.findOneByEmail(email));
		campaign.setId(cid);
		return campRepo.saveAndFlush(campaign);
	}

	@Override
	public void destroy(int cid) {
		campRepo.deleteById(cid);

	}

}

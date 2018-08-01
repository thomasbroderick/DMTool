package com.skilldistillery.dmtool.services;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.dmtool.entities.Town;
import com.skilldistillery.dmtool.repositories.CampaignRepository;
import com.skilldistillery.dmtool.repositories.TownRepository;
@Service
public class TownServiceImpl implements TownService {
	@Autowired
	private TownRepository townRepo;
	@Autowired
	private CampaignRepository campRepo;

	@Override
	public Set<Town> index(int cid) {
		return (Set<Town>) townRepo.findByCampaign_Id(cid);
	}

	@Override
	public Town show(int tid) {
		return townRepo.findById(tid).get();
	}

	@Override
	public Town create(int cid, Town town) {
		town.setCampaign(campRepo.findOneById(cid));
		return townRepo.saveAndFlush(town);
	}

	@Override
	public Town update(int cid, int tid, Town town) {
		town.setCampaign(campRepo.findOneById(cid));
		town.setId(tid);
		return townRepo.saveAndFlush(town);
	}

	@Override
	public void destroy(int tid) {
		townRepo.deleteById(tid);
	}

}

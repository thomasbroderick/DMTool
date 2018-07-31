package com.skilldistillery.dmtool.services;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;

import com.skilldistillery.dmtool.entities.CampaignNote;
import com.skilldistillery.dmtool.repositories.CampaignNoteRepository;
import com.skilldistillery.dmtool.repositories.CampaignRepository;


public class CampaignNoteServiceImpl implements CampaignNoteService {

	@Autowired
	private CampaignNoteRepository campNoteRepo;
	@Autowired
	private CampaignRepository campRepo;
	@Override
	public Set<CampaignNote> index(int id) {

		return (Set<CampaignNote>) campNoteRepo.findByCampaign_Id(id);
	}

	@Override
	public CampaignNote show(int nid) {		
		return campNoteRepo.findById(nid).get();
	}

	@Override
	public CampaignNote create(int campId, CampaignNote campaignNote) {
		campaignNote.setCampaign(campRepo.findById(campId).get());
		return campNoteRepo.saveAndFlush(campaignNote);
	}

	@Override
	public CampaignNote update(int noteId, CampaignNote campaignNote) {
		campaignNote.setId(noteId);
		return campNoteRepo.saveAndFlush(campaignNote);
		
	}

	@Override
	public void destroy(int cid) {
		campNoteRepo.deleteById(cid);
		
	}

}

package com.skilldistillery.dmtool.client;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.skilldistillery.dmtool.entities.CampaignNote;

public class CampaignNoteClient {
	
	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("DMTool");
		EntityManager em = emf.createEntityManager();

		CampaignNote campaignNote = em.find(CampaignNote.class, 1);

		System.out.println(campaignNote);

		em.close();
		emf.close();
		
		
	}

}

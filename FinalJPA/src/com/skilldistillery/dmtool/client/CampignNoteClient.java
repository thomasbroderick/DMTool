package com.skilldistillery.dmtool.client;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.skilldistillery.dmtool.entities.Campaign;

public class CampaignNote {
	
	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("DMTool");
		EntityManager em = emf.createEntityManager();

		CampignNote campignNote = em.find(Campaign.class, 1);

		System.out.println(campaign);

		em.close();
		emf.close();
		
		
	}

}

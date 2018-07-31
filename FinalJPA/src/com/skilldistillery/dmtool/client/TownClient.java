package com.skilldistillery.dmtool.client;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.skilldistillery.dmtool.entities.Town;

public class TownClient {
	
	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("DMTool");
		EntityManager em = emf.createEntityManager();

		Town town = em.find(Town.class, 1);

		System.out.println(town);

		em.close();
		emf.close();
		
		
	}

}

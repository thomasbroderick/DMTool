package com.skilldistillery.dmtool.client;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.skilldistillery.dmtool.entities.Npc;

public class NpcClient {
	
	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("DMTool");
		EntityManager em = emf.createEntityManager();

		Npc npc = em.find(Npc.class, 1);

		System.out.println(npc);

		em.close();
		emf.close();
		
		
	}

}

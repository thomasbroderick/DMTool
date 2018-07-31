package com.skilldistillery.dmtool.client;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.skilldistillery.dmtool.entities.PlayerNote;

public class PlayerNoteClient {
	
	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("DMTool");
		EntityManager em = emf.createEntityManager();

		PlayerNote playerNote = em.find(PlayerNote.class, 1);

		System.out.println(playerNote);

		em.close();
		emf.close();
		
		
	}

}

package com.skilldistillery.dmtool.client;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.skilldistillery.dmtool.entities.Spell;

public class SpellClient {
	
	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("DMTool");
		EntityManager em = emf.createEntityManager();

		Spell spell = em.find(Spell.class, 1);

		System.out.println(spell);

		em.close();
		emf.close();
		
		
	}

}

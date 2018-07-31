package com.skilldistillery.dmtool.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.skilldistillery.dmtool.entities.Spell;

class SpellTests {
	private static EntityManagerFactory emf;
	private EntityManager em;
	private Spell s;
	
	
	@BeforeAll
	public static void setUpAll() throws Exception {
		emf = Persistence.createEntityManagerFactory("DMTool");

	}

	@BeforeEach
	public void setUp() throws Exception {
		em = emf.createEntityManager();
		s = em.find(Spell.class, 1);
	}

	@AfterEach
	public void tearDown() throws Exception {
		em.close();
		s = null;
	}

	@AfterAll
	public static void tearDownAll() throws Exception {
		emf.close();

	}
	
	@Test
	void test_spell_mapping() {
		assertEquals("Test Spell", s.getName());
	}
	
	@Test
	void test_spell_mapping_to_user() {
		assertEquals("standard@standard.com", s.getUser().getEmail());
	}
	
	

}
